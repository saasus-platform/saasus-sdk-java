package saasus.sdk.e2e.communication;

import saasus.sdk.communication.models.Comment;
import saasus.sdk.communication.models.CreateFeedbackCommentParam;
import saasus.sdk.communication.models.CreateFeedbackParam;
import saasus.sdk.communication.models.CreateVoteUserParam;
import saasus.sdk.communication.models.Feedback;
import saasus.sdk.communication.models.UpdateFeedbackCommentParam;
import saasus.sdk.communication.models.UpdateFeedbackParam;
import saasus.sdk.communication.models.UpdateFeedbackStatusParam;

import java.util.Map;

/**
 * Parameter builders and response extraction for communication (feedback) E2E stories.
 *
 * <p>Mirrors the Go reference builders in {@code communicationapi/validation.go}: fixed titles /
 * bodies for create and update, {@code status = 1} for the status update, and the vote/comment
 * user id resolved from {@code TEST_USER_ID} (default all-zero UUID) or the story variables.
 */
final class CommunicationParams {

    static final String USER_ID_ENV = "TEST_USER_ID";
    static final String DEFAULT_USER_ID = "00000000-0000-0000-0000-000000000000";

    private CommunicationParams() {
    }

    // ---- user id ----------------------------------------------------------------

    /** Resolves the vote/feedback user id: story variable, then {@code TEST_USER_ID}, then default. */
    static String userId(Map<String, Object> vars) {
        Object v = vars.get("user_id");
        if (v != null && !v.toString().isEmpty()) {
            return v.toString();
        }
        return testUserId();
    }

    private static String testUserId() {
        String env = System.getenv(USER_ID_ENV);
        return (env != null && !env.isEmpty()) ? env : DEFAULT_USER_ID;
    }

    /** Seeds the initial {@code user_id} story variable from the environment (or default). */
    static void seedUserId(Map<String, Object> vars) {
        vars.put("user_id", testUserId());
    }

    // ---- path parameters --------------------------------------------------------

    static String feedbackId(Map<String, Object> vars) {
        return require(vars, "feedback_id");
    }

    static String commentId(Map<String, Object> vars) {
        return require(vars, "comment_id");
    }

    private static String require(Map<String, Object> vars, String key) {
        Object v = vars.get(key);
        if (v == null || v.toString().isEmpty()) {
            throw new IllegalStateException("required variable '" + key + "' is missing");
        }
        return v.toString();
    }

    // ---- request bodies ---------------------------------------------------------

    static CreateFeedbackParam createFeedbackParam(Map<String, Object> vars) {
        CreateFeedbackParam param = new CreateFeedbackParam();
        param.setUserId(userId(vars));
        param.setFeedbackTitle("Test Feedback Title");
        param.setFeedbackDescription("Test Feedback Description for E2E testing");
        return param;
    }

    static UpdateFeedbackParam updateFeedbackParam() {
        UpdateFeedbackParam param = new UpdateFeedbackParam();
        param.setFeedbackTitle("Updated Feedback Title");
        param.setFeedbackDescription("Updated Feedback Description");
        return param;
    }

    static UpdateFeedbackStatusParam updateFeedbackStatusParam() {
        UpdateFeedbackStatusParam param = new UpdateFeedbackStatusParam();
        param.setStatus(1);
        return param;
    }

    static CreateFeedbackCommentParam createFeedbackCommentParam() {
        CreateFeedbackCommentParam param = new CreateFeedbackCommentParam();
        param.setBody("Test comment body");
        return param;
    }

    static UpdateFeedbackCommentParam updateFeedbackCommentParam() {
        UpdateFeedbackCommentParam param = new UpdateFeedbackCommentParam();
        param.setBody("Updated comment body");
        return param;
    }

    static CreateVoteUserParam createVoteUserParam(Map<String, Object> vars) {
        CreateVoteUserParam param = new CreateVoteUserParam();
        param.setUserId(userId(vars));
        return param;
    }

    // ---- response extraction ----------------------------------------------------

    static void extractFeedbackId(Object response, Map<String, Object> vars) {
        if (response instanceof Feedback) {
            String id = ((Feedback) response).getId();
            if (id != null && !id.isEmpty()) {
                vars.put("feedback_id", id);
            }
        }
    }

    static void extractCommentId(Object response, Map<String, Object> vars) {
        if (response instanceof Comment) {
            String id = ((Comment) response).getId();
            if (id != null && !id.isEmpty()) {
                vars.put("comment_id", id);
            }
        }
    }
}
