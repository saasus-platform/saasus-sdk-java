package saasus.sdk.contract;

/**
 * Resolves the base URL of the Prism mock for a given module, or {@code null}
 * when the module has no mock configured (it then contributes no cases).
 *
 * <p>The single source is the environment variable {@code PRISM_URL_<MODULE>},
 * exported by the setup-prism action in CI and set by hand for a local run
 * ({@code PRISM_URL_AUTH=http://127.0.0.1:4010 mvn test}).
 */
public final class PrismEndpoints {

    private PrismEndpoints() {
    }

    /** Base URL of the module's Prism mock, or {@code null} when unconfigured. */
    public static String urlForOrNull(String module) {
        String env = System.getenv("PRISM_URL_" + module.toUpperCase());
        return env != null && !env.isEmpty() ? env : null;
    }
}
