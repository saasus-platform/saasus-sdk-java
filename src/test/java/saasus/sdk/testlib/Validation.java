package saasus.sdk.testlib;

/**
 * Validates a step response. Throw an exception (with a descriptive message) to fail the step.
 */
@FunctionalInterface
public interface Validation {

    void validate(Object response) throws Exception;
}
