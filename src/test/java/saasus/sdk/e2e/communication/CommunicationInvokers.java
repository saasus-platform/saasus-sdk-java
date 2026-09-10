package saasus.sdk.e2e.communication;

import com.google.gson.reflect.TypeToken;
import okhttp3.Request;
import saasus.sdk.communication.ApiCallback;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.ApiResponse;
import saasus.sdk.communication.api.FeedbackApi;
import saasus.sdk.communication.models.Comment;
import saasus.sdk.communication.models.Feedback;
import saasus.sdk.communication.models.Feedbacks;
import saasus.sdk.communication.models.Votes;
import saasus.sdk.e2e.support.ThrowingCallSupplier;
import saasus.sdk.modules.CommunicationApiClient;
import saasus.sdk.modules.Utils;
import saasus.sdk.testlib.AsyncSink;
import saasus.sdk.testlib.HttpInfo;
import saasus.sdk.testlib.HttpInfoCall;
import saasus.sdk.testlib.MethodInvokers;
import saasus.sdk.testlib.MethodRegistry;
import saasus.sdk.testlib.NormalCall;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Registers the communication (feedback) API methods against a {@link MethodRegistry} using all
 * four call styles (NORMAL / WITH_HTTP_INFO / ASYNC / CALL).
 *
 * <p><b>Signing:</b> {@link CommunicationApiClient} only overrides {@code execute(Call, Type)} to
 * add the SaaSus SigV1 {@code Authorization} header; it does <em>not</em> override
 * {@code executeAsync}. The ASYNC style therefore builds the unsigned call, signs it exactly as
 * {@code execute} does, and runs it through {@code executeAsync}; the CALL style relies on
 * {@code client.execute(...)}, which re-signs. This mirrors {@code billing.BillingInvokers}.
 */
final class CommunicationInvokers {

    private static final Type FEEDBACKS_TYPE = new TypeToken<Feedbacks>() {
    }.getType();
    private static final Type FEEDBACK_TYPE = new TypeToken<Feedback>() {
    }.getType();
    private static final Type COMMENT_TYPE = new TypeToken<Comment>() {
    }.getType();
    private static final Type VOTES_TYPE = new TypeToken<Votes>() {
    }.getType();

    private final FeedbackApi api;
    private final CommunicationApiClient client;

    CommunicationInvokers(FeedbackApi api, CommunicationApiClient client) {
        this.api = api;
        this.client = client;
    }

