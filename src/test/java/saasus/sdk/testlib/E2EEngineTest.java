package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class E2EEngineTest {

    private Config quietConfig() {
        Config config = new Config();
        config.logLevel = LogLevel.ERROR;
        return config;
    }

    private Map<String, List<String>> emptyHeaders() {
        return new HashMap<String, List<String>>();
    }

    @Test
    void executesAllFourCallStylesInOneStory() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder()
                .normal(vars -> "n")
                .withHttpInfo(vars -> new HttpInfo("h", 200, emptyHeaders()))
                .async((vars, sink) -> sink.onSuccess("a", 200, emptyHeaders()))
                .call((vars, sink) -> sink.onSuccess("c", 200, emptyHeaders()))
                .build());

        Story story = Story.builder("four-styles")
                .step(Step.builder("normal", "m").callStyle(CallStyle.NORMAL).build())
                .step(Step.builder("withHttpInfo", "m").callStyle(CallStyle.WITH_HTTP_INFO).expectedStatus(200).build())
                .step(Step.builder("async", "m").callStyle(CallStyle.ASYNC).expectedStatus(200).build())
                .step(Step.builder("call", "m").callStyle(CallStyle.CALL).expectedStatus(200).build())
                .build();

        E2EEngine engine = new E2EEngine(registry, quietConfig());
        List<StoryResult> results = engine.executeStories(Collections.singletonList(story));

        assertEquals(1, results.size());
        assertTrue(results.get(0).isSuccess());
        assertEquals(4, results.get(0).steps.size());
        // All four (method, style) pairs covered.
        assertTrue(engine.coverage().isFullyCovered());
    }

    @Test
    void setupStepsCleanupAndValueHandoff() {
        final AtomicBoolean setupRan = new AtomicBoolean(false);
        final AtomicBoolean cleanupRan = new AtomicBoolean(false);

        MethodRegistry registry = new MethodRegistry();
        registry.register("produce", MethodInvokers.builder().normal(vars -> "the-id").build());
        registry.register("consume", MethodInvokers.builder()
                .normal(vars -> vars.get("id"))
                .build());

        Story story = Story.builder("handoff")
                .setup(vars -> setupRan.set(true))
                .cleanup(vars -> cleanupRan.set(true))
                .step(Step.builder("produce", "produce")
                        .stateUpdate((response, vars) -> vars.put("id", response))
                        .build())
                .step(Step.builder("consume", "consume")
                        .validation(response -> {
                            if (!"the-id".equals(response)) {
                                throw new AssertionError("expected the-id, got " + response);
                            }
                        })
                        .build())
                .build();

        E2EEngine engine = new E2EEngine(registry, quietConfig());
        StoryResult result = engine.executeStory(story);

        assertTrue(setupRan.get());
        assertTrue(cleanupRan.get());
        assertTrue(result.isSuccess());
        assertEquals("the-id", result.variables.get("id"));
    }

    @Test
    void cleanupRunsEvenWhenStepFails() {
        final AtomicBoolean cleanupRan = new AtomicBoolean(false);
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());

        Story story = Story.builder("failing")
                .cleanup(vars -> cleanupRan.set(true))
                .step(Step.builder("bad", "m")
                        .validation(response -> {
                            throw new AssertionError("always fails");
                        })
                        .build())
                .build();

        StoryResult result = new E2EEngine(registry, quietConfig()).executeStory(story);
        assertFalse(result.isSuccess());
        assertTrue(cleanupRan.get());
    }

    @Test
    void failFastStopsAfterFirstFailingStory() {
        final AtomicInteger secondStoryCalls = new AtomicInteger(0);
        MethodRegistry registry = new MethodRegistry();
        registry.register("bad", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("boom");
                })
                .build());
        registry.register("ok", MethodInvokers.builder()
                .normal(vars -> {
                    secondStoryCalls.incrementAndGet();
                    return "ok";
                })
                .build());

        Story failing = Story.builder("story1").step(Step.builder("bad", "bad").build()).build();
        Story second = Story.builder("story2").step(Step.builder("ok", "ok").build()).build();

        Config config = quietConfig();
        config.failFast = true;
        List<StoryResult> results = new E2EEngine(registry, config).executeStories(Arrays.asList(failing, second));

        assertEquals(1, results.size());
        assertEquals(0, secondStoryCalls.get());
    }

    @Test
    void retriesRetriableFailuresThenSucceeds() {
        final AtomicInteger attempts = new AtomicInteger(0);
        MethodRegistry registry = new MethodRegistry();
        registry.register("flaky", MethodInvokers.builder()
                .normal(vars -> {
                    if (attempts.getAndIncrement() == 0) {
                        throw new IOException("transient");
                    }
                    return "recovered";
                })
                .build());

        Config config = quietConfig();
        config.maxRetries = 3;
        Story story = Story.builder("retry").step(Step.builder("flaky", "flaky").build()).build();
        StoryResult result = new E2EEngine(registry, config).executeStory(story);

        assertTrue(result.isSuccess());
        assertEquals(2, attempts.get()); // 1 failure + 1 success
    }

    @Test
    void dryRunRecordsCoverageWithoutInvoking() {
        final AtomicInteger calls = new AtomicInteger(0);
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder()
                .normal(vars -> {
                    calls.incrementAndGet();
                    return "x";
                })
                .build());

        Config config = quietConfig();
        config.dryRun = true;
        Story story = Story.builder("dry").step(Step.builder("m", "m").build()).build();
        E2EEngine engine = new E2EEngine(registry, config);
        List<StoryResult> results = engine.executeStories(Collections.singletonList(story));

        assertEquals(0, calls.get());
        assertTrue(results.isEmpty());
        assertTrue(engine.coverage().coveredCount() > 0);
    }

    @Test
    void perStoryTimeoutFailsSlowStep() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("slow", MethodInvokers.builder()
                .normal(vars -> {
                    Thread.sleep(5000);
                    return "late";
                })
                .build());

        Config config = quietConfig();
        config.maxRetries = 0;
        Story story = Story.builder("slow-story")
                .timeoutSeconds(1)
                .step(Step.builder("slow", "slow").build())
                .build();

        long start = System.currentTimeMillis();
        StoryResult result = new E2EEngine(registry, config).executeStory(story);
        long elapsed = System.currentTimeMillis() - start;

        assertFalse(result.isSuccess());
        assertTrue(elapsed < 4000, "should abort well before the 5s sleep, was " + elapsed + "ms");
    }

    @Test
    void skippedStepStillCountsForCoverage() {
        // A skipped step still counts as covered: coverage tracks that a (method, style) pair is
        // present in a story, matching the Go reference's static VerifyMethodCoverage. This lets
        // environment-gated skips (e.g. Stripe steps without STRIPE_SECRET_KEY) keep coverage complete.
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());
        Story story = Story.builder("skip")
                .step(Step.builder("skipme", "m").skip("not applicable").build())
                .build();

        E2EEngine engine = new E2EEngine(registry, quietConfig());
        StoryResult result = engine.executeStory(story);

        assertEquals(TestStatus.SKIPPED, result.steps.get(0).status);
        assertEquals(1, engine.coverage().coveredCount());
    }

    @Test
    void executeStoryHonorsDryRun() {
        final AtomicBoolean setupRan = new AtomicBoolean(false);
        final AtomicBoolean cleanupRan = new AtomicBoolean(false);
        final AtomicInteger calls = new AtomicInteger(0);
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder()
                .normal(vars -> {
                    calls.incrementAndGet();
                    return "x";
                })
                .build());

        Config config = quietConfig();
        config.dryRun = true;
        Story story = Story.builder("s")
                .setup(vars -> setupRan.set(true))
                .cleanup(vars -> cleanupRan.set(true))
                .step(Step.builder("m", "m").build())
                .build();

        E2EEngine engine = new E2EEngine(registry, config);
        StoryResult result = engine.executeStory(story);

        assertEquals(0, calls.get());        // method never invoked
        assertFalse(setupRan.get());         // setup skipped under dry-run
        assertFalse(cleanupRan.get());       // cleanup skipped under dry-run
        assertTrue(engine.coverage().coveredCount() > 0);
        assertTrue(result.isSuccess());
    }

    @Test
    void executeStoryNotifiesObservers() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());
        Story story = Story.builder("s").step(Step.builder("ok", "m").build()).build();

        E2EEngine engine = new E2EEngine(registry, quietConfig());
        final AtomicBoolean observed = new AtomicBoolean(false);
        engine.addObserver((s, r) -> {
            observed.set(true);
            return false;
        });

        StoryResult result = engine.executeStory(story);
        assertTrue(observed.get());
        assertTrue(result.isSuccess());
    }

    @Test
    void executeStoryObserverCanForceFailure() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());
        Story story = Story.builder("s").step(Step.builder("ok", "m").build()).build();

        E2EEngine engine = new E2EEngine(registry, quietConfig());
        engine.addObserver((s, r) -> true);

        StoryResult result = engine.executeStory(story);
        assertFalse(result.isSuccess());
        assertEquals(TestStatus.FAILED, result.status);
    }

    @Test
    void observerCanForceStoryFailure() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());
        Story story = Story.builder("s").step(Step.builder("ok", "m").build()).build();

        E2EEngine engine = new E2EEngine(registry, quietConfig());
        engine.addObserver((s, r) -> true); // force failure (e.g. breaking snapshot change)
        List<StoryResult> results = engine.executeStories(Collections.singletonList(story));

        assertEquals(1, results.size());
        assertFalse(results.get(0).isSuccess());
        assertEquals(TestStatus.FAILED, results.get(0).status);
    }

    @Test
    void expectedApiErrorStatusIsTreatedAsPass() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("notFound", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("HTTP 404 not found");
                })
                .build());
        // Extractor surfaces the non-2xx status the generated client would carry on ApiException.
        ApiErrorExtractor extractor = t -> new ApiError(404, emptyHeaders(), "{\"message\":\"not found\"}");

        Config config = quietConfig();
        config.maxRetries = 0;
        E2EEngine engine = new E2EEngine(registry, config, extractor);
        Story story = Story.builder("s")
                .step(Step.builder("nf", "notFound").allowedStatuses(404).build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertTrue(result.isSuccess());
        assertEquals(TestStatus.PASSED, result.steps.get(0).status);
    }

    @Test
    void unexpectedApiErrorStatusStillFails() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("boom", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("HTTP 500");
                })
                .build());
        ApiErrorExtractor extractor = t -> new ApiError(500, emptyHeaders(), "err");

        Config config = quietConfig();
        config.maxRetries = 0;
        E2EEngine engine = new E2EEngine(registry, config, extractor);
        Story story = Story.builder("s")
                .step(Step.builder("b", "boom").allowedStatuses(404).build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertFalse(result.isSuccess());
    }

    @Test
    void acceptedErrorStatusIsNotRetried() {
        final AtomicInteger calls = new AtomicInteger(0);
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder()
                .normal(vars -> {
                    calls.incrementAndGet();
                    throw new IllegalStateException("HTTP 500");
                })
                .build());
        // 500 is retriable by default, but here it is explicitly accepted.
        ApiErrorExtractor extractor = t -> new ApiError(500, emptyHeaders(), "err");

        Config config = quietConfig();
        config.maxRetries = 3;
        E2EEngine engine = new E2EEngine(registry, config, extractor);
        Story story = Story.builder("s")
                .step(Step.builder("m", "m").allowedStatuses(500).build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertTrue(result.isSuccess());
        assertEquals(1, calls.get()); // accepted status must not trigger retries
    }

    @Test
    void setupIsBoundedByStoryTimeout() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());

        Config config = quietConfig();
        config.maxRetries = 0;
        Story story = Story.builder("slow-setup")
                .timeoutSeconds(1)
                .setup(vars -> Thread.sleep(5000))
                .step(Step.builder("m", "m").build())
                .build();

        long start = System.currentTimeMillis();
        StoryResult result = new E2EEngine(registry, config).executeStory(story);
        long elapsed = System.currentTimeMillis() - start;

        assertFalse(result.isSuccess());
        assertTrue(elapsed < 4000, "setup should abort near the 1s timeout, was " + elapsed + "ms");
    }

    @Test
    void cleanupIsBoundedByStoryTimeout() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());

        Config config = quietConfig();
        config.maxRetries = 0;
        Story story = Story.builder("slow-cleanup")
                .timeoutSeconds(1)
                .cleanup(vars -> Thread.sleep(5000))
                .step(Step.builder("m", "m").build())
                .build();

        long start = System.currentTimeMillis();
        new E2EEngine(registry, config).executeStory(story);
        long elapsed = System.currentTimeMillis() - start;

        assertTrue(elapsed < 4000, "cleanup should abort near the 1s timeout, was " + elapsed + "ms");
    }

    @Test
    void cleanupFailureFailsOtherwisePassingStory() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("m", MethodInvokers.builder().normal(vars -> "x").build());

        Story story = Story.builder("cleanup-fails")
                .cleanup(vars -> {
                    throw new IllegalStateException("teardown boom");
                })
                .step(Step.builder("m", "m").build())
                .build();

        StoryResult result = new E2EEngine(registry, quietConfig()).executeStory(story);
        assertFalse(result.isSuccess());
        assertEquals(TestStatus.PASSED, result.steps.get(0).status); // the step itself passed
    }

    @Test
    void acceptedApiErrorRunsValidationAndStateUpdateHooks() {
        final java.util.concurrent.atomic.AtomicBoolean validated = new java.util.concurrent.atomic.AtomicBoolean(false);
        final java.util.concurrent.atomic.AtomicBoolean stateUpdated = new java.util.concurrent.atomic.AtomicBoolean(false);
        MethodRegistry registry = new MethodRegistry();
        registry.register("nf", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("HTTP 404");
                })
                .build());
        ApiErrorExtractor extractor = t -> new ApiError(404, emptyHeaders(), "not found");

        Config config = quietConfig();
        config.maxRetries = 0;
        E2EEngine engine = new E2EEngine(registry, config, extractor);
        Story story = Story.builder("s")
                .step(Step.builder("nf", "nf")
                        .allowedStatuses(404)
                        .validation(response -> validated.set(true))
                        .stateUpdate((response, vars) -> stateUpdated.set(true))
                        .build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertTrue(result.isSuccess());
        assertTrue(validated.get());
        assertTrue(stateUpdated.get());
    }

    @Test
    void acceptedApiErrorBodyIsPassedToHooks() {
        final java.util.concurrent.atomic.AtomicReference<Object> seen =
                new java.util.concurrent.atomic.AtomicReference<Object>();
        MethodRegistry registry = new MethodRegistry();
        registry.register("nf", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("HTTP 404");
                })
                .build());
        ApiErrorExtractor extractor = t -> new ApiError(404, emptyHeaders(), "{\"message\":\"not found\"}");

        Config config = quietConfig();
        config.maxRetries = 0;
        E2EEngine engine = new E2EEngine(registry, config, extractor);
        Story story = Story.builder("s")
                .step(Step.builder("nf", "nf")
                        .allowedStatuses(404)
                        .validation(response -> seen.set(response))
                        .build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertTrue(result.isSuccess());
        assertEquals("{\"message\":\"not found\"}", seen.get());
    }

    @Test
    void acceptedApiErrorBodyIsStoredInStepResult() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("nf", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("HTTP 404");
                })
                .build());
        ApiErrorExtractor extractor = t -> new ApiError(404, emptyHeaders(), "{\"message\":\"not found\"}");

        Config config = quietConfig();
        config.maxRetries = 0;
        E2EEngine engine = new E2EEngine(registry, config, extractor);
        Story story = Story.builder("s")
                .step(Step.builder("nf", "nf").allowedStatuses(404).build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertTrue(result.isSuccess());
        assertEquals("{\"message\":\"not found\"}", result.steps.get(0).response);
    }

    @Test
    void failureWith2xxStatusIsNotAccepted() {
        // A callback failure (e.g. deserialization) that carries a 2xx status must not be
        // treated as an accepted outcome even if 200 is the expected/allowed status.
        MethodRegistry registry = new MethodRegistry();
        registry.register("broken", MethodInvokers.builder()
                .async((vars, sink) -> sink.onFailure(new RuntimeException("deserialize failed"), 200, emptyHeaders()))
                .build());

        Config config = quietConfig();
        config.maxRetries = 0;
        E2EEngine engine = new E2EEngine(registry, config);
        Story story = Story.builder("s")
                .step(Step.builder("b", "broken").callStyle(CallStyle.ASYNC).allowedStatuses(200).build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertFalse(result.isSuccess());
    }

    @Test
    void acceptedApiErrorStillFailsWhenValidationHookThrows() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("nf", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("HTTP 404");
                })
                .build());
        ApiErrorExtractor extractor = t -> new ApiError(404, emptyHeaders(), "not found");

        Config config = quietConfig();
        config.maxRetries = 0;
        E2EEngine engine = new E2EEngine(registry, config, extractor);
        Story story = Story.builder("s")
                .step(Step.builder("nf", "nf")
                        .allowedStatuses(404)
                        .validation(response -> {
                            throw new AssertionError("validation rejects this outcome");
                        })
                        .build())
                .build();

        StoryResult result = engine.executeStory(story);
        assertFalse(result.isSuccess());
    }

    @Test
    void storyTimeoutOverrideAppliesToAsyncCalls() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("slowAsync", MethodInvokers.builder()
                .async((vars, sink) -> {
                    Thread t = new Thread(() -> {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            return;
                        }
                        sink.onSuccess("ok", 200, emptyHeaders());
                    });
                    t.setDaemon(true);
                    t.start();
                })
                .build());

        Config config = quietConfig();
        config.timeout = 1;       // small config-level default
        config.maxRetries = 0;
        Story story = Story.builder("s")
                .timeoutSeconds(10)  // story overrides to a larger budget
                .step(Step.builder("a", "slowAsync").callStyle(CallStyle.ASYNC).expectedStatus(200).build())
                .build();

        StoryResult result = new E2EEngine(registry, config).executeStory(story);
        assertTrue(result.isSuccess());
    }

    @Test
    void retriableStatusWithoutExceptionIsRetried() {
        final AtomicInteger attempts = new AtomicInteger(0);
        MethodRegistry registry = new MethodRegistry();
        registry.register("flaky", MethodInvokers.builder()
                .withHttpInfo(vars -> {
                    if (attempts.getAndIncrement() == 0) {
                        return new HttpInfo("err", 503, emptyHeaders()); // retriable status, no exception
                    }
                    return new HttpInfo("ok", 200, emptyHeaders());
                })
                .build());

        Config config = quietConfig();
        config.maxRetries = 3;
        Story story = Story.builder("s")
                .step(Step.builder("f", "flaky").callStyle(CallStyle.WITH_HTTP_INFO).expectedStatus(200).build())
                .build();

        StoryResult result = new E2EEngine(registry, config).executeStory(story);
        assertTrue(result.isSuccess());
        assertEquals(2, attempts.get()); // retried once after the 503
    }

    @Test
    void retriesWhenIoExceptionIsWrappedInCause() {
        final AtomicInteger attempts = new AtomicInteger(0);
        MethodRegistry registry = new MethodRegistry();
        registry.register("flaky", MethodInvokers.builder()
                .normal(vars -> {
                    if (attempts.getAndIncrement() == 0) {
                        // Generated clients wrap transport failures in an ApiException whose cause is I/O.
                        throw new RuntimeException("ApiException", new IOException("connection reset"));
                    }
                    return "recovered";
                })
                .build());

        Config config = quietConfig();
        config.maxRetries = 3;
        Story story = Story.builder("retry").step(Step.builder("flaky", "flaky").build()).build();
        StoryResult result = new E2EEngine(registry, config).executeStory(story);

        assertTrue(result.isSuccess());
        assertEquals(2, attempts.get()); // 1 wrapped-I/O failure + 1 success
    }
}
