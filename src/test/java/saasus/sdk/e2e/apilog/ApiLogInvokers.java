package saasus.sdk.e2e.apilog;

import com.google.gson.reflect.TypeToken;
import okhttp3.Request;
import saasus.sdk.apilog.ApiCallback;
import saasus.sdk.apilog.ApiException;
import saasus.sdk.apilog.ApiResponse;
import saasus.sdk.apilog.api.ApiLogApi;
import saasus.sdk.apilog.models.ApiLog;
import saasus.sdk.apilog.models.ApiLogs;
import saasus.sdk.e2e.support.ThrowingCallSupplier;
import saasus.sdk.modules.ApiLogApiClient;
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
 * Registers apilog methods ({@code getLogs}, {@code getLog}) across all four call styles.
 *
 * <p>See {@code billing.BillingInvokers} for the signing rationale: async requests are signed
 * manually because {@link ApiLogApiClient} only signs the synchronous {@code execute} path.
 */
final class ApiLogInvokers {

    private static final Type LOGS_TYPE = new TypeToken<ApiLogs>() {
    }.getType();
    private static final Type LOG_TYPE = new TypeToken<ApiLog>() {
    }.getType();

    private final ApiLogApi api;
    private final ApiLogApiClient client;

    ApiLogInvokers(ApiLogApi api, ApiLogApiClient client) {
        this.api = api;
        this.client = client;
    }

    MethodRegistry buildRegistry() {
        MethodRegistry registry = new MethodRegistry();

        registry.register("getLogs", make(
                vars -> api.getLogs(ApiLogParams.createdDate(vars), ApiLogParams.createdAt(vars),
                        ApiLogParams.limit(vars), ApiLogParams.cursor(vars)),
                vars -> httpInfo(api.getLogsWithHttpInfo(ApiLogParams.createdDate(vars),
                        ApiLogParams.createdAt(vars), ApiLogParams.limit(vars), ApiLogParams.cursor(vars))),
                vars -> api.getLogsCall(ApiLogParams.createdDate(vars), ApiLogParams.createdAt(vars),
                        ApiLogParams.limit(vars), ApiLogParams.cursor(vars), null),
                LOGS_TYPE));

        registry.register("getLog", make(
                vars -> api.getLog(ApiLogParams.apiLogId(vars)),
                vars -> httpInfo(api.getLogWithHttpInfo(ApiLogParams.apiLogId(vars))),
                vars -> api.getLogCall(ApiLogParams.apiLogId(vars), null),
                LOG_TYPE));

        return registry;
    }

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
