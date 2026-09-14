package saasus.sdk.testlib.snapshot;

import saasus.sdk.testlib.Masker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Masks sensitive values in captured snapshot data, matching the Go implementation.
 *
 * <p>Masking is <b>key-based</b>: a value is redacted only when its key contains one of the
 * sensitive substrings (e.g. {@code secret}, {@code token}, {@code api_key}). Redacted string
 * values are replaced with {@code [MASKED len=N]} (N = original length); non-string values with
 * {@code [MASKED]}. Unlike the previous implementation this masker does <b>not</b> substitute
 * dynamic fields (ids, timestamps, ...) with a placeholder — real values are preserved, and the
 * per-git-tag file layout keeps runs distinct.
 *
 * <p>String values that are themselves serialized JSON (for example apilog's {@code response_body}
 * / {@code request_body}, which embed a whole JSON document that may nest several levels deep) are
 * parsed and masked recursively so sensitive keys buried inside them are redacted too. This
 * intentionally diverges from the Go implementation, which leaves nested body strings verbatim.
 */
public class SnapshotMasker {

    /** Sensitive key substrings (case-insensitive), matching Go's {@code sensitiveKeySubstrings}. */
    private static final List<String> SENSITIVE_KEY_SUBSTRINGS = Arrays.asList(
            "secret", "password", "token", "credential", "api_key", "api-key",
            "secret_key", "secret-key", "saasus_secret", "saasus_api_key",
            "stripe_key", "stripe_secret", "access_key", "access-key",
            "client_secret", "client-secret", "refresh_token", "refresh-token",
            "set-cookie", "cookie", "authorization", "proxy-authorization", "x-api-key");

    /**
     * Matches the credential-bearing query parameters of an AWS SigV4 presigned URL
     * ({@code X-Amz-Credential}, {@code X-Amz-Signature}, {@code X-Amz-Security-Token}). These
     * appear verbatim inside otherwise non-sensitive fields such as {@code icon} / {@code favicon}
     * / {@code *_template_url} (presigned S3 links), embedding a temporary AWS access key,
     * session token and request signature. They are dynamic and secret-shaped, so we redact the
     * value while keeping the parameter name and the rest of the URL. The value runs to the next
     * query delimiter ({@code &}), quote, backslash or whitespace.
     */
    private static final Pattern PRESIGNED_CREDENTIAL = Pattern.compile(
            "(?i)(X-Amz-(?:Credential|Signature|Security-Token)=)[^&\"'\\\\\\s]+");

    private final Masker text = new Masker();

    public SnapshotMasker() {
    }

    /**
     * Redacts the credential-bearing query parameters of any AWS presigned URL embedded in a
     * free-form string value. Non-URL strings are returned unchanged.
     */
    static String redactPresignedUrl(String value) {
        if (value == null || value.isEmpty() || value.indexOf("X-Amz-") < 0) {
            return value;
        }
        return PRESIGNED_CREDENTIAL.matcher(value).replaceAll("$1[MASKED]");
    }

    public boolean isSensitiveKey(String key) {
        if (key == null) {
            return false;
        }
        String lower = key.toLowerCase(Locale.ROOT);
        for (String keyword : SENSITIVE_KEY_SUBSTRINGS) {
            if (lower.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Masks secret-like content embedded in a free-form text value (for example a failed SDK
     * call's exception message, which may inline an HTTP response body or headers).
     */
    public String processText(String value) {
        return text.maskText(value);
    }

    /** Returns a masked deep copy of a normalized map/list/primitive structure (key-based). */
    @SuppressWarnings("unchecked")
    public Object process(Object data) {
        if (data == null) {
            return null;
        }
        if (data instanceof Map) {
            Map<Object, Object> src = (Map<Object, Object>) data;
            Map<Object, Object> out = new LinkedHashMap<Object, Object>();
            for (Map.Entry<Object, Object> entry : src.entrySet()) {
                Object key = entry.getKey();
                String keyStr = key == null ? null : key.toString();
                if (keyStr != null && isSensitiveKey(keyStr)) {
                    out.put(key, maskValue(entry.getValue()));
                } else {
                    out.put(key, process(entry.getValue()));
                }
            }
            return out;
        }
        if (data instanceof Iterable) {
            List<Object> out = new ArrayList<Object>();
            for (Object item : (Iterable<Object>) data) {
                out.add(process(item));
            }
            return out;
        }
        // A string leaf may itself be serialized JSON (e.g. apilog's response_body / request_body,
        // which embed a full JSON document — potentially several levels deep — that can contain
        // sensitive keys such as api_key). Recurse into it so nested secrets are masked too. This
        // intentionally diverges from Go, which leaves nested body strings verbatim. Any presigned
        // URL embedded in a (non-JSON) string leaf also has its credential params redacted.
        if (data instanceof String) {
            return redactPresignedUrl(maskBodyString((String) data));
        }
        // Other leaves are preserved as-is (masking is key-based, matching Go).
        return data;
    }

    /** Masks a value regardless of its key. Strings become {@code [MASKED len=N]}. */
    public Object maskValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return maskString((String) value);
        }
        return "[MASKED]";
    }

    private static String maskString(String value) {
        if (value.isEmpty()) {
            return "";
        }
        return "[MASKED len=" + value.length() + "]";
    }

    /**
     * Masks a single header value when its key is sensitive; otherwise returns it unchanged.
     */
    public String maskHeaderValue(String key, String value) {
        if (value == null) {
            return "";
        }
        if (isSensitiveKey(key)) {
            Object masked = maskValue(value);
            return masked == null ? "" : masked.toString();
        }
        return value;
    }

    /**
     * Masks a JSON body string: parses it, redacts sensitive keys, and re-serializes it with
     * two-space indentation and sorted keys (matching Go's {@code maskBodyString}). Non-JSON
     * input is returned unchanged.
     */
    public String maskBodyString(String body) {
        if (body == null) {
            return "";
        }
        String trimmed = body.trim();
        if (trimmed.isEmpty()) {
            return body;
        }
        char first = trimmed.charAt(0);
        if (first != '{' && first != '[') {
            return body;
        }
        Object parsed = SnapshotJson.parse(trimmed);
        if (parsed == null) {
            return body;
        }
        String masked = SnapshotJson.prettyBody(process(parsed));
        if (body.endsWith("\n")) {
            return masked + "\n";
        }
        return masked;
    }
}
