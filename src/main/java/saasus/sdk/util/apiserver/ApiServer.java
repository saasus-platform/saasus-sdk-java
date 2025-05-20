package saasus.sdk.util.apiserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;
import saasus.sdk.apigateway.models.ApiGatewaySettings;
import saasus.sdk.apigateway.models.ApiGatewayTenant;
import saasus.sdk.apigateway.models.ApiKey;
import saasus.sdk.apigateway.models.TenantRouting;
import saasus.sdk.modules.ApiGatewayApiClient;
import saasus.sdk.modules.Configuration;

public class ApiServer {
    private static String clientSecret;

    private static String fetchClientSecret(String apiKey) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            return null;
        }

        if (clientSecret != null) {
            return clientSecret;
        }

        try {
            ApiGatewayApiClient apiClient = new Configuration().getApiGatewayApiClient();
            SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(apiClient);

            ApiKey response = apiInstance.getApiKey(apiKey);

            clientSecret = response.getClientSecret();
            return clientSecret;

        } catch (Exception e) {
            System.out.println("クライアントシークレットの取得に失敗しました:");
            System.out.println("  エラータイプ: " + e.getClass().getName());
            System.out.println("  メッセージ: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static void start(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new DynamicHandler());
        server.setExecutor(null); // デフォルトのエグゼキューターを使用
        server.start();

        System.out.println("#################### Server is listening on port " + port);
    }

    static class DynamicHandler implements HttpHandler {
        private final Map<String, Class<?>> classCache = new HashMap<>();
        private final Map<String, Method> methodCache = new HashMap<>();

        private boolean verifySignature(HttpExchange exchange) {
            System.out.println("\n=== 署名検証開始 ===");
            String method = exchange.getRequestMethod();
            String requestHost = exchange.getRequestHeaders().getFirst("Host");
            String rawPath = exchange.getRequestURI().getRawPath();
            String query = exchange.getRequestURI().getRawQuery();

            System.out.println("検証情報:");
            System.out.println("  Method: " + method);
            System.out.println("  Host: " + requestHost);
            System.out.println("  Path: " + rawPath);
            System.out.println("  Query: " + query);
            String pathWithQuery = query != null && !query.isEmpty() ? rawPath + "?" + query : rawPath;

            // 初期値として現在のホストとパスを使用
            String verificationPath = requestHost + pathWithQuery;
            System.out.println("verificationPath: " + verificationPath);

            System.out.println("\n=== API Gateway設定取得処理 ===");

            System.out.println("1. ApiGatewayApiClient構築");
            Configuration config = new Configuration();
            ApiGatewayApiClient apiClient = config.getApiGatewayApiClient();
            System.out.println("  ベースURL: " + apiClient.getBasePath());
            System.out.println("  タイムアウト設定: " + apiClient.getReadTimeout() + "ms");
            try {
                System.out.println("  認証情報: " + apiClient.getAuthentication("Bearer"));
            } catch (Exception e) {
                System.out.println("  認証情報の取得に失敗: " + e.getMessage());
            }

            System.out.println("\n2. SmartApiGatewayApiインスタンス作成");
            SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(apiClient);

            System.out.println("\n3. getApiGatewaySettings呼び出し");
            ApiGatewaySettings settings = null;
            try {
                settings = apiInstance.getApiGatewaySettings();

                if (settings == null) {
                    System.out.println("❌ API Gateway設定が見つかりません（レスポンスがnull）");
                    return false;
                }

                System.out.println("✅ API Gateway設定の取得に成功");
                System.out.println("設定内容:");
                System.out.println("  テナントルーティングタイプ: " +
                        (settings.getTenantRoutingType() != null ? settings.getTenantRoutingType().getValue()
                                : "null"));
                System.out.println("  RestApiEndpoint: " + settings.getRestApiEndpoint());
                System.out.println("  DomainName: " + settings.getDomainName());
                System.out.println("  CloudFrontDnsRecord: " +
                        (settings.getCloudFrontDnsRecord() != null ? settings.getCloudFrontDnsRecord().getValue()
                                : "null"));
                System.out
                        .println("  InternalEndpointHealthCheckPort: " + settings.getInternalEndpointHealthCheckPort());

                // ここで変換後のpathから変換前のpathを取得する必要がある
                System.out.println("endpoint list: " + settings.getEndpointSettingsList());

                Integer healthCheckPort = settings.getInternalEndpointHealthCheckPort();

                // 候補となるホストを取得
                List<String> possibleHosts = new ArrayList<>();
                if (settings.getCloudFrontDnsRecord() != null && settings.getCloudFrontDnsRecord().getValue() != null) {
                    possibleHosts.add(settings.getCloudFrontDnsRecord().getValue());
                }
                if (settings.getRestApiEndpoint() != null) {
                    possibleHosts.add(settings.getRestApiEndpoint());
                }
                if (settings.getDomainName() != null) {
                    possibleHosts.add(settings.getDomainName());
                }
                System.out.println("possibleHosts: " + possibleHosts);

                // 要求されたホストが候補のいずれかにマッチするか確認
                for (String host : possibleHosts) {
                    System.out.println("path" + host + healthCheckPort + pathWithQuery);
                    if (requestHost != null && requestHost.equals(host)) {
                        verificationPath = host + healthCheckPort + pathWithQuery;
                        System.out.println("マッチしたホスト " + host + " で署名を検証します");
                        break;
                    }
                }

            } catch (ApiException e) {
                System.out.println("❌ API呼び出しでエラー発生:");
                System.out.println("  ステータスコード: " + e.getCode());
                System.out.println("  レスポンスボディ: " + e.getResponseBody());
                System.out.println("  エラーメッセージ: " + e.getMessage());
                e.printStackTrace();
                return false;
            }

            // 署名検証のためのホストとパスの組み合わせを確認
            System.out.println("署名検証に使用するホストとパス: " + verificationPath);

            System.out.println("\n=== Authorization ヘッダー解析 ===");
            String authHeader = exchange.getRequestHeaders().getFirst("Authorization");
            System.out.println("Authorization ヘッダー: " + authHeader);

            if (authHeader == null || authHeader.isEmpty()) {
                System.err.println("❌ Authorization ヘッダーが存在しないか空です");
                return false;
            }

            Pattern pattern = Pattern.compile("^SAASUSSIGV1 Sig=([^,]+),\\s*APIKey=([^,]+)$");
            Matcher matcher = pattern.matcher(authHeader);
            if (!matcher.matches()) {
                System.err.println("❌ Authorization ヘッダーのフォーマットが不正です");
                System.err.println("期待されるフォーマット: SAASUSSIGV1 Sig=<signature>,APIKey=<apikey>");
                return false;
            }

            String signature = matcher.group(1);
            String headerApiKey = matcher.group(2);

            System.out.println("ヘッダー解析結果:");
            System.out.println("  署名: " + signature);
            System.out.println("  APIキー: " + headerApiKey);

            String apiKey = exchange.getRequestHeaders().getFirst("x-api-key");
            System.out.println("\nAPIキー検証:");
            System.out.println("  Authorization内のAPIキー: " + headerApiKey);
            System.out.println("  x-api-keyヘッダーの値: " + apiKey);

            if (!headerApiKey.equals(apiKey)) {
                System.err.println("❌ APIキーが一致しません");
                return false;
            }
            System.out.println("✅ APIキーの検証成功");

            try {
                clientSecret = fetchClientSecret(apiKey);
                if (clientSecret == null) {
                    System.out.println("\n警告: クライアントシークレットが利用できません");
                    System.out.println("APIキー: " + apiKey);
                    System.out.println("署名検証をスキップします");
                    return true;
                }
                System.out.println("クライアントシークレットの取得に成功しました");
            } catch (Exception e) {
                System.out.println("Error fetching client secret: " + e.getMessage());
                return true;
            }

            if (clientSecret == null) {
                System.out.println("No client secret available");
                return true;
            }

            Date now = new Date();
            int timeWindow = 1;

            for (int i = -timeWindow; i <= timeWindow; i++) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(now);
                cal.add(Calendar.MINUTE, i);
                Date adjustedTime = cal.getTime();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                String timestamp = sdf.format(adjustedTime);

                try {
                    System.out.println("\n=== 署名計算（タイムスタンプ: " + timestamp + "）===");
                    System.out.println("署名計算に使用する値:");
                    System.out.println("  タイムスタンプ: " + timestamp);
                    System.out.println("  APIキー: " + apiKey);
                    System.out.println("  メソッド: " + method.toUpperCase());
                    System.out.println("  検証パス: " + verificationPath);

                    Mac mac = Mac.getInstance("HmacSHA256");
                    SecretKeySpec keySpec = new SecretKeySpec(clientSecret.getBytes(StandardCharsets.UTF_8),
                            "HmacSHA256");
                    mac.init(keySpec);

                    System.out.println("\n署名計算の順序:");
                    // バイト配列にデータを書き込む
                    mac.update(timestamp.getBytes(StandardCharsets.UTF_8));
                    System.out.println("1. タイムスタンプ更新");
                    mac.update(apiKey.getBytes(StandardCharsets.UTF_8));
                    System.out.println("2. APIキー更新");
                    mac.update(method.toUpperCase().getBytes(StandardCharsets.UTF_8));
                    System.out.println("3. メソッド更新");
                    mac.update(verificationPath.getBytes(StandardCharsets.UTF_8));
                    System.out.println("4. 検証パス更新");

                    // リクエストボディが存在する場合は追加
                    InputStream is = exchange.getRequestBody();
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    int nRead;
                    byte[] data = new byte[16384];
                    while ((nRead = is.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, nRead);
                    }
                    buffer.flush();
                    byte[] requestBody = buffer.toByteArray();
                    if (requestBody.length > 0) {
                        mac.update(requestBody);
                        System.out.println("5. リクエストボディ更新 (長さ: " + requestBody.length + " bytes)");
                        System.out.println("  ボディ内容: " + new String(requestBody, StandardCharsets.UTF_8));
                    }

                    String calculatedSignature = bytesToHex(mac.doFinal());
                    System.out.println("\n署名比較:");
                    System.out.println("  期待される署名: " + signature);
                    System.out.println("  計算された署名: " + calculatedSignature);
                    System.out.println("  一致: " + calculatedSignature.equals(signature));

                    if (calculatedSignature.equals(signature)) {
                        System.out.println("\n✅ 署名検証成功");
                        return true;
                    } else {
                        System.out.println("\n❌ 署名検証失敗");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.err.println("Signature verification failed for all time windows");
            return false;
        }

        private String bytesToHex(byte[] bytes) {
            StringBuilder hexString = new StringBuilder();
            for (byte aByte : bytes) {
                hexString.append(String.format("%02x", aByte));
            }
            return hexString.toString();
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String apiKey = exchange.getRequestHeaders().getFirst("x-api-key");
            if (apiKey == null || apiKey.isEmpty()) {
                sendResponse(exchange, 401, "{\"message\": \"x-api-key header is required\"}");
                return;
            }

            if (!verifySignature(exchange)) {
                sendResponse(exchange, 401, "{\"message\": \"Invalid signature\"}");
                return;
            }
            String path = exchange.getRequestURI().getPath();
            String[] pathParts = path.split("/");

            if (pathParts.length < 3) {
                sendResponse(exchange, 400, "Invalid path. Use format: /ClassName/methodName");
                return;
            }

            System.out.println("Path parts: " + String.join(", ", pathParts));
            // set default value
            String className = pathParts[1];
            String methodName = pathParts[2];

            // custom routing
            String routingValue = null;
            try {
                routingValue = getRoutingValue(apiKey);
                System.out.println("Routing value: " + routingValue);
            } catch (ApiException e) {
                System.out.println("API Error: " + e.getMessage());
                e.printStackTrace();
                sendResponse(exchange, 500, "API Error: " + e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println("Error getting routing value: " + e.getMessage());
                e.printStackTrace();
                sendResponse(exchange, 500, "Error getting routing value: " + e.getMessage());
                return;
            }

            // routing is required
            if (routingValue != null && !routingValue.isEmpty()) {
                System.out.println("Routing value found: " + routingValue);

                if (path.contains("/" + routingValue + "/")) {
                    // パスからルーティング値を削除して再分割
                    String newPath = path.replace("/" + routingValue, "");
                    String[] newPathParts = newPath.split("/");

                    if (newPathParts.length >= 3) {
                        className = newPathParts[1];
                        methodName = newPathParts[2];
                        System.out.println("Updated class name: " + className + ", method name: " + methodName);
                    } else {
                        sendResponse(exchange, 400, "Invalid path after routing: " + newPath);
                        return;
                    }
                } else {
                    // routing value not found in URL
                    sendResponse(exchange, 403,
                            "Access denied: Required routing path '" + routingValue + "' not found in URL");
                    return;
                }
            } else {
                if (pathParts.length >= 4) {
                    className = pathParts[2];
                    methodName = pathParts[3];
                    System.out.println("No explicit routing found, assuming " + pathParts[1] + " is routing, class: "
                            + className + ", method: " + methodName);
                } else {
                    sendResponse(exchange, 400, "Invalid path format. Expected /routing/ClassName/methodName");
                    return;
                }
            }

            Map<String, String> queryParams = parseQueryParams(exchange.getRequestURI());

            try {
                Class<?> clazz = getClass(className);
                Method method = getMethod(clazz, methodName);

                if (method != null) {
                    Object[] args = prepareMethodArguments(method, queryParams);
                    Object response = method.invoke(null, args);
                    String jsonResponse = objectMapper.writeValueAsString(response);
                    sendResponse(exchange, 200, jsonResponse);
                } else {
                    sendResponse(exchange, 404, "Method not found: " + methodName);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                sendResponse(exchange, 404, "Class not found: " + className);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
                sendResponse(exchange, 500, "Error invoking method: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                sendResponse(exchange, 400, "Invalid arguments: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                sendResponse(exchange, 500, "Internal server error: " + e.getMessage());
            }
        }

        private Class<?> getClass(String className) throws ClassNotFoundException {
            return classCache.computeIfAbsent(className, name -> {
                try {
                    return Class.forName(name);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        private Method getMethod(Class<?> clazz, String methodName) {
            String key = clazz.getName() + "#" + methodName;
            return methodCache.computeIfAbsent(key, k -> {
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        return method;
                    }
                }
                return null;
            });
        }

        private Map<String, String> parseQueryParams(URI uri) {
            Map<String, String> queryParams = new HashMap<>();
            String query = uri.getQuery();
            if (query != null) {
                String[] pairs = query.split("&");
                for (String pair : pairs) {
                    int idx = pair.indexOf("=");
                    queryParams.put(pair.substring(0, idx), pair.substring(idx + 1));
                }
            }
            return queryParams;
        }

        private Object[] prepareMethodArguments(Method method, Map<String, String> queryParams) {
            Parameter[] parameters = method.getParameters();
            List<Object> args = new ArrayList<>();

            for (Parameter parameter : parameters) {
                String paramName = parameter.getName();
                String paramValue = queryParams.get(paramName);

                if (paramValue == null) {
                    throw new IllegalArgumentException("Missing parameter: " + paramName);
                }

                Class<?> paramType = parameter.getType();
                args.add(convertParamValue(paramValue, paramType));
            }

            return args.toArray();
        }

        private Object convertParamValue(String value, Class<?> type) {
            if (type == String.class) {
                return value;
            } else if (type == int.class || type == Integer.class) {
                return Integer.parseInt(value);
            } else if (type == long.class || type == Long.class) {
                return Long.parseLong(value);
            } else if (type == double.class || type == Double.class) {
                return Double.parseDouble(value);
            } else if (type == boolean.class || type == Boolean.class) {
                return Boolean.parseBoolean(value);
            }
            throw new IllegalArgumentException("Unsupported parameter type: " + type.getName());
        }

        private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] responseBytes = response.getBytes("UTF-8");
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        }

        private String getRoutingValue(String apiKey) throws ApiException {
            ApiGatewayApiClient apiClient = new Configuration().getApiGatewayApiClient();
            SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(apiClient);

            ApiGatewaySettings settings = apiInstance.getApiGatewaySettings();
            if (settings == null) {
                System.out.println("API Gateway Settings not found");
                throw new ApiException("API Gateway Settings not found");
            }

            String tenantRoutingType = settings.getTenantRoutingType().getValue();
            if (tenantRoutingType == null || tenantRoutingType.isEmpty()) {
                System.out.println("Tenant Routing Type not found");
                throw new ApiException("Tenant Routing Type not found");
            }

            // APIキーからテナント情報を取得（全ルーティングタイプで必要）
            ApiKey apiKeyObj = apiInstance.getApiKey(apiKey);
            if (apiKeyObj == null) {
                System.out.println("API Key not found: " + apiKey);
                throw new ApiException("API Key not found: " + apiKey);
            }

            // テナント設定情報を取得
            ApiGatewayTenant tenant = apiInstance.getTenant(apiKeyObj.getTenantId());
            if (tenant == null) {
                System.out.println("Tenant not found for ID: " + apiKeyObj.getTenantId());
                throw new ApiException("Tenant not found for ID: " + apiKeyObj.getTenantId());
            }

            TenantRouting routing = tenant.getRouting();
            if (routing == null) {
                System.out.println("Routing not found for tenant: " + apiKeyObj.getTenantId());
                throw new ApiException("Routing not found for tenant: " + apiKeyObj.getTenantId());
            }
            switch (tenantRoutingType.toLowerCase()) {
                case "none":
                    System.out.println("Tenant Routing Type is none");
                    return null;
                case "path":
                    System.out.println("Tenant Routing Type is path");
                    return routing.getPath();
                case "hostname":
                    System.out.println("Tenant Routing Type is hostname");
                    // not implemented
                    return null;
                case "headervalue":
                    System.out.println("Tenant Routing Type is headervalue");
                    // not implemented
                    return null;
                default:
                    throw new ApiException("Invalid tenantRoutingType: " + tenantRoutingType);
            }
        }
    }

    // サンプルAPIクラス
    public static class UserApi {
        public static String getUser(int userId) {
            return "User info for ID: " + userId;
        }

        public static String createUser(String name, int age) {
            return "Created user: " + name + " (Age: " + age + ")";
        }
    }

    public static class MathApi {
        public static String add(int a, int b) {
            return "Result: " + (a + b);
        }

        public static String multiply(double x, double y) {
            return "Result: " + (x * y);
        }
    }
}