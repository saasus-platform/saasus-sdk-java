package saasus.sdk.testlib;

/**
 * A single recorded method execution, used for coverage statistics.
 */
public class MethodExecution {

    public final String method;
    public final CallStyle callStyle;
    public final String storyName;
    public final String stepName;
    public final int statusCode;
    public final long durationMillis;
    public final boolean success;
    public final String error;
    public final long timestamp;

    public MethodExecution(String method, CallStyle callStyle, String storyName, String stepName,
                           int statusCode, long durationMillis, boolean success, String error) {
        this.method = method;
        this.callStyle = callStyle;
        this.storyName = storyName;
        this.stepName = stepName;
        this.statusCode = statusCode;
        this.durationMillis = durationMillis;
        this.success = success;
        this.error = error;
        this.timestamp = System.currentTimeMillis();
    }
}
