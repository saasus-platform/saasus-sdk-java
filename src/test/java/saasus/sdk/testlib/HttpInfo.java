package saasus.sdk.testlib;

import java.util.List;
import java.util.Map;

/**
 * Module-agnostic representation of a {@code *WithHttpInfo} / async result:
 * deserialized data plus HTTP status code and headers.
 *
 * <p>Callers convert each module's own {@code ApiResponse<T>} into this type inside
 * their registered invoker lambda, keeping the test library free of any dependency
 * on a specific SDK module.
 */
public class HttpInfo {

    public final Object data;
    public final int statusCode;
    public final Map<String, List<String>> headers;

    public HttpInfo(Object data, int statusCode, Map<String, List<String>> headers) {
        this.data = data;
        this.statusCode = statusCode;
        this.headers = headers;
    }
}
