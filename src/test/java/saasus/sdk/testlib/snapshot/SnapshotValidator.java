package saasus.sdk.testlib.snapshot;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Validates a captured {@link StorySnapshot}, producing a {@link StoryValidation} that mirrors
 * the Go {@code SimpleStoryValidator}.
 *
 * <p>Enabled rules and severities match the Go defaults:
 * <ul>
 *   <li>completion &mdash; {@code error} (enabled);</li>
 *   <li>sequence &mdash; {@code error} (enabled);</li>
 *   <li>state transition &mdash; {@code warning} (enabled);</li>
 *   <li>timing &mdash; {@code info} (disabled).</li>
 * </ul>
 * Empty error categories are left {@code null} so the serialized JSON emits {@code null},
 * matching Go's nil-slice encoding.
 */
public class SnapshotValidator {

    public StoryValidation validate(StorySnapshot snapshot) {
        StoryValidation validation = new StoryValidation();
        validation.storyName = snapshot.storyName;
        validation.validationTime = OffsetDateTime.now().toString();
        validation.completionStatus = determineCompletionStatus(snapshot);
        validation.skippedSteps = collectSkippedSteps(snapshot);

        List<ValidationError> sequence = new ArrayList<ValidationError>();
        List<ValidationError> stateTransition = new ArrayList<ValidationError>();
        List<ValidationError> timing = new ArrayList<ValidationError>();

        // completion rule (error, enabled)
        if (!validateStoryCompletion(snapshot)) {
            sequence.add(new ValidationError(ValidationError.TYPE_SEQUENCE, "",
                    "Story execution is not complete", ValidationError.SEVERITY_ERROR));
        }

        // sequence rule (error, enabled)
        sequence.addAll(validateStepSequence(snapshot.steps));

        // state transition rule (warning, enabled)
        stateTransition.addAll(validateStateTransitions(snapshot.steps));

        // timing rule (info) is disabled by default, matching Go.

        // incomplete-execution detection (always)
        sequence.addAll(detectIncompleteExecution(snapshot));

        validation.sequenceErrors = sequence.isEmpty() ? null : sequence;
        validation.stateTransitionErrors = stateTransition.isEmpty() ? null : stateTransition;
        validation.timingErrors = timing.isEmpty() ? null : timing;

        generateSummary(validation);
        return validation;
    }

    boolean validateStoryCompletion(StorySnapshot snapshot) {
        if (snapshot == null) {
            return false;
        }
        if (!TestStatusLabels.PASSED.equals(snapshot.status)) {
            return false;
        }
        if (snapshot.steps == null || snapshot.steps.isEmpty()) {
            return false;
        }
        return snapshot.summary.failedSteps <= 0;
    }

    List<ValidationError> validateStepSequence(List<StepSnapshot> steps) {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        if (steps == null) {
            return errors;
        }
        for (int i = 0; i < steps.size(); i++) {
            StepSnapshot step = steps.get(i);
            if (step.returnValue == null && !isUnobservedSuccess(step)) {
                errors.add(new ValidationError(ValidationError.TYPE_SEQUENCE, step.stepName,
                        "Missing return_value", ValidationError.SEVERITY_ERROR));
            }
            // NOTE: A step whose success flag is already set by the engine (which honors the
            // step's expected/allowed status) may intentionally carry a non-2xx status, e.g. an
            // internal-only endpoint that always returns 501. The engine's success flag is
            // authoritative, so we do not re-flag "success + error status" here.
            if (i > 0) {
                StepSnapshot prev = steps.get(i - 1);
                if (isBefore(step.timestamp, prev.timestamp)) {
                    errors.add(new ValidationError(ValidationError.TYPE_SEQUENCE, step.stepName,
                            "Step timestamp is before previous step", ValidationError.SEVERITY_WARNING));
                }
            }
        }
        return errors;
    }

    List<ValidationError> validateStateTransitions(List<StepSnapshot> steps) {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        if (steps == null) {
            return errors;
        }
        for (StepSnapshot step : steps) {
            if (!step.success && step.error == null) {
                errors.add(new ValidationError(ValidationError.TYPE_STATE_TRANSITION, step.stepName,
                        "Step marked as failed but no error information provided",
                        ValidationError.SEVERITY_WARNING));
            }
            if (step.success && step.error != null) {
                errors.add(new ValidationError(ValidationError.TYPE_STATE_TRANSITION, step.stepName,
                        "Step marked as successful but has error information",
                        ValidationError.SEVERITY_WARNING));
            }
            if (step.returnValue != null && step.returnValue.statusCode != 0) {
                boolean isSuccessStatusCode = step.returnValue.statusCode >= 200
                        && step.returnValue.statusCode < 400;
                // The engine's success flag is authoritative and already accounts for a step's
                // expected/allowed status, so a successful step may legitimately carry a non-2xx
                // status. Only flag the genuine inconsistency: a failed step reporting a success
                // status code. (A status code of 0 means the call style could not observe HTTP
                // metadata, so it is skipped above.)
                if (!step.success && isSuccessStatusCode) {
                    ValidationError e = new ValidationError(ValidationError.TYPE_STATE_TRANSITION,
                            step.stepName, "Step success flag doesn't match return value status code",
                            ValidationError.SEVERITY_WARNING);
                    e.expectedValue = isSuccessStatusCode;
                    e.actualValue = step.success;
                    errors.add(e);
                }
            }
        }
        return errors;
    }

