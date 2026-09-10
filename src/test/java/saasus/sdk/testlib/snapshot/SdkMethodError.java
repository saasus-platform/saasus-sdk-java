package saasus.sdk.testlib.snapshot;

/**
 * Captures error information for a failed step, mirroring the Go {@code SDKMethodError}.
 */
public class SdkMethodError {

    public String type;
    public String message;
    /** Omitted when empty. */
    @OmitEmpty
    public String details;

    public SdkMethodError() {
    }

    public SdkMethodError(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
