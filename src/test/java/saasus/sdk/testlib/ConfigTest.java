package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ConfigTest {

    private Map<String, String> baseEnv() {
        Map<String, String> env = new HashMap<String, String>();
        env.put("SAASUS_SAAS_ID", "saas");
        env.put("SAASUS_API_KEY", "apikey");
        env.put("SAASUS_SECRET_KEY", "secret");
        return env;
    }

    @Test
    void readsRequiredCredentials() {
        Config config = new Config(baseEnv(), Collections.<String>emptyList());
        assertEquals("saas", config.saasId);
        assertEquals("apikey", config.apiKey);
        assertEquals("secret", config.secretKey);
        assertTrue(config.isValid());
    }

    @Test
    void validateThrowsWhenMissing() {
        Config config = new Config(new HashMap<String, String>(), Collections.<String>emptyList());
        assertThrows(IllegalStateException.class, config::validate);
        assertFalse(config.isValid());
    }

    @Test
    void e2eLogLevelOverridesLogLevel() {
        Map<String, String> env = baseEnv();
        env.put("LOG_LEVEL", "info");
        env.put("E2E_LOG_LEVEL", "debug");
        Config config = new Config(env, Collections.<String>emptyList());
        assertEquals(LogLevel.DEBUG, config.logLevel);
    }

    @Test
    void parsesFlagsAndNumbers() {
        Map<String, String> env = baseEnv();
        env.put("E2E_TIMEOUT", "42");
        env.put("E2E_MAX_RETRIES", "5");
        env.put("E2E_DRY_RUN", "true");
        env.put("E2E_FAIL_FAST", "true");
        Config config = new Config(env, Collections.<String>emptyList());
        assertEquals(42, config.timeout);
        assertEquals(5, config.maxRetries);
        assertTrue(config.dryRun);
        assertTrue(config.failFast);
    }

    @Test
    void readsApiUrlBaseAndIgnoresBaseUrlAlias() {
        Map<String, String> env = baseEnv();
        env.put("SAASUS_API_URL_BASE", "https://api.example.com");
        Config config = new Config(env, Collections.<String>emptyList());
        assertEquals("https://api.example.com", config.baseUrl);

        // SAASUS_BASE_URL is not consumed by the Java SDK, so it must not set baseUrl.
        Map<String, String> aliasOnly = baseEnv();
        aliasOnly.put("SAASUS_BASE_URL", "https://legacy.example.com");
        Config aliasConfig = new Config(aliasOnly, Collections.<String>emptyList());
        assertEquals("", aliasConfig.baseUrl);
    }

    @Test
    void commandLineArgsOverride() {
        Config config = new Config(baseEnv(), Arrays.asList("--verbose", "--dry-run", "--fail-fast", "--timeout", "600"));
        assertEquals(LogLevel.DEBUG, config.logLevel);
        assertTrue(config.dryRun);
        assertTrue(config.failFast);
        assertEquals(600, config.timeout);
    }

    @Test
    void snapshotConfigOnlyWhenEnvPresent() {
        Config withoutSnapshot = new Config(baseEnv(), Collections.<String>emptyList());
        assertNull(withoutSnapshot.snapshot);

        Map<String, String> env = baseEnv();
        env.put("E2E_SNAPSHOT_ENABLE", "true");
        env.put("E2E_SNAPSHOT_COMPARISON", "true");
        env.put("E2E_SNAPSHOT_OUTPUT_DIR", "/tmp/snap");
        Config config = new Config(env, Collections.<String>emptyList());
        assertNotNull(config.snapshot);
        assertTrue(config.snapshot.enableCapture);
        assertTrue(config.snapshot.enableComparison);
        assertEquals("/tmp/snap", config.snapshot.outputDirectory);
    }

    @Test
    void invalidTimeoutArgThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new Config(baseEnv(), Arrays.asList("--timeout", "notanumber")));
    }

    @Test
    void snapshotConfigActivatedByFailOnBreakingAlone() {
        Map<String, String> env = baseEnv();
        env.put("E2E_SNAPSHOT_FAIL_ON_BREAKING", "true");
        Config config = new Config(env, Collections.<String>emptyList());
        assertNotNull(config.snapshot);
        assertTrue(config.snapshot.failOnBreaking);
    }

    @Test
    void mergedEnvironmentDoesNotSurfaceDotenvOnlySdkCredentials() {
        // The SDK reads these keys from the real process environment; a value present only in a
        // .env file must not appear here (it would validate but fail at the first signed request).
        Map<String, String> merged = Config.mergedEnvironment();
        Map<String, String> real = System.getenv();
        for (String key : new String[] {"SAASUS_SAAS_ID", "SAASUS_API_KEY", "SAASUS_SECRET_KEY", "SAASUS_API_URL_BASE"}) {
            if (merged.containsKey(key)) {
                assertTrue(real.containsKey(key),
                        key + " must originate from the real environment, not a .env-only value");
            }
        }
    }
}
