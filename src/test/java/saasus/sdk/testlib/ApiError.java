package saasus.sdk.testlib;

import java.util.List;
import java.util.Map;

/**
 * Module-agnostic view of a failed API call, extracted from a module-specific
 * {@code ApiException} by an {@link ApiErrorExtractor}.
 */
public class ApiError {

    public final int code;
    public final Map<String, List<String>> headers;
    public final String body;

    public ApiError(int code, Map<String, List<String>> headers, String body) {
        this.code = code;
        this.headers = headers;
        this.body = body;
    }
}
