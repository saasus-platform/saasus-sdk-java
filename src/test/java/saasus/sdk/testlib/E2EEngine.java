package saasus.sdk.testlib;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Core engine that executes stories against a {@link MethodRegistry}.
 *
 * <p>Supports dry-run, per-story timeout, retry with linear backoff (on network errors,
 * timeouts, HTTP 429 and 5xx), fail-fast, coverage tracking and reporting. Cleanup runs
 * even when steps fail.
 */
public class E2EEngine {

    private final MethodRegistry registry;
    private final Config config;
    private final Logger logger;
    private final CoverageTracker coverage;
    private final Reporter reporter;
    private final MethodExecutor executor;
    private final List<StoryObserver> observers = new ArrayList<StoryObserver>();

    public E2EEngine(MethodRegistry registry, Config config) {
        this(registry, config, null);
    }

    public E2EEngine(MethodRegistry registry, Config config, ApiErrorExtractor errorExtractor) {
        this.registry = registry;
        this.config = config != null ? config : new Config();
        this.logger = new Logger(this.config.logLevel);
        List<String> keys = registry != null ? registry.coverageKeys() : Collections.<String>emptyList();
        this.coverage = new CoverageTracker(keys, logger);
        this.reporter = new Reporter(coverage);
        long asyncTimeout = this.config.timeout > 0 ? this.config.timeout * 1000L : 300_000L;
        this.executor = new MethodExecutor(registry, logger, this.config.dryRun, errorExtractor, asyncTimeout);
    }

    public E2EEngine addObserver(StoryObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
        return this;
    }

    public Config config() {
        return config;
    }

    public Logger logger() {
        return logger;
    }

    public CoverageTracker coverage() {
        return coverage;
    }

    public Reporter reporter() {
        return reporter;
    }

    // ---- execution ------------------------------------------------------------

    public List<StoryResult> executeStories(List<Story> stories) {
        List<StoryResult> results = new ArrayList<StoryResult>();
        logger.info("Starting E2E test execution (" + stories.size() + " stories)");

        for (Story story : stories) {
            if (config.dryRun) {
                logger.info("DRY RUN: would execute story '" + story.name() + "'");
                recordDryRunCoverage(story);
                continue;
            }

            StoryResult result = executeStory(story);
            results.add(result);

            if (!result.isSuccess() && config.failFast) {
                logger.warn("Fail-fast enabled; stopping after story '" + story.name() + "'");
                break;
            }
        }
        return results;
    }

    /**
     * Records coverage for every step in a story without invoking any SDK call. Skipped steps are
     * included: coverage tracks that a {@code (method, style)} pair is <em>present</em> in a story
     * (mirroring the Go reference's static {@code VerifyMethodCoverage}), so environment-gated skips
     * (e.g. Stripe steps without {@code STRIPE_SECRET_KEY}) do not reduce reported coverage.
     */
    private void recordDryRunCoverage(Story story) {
        for (Step step : story.steps()) {
            if (step.skip()) {
                coverage.recordPresence(step.method(), step.callStyle());
            } else {
                coverage.recordExecution(step.method(), step.callStyle(), story.name(),
                        step.name(), 200, 0, true, null);
            }
        }
    }

    /**
     * Invokes attached observers for a finished story and, if any requests failure (e.g. a
     * breaking snapshot change with {@code failOnBreaking}), marks the story failed while
     * preserving an earlier failure.
     */
    private StoryResult notifyObservers(Story story, StoryResult result) {
        boolean observerRequestedFailure = false;
        for (StoryObserver observer : observers) {
            try {
                if (observer.onStoryFinished(story, result)) {
                    observerRequestedFailure = true;
                }
            } catch (Throwable t) {
                logger.error("Story observer failed", t);
            }
        }
        if (observerRequestedFailure && result.isSuccess()) {
            result = result.asFailed(new RuntimeException(
                    "breaking snapshot changes detected for story '" + story.name() + "'"));
        }
        return result;
    }

    public StoryResult executeStory(Story story) {
        // Honor dry-run on the single-story path too: skip setup/steps/cleanup (which can make
        // real SDK calls / mutate resources) and only record coverage.
        if (config.dryRun) {
            logger.info("DRY RUN: would execute story '" + story.name() + "'");
            recordDryRunCoverage(story);
            return new StoryResult(story.name(), TestStatus.PASSED, 0,
                    new ArrayList<StepResult>(), null,
                    new LinkedHashMap<String, Object>(story.initialVariables()));
        }
        // Observers must run for both public execution paths (executeStories and executeStory).
        return notifyObservers(story, runStory(story));
    }

