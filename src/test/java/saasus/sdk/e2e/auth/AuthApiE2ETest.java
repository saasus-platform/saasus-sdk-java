package saasus.sdk.e2e.auth;

import org.junit.jupiter.api.Test;
import saasus.sdk.modules.AuthApiClient;
import saasus.sdk.modules.Configuration;
import saasus.sdk.testlib.ApiError;
import saasus.sdk.testlib.ApiErrorExtractor;
import saasus.sdk.testlib.Config;
import saasus.sdk.testlib.E2EEngine;
import saasus.sdk.testlib.MethodRegistry;
import saasus.sdk.testlib.StoryResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Live E2E test for the SaaSus auth API. Runs only via {@code mvn verify -Pe2e}; requires
 * {@code SAASUS_SAAS_ID} / {@code SAASUS_API_KEY} / {@code SAASUS_SECRET_KEY}. Some flows
 * (invitations, email update) additionally require a DNS/SES-validated environment and an
 * existing tenant ({@code TEST_TENANT_ID}); see the module README.
 */
public class AuthApiE2ETest {

    /**
     * Whether to fail on incomplete {@code (method, style)} coverage. Enabled once the feature
     * stories are in place (Task 5); until then coverage gaps are only logged.
     */
    private static final boolean ENFORCE_COVERAGE = true;

    private static final ApiErrorExtractor ERROR_EXTRACTOR = throwable -> {
        if (throwable instanceof saasus.sdk.auth.ApiException) {
            saasus.sdk.auth.ApiException e = (saasus.sdk.auth.ApiException) throwable;
            return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
        }
        return null;
    };

    @Test
    public void authApiE2E() {
        Config config = Config.fromEnv();
        if (!config.dryRun) {
            config.validate();
        }

        AuthApiClient client = new Configuration().getAuthApiClient();

        MethodRegistry registry = new AuthInvokers(client).buildRegistry();
        E2EEngine engine = new E2EEngine(registry, config, ERROR_EXTRACTOR);
        saasus.sdk.e2e.support.Snapshots.attach(engine, config, "auth");

        List<StoryResult> results = engine.executeStories(AuthStories.all(client));
        engine.printResults(results);

        boolean allPassed = true;
        for (StoryResult result : results) {
            if (!result.isSuccess()) {
                allPassed = false;
            }
        }

        assertTrue(allPassed, "some auth stories failed");
        if (ENFORCE_COVERAGE && !engine.coverage().isFullyCovered()) {
            fail("auth method coverage incomplete: untested = " + engine.coverage().untestedKeys());
        }
    }
}
