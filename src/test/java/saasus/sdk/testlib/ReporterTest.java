package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReporterTest {

    private StoryResult story(String name, TestStatus status, StepResult... steps) {
        return new StoryResult(name, status, 12, new ArrayList<StepResult>(Arrays.asList(steps)), null, null);
    }

    private StepResult step(String name, TestStatus status, Integer code) {
        return new StepResult(name, "m", CallStyle.NORMAL, status, 5, code, null, null, null, null);
    }

    @Test
    void summaryCountsStoriesAndSteps() {
        CoverageTracker coverage = new CoverageTracker(Arrays.asList("m:NORMAL"));
        Reporter reporter = new Reporter(coverage);
        List<StoryResult> results = Arrays.asList(
                story("a", TestStatus.PASSED, step("s1", TestStatus.PASSED, 200)),
                story("b", TestStatus.FAILED, step("s2", TestStatus.FAILED, 500)));
        String summary = reporter.summary(results);
        assertTrue(summary.contains("Stories: 1/2"));
        assertTrue(summary.contains("Steps: 1/2"));
    }

    @Test
    void jsonReportContainsSummaryAndStories() {
        Reporter reporter = new Reporter(new CoverageTracker(Arrays.asList("m:NORMAL")));
        List<StoryResult> results = Arrays.asList(
                story("a", TestStatus.PASSED, step("s1", TestStatus.PASSED, 200)));
        String json = reporter.exportJson(results);
        assertTrue(json.contains("\"summary\""));
        assertTrue(json.contains("\"total_stories\""));
        assertTrue(json.contains("\"stories\""));
        assertTrue(json.contains("\"call_style\""));
    }

    @Test
    void detailedReportListsSteps() {
        Reporter reporter = new Reporter(new CoverageTracker(Arrays.asList("m:NORMAL")));
        List<StoryResult> results = Arrays.asList(
                story("a", TestStatus.PASSED, step("s1", TestStatus.PASSED, 200)));
        String detailed = reporter.detailed(results);
        assertTrue(detailed.contains("s1"));
        assertTrue(detailed.contains("[PASS]"));
    }

    private StepResult failedStep(String name, String errorMessage) {
        return new StepResult(name, "m", CallStyle.NORMAL, TestStatus.FAILED, 5, 500, null, null,
                new RuntimeException(errorMessage), null);
    }

    @Test
    void jsonReportMasksSecretsInStepErrors() {
        Reporter reporter = new Reporter(new CoverageTracker(Arrays.asList("m:NORMAL")));
        List<StoryResult> results = Arrays.asList(
                story("a", TestStatus.FAILED,
                        failedStep("s1", "body {\"api_key\":\"supersecretlongapikeyvalue\"}")));
        String json = reporter.exportJson(results);
        assertFalse(json.contains("supersecretlongapikeyvalue"));
    }

    @Test
    void detailedReportMasksSecretsInStepErrors() {
        Reporter reporter = new Reporter(new CoverageTracker(Arrays.asList("m:NORMAL")));
        List<StoryResult> results = Arrays.asList(
                story("a", TestStatus.FAILED,
                        failedStep("s1", "body {\"api_key\":\"supersecretlongapikeyvalue\"}")));
        String detailed = reporter.detailed(results);
        assertFalse(detailed.contains("supersecretlongapikeyvalue"));
    }
}
