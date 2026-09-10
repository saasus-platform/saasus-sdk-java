package saasus.sdk.testlib.snapshot;

import saasus.sdk.testlib.Logger;
import saasus.sdk.testlib.SnapshotConfig;
import saasus.sdk.testlib.Step;
import saasus.sdk.testlib.StepResult;
import saasus.sdk.testlib.Story;
import saasus.sdk.testlib.StoryObserver;
import saasus.sdk.testlib.StoryResult;
import saasus.sdk.testlib.TestStatus;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Snapshot engine: captures story executions in the Go-compatible snapshot format, validates
 * them, persists snapshots and validations (per git tag), and optionally compares against an
 * earlier baseline. Plugs into {@link saasus.sdk.testlib.E2EEngine} as a {@link StoryObserver}.
 */
public class SnapshotEngine implements StoryObserver {

    private static final long MILLIS_TO_NANOS = 1_000_000L;

    private final SnapshotConfig config;
    private final Logger logger;
    private final SnapshotMasker masker;
    private final SnapshotFileManager files;
    private final SnapshotValidator validator = new SnapshotValidator();
    private final SnapshotComparator comparator = new SnapshotComparator();
    private final SnapshotReporter reporter = new SnapshotReporter();

    public SnapshotEngine(SnapshotConfig config, Logger logger) {
        this(config, logger, new SnapshotMasker());
    }

    public SnapshotEngine(SnapshotConfig config, Logger logger, SnapshotMasker masker) {
        this.config = config != null ? config : new SnapshotConfig();
        this.logger = logger;
        this.masker = masker != null ? masker : new SnapshotMasker();
        this.files = new SnapshotFileManager(this.config.outputDirectory);
    }

    public SnapshotFileManager fileManager() {
        return files;
    }

    // ---- capture --------------------------------------------------------------

    /** Builds a Go-structured, masked snapshot from a story result and its definition. */
    public StorySnapshot capture(Story story, StoryResult result) {
        return capture(result, story != null ? story.description() : "",
                story != null ? story.steps() : null);
    }

    /** Convenience overload without a {@link Story} (step parameters are omitted). */
    public StorySnapshot capture(StoryResult result, String description) {
        return capture(result, description, null);
    }

    private StorySnapshot capture(StoryResult result, String description, List<Step> steps) {
        StorySnapshot snapshot = new StorySnapshot();
        snapshot.storyName = result.storyName;
        snapshot.description = description;
        snapshot.timestamp = OffsetDateTime.now().toString();
        snapshot.duration = result.durationMillis * MILLIS_TO_NANOS;
        snapshot.status = result.status.label();
        snapshot.variables = maskedSortedMap(result.variables);

        for (int i = 0; i < result.steps.size(); i++) {
            StepResult step = result.steps.get(i);
            Step definition = steps != null && i < steps.size() ? steps.get(i) : null;
            snapshot.steps.add(buildStep(step, definition));
        }

        snapshot.summary = summarize(snapshot.steps);
        snapshot.metadata = buildMetadata();
        return snapshot;
    }

    private StepSnapshot buildStep(StepResult step, Step definition) {
        StepSnapshot ss = new StepSnapshot();
        ss.stepName = step.stepName;
        ss.method = step.method;
        ss.parameters = definition != null ? maskedSortedMap(definition.inputs())
                : new LinkedHashMap<String, Object>();
        ss.duration = step.durationMillis * MILLIS_TO_NANOS;
        ss.statusCode = step.statusCode == null ? 0 : step.statusCode;
        ss.success = step.isSuccess();
        ss.status = step.status.label();
        ss.skipReason = step.skipReason;
        ss.timestamp = OffsetDateTime.now().toString();
        if (step.error != null) {
            ss.error = new SdkMethodError("StepExecutionError", masker.processText(step.error.getMessage()));
        }
        // Skipped steps carry no return value (matching Go). Go always records the payload
        // regardless of capture level, so the level only affects metadata, never the return value.
        if (step.status != TestStatus.SKIPPED) {
            ss.returnValue = buildReturnValue(step);
        }
        return ss;
    }