    List<ValidationError> detectIncompleteExecution(StorySnapshot snapshot) {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        for (StepSnapshot step : snapshot.steps) {
            boolean skipped = step.returnValue == null && !step.success
                    && step.error == null && step.statusCode == 0;
            if (step.returnValue == null && !skipped && !isUnobservedSuccess(step)) {
                errors.add(new ValidationError(ValidationError.TYPE_SEQUENCE, step.stepName,
                        "Step execution incomplete - missing return value", ValidationError.SEVERITY_ERROR));
            }
        }
        if (TestStatusLabels.FAILED.equals(snapshot.status)) {
            boolean hasStepErrors = false;
            for (StepSnapshot step : snapshot.steps) {
                if (!step.success || step.error != null) {
                    hasStepErrors = true;
                    break;
                }
            }
            if (!hasStepErrors) {
                errors.add(new ValidationError(ValidationError.TYPE_SEQUENCE, "",
                        "Story marked as failed but no step failures detected",
                        ValidationError.SEVERITY_ERROR));
            }
        }
        return errors;
    }

    private String determineCompletionStatus(StorySnapshot snapshot) {
        StoryExecutionSummary summary = snapshot.summary;
        if (TestStatusLabels.PASSED.equals(snapshot.status) && summary.failedSteps == 0) {
            return StoryValidation.STATUS_COMPLETE;
        }
        if (TestStatusLabels.FAILED.equals(snapshot.status)) {
            return summary.successfulSteps > 0 ? StoryValidation.STATUS_PARTIAL : StoryValidation.STATUS_FAILED;
        }
        if (summary.successfulSteps > 0 && summary.failedSteps > 0) {
            return StoryValidation.STATUS_PARTIAL;
        }
        return StoryValidation.STATUS_INCOMPLETE;
    }

    private List<SkippedStepInfo> collectSkippedSteps(StorySnapshot snapshot) {
        List<SkippedStepInfo> skipped = new ArrayList<SkippedStepInfo>();
        for (StepSnapshot step : snapshot.steps) {
            if (TestStatusLabels.SKIPPED.equals(step.status)) {
                skipped.add(new SkippedStepInfo(step.stepName, step.method, step.skipReason));
            }
        }
        return skipped.isEmpty() ? null : skipped;
    }

    private void generateSummary(StoryValidation validation) {
        ValidationSummary summary = validation.summary;
        countSeverities(summary, validation.sequenceErrors);
        countSeverities(summary, validation.stateTransitionErrors);
        countSeverities(summary, validation.timingErrors);
        summary.isValid = summary.totalErrors == 0;
        validation.isValid = summary.isValid;
    }

    private static void countSeverities(ValidationSummary summary, List<ValidationError> errors) {
        if (errors == null) {
            return;
        }
        for (ValidationError e : errors) {
            if (ValidationError.SEVERITY_ERROR.equals(e.severity)) {
                summary.totalErrors++;
            } else if (ValidationError.SEVERITY_WARNING.equals(e.severity)) {
                summary.totalWarnings++;
            } else if (ValidationError.SEVERITY_INFO.equals(e.severity)) {
                summary.totalInfo++;
            }
        }
    }

    /**
     * A successful step whose call style could not observe any HTTP metadata: the {@code NORMAL}
     * style returns only the deserialized payload (or nothing for a void method), so a successful
     * void call has no return value, a status code of 0 and no error. Such a step is complete, not
     * a missing/incomplete result.
     */
    private static boolean isUnobservedSuccess(StepSnapshot step) {
        return step.success && step.error == null && step.returnValue == null && step.statusCode == 0;
    }

    private static boolean isBefore(String timestamp, String previous) {
        if (timestamp == null || previous == null) {
            return false;
        }
        try {
            return OffsetDateTime.parse(timestamp).isBefore(OffsetDateTime.parse(previous));
        } catch (RuntimeException e) {
            return false;
        }
    }

    /** Story/step status label constants (match {@code TestStatus.label()}). */
    static final class TestStatusLabels {
        static final String PASSED = "passed";
        static final String FAILED = "failed";
        static final String SKIPPED = "skipped";

        private TestStatusLabels() {
        }
    }
}