    private StoryResult runStory(Story story) {
        long start = System.currentTimeMillis();
        logger.logStoryStart(story.name());

        Map<String, Object> variables = new LinkedHashMap<String, Object>(story.initialVariables());
        List<StepResult> stepResults = new ArrayList<StepResult>();
        TestStatus status = TestStatus.PASSED;
        Throwable storyError = null;

        long timeoutSeconds = story.timeoutSeconds() > 0 ? story.timeoutSeconds() : config.timeout;
        long deadline = timeoutSeconds > 0 ? start + timeoutSeconds * 1000L : Long.MAX_VALUE;

        try {
            boolean setupFailed = false;
            if (story.setup() != null) {
                long setupBudget = deadline - System.currentTimeMillis();
                Throwable setupError = runLifecycleWithTimeout(story.setup(), variables, setupBudget,
                        "setup", story.name());
                if (setupError != null) {
                    logger.error("Setup failed for story '" + story.name() + "'", setupError);
                    status = TestStatus.FAILED;
                    storyError = new RuntimeException("setup failed: " + setupError.getMessage(), setupError);
                    setupFailed = true;
                }
            }

            for (int i = 0; !setupFailed && i < story.steps().size(); i++) {
                Step step = story.steps().get(i);
                long remaining = deadline - System.currentTimeMillis();
                if (remaining <= 0) {
                    StepResult timedOut = new StepResult(step.name(), step.method(), step.callStyle(),
                            TestStatus.FAILED, 0, null, null, null,
                            new TimeoutException("story '" + story.name() + "' exceeded timeout"), null);
                    stepResults.add(timedOut);
                    // The invoker never ran, so this (method, style) pair must not be counted
                    // as covered; only record it in the step results for reporting.
                    status = TestStatus.FAILED;
                    storyError = timedOut.error;
                    break;
                }

                StepResult result = executeStep(story, step, i + 1, variables, remaining);
                stepResults.add(result);
                recordCoverage(story, result);

                if (result.status == TestStatus.FAILED) {
                    status = TestStatus.FAILED;
                    storyError = result.error;
                    break;
                }
            }
        } finally {
            if (story.cleanup() != null) {
                // Cleanup gets a fresh budget (it must still run even if steps timed out),
                // but is bounded so a hanging cleanup cannot block the suite indefinitely.
                long cleanupBudget = timeoutSeconds > 0 ? timeoutSeconds * 1000L : 0;
                Throwable cleanupError;
                if (cleanupBudget > 0) {
                    cleanupError = runLifecycleWithTimeout(story.cleanup(), variables, cleanupBudget,
                            "cleanup", story.name());
                } else {
                    try {
                        story.cleanup().run(variables);
                        cleanupError = null;
                    } catch (Throwable e) {
                        cleanupError = e;
                    }
                }
                if (cleanupError != null) {
                    logger.error("Cleanup failed for story '" + story.name() + "'", cleanupError);
                    // Cleanup failure fails the story, but never masks an earlier step/setup failure.
                    if (status == TestStatus.PASSED) {
                        status = TestStatus.FAILED;
                        storyError = new RuntimeException(
                                "cleanup failed: " + cleanupError.getMessage(), cleanupError);
                    }
                }
            }
        }

        return finish(story, status, start, stepResults, storyError, variables);
    }