    /** Builds the structured return value from the observable parts of a step result. */
    private SdkReturnValue buildReturnValue(StepResult step) {
        Object response = step.response;
        boolean hasHeaders = step.headers != null && !step.headers.isEmpty();
        int statusCode = step.statusCode == null ? 0 : step.statusCode;
        if (response == null && !hasHeaders && statusCode == 0) {
            return null;
        }

        SdkReturnValue rv = new SdkReturnValue();
        rv.type = response == null ? "" : response.getClass().getName();
        rv.statusCode = statusCode;
        rv.status = statusLine(statusCode);

        if (hasHeaders) {
            Map<String, String> headers = new TreeMap<String, String>();
            String traceId = null;
            long contentLength = -1;
            for (Map.Entry<String, List<String>> e : step.headers.entrySet()) {
                String key = e.getKey();
                List<String> values = e.getValue();
                if (key == null || values == null || values.isEmpty()) {
                    continue;
                }
                String first = values.get(0);
                headers.put(key, masker.maskHeaderValue(key, first));
                if ("X-Saasus-Trace-Id".equalsIgnoreCase(key)) {
                    traceId = first;
                }
                if ("Content-Length".equalsIgnoreCase(key)) {
                    try {
                        contentLength = Long.parseLong(first.trim());
                    } catch (NumberFormatException ignored) {
                        // leave as -1
                    }
                }
            }
            rv.headers = headers;

            HttpResponseSnapshot http = new HttpResponseSnapshot();
            http.statusCode = statusCode;
            http.status = rv.status;
            http.headers = headers;
            http.contentLength = contentLength;
            http.traceId = traceId;
            rv.httpResponse = http;
        }

        // json_data + body from the response payload.
        if (response instanceof String) {
            String bodyStr = (String) response;
            rv.body = masker.maskBodyString(bodyStr);
            Object parsed = SnapshotJson.parse(bodyStr);
            Object masked = masker.process(parsed);
            if (masked instanceof Map) {
                rv.jsonData = asSortedMap(masked);
            }
        } else if (response != null) {
            Object masked = masker.process(SnapshotJson.normalize(response));
            if (masked instanceof Map) {
                rv.jsonData = asSortedMap(masked);
            }
            rv.body = SnapshotJson.prettyBody(masked);
        }
        return rv;
    }

    private SnapshotMetadata buildMetadata() {
        SnapshotMetadata metadata = new SnapshotMetadata();
        String version = System.getenv("SDK_VERSION");
        metadata.sdkVersion = version != null && !version.isEmpty() ? version : "unknown";
        String env = System.getenv("TEST_ENVIRONMENT");
        metadata.testEnvironment = env != null && !env.isEmpty() ? env : "dev";
        metadata.captureLevel = config.captureLevel != null ? config.captureLevel : "FULL";
        metadata.gitTag = emptyToNull(files.gitTag());
        metadata.gitCommit = emptyToNull(System.getenv("GIT_COMMIT"));
        return metadata;
    }

    private StoryExecutionSummary summarize(List<StepSnapshot> steps) {
        StoryExecutionSummary summary = new StoryExecutionSummary();
        summary.totalSteps = steps.size();
        long totalDuration = 0;
        for (StepSnapshot step : steps) {
            totalDuration += step.duration;
            if (SnapshotValidator.TestStatusLabels.SKIPPED.equals(step.status)) {
                summary.skippedSteps++;
            } else if (step.success) {
                summary.successfulSteps++;
            } else {
                summary.failedSteps++;
            }
        }
        summary.totalDuration = totalDuration;
        if (summary.totalSteps > 0) {
            summary.averageStepDuration = totalDuration / summary.totalSteps;
        }
        return summary;
    }

    // ---- observer -------------------------------------------------------------

