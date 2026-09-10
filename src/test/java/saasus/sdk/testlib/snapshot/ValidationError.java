package saasus.sdk.testlib.snapshot;

/**
 * A single validation error, mirroring the Go {@code ValidationError}.
 *
 * <p>{@code type} and {@code severity} carry the same string values as the Go
 * implementation (e.g. {@code sequence}/{@code state_transition}/{@code timing} and
 * {@code error}/{@code warning}/{@code info}).
 */
public class ValidationError {

    // Error type values (match Go ValidationErrorType).
    public static final String TYPE_SEQUENCE = "sequence";
    public static final String TYPE_STATE_TRANSITION = "state_transition";
    public static final String TYPE_TIMING = "timing";
    public static final String TYPE_DEPENDENCY = "dependency";

    // Severity values (match Go ValidationSeverity).
    public static final String SEVERITY_ERROR = "error";
    public static final String SEVERITY_WARNING = "warning";
    public static final String SEVERITY_INFO = "info";

    public String type;
    public String stepName;
    public String message;
    public String severity;
    /** Omitted when empty. */
    @OmitEmpty
    public Object expectedValue;
    /** Omitted when empty. */
    @OmitEmpty
    public Object actualValue;

    public ValidationError() {
    }

    public ValidationError(String type, String stepName, String message, String severity) {
        this.type = type;
        this.stepName = stepName;
        this.message = message;
        this.severity = severity;
    }
}
