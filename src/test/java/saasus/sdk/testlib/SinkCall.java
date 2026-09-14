package saasus.sdk.testlib;

import java.util.Map;

/**
 * Invoker for the {@link CallStyle#ASYNC} and {@link CallStyle#CALL} styles.
 *
 * <p>The adapter starts the asynchronous call and forwards the module-specific
 * {@code ApiCallback} events to the supplied {@link AsyncSink}. For the {@code CALL}
 * style it executes the {@code okhttp3.Call} through the configured (signed) client.
 */
@FunctionalInterface
public interface SinkCall {

    void call(Map<String, Object> variables, AsyncSink sink) throws Exception;
}