    private StepResult executeStep(Story story, Step step, int number,
                                   Map<String, Object> variables, long timeoutMillis) {
        logger.logStepStart(number, step.name(), step.method());

        if (step.skip()) {
            // A skipped step still counts as covered (the (method, style) pair is present in the
            // story, matching the Go reference's static coverage), but records no execution so
            // success rates and execution counts are not inflated by non-executed calls.
            coverage.recordPresence(step.method(), step.callStyle());
            StepResult skipped = new StepResult(step.name(), step.method(), step.callStyle(),
                    TestStatus.SKIPPED, 0, null, null, null, null, step.skipReason());
            logger.logStepResult(step.name(), step.method(), TestStatus.SKIPPED, 0, 0);
            return skipped;
        }

        Map<String, Object> callVars = mergeInputs(variables, step.inputs());

        long start = System.currentTimeMillis();
        ExecutionResult exec = null;
        int attempt = 0;
        while (true) {
            long remaining = timeoutMillis - (System.currentTimeMillis() - start);
            if (remaining <= 0) {
                exec = ExecutionResult.failure(new TimeoutException("step '" + step.name() + "' timed out"));
                break;
            }
            exec = executeWithTimeout(step, callVars, remaining);
            boolean expectedStatus = exec.statusCode != null && exec.statusCode != 0
                    && isExpectedStatus(exec.statusCode, step.expectedStatus(), step.allowedStatuses());
            // Note: a successful call that nonetheless reports a retriable status (429/5xx) and
            // is not explicitly accepted should still be retried, so success alone is not a
            // reason to stop — isRetriable() decides based on the observed status.
            if (expectedStatus || !isRetriable(exec) || attempt >= config.maxRetries) {
                break;
            }
            attempt++;
            logger.warn("Step '" + step.name() + "' failed (retriable). Retrying " + attempt + "/" + config.maxRetries);
            long remainingBudget = timeoutMillis - (System.currentTimeMillis() - start);
            if (remainingBudget <= 0) {
                break;
            }
            sleep(Math.min(1000L * attempt, remainingBudget));
        }

        long duration = System.currentTimeMillis() - start;
        Integer statusCode = exec.statusCode;
        Throwable error = exec.error;
        TestStatus status;
        Object responseValue = exec.response;

        // A recognized API error whose observed status is explicitly expected or allowed
        // (e.g. a documented 404) is a valid outcome, not a failure. Generated clients
        // surface non-2xx responses as exceptions, so this is checked before failing.
        // Only intentional non-2xx statuses qualify: a failure carrying a 2xx status is a
        // response-processing error (e.g. deserialization), which must still fail the step.
        boolean acceptedApiError = error != null
                && statusCode != null && statusCode != 0
                && (statusCode < 200 || statusCode >= 300)
                && isExpectedStatus(statusCode, step.expectedStatus(), step.allowedStatuses());

        if (error != null && !acceptedApiError) {
            status = TestStatus.FAILED;
            logger.error("Step '" + step.name() + "' failed", error);
        } else {
            // Success, or an accepted API-error outcome: run the same validation / state-update
            // hooks so accepted errors are held to the same assertions as any other pass.
            if (acceptedApiError) {
                error = null;
            }
            // For accepted API errors the deserialized response is null, but the extracted
            // error body is available; expose it so validation / state-update hooks can inspect it,
            // and record it as the step's response so snapshot capture / consumers keep it too.
            Object hookResponse = exec.response != null ? exec.response : exec.body;
            responseValue = hookResponse;
            try {
                StatusValidator.validate(statusCode, step.expectedStatus(), step.allowedStatuses(),
                        step.name(), step.method());
                if (step.validation() != null) {
                    step.validation().validate(hookResponse);
                    logger.logValidation(step.name(), true, "validation passed");
                }
                if (step.stateUpdate() != null) {
                    step.stateUpdate().update(hookResponse, variables);
                    logger.logStateUpdate(step.name(), variables);
                }
                status = TestStatus.PASSED;
            } catch (Throwable e) {
                status = TestStatus.FAILED;
                error = e;
                logger.error("Step '" + step.name() + "' validation failed", e);
            }
        }

        StepResult result = new StepResult(step.name(), step.method(), step.callStyle(), status,
                duration, statusCode, exec.headers, responseValue, error, null);
        logger.logStepResult(step.name(), step.method(), status, statusCode == null ? 0 : statusCode, duration);
        return result;
    }

