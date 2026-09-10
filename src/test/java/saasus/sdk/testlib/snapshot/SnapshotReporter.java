package saasus.sdk.testlib.snapshot;

import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Renders a {@link ComparisonResult} as console text, JSON, or Markdown.
 */
public class SnapshotReporter {

    public String console(ComparisonResult result, String storyName) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(repeat('=', 60)).append("\n");
        sb.append("SNAPSHOT COMPARISON: ").append(storyName).append("\n");
        sb.append(repeat('=', 60)).append("\n");
        sb.append("Status: ").append(result.compatible ? "COMPATIBLE" : "INCOMPATIBLE").append("\n");
        sb.append("Level: ").append(result.level.label()).append("\n");
        sb.append("Summary: ").append(result.summary).append("\n");

        List<CompatibilityIssue> breaking = result.issuesOf(CompatibilityLevel.BREAKING);
        List<CompatibilityIssue> warnings = result.issuesOf(CompatibilityLevel.WARNING);
        if (!breaking.isEmpty()) {
            sb.append("\n  Breaking changes:\n");
            for (CompatibilityIssue issue : breaking) {
                sb.append("    - ").append(issue.description).append("\n");
            }
        }
        if (!warnings.isEmpty()) {
            sb.append("\n  Warnings:\n");
            for (CompatibilityIssue issue : warnings) {
                sb.append("    - ").append(issue.description).append("\n");
            }
        }
        sb.append(repeat('=', 60)).append("\n");
        return sb.toString();
    }

    public String json(ComparisonResult result) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(result);
    }

    public String markdown(ComparisonResult result, String storyName) {
        StringBuilder sb = new StringBuilder();
        sb.append("# Snapshot Comparison: ").append(storyName).append("\n\n");
        sb.append("**Status:** ").append(result.compatible ? "Compatible" : "Incompatible").append("\n\n");
        sb.append("**Level:** ").append(result.level.label()).append("\n\n");
        sb.append("**Summary:** ").append(result.summary).append("\n\n");

        List<CompatibilityIssue> breaking = result.issuesOf(CompatibilityLevel.BREAKING);
        List<CompatibilityIssue> warnings = result.issuesOf(CompatibilityLevel.WARNING);
        if (!breaking.isEmpty()) {
            sb.append("## Breaking Changes\n\n");
            for (CompatibilityIssue issue : breaking) {
                sb.append("- ").append(issue.description).append("\n");
            }
            sb.append("\n");
        }
        if (!warnings.isEmpty()) {
            sb.append("## Warnings\n\n");
            for (CompatibilityIssue issue : warnings) {
                sb.append("- ").append(issue.description).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
