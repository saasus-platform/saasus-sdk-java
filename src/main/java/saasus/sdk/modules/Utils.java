package saasus.sdk.modules;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import okhttp3.Call;

public class Utils {

    public static String withSaasusSigV1(Call call) throws Exception {

        String secret = System.getenv("SAASUS_SECRET_KEY");
        String apiKey = System.getenv("SAASUS_API_KEY");
        String saasID = System.getenv("SAASUS_SAAS_ID");
        String literal = "SAASUSSIGV1";
    
        if (secret == null || apiKey == null || saasID == null) {
            throw new Exception("Invalid request: SAASUS_SECRET_KEY, SAASUS_API_KEY, SAASUS_SAAS_ID are required");
        }
    
        Mac signatureHmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        signatureHmac.init(secretKey);
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        String now = dateFormat.format(new Date());
        String method = call.request().method().toUpperCase();
        String applyResource = call.request().url().encodedPath();
        String queryString = call.request().url().encodedQuery();
        String host = call.request().url().host();

        String fullResourceUri = (queryString == null)
                                ? host + applyResource
                                : host + applyResource + "?" + queryString;    
        String body = (call.request().body() == null)
                    ? ""
                    : call.request().body().toString();

        String message = now.concat(apiKey).concat(method).concat(fullResourceUri).concat(body);
        byte[] hash = signatureHmac.doFinal(message.getBytes(StandardCharsets.UTF_8));

        StringBuffer hexString = new StringBuffer();
        for (byte bit : hash) {
            String hex = String.format("%02x", bit);
            hexString.append(hex);
        }

        String authorization = literal + " Sig=" + hexString.toString() + ", SaaSID=" + saasID + ", APIKey=" + apiKey;

        return authorization;
    }
}
