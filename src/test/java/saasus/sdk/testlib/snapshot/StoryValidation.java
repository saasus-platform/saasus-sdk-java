package saasus.sdk.testlib.snapshot;

import java.util.List;

/**
 * Validation result for a story snapshot, mirroring the Go {@code StoryValidation}.
 *
 * <p>The three error lists are left {@code null} (rather than empty) when no issue is
 * found, matching the Go encoding which emits {@code null} for empty error slices.
 */
public class StoryValidation {

    // Completion status values (match Go CompletionStatus).
    public static final String STATUS_COMPLETE = "complete";
    public static final String STATUS_INCOMPLETE = "incomplete";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_PARTIAL = "partial";

    public String storyName;
    /** RFC 3339 timestamp. */
    public String validationTime;
    public boolean isValid = true;
    public String completionStatus;
    public List<ValidationError> sequenceErrors;
    public List<ValidationError> stateTransitionErrors;
    public List<ValidationError> timingErrors;
    /** Omitted when empty. */
    @OmitEmpty
    public List<SkippedStepInfo> skippedSteps;
    /** Omitted when empty. */
    @OmitEmpty
    public ValidationComparison comparison;
    public ValidationSummary summary = new ValidationSummary();

    public StoryValidation() {
    }
}
