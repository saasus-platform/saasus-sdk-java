package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MaskerTest {

    private final Masker masker = new Masker();

    @Test
    void masksSensitiveKeys() {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("api_key", "supersecretapikey12345");
        data.put("name", "public-name");
        @SuppressWarnings("unchecked")
        Map<Object, Object> masked = (Map<Object, Object>) masker.mask(data);
        assertEquals("supe...2345", masked.get("api_key"));
        assertEquals("public-name", masked.get("name"));
    }

    @Test
    void masksShortSensitiveValueWithStars() {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("secret", "short");
        @SuppressWarnings("unchecked")
        Map<Object, Object> masked = (Map<Object, Object>) masker.mask(data);
        assertEquals("***", masked.get("secret"));
    }

    @Test
    void masksNestedStructures() {
        Map<String, Object> inner = new LinkedHashMap<String, Object>();
        inner.put("password", "verylongpasswordvalue");
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("user", inner);
        data.put("tokens", Arrays.asList("plain", "token"));
        @SuppressWarnings("unchecked")
        Map<Object, Object> masked = (Map<Object, Object>) masker.mask(data);
        @SuppressWarnings("unchecked")
        Map<Object, Object> maskedInner = (Map<Object, Object>) masked.get("user");
        assertEquals("very...alue", maskedInner.get("password"));
    }

    @Test
    void masksJwtLikeStringByValue() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0In0.abcDEF123456";
        Object masked = masker.mask(jwt);
        assertTrue(masked.toString().contains("..."));
        assertTrue(!masked.equals(jwt));
    }

    @Test
    void leavesPlainStringUnchanged() {
        assertEquals("hello", masker.mask("hello"));
    }

    @Test
    void masksSecretEmbeddedInNonSensitiveKeyStringValue() {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        // Non-sensitive key ("body"), but the value inlines a credential.
        data.put("body", "{\"api_key\":\"supersecretlongapikeyvalue\"}");
        @SuppressWarnings("unchecked")
        Map<Object, Object> masked = (Map<Object, Object>) masker.mask(data);
        assertFalse(masked.get("body").toString().contains("supersecretlongapikeyvalue"));
    }

    @Test
    void detectsSensitiveKeyVariants() {
        assertTrue(masker.isSensitiveKey("SAASUS_API_KEY"));
        assertTrue(masker.isSensitiveKey("secret-key"));
        assertTrue(masker.isSensitiveKey("accessToken"));
    }

    @Test
    void detectsSensitiveKeysUnderTurkishLocale() {
        java.util.Locale original = java.util.Locale.getDefault();
        try {
            java.util.Locale.setDefault(new java.util.Locale("tr", "TR"));
            // Locale-sensitive lowercasing would otherwise turn "API_KEY" into "apı_key".
            assertTrue(new Masker().isSensitiveKey("API_KEY"));
        } finally {
            java.util.Locale.setDefault(original);
        }
    }

    @Test
    void maskTextMasksSensitiveKeyValuesInBody() {
        String body = "response body: {\"api_key\":\"supersecretlongapikeyvalue\",\"message\":\"bad request\"}";
        String masked = masker.maskText(body);
        assertFalse(masked.contains("supersecretlongapikeyvalue"));
        assertTrue(masked.contains("bad request")); // non-sensitive content preserved
    }

    @Test
    void maskTextMasksInlineJwtAndLongTokens() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0In0.abcDEF123456";
        String longToken = "abcdefghijklmnopqrstuvwxyz0123456789";
        String masked = masker.maskText("Authorization header " + jwt + " token " + longToken + " done");
        assertFalse(masked.contains(jwt));
        assertFalse(masked.contains(longToken));
        assertTrue(masked.contains("done"));
    }

    @Test
    void maskTextLeavesNonSensitiveTextUnchanged() {
        assertEquals("plain error message", masker.maskText("plain error message"));
    }

    @Test
    void maskTextMasksBearerCredentialAfterScheme() {
        String masked = masker.maskText("Authorization: Bearer sk_live_SECRETCREDENTIAL9");
        assertFalse(masked.contains("sk_live_SECRETCREDENTIAL9"));
        assertFalse(masked.contains("SECRETCREDENTIAL"));
    }
}
