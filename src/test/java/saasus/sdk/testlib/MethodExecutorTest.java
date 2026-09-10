package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.Test;

class MethodExecutorTest {

    /** A stand-in for a module-specific ApiException. */
    static class FakeApiException extends Exception {
        final int code;
        final String body;

        FakeApiException(int code, String body) {
            super("HTTP " + code);
            this.code = code;
            this.body = body;
        }
    }

    private static Map<String, List<String>> headers() {
        Map<String, List<String>> h = new HashMap<String, List<String>>();
        h.put("X-Test", Collections.singletonList("1"));
        return h;
    }

    private MethodExecutor executor(MethodRegistry registry) {
        return new MethodExecutor(registry, new Logger(LogLevel.ERROR), false, defaultExtractor(), 2000);
    }

    private ApiErrorExtractor defaultExtractor() {
        return t -> {
            if (t instanceof FakeApiException) {
                FakeApiException e = (FakeApiException) t;
                return new ApiError(e.code, headers(), e.body);
            }
            return null;
        };
    }

    @Test
    void normalStyleReturnsResponseWithUnsetStatus() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("echo", MethodInvokers.builder()
                .normal(vars -> "normal-result")
                .build());
        ExecutionResult result = executor(registry).execute("echo", CallStyle.NORMAL, vars());
        assertTrue(result.isSuccess());
        assertEquals("normal-result", result.response);
        assertNull(result.statusCode);
        assertFalse(result.hasStatusCode());
    }

    @Test
    void withHttpInfoStyleCarriesStatusAndHeaders() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("echo", MethodInvokers.builder()
                .withHttpInfo(vars -> new HttpInfo("http-data", 200, headers()))
                .build());
        ExecutionResult result = executor(registry).execute("echo", CallStyle.WITH_HTTP_INFO, vars());
        assertTrue(result.isSuccess());
        assertEquals("http-data", result.response);
        assertEquals(Integer.valueOf(200), result.statusCode);
        assertEquals(Collections.singletonList("1"), result.headers.get("X-Test"));
    }

    @Test
    void asyncStyleForwardsSinkResult() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("echo", MethodInvokers.builder()
                .async((vars, sink) -> sink.onSuccess("async-result", 201, headers()))
                .build());
        ExecutionResult result = executor(registry).execute("echo", CallStyle.ASYNC, vars());
        assertTrue(result.isSuccess());
        assertEquals("async-result", result.response);
        assertEquals(Integer.valueOf(201), result.statusCode);
    }

    @Test
    void callStyleForwardsSinkResult() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("echo", MethodInvokers.builder()
                .call((vars, sink) -> sink.onSuccess("call-result", 202, headers()))
                .build());
        ExecutionResult result = executor(registry).execute("echo", CallStyle.CALL, vars());
        assertTrue(result.isSuccess());
        assertEquals("call-result", result.response);
        assertEquals(Integer.valueOf(202), result.statusCode);
    }

    @Test
    void exceptionConvertedViaErrorExtractor() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("boom", MethodInvokers.builder()
                .normal(vars -> {
                    throw new FakeApiException(404, "{\"message\":\"not found\"}");
                })
                .build());
        ExecutionResult result = executor(registry).execute("boom", CallStyle.NORMAL, vars());
        assertFalse(result.isSuccess());
        assertEquals(Integer.valueOf(404), result.statusCode);
        assertEquals("{\"message\":\"not found\"}", result.body);
    }

    @Test
    void asyncFailureIsCaptured() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("boom", MethodInvokers.builder()
                .async((vars, sink) -> sink.onFailure(new FakeApiException(500, "err"), 500, headers()))
                .build());
        ExecutionResult result = executor(registry).execute("boom", CallStyle.ASYNC, vars());
        assertFalse(result.isSuccess());
        assertEquals(Integer.valueOf(500), result.statusCode);
    }

    @Test
    void asyncTimesOutWhenSinkNeverCompletes() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("hang", MethodInvokers.builder()
                .async((vars, sink) -> { /* never completes */ })
                .build());
        MethodExecutor exec = new MethodExecutor(registry, new Logger(LogLevel.ERROR), false, null, 100);
        ExecutionResult result = exec.execute("hang", CallStyle.ASYNC, vars());
        assertFalse(result.isSuccess());
        assertTrue(result.error instanceof TimeoutException);
    }

    @Test
    void dryRunSkipsInvocation() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("echo", MethodInvokers.builder()
                .normal(vars -> {
                    throw new IllegalStateException("should not be called in dry-run");
                })
                .build());
        MethodExecutor exec = new MethodExecutor(registry, new Logger(LogLevel.ERROR), true, null, 2000);
        ExecutionResult result = exec.execute("echo", CallStyle.NORMAL, vars());
        assertTrue(result.isSuccess());
        assertEquals(Integer.valueOf(200), result.statusCode);
    }

    @Test
    void unregisteredMethodFails() {
        ExecutionResult result = executor(new MethodRegistry()).execute("missing", CallStyle.NORMAL, vars());
        assertFalse(result.isSuccess());
    }

    @Test
    void unsupportedStyleFails() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("only-normal", MethodInvokers.builder().normal(vars -> "x").build());
        ExecutionResult result = executor(registry).execute("only-normal", CallStyle.ASYNC, vars());
        assertFalse(result.isSuccess());
    }

    @Test
    void nullHttpInfoResultIsFailure() {
        MethodRegistry registry = new MethodRegistry();
        registry.register("nullhttp", MethodInvokers.builder()
                .withHttpInfo(vars -> null)
                .build());
        ExecutionResult result = executor(registry).execute("nullhttp", CallStyle.WITH_HTTP_INFO, vars());
        assertFalse(result.isSuccess());
    }

    private Map<String, Object> vars() {
        return new HashMap<String, Object>();
    }
}