    @Override
    public boolean onStoryFinished(Story story, StoryResult result) {
        if (config == null || !config.anyEnabled()) {
            return false;
        }
        String storyName = result.storyName;
        try {
            StorySnapshot current = capture(story, result);

            if (config.enableCapture) {
                files.saveSnapshot(current);
                StoryValidation validation = validator.validate(current);
                files.saveValidation(validation);
                info("Snapshot saved: " + files.snapshotPath(files.gitTag(), current.storyName));
            }

            if (config.enableComparison) {
                StorySnapshot baseline = files.loadPreviousSnapshot(files.gitTag(), current.storyName);
                if (baseline != null) {
                    ComparisonResult comparison = comparator.compare(current, baseline);
                    report(comparison, current.storyName);
                    if (comparison.hasBreaking() && config.failOnBreaking) {
                        warn("Breaking snapshot changes detected for story '" + current.storyName + "'");
                        return true;
                    }
                } else if (!config.enableCapture && !config.captureFallback) {
                    warn("No previous snapshot for story '" + current.storyName
                            + "' and capture fallback disabled.");
                    return true;
                } else if (!config.enableCapture) {
                    // Comparison-only mode with no baseline: capture one now.
                    files.saveSnapshot(current);
                    files.saveValidation(validator.validate(current));
                }
            }
        } catch (Exception e) {
            if (logger != null) {
                logger.error("Snapshot processing failed for story '" + storyName + "'", e);
            }
            if (config.enableComparison) {
                return true;
            }
        }
        return false;
    }

    // ---- helpers --------------------------------------------------------------

    private Map<String, Object> maskedSortedMap(Map<String, Object> source) {
        if (source == null || source.isEmpty()) {
            return new LinkedHashMap<String, Object>();
        }
        Object masked = masker.process(SnapshotJson.normalize(source));
        Map<String, Object> sorted = asSortedMap(masked);
        return sorted != null ? sorted : new LinkedHashMap<String, Object>();
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> asSortedMap(Object value) {
        Object sorted = SnapshotJson.deepSort(value);
        if (sorted instanceof Map) {
            return (Map<String, Object>) sorted;
        }
        return null;
    }

    private static String emptyToNull(String value) {
        return value == null || value.isEmpty() ? null : value;
    }

    private static String statusLine(int statusCode) {
        if (statusCode == 0) {
            return "";
        }
        String reason = REASON_PHRASES.get(statusCode);
        return reason != null ? statusCode + " " + reason : String.valueOf(statusCode);
    }

    private static final Map<Integer, String> REASON_PHRASES = new LinkedHashMap<Integer, String>();
    static {
        REASON_PHRASES.put(200, "OK");
        REASON_PHRASES.put(201, "Created");
        REASON_PHRASES.put(202, "Accepted");
        REASON_PHRASES.put(204, "No Content");
        REASON_PHRASES.put(400, "Bad Request");
        REASON_PHRASES.put(401, "Unauthorized");
        REASON_PHRASES.put(403, "Forbidden");
        REASON_PHRASES.put(404, "Not Found");
        REASON_PHRASES.put(409, "Conflict");
        REASON_PHRASES.put(422, "Unprocessable Entity");
        REASON_PHRASES.put(429, "Too Many Requests");
        REASON_PHRASES.put(500, "Internal Server Error");
        REASON_PHRASES.put(501, "Not Implemented");
        REASON_PHRASES.put(502, "Bad Gateway");
        REASON_PHRASES.put(503, "Service Unavailable");
    }

    private void report(ComparisonResult comparison, String storyName) {
        if (!config.enableReporting) {
            return;
        }
        String text = reporter.console(comparison, storyName);
        if (logger != null) {
            logger.info(text);
        } else {
            System.out.println(text);
        }
    }

    private void info(String message) {
        if (logger != null) {
            logger.info(message);
        }
    }

    private void warn(String message) {
        if (logger != null) {
            logger.warn(message);
        }
    }
}
