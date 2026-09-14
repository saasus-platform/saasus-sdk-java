package saasus.sdk.testlib;

import java.io.PrintStream;
import java.util.Map;

/**
 * Level-aware logger with automatic masking of sensitive values.
 *
 * <p>All output goes to {@code stdout} except {@link #error} which uses {@code stderr}.
 * Streams are injectable to make the logger unit-testable.
 */
public class Logger {

    private final LogLevel level;
    private final Masker masker;
    private final PrintStream out;
    private final PrintStream err;

    public Logger(LogLevel level) {
        this(level, System.out, System.err);
    }

    public Logger(LogLevel level, PrintStream out, PrintStream err) {
        this.level = level == null ? LogLevel.INFO : level;
        this.masker = new Masker();
        this.out = out;
        this.err = err;
    }

    public LogLevel level() {
        return level;
    }

    public boolean shouldLog(LogLevel messageLevel) {
        return level.allows(messageLevel);
    }

    public void debug(String message) {
        if (shouldLog(LogLevel.DEBUG)) {
            out.println("[DEBUG] " + masker.maskText(message));
        }
    }

    public void info(String message) {
        if (shouldLog(LogLevel.INFO)) {
            out.println("[INFO] " + masker.maskText(message));
        }
    }

    public void warn(String message) {
        if (shouldLog(LogLevel.WARN)) {
            out.println("[WARN] " + masker.maskText(message));
        }
    }

    public void error(String message) {
        error(message, null);
    }

    public void error(String message, Throwable t) {
        if (shouldLog(LogLevel.ERROR)) {
            String masked = masker.maskText(message);
            if (t != null) {
                err.println("[ERROR] " + masked + ": " + masker.maskText(t.getMessage()));
            } else {
                err.println("[ERROR] " + masked);
            }
        }
    }

    // ---- story / step lifecycle ----------------------------------------------

    public void logStoryStart(String storyName) {
        if (shouldLog(LogLevel.DEBUG)) {
            out.println();
            out.println("STORY START: " + storyName);
            out.println(repeat('=', 63));
        }
    }

    public void logStoryEnd(String storyName, long durationMillis) {
        if (shouldLog(LogLevel.DEBUG)) {
            out.println();
            out.println("STORY COMPLETED: " + storyName + " (" + durationMillis + "ms)");
            out.println(repeat('=', 63));
        }
    }

    public void logStepStart(int stepNumber, String stepName, String method) {
        if (shouldLog(LogLevel.DEBUG)) {
            out.println();
            out.println("STEP " + stepNumber + ": " + stepName);
            out.println("   Method: " + method);
        }
    }

    public void logStepResult(String stepName, String method, TestStatus status, int statusCode, long durationMillis) {
        if (shouldLog(LogLevel.DEBUG)) {
            out.println("   Step Result: " + status.label()
                    + " | Status Code: " + statusCode
                    + " | Duration: " + durationMillis + "ms"
                    + " | " + stepName + " -> " + method);
        }
    }

    public void logValidation(String stepName, boolean success, String details) {
        if (shouldLog(LogLevel.DEBUG)) {
            out.println("   VALIDATION " + (success ? "PASSED" : "FAILED") + ": " + stepName
                    + (details != null && !details.isEmpty() ? " (" + details + ")" : ""));
        }
    }

    public void logStateUpdate(String stepName, Map<String, Object> variables) {
        if (shouldLog(LogLevel.DEBUG) && variables != null && !variables.isEmpty()) {
            out.println("   STATE UPDATE: " + stepName);
            for (Map.Entry<String, Object> entry : variables.entrySet()) {
                Object display = maskEntry(entry.getKey(), entry.getValue());
                out.println("     " + entry.getKey() + ": " + display);
            }
        }
    }

    /** Logs an arbitrary object with masking, at the given level. */
    public void logObject(String label, Object data, LogLevel atLevel) {
        if (shouldLog(atLevel)) {
            Object masked = masker.mask(data);
            String line = "[" + atLevel.name() + "] " + label + ": " + masked;
            if (atLevel == LogLevel.ERROR) {
                err.println(line);
            } else {
                out.println(line);
            }
        }
    }

    private Object maskEntry(String key, Object value) {
        if (masker.isSensitiveKey(key)) {
            return masker.maskValue(value);
        }
        return masker.mask(value);
    }

    private static String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
