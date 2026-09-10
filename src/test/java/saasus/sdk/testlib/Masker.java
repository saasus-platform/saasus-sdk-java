package saasus.sdk.testlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Recursively masks sensitive information (API keys, secrets, tokens, passwords, ...)
 * in arbitrary data structures (maps, lists, strings).
 *
 * <p>A value is masked when either its key looks sensitive, or the value itself looks
 * like a secret (JWT, or a long alphanumeric string).
 */
public class Masker {

    private static final List<String> DEFAULT_SENSITIVE_KEYS = Arrays.asList(
            "apikey", "secret", "secretkey", "password", "passwd", "pwd",
            "token", "accesstoken", "refreshtoken", "idtoken",
            "authorization", "auth", "signature", "credential", "clientsecret",
            "stripekey", "stripesecret", "saasusapikey", "saasussecretkey");

    // Unanchored variants used to mask secrets embedded inside free-form text such as an
    // exception message (which, for generated ApiExceptions, can include the full HTTP
    // response body and headers).
    private static final Pattern JWT_INLINE =
            Pattern.compile("eyJ[A-Za-z0-9_-]+\\.[A-Za-z0-9_-]+\\.[A-Za-z0-9_-]*");
    private static final Pattern LONG_TOKEN_INLINE = Pattern.compile("[A-Za-z0-9]{32,}");
    // Sensitive "key": "value" / key=value pairs (JSON bodies, headers, query strings).
    // The unquoted value runs to the next structural delimiter so a full header value such
    // as "Bearer sk_live_..." (scheme + credential, with spaces) is captured and masked.
    private static final Pattern SENSITIVE_KV = Pattern.compile(
            "(?i)([\"']?[A-Za-z0-9_-]*"
            + "(?:api[_-]?key|secret|token|password|passwd|pwd|authorization|auth|credential|signature|cookie)"
            + "[A-Za-z0-9_-]*[\"']?\\s*[:=]\\s*)(\"[^\"]*\"|'[^']*'|[^,;&}\\r\\n]+)");

    private final List<String> sensitiveKeys;

    public Masker() {
        this.sensitiveKeys = new ArrayList<String>(DEFAULT_SENSITIVE_KEYS);
    }

    /** Adds extra normalized sensitive-key fragments (matched as substrings). */
    public Masker(List<String> extraKeys) {
        this();
        if (extraKeys != null) {
            for (String k : extraKeys) {
                if (k != null) {
                    sensitiveKeys.add(normalize(k));
                }
            }
        }
    }

    /** Returns a masked deep copy of {@code data}. Maps and lists are recreated. */
    @SuppressWarnings("unchecked")
    public Object mask(Object data) {
        if (data == null) {
            return null;
        }
        if (data instanceof Map) {
            Map<Object, Object> src = (Map<Object, Object>) data;
            Map<Object, Object> out = new LinkedHashMap<Object, Object>();
            for (Map.Entry<Object, Object> entry : src.entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String && isSensitiveKey((String) key)) {
                    out.put(key, maskValue(entry.getValue()));
                } else {
                    out.put(key, mask(entry.getValue()));
                }
            }
            return out;
        }
        if (data instanceof Iterable) {
            List<Object> out = new ArrayList<Object>();
            for (Object item : (Iterable<Object>) data) {
                out.add(mask(item));
            }
            return out;
        }
        if (data instanceof String) {
            // Use the inline-aware masker so secrets embedded within a free-form string
            // (e.g. a JSON error body under a non-sensitive key) are also redacted.
            return maskText((String) data);
        }
        return data;
    }

    /** Masks a value regardless of its key (used when the key is sensitive). */
    public Object maskValue(Object value) {
        if (!(value instanceof String)) {
            return "***MASKED***";
        }
        return maskSecret((String) value);
    }

    public boolean isSensitiveKey(String key) {
        String normalized = normalize(key);
        for (String sk : sensitiveKeys) {
            if (normalized.contains(sk)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Masks secret-like content embedded anywhere within a free-form text value (for
     * example an exception message that inlines an HTTP response body or headers).
     * Masks sensitive {@code key:value} / {@code key=value} pairs, JWTs and long tokens.
     * Returns {@code null}/empty inputs unchanged.
     */
    public String maskText(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        String result = maskKeyValues(text);
        result = maskPattern(result, JWT_INLINE);
        result = maskPattern(result, LONG_TOKEN_INLINE);
        return result;
    }

    private String maskKeyValues(String text) {
        Matcher m = SENSITIVE_KV.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String prefix = m.group(1);
            String value = m.group(2);
            String maskedValue;
            if (value.length() >= 2
                    && (value.charAt(0) == '"' || value.charAt(0) == '\'')
                    && value.charAt(value.length() - 1) == value.charAt(0)) {
                char q = value.charAt(0);
                maskedValue = q + maskSecret(value.substring(1, value.length() - 1)) + q;
            } else {
                maskedValue = maskSecret(value);
            }
            m.appendReplacement(sb, Matcher.quoteReplacement(prefix + maskedValue));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private String maskPattern(String text, Pattern pattern) {
        Matcher m = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, Matcher.quoteReplacement(maskSecret(m.group())));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private String maskSecret(String value) {
        if (value.length() <= 8) {
            return "***";
        }
        return value.substring(0, 4) + "..." + value.substring(value.length() - 4);
    }

    private static String normalize(String key) {
        return key.toLowerCase(Locale.ROOT).replace("_", "").replace("-", "");
    }
}
