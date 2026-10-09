package saasus.sdk.contract;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Resolves the base URL of the Prism mock for a given module.
 *
 * Resolution order:
 *   1. Environment variable PRISM_URL_&lt;MODULE&gt; (exported by the setup-prism action).
 *   2. A file at PRISM_ENDPOINTS_FILE containing "module=url" lines.
 *   3. System property -Dprism.url.&lt;module&gt; (handy for local runs).
 *
 * This class is intentionally dependency-free (no JUnit) so it can be overlaid
 * onto a previously released SDK checkout for the (C) forward-compatibility run.
 */
public final class PrismEndpoints {

    private PrismEndpoints() {
    }

    public static String urlFor(String module) {
        String env = System.getenv("PRISM_URL_" + module.toUpperCase());
        if (env != null && !env.isEmpty()) {
            return env;
        }

        String file = System.getenv("PRISM_ENDPOINTS_FILE");
        if (file != null && !file.isEmpty()) {
            Map<String, String> endpoints = parse(file);
            String url = endpoints.get(module);
            if (url != null && !url.isEmpty()) {
                return url;
            }
        }

        String prop = System.getProperty("prism.url." + module);
        if (prop != null && !prop.isEmpty()) {
            return prop;
        }

        throw new IllegalStateException(
                "No Prism endpoint configured for module '" + module + "'. "
                        + "Set PRISM_URL_" + module.toUpperCase()
                        + ", PRISM_ENDPOINTS_FILE, or -Dprism.url." + module);
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
