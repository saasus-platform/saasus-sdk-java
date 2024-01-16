package saasus.sdk.modules;

import saasus.sdk.awsmarketplace.ApiResponse;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.ApiClient;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.lang.reflect.Type;

public class AwsMarketplaceClient extends ApiClient {
    
    private String referer;

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
        Request newRequest = request.newBuilder().header("Authorization", signature).header("Referer", this.getReferer()).build();
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
}
