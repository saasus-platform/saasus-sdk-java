package saasus.sdk.testlib;

/** Thrown when an observed HTTP status code does not satisfy a step's expectation. */
public class StatusValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    public StatusValidationException(String message) {
        super(message);
    }
}
