package saasus.sdk.testlib;

import java.util.Map;

/**
 * Executes a registered SDK method through a chosen {@link CallStyle} and converts the
 * outcome (return value or exception) into a common {@link ExecutionResult}.
 */
public class MethodExecutor {

    private final MethodRegistry registry;
    private final Logger logger;
    private final boolean dryRun;
    private final ApiErrorExtractor errorExtractor; // nullable
    private final long asyncTimeoutMillis;

    public MethodExecutor(MethodRegistry registry, Logger logger, boolean dryRun,
                          ApiErrorExtractor errorExtractor, long asyncTimeoutMillis) {
        this.registry = registry;
        this.logger = logger;
        this.dryRun = dryRun;
        this.errorExtractor = errorExtractor;
        this.asyncTimeoutMillis = asyncTimeoutMillis > 0 ? asyncTimeoutMillis : 300_000L;
    }

    public ExecutionResult execute(String method, CallStyle style, Map<String, Object> variables) {
        return execute(method, style, variables, asyncTimeoutMillis);
    }

    /**
     * Executes a method through the given call style, using {@code asyncWaitMillis} as the
     * maximum wait for async/call-style callbacks. Passing the step's remaining budget here
     * lets a story-level timeout override the engine's construction-time default.
     */
    public ExecutionResult execute(String method, CallStyle style, Map<String, Object> variables,
                                   long asyncWaitMillis) {
        long asyncTimeout = asyncWaitMillis > 0 ? asyncWaitMillis : this.asyncTimeoutMillis;
        if (logger != null) {
            logger.debug("Executing " + method + " [" + style + "]");
        }

        if (dryRun) {
            if (logger != null) {
                logger.debug("DRY RUN: simulating " + method + " [" + style + "]");
            }
            return ExecutionResult.dryRun();
        }

        MethodInvokers invokers = registry == null ? null : registry.get(method);
        if (invokers == null) {
            return ExecutionResult.failure(new IllegalArgumentException("method not registered: " + method));
        }
        if (!invokers.supports(style)) {
            return ExecutionResult.failure(new IllegalArgumentException(
                    "method '" + method + "' does not support call style " + style));
        }

        try {
            switch (style) {
                case NORMAL:
                    return ExecutionResult.success(invokers.normal().call(variables));
                case WITH_HTTP_INFO:
                    HttpInfo info = invokers.httpInfo().call(variables);
                    if (info == null) {
                        // A null ApiResponse indicates a broken adapter/response; do not turn it
                        // into a statusless success that would bypass status validation.
                        return ExecutionResult.failure(new IllegalStateException(
                                "method '" + method + "' WithHttpInfo adapter returned null"));
                    }
                    return ExecutionResult.withHttp(info.data, info.statusCode, info.headers);
                case ASYNC:
                    return runSink(invokers.async(), variables, asyncTimeout);
                case CALL:
                    return runSink(invokers.call(), variables, asyncTimeout);
                default:
                    return ExecutionResult.failure(new IllegalArgumentException("unknown call style: " + style));
            }
        } catch (Throwable t) {
            return toFailure(t);
        }
    }

    private ExecutionResult runSink(SinkCall sinkCall, Map<String, Object> variables, long asyncWaitMillis) throws Exception {
        long waitMillis = asyncWaitMillis > 0 ? asyncWaitMillis : asyncTimeoutMillis;
        LatchAsyncSink sink = new LatchAsyncSink();
        sinkCall.call(variables, sink);
        boolean completed;
        try {
            completed = sink.await(waitMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ExecutionResult.failure(e);
        }
        if (!completed) {
            return ExecutionResult.failure(
                    new java.util.concurrent.TimeoutException("async call timed out after " + waitMillis + "ms"));
        }
        if (sink.isSuccess()) {
            return ExecutionResult.withHttp(sink.result(), sink.statusCode(), sink.headers());
        }
        Throwable error = sink.error() != null ? sink.error() : new RuntimeException("async call failed");
        return ExecutionResult.asyncFailure(error, sink.statusCode(), sink.headers(), extract(error));
    }

    private ExecutionResult toFailure(Throwable t) {
        ApiError apiError = extract(t);
        if (apiError != null) {
            return ExecutionResult.failure(t, apiError);
        }
        return ExecutionResult.failure(t);
    }

    private ApiError extract(Throwable t) {
        if (errorExtractor == null || t == null) {
            return null;
        }
        try {
            return errorExtractor.extract(t);
        } catch (Throwable ignored) {
            return null;
        }
    }
}
