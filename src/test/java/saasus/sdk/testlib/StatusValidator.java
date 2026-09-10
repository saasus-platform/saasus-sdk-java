package saasus.sdk.testlib;

import java.util.List;

/**
 * Validates an observed HTTP status code against a step's expectation.
 *
 * <p>Resolution order (matching the issue specification):
 * <ol>
 *   <li>if the status code is unset (null/0) the check passes (e.g. NORMAL style);</li>
 *   <li>if {@code allowedStatuses} is non-empty, the code must be one of them;</li>
 *   <li>otherwise if {@code expectedStatus} is set (non-zero), the code must equal it;</li>
 *   <li>otherwise any {@code 2xx} status is accepted.</li>
 * </ol>
 */
public final class StatusValidator {

    private StatusValidator() {
    }

    /** @throws StatusValidationException when the status code violates the expectation. */
    public static void validate(Integer actual, int expectedStatus, List<Integer> allowedStatuses,
                                String stepName, String method) throws StatusValidationException {
        if (actual == null || actual == 0) {
            return; // unset / not observable
        }
        int code = actual;

        if (allowedStatuses != null && !allowedStatuses.isEmpty()) {
            if (!allowedStatuses.contains(code)) {
                throw new StatusValidationException("unexpected status code for step '" + stepName
                        + "' (" + method + "): expected one of " + allowedStatuses + ", got " + code);
            }
            return;
        }

        if (expectedStatus != 0) {
            if (code != expectedStatus) {
                throw new StatusValidationException("unexpected status code for step '" + stepName
                        + "' (" + method + "): expected " + expectedStatus + ", got " + code);
            }
            return;
        }

        if (code < 200 || code >= 300) {
            throw new StatusValidationException("unexpected status code for step '" + stepName
                    + "' (" + method + "): expected 2xx, got " + code);
        }
    }

    /** Non-throwing variant used by tests and reporting. */
    public static boolean isValid(Integer actual, int expectedStatus, List<Integer> allowedStatuses) {
        try {
            validate(actual, expectedStatus, allowedStatuses, "", "");
            return true;
        } catch (StatusValidationException e) {
            return false;
        }
    }
}
