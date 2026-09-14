package saasus.sdk.e2e.auth.support;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * SRP-6a client helper for the SaaSus Auth {@code USER_SRP_AUTH} sign-in flow, faithfully ported
 * from the Postman collection's embedded {@code srpHelper} (see the SaaSus Auth API Postman
 * collection). It reproduces the AWS Cognito USER_SRP_AUTH / PASSWORD_VERIFIER computation so the
 * SDK's {@code signIn} &rarr; {@code respondToSignInChallenge} flow can be exercised end-to-end
 * without an AWS SDK dependency.
 *
 * <p>Modular exponentiation uses {@link BigInteger#modPow} (the JDK reference); SHA-256 / HMAC-SHA256
 * use {@link MessageDigest} / {@link Mac}. Only the six SRP primitives the Postman helper bound to
 * CryptoJS are needed here.
 */
public final class Srp {

    /** The 3072-bit group prime N (hex), identical to the Postman helper / Cognito. */
    public static final String SRP_INIT_N =
            "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD1"
            + "29024E088A67CC74020BBEA63B139B22514A08798E3404DD"
            + "EF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245"
            + "E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7ED"
            + "EE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3D"
            + "C2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F"
            + "83655D23DCA3AD961C62F356208552BB9ED529077096966D"
            + "670C354E4ABC9804F1746C08CA18217C32905E462E36CE3B"
            + "E39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9"
            + "DE2BCBF6955817183995497CEA956AE515D2261898FA0510"
            + "15728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64"
            + "ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7"
            + "ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6B"
            + "F12FFA06D98A0864D87602733EC86A64521F2B18177B200C"
            + "BBE117577A615D6C770988C0BAD946E208E24FA074E5AB31"
            + "43DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";

    private static final BigInteger N = new BigInteger(SRP_INIT_N, 16);
    private static final BigInteger G = BigInteger.valueOf(2);
    private static final SecureRandom RANDOM = new SecureRandom();

    private Srp() {
    }

    /** Client ephemeral key pair: private {@code a} and public {@code A = g^a mod N}. */
    public static final class Init {
        public final BigInteger a;
        public final String aHex;
        public final String aHexPublic;

        Init(BigInteger a, BigInteger bigA) {
            this.a = a;
            this.aHex = a.toString(16);
            this.aHexPublic = bigA.toString(16);
        }
    }

    /** Result of computing the PASSWORD_VERIFIER challenge response. */
    public static final class Challenge {
        public final String signature;
        public final String timestamp;

        Challenge(String signature, String timestamp) {
            this.signature = signature;
            this.timestamp = timestamp;
        }
    }

    /** Generates a fresh {@code a} / {@code A}; {@code A mod N} must not be zero. */
    public static Init init() {
        BigInteger a = new BigInteger(1, randomBytes(128)).mod(N);
        if (a.signum() == 0) {
            a = BigInteger.ONE;
        }
        BigInteger bigA = G.modPow(a, N);
        if (bigA.mod(N).signum() == 0) {
            throw new IllegalStateException("illegal parameter: A mod N cannot be 0");
        }
        return new Init(a, bigA);
    }

    /** k = SHA256(pad(N) + pad(g)). */
    public static BigInteger k() {
        return bi(sha256Hex(padHex(N) + padHex(G)));
    }

    /** u = SHA256(pad(A) + pad(B)); must be non-zero. */
    public static BigInteger calcU(BigInteger bigA, BigInteger bigB) {
        BigInteger u = bi(sha256Hex(padHex(bigA) + padHex(bigB)));
        if (u.signum() == 0) {
            throw new IllegalStateException("u cannot be zero");
        }
        return u;
    }

    /** x = SHA256(pad(salt) + SHA256(utf8(poolName + username + ':' + password))). */
    public static BigInteger calcX(BigInteger salt, String poolName, String username, String password) {
        String uph = sha256Hex(utf8ToHex(poolName + username + ":" + password));
        return bi(sha256Hex(padHex(salt) + uph));
    }

    /** S = (B - k*g^x)^(a + u*x) mod N. */
    public static BigInteger calcS(BigInteger a, BigInteger x, BigInteger bigB, BigInteger u) {
        if (bigB.mod(N).signum() == 0) {
            throw new IllegalStateException("B cannot be zero");
        }
        BigInteger gx = G.modPow(x, N);
        BigInteger base = bigB.subtract(k().multiply(gx)).mod(N);
        if (base.signum() < 0) {
            base = base.add(N);
        }
        BigInteger exp = a.add(u.multiply(x));
        return base.modPow(exp, N);
    }

    /** 16-byte HKDF as used by Cognito: PRK = HMAC(salt, ikm); OKM = HMAC(PRK, info); first 16 bytes. */
    public static String hkdf16Hex(String ikmHex, String saltHex, String infoHex) {
        String prk = hmacSha256Hex(saltHex, ikmHex);
        String okm = hmacSha256Hex(prk, infoHex);
        return okm.substring(0, 32);
    }

    /** Derives the 16-byte HKDF password key hex from the SRP challenge inputs. */
    public static String passwordKeyHex(BigInteger a, BigInteger bigB, BigInteger salt,
                                        String poolName, String username, String password) {
        BigInteger bigA = G.modPow(a, N);
        BigInteger u = calcU(bigA, bigB);
        BigInteger x = calcX(salt, poolName, username, password);
        BigInteger s = calcS(a, x, bigB, u);
        String infoHex = utf8ToHex("Caldera Derived Key") + "01";
        return hkdf16Hex(padHex(s), padHex(u), infoHex);
    }

    /** signature = base64( HMAC(hkdf, utf8(poolName)+utf8(username)+b64decode(secretBlock)+utf8(timestamp)) ). */
    public static String signatureB64(String poolName, String username, String secretBlockB64,
                                      String timestamp, String hkdfHex) {
        String msgHex = utf8ToHex(poolName) + utf8ToHex(username)
                + b64ToHex(secretBlockB64) + utf8ToHex(timestamp);
        String sigHex = hmacSha256Hex(hkdfHex, msgHex);
        return hexToB64(sigHex);
    }

    /**
     * Full PASSWORD_VERIFIER response: computes the timestamp and signature for the given challenge
     * parameters and the client's private {@code a} / password.
     */
    public static Challenge respond(String poolName, String usernameForSrp, String secretBlockB64,
                                    String bHex, String saltHex, String aHex, String password,
                                    Calendar now) {
        BigInteger a = bi(aHex);
        BigInteger bigB = bi(bHex);
        BigInteger salt = bi(saltHex);
        String hkdf = passwordKeyHex(a, bigB, salt, poolName, usernameForSrp, password);
        String timestamp = formatTimestamp(now);
        String signature = signatureB64(poolName, usernameForSrp, secretBlockB64, timestamp, hkdf);
        return new Challenge(signature, timestamp);
    }

    // ---- primitives -------------------------------------------------------------

    public static String sha256Hex(String hex) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return toHex(md.digest(fromHex(hex)));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String hmacSha256Hex(String keyHex, String msgHex) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(fromHex(keyHex), "HmacSHA256"));
            return toHex(mac.doFinal(fromHex(msgHex)));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String utf8ToHex(String s) {
        return toHex(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String b64ToHex(String b64) {
        return toHex(Base64.getDecoder().decode(b64));
    }

    public static String hexToB64(String hex) {
        return Base64.getEncoder().encodeToString(fromHex(hex));
    }

    /** Matches the Postman helper: even length, and a leading 00 when the top nibble is 8-f. */
    public static String padHex(BigInteger value) {
        String hex = value.toString(16);
        if (hex.length() % 2 != 0) {
            hex = "0" + hex;
        }
        char first = hex.charAt(0);
        if ("89abcdef".indexOf(first) != -1) {
            hex = "00" + hex;
        }
        return hex;
    }

    /** {@code "EEE MMM d HH:mm:ss 'UTC' yyyy"} in UTC with a non-zero-padded day, English locale. */
    public static String formatTimestamp(Calendar cal) {
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Calendar utc = (Calendar) cal.clone();
        utc.setTimeZone(TimeZone.getTimeZone("UTC"));
        int dow = utc.get(Calendar.DAY_OF_WEEK) - 1; // Calendar.SUNDAY == 1
        int month = utc.get(Calendar.MONTH);
        int day = utc.get(Calendar.DAY_OF_MONTH);
        int hh = utc.get(Calendar.HOUR_OF_DAY);
        int mm = utc.get(Calendar.MINUTE);
        int ss = utc.get(Calendar.SECOND);
        int year = utc.get(Calendar.YEAR);
        return String.format(Locale.US, "%s %s %d %02d:%02d:%02d UTC %d",
                days[dow], months[month], day, hh, mm, ss, year);
    }

    public static BigInteger bi(String hex) {
        return new BigInteger(hex, 16);
    }

    private static byte[] randomBytes(int n) {
        byte[] b = new byte[n];
        RANDOM.nextBytes(b);
        return b;
    }

    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(Character.forDigit((b >> 4) & 0xF, 16));
            sb.append(Character.forDigit(b & 0xF, 16));
        }
        return sb.toString();
    }

    private static byte[] fromHex(String hex) {
        int len = hex.length();
        byte[] out = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            out[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return out;
    }
}
