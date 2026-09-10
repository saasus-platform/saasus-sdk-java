package saasus.sdk.testlib;

/**
 * Snapshot-related configuration. Present on {@link Config} only when at least one
 * snapshot environment variable is set (mirrors the Go/JS behaviour).
 */
public class SnapshotConfig {

    public boolean enableCapture;
    public boolean enableComparison;
    public boolean enableReporting;
    public String outputDirectory = "tests/e2e/snapshot";
    /** {@code FULL} or {@code MINIMAL}. */
    public String captureLevel = "FULL";
    /** When true, a missing baseline is captured instead of failing the comparison. */
    public boolean captureFallback = true;
    /** When true, a breaking snapshot diff fails the step. */
    public boolean failOnBreaking = false;

    public SnapshotConfig() {
    }

    public boolean anyEnabled() {
        return enableCapture || enableComparison || enableReporting;
    }

    @Override
    public String toString() {
        return "SnapshotConfig{capture=" + enableCapture
                + ", comparison=" + enableComparison
                + ", reporting=" + enableReporting
                + ", outputDirectory='" + outputDirectory + '\''
                + ", captureLevel='" + captureLevel + '\''
                + '}';
    }
}
