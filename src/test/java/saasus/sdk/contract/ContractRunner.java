package saasus.sdk.contract;

import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.api.SaasUserApi;
import saasus.sdk.auth.api.UserInfoApi;
import saasus.sdk.auth.models.SaasUsers;
import saasus.sdk.auth.models.UserInfo;

/**
 * Minimal contract harness.
 *
 * It drives SDK operations against the Prism mock and asserts only that:
 *   - the request is accepted by Prism (no schema-validation HTTP error), and
 *   - the response deserializes into the SDK model (no exception).
 *
 * The same runner serves both perspectives depending on which SDK it is
 * compiled against:
 *   (B) spec compliance        -> run against the latest SDK (the PR checkout)
 *   (C) forward compatibility  -> run against the previously released SDK
 *
 * Safety: on failure only the HTTP status code / exception type is printed.
 * Response bodies, tokens and PII are never logged.
 *
 * This is a thin starting point that proves the pipeline end to end. Exhaustive
 * per-operation coverage can be added incrementally.
 */
public final class ContractRunner {

    private static int failures = 0;

    public static void main(String[] args) {
        String base = PrismEndpoints.urlFor("auth");
        System.out.println("[contract] auth base URL: " + base);

        check("auth.GetSaasUsers", new Check() {
            public void run() throws Exception {
                SaasUsers res = new SaasUserApi(client(base)).getSaasUsers();
                require(res != null, "SaasUsers deserialized to null");
            }
        });

        check("auth.GetUserInfo", new Check() {
            public void run() throws Exception {
                UserInfo res = new UserInfoApi(client(base)).getUserInfo("synthetic-id-token");
                require(res != null, "UserInfo deserialized to null");
            }
        });

        if (failures > 0) {
            System.out.println("[contract] FAILED: " + failures + " check(s)");
            System.exit(1);
        }
        System.out.println("[contract] all checks passed");
    }

    private static ApiClient client(String base) {
        ApiClient c = new ApiClient();
        c.setBasePath(base);
        // The specs declare an http "Bearer" security scheme. Prism with --errors
        // rejects requests without credentials (HTTP 401). A synthetic token
        // satisfies the presence check; Prism does not validate the value.
        // Synthetic data only.
        c.setBearerToken("synthetic-bearer-token");
        return c;
    }

    private interface Check {
        void run() throws Exception;
    }

    private static void check(String name, Check check) {
        try {
            check.run();
            System.out.println("[contract] PASS " + name);
        } catch (ApiException e) {
            // never print response body/token; only the status code.
            failures++;
            System.out.println("[contract] FAIL " + name + ": HTTP " + e.getCode());
        } catch (Exception e) {
            failures++;
            System.out.println("[contract] FAIL " + name + ": "
                    + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    private static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
