package saasus.sdk.e2e.integration;

import saasus.sdk.testlib.CallStyle;
import saasus.sdk.testlib.LifecycleAction;
import saasus.sdk.testlib.Step;
import saasus.sdk.testlib.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Integration (EventBridge) test stories, mirroring the Go reference flow that merges the two
 * Postman folders (eventbridge-settings / eventbridge-events) into a single lifecycle:
 * Get &rarr; Save &rarr; Get &rarr; Delete &rarr; Get &rarr; Setup &rarr; Save &rarr; TestEvent &rarr;
 * SendEvent &rarr; Cleanup.
 *
 * <p>The Go SDK exercised four method families (standard / WithBody / WithResponse /
 * WithBodyWithResponse). The Java testlib exposes four call styles, so the same flow is replicated
 * once per {@link CallStyle}; together the four variants cover every {@code (method, style)} pair.
 *
 * <p>{@code CreateEventBridgeEvent} expects {@code 501 Not Implemented} — the endpoint is not
 * implemented server-side (matching the Go reference), so this is the documented expected value.
 */
final class IntegrationStories {

    private static final int OK = 200;
    private static final int CREATED = 201;
    private static final int NOT_IMPLEMENTED = 501;

    private IntegrationStories() {
    }

    static List<Story> all(LifecycleAction cleanup) {
        List<Story> stories = new ArrayList<Story>();
        for (CallStyle style : CallStyle.values()) {
            stories.add(story(style, cleanup));
        }
        return stories;
    }

    private static Story story(CallStyle style, LifecycleAction cleanup) {
        return Story.builder("EventBridge lifecycle - " + style)
                .description("Reproduces the Postman collection integration flow using the " + style + " call style")
                .module("integration")
                .step(Step.builder("Pre_GetEventBridgeSettings", "getEventBridgeSettings")
                        .callStyle(style).expectedStatus(OK)
                        .stateUpdate(IntegrationParams::captureInitialSettings).build())
                .step(step("SaveEventBridgeSettings", "saveEventBridgeSettings", style, OK))
                .step(step("GetEventBridgeSettings_AfterSave", "getEventBridgeSettings", style, OK))
                .step(step("DeleteEventBridgeSettings", "deleteEventBridgeSettings", style, OK))
                .step(step("GetEventBridgeSettings_AfterDelete", "getEventBridgeSettings", style, OK))
                .step(step("GetEventBridgeSettings_Setup", "getEventBridgeSettings", style, OK))
                .step(step("SaveEventBridgeSettings_ForTest", "saveEventBridgeSettings", style, OK))
                .step(step("CreateEventBridgeTestEvent", "createEventBridgeTestEvent", style, CREATED))
                .step(step("CreateEventBridgeEvent", "createEventBridgeEvent", style, NOT_IMPLEMENTED))
                .step(step("DeleteEventBridgeSettings_Cleanup", "deleteEventBridgeSettings", style, OK))
                .cleanup(cleanup)
                .build();
    }

    private static Step step(String name, String method, CallStyle style, int expectedStatus) {
        return Step.builder(name, method)
                .callStyle(style)
                .expectedStatus(expectedStatus)
                .build();
    }
}
