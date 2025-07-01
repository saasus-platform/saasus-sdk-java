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
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import saasus.sdk.modules.ApiGatewayApiClient;
import saasus.sdk.modules.Configuration;

public class ApiServer {
    private static final Logger logger = Logger.getLogger(ApiServer.class.getName());
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private static final Configuration configuration = new Configuration();
    private static final boolean DEBUG = Boolean.parseBoolean(System.getenv().getOrDefault("SAASUS_DEBUG", "false"));

    // キャッシュ関連
    private static final long CACHE_DURATION = 300_000; // 5分
    private static final Map<String, CachedApiData> apiDataCache = new ConcurrentHashMap<>();

    private static class CachedApiData {
        final ApiGatewaySettings settings;
        final ApiKey apiKey;
        final ApiGatewayTenant tenant;
        final long timestamp;

        CachedApiData(ApiGatewaySettings settings, ApiKey apiKey, ApiGatewayTenant tenant) {
            this.settings = settings;
            this.apiKey = apiKey;
            this.tenant = tenant;
            this.timestamp = System.currentTimeMillis();
        }

        boolean isExpired() {
            return System.currentTimeMillis() - timestamp > CACHE_DURATION;
        }
    }

    public static void start(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new DynamicHandler());
        server.setExecutor(null);
        server.start();
        logger.info("Server is listening on port " + port);
    }

    static class DynamicHandler implements HttpHandler {
        private final Map<String, Class<?>> classCache = new HashMap<>();
        private final Map<String, Method> methodCache = new HashMap<>();

        private CachedApiData getApiData(String apiKey) throws ApiException {
            // キャッシュから取得
            CachedApiData cached = apiDataCache.get(apiKey);
            if (cached != null && !cached.isExpired()) {
                if (DEBUG)
                    logger.info("Using cached API data for key: " + apiKey);
                return cached;
            }

            // キャッシュが無効または期限切れの場合、新しいデータを取得
            if (DEBUG)
                logger.info("Fetching fresh API data for key: " + apiKey);

            ApiGatewayApiClient apiClient = configuration.getApiGatewayApiClient();
            SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(apiClient);

            try {
                // 一度に必要なデータを全て取得
                ApiGatewaySettings settings = apiInstance.getApiGatewaySettings();
                ApiKey apiKeyObj = apiInstance.getApiKey(apiKey);
                ApiGatewayTenant tenant = apiInstance.getTenant(apiKeyObj.getTenantId());

                if (DEBUG) {
                    logger.info("API Key retrieved, Client Secret available: " +
                               (apiKeyObj.getClientSecret() != null && !apiKeyObj.getClientSecret().isEmpty()));
                }

                CachedApiData newData = new CachedApiData(settings, apiKeyObj, tenant);
                apiDataCache.put(apiKey, newData);

                return newData;
            } catch (ApiException e) {
                if (e.getCode() == 404 || e.getCode() == 501) {
                    logger.warning("API Gateway settings not available: " + e.getMessage());
                    return null;
                }
                throw e;
            }
        }

        private boolean verifySignature(HttpExchange exchange, CachedApiData apiData) {
            if (DEBUG)
                logger.info("Starting signature verification");

            String method = exchange.getRequestMethod();
            String requestHost = exchange.getRequestHeaders().getFirst("Host");
            String rawPath = exchange.getRequestURI().getRawPath();
            String query = exchange.getRequestURI().getRawQuery();
            String apiKey = exchange.getRequestHeaders().getFirst("x-api-key");

            if (apiData == null) {
                if (DEBUG)
                    logger.warning("API data not available, skipping signature verification");
                return true;
            }

            if (apiData.apiKey.getClientSecret() == null || apiData.apiKey.getClientSecret().isEmpty()) {
                if (DEBUG)
                    logger.warning("Client secret not available, signature verification failed");
                return true;
            }

            String adjustedPath = rawPath;
            String pathWithQuery = query != null && !query.isEmpty() ? rawPath + "?" + query : rawPath;

            // テナントルーティングの処理
            if (apiData.settings != null && "path".equals(apiData.settings.getTenantRoutingType().getValue())) {
                if (apiData.tenant != null && apiData.tenant.getRouting() != null) {
                    String routingValue = apiData.tenant.getRouting().getPath();
                    if (routingValue != null && rawPath.contains("/" + routingValue + "/")) {
                        adjustedPath = rawPath.replace("/" + routingValue, "");
                        pathWithQuery = query != null && !query.isEmpty() ? adjustedPath + "?" + query : adjustedPath;
                        if (DEBUG)
                            logger.info("Applied tenant routing: " + routingValue);
                    } else {
                        if (DEBUG)
                            logger.info("Tenant routing path '" + routingValue + "' not found in rawPath '" + rawPath
                                    + "', using original path");
                    }
                }
            }

            // エンドポイントマッピングの確認（プロトコルを含む完全なURL形式）
            String verificationPath = "https://" + requestHost + pathWithQuery;
            if (apiData.settings != null && apiData.settings.getEndpointSettingsList() != null) {
                for (saasus.sdk.apigateway.models.EndpointSettings endpoint : apiData.settings
                        .getEndpointSettingsList()) {
                    String normalizedPath = adjustedPath.startsWith("/") ? adjustedPath.substring(1) : adjustedPath;
                    if (endpoint.getMappingEndpointId().equals(normalizedPath) ||
                            normalizedPath.startsWith(endpoint.getMappingEndpointId())) {
                        String originalPath = endpoint.getPath();
                        String originalPathWithQuery = query != null && !query.isEmpty() ? originalPath + "?" + query
                                : originalPath;
                        verificationPath = "https://" + requestHost + originalPathWithQuery;
                        break;
                    }
                }
            }

            // Authorization ヘッダーの解析
            String authHeader = exchange.getRequestHeaders().getFirst("Authorization");
            if (authHeader == null || authHeader.isEmpty()) {
                if (DEBUG)
                    logger.warning("Authorization header missing");
                return false;
            }

            Pattern pattern = Pattern.compile("^SAASUSSIGV1 Sig=([^,]+),\\s*APIKey=([^,]+)$");
            Matcher matcher = pattern.matcher(authHeader);
            if (!matcher.matches()) {
                if (DEBUG)
                    logger.warning("Invalid Authorization header format");
                return false;
            }

            String signature = matcher.group(1);
            String headerApiKey = matcher.group(2);

            if (!headerApiKey.equals(apiKey)) {
                if (DEBUG)
                    logger.warning("API key mismatch");
                return false;
            }

            // リクエストボディの読み取り
            byte[] requestBody = readRequestBody(exchange);

            // 署名検証
            return verifySignatureWithCandidates(verificationPath, signature, apiKey,
                    apiData.apiKey.getClientSecret(), method, requestBody, apiData.settings);
        }

        private byte[] readRequestBody(HttpExchange exchange) {
            try (InputStream is = exchange.getRequestBody();
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = is.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                return buffer.toByteArray();
            } catch (IOException e) {
                if (DEBUG)
                    logger.warning("Failed to read request body: " + e.getMessage());
                return new byte[0];
            }
        }

        private boolean verifySignatureWithCandidates(String primaryPath, String signature,
                String apiKey, String clientSecret, String method, byte[] requestBody,
                ApiGatewaySettings settings) {

            List<String> candidateUrls = new ArrayList<>();
            candidateUrls.add(primaryPath);

            // 追加の候補URLを生成（プロトコルを含む完全なURL形式）
            if (settings != null) {
                // primaryPathからパス部分のみを抽出（プロトコル+ホスト部分を除去）
                String pathPart = "";
                if (primaryPath.startsWith("https://")) {
                    int pathStartIndex = primaryPath.indexOf("/", 8); // "https://"の後の最初の"/"
                    if (pathStartIndex != -1) {
                        pathPart = primaryPath.substring(pathStartIndex);
                    }
                } else {
                    // プロトコルがない場合は最初の"/"以降をパス部分とする
                    int pathStartIndex = primaryPath.indexOf("/");
                    if (pathStartIndex != -1) {
                        pathPart = primaryPath.substring(pathStartIndex);
                    }
                }
                
                if (settings.getCloudFrontDnsRecord() != null) {
                    String cloudFrontUrl = settings.getCloudFrontDnsRecord().getValue();
                    // 末尾のドットを除去
                    if (cloudFrontUrl.endsWith(".")) {
                        cloudFrontUrl = cloudFrontUrl.substring(0, cloudFrontUrl.length() - 1);
                    }
                    if (!cloudFrontUrl.startsWith("http://") && !cloudFrontUrl.startsWith("https://")) {
                        cloudFrontUrl = "https://" + cloudFrontUrl;
                    }
                    candidateUrls.add(cloudFrontUrl + pathPart);
                }
                if (settings.getRestApiEndpoint() != null) {
                    // rest_api_endpointは既にhttps://を含んでいる
                    candidateUrls.add(settings.getRestApiEndpoint() + pathPart);
                }
                if (settings.getDomainName() != null) {
                    String domainUrl = settings.getDomainName();
                    // 末尾のドットを除去
                    if (domainUrl.endsWith(".")) {
                        domainUrl = domainUrl.substring(0, domainUrl.length() - 1);
                    }
                    if (!domainUrl.startsWith("http://") && !domainUrl.startsWith("https://")) {
                        domainUrl = "https://" + domainUrl;
                    }
                    candidateUrls.add(domainUrl + pathPart);
                    
                    // カスタムドメインの場合、"api."プレフィックス付きの候補も追加
                    if (!domainUrl.startsWith("https://api.") && !domainUrl.startsWith("http://api.")) {
                        String apiDomainUrl = domainUrl.replace("https://", "https://api.");
                        candidateUrls.add(apiDomainUrl + pathPart);
                    }
                }
            }

            Date now = new Date();
            int timeWindow = 1;

            for (String candidateUrl : candidateUrls) {
                for (int i = -timeWindow; i <= timeWindow; i++) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(now);
                    cal.add(Calendar.MINUTE, i);
                    Date adjustedTime = cal.getTime();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
                    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                    String timestamp = sdf.format(adjustedTime);

                    try {
                        Mac mac = Mac.getInstance("HmacSHA256");
                        SecretKeySpec keySpec = new SecretKeySpec(clientSecret.getBytes(StandardCharsets.UTF_8),
                                "HmacSHA256");
                        mac.init(keySpec);

                        // 署名=日時情報+API Key+HTTPメソッド+URL(Host:Port/URI)+Request Body
                        mac.update(timestamp.getBytes(StandardCharsets.UTF_8));
                        mac.update(apiKey.getBytes(StandardCharsets.UTF_8));
                        mac.update(method.toUpperCase().getBytes(StandardCharsets.UTF_8));
                        mac.update(candidateUrl.getBytes(StandardCharsets.UTF_8));

                        if (requestBody.length > 0) {
                            mac.update(requestBody);
                        }

                        String calculatedSignature = bytesToHex(mac.doFinal());

                        if (DEBUG) {
                            logger.info("Signature check - URL: " + candidateUrl +
                                    ", Timestamp: " + timestamp +
                                    ", Expected: " + signature +
                                    ", Calculated: " + calculatedSignature);
                        }

                        if (calculatedSignature.equals(signature)) {
                            if (DEBUG)
                                logger.info("Signature verification successful");
                            return true;
                        }
                    } catch (Exception e) {
                        if (DEBUG)
                            logger.warning("Signature calculation error: " + e.getMessage());
                    }
                }
            }

            if (DEBUG)
                logger.warning("Signature verification failed for all candidates");
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

            CachedApiData apiData = null;
            try {
                apiData = getApiData(apiKey);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Failed to get API data", e);
            }

            if (!verifySignature(exchange, apiData)) {
                sendResponse(exchange, 401, "{\"message\": \"Invalid signature\"}");
                return;
            }

            String path = exchange.getRequestURI().getPath();
            String[] pathParts = path.split("/");

            if (pathParts.length < 3) {
                sendResponse(exchange, 400, "Invalid path. Use format: /ClassName/methodName");
                return;
            }

            String className = pathParts[1];
            String methodName = pathParts[2];

            // ルーティング処理の統合
            if (apiData != null && apiData.tenant != null && apiData.tenant.getRouting() != null) {
                String routingValue = apiData.tenant.getRouting().getPath();
                if (routingValue != null && !routingValue.isEmpty()) {
                    // パスにルーティング値が含まれている場合のみルーティング処理を適用
                    if (path.contains("/" + routingValue + "/")) {
                        String newPath = path.replace("/" + routingValue, "");
                        String[] newPathParts = newPath.split("/");
                        if (newPathParts.length >= 3) {
                            className = newPathParts[1];
                            methodName = newPathParts[2];
                        } else {
                            sendResponse(exchange, 400, "Invalid path after routing: " + newPath);
                            return;
                        }
                    } else {
                        // API Gatewayやプロキシ経由のリクエストの場合、
                        // テナントルーティングを適用せずに直接処理
                        if (DEBUG) {
                            logger.info("Routing path '" + routingValue + "' not found in URL '" + path
                                    + "', proceeding without tenant routing");
                        }
                        // 現在のpathPartsをそのまま使用（className, methodNameは既に設定済み）
                    }
                }
            }

            Map<String, String> queryParams = parseQueryParams(exchange.getRequestURI());

            try {
                if (DEBUG) {
                    logger.info("Invoking method - Class: " + className + ", Method: " + methodName);
                }

                Class<?> clazz = getClass(className);
                Method method = getMethod(clazz, methodName);

                if (method != null) {
                    boolean needsIdentity = requiresSaaSusIdentity(method);
                    SaaSusIdentity identity = null;
                    
                    if (needsIdentity) {
                        identity = createSaaSusIdentity(apiData);
                    }
                    
                    Object[] args = prepareMethodArguments(method, queryParams, identity);
                    Object response = method.invoke(null, args);
                    String jsonResponse = objectMapper.writeValueAsString(response);
                    sendResponse(exchange, 200, jsonResponse);
                } else {
                    sendResponse(exchange, 404, "Method not found: " + methodName);
                }
            } catch (ClassNotFoundException e) {
                sendResponse(exchange, 404, "Class not found: " + className);
            } catch (InvocationTargetException | IllegalAccessException e) {
                logger.log(Level.SEVERE, "Error invoking method", e);
                sendResponse(exchange, 500, "Error invoking method: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                sendResponse(exchange, 400, "Invalid arguments: " + e.getMessage());
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Internal server error", e);
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
                    if (idx > 0) {
                        queryParams.put(pair.substring(0, idx), pair.substring(idx + 1));
                    }
                }
            }
            return queryParams;
        }

        private Object[] prepareMethodArguments(Method method, Map<String, String> queryParams, SaaSusIdentity identity) {
            Parameter[] parameters = method.getParameters();
            List<Object> args = new ArrayList<>();

            for (Parameter parameter : parameters) {
                Class<?> paramType = parameter.getType();
                
                // SaaSusIdentityパラメータの検出と自動注入
                if (paramType == SaaSusIdentity.class) {
                    if (identity == null) {
                        throw new IllegalStateException("SaaSusIdentity is required but not available");
                    }
                    if (DEBUG) {
                        logger.info("Auto-injecting SaaSusIdentity for parameter: " + parameter.getName());
                    }
                    args.add(identity);
                    continue;
                }
                
                String paramName = parameter.getName();
                String paramValue = queryParams.get(paramName);

                if (paramValue == null) {
                    throw new IllegalArgumentException("Missing parameter: " + paramName);
                }

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

        /**
         * メソッドがSaaSusIdentityパラメータを必要とするかチェック
         * @param method チェック対象のメソッド
         * @return SaaSusIdentityパラメータが必要な場合true
         */
        private boolean requiresSaaSusIdentity(Method method) {
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                if (parameter.getType() == SaaSusIdentity.class) {
                    return true;
                }
            }
            return false;
        }

        private SaaSusIdentity createSaaSusIdentity(CachedApiData apiData) {
            try {
                if (apiData == null || apiData.apiKey == null) {
                    throw new IllegalStateException("API data not available for identity creation");
                }
                
                String userId = apiData.apiKey.getUserId();
                String tenantId = apiData.apiKey.getTenantId();
                Integer envIdInt = apiData.apiKey.getEnvId();
                
                if (tenantId == null || envIdInt == null) {
                    throw new IllegalStateException("Required identity fields are missing");
                }
                
                String envId = envIdInt.toString();
                
                if (DEBUG) {
                    logger.info("Creating SaaSusIdentity - userId: " + userId +
                               ", tenantId: " + tenantId + ", envId: " + envId);
                }
                
                return new SaaSusIdentity(userId, tenantId, envId);
                
            } catch (Exception e) {
                logger.warning("Failed to create SaaSusIdentity: " + e.getMessage());
                throw new IllegalStateException("Identity creation failed", e);
            }
        }

        private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] responseBytes = response.getBytes("UTF-8");
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBytes);
            }
        }
    }

    public static class UserApi {
        public static String getUser(String id) {
            return "User " + id;
        }
    }

    public static class MathApi {
        public static int add(int a, int b) {
            return a + b;
        }
    }
}
