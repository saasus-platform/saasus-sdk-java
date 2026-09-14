package saasus.sdk.testlib;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Test execution configuration.
 *
 * <p>Values are resolved from (in order of precedence):
 * <ol>
 *   <li>command-line arguments (e.g. {@code --verbose})</li>
 *   <li>the real process environment ({@link System#getenv()})</li>
 *   <li>a {@code .env} file discovered by {@link EnvFileLoader}</li>
 *   <li>built-in defaults</li>
 * </ol>
 *
 * <p>The {@link #Config(Map, List)} constructor takes an explicit environment map,
 * which makes the class fully unit-testable without touching the real environment.
 */
public class Config {

    // Required credentials
    public String saasId = "";
    public String apiKey = "";
    public String secretKey = "";

    // Optional
    public String baseUrl = "";
    public String stripeKey = "";
    public LogLevel logLevel = LogLevel.INFO;
    public boolean dryRun = false;
    public boolean failFast = false;
    public int timeout = 300;      // seconds
    public int maxRetries = 3;

    /** Present only when a snapshot-related environment variable is set. */
    public SnapshotConfig snapshot;

    /** Creates a config populated from the real environment, {@code .env}, and JVM args. */
    public static Config fromEnv() {
        return new Config(mergedEnvironment(), jvmArgs());
    }

    /** Creates an empty config with defaults only (no environment access). */
    public Config() {
    }

    /**
     * Creates a config from an explicit environment map and argument list.
     *
     * @param env  environment key/value pairs ({@code null} treated as empty)
     * @param args command-line arguments ({@code null} treated as empty)
     */
    public Config(Map<String, String> env, List<String> args) {
        Map<String, String> e = env == null ? Collections.<String, String>emptyMap() : env;
        applyEnvironment(e);
        if (args != null) {
            parseArgs(args);
        }
    }

    private void applyEnvironment(Map<String, String> env) {
        saasId = orDefault(env.get("SAASUS_SAAS_ID"), saasId);
        apiKey = orDefault(env.get("SAASUS_API_KEY"), apiKey);
        secretKey = orDefault(env.get("SAASUS_SECRET_KEY"), secretKey);

        // The Java SDK reads only SAASUS_API_URL_BASE (saasus.sdk.*.Configuration); a value set
        // solely via the Go-style SAASUS_BASE_URL alias would never reach the SDK clients, so it
        // is intentionally not treated as an endpoint override here.
        baseUrl = orDefault(env.get("SAASUS_API_URL_BASE"), baseUrl);
        stripeKey = orDefault(env.get("STRIPE_SECRET_KEY"), stripeKey);

        timeout = parsePositiveInt(env.get("E2E_TIMEOUT"), timeout);
        maxRetries = parseNonNegativeInt(env.get("E2E_MAX_RETRIES"), maxRetries);
        dryRun = parseBool(firstNonEmpty(env.get("E2E_DRY_RUN"), env.get("DRY_RUN")), dryRun);
        failFast = parseBool(firstNonEmpty(env.get("E2E_FAIL_FAST"), env.get("FAIL_FAST")), failFast);

        logLevel = resolveLogLevel(env);
        this.snapshot = resolveSnapshotConfig(env);
    }

    private LogLevel resolveLogLevel(Map<String, String> env) {
        // E2E-specific setting takes priority over the general one.
        String e2e = env.get("E2E_LOG_LEVEL");
        if (isNotEmpty(e2e)) {
            return LogLevel.parse(e2e);
        }
        String general = env.get("LOG_LEVEL");
        if (isNotEmpty(general)) {
            return LogLevel.parse(general);
        }
        return logLevel;
    }

    private SnapshotConfig resolveSnapshotConfig(Map<String, String> env) {
        boolean hasSnapshotEnv =
                env.containsKey("E2E_SNAPSHOT_ENABLE")
                        || env.containsKey("E2E_SNAPSHOT_COMPARISON")
                        || env.containsKey("E2E_SNAPSHOT_REPORTING")
                        || env.containsKey("E2E_SNAPSHOT_OUTPUT_DIR")
                        || env.containsKey("E2E_SNAPSHOT_CAPTURE_LEVEL")
                        || env.containsKey("E2E_SNAPSHOT_FAIL_ON_BREAKING");
        if (!hasSnapshotEnv) {
            return null;
        }
        SnapshotConfig sc = new SnapshotConfig();
        sc.enableCapture = parseBool(env.get("E2E_SNAPSHOT_ENABLE"), false);
        sc.enableComparison = parseBool(env.get("E2E_SNAPSHOT_COMPARISON"), false);
        sc.enableReporting = parseBool(env.get("E2E_SNAPSHOT_REPORTING"), false);
        sc.outputDirectory = orDefault(env.get("E2E_SNAPSHOT_OUTPUT_DIR"), sc.outputDirectory);
        String level = env.get("E2E_SNAPSHOT_CAPTURE_LEVEL");
        if (isNotEmpty(level)) {
            sc.captureLevel = level.trim().toUpperCase();
        }
        sc.failOnBreaking = parseBool(env.get("E2E_SNAPSHOT_FAIL_ON_BREAKING"), sc.failOnBreaking);
        return sc;
    }

    /** Parses supported command-line flags. */
    public void parseArgs(List<String> args) {
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            if ("-v".equals(arg) || "--verbose".equals(arg)) {
                logLevel = LogLevel.DEBUG;
            } else if ("--dry-run".equals(arg)) {
                dryRun = true;
            } else if ("--fail-fast".equals(arg)) {
                failFast = true;
            } else if ("--timeout".equals(arg)) {
                if (i + 1 < args.size()) {
                    int parsed = parsePositiveInt(args.get(i + 1), Integer.MIN_VALUE);
                    if (parsed == Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("--timeout requires a positive integer");
                    }
                    timeout = parsed;
                    i++;
                } else {
                    throw new IllegalArgumentException("--timeout requires a positive integer");
                }
            }
        }
    }

    /** Throws {@link IllegalStateException} if any required credential is missing. */
    public void validate() {
        if (isEmpty(saasId)) {
            throw new IllegalStateException("missing required environment variable: SAASUS_SAAS_ID");
        }
        if (isEmpty(apiKey)) {
            throw new IllegalStateException("missing required environment variable: SAASUS_API_KEY");
        }
        if (isEmpty(secretKey)) {
            throw new IllegalStateException("missing required environment variable: SAASUS_SECRET_KEY");
        }
    }

    public boolean isValid() {
        return isNotEmpty(saasId) && isNotEmpty(apiKey) && isNotEmpty(secretKey);
    }

    // ---- environment assembly -------------------------------------------------

    /**
     * Environment keys the SDK itself reads directly from the real process environment
     * ({@code System.getenv()}) at request time — via {@code Utils.withSaasusSigV1} and each
     * module's {@code Configuration}. A value present only in a {@code .env} file cannot reach
     * that code, so we must not report it as usable SDK configuration.
     */
    private static final String[] SDK_PROCESS_ENV_KEYS = {
        "SAASUS_SAAS_ID", "SAASUS_API_KEY", "SAASUS_SECRET_KEY", "SAASUS_API_URL_BASE"
    };

    /**
     * Real environment overlaid on top of the {@code .env} file (real env wins). The keys the
     * SDK reads directly from the process environment are taken from the real environment only:
     * a {@code .env}-only credential would validate here but fail at the first signed request,
     * so it is intentionally not treated as present.
     */
    static Map<String, String> mergedEnvironment() {
        Map<String, String> real = System.getenv();
        Map<String, String> merged = new LinkedHashMap<String, String>(EnvFileLoader.load());
        merged.putAll(real);
        for (String key : SDK_PROCESS_ENV_KEYS) {
            if (!real.containsKey(key)) {
                merged.remove(key);
            }
        }
        return merged;
    }

    static List<String> jvmArgs() {
        String raw = System.getProperty("testlib.args", "");
        if (raw.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return java.util.Arrays.asList(raw.trim().split("\\s+"));
    }

    // ---- small parsing helpers ------------------------------------------------

    private static boolean parseBool(String value, boolean defaultValue) {
        if (!isNotEmpty(value)) {
            return defaultValue;
        }
        return "true".equalsIgnoreCase(value.trim());
    }

    private static int parsePositiveInt(String value, int defaultValue) {
        if (!isNotEmpty(value)) {
            return defaultValue;
        }
        try {
            int parsed = Integer.parseInt(value.trim());
            return parsed > 0 ? parsed : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private static int parseNonNegativeInt(String value, int defaultValue) {
        if (!isNotEmpty(value)) {
            return defaultValue;
        }
        try {
            int parsed = Integer.parseInt(value.trim());
            return parsed >= 0 ? parsed : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private static String orDefault(String value, String defaultValue) {
        return isNotEmpty(value) ? value : defaultValue;
    }

    private static String firstNonEmpty(String a, String b) {
        if (isNotEmpty(a)) {
            return a;
        }
        return isNotEmpty(b) ? b : null;
    }

    private static boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
