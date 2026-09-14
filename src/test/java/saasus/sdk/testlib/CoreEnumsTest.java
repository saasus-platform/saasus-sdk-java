package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoreEnumsTest {

    @Test
    void logLevelParsing() {
        assertEquals(LogLevel.DEBUG, LogLevel.parse("debug"));
        assertEquals(LogLevel.DEBUG, LogLevel.parse("  DEBUG "));
        assertEquals(LogLevel.INFO, LogLevel.parse("info"));
        assertEquals(LogLevel.WARN, LogLevel.parse("warning"));
        assertEquals(LogLevel.ERROR, LogLevel.parse("error"));
        assertEquals(LogLevel.INFO, LogLevel.parse("nonsense"));
        assertEquals(LogLevel.INFO, LogLevel.parse(null));
    }

    @Test
    void logLevelThreshold() {
        // INFO threshold shows INFO/WARN/ERROR but not DEBUG.
        assertTrue(LogLevel.INFO.allows(LogLevel.INFO));
        assertTrue(LogLevel.INFO.allows(LogLevel.WARN));
        assertTrue(LogLevel.INFO.allows(LogLevel.ERROR));
        assertFalse(LogLevel.INFO.allows(LogLevel.DEBUG));
        // DEBUG threshold shows everything.
        assertTrue(LogLevel.DEBUG.allows(LogLevel.DEBUG));
    }

    @Test
    void callStyleCoverageKeyAndSuffix() {
        assertEquals("getStripeInfo:NORMAL", CallStyle.NORMAL.coverageKey("getStripeInfo"));
        assertEquals("WithHttpInfo", CallStyle.WITH_HTTP_INFO.suffix());
        assertEquals("Async", CallStyle.ASYNC.suffix());
        assertEquals("Call", CallStyle.CALL.suffix());
        assertEquals("", CallStyle.NORMAL.suffix());
    }

    @Test
    void testStatusLabel() {
        assertEquals("passed", TestStatus.PASSED.label());
        assertEquals("failed", TestStatus.FAILED.label());
        assertEquals("skipped", TestStatus.SKIPPED.label());
    }
}
