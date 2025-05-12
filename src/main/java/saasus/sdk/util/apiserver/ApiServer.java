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

import saasus.sdk.apigateway.api.SmartApiGatewayApi;
import saasus.sdk.apigateway.models.ApiKey;
import saasus.sdk.modules.ApiGatewayClient;
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
            ApiGatewayClient apiClient = new Configuration().getSmartApiGatewayClient();

            SmartApiGatewayApi smartApiGatewayApi = new SmartApiGatewayApi(apiClient);
            ApiKey response = smartApiGatewayApi.getApiKey(apiKey);

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
            String method = exchange.getRequestMethod();
            String host = exchange.getRequestHeaders().getFirst("Host");
            String path = exchange.getRequestURI().getPath();
            String hostAndPath = host + path;
            String pathAndQuery = exchange.getRequestURI().getRawPath();
            String query = exchange.getRequestURI().getRawQuery();
            if (query != null && !query.isEmpty()) {
                pathAndQuery += "?" + query;
            }
            String hostAndPathAndQuery = host + pathAndQuery;

            String authHeader = exchange.getRequestHeaders().getFirst("Authorization");
            if (authHeader == null || authHeader.isEmpty()) {
                System.err.println("Authorization header is missing or empty");
                return false;
            }

            Pattern pattern = Pattern.compile("^SAASUSSIGV1 Sig=([^,]+),\\s*APIKey=([^,]+)$");
            Matcher matcher = pattern.matcher(authHeader);
            if (!matcher.matches()) {
                System.err.println("Invalid Authorization header format");
                return false;
            }

            String signature = matcher.group(1);
            String headerApiKey = matcher.group(2);

            String apiKey = exchange.getRequestHeaders().getFirst("x-api-key");
            if (!headerApiKey.equals(apiKey)) {
                System.err.println("APIKey mismatch between header and x-api-key");
                return false;
            }

            try {
                clientSecret = fetchClientSecret(apiKey);
                if (clientSecret == null) {
                    System.out.println("No client secret available - skipping signature verification");
                    return true;
                }
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
                    Mac mac = Mac.getInstance("HmacSHA256");
                    SecretKeySpec keySpec = new SecretKeySpec(clientSecret.getBytes(StandardCharsets.UTF_8),
                            "HmacSHA256");
                    mac.init(keySpec);
                    // バイト配列にデータを書き込む
                    mac.update(timestamp.getBytes(StandardCharsets.UTF_8));
                    mac.update(apiKey.getBytes(StandardCharsets.UTF_8));
                    mac.update(method.toUpperCase().getBytes(StandardCharsets.UTF_8));
                    mac.update(hostAndPathAndQuery.getBytes(StandardCharsets.UTF_8));

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
                    }

                    String calculatedSignature = bytesToHex(mac.doFinal());

                    if (calculatedSignature.equals(signature)) {
                        System.out.println("Signature verification successful");
                        return true;
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

            String className = pathParts[1];
            String methodName = pathParts[2];
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
                sendResponse(exchange, 404, "Class not found: " + className);
            } catch (InvocationTargetException | IllegalAccessException e) {
                sendResponse(exchange, 500, "Error invoking method: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                sendResponse(exchange, 400, "Invalid arguments: " + e.getMessage());
            } catch (Exception e) {
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