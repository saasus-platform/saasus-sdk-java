package saasus.sdk.testlib;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Tracks which registered {@code (method, callStyle)} pairs were exercised, along with
 * success/failure counts and timing. The "registered" universe is provided up-front
 * (typically from {@link MethodRegistry#coverageKeys()}), enabling untested-method detection.
 */
public class CoverageTracker {

    /** Per coverage-key aggregated statistics. */
    public static class Stats {
        public final String key;
        public int total;
        public int success;
        public int failure;
        public long totalDurationMillis;
        public final List<MethodExecution> executions = new ArrayList<MethodExecution>();

        Stats(String key) {
            this.key = key;
        }

        public double successRate() {
            return total == 0 ? 0.0 : (success * 100.0) / total;
        }

        public double averageDurationMillis() {
            return total == 0 ? 0.0 : (double) totalDurationMillis / total;
        }
    }

    private final Map<String, Stats> stats = new LinkedHashMap<String, Stats>();
    private final List<String> registeredKeys;
    private final Logger logger;

    public CoverageTracker(List<String> registeredKeys) {
        this(registeredKeys, null);
    }

    public CoverageTracker(List<String> registeredKeys, Logger logger) {
        this.registeredKeys = registeredKeys == null ? new ArrayList<String>() : new ArrayList<String>(registeredKeys);
        this.logger = logger;
    }

    public void recordExecution(String method, CallStyle callStyle, String storyName, String stepName,
                                int statusCode, long durationMillis, boolean success, String error) {
        String key = callStyle.coverageKey(method);
        Stats s = stats.get(key);
        if (s == null) {
            s = new Stats(key);
            stats.put(key, s);
        }
        s.total++;
        s.totalDurationMillis += durationMillis;
        if (success) {
            s.success++;
        } else {
            s.failure++;
        }
        s.executions.add(new MethodExecution(method, callStyle, storyName, stepName,
                statusCode, durationMillis, success, error));
    }

    /**
     * Marks a {@code (method, callStyle)} pair as present/covered without recording an executed
     * call. Used for skipped steps: the pair still counts towards coverage (mirroring the Go
     * reference's static {@code VerifyMethodCoverage}), but no fabricated execution or success is
     * added to the statistics, so success rates and execution counts stay accurate.
     */
    public void recordPresence(String method, CallStyle callStyle) {
        String key = callStyle.coverageKey(method);
        if (!stats.containsKey(key)) {
            stats.put(key, new Stats(key));
        }
    }

    /** Number of registered coverage keys that were actually exercised. */
    public int coveredCount() {
        int covered = 0;
        for (String key : registeredKeys) {
            if (stats.containsKey(key)) {
                covered++;
            }
        }
        return covered;
    }

    public int totalCount() {
        return registeredKeys.size();
    }

    public double coveragePercentage() {
        int total = totalCount();
        return total == 0 ? 0.0 : (coveredCount() * 100.0) / total;
    }

    /** Registered coverage keys that were never executed. */
    public List<String> untestedKeys() {
        List<String> untested = new ArrayList<String>();
        for (String key : registeredKeys) {
            if (!stats.containsKey(key)) {
                untested.add(key);
            }
        }
        return untested;
    }

    public boolean isFullyCovered() {
        return untestedKeys().isEmpty();
    }

    public Stats statsFor(String coverageKey) {
        return stats.get(coverageKey);
    }

    public Map<String, Stats> allStats() {
        return new LinkedHashMap<String, Stats>(stats);
    }

    public int totalExecutions() {
        int n = 0;
        for (Stats s : stats.values()) {
            n += s.total;
        }
        return n;
    }

    public void printSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(repeat('=', 60)).append("\n");
        sb.append("COVERAGE SUMMARY\n");
        sb.append(repeat('=', 60)).append("\n");
        sb.append(String.format("Methods Covered: %d/%d (%.1f%%)%n",
                coveredCount(), totalCount(), coveragePercentage()));
        sb.append("Total Executions: ").append(totalExecutions()).append("\n");
        List<String> untested = untestedKeys();
        if (!untested.isEmpty()) {
            sb.append("\nUntested methods:\n");
            for (String key : untested) {
                sb.append("  - ").append(key).append("\n");
            }
        } else if (totalCount() > 0) {
            sb.append("All registered methods have been tested!\n");
        }
        sb.append(repeat('=', 60)).append("\n");
        if (logger != null) {
            logger.info(sb.toString());
        } else {
            System.out.println(sb);
        }
    }

    private static String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
