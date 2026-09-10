package saasus.sdk.testlib.snapshot;

/**
 * Severity of a difference detected between a current snapshot and its baseline.
 */
public enum CompatibilityLevel {
    /** No meaningful difference. */
    COMPATIBLE,
    /** Backward-compatible change (e.g. a new field was added). */
    WARNING,
    /** Backward-incompatible change (status/type change, field removed, ...). */
    BREAKING;

    public String label() {
        return name().toLowerCase();
    }
}
