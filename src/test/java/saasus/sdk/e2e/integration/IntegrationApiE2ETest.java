package saasus.sdk.e2e.integration;

import org.junit.jupiter.api.Test;
import saasus.sdk.integration.api.EventBridgeApi;
import saasus.sdk.integration.models.EventBridgeSettings;
import saasus.sdk.modules.Configuration;
import saasus.sdk.modules.IntegrationApiClient;
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
 * Live E2E test for the SaaSus integration (EventBridge) API. Runs only via
 * {@code mvn verify -Pe2e}; requires {@code SAASUS_SAAS_ID} / {@code SAASUS_API_KEY} /
 * {@code SAASUS_SECRET_KEY}. Optional {@code TEST_AWS_ACCOUNT_ID} / {@code TEST_AWS_REGION}
 * override the EventBridge target (defaults {@code 267185063265} / {@code ap-northeast-1}).
 */
public class IntegrationApiE2ETest {

    private static final ApiErrorExtractor ERROR_EXTRACTOR = throwable -> {
        if (throwable instanceof saasus.sdk.integration.ApiException) {
            saasus.sdk.integration.ApiException e = (saasus.sdk.integration.ApiException) throwable;
            return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
        }
        return null;
    };

    @Test
    public void integrationApiE2E() {
        Config config = Config.fromEnv();
        if (!config.dryRun) {
            config.validate();
        }

        IntegrationApiClient client = new Configuration().getIntegrationApiClient();
        EventBridgeApi api = new EventBridgeApi(client);

        MethodRegistry registry = new IntegrationInvokers(api, client).buildRegistry();
        E2EEngine engine = new E2EEngine(registry, config, ERROR_EXTRACTOR);
        saasus.sdk.e2e.support.Snapshots.attach(engine, config, "integration");

        List<StoryResult> results = engine.executeStories(IntegrationStories.all(bestEffortCleanup(api)));
        engine.printResults(results);

        boolean allPassed = true;
        for (StoryResult result : results) {
            if (!result.isSuccess()) {
                allPassed = false;
            }
        }

        assertTrue(allPassed, "some integration stories failed");
        if (!engine.coverage().isFullyCovered()) {
            fail("integration method coverage incomplete: untested = " + engine.coverage().untestedKeys());
        }
    }

    /**
     * Best-effort cleanup: restore the tenant's EventBridge configuration to its pre-story state.
     * If settings existed before the story ran, they are re-saved; otherwise the settings created
     * by the story are deleted so the tenant returns to a clean state. Failures are swallowed so
     * they never mask an earlier story failure.
     */
    private static LifecycleAction bestEffortCleanup(EventBridgeApi api) {
        return (Map<String, Object> vars) -> {
            try {
                if (!Boolean.TRUE.equals(vars.get(IntegrationParams.INITIAL_READ_OK_VAR))) {
                    // The initial read never succeeded, so the prior state is unknown. Do nothing
                    // rather than risk deleting a real, pre-existing EventBridge configuration.
                    return;
                }
                Object initial = vars.get(IntegrationParams.INITIAL_SETTINGS_VAR);
                if (initial instanceof EventBridgeSettings
                        && ((EventBridgeSettings) initial).getAwsAccountId() != null
                        && !((EventBridgeSettings) initial).getAwsAccountId().isEmpty()) {
                    // A real integration existed before the story; restore it rather than deleting.
                    api.saveEventBridgeSettings((EventBridgeSettings) initial);
                } else {
                    // The initial read explicitly returned an unconfigured state; delete what the
                    // story created so the tenant returns to that clean state.
                    api.deleteEventBridgeSettings();
                }
            } catch (Exception ignored) {
                // best-effort only
            }
        };
    }
}
