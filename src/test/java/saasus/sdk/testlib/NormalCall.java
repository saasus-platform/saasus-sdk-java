package saasus.sdk.testlib;

import java.util.Map;

/**
 * Invoker for the {@link CallStyle#NORMAL} style: a synchronous method returning the
 * deserialized model. HTTP status and headers are not observable and are treated as unset.
 */
@FunctionalInterface
public interface NormalCall {

    Object call(Map<String, Object> variables) throws Exception;
}
