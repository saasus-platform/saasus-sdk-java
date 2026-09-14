package saasus.sdk.testlib.snapshot;

/**
 * Execution summary for a story, mirroring the Go {@code StoryExecutionSummary}.
 * Durations are expressed in nanoseconds to match the Go {@code time.Duration} encoding.
 */
public class StoryExecutionSummary {

    public int totalSteps;
    public int successfulSteps;
    public int failedSteps;
    public int skippedSteps;
    public long totalDuration;
    public long averageStepDuration;

    public StoryExecutionSummary() {
    }
}
