package saasus.sdk.modules;

import saasus.sdk.apilog.ApiException;
import saasus.sdk.apilog.ApiResponse;
import saasus.sdk.apilog.ApiClient;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.lang.reflect.Type;

public class ApiLogApiClient extends ApiClient {
    
    private String referer;
    private String xSaasusReferer;
    private String xSaaSusTraceId;

    @Override
    public <T> ApiResponse<T> execute(Call call, Type returnType) throws ApiException {        

        String signature = "";
        try {
            signature = Utils.withSaasusSigV1(call);
        } catch (Exception e) {
            throw new ApiException(e);
        }

        OkHttpClient httpClient = getHttpClient();
        Request request = call.request();
        Request.Builder requestBuilder = request.newBuilder()
                .header("Authorization", signature);

        if (this.referer != null) {
            requestBuilder.header("Referer", this.referer);
        }

        if (this.xSaasusReferer != null) {
            requestBuilder.header("X-SaaSus-Referer", this.xSaasusReferer);
        }

        if (this.xSaaSusTraceId != null) {
            requestBuilder.header("X-SaaSus-Trace-Id", this.xSaaSusTraceId);
        }

        Request newRequest = requestBuilder.build();
        Call newCall = httpClient.newCall(newRequest);
        return super.execute(newCall, returnType);
    }

    private String getReferer() {
        if (referer == null) {
            return "";
        }
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    private String getXSaasusReferer() {
        if (xSaasusReferer == null) {
            return "";
        }
        return xSaasusReferer;
    }

    public void setXSaasusReferer(String xSaasusReferer) {
        this.xSaasusReferer = xSaasusReferer;
    }

    private String getXSaaSusTraceId() {
        if (xSaaSusTraceId == null) {
            return "";
        }
        return xSaaSusTraceId;
    }

    public void setXSaaSusTraceId(String xSaaSusTraceId) {
        this.xSaaSusTraceId = xSaaSusTraceId;
    }
}
