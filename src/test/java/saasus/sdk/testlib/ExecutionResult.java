package saasus.sdk.testlib;

import java.util.List;
import java.util.Map;

/**
 * Module-agnostic result of executing a single SDK call, regardless of call style.
 *
 * <p>{@link #statusCode} and {@link #headers} are {@code null} when not observable
 * (for example the {@link CallStyle#NORMAL} style cannot report them). {@link #error}
 * is non-null on failure.
 */
public class ExecutionResult {

    public final Object response;
    public final Integer statusCode;             // null = unset / not observable
    public final Map<String, List<String>> headers; // null = unset
    public final Throwable error;                // null = success
    public final String body;                    // response/error body when available

    private ExecutionResult(Object response, Integer statusCode,
                            Map<String, List<String>> headers, Throwable error, String body) {
        this.response = response;
        this.statusCode = statusCode;
        this.headers = headers;
        this.error = error;
        this.body = body;
    }

    public boolean isSuccess() {
        return error == null;
    }

    /** Whether an HTTP status code was observed for this call. */
    public boolean hasStatusCode() {
        return statusCode != null && statusCode != 0;
    }

    // ---- factories ------------------------------------------------------------

    /** NORMAL-style success: status/headers unobservable. */
    public static ExecutionResult success(Object response) {
        return new ExecutionResult(response, null, null, null, null);
    }

    /** WithHttpInfo / async success: status and headers known. */
    public static ExecutionResult withHttp(Object response, int statusCode,
                                            Map<String, List<String>> headers) {
        return new ExecutionResult(response, statusCode, headers, null, null);
    }

    /** Dry-run synthetic success. */
    public static ExecutionResult dryRun() {
        return new ExecutionResult(null, 200, null, null, null);
    }

    /** Failure with no HTTP metadata. */
    public static ExecutionResult failure(Throwable error) {
        return new ExecutionResult(null, null, null, error, null);
    }

    /** Failure enriched with API error metadata (status/headers/body). */
    public static ExecutionResult failure(Throwable error, ApiError apiError) {
        if (apiError == null) {
            return failure(error);
        }
        Integer code = apiError.code != 0 ? apiError.code : null;
        return new ExecutionResult(null, code, apiError.headers, error, apiError.body);
    }

    /** Failure from an async sink where a status code may be present. */
    public static ExecutionResult asyncFailure(Throwable error, int statusCode,
                                                Map<String, List<String>> headers, ApiError apiError) {
        Integer code = statusCode != 0 ? statusCode : (apiError != null && apiError.code != 0 ? apiError.code : null);
        Map<String, List<String>> h = headers != null ? headers : (apiError != null ? apiError.headers : null);
        String body = apiError != null ? apiError.body : null;
        return new ExecutionResult(null, code, h, error, body);
    }
}
