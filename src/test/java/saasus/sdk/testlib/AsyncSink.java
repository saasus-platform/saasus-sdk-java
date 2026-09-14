package saasus.sdk.testlib;

import java.util.List;
import java.util.Map;

/**
 * Generic asynchronous result sink. A caller's {@code *Async} / {@code *Call} invoker
 * adapter forwards the module-specific {@code ApiCallback} events into this sink so the
 * test library can wait for completion without knowing the module types.
 */
public interface AsyncSink {

    void onSuccess(Object result, int statusCode, Map<String, List<String>> headers);

    void onFailure(Throwable error, int statusCode, Map<String, List<String>> headers);
}
