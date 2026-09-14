package saasus.sdk.e2e.integration;

import saasus.sdk.integration.models.AwsRegion;
import saasus.sdk.integration.models.CreateEventBridgeEventParam;
import saasus.sdk.integration.models.EventBridgeSettings;
import saasus.sdk.integration.models.EventMessage;

import java.util.Collections;
import java.util.Map;

/**
 * Parameter builders for integration (EventBridge) E2E stories.
 *
 * <p>Mirrors the Go reference builders in {@code integrationapi/validation.go}: the AWS account id
 * and region come from {@code TEST_AWS_ACCOUNT_ID} / {@code TEST_AWS_REGION} (defaults
 * {@code 267185063265} / {@code ap-northeast-1}), and a single {@code api_call / create_user}
 * event message is used for {@code CreateEventBridgeEvent}.
 */
final class IntegrationParams {

    static final String AWS_ACCOUNT_ID_ENV = "TEST_AWS_ACCOUNT_ID";
    static final String AWS_REGION_ENV = "TEST_AWS_REGION";
    static final String DEFAULT_AWS_ACCOUNT_ID = "267185063265";
    static final String DEFAULT_AWS_REGION = "ap-northeast-1";

    /** Story-variable key holding the EventBridge settings that existed before the story ran. */
    static final String INITIAL_SETTINGS_VAR = "initial_eventbridge_settings";

    /** Story-variable key flagging that the initial {@code getEventBridgeSettings} read succeeded. */
    static final String INITIAL_READ_OK_VAR = "initial_eventbridge_read_ok";

    private IntegrationParams() {
    }

    /**
     * {@link saasus.sdk.testlib.StateUpdate} for the first {@code getEventBridgeSettings} step:
     * remembers the tenant's pre-existing EventBridge configuration (if any) so the cleanup hook can
     * restore it instead of destroying a real integration. Because this only runs when the read
     * succeeds, it also records {@link #INITIAL_READ_OK_VAR} so cleanup can tell a genuine
     * unconfigured state apart from a failed initial read.
     */
    static void captureInitialSettings(Object response, Map<String, Object> vars) {
        if (response instanceof EventBridgeSettings) {
            vars.put(INITIAL_SETTINGS_VAR, response);
            vars.put(INITIAL_READ_OK_VAR, Boolean.TRUE);
        }
    }

    static String awsAccountId() {
        String env = System.getenv(AWS_ACCOUNT_ID_ENV);
        return (env != null && !env.isEmpty()) ? env : DEFAULT_AWS_ACCOUNT_ID;
    }

    static AwsRegion awsRegion() {
        String env = System.getenv(AWS_REGION_ENV);
        String value = (env != null && !env.isEmpty()) ? env : DEFAULT_AWS_REGION;
        return AwsRegion.fromValue(value);
    }

    /** {@code EventBridgeSettings} save body (Java SDK's {@code saveEventBridgeSettings} takes the settings directly). */
    static EventBridgeSettings saveEventBridgeSettings() {
        EventBridgeSettings settings = new EventBridgeSettings();
        settings.setAwsAccountId(awsAccountId());
        settings.setAwsRegion(awsRegion());
        return settings;
    }

    static CreateEventBridgeEventParam createEventBridgeEventParam() {
        EventMessage message = new EventMessage();
        message.setEventType("api_call");
        message.setEventDetailType("create_user");
        message.setMessage("{id:8b79528a-ec3b-4f68-b7c4-d793e3894561,name:test222}");

        CreateEventBridgeEventParam param = new CreateEventBridgeEventParam();
        param.setEventMessages(Collections.singletonList(message));
        return param;
    }
}
