package saasus.sdk.testlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Outcome of executing a whole story.
 */
public class StoryResult {

    public final String storyName;
    public final TestStatus status;
    public final long durationMillis;
    public final List<StepResult> steps;
    public final Throwable error;
    public final Map<String, Object> variables;

    public StoryResult(String storyName, TestStatus status, long durationMillis,
                       List<StepResult> steps, Throwable error, Map<String, Object> variables) {
        this.storyName = storyName;
        this.status = status;
        this.durationMillis = durationMillis;
        this.steps = steps == null ? new ArrayList<StepResult>() : steps;
        this.error = error;
        this.variables = variables;
    }

    public boolean isSuccess() {
        return status == TestStatus.PASSED;
    }

    /**
     * Returns a copy of this result marked as {@link TestStatus#FAILED} with the given error,
     * preserving the steps, timing and variables. Used when a post-execution observer (such as
     * the snapshot engine on a breaking change) forces the story to fail.
     */
    public StoryResult asFailed(Throwable failure) {
        return new StoryResult(storyName, TestStatus.FAILED, durationMillis, steps,
                error != null ? error : failure, variables);
    }

    public int passedSteps() {
        int count = 0;
        for (StepResult s : steps) {
            if (s.status == TestStatus.PASSED) {
                count++;
            }
        }
        return count;
    }
}
