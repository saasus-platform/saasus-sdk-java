package saasus.sdk.e2e.auth.support;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the {@link Srp} SRP-6a helper. These validate the cryptographic primitives with
 * published known-answer vectors (RFC 4231 HMAC-SHA256, FIPS SHA-256), the {@code padHex} rule,
 * the {@code g^a mod N} identity, the timestamp format, and end-to-end determinism. The full
 * Cognito PASSWORD_VERIFIER match is additionally exercised live by the {@code sign-in-ok} story.
 */
public class SrpTest {

    @Test
    public void sha256KnownVector() {
        // FIPS 180-2: SHA-256("abc")
        assertEquals("ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad",
                Srp.sha256Hex(Srp.utf8ToHex("abc")));
    }

    @Test
    public void hmacSha256Rfc4231TestCase1() {
        // RFC 4231 test case 1: key = 0x0b x20, data = "Hi There"
        String keyHex = repeat("0b", 20);
        String msgHex = Srp.utf8ToHex("Hi There");
        assertEquals("b0344c61d8db38535ca8afceaf0bf12b881dc200c9833da726e9376c2e32cff7",
                Srp.hmacSha256Hex(keyHex, msgHex));
    }

    @Test
    public void padHexRule() {
        // Odd length -> leading zero.
        assertEquals("01", Srp.padHex(BigInteger.valueOf(0x1)));
        // Top nibble 0x8-0xf -> prepend "00" (sign-bit guard), even length preserved otherwise.
        assertEquals("008f", Srp.padHex(BigInteger.valueOf(0x8f)));
        assertEquals("7f", Srp.padHex(BigInteger.valueOf(0x7f)));
    }

    @Test
    public void publicKeyMatchesModPow() {
        Srp.Init init = Srp.init();
        BigInteger n = new BigInteger(Srp.SRP_INIT_N, 16);
        BigInteger expected = BigInteger.valueOf(2).modPow(init.a, n);
        assertEquals(expected.toString(16), init.aHexPublic);
    }

    @Test
    public void timestampFormat() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.clear();
        cal.set(2020, Calendar.JANUARY, 2, 3, 4, 5); // 2020-01-02 is a Thursday
        assertEquals("Thu Jan 2 03:04:05 UTC 2020", Srp.formatTimestamp(cal));
    }

    @Test
    public void hkdfIs16Bytes() {
        String hkdf = Srp.hkdf16Hex(Srp.utf8ToHex("ikm"), Srp.utf8ToHex("salt"), Srp.utf8ToHex("info01"));
        assertEquals(32, hkdf.length()); // 16 bytes = 32 hex chars
    }

    @Test
    public void respondIsDeterministicAndWellFormed() {
        // Fixed, arbitrary-but-valid challenge inputs.
        Srp.Init init = Srp.init();
        String aHex = init.a.toString(16);
        String poolName = "ap-northeast-1_examplepool";
        String username = "11111111-2222-3333-4444-555555555555";
        String secretBlock = Base64.getEncoder().encodeToString("secret-block-bytes".getBytes());
        // A plausible server public value B and salt (non-zero mod N).
        String bHex = BigInteger.valueOf(2).modPow(BigInteger.valueOf(123456789), new BigInteger(Srp.SRP_INIT_N, 16)).toString(16);
        String saltHex = "0a1b2c3d4e5f60718293a4b5c6d7e8f9";
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.clear();
        cal.set(2024, Calendar.MARCH, 4, 5, 6, 7);

        Srp.Challenge c1 = Srp.respond(poolName, username, secretBlock, bHex, saltHex, aHex, "Test-Passw0rd-1!", cal);
        Srp.Challenge c2 = Srp.respond(poolName, username, secretBlock, bHex, saltHex, aHex, "Test-Passw0rd-1!", cal);

        // Deterministic for identical inputs.
        assertEquals(c1.signature, c2.signature);
        assertEquals("Mon Mar 4 05:06:07 UTC 2024", c1.timestamp);
        // Signature is base64 of a 32-byte HMAC-SHA256.
        assertEquals(32, Base64.getDecoder().decode(c1.signature).length);
        // A different password must change the signature.
        Srp.Challenge c3 = Srp.respond(poolName, username, secretBlock, bHex, saltHex, aHex, "Different-1!", cal);
        assertNotEquals(c1.signature, c3.signature);
    }

    @Test
    public void initProducesDistinctEphemerals() {
        assertNotEquals(Srp.init().aHexPublic, Srp.init().aHexPublic);
    }

    @Test
    public void passwordKeyIsSixteenBytes() {
        Srp.Init init = Srp.init();
        BigInteger bigB = BigInteger.valueOf(2).modPow(BigInteger.valueOf(987654321), new BigInteger(Srp.SRP_INIT_N, 16));
        BigInteger salt = new BigInteger("0a1b2c3d4e5f60718293a4b5c6d7e8f9", 16);
        String key = Srp.passwordKeyHex(init.a, bigB, salt, "pool", "user", "pw");
        assertEquals(32, key.length());
        assertTrue(key.matches("[0-9a-f]{32}"));
    }

    private static String repeat(String unit, int times) {
        StringBuilder sb = new StringBuilder(unit.length() * times);
        for (int i = 0; i < times; i++) {
            sb.append(unit);
        }
        return sb.toString();
    }
}
