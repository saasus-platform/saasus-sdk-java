package saasus.sdk.testlib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Minimal, dependency-free {@code .env} loader.
 *
 * <p>Behaviour mirrors the Go implementation (godotenv): the first existing file
 * among a small list of candidate paths is parsed, and values from the file
 * <em>do not</em> override variables already present in the real process
 * environment. Parsing supports:
 *
 * <ul>
 *   <li>{@code KEY=VALUE} lines</li>
 *   <li>blank lines and {@code #} comments</li>
 *   <li>an optional leading {@code export } keyword</li>
 *   <li>single- or double-quoted values (quotes are stripped)</li>
 *   <li>trailing inline comments for unquoted values</li>
 * </ul>
 */
public final class EnvFileLoader {

    /** Candidate paths searched relative to the current working directory. */
    static final String[] DEFAULT_PATHS = {
        ".env", "../.env", "../../.env", "../../../.env", "../../../../.env"
    };

    private EnvFileLoader() {
    }

    /** Loads the first existing {@code .env} among {@link #DEFAULT_PATHS}. Never throws. */
    public static Map<String, String> load() {
        String workingDir = System.getProperty("user.dir", ".");
        for (String candidate : DEFAULT_PATHS) {
            File file = new File(workingDir, candidate);
            if (file.isFile()) {
                try {
                    return parse(new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8));
                } catch (IOException e) {
                    System.err.println("Warning: failed to read " + file + ": " + e.getMessage());
                    return new LinkedHashMap<String, String>();
                }
            }
        }
        return new LinkedHashMap<String, String>();
    }

    /** Loads a specific file. Returns an empty map if it does not exist or cannot be read. */
    public static Map<String, String> loadFrom(File file) {
        if (file == null || !file.isFile()) {
            return new LinkedHashMap<String, String>();
        }
        try {
            return parse(new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Warning: failed to read " + file + ": " + e.getMessage());
            return new LinkedHashMap<String, String>();
        }
    }

    /** Parses {@code .env} content from a string. */
    public static Map<String, String> parse(String content) {
        return parse(new StringReader(content == null ? "" : content));
    }

    /** Parses {@code .env} content from a reader. */
    public static Map<String, String> parse(Reader reader) {
        Map<String, String> result = new LinkedHashMap<String, String>();
        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                parseLine(line, result);
            }
        } catch (IOException e) {
            System.err.println("Warning: failed to parse .env content: " + e.getMessage());
        }
        return result;
    }

    private static void parseLine(String rawLine, Map<String, String> out) {
        String line = rawLine.trim();
        if (line.isEmpty() || line.charAt(0) == '#') {
            return;
        }
        if (line.startsWith("export ")) {
            line = line.substring("export ".length()).trim();
        }
        int eq = line.indexOf('=');
        if (eq <= 0) {
            return; // no key, or empty key
        }
        String key = line.substring(0, eq).trim();
        String value = line.substring(eq + 1).trim();
        value = stripValue(value);
        if (!key.isEmpty()) {
            out.put(key, value);
        }
    }

    private static String stripValue(String value) {
        if (!value.isEmpty()) {
            char first = value.charAt(0);
            if (first == '"' || first == '\'') {
                // Quoted value: take the content up to the matching closing quote and
                // ignore anything after it (e.g. a trailing inline comment).
                int closing = value.indexOf(first, 1);
                if (closing > 0) {
                    return value.substring(1, closing);
                }
            }
        }
        // Strip trailing inline comment for unquoted values ("value # comment").
        int hash = value.indexOf(" #");
        if (hash >= 0) {
            value = value.substring(0, hash).trim();
        }
        return value;
    }

    /**
     * Convenience used by tests: reads a {@code .env} file relative to the classpath is
     * intentionally not supported; use {@link #loadFrom(File)} instead.
     */
    static Reader readerFor(File file) throws IOException {
        return new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8);
    }
}
