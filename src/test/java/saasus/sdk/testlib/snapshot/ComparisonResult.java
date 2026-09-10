package saasus.sdk.testlib.snapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Outcome of comparing a current snapshot to its baseline.
 */
public class ComparisonResult {

    public final boolean compatible;
    public final CompatibilityLevel level;
    public final List<CompatibilityIssue> issues;
    public final String summary;

    public ComparisonResult(CompatibilityLevel level, List<CompatibilityIssue> issues, String summary) {
        this.level = level;
        this.compatible = level == CompatibilityLevel.COMPATIBLE;
        this.issues = issues == null ? new ArrayList<CompatibilityIssue>() : issues;
        this.summary = summary;
    }

    public List<CompatibilityIssue> issuesOf(CompatibilityLevel impact) {
        List<CompatibilityIssue> filtered = new ArrayList<CompatibilityIssue>();
        for (CompatibilityIssue issue : issues) {
            if (issue.impact == impact) {
                filtered.add(issue);
            }
        }
        return filtered;
    }

    public boolean hasBreaking() {
        return !issuesOf(CompatibilityLevel.BREAKING).isEmpty();
    }
}
