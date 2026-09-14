package saasus.sdk.testlib;

import java.util.List;
import java.util.Map;

/**
 * Outcome of a single executed step, including the (masked at report time) response so
 * downstream consumers such as the snapshot engine can capture it.
 */
public class StepResult {

    public final String stepName;
    public final String method;
    public final CallStyle callStyle;
    public final TestStatus status;
    public final long durationMillis;
    public final Integer statusCode; // null = unobserved
    public final Map<String, List<String>> headers; // null = unobserved
    public final Object response;
    public final Throwable error;
    public final String skipReason;

    public StepResult(String stepName, String method, CallStyle callStyle, TestStatus status,
                      long durationMillis, Integer statusCode, Map<String, List<String>> headers,
                      Object response, Throwable error, String skipReason) {
        this.stepName = stepName;
        this.method = method;
        this.callStyle = callStyle;
        this.status = status;
        this.durationMillis = durationMillis;
        this.statusCode = statusCode;
        this.headers = headers;
        this.response = response;
        this.error = error;
        this.skipReason = skipReason;
    }

    public boolean isSuccess() {
        return status == TestStatus.PASSED;
    }
}
