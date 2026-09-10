package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class StatusValidatorTest {

    @Test
    void unsetStatusAlwaysPasses() {
        assertTrue(StatusValidator.isValid(null, 200, null));
        assertTrue(StatusValidator.isValid(0, 200, null));
    }

    @Test
    void allowedStatusesTakePriority() {
        assertTrue(StatusValidator.isValid(404, 200, Arrays.asList(200, 404)));
        assertFalse(StatusValidator.isValid(500, 200, Arrays.asList(200, 404)));
    }

    @Test
    void expectedStatusChecked() {
        assertTrue(StatusValidator.isValid(201, 201, Collections.<Integer>emptyList()));
        assertFalse(StatusValidator.isValid(200, 201, Collections.<Integer>emptyList()));
    }

    @Test
    void defaultsToTwoXxWhenNoExpectation() {
        assertTrue(StatusValidator.isValid(200, 0, null));
        assertTrue(StatusValidator.isValid(299, 0, null));
        assertFalse(StatusValidator.isValid(300, 0, null));
        assertFalse(StatusValidator.isValid(404, 0, null));
    }
}
