package saasus.sdk.testlib.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Captures the complete return value of an SDK call, mirroring the Go
 * {@code SDKReturnValue} structure.
 *
 * <p>Serialized field names are snake_case: {@code type}, {@code status_code},
 * {@code status}, {@code http_response}, {@code json_data}, {@code body}, {@code headers}.
 * When a value cannot be observed for a given call style (for example headers under the
 * {@code NORMAL} style) the corresponding member is left empty/null.
 */
public class SdkReturnValue {

    public String type;
    public int statusCode;
    public String status;
    public HttpResponseSnapshot httpResponse;
    public Map<String, Object> jsonData = new LinkedHashMap<String, Object>();
    public String body = "";
    public Map<String, String> headers = new LinkedHashMap<String, String>();

    public SdkReturnValue() {
    }
}
