package saasus.sdk.testlib.snapshot;

/**
 * Summary of validation results, mirroring the Go {@code ValidationSummary}.
 */
public class ValidationSummary {

    public int totalErrors;
    public int totalWarnings;
    public int totalInfo;
    public boolean isValid = true;

    public ValidationSummary() {
    }
}
