package saasus.sdk.e2e.billing;

import com.google.gson.reflect.TypeToken;
import okhttp3.Request;
import saasus.sdk.billing.ApiCallback;
import saasus.sdk.billing.ApiException;
import saasus.sdk.billing.ApiResponse;
import saasus.sdk.billing.api.StripeApi;
import saasus.sdk.billing.models.StripeInfo;
import saasus.sdk.e2e.support.ThrowingCallSupplier;
import saasus.sdk.modules.BillingApiClient;
import saasus.sdk.modules.Utils;
import saasus.sdk.testlib.AsyncSink;
import saasus.sdk.testlib.HttpInfo;
import saasus.sdk.testlib.MethodInvokers;
import saasus.sdk.testlib.MethodRegistry;
import saasus.sdk.testlib.NormalCall;
import saasus.sdk.testlib.HttpInfoCall;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Registers the billing (Stripe) API methods against a {@link MethodRegistry} using all four
 * call styles (NORMAL / WITH_HTTP_INFO / ASYNC / CALL).
 *
 * <p><b>Signing:</b> {@link BillingApiClient} only overrides {@code execute(Call, Type)} to add
 * the SaaSus SigV1 {@code Authorization} header; it does <em>not</em> override
 * {@code executeAsync}. Therefore the SDK's native {@code *Async} methods would send unsigned
 * requests. To keep the ASYNC style genuinely asynchronous <em>and</em> signed, this helper
 * builds the unsigned {@code okhttp3.Call}, signs it exactly as {@code execute} does, and then
 * runs it through {@code executeAsync}. The CALL style relies on {@code client.execute(...)},
 * which re-signs the call.
 */
final class BillingInvokers {

    private static final Type STRIPE_INFO_TYPE = new TypeToken<StripeInfo>() {
    }.getType();

    private final StripeApi api;
    private final BillingApiClient client;
    private final String stripeKey;

    BillingInvokers(StripeApi api, BillingApiClient client, String stripeKey) {
        this.api = api;
        this.client = client;
        this.stripeKey = stripeKey;
    }

    /** Builds a registry with all billing methods registered across the four call styles. */
    MethodRegistry buildRegistry() {
        MethodRegistry registry = new MethodRegistry();

        registry.register("getStripeInfo", make(
                vars -> api.getStripeInfo(),
                vars -> httpInfo(api.getStripeInfoWithHttpInfo()),
                vars -> api.getStripeInfoCall(null),
                STRIPE_INFO_TYPE));

        registry.register("updateStripeInfo", make(
                vars -> {
                    api.updateStripeInfo(BillingParams.updateStripeInfoParam(stripeKey));
                    return null;
                },
                vars -> httpInfo(api.updateStripeInfoWithHttpInfo(BillingParams.updateStripeInfoParam(stripeKey))),
                vars -> api.updateStripeInfoCall(BillingParams.updateStripeInfoParam(stripeKey), null),
                null));

        registry.register("deleteStripeInfo", make(
                vars -> {
                    api.deleteStripeInfo();
                    return null;
                },
                vars -> httpInfo(api.deleteStripeInfoWithHttpInfo()),
                vars -> api.deleteStripeInfoCall(null),
                null));

        return registry;
    }

    // ---- style assembly -------------------------------------------------------

    /**
     * Assembles the four call styles for one method. The ASYNC and CALL styles are derived
     * entirely from the {@code *Call} factory plus return type, since both merely need a
     * signed HTTP call.
     */
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

    /**
     * Signs the built call and runs it through {@code executeAsync}, forwarding the module's
     * {@link ApiCallback} events to the module-agnostic {@link AsyncSink}.
     */
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

    /**
     * Executes the {@code *Call} through the configured (signed) client synchronously and
     * forwards the outcome to the sink. {@code client.execute(...)} applies SigV1 signing.
     */
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
