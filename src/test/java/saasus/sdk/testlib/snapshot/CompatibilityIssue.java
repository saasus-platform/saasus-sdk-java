package saasus.sdk.testlib.snapshot;

/**
 * A single difference between a current snapshot and its baseline.
 */
public class CompatibilityIssue {

    public final String type;        // e.g. "field_removed", "type_mismatch"
    public final String path;        // location within the response, e.g. "Step 0.data.id"
    public final String description;
    public final CompatibilityLevel impact;

    public CompatibilityIssue(String type, String path, String description, CompatibilityLevel impact) {
        this.type = type;
        this.path = path;
        this.description = description;
        this.impact = impact;
    }

    @Override
    public String toString() {
        return "[" + impact.label() + "] " + description;
    }
}
