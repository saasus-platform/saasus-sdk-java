package saasus.sdk.testlib.snapshot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;

class SnapshotValidatorTest {

    private final SnapshotValidator validator = new SnapshotValidator();

    private StorySnapshot passedStory(StepSnapshot... steps) {
        StorySnapshot s = new StorySnapshot();
        s.storyName = "story";
        s.status = "passed";
        for (StepSnapshot st : steps) {
            s.steps.add(st);
        }
        s.summary.totalSteps = steps.length;
        s.summary.successfulSteps = steps.length;
        s.summary.failedSteps = 0;
        return s;
    }

    private StepSnapshot step(boolean success, int statusCode, SdkReturnValue rv) {
        StepSnapshot st = new StepSnapshot();
        st.stepName = "s";
        st.method = "m";
        st.success = success;
        st.statusCode = statusCode;
        st.status = success ? "passed" : "failed";
        st.returnValue = rv;
        st.timestamp = OffsetDateTime.now().toString();
        return st;
    }

    private SdkReturnValue rv(int statusCode) {
        SdkReturnValue rv = new SdkReturnValue();
        rv.statusCode = statusCode;
        rv.type = "java.util.LinkedHashMap";
        return rv;
    }

    @Test
    void unobservedSuccessfulNormalStepIsValid() {
        // NORMAL call style: the step succeeds but no return value / status code is observable.
        StoryValidation v = validator.validate(passedStory(step(true, 0, null)));
        assertTrue(v.isValid, "successful void NORMAL step should not be flagged as missing/incomplete");
    }

    @Test
    void acceptedNonSuccessStatusIsValid() {
        // e.g. an internal-only endpoint intentionally accepted with a 501 status.
        StoryValidation v = validator.validate(passedStory(step(true, 501, rv(501))));
        assertTrue(v.isValid, "successful step with an accepted non-2xx status should not be flagged");
    }

    @Test
    void observedSuccessfulStepIsValid() {
        StoryValidation v = validator.validate(passedStory(step(true, 200, rv(200))));
        assertTrue(v.isValid);
    }

    @Test
    void failedStepWithNoReturnValueIsFlagged() {
        StoryValidation v = validator.validate(passedStory(step(false, 500, null)));
        assertFalse(v.isValid, "a non-successful step missing its return value should be flagged");
    }
}
