package saasus.sdk.contract;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Resolves the base URL of the Prism mock for a given module, or {@code null}
 * when the module has no mock configured (it then contributes no cases).
 *
 * Resolution order:
 *   1. Environment variable PRISM_URL_&lt;MODULE&gt; (exported by the setup-prism action).
 *   2. A file at PRISM_ENDPOINTS_FILE containing "module=url" lines (also
 *      written by setup-prism, as its endpoints-file output).
 *   3. System property -Dprism.url.&lt;module&gt; (handy for local runs).
 */
public final class PrismEndpoints {

    private PrismEndpoints() {
    }

    /** Base URL of the module's Prism mock, or {@code null} when unconfigured. */
    public static String urlForOrNull(String module) {
        String env = System.getenv("PRISM_URL_" + module.toUpperCase());
        if (env != null && !env.isEmpty()) {
            return env;
        }

        String file = System.getenv("PRISM_ENDPOINTS_FILE");
        if (file != null && !file.isEmpty()) {
            String url = parse(file).get(module);
            if (url != null && !url.isEmpty()) {
                return url;
            }
        }

        String prop = System.getProperty("prism.url." + module);
        return prop != null && !prop.isEmpty() ? prop : null;
    }

    private static Map<String, String> parse(String file) {
        Map<String, String> out = new HashMap<String, String>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (String raw : lines) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                int eq = line.indexOf('=');
                if (eq > 0) {
                    out.put(line.substring(0, eq).trim(), line.substring(eq + 1).trim());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read PRISM_ENDPOINTS_FILE=" + file, e);
        }
        return out;
    }
}
