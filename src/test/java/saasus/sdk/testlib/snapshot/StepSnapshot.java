package saasus.sdk.testlib.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Captured snapshot of a single step's outcome, mirroring the Go {@code StepSnapshot}.
 *
 * <p>{@link #returnValue} holds the structured, masked SDK return value; {@link #duration}
 * is in nanoseconds and {@link #timestamp} is an RFC 3339 string. Optional members
 * ({@link #skipReason}, {@link #error}, {@link #stateChanges}) are left {@code null} when absent.
 */
public class StepSnapshot {

    public String stepName;
    public String method;
    public Map<String, Object> parameters = new LinkedHashMap<String, Object>();
    public SdkReturnValue returnValue;
    public long duration;
    public int statusCode;
    public boolean success;
    public String status;
    @OmitEmpty
    public String skipReason;
    @OmitEmpty
    public SdkMethodError error;
    public String timestamp;
    @OmitEmpty
    public Map<String, Object> stateChanges;

    public StepSnapshot() {
    }
}
