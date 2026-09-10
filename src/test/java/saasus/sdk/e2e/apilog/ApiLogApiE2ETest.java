package saasus.sdk.e2e.apilog;

import org.junit.jupiter.api.Test;
import saasus.sdk.apilog.api.ApiLogApi;
import saasus.sdk.modules.ApiLogApiClient;
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
 * Live E2E test for the SaaSus apilog API. Runs only via {@code mvn verify -Pe2e}; requires
 * {@code SAASUS_SAAS_ID} / {@code SAASUS_API_KEY} / {@code SAASUS_SECRET_KEY}. Fails fast when
 * credentials are missing.
 */
public class ApiLogApiE2ETest {

    private static final ApiErrorExtractor ERROR_EXTRACTOR = throwable -> {
        if (throwable instanceof saasus.sdk.apilog.ApiException) {
            saasus.sdk.apilog.ApiException e = (saasus.sdk.apilog.ApiException) throwable;
            return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
        }
        return null;
    };

    @Test
    public void apiLogApiE2E() {
        Config config = Config.fromEnv();
        if (!config.dryRun) {
            config.validate();
        }

        ApiLogApiClient client = new Configuration().getApiLogApiClient();
        ApiLogApi api = new ApiLogApi(client);

        MethodRegistry registry = new ApiLogInvokers(api, client).buildRegistry();
        E2EEngine engine = new E2EEngine(registry, config, ERROR_EXTRACTOR);
        saasus.sdk.e2e.support.Snapshots.attach(engine, config, "apilog");

        List<StoryResult> results = engine.executeStories(ApiLogStories.all());
        engine.printResults(results);

        boolean allPassed = true;
        for (StoryResult result : results) {
            if (!result.isSuccess()) {
                allPassed = false;
            }
        }

        assertTrue(allPassed, "some apilog stories failed");
        if (!engine.coverage().isFullyCovered()) {
            fail("apilog method coverage incomplete: untested = " + engine.coverage().untestedKeys());
        }
    }
}
