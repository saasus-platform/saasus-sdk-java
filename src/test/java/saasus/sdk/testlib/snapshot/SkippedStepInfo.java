package saasus.sdk.testlib.snapshot;

/**
 * Information about a skipped step, mirroring the Go {@code SkippedStepInfo}.
 */
public class SkippedStepInfo {

    public String stepName;
    public String method;
    /** Omitted when empty. */
    @OmitEmpty
    public String reason;

    public SkippedStepInfo() {
    }

    public SkippedStepInfo(String stepName, String method, String reason) {
        this.stepName = stepName;
        this.method = method;
        this.reason = reason;
    }
}
