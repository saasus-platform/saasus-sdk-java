package saasus.sdk.testlib.snapshot;

/**
 * Metadata attached to a stored snapshot, mirroring the Go {@code SnapshotMetadata}.
 * {@link #gitTag}/{@link #gitCommit} are left {@code null} when unavailable.
 */
public class SnapshotMetadata {

    public String sdkVersion = "unknown";
    public String testEnvironment = "dev";
    public String captureLevel = "FULL";
    @OmitEmpty
    public String gitTag;
    @OmitEmpty
    public String gitCommit;

    public SnapshotMetadata() {
    }
}
