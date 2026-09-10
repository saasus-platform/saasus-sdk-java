package saasus.sdk.testlib;

/**
 * Logging verbosity level.
 *
 * <p>Ordering follows the Go implementation: {@code ERROR < WARN < INFO < DEBUG}.
 * A configured level acts as a threshold: a message is emitted when its own
 * severity is less than or equal to the configured severity.
 */
public enum LogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3);

    private final int severity;

    LogLevel(int severity) {
        this.severity = severity;
    }

    public int severity() {
        return severity;
    }

    /**
     * Returns {@code true} when a message emitted at {@code messageLevel} should be
     * shown while this level is configured as the threshold.
     */
    public boolean allows(LogLevel messageLevel) {
        return messageLevel.severity <= this.severity;
    }

    /**
     * Parses a textual log level. Accepts (case-insensitively) {@code debug},
     * {@code info}, {@code warn}/{@code warning} and {@code error}. Any other
     * (non-empty) value produces a warning on {@code stderr} and falls back to
     * {@link #INFO}.
     */
    public static LogLevel parse(String value) {
        if (value == null) {
            return INFO;
        }
        String normalized = value.trim().toLowerCase();
        switch (normalized) {
            case "debug":
                return DEBUG;
            case "info":
                return INFO;
            case "warn":
            case "warning":
                return WARN;
            case "error":
                return ERROR;
            case "":
                return INFO;
            default:
                System.err.println("Warning: Invalid LOG_LEVEL '" + value + "', using 'info'");
                return INFO;
        }
    }
}