    MethodRegistry buildRegistry() {
        MethodRegistry registry = new MethodRegistry();

        registry.register("getFeedbacks", make(
                vars -> api.getFeedbacks(),
                vars -> httpInfo(api.getFeedbacksWithHttpInfo()),
                vars -> api.getFeedbacksCall(null),
                FEEDBACKS_TYPE));

        registry.register("createFeedback", make(
                vars -> api.createFeedback(CommunicationParams.createFeedbackParam(vars)),
                vars -> httpInfo(api.createFeedbackWithHttpInfo(CommunicationParams.createFeedbackParam(vars))),
                vars -> api.createFeedbackCall(CommunicationParams.createFeedbackParam(vars), null),
                FEEDBACK_TYPE));

        registry.register("getFeedback", make(
                vars -> api.getFeedback(CommunicationParams.feedbackId(vars)),
                vars -> httpInfo(api.getFeedbackWithHttpInfo(CommunicationParams.feedbackId(vars))),
                vars -> api.getFeedbackCall(CommunicationParams.feedbackId(vars), null),
                FEEDBACK_TYPE));

        registry.register("updateFeedback", make(
                vars -> {
                    api.updateFeedback(CommunicationParams.feedbackId(vars), CommunicationParams.updateFeedbackParam());
                    return null;
                },
                vars -> httpInfo(api.updateFeedbackWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.updateFeedbackParam())),
                vars -> api.updateFeedbackCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.updateFeedbackParam(), null),
                null));

        registry.register("updateFeedbackStatus", make(
                vars -> {
                    api.updateFeedbackStatus(CommunicationParams.feedbackId(vars),
                            CommunicationParams.updateFeedbackStatusParam());
                    return null;
                },
                vars -> httpInfo(api.updateFeedbackStatusWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.updateFeedbackStatusParam())),
                vars -> api.updateFeedbackStatusCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.updateFeedbackStatusParam(), null),
                null));

        registry.register("createFeedbackComment", make(
                vars -> api.createFeedbackComment(CommunicationParams.feedbackId(vars),
                        CommunicationParams.createFeedbackCommentParam()),
                vars -> httpInfo(api.createFeedbackCommentWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.createFeedbackCommentParam())),
                vars -> api.createFeedbackCommentCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.createFeedbackCommentParam(), null),
                COMMENT_TYPE));

        registry.register("getFeedbackComment", make(
                vars -> api.getFeedbackComment(CommunicationParams.feedbackId(vars),
                        CommunicationParams.commentId(vars)),
                vars -> httpInfo(api.getFeedbackCommentWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.commentId(vars))),
                vars -> api.getFeedbackCommentCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.commentId(vars), null),
                COMMENT_TYPE));

        registry.register("updateFeedbackComment", make(
                vars -> {
                    api.updateFeedbackComment(CommunicationParams.feedbackId(vars),
                            CommunicationParams.commentId(vars), CommunicationParams.updateFeedbackCommentParam());
                    return null;
                },
                vars -> httpInfo(api.updateFeedbackCommentWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.commentId(vars), CommunicationParams.updateFeedbackCommentParam())),
                vars -> api.updateFeedbackCommentCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.commentId(vars), CommunicationParams.updateFeedbackCommentParam(), null),
                null));

        registry.register("createVoteUser", make(
                vars -> api.createVoteUser(CommunicationParams.feedbackId(vars),
                        CommunicationParams.createVoteUserParam(vars)),
                vars -> httpInfo(api.createVoteUserWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.createVoteUserParam(vars))),
                vars -> api.createVoteUserCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.createVoteUserParam(vars), null),
                VOTES_TYPE));

        registry.register("deleteVoteForFeedback", make(
                vars -> {
                    api.deleteVoteForFeedback(CommunicationParams.feedbackId(vars), CommunicationParams.userId(vars));
                    return null;
                },
                vars -> httpInfo(api.deleteVoteForFeedbackWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.userId(vars))),
                vars -> api.deleteVoteForFeedbackCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.userId(vars), null),
                null));

        registry.register("deleteFeedbackComment", make(
                vars -> {
                    api.deleteFeedbackComment(CommunicationParams.feedbackId(vars), CommunicationParams.commentId(vars));
                    return null;
                },
                vars -> httpInfo(api.deleteFeedbackCommentWithHttpInfo(CommunicationParams.feedbackId(vars),
                        CommunicationParams.commentId(vars))),
                vars -> api.deleteFeedbackCommentCall(CommunicationParams.feedbackId(vars),
                        CommunicationParams.commentId(vars), null),
                null));

        registry.register("deleteFeedback", make(
                vars -> {
                    api.deleteFeedback(CommunicationParams.feedbackId(vars));
                    return null;
                },
                vars -> httpInfo(api.deleteFeedbackWithHttpInfo(CommunicationParams.feedbackId(vars))),
                vars -> api.deleteFeedbackCall(CommunicationParams.feedbackId(vars), null),
                null));

        return registry;
    }

    // ---- style assembly ---------------------------------------------------------

    private MethodInvokers make(NormalCall normal, HttpInfoCall httpInfo,
                                ThrowingCallSupplier callFactory, Type returnType) {
        return MethodInvokers.builder()
                .normal(normal)
                .withHttpInfo(httpInfo)
                .async((vars, sink) -> asyncSigned(vars, callFactory, returnType, sink))
                .call((vars, sink) -> callSigned(vars, callFactory, returnType, sink))
                .build();
    }

    private static HttpInfo httpInfo(ApiResponse<?> response) {
        return new HttpInfo(response.getData(), response.getStatusCode(), response.getHeaders());
    }

    private void asyncSigned(Map<String, Object> vars, ThrowingCallSupplier callFactory,
                             Type returnType, AsyncSink sink) throws Exception {
        okhttp3.Call unsigned = callFactory.get(vars);
        String signature = Utils.withSaasusSigV1(unsigned);
        Request signedRequest = unsigned.request().newBuilder().header("Authorization", signature).build();
        okhttp3.Call signed = client.getHttpClient().newCall(signedRequest);
        client.executeAsync(signed, returnType, new ApiCallback<Object>() {
            @Override
            public void onSuccess(Object result, int statusCode, Map<String, List<String>> headers) {
                sink.onSuccess(result, statusCode, headers);
            }

            @Override
            public void onFailure(ApiException e, int statusCode, Map<String, List<String>> headers) {
                sink.onFailure(e, statusCode, headers);
            }

            @Override
            public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
            }

            @Override
            public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
            }
        });
    }

    private void callSigned(Map<String, Object> vars, ThrowingCallSupplier callFactory,
                            Type returnType, AsyncSink sink) {
        try {
            okhttp3.Call unsigned = callFactory.get(vars);
            ApiResponse<?> response = (returnType == null)
                    ? client.execute(unsigned)
                    : client.execute(unsigned, returnType);
            sink.onSuccess(response.getData(), response.getStatusCode(), response.getHeaders());
        } catch (ApiException e) {
            sink.onFailure(e, e.getCode(), e.getResponseHeaders());
        } catch (Exception e) {
            sink.onFailure(e, 0, null);
        }
    }
}
