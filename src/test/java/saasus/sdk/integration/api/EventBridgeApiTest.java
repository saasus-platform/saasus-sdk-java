/*
 * SaaSus Eventbridge API Schema
 * SaaSus Eventbridge API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.integration.api;

import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.models.CreateEventBridgeEventParam;
import saasus.sdk.integration.models.Error;
import saasus.sdk.integration.models.EventBridgeSettings;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EventBridgeApi
 */
@Disabled
public class EventBridgeApiTest {

    private final EventBridgeApi api = new EventBridgeApi();

    /**
     * イベント連携の送信(Send Events)
     *
     * Amazon EventBridge へイベントを送信します。  Send events to Amazon EventBridge. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createEventBridgeEventTest() throws ApiException {
        CreateEventBridgeEventParam createEventBridgeEventParam = null;
        api.createEventBridgeEvent(createEventBridgeEventParam);
        // TODO: test validations
    }

    /**
     * イベント連携のテスト送信(Test EventBridge Connection)
     *
     * Amazon EventBridge との連携をテストする為のイベントを送信します。  Send events to test the connection with Amazon EventBridge. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createEventBridgeTestEventTest() throws ApiException {
        api.createEventBridgeTestEvent();
        // TODO: test validations
    }

    /**
     * イベント連携設定を削除(Delete EventBridge Settings)
     *
     * ホストの状態を Amazon EventBridge 経由で提供するための設定を解除します。  Delete settings used to provide host state via Amazon EventBridge. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteEventBridgeSettingsTest() throws ApiException {
        api.deleteEventBridgeSettings();
        // TODO: test validations
    }

    /**
     * イベント連携設定を取得(Get EventBridge Settings)
     *
     * 監視対象となっている全ホストの状態をリアルタイムにAmazon EventBridge 経由で提供するための設定を取得します。  Gets the settings for providing real-time status of all monitored hosts via Amazon EventBridge. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getEventBridgeSettingsTest() throws ApiException {
        EventBridgeSettings response = api.getEventBridgeSettings();
        // TODO: test validations
    }

    /**
     * イベント連携設定を更新(Update EventBridge Settings)
     *
     * ホストの状態を Amazon EventBridge 経由で提供するための設定を更新します。  Update configuration used to provide the host state via Amazon EventBridge. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void saveEventBridgeSettingsTest() throws ApiException {
        EventBridgeSettings body = null;
        api.saveEventBridgeSettings(body);
        // TODO: test validations
    }

}
