package saasus.sdk.testlib.snapshot;

/**
 * Summarizes the difference from the previous validation of the same story,
 * mirroring the fields emitted by the Go {@code ValidationComparison}.
 */
public class ValidationComparison {

    /** Omitted when empty. */
    @OmitEmpty
    public String previousFile;
    /** Omitted when empty (RFC 3339). */
    @OmitEmpty
    public String previousValidationTime;
    public int errorCountDelta;
    public int warningCountDelta;
    public int infoCountDelta;

    public ValidationComparison() {
    }
}
