package saasus.sdk.e2e.billing;

import org.junit.jupiter.api.Test;
import saasus.sdk.billing.api.StripeApi;
import saasus.sdk.modules.BillingApiClient;
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
 * Live E2E test for the SaaSus Billing (Stripe) API.
 *
 * <p>Runs only via the {@code e2e} Maven profile ({@code mvn verify -Pe2e}); the ordinary unit
 * test phase excludes {@code **}{@code /e2e/}{@code **}{@code /*E2ETest.java}. Requires
 * {@code SAASUS_SAAS_ID}, {@code SAASUS_API_KEY} and {@code SAASUS_SECRET_KEY} in the process
 * environment. When credentials are missing the run fails (rather than silently skipping) so a
 * misconfigured E2E run is always surfaced.
 */
public class BillingApiE2ETest {

    /** Converts a billing {@code ApiException} into the module-agnostic {@link ApiError}. */
    private static final ApiErrorExtractor ERROR_EXTRACTOR = throwable -> {
        if (throwable instanceof saasus.sdk.billing.ApiException) {
            saasus.sdk.billing.ApiException e = (saasus.sdk.billing.ApiException) throwable;
            return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
        }
        return null;
    };

    @Test
    public void billingApiE2E() {
        Config config = Config.fromEnv();
        if (!config.dryRun) {
            config.validate(); // fails fast when required credentials are absent
        }

        BillingApiClient client = new saasus.sdk.modules.Configuration().getBillingApiClient();
        StripeApi api = new StripeApi(client);

        MethodRegistry registry = new BillingInvokers(api, client, config.stripeKey).buildRegistry();
        E2EEngine engine = new E2EEngine(registry, config, ERROR_EXTRACTOR);
        saasus.sdk.e2e.support.Snapshots.attach(engine, config, "billing");

        List<StoryResult> results = engine.executeStories(BillingStories.all());
        engine.printResults(results);

        boolean allPassed = true;
        for (StoryResult result : results) {
            if (!result.isSuccess()) {
                allPassed = false;
            }
        }

        assertTrue(allPassed, "some billing stories failed");
        if (!engine.coverage().isFullyCovered()) {
            fail("billing method coverage incomplete: untested = " + engine.coverage().untestedKeys());
        }
    }
}
