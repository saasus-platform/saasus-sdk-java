/*
 * SaaSus Communication API Schema
 * SaaSus Communication API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.communication.api;

import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.models.Comment;
import saasus.sdk.communication.models.CreateFeedbackCommentParam;
import saasus.sdk.communication.models.CreateFeedbackParam;
import saasus.sdk.communication.models.CreateVoteUserParam;
import saasus.sdk.communication.models.Error;
import saasus.sdk.communication.models.Feedback;
import saasus.sdk.communication.models.Feedbacks;
import saasus.sdk.communication.models.UpdateFeedbackCommentParam;
import saasus.sdk.communication.models.UpdateFeedbackParam;
import saasus.sdk.communication.models.UpdateFeedbackStatusParam;
import saasus.sdk.communication.models.Votes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FeedbackApi
 */
@Disabled
public class FeedbackApiTest {

    private final FeedbackApi api = new FeedbackApi();

    /**
     * フィードバックを起票
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createFeedbackTest() throws ApiException {
        CreateFeedbackParam createFeedbackParam = null;
        Feedback response = api.createFeedback(createFeedbackParam);
        // TODO: test validations
    }

    /**
     * フィードバックへのコメント
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createFeedbackCommentTest() throws ApiException {
        String feedbackId = null;
        CreateFeedbackCommentParam createFeedbackCommentParam = null;
        Comment response = api.createFeedbackComment(feedbackId, createFeedbackCommentParam);
        // TODO: test validations
    }

    /**
     * フィードバックへの投票
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createVoteUserTest() throws ApiException {
        String feedbackId = null;
        CreateVoteUserParam createVoteUserParam = null;
        Votes response = api.createVoteUser(feedbackId, createVoteUserParam);
        // TODO: test validations
    }

    /**
     * フィードバックの削除
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteFeedbackTest() throws ApiException {
        String feedbackId = null;
        api.deleteFeedback(feedbackId);
        // TODO: test validations
    }

    /**
     * フィードバックへのコメント削除
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteFeedbackCommentTest() throws ApiException {
        String feedbackId = null;
        String commentId = null;
        api.deleteFeedbackComment(feedbackId, commentId);
        // TODO: test validations
    }

    /**
     * フィードバックへの投票の取消
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteVoteForFeedbackTest() throws ApiException {
        String feedbackId = null;
        String userId = null;
        api.deleteVoteForFeedback(feedbackId, userId);
        // TODO: test validations
    }

    /**
     * フィードバックの取得
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getFeedbackTest() throws ApiException {
        String feedbackId = null;
        Feedback response = api.getFeedback(feedbackId);
        // TODO: test validations
    }

    /**
     * フィードバックへのコメント取得
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getFeedbackCommentTest() throws ApiException {
        String feedbackId = null;
        String commentId = null;
        Comment response = api.getFeedbackComment(feedbackId, commentId);
        // TODO: test validations
    }

    /**
     * フィードバックの一覧を取得
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getFeedbacksTest() throws ApiException {
        Feedbacks response = api.getFeedbacks();
        // TODO: test validations
    }

    /**
     * フィードバックの編集
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateFeedbackTest() throws ApiException {
        String feedbackId = null;
        UpdateFeedbackParam updateFeedbackParam = null;
        api.updateFeedback(feedbackId, updateFeedbackParam);
        // TODO: test validations
    }

    /**
     * フィードバックへのコメント編集
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateFeedbackCommentTest() throws ApiException {
        String feedbackId = null;
        String commentId = null;
        UpdateFeedbackCommentParam updateFeedbackCommentParam = null;
        api.updateFeedbackComment(feedbackId, commentId, updateFeedbackCommentParam);
        // TODO: test validations
    }

    /**
     * フィードバックのステータス更新
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateFeedbackStatusTest() throws ApiException {
        String feedbackId = null;
        UpdateFeedbackStatusParam updateFeedbackStatusParam = null;
        api.updateFeedbackStatus(feedbackId, updateFeedbackStatusParam);
        // TODO: test validations
    }

}
