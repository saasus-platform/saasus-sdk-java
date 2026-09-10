package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class LoggerTest {

    private static Logger logger(ByteArrayOutputStream out, ByteArrayOutputStream err) {
        try {
            return new Logger(LogLevel.DEBUG,
                    new PrintStream(out, true, "UTF-8"),
                    new PrintStream(err, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void infoMasksSensitiveValues() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        logger(out, err).info("api_key=supersecretlongapikeyvalue");
        assertFalse(out.toString().contains("supersecretlongapikeyvalue"));
    }

    @Test
    void warnAndDebugMaskSensitiveValues() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        Logger logger = logger(out, err);
        logger.warn("secret=verylongsecretvalue1234567");
        logger.debug("password=verylongpasswordvalue999");
        String printed = out.toString();
        assertFalse(printed.contains("verylongsecretvalue1234567"));
        assertFalse(printed.contains("verylongpasswordvalue999"));
    }

    @Test
    void errorMasksBothMessageAndThrowable() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        logger(out, err).error("token=supersecretlongtokenvalue123",
                new RuntimeException("secret=anotherlongsecretvalue999"));
        String printed = err.toString();
        assertFalse(printed.contains("supersecretlongtokenvalue123"));
        assertFalse(printed.contains("anotherlongsecretvalue999"));
    }

    @Test
    void leavesPlainMessagesReadable() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        logger(out, err).info("Starting E2E test execution");
        assertTrue(out.toString().contains("Starting E2E test execution"));
    }
}
