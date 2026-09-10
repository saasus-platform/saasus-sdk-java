package saasus.sdk.e2e.communication;

import saasus.sdk.testlib.CallStyle;
import saasus.sdk.testlib.LifecycleAction;
import saasus.sdk.testlib.StateUpdate;
import saasus.sdk.testlib.Step;
import saasus.sdk.testlib.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Communication (feedback) test stories, mirroring the Go reference flow
 * (GetFeedbacks &rarr; CreateFeedback &rarr; GetFeedback &rarr; UpdateFeedback &rarr;
 * UpdateFeedbackStatus &rarr; CreateFeedbackComment &rarr; GetFeedbackComment &rarr;
 * UpdateFeedbackComment &rarr; CreateVoteUser &rarr; DeleteVoteForFeedback &rarr;
 * DeleteFeedbackComment &rarr; DeleteFeedback).
 *
 * <p>The Go SDK exercised two method families (standard / WithResponse, each with a WithBody
 * variant). The Java testlib exposes four call styles, so the same flow is replicated once per
 * {@link CallStyle}; together the four variants cover every {@code (method, style)} pair in the
 * communication coverage universe.
 */
final class CommunicationStories {

    private static final int OK = 200;
    private static final int CREATED = 201;

    private CommunicationStories() {
    }

    static List<Story> all(LifecycleAction cleanup) {
        List<Story> stories = new ArrayList<Story>();
        for (CallStyle style : CallStyle.values()) {
            stories.add(story(style, cleanup));
        }
        return stories;
    }

    private static Story story(CallStyle style, LifecycleAction cleanup) {
        return Story.builder("Feedback lifecycle - " + style)
                .description("Reproduces the Postman collection communication flow using the " + style + " call style")
                .module("communication")
                .setup(CommunicationParams::seedUserId)
                .step(step("GetFeedbacks", "getFeedbacks", style, OK, null))
                .step(step("CreateFeedback", "createFeedback", style, CREATED, CommunicationParams::extractFeedbackId))
                .step(step("GetFeedback", "getFeedback", style, OK, null))
                .step(step("UpdateFeedback", "updateFeedback", style, OK, null))
                .step(step("UpdateFeedbackStatus", "updateFeedbackStatus", style, OK, null))
                .step(step("CreateFeedbackComment", "createFeedbackComment", style, CREATED,
                        CommunicationParams::extractCommentId))
                .step(step("GetFeedbackComment", "getFeedbackComment", style, OK, null))
                .step(step("UpdateFeedbackComment", "updateFeedbackComment", style, OK, null))
                .step(step("CreateVoteUser", "createVoteUser", style, CREATED, null))
                .step(step("DeleteVoteForFeedback", "deleteVoteForFeedback", style, OK, null))
                .step(step("DeleteFeedbackComment", "deleteFeedbackComment", style, OK, null))
                .step(step("DeleteFeedback", "deleteFeedback", style, OK, null))
                .cleanup(cleanup)
                .build();
    }

    private static Step step(String name, String method, CallStyle style, int expectedStatus, StateUpdate stateUpdate) {
        Step.Builder builder = Step.builder(name, method)
                .callStyle(style)
                .expectedStatus(expectedStatus);
        if (stateUpdate != null) {
            builder.stateUpdate(stateUpdate);
        }
        return builder.build();
    }
}