    /**
     * Runs a story {@link LifecycleAction} (setup) on a worker thread bounded by
     * {@code timeoutMillis}, so a blocking setup cannot exceed the per-story timeout.
     *
     * @return {@code null} on success, otherwise the failure (or a {@link TimeoutException}).
     */
    private Throwable runLifecycleWithTimeout(final LifecycleAction action, final Map<String, Object> variables,
                                              long timeoutMillis, String phase, String storyName) {
        if (timeoutMillis <= 0) {
            return new TimeoutException(phase + " for story '" + storyName + "' exceeded timeout");
        }
        ExecutorService pool = newDaemonExecutor();
        try {
            Future<?> future = pool.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    action.run(variables);
                    return null;
                }
            });
            try {
                future.get(timeoutMillis, TimeUnit.MILLISECONDS);
                return null;
            } catch (TimeoutException e) {
                future.cancel(true);
                return new TimeoutException(phase + " for story '" + storyName
                        + "' timed out after " + timeoutMillis + "ms");
            } catch (ExecutionException e) {
                return e.getCause() != null ? e.getCause() : e;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return e;
            }
        } finally {
            pool.shutdownNow();
        }
    }

    /**
     * Single-thread executor backed by a daemon thread. A daemon worker cannot keep the
     * test JVM alive, so even if an underlying (uncancellable) blocking SDK call outlives
     * its timeout, it will not prevent the suite from exiting.
     */
    private static ExecutorService newDaemonExecutor() {
        return Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "e2e-testlib-worker");
                t.setDaemon(true);
                return t;
            }
        });
    }

    private ExecutionResult executeWithTimeout(Step step, Map<String, Object> callVars, final long timeoutMillis) {
        ExecutorService pool = newDaemonExecutor();
        try {
            Future<ExecutionResult> future = pool.submit(new Callable<ExecutionResult>() {
                @Override
                public ExecutionResult call() {
                    return executor.execute(step.method(), step.callStyle(), callVars, timeoutMillis);
                }
            });
            try {
                return future.get(timeoutMillis, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                future.cancel(true);
                return ExecutionResult.failure(new TimeoutException("step '" + step.name()
                        + "' timed out after " + timeoutMillis + "ms"));
            } catch (ExecutionException e) {
                return ExecutionResult.failure(e.getCause() != null ? e.getCause() : e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return ExecutionResult.failure(e);
            }
        } finally {
            pool.shutdownNow();
        }
    }

    private static boolean isExpectedStatus(int code, int expectedStatus, List<Integer> allowedStatuses) {
        if (allowedStatuses != null && !allowedStatuses.isEmpty()) {
            return allowedStatuses.contains(code);
        }
        return expectedStatus != 0 && code == expectedStatus;
    }

    private boolean isRetriable(ExecutionResult exec) {
        if (hasRetriableCause(exec.error)) {
            return true;
        }
        // A retriable status (429 / 5xx) is retriable whether or not it arrived as an exception,
        // since WithHttpInfo / async adapters can surface such statuses on a "successful" call.
        if (exec.statusCode != null) {
            int code = exec.statusCode;
            return code == 429 || (code >= 500 && code < 600);
        }
        return false;
    }

    /**
     * Walks the cause chain of a failure looking for a transport-level error. Generated
     * SDK clients wrap connection failures / socket timeouts inside a module-specific
     * {@code ApiException}, so the top-level type alone is not sufficient.
     */
    private static boolean hasRetriableCause(Throwable e) {
        int guard = 0;
        while (e != null && guard++ < 32) {
            if (e instanceof TimeoutException
                    || e instanceof SocketTimeoutException
                    || e instanceof InterruptedIOException
                    || e instanceof IOException) {
                return true;
            }
            e = e.getCause();
        }
        return false;
    }

    private void recordCoverage(Story story, StepResult result) {
        if (result.status == TestStatus.SKIPPED) {
            return;
        }
        coverage.recordExecution(result.method, result.callStyle, story.name(), result.stepName,
                result.statusCode == null ? 0 : result.statusCode, result.durationMillis,
                result.status == TestStatus.PASSED, result.error != null ? result.error.getMessage() : null);
    }

    private StoryResult finish(Story story, TestStatus status, long start,
                               List<StepResult> steps, Throwable error, Map<String, Object> variables) {
        long duration = System.currentTimeMillis() - start;
        logger.logStoryEnd(story.name(), duration);
        return new StoryResult(story.name(), status, duration, steps, error, variables);
    }

    private static Map<String, Object> mergeInputs(Map<String, Object> variables, Map<String, Object> inputs) {
        if (inputs == null || inputs.isEmpty()) {
            return variables;
        }
        Map<String, Object> merged = new LinkedHashMap<String, Object>(variables);
        merged.putAll(inputs);
        return merged;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ---- reporting ------------------------------------------------------------

    public void printResults(List<StoryResult> results) {
        logger.info(reporter.summary(results));
        coverage.printSummary();
    }

    public String jsonReport(List<StoryResult> results) {
        return reporter.exportJson(results);
    }
}
