package saasus.sdk.e2e.communication;

import org.junit.jupiter.api.Test;
import saasus.sdk.communication.api.FeedbackApi;
import saasus.sdk.modules.CommunicationApiClient;
import saasus.sdk.modules.Configuration;
import saasus.sdk.testlib.ApiError;
import saasus.sdk.testlib.ApiErrorExtractor;
import saasus.sdk.testlib.Config;
import saasus.sdk.testlib.E2EEngine;
import saasus.sdk.testlib.LifecycleAction;
import saasus.sdk.testlib.MethodRegistry;
import saasus.sdk.testlib.StoryResult;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Live E2E test for the SaaSus communication (feedback) API. Runs only via
 * {@code mvn verify -Pe2e}; requires {@code SAASUS_SAAS_ID} / {@code SAASUS_API_KEY} /
 * {@code SAASUS_SECRET_KEY}. Fails fast when credentials are missing.
 */
public class CommunicationApiE2ETest {

    private static final ApiErrorExtractor ERROR_EXTRACTOR = throwable -> {
        if (throwable instanceof saasus.sdk.communication.ApiException) {
            saasus.sdk.communication.ApiException e = (saasus.sdk.communication.ApiException) throwable;
            return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
        }
        return null;
    };

    @Test
    public void communicationApiE2E() {
        Config config = Config.fromEnv();
        if (!config.dryRun) {
            config.validate();
        }

        CommunicationApiClient client = new Configuration().getCommunicationApiClient();
        FeedbackApi api = new FeedbackApi(client);

        MethodRegistry registry = new CommunicationInvokers(api, client).buildRegistry();
        E2EEngine engine = new E2EEngine(registry, config, ERROR_EXTRACTOR);
        saasus.sdk.e2e.support.Snapshots.attach(engine, config, "communication");

        List<StoryResult> results = engine.executeStories(CommunicationStories.all(bestEffortCleanup(api)));
        engine.printResults(results);

        boolean allPassed = true;
        for (StoryResult result : results) {
            if (!result.isSuccess()) {
                allPassed = false;
            }
        }

        assertTrue(allPassed, "some communication stories failed");
        if (!engine.coverage().isFullyCovered()) {
            fail("communication method coverage incomplete: untested = " + engine.coverage().untestedKeys());
        }
    }

    /**
     * Best-effort cleanup: if a {@code feedback_id} survived the story (e.g. a mid-flow failure
     * left it undeleted), try to delete it so the tenant does not accumulate test feedback.
     * Cleanup failures are swallowed so they never mask an earlier story failure.
     */
    private static LifecycleAction bestEffortCleanup(FeedbackApi api) {
        return (Map<String, Object> vars) -> {
            Object id = vars.get("feedback_id");
            if (id == null || id.toString().isEmpty()) {
                return;
            }
            try {
                api.deleteFeedback(id.toString());
            } catch (Exception ignored) {
                // best-effort only
            }
        };
    }
}
