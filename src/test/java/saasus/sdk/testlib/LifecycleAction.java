package saasus.sdk.testlib;

import java.util.Map;

/**
 * A story setup or cleanup action. Receives the shared story variables so it can seed or
 * consume state. Throw an exception to signal failure.
 */
@FunctionalInterface
public interface LifecycleAction {

    void run(Map<String, Object> variables) throws Exception;
}
