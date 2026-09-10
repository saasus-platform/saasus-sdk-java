package saasus.sdk.e2e.pricing;

import org.junit.jupiter.api.Test;
import saasus.sdk.modules.Configuration;
import saasus.sdk.modules.PricingApiClient;
import saasus.sdk.testlib.ApiError;
import saasus.sdk.testlib.ApiErrorExtractor;
import saasus.sdk.testlib.Config;
import saasus.sdk.testlib.E2EEngine;
import saasus.sdk.testlib.LifecycleAction;
import saasus.sdk.testlib.MethodRegistry;
import saasus.sdk.testlib.StoryResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Live E2E test for the SaaSus pricing API. Runs only via {@code mvn verify -Pe2e}; requires
 * {@code SAASUS_SAAS_ID} / {@code SAASUS_API_KEY} / {@code SAASUS_SECRET_KEY} and an existing
 * tenant supplied via {@code TEST_TENANT_ID} (used by the tenant-scoped metering endpoints).
 * Fails fast when credentials are missing.
 */
public class PricingApiE2ETest {

    private static final ApiErrorExtractor ERROR_EXTRACTOR = throwable -> {
        if (throwable instanceof saasus.sdk.pricing.ApiException) {
            saasus.sdk.pricing.ApiException e = (saasus.sdk.pricing.ApiException) throwable;
            return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
        }
        return null;
    };

    @Test
    public void pricingApiE2E() {
        Config config = Config.fromEnv();
        if (!config.dryRun) {
            config.validate();
            PricingParams.requireTenantId(); // fail fast before any resource is created/mutated
        }

        PricingApiClient client = new Configuration().getPricingApiClient();
        PricingInvokers invokers = new PricingInvokers(client);
        MethodRegistry registry = invokers.buildRegistry();
        E2EEngine engine = new E2EEngine(registry, config, ERROR_EXTRACTOR);
        saasus.sdk.e2e.support.Snapshots.attach(engine, config, "pricing");

        LifecycleAction cleanup = vars -> invokers.deleteAllQuietly();
        List<StoryResult> results = engine.executeStories(PricingStories.all(cleanup));
        engine.printResults(results);

        boolean allPassed = true;
        for (StoryResult result : results) {
            if (!result.isSuccess()) {
                allPassed = false;
            }
        }

        assertTrue(allPassed, "some pricing stories failed");
        if (!engine.coverage().isFullyCovered()) {
            fail("pricing method coverage incomplete: untested = " + engine.coverage().untestedKeys());
        }
    }
}
