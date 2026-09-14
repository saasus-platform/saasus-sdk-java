package saasus.sdk.testlib.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Captures HTTP response details for a step, mirroring the Go
 * {@code HTTPResponseSnapshot} structure. Serialized with snake_case field names
 * ({@code status_code}, {@code content_length}, {@code trace_id}, ...).
 */
public class HttpResponseSnapshot {

    public int statusCode;
    public String status;
    public Map<String, String> headers = new LinkedHashMap<String, String>();
    public long contentLength;
    /** Omitted when empty ({@code X-Saasus-Trace-Id}). */
    @OmitEmpty
    public String traceId;

    public HttpResponseSnapshot() {
    }
}
