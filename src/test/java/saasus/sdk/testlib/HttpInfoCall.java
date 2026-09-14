package saasus.sdk.testlib;

import java.util.Map;

/**
 * Invoker for the {@link CallStyle#WITH_HTTP_INFO} style: a synchronous method returning
 * data plus HTTP status code and headers. The adapter converts the module's
 * {@code ApiResponse<T>} into a {@link HttpInfo}.
 */
@FunctionalInterface
public interface HttpInfoCall {

    HttpInfo call(Map<String, Object> variables) throws Exception;
}
