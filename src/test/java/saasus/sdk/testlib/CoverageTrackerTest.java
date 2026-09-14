package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CoverageTrackerTest {

    private List<String> registered() {
        return Arrays.asList("getA:NORMAL", "getA:WITH_HTTP_INFO", "getB:NORMAL");
    }

    @Test
    void tracksCoverageAndUntested() {
        CoverageTracker tracker = new CoverageTracker(registered());
        tracker.recordExecution("getA", CallStyle.NORMAL, "story", "step", 200, 10, true, null);
        tracker.recordExecution("getA", CallStyle.WITH_HTTP_INFO, "story", "step", 200, 12, true, null);

        assertEquals(2, tracker.coveredCount());
        assertEquals(3, tracker.totalCount());
        assertFalse(tracker.isFullyCovered());
        assertEquals(Arrays.asList("getB:NORMAL"), tracker.untestedKeys());
    }

    @Test
    void aggregatesSuccessAndFailure() {
        CoverageTracker tracker = new CoverageTracker(Arrays.asList("m:NORMAL"));
        tracker.recordExecution("m", CallStyle.NORMAL, "s", "st1", 200, 10, true, null);
        tracker.recordExecution("m", CallStyle.NORMAL, "s", "st2", 500, 20, false, "boom");
        CoverageTracker.Stats stats = tracker.statsFor("m:NORMAL");
        assertEquals(2, stats.total);
        assertEquals(1, stats.success);
        assertEquals(1, stats.failure);
        assertEquals(50.0, stats.successRate(), 0.001);
        assertEquals(15.0, stats.averageDurationMillis(), 0.001);
    }

    @Test
    void fullCoverage() {
        CoverageTracker tracker = new CoverageTracker(Arrays.asList("m:NORMAL"));
        tracker.recordExecution("m", CallStyle.NORMAL, "s", "st", 200, 10, true, null);
        assertTrue(tracker.isFullyCovered());
        assertEquals(100.0, tracker.coveragePercentage(), 0.001);
    }

    @Test
    void unregisteredKeysAreNotCountedAsCovered() {
        CoverageTracker tracker = new CoverageTracker(Arrays.asList("registered:NORMAL"));
        // Execute an unregistered (method, style) pair as well as the sole registered one.
        tracker.recordExecution("unregistered", CallStyle.NORMAL, "s", "st", 200, 10, true, null);

        assertEquals(0, tracker.coveredCount());
        assertFalse(tracker.isFullyCovered());
        assertEquals(0.0, tracker.coveragePercentage(), 0.001);

        tracker.recordExecution("registered", CallStyle.NORMAL, "s", "st", 200, 10, true, null);
        // coveredCount must never exceed totalCount even with extra unregistered executions.
        assertEquals(1, tracker.coveredCount());
        assertEquals(1, tracker.totalCount());
        assertEquals(100.0, tracker.coveragePercentage(), 0.001);
    }
}
