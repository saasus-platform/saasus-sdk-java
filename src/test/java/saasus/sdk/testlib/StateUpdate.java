package saasus.sdk.testlib;

import java.util.Map;

/**
 * Extracts values from a step response into the shared story variables, so later steps
 * can consume them. Throw an exception to fail the step.
 */
@FunctionalInterface
public interface StateUpdate {

    void update(Object response, Map<String, Object> variables) throws Exception;
}
