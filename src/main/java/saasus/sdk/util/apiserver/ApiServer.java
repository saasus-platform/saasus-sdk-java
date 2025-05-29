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

            // 署名検証候補パスのリスト（スコープを広げるためここで宣言）
            List<String> candidateVerificationPaths = new ArrayList<>();

            System.out.println("\n=== API Gateway設定取得処理 ===");

            System.out.println("1. ApiGatewayApiClient構築");
            Configuration config = new Configuration();
            ApiGatewayApiClient apiClient = config.getApiGatewayApiClient();
            System.out.println("  ベースURL: " + apiClient.getBasePath());
            System.out.println("  タイムアウト設定: " + apiClient.getReadTimeout() + "ms");
            System.out.println("  接続タイムアウト: " + apiClient.getConnectTimeout() + "ms");

            // 認証情報の詳細確認
            try {
                saasus.sdk.apigateway.auth.Authentication auth = apiClient.getAuthentication("Bearer");
                System.out.println("  認証情報: " + auth);
                if (auth instanceof saasus.sdk.apigateway.auth.HttpBearerAuth) {
                    saasus.sdk.apigateway.auth.HttpBearerAuth bearerAuth = (saasus.sdk.apigateway.auth.HttpBearerAuth) auth;
                    String token = bearerAuth.getBearerToken();
                    if (token != null && !token.isEmpty()) {
                        System.out.println("  Bearerトークン: " + token.substring(0, Math.min(token.length(), 20)) + "...");
                    } else {
                        System.out.println("  ⚠️  Bearerトークンが設定されていません");
                    }
                }
            } catch (Exception e) {
                System.out.println("  認証情報の取得に失敗: " + e.getMessage());
                e.printStackTrace();
            }

            // 環境変数の確認
            System.out.println("\n環境変数確認:");
            System.out.println("  SAASUS_API_KEY: " + (System.getenv("SAASUS_API_KEY") != null ? "設定済み" : "未設定"));
            System.out.println("  SAASUS_SECRET_KEY: " + (System.getenv("SAASUS_SECRET_KEY") != null ? "設定済み" : "未設定"));
            System.out.println("  SAASUS_SAAS_ID: " + (System.getenv("SAASUS_SAAS_ID") != null ? "設定済み" : "未設定"));

            System.out.println("\n2. SmartApiGatewayApiインスタンス作成");
            SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(apiClient);

            System.out.println("\n3. getApiGatewaySettings呼び出し開始");
            System.out.println("  呼び出しURL: " + apiClient.getBasePath() + "/api-gateway/settings");
            ApiGatewaySettings settings = null;
            try {
                // API呼び出しの時間計測
                long startTime = System.currentTimeMillis();
                settings = apiInstance.getApiGatewaySettings();
                long endTime = System.currentTimeMillis();
                System.out.println("  API呼び出し完了時間: " + (endTime - startTime) + "ms");

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

                // ここで変換後のpathから変換前のpathを取得する
                String originalPath = null;
                List<saasus.sdk.apigateway.models.EndpointSettings> endpointSettingsList = settings
                        .getEndpointSettingsList();
                System.out.println("endpoint list: " + endpointSettingsList);

                // 現在のrawPathに対応するEndpointSettingsを検索
                System.out.println("🔍 マッピング検索中:");
                System.out.println("  検索対象rawPath: '" + rawPath + "'");
                for (saasus.sdk.apigateway.models.EndpointSettings endpoint : endpointSettingsList) {
                    String mappingId = endpoint.getMappingEndpointId();
                    System.out.println("  比較対象mappingEndpointId: '" + mappingId + "'");

                    // rawPathから先頭の「/」を除去して比較
                    String normalizedRawPath = rawPath.startsWith("/") ? rawPath.substring(1) : rawPath;
                    System.out.println("  正規化されたrawPath: '" + normalizedRawPath + "'");

                    if (mappingId.equals(normalizedRawPath) || normalizedRawPath.startsWith(mappingId)) {
                        originalPath = endpoint.getPath();
                        System.out.println("マッピング発見:");
                        System.out.println("  変換後のpath (mappingEndpointId): " + endpoint.getMappingEndpointId());
                        System.out.println("  変換前のpath (path): " + originalPath);
                        System.out.println("  メソッド: " + endpoint.getMethod().getValue());
                        break;
                    }
                }

                // 元のパスが見つかった場合、検証パスを更新
                if (originalPath != null) {
                    String originalPathWithQuery = query != null && !query.isEmpty() ? originalPath + "?" + query
                            : originalPath;
                    verificationPath = requestHost + originalPathWithQuery;
                    System.out.println("元のパスを使用した検証パス: " + verificationPath);
                } else {
                    System.out.println("警告: 変換前のパスが見つかりませんでした。現在のパスを使用します: " + rawPath);
                }

                Integer healthCheckPort = settings.getInternalEndpointHealthCheckPort();

                // マッピング後のパスを使用してpathWithQueryを再構築
                String finalPathWithQuery;
                if (originalPath != null) {
                    finalPathWithQuery = query != null && !query.isEmpty() ? originalPath + "?" + query : originalPath;
                    System.out.println("🔄 マッピング適用後のpathWithQuery: " + finalPathWithQuery);
                } else {
                    finalPathWithQuery = pathWithQuery;
                    System.out.println("📝 マッピングなし、元のpathWithQueryを使用: " + finalPathWithQuery);
                }

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

                // 全てのホスト候補で署名検証を試行
                candidateVerificationPaths.add(requestHost + finalPathWithQuery); // 元のリクエストホスト

                for (String host : possibleHosts) {
                    String candidatePath;
                    // CloudFrontドメイン、REST API
                    // エンドポイント、カスタムドメイン（getDomainName）の場合はHTTPSとして扱い、ポート番号を付加しない
                    if (host.contains(settings.getCloudFrontDnsRecord().getValue()) ||
                            host.contains(settings.getRestApiEndpoint()) ||
                            host.contains(settings.getDomainName())) {
                        candidatePath = host + finalPathWithQuery;
                        System.out.println("🌐 HTTPS Endpoint（ポート番号なし）: " + candidatePath);
                    } else {
                        candidatePath = host + healthCheckPort + finalPathWithQuery;
                        System.out.println("🔍 内部エンドポイント（ポート番号付き）: " + candidatePath);
                    }
                    candidateVerificationPaths.add(candidatePath);
                }

                System.out.println("📋 署名検証候補パス一覧:");
                for (int i = 0; i < candidateVerificationPaths.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + candidateVerificationPaths.get(i));
                }

            } catch (ApiException e) {
                System.out.println("❌ API呼び出しでエラー発生:");
                System.out.println("  ステータスコード: " + e.getCode());
                System.out.println("  レスポンスボディ: " + e.getResponseBody());
                System.out.println("  エラーメッセージ: " + e.getMessage());

                // レスポンスヘッダーの詳細表示
                System.out.println("  レスポンスヘッダー:");
                if (e.getResponseHeaders() != null) {
                    for (Map.Entry<String, java.util.List<String>> header : e.getResponseHeaders().entrySet()) {
                        System.out.println("    " + header.getKey() + ": " + header.getValue());
                    }
                } else {
                    System.out.println("    ヘッダー情報なし");
                }

                // 詳細なエラー解析
                System.out.println("\n詳細なエラー解析:");
                if (e.getCode() == 401) {
                    System.out.println("  🔐 認証エラー: APIキーまたはトークンが無効です");
                    System.out.println("     - SAASUS_API_KEY環境変数が正しく設定されているか確認してください");
                    System.out.println("     - APIキーの有効期限が切れていないか確認してください");
                    return false;
                } else if (e.getCode() == 403) {
                    System.out.println("  🚫 認可エラー: このリソースへのアクセス権限がありません");
                    System.out.println("     - SaaS IDが正しく設定されているか確認してください");
                    System.out.println("     - APIキーに適切な権限が付与されているか確認してください");
                    return false;
                } else if (e.getCode() == 404) {
                    System.out.println("  🔍 リソースが見つかりません");
                    System.out.println("     - API Gatewayの設定が存在しない可能性があります");
                    System.out.println("  ⚠️  エンドポイントマッピングなしで署名検証を続行します");
                } else if (e.getCode() == 500) {
                    System.out.println("  🔥 サーバー内部エラー: SaaSus側でエラーが発生しています");
                    return false;
                } else if (e.getCode() == 501) {
                    System.out.println("  ⚠️  API Gateway設定が利用できません（501 Not Implemented）");
                    System.out.println("     - この機能がまだ実装されていない可能性があります");
                    System.out.println("  ⚠️  エンドポイントマッピングなしで署名検証を続行します");
                } else if (e.getCode() == 502 || e.getCode() == 503 || e.getCode() == 504) {
                    System.out.println("  🌐 ネットワークエラー: SaaSusサービスへの接続に問題があります");
                    System.out.println("     - インターネット接続を確認してください");
                    System.out.println("     - ファイアウォール設定を確認してください");
                    return false;
                }

                System.out.println("   現在のパスを使用して署名検証を続行: " + rawPath);
                e.printStackTrace();
            }

            // 署名検証のためのホストとパスの組み合わせを確認
            System.out.println("署名検証に使用するホストとパス: " + verificationPath);

            // APIキーを先に取得してclient_secretの有無を確認
            String apiKey = exchange.getRequestHeaders().getFirst("x-api-key");
            System.out.println("\n=== APIキー確認 ===");
            System.out.println("x-api-keyヘッダーの値: " + apiKey);

            try {
                clientSecret = fetchClientSecret(apiKey);
                System.out.println("client secret: " + clientSecret);
                if (clientSecret == null || clientSecret.trim().isEmpty()) {
                    System.out.println("\n⚠️  クライアントシークレットが利用できません");
                    System.out.println("APIキー: " + apiKey);
                    System.out.println("署名検証をスキップして処理を続行します");
                    return true;
                }
                System.out.println("✅ クライアントシークレットの取得に成功しました");
            } catch (Exception e) {
                System.out.println("⚠️  クライアントシークレット取得中にエラーが発生しました: " + e.getMessage());
                System.out.println("署名検証をスキップして処理を続行します");
                return true;
            }

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

            System.out.println("\nAPIキー検証:");
            System.out.println("  Authorization内のAPIキー: " + headerApiKey);
            System.out.println("  x-api-keyヘッダーの値: " + apiKey);

            if (!headerApiKey.equals(apiKey)) {
                System.err.println("❌ APIキーが一致しません");
                return false;
            }
            System.out.println("✅ APIキーの検証成功");

            // 既に上の部分でcandidateVerificationPathsが定義されているので、それを使用
            // フォールバックとして現在のverificationPathが含まれていることを確認
            if (!candidateVerificationPaths.contains(verificationPath)) {
                candidateVerificationPaths.add(verificationPath);
                System.out.println("🔍 フォールバック用に現在の検証パスを追加: " + verificationPath);
            }

            // リクエストボディを事前に読み取り（複数回使用するため）
            byte[] requestBody = new byte[0];
            try {
                InputStream is = exchange.getRequestBody();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = is.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                requestBody = buffer.toByteArray();
            } catch (IOException e) {
                System.out.println("リクエストボディ読み取りエラー: " + e.getMessage());
            }

            Date now = new Date();
            int timeWindow = 1;

            // 全ての候補パスで署名検証を試行
            for (String candidatePath : candidateVerificationPaths) {
                System.out.println("\n🎯 候補パスでの署名検証: " + candidatePath);

                for (int i = -timeWindow; i <= timeWindow; i++) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(now);
                    cal.add(Calendar.MINUTE, i);
                    Date adjustedTime = cal.getTime();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
                    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                    String timestamp = sdf.format(adjustedTime);

                    try {
                        System.out.println(
                                "\n=== 署名計算（パス: " + candidatePath.substring(0, Math.min(50, candidatePath.length()))
                                        + "..., タイムスタンプ: " + timestamp + "）===");

                        Mac mac = Mac.getInstance("HmacSHA256");
                        SecretKeySpec keySpec = new SecretKeySpec(clientSecret.getBytes(StandardCharsets.UTF_8),
                                "HmacSHA256");
                        mac.init(keySpec);

                        // 署名計算
                        mac.update(timestamp.getBytes(StandardCharsets.UTF_8));
                        mac.update(apiKey.getBytes(StandardCharsets.UTF_8));
                        mac.update(method.toUpperCase().getBytes(StandardCharsets.UTF_8));
                        mac.update(candidatePath.getBytes(StandardCharsets.UTF_8));

                        if (requestBody.length > 0) {
                            mac.update(requestBody);
                        }

                        String calculatedSignature = bytesToHex(mac.doFinal());
                        System.out.println("  🔍 署名計算詳細:");
                        System.out.println("    タイムスタンプ: '" + timestamp + "'");
                        System.out.println("    APIキー: '" + apiKey + "'");
                        System.out.println("    メソッド: '" + method.toUpperCase() + "'");
                        System.out.println("    候補パス: '" + candidatePath + "'");
                        System.out.println("    リクエストボディ長: " + requestBody.length);
                        System.out.println("  期待される署名: " + signature);
                        System.out.println("  計算された署名: " + calculatedSignature);

                        // 実際のクライアントリクエストと一致する候補パスの場合、追加情報を表示
                        if (candidatePath.equals(
                                "https://1xp91qxmeh.execute-api.ap-northeast-1.amazonaws.com/prod/inventory-service/get-inventory?xApiKey=d296b330-3cce-40b6-88c3ls")) {
                            System.out.println("  🎯 クライアントリクエストと一致する候補パス！");
                            System.out.println("  💡 クライアント側で使用すべき署名計算パラメータ:");
                            System.out.println("    TIMESTAMP=" + timestamp);
                            System.out.println("    API_KEY=" + apiKey);
                            System.out.println("    METHOD=" + method.toUpperCase());
                            System.out.println("    PATH=" + candidatePath);
                        }

                        if (calculatedSignature.equals(signature)) {
                            System.out.println("\n🎉 署名検証成功!");
                            System.out.println("  ✅ 成功したパス: " + candidatePath);
                            System.out.println("  ✅ タイムスタンプ: " + timestamp);
                            return true;
                        }
                    } catch (Exception e) {
                        System.out.println("署名計算エラー: " + e.getMessage());
                    }
                }
            }

            System.err.println("❌ 全ての候補パスで署名検証に失敗しました");
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
                if (pathParts.length >= 3) {
                    className = pathParts[1];
                    methodName = pathParts[2];
                    System.out.println("class: "
                            + className + ", method: " + methodName);
                } else {
                    sendResponse(exchange, 400, "Invalid path format. Expected /routing/ClassName/methodName");
                    return;
                }
            }

            Map<String, String> queryParams = parseQueryParams(exchange.getRequestURI());

            try {
                System.out.println("\n=== デバッグ: メソッド呼び出し開始 ===");
                System.out.println("クラス名: " + className);
                System.out.println("メソッド名: " + methodName);
                System.out.println("クエリパラメータ: " + queryParams);

                Class<?> clazz = getClass(className);
                System.out.println("✅ クラス解決成功: " + clazz.getName());

                Method method = getMethod(clazz, methodName);
                System.out.println("取得されたメソッド: " + method);

                if (method != null) {
                    System.out.println("✅ メソッド解決成功: " + method.toString());
                    System.out.println("メソッドパラメータ数: " + method.getParameterCount());

                    // パラメータ詳細を表示
                    Parameter[] parameters = method.getParameters();
                    for (int i = 0; i < parameters.length; i++) {
                        System.out.println("  パラメータ" + i + ": " + parameters[i].getName() +
                                " (型: " + parameters[i].getType().getSimpleName() + ")");
                    }

                    System.out.println("\n--- 引数準備開始 ---");
                    Object[] args = prepareMethodArguments(method, queryParams);
                    System.out.println("✅ 引数準備完了");
                    System.out.println("準備された引数数: " + args.length);
                    for (int i = 0; i < args.length; i++) {
                        System.out.println("  引数" + i + ": " + args[i] + " (型: " +
                                (args[i] != null ? args[i].getClass().getSimpleName() : "null") + ")");
                    }

                    System.out.println("\n--- メソッド実行開始 ---");
                    Object response = method.invoke(null, args);
                    System.out.println("✅ メソッド実行完了");
                    System.out.println("レスポンス: " + response + " (型: " +
                            (response != null ? response.getClass().getSimpleName() : "null") + ")");

                    System.out.println("\n--- JSON変換開始 ---");
                    String jsonResponse = objectMapper.writeValueAsString(response);
                    System.out.println("✅ JSON変換完了");
                    System.out.println("JSONレスポンス: " + jsonResponse);

                    sendResponse(exchange, 200, jsonResponse);
                    System.out.println("✅ レスポンス送信完了");
                } else {
                    System.out.println("❌ メソッドが見つかりません: " + methodName);
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
