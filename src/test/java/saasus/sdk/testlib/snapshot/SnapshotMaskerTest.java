package saasus.sdk.testlib.snapshot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SnapshotMaskerTest {

    private final SnapshotMasker masker = new SnapshotMasker();

    private Map<String, Object> sample() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("id", "dynamic-123");
        m.put("api_key", "supersecretlongapikey");
        m.put("name", "stable");
        return m;
    }

    @Test
    @SuppressWarnings("unchecked")
    void masksSensitiveValuesWithLengthPlaceholder() {
        Map<Object, Object> result = (Map<Object, Object>) masker.process(sample());
        assertEquals("[MASKED len=" + "supersecretlongapikey".length() + "]", result.get("api_key"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void preservesDynamicAndNonSensitiveValues() {
        // Unlike the previous implementation, dynamic values are kept verbatim (no <DYNAMIC>).
        Map<Object, Object> result = (Map<Object, Object>) masker.process(sample());
        assertEquals("dynamic-123", result.get("id"));
        assertEquals("stable", result.get("name"));
    }

    @Test
    void maskBodyStringMasksSensitiveKeysAndReindents() {
        String body = "{\"api_key\":\"supersecretlongapikey\",\"name\":\"stable\"}";
        String masked = masker.maskBodyString(body);
        assertFalse(masked.contains("supersecretlongapikey"));
        assertTrue(masked.contains("[MASKED len=" + "supersecretlongapikey".length() + "]"));
        // Re-indented (pretty) output spans multiple lines.
        assertTrue(masked.contains("\n"));
    }

    @Test
    void maskBodyStringLeavesNonJsonUnchanged() {
        assertEquals("not json", masker.maskBodyString("not json"));
    }

    @Test
    void maskBodyStringMasksSecretsNestedInsideStringifiedBody() {
        // apilog's response_body is a JSON *string* embedded in the outer document, and can itself
        // wrap another stringified body. Secrets at any depth must be masked.
        String inner = "{\"api_key\":\"deadbeefdeadbeefdeadbeef\",\"created_at\":1763529623}";
        String outer = "{\"response_body\":" + gsonString(inner) + ",\"saas_id\":\"keep-me\"}";
        String masked = masker.maskBodyString(outer);
        assertFalse(masked.contains("deadbeefdeadbeefdeadbeef"), "nested api_key must be masked");
        assertTrue(masked.contains("[MASKED len=" + "deadbeefdeadbeefdeadbeef".length() + "]"));
        // Non-sensitive values are preserved.
        assertTrue(masked.contains("keep-me"));
        // Integral numbers stay integers (no scientific notation).
        assertTrue(masked.contains("1763529623"), "timestamp must stay an integer");
        assertFalse(masked.contains("1.763529623E9"), "no scientific notation");
    }

    @Test
    @SuppressWarnings("unchecked")
    void processMasksSecretsInStringifiedJsonLeaf() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("response_body", "{\"api_key\":\"supersecretlongapikey\"}");
        m.put("id", "dynamic-123");
        Map<Object, Object> result = (Map<Object, Object>) masker.process(m);
        String body = String.valueOf(result.get("response_body"));
        assertFalse(body.contains("supersecretlongapikey"));
        assertTrue(body.contains("[MASKED len=" + "supersecretlongapikey".length() + "]"));
        assertEquals("dynamic-123", result.get("id"));
    }

    /** Serializes a string as a JSON string literal (with surrounding quotes and escaping). */
    private static String gsonString(String value) {
        return SnapshotJson.PLAIN.toJson(value);
    }

    @Test
    void maskHeaderValueMasksOnlySensitiveHeaders() {
        assertEquals("application/json", masker.maskHeaderValue("Content-Type", "application/json"));
        assertEquals("[MASKED len=5]", masker.maskHeaderValue("Authorization", "abcde"));
    }

    @Test
    void isSensitiveKeyMatchesSubstrings() {
        assertTrue(masker.isSensitiveKey("api_key"));
        assertTrue(masker.isSensitiveKey("X-Api-Key"));
        assertTrue(masker.isSensitiveKey("client_secret"));
        assertFalse(masker.isSensitiveKey("name"));
    }

    private static final String PRESIGNED_URL =
            "https://bucket.s3.amazonaws.com/assets/logo?X-Amz-Algorithm=AWS4-HMAC-SHA256"
            + "&X-Amz-Credential=EXAMPLE0CRED0VALUE%2F20260806%2Fap-northeast-1%2Fs3%2Faws4_request"
            + "&X-Amz-Date=20260806T075715Z&X-Amz-Expires=300"
            + "&X-Amz-Security-Token=EXAMPLE0SESSION0TOKEN%2Bvalue%3D"
            + "&X-Amz-SignedHeaders=host"
            + "&X-Amz-Signature=abcdef0123456789abcdef0123456789abcdef0123456789abcdef0123456789";

    @Test
    @SuppressWarnings("unchecked")
    void masksPresignedUrlCredentialsInStringLeaf() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("icon", PRESIGNED_URL);
        Map<Object, Object> result = (Map<Object, Object>) masker.process(m);
        String icon = String.valueOf(result.get("icon"));
        // Credential-bearing params are redacted...
        assertFalse(icon.contains("EXAMPLE0CRED0VALUE"), "temp access key must be masked");
        assertFalse(icon.contains("EXAMPLE0SESSION0TOKEN"), "session token must be masked");
        assertFalse(icon.contains("abcdef0123456789abcdef0123456789"), "signature must be masked");
        assertTrue(icon.contains("X-Amz-Credential=[MASKED]"));
        assertTrue(icon.contains("X-Amz-Security-Token=[MASKED]"));
        assertTrue(icon.contains("X-Amz-Signature=[MASKED]"));
        // ...non-credential params and the URL structure are preserved.
        assertTrue(icon.contains("X-Amz-Algorithm=AWS4-HMAC-SHA256"));
        assertTrue(icon.contains("X-Amz-Date=20260806T075715Z"));
        assertTrue(icon.startsWith("https://bucket.s3.amazonaws.com/assets/logo?"));
    }

    @Test
    void masksPresignedUrlCredentialsNestedInStringifiedBody() {
        String body = "{\"favicon\":" + gsonString(PRESIGNED_URL) + ",\"title\":\"keep\"}";
        String masked = masker.maskBodyString(body);
        assertFalse(masked.contains("EXAMPLE0CRED0VALUE"));
        assertFalse(masked.contains("abcdef0123456789abcdef0123456789"));
        assertTrue(masked.contains("X-Amz-Signature=[MASKED]"));
        assertTrue(masked.contains("keep"));
    }
}
