package saasus.sdk.e2e.integration;

import com.google.gson.reflect.TypeToken;
import okhttp3.Request;
import saasus.sdk.integration.ApiCallback;
import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.ApiResponse;
import saasus.sdk.integration.api.EventBridgeApi;
import saasus.sdk.integration.models.EventBridgeSettings;
import saasus.sdk.e2e.support.ThrowingCallSupplier;
import saasus.sdk.modules.IntegrationApiClient;
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
 * Registers the integration (EventBridge) API methods against a {@link MethodRegistry} using all
 * four call styles (NORMAL / WITH_HTTP_INFO / ASYNC / CALL).
 *
 * <p><b>Signing:</b> {@link IntegrationApiClient} only overrides {@code execute(Call, Type)} to
 * add the SaaSus SigV1 {@code Authorization} header; async requests are therefore signed manually
 * (as in {@code billing.BillingInvokers}) before being run through {@code executeAsync}.
 */
final class IntegrationInvokers {

    private static final Type SETTINGS_TYPE = new TypeToken<EventBridgeSettings>() {
    }.getType();

    private final EventBridgeApi api;
    private final IntegrationApiClient client;

    IntegrationInvokers(EventBridgeApi api, IntegrationApiClient client) {
        this.api = api;
        this.client = client;
    }

    MethodRegistry buildRegistry() {
        MethodRegistry registry = new MethodRegistry();

        registry.register("getEventBridgeSettings", make(
                vars -> api.getEventBridgeSettings(),
                vars -> httpInfo(api.getEventBridgeSettingsWithHttpInfo()),
                vars -> api.getEventBridgeSettingsCall(null),
                SETTINGS_TYPE));

        registry.register("saveEventBridgeSettings", make(
                vars -> {
                    api.saveEventBridgeSettings(IntegrationParams.saveEventBridgeSettings());
                    return null;
                },
                vars -> httpInfo(api.saveEventBridgeSettingsWithHttpInfo(IntegrationParams.saveEventBridgeSettings())),
                vars -> api.saveEventBridgeSettingsCall(IntegrationParams.saveEventBridgeSettings(), null),
                null));

        registry.register("deleteEventBridgeSettings", make(
                vars -> {
                    api.deleteEventBridgeSettings();
                    return null;
                },
                vars -> httpInfo(api.deleteEventBridgeSettingsWithHttpInfo()),
                vars -> api.deleteEventBridgeSettingsCall(null),
                null));

        registry.register("createEventBridgeTestEvent", make(
                vars -> {
                    api.createEventBridgeTestEvent();
                    return null;
                },
                vars -> httpInfo(api.createEventBridgeTestEventWithHttpInfo()),
                vars -> api.createEventBridgeTestEventCall(null),
                null));

        registry.register("createEventBridgeEvent", make(
                vars -> {
                    api.createEventBridgeEvent(IntegrationParams.createEventBridgeEventParam());
                    return null;
                },
                vars -> httpInfo(api.createEventBridgeEventWithHttpInfo(IntegrationParams.createEventBridgeEventParam())),
                vars -> api.createEventBridgeEventCall(IntegrationParams.createEventBridgeEventParam(), null),
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
