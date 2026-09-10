package saasus.sdk.testlib;

/**
 * Result status of a story or step execution.
 */
public enum TestStatus {
    PASSED,
    FAILED,
    SKIPPED;

    /** Lower-case label, matching the Go/JS implementations ("passed"/"failed"/"skipped"). */
    public String label() {
        return name().toLowerCase();
    }
}
