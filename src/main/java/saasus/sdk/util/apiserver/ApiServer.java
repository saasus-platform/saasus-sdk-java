package saasus.sdk.util.apiserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiServer {

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

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            // ここで、API定義を読んで、リクエストと一致するかどうかを判定する
            // 一致していたら、パラメータを取得し、コール先の型に変換する
            // そして、以下のサンプルのようにリフレクションを使ってコールする
            // 戻り値をAPI定義に従ってJSONに変換して返す
            // エラー処理は、適切なHTTPステータスコードを返す(要検討)

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