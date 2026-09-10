package saasus.sdk.e2e.apilog;

import saasus.sdk.testlib.CallStyle;
import saasus.sdk.testlib.Step;
import saasus.sdk.testlib.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * apilog test stories, mirroring the Go reference flow
 * (Pre_GetApiLogs &rarr; GetApiLogs &rarr; GetApiLogs With QueryParameters &rarr; GetApiLog).
 *
 * <p>The flow is replicated once per {@link CallStyle}; together the variants cover every
 * {@code (method, style)} pair for {@code getLogs} and {@code getLog}. Range-search stories from
 * the Postman collection are intentionally excluded (unsupported by the Java SDK).
 */
final class ApiLogStories {

    private ApiLogStories() {
    }

    static List<Story> all() {
        List<Story> stories = new ArrayList<Story>();
        for (CallStyle style : CallStyle.values()) {
            stories.add(story(style));
        }
        return stories;
    }

    private static Story story(CallStyle style) {
        return Story.builder("API Logs retrieval - " + style)
                .description("Reproduces the Postman collection apilog flow using the " + style + " call style")
                .module("apilog")
                .step(Step.builder("Pre_GetApiLogs", "getLogs")
                        .callStyle(style)
                        .expectedStatus(200)
                        .stateUpdate(ApiLogParams::extractFromLogs)
                        .build())
                // Re-capture on every getLogs step: on a fresh tenant the first call returns an
                // empty list, but each authenticated request is itself logged, so a later getLogs
                // (after the suite's own traffic) yields an api_log_id for the GetApiLog step
                // instead of failing on an empty collection.
                .step(Step.builder("GetApiLogs", "getLogs")
                        .callStyle(style)
                        .expectedStatus(200)
                        .stateUpdate(ApiLogParams::extractFromLogs)
                        .build())
                .step(Step.builder("GetApiLogs With QueryParameters", "getLogs")
                        .callStyle(style)
                        .expectedStatus(200)
                        .input(ApiLogParams.QUERY_MODE_KEY, ApiLogParams.QUERY_MODE_WITH)
                        .stateUpdate(ApiLogParams::extractFromLogs)
                        .build())
                .step(Step.builder("GetApiLog", "getLog")
                        .callStyle(style)
                        .expectedStatus(200)
                        .build())
                .build();
    }
}
