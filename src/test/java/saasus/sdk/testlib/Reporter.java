package saasus.sdk.testlib;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Produces human-readable summaries and a machine-readable JSON report from story results
 * and coverage statistics.
 */
public class Reporter {

    private final CoverageTracker coverage;
    private final Masker masker = new Masker();

    public Reporter(CoverageTracker coverage) {
        this.coverage = coverage;
    }

    public String summary(List<StoryResult> results) {
        int totalStories = results.size();
        int passedStories = 0;
        int totalSteps = 0;
        int passedSteps = 0;
        long totalDuration = 0;
        for (StoryResult r : results) {
            if (r.status == TestStatus.PASSED) {
                passedStories++;
            }
            totalSteps += r.steps.size();
            passedSteps += r.passedSteps();
            totalDuration += r.durationMillis;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nTest Execution Summary:\n");
        sb.append(String.format("Stories: %d/%d passed (%.1f%%)%n",
                passedStories, totalStories, percentage(passedStories, totalStories)));
        sb.append(String.format("Steps: %d/%d passed (%.1f%%)%n",
                passedSteps, totalSteps, percentage(passedSteps, totalSteps)));
        if (coverage != null) {
            sb.append(String.format("Method Coverage: %d/%d (%.1f%%)%n",
                    coverage.coveredCount(), coverage.totalCount(), coverage.coveragePercentage()));
        }
        sb.append("Execution Time: ").append(totalDuration).append("ms\n");
        return sb.toString();
    }

    public String detailed(List<StoryResult> results) {
        StringBuilder sb = new StringBuilder();
        sb.append(repeat('=', 80)).append("\n");
        sb.append("DETAILED TEST EXECUTION REPORT\n");
        sb.append(repeat('=', 80)).append("\n");
        for (StoryResult r : results) {
            sb.append(icon(r.status)).append(" ").append(r.storyName)
                    .append(" (").append(r.durationMillis).append("ms)\n");
            if (r.error != null) {
                sb.append("   Error: ").append(masker.maskText(r.error.getMessage())).append("\n");
            }
            int i = 1;
            for (StepResult s : r.steps) {
                sb.append("   ").append(i++).append(". ").append(icon(s.status)).append(" ")
                        .append(s.stepName).append(" -> ").append(s.method)
                        .append(" [").append(s.callStyle).append("]")
                        .append(" (").append(s.statusCode == null ? "-" : s.statusCode).append(") ")
                        .append(s.durationMillis).append("ms\n");
                if (s.error != null) {
                    sb.append("      Error: ").append(masker.maskText(s.error.getMessage())).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /** Builds a report object suitable for JSON serialization. */
    public Map<String, Object> reportObject(List<StoryResult> results) {
        Map<String, Object> report = new LinkedHashMap<String, Object>();
        report.put("timestamp", System.currentTimeMillis());

        int passedStories = 0;
        int totalSteps = 0;
        int passedSteps = 0;
        for (StoryResult r : results) {
            if (r.status == TestStatus.PASSED) {
                passedStories++;
            }
            totalSteps += r.steps.size();
            passedSteps += r.passedSteps();
        }

        Map<String, Object> summary = new LinkedHashMap<String, Object>();
        summary.put("total_stories", results.size());
        summary.put("passed_stories", passedStories);
        summary.put("total_steps", totalSteps);
        summary.put("passed_steps", passedSteps);
        if (coverage != null) {
            summary.put("covered_methods", coverage.coveredCount());
            summary.put("total_methods", coverage.totalCount());
            summary.put("coverage_percentage", coverage.coveragePercentage());
        }
        report.put("summary", summary);

        List<Map<String, Object>> stories = new ArrayList<Map<String, Object>>();
        for (StoryResult r : results) {
            Map<String, Object> story = new LinkedHashMap<String, Object>();
            story.put("name", r.storyName);
            story.put("status", r.status.label());
            story.put("duration_ms", r.durationMillis);
            if (r.error != null) {
                story.put("error", masker.maskText(r.error.getMessage()));
            }
            List<Map<String, Object>> steps = new ArrayList<Map<String, Object>>();
            for (StepResult s : r.steps) {
                Map<String, Object> step = new LinkedHashMap<String, Object>();
                step.put("name", s.stepName);
                step.put("method", s.method);
                step.put("call_style", s.callStyle.name());
                step.put("status", s.status.label());
                step.put("status_code", s.statusCode);
                step.put("duration_ms", s.durationMillis);
                if (s.error != null) {
                    step.put("error", masker.maskText(s.error.getMessage()));
                }
                if (s.skipReason != null && !s.skipReason.isEmpty()) {
                    step.put("skip_reason", s.skipReason);
                }
                steps.add(step);
            }
            story.put("steps", steps);
            stories.add(story);
        }
        report.put("stories", stories);
        if (coverage != null) {
            report.put("untested_methods", coverage.untestedKeys());
        }
        return report;
    }

    public String exportJson(List<StoryResult> results) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(reportObject(results));
    }

    private static double percentage(int part, int total) {
        return total == 0 ? 0.0 : (part * 100.0) / total;
    }

    private static String icon(TestStatus status) {
        switch (status) {
            case PASSED:
                return "[PASS]";
            case FAILED:
                return "[FAIL]";
            case SKIPPED:
                return "[SKIP]";
            default:
                return "[????]";
        }
    }

    private static String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
