package saasus.sdk.contract;

import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.opentest4j.TestAbortedException;

/**
 * Reflective contract engine behind the JUnit suite ({@link ContractTest}).
 *
 * <p>Responsibilities:
 * <ul>
 *   <li><b>Automatic operation enumeration</b> — operations are discovered at
 *       runtime by scanning the generated {@code saasus.sdk.<module>.api.*Api}
 *       classes. Nothing is hardcoded, so an SDK that lacks an API simply has
 *       nothing enumerated for it (natural exclusion).</li>
 *   <li><b>Four call forms</b> — every operation is exercised through all four
 *       generated forms: synchronous, {@code WithHttpInfo}, {@code Call} and
 *       {@code Async}.</li>
 *   <li><b>Spec-driven inputs</b> — path/query/header values and request bodies
 *       come from {@link SpecInputs}.</li>
 * </ul>
 *
 * <p>Everything is done via reflection so the engine compiles and runs no
 * matter which modules happen to be generated, and so it can be overlaid on any
 * SDK generation.
 */
public final class ContractEngine {

    /** All SDK modules. A module is tested only if it is generated AND has a Prism endpoint. */
    public static final List<String> MODULES = Arrays.asList(
            "auth", "pricing", "billing", "awsmarketplace", "integration", "apilog", "communication");

    private static final String BEARER = "synthetic-bearer-token";
    private static final long ASYNC_TIMEOUT_SECONDS = 30;

    /** One {@code ApiClient} per module and base URL, reused across cases. */
    private static final Map<String, Object> CLIENTS = new ConcurrentHashMap<String, Object>();

    /** The four generated call forms per operation. */
    public enum Form {
        SYNC, WITH_HTTP_INFO, CALL, ASYNC
    }

    private ContractEngine() {
    }

    // --- discovery ----------------------------------------------------------

    /** Discovers every enumerable operation for a module, or an empty list. */
    public static List<OperationCase> discover(String module) {
        List<OperationCase> cases = new ArrayList<OperationCase>();
        SpecInputs spec = SpecInputs.forModule(module);
        if (spec == null) {
            return cases;
        }
        for (SpecInputs.Operation op : spec.allOperations()) {
            Method sync = resolveSyncMethod(module, op);
            if (sync == null) {
                continue;
            }
            // A oneOf/anyOf request body yields one case per variant, so every
            // variant is actually sent; other operations yield a single case.
            List<String> variants = spec.bodyVariantLabels(op);
            if (variants.isEmpty()) {
                cases.add(new OperationCase(module, sync, spec, op, 0, null));
            } else {
                for (int i = 0; i < variants.size(); i++) {
                    cases.add(new OperationCase(module, sync, spec, op, i, variants.get(i)));
                }
            }
        }
        return cases;
    }

    /**
     * Spec operations that could not be mapped to a generated SDK method
     * (missing tag, API class, or sync method). Used to assert that the latest
     * SDK covers every operation the spec declares; an older SDK legitimately
     * lacks newer operations, so this check is only enforced for the latest SDK.
     */
    public static List<String> unmappedOperations(String module) {
        List<String> missing = new ArrayList<String>();
        SpecInputs spec = SpecInputs.forModule(module);
        if (spec == null) {
            return missing;
        }
        for (SpecInputs.Operation op : spec.allOperations()) {
            if (resolveSyncMethod(module, op) == null) {
                missing.add(op.tag == null ? op.operationId + " (no tag)" : op.operationId);
            }
        }
        return missing;
    }

    /**
     * The generated synchronous method for a spec operation, or {@code null}
     * when this SDK does not have it (natural exclusion of APIs an older SDK
     * does not contain). Single source of the operationId -> SDK method
     * mapping, so enumeration and the completeness check cannot drift apart.
     */
    private static Method resolveSyncMethod(String module, SpecInputs.Operation op) {
        if (op.tag == null) {
            return null;
        }
        // operationId -> generated API class (<Tag>Api) and sync method name.
        Class<?> api = tryClass("saasus.sdk." + module + ".api." + apiClassName(op.tag));
        if (api == null) {
            return null;
        }
        Method sync = findDeclaredMethod(api, SpecInputs.methodName(op.operationId));
        // A real operation also has a matching <name>Call form generated.
        return sync != null && hasMethodNamed(api, sync.getName() + "Call") ? sync : null;
    }

    /** Generated API class name for a tag, e.g. {@code saasUser -> SaasUserApi}. */
    private static String apiClassName(String tag) {
        return Character.toUpperCase(tag.charAt(0)) + tag.substring(1) + "Api";
    }

    private static Class<?> tryClass(String name) {
        try {
            return Class.forName(name);
        } catch (Throwable t) {
            return null;
        }
    }

    /**
     * Finds the public, non-form-suffixed declared method with the given name
     * (the synchronous operation), or {@code null}.
     */
    private static Method findDeclaredMethod(Class<?> api, String name) {
        for (Method m : api.getDeclaredMethods()) {
            int mod = m.getModifiers();
            if (!Modifier.isPublic(mod) || Modifier.isStatic(mod) || m.isSynthetic() || m.isBridge()) {
                continue;
            }
            String n = m.getName();
            if (!n.equals(name)) {
                continue;
            }
            if (n.endsWith("Call") || n.endsWith("Async") || n.endsWith("WithHttpInfo")) {
                continue;
            }
            return m;
        }
        return null;
    }

    private static boolean hasMethodNamed(Class<?> api, String name) {
        for (Method m : api.getDeclaredMethods()) {
            if (m.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // --- a single discovered operation --------------------------------------

    public static final class OperationCase {
        public final String module;
        public final Class<?> apiClass;
        public final Method syncMethod;
        /** Index of the request-body oneOf/anyOf variant to send (0 when single). */
        public final int variantIndex;
        /** Variant label for reporting, or {@code null} when the body is not a composite. */
        public final String variantLabel;

        private final SpecInputs spec;
        private final SpecInputs.Operation op;

        OperationCase(String module, Method syncMethod, SpecInputs spec, SpecInputs.Operation op,
                int variantIndex, String variantLabel) {
            this.module = module;
            this.apiClass = syncMethod.getDeclaringClass();
            this.syncMethod = syncMethod;
            this.spec = spec;
            this.op = op;
            this.variantIndex = variantIndex;
            this.variantLabel = variantLabel;
        }

        public String operationId() {
            return syncMethod.getName();
        }

        /** Stable, human-readable id, e.g. {@code pricing.PricingUnitsApi.createPricingUnit(fixed)}. */
        public String id() {
            return module + "." + apiClass.getSimpleName() + "." + syncMethod.getName()
                    + (variantLabel == null ? "" : "(" + variantLabel + ")");
        }

        /**
         * Invokes one call form against the mock and asserts the round-trip
         * (request accepted + response deserialized). Any exception is a failure,
         * except that an operation declaring no 2xx response is expected to
         * surface its declared error (see {@link #classify}).
         */
        public void invoke(Form form, String baseUrl) throws Throwable {
            Object client = apiClient(module, baseUrl);
            Object api = apiClass.getConstructor(client.getClass()).newInstance(client);
            Class<?>[] params = syncMethod.getParameterTypes();
            Object[] args = buildArgs(syncMethod, op, spec, module, variantIndex);

            String name = syncMethod.getName();
            try {
                switch (form) {
                    case SYNC: {
                        Object result = syncMethod.invoke(api, args);
                        if (syncMethod.getReturnType() != void.class) {
                            require(result != null, "sync result deserialized to null");
                        }
                        break;
                    }
                    case WITH_HTTP_INFO: {
                        Method m = apiClass.getMethod(name + "WithHttpInfo", params);
                        Object resp = m.invoke(api, args);
                        require(resp != null, "WithHttpInfo ApiResponse was null");
                        break;
                    }
                    case CALL: {
                        Class<?> cb = apiCallbackClass(module);
                        Method m = apiClass.getMethod(name + "Call", append(params, cb));
                        Object call = m.invoke(api, append(args, (Object) null));
                        executeCall(client, call);
                        break;
                    }
                    case ASYNC: {
                        Class<?> cb = apiCallbackClass(module);
                        Method m = apiClass.getMethod(name + "Async", append(params, cb));
                        awaitAsync(m, api, args, cb);
                        break;
                    }
                    default:
                        throw new IllegalStateException("unknown form");
                }
            } catch (Throwable t) {
                // Reflection wraps the SDK's own exception; unwrap it so the
                // declared-error check below sees the real ApiException.
                Throwable err = t instanceof InvocationTargetException && t.getCause() != null
                        ? t.getCause() : t;
                Throwable c = classify(err);
                if (c != null) {
                    throw c;
                }
            }
        }

        /**
         * Classifies a thrown error into pass ({@code null}), skip, or failure.
         *
         * <p>Operations declaring no 2xx response (e.g. ReturnInternalServerError)
         * are a positive check: the SDK must surface the declared error, so an
         * {@code ApiException} whose status the spec declares is a <em>pass</em>.
         *
         * <p>Otherwise a 4xx is a failure — the request the SDK built from the
         * spec was rejected by the mock that validates against the same spec, so
         * either the SDK or the spec is wrong. A 5xx is <em>skipped</em>: Prism
         * runs in static mode, where a 5xx means it could not produce a response
         * from the spec's examples. That is a mock/spec response-side limitation
         * rather than an SDK fault, and the request was still accepted. Anything
         * else (a deserialization error, a null payload) is a failure.
         */
        private Throwable classify(Throwable err) {
            int code = httpCode(err);
            if (!op.hasSuccess && code != 0 && op.declaredStatuses.contains(code)) {
                return null; // expected error response, surfaced correctly
            }
            if (code >= 500) {
                throw new TestAbortedException("request accepted; mock could not generate a"
                        + " response from the spec examples (HTTP " + code + ")");
            }
            return err;
        }

        // Executes an okhttp3.Call built by the Call form and deserializes the response.
        private void executeCall(Object client, Object call) throws Exception {
            Class<?> callClass = Class.forName("okhttp3.Call");
            Type returnType = syncMethod.getGenericReturnType();
            if (returnType == void.class || returnType == Void.class) {
                client.getClass().getMethod("execute", callClass).invoke(client, call);
            } else {
                client.getClass().getMethod("execute", callClass, Type.class)
                        .invoke(client, call, returnType);
            }
        }

        // Invokes the Async form with a dynamic ApiCallback and waits for the result.
        private void awaitAsync(Method asyncMethod, Object api, Object[] args, Class<?> cbClass)
                throws Throwable {
            final CountDownLatch latch = new CountDownLatch(1);
            final AtomicBoolean success = new AtomicBoolean(false);
            final AtomicReference<Throwable> failure = new AtomicReference<Throwable>();
            Object callback = Proxy.newProxyInstance(cbClass.getClassLoader(),
                    new Class<?>[] {cbClass}, new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] a) {
                            String n = method.getName();
                            if ("onSuccess".equals(n)) {
                                success.set(true);
                                latch.countDown();
                            } else if ("onFailure".equals(n)) {
                                failure.set(a != null && a.length > 0 && a[0] instanceof Throwable
                                        ? (Throwable) a[0] : new RuntimeException("async onFailure"));
                                latch.countDown();
                            }
                            return null;
                        }
                    });
            asyncMethod.invoke(api, append(args, callback));
            if (!latch.await(ASYNC_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                throw new RuntimeException("async timed out");
            }
            if (!success.get()) {
                throw failure.get() != null ? failure.get() : new RuntimeException("async failed");
            }
        }
    }

    // --- argument synthesis -------------------------------------------------

    private static Object[] buildArgs(Method sync, SpecInputs.Operation op, SpecInputs spec,
            String module, int variantIndex) throws Exception {
        Class<?>[] params = sync.getParameterTypes();
        java.lang.reflect.Type[] generics = sync.getGenericParameterTypes();
        SpecInputs.Param[] bound = bindParams(sync, op);
        // The request body is the one argument that carries no spec parameter.
        int bodyIndex = -1;
        if (op.bodySchema != null) {
            for (int i = params.length - 1; i >= 0; i--) {
                if (bound[i] == null) {
                    bodyIndex = i;
                    break;
                }
            }
        }
        Object[] args = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            if (i == bodyIndex) {
                args[i] = buildBody(op, params[i], spec, module, variantIndex);
            } else if (Collection.class.isAssignableFrom(params[i])) {
                // Array parameter: supply a single spec-derived element.
                Class<?> element = elementType(generics[i]);
                String item = bound[i] != null ? spec.synthArrayItem(bound[i]) : "synthetic";
                args[i] = Collections.singletonList(coerce(item, element));
            } else {
                String value = bound[i] != null ? spec.synthParam(bound[i]) : "synthetic";
                args[i] = coerce(value, params[i]);
            }
        }
        return args;
    }

    /**
     * Binds each generated argument to the spec parameter it carries, with
     * {@code null} for arguments that carry none (the request body).
     *
     * <p>Matching is by name: the generator derives the argument name from the
     * spec parameter name ({@code created_date -> createdDate}), so an SDK
     * generated from a different spec revision — the forward-compatibility case,
     * where a parameter may have been inserted in the middle of the list — still
     * binds every value to the right argument. Argument names are in the
     * bytecode because the build passes {@code -parameters}; an SDK compiled
     * without it falls back to declaration order, which is the generator's order
     * for the spec revision that SDK was generated from.
     */
    private static SpecInputs.Param[] bindParams(Method sync, SpecInputs.Operation op) {
        java.lang.reflect.Parameter[] declared = sync.getParameters();
        SpecInputs.Param[] bound = new SpecInputs.Param[declared.length];
        if (declared.length > 0 && declared[0].isNamePresent()) {
            for (int i = 0; i < declared.length; i++) {
                for (SpecInputs.Param p : op.parameters) {
                    if (declared[i].getName().equals(SpecInputs.argName(p.name))) {
                        bound[i] = p;
                        break;
                    }
                }
            }
            return bound;
        }
        int scalarCount = op.bodySchema != null && declared.length > 0
                ? declared.length - 1 : declared.length;
        for (int i = 0; i < scalarCount && i < op.parameters.size(); i++) {
            bound[i] = op.parameters.get(i);
        }
        return bound;
    }

    /** Element type of a {@code List<E>}/{@code Collection<E>} argument. */
    private static Class<?> elementType(java.lang.reflect.Type generic) {
        if (generic instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.Type[] args = ((java.lang.reflect.ParameterizedType) generic)
                    .getActualTypeArguments();
            if (args.length == 1 && args[0] instanceof Class) {
                return (Class<?>) args[0];
            }
        }
        // Defaulting to String would send a wrong element type instead of
        // reporting that this argument is not covered.
        throw new IllegalArgumentException("cannot determine element type of " + generic);
    }

    private static Object buildBody(SpecInputs.Operation op, Class<?> type,
            SpecInputs spec, String module, int variantIndex) throws Exception {
        String json = spec.synthBodyJson(op, variantIndex);
        Gson gson = moduleGson(module);
        return gson.fromJson(json, type);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static Object coerce(String v, Class<?> t) throws Exception {
        // A spec-derived value that does not parse into the SDK's argument type
        // means either the synthesis is wrong or the spec example contradicts
        // its own declared type. Substituting a constant would hide both and let
        // the request pass on a value the spec never declared, so it fails.
        try {
            if (t == String.class) {
                return v;
            }
            if (t == Integer.class || t == int.class) {
                return Integer.valueOf(v.trim());
            }
            if (t == Long.class || t == long.class) {
                return Long.valueOf(v.trim());
            }
            if (t == Boolean.class || t == boolean.class) {
                return parseBoolean(v.trim());
            }
            if (t == Float.class || t == float.class) {
                return Float.valueOf(v.trim());
            }
            if (t == Double.class || t == double.class) {
                return Double.valueOf(v.trim());
            }
            if (t == BigDecimal.class) {
                return new BigDecimal(v.trim());
            }
            if (t == LocalDate.class) {
                return LocalDate.parse(v);
            }
            if (t == OffsetDateTime.class) {
                return OffsetDateTime.parse(v);
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("spec value '" + v + "' does not parse into "
                    + t.getSimpleName() + ": " + e.getMessage(), e);
        }
        if (t.isEnum()) {
            return toEnum(t, v);
        }
        // Unsupported types are a real coverage gap, not something to hide:
        // fail so the operation is visibly not verified.
        throw new IllegalArgumentException("unsupported parameter type " + t.getName());
    }

    private static Boolean parseBoolean(String v) {
        if ("true".equalsIgnoreCase(v) || "false".equalsIgnoreCase(v)) {
            return Boolean.valueOf(v);
        }
        throw new IllegalArgumentException("not a boolean");
    }

    private static Object toEnum(Class<?> t, String v) throws Exception {
        // Generated enums expose fromValue(String). The SDK is generated with
        // enumUnknownDefaultCase=true, so fromValue never throws: an unknown
        // value yields UNKNOWN_DEFAULT_OPEN_API, which would then be sent to the
        // mock as "unknown_default_open_api". Report it instead.
        Method fromValue = t.getMethod("fromValue", String.class);
        Object value = fromValue.invoke(null, v);
        if (value instanceof Enum && "UNKNOWN_DEFAULT_OPEN_API".equals(((Enum<?>) value).name())) {
            throw new IllegalArgumentException(
                    "spec value '" + v + "' is not a member of enum " + t.getName());
        }
        return value;
    }

    // --- reflective SDK access ---------------------------------------------

    /**
     * The module's {@code ApiClient}, created once per base URL. An OkHttp
     * client owns connection and thread pools, so it is shared across the
     * module's cases instead of being rebuilt for each one.
     */
    private static Object apiClient(String module, String baseUrl) throws Exception {
        String key = module + " " + baseUrl;
        Object cached = CLIENTS.get(key);
        if (cached != null) {
            return cached;
        }
        Class<?> clientClass = Class.forName("saasus.sdk." + module + ".ApiClient");
        Object client = clientClass.getConstructor().newInstance();
        clientClass.getMethod("setBasePath", String.class).invoke(client, baseUrl);
        // The specs declare an http "Bearer" scheme; Prism (--errors) rejects
        // requests without credentials. A synthetic token satisfies the presence
        // check; Prism does not validate its value. Synthetic data only.
        clientClass.getMethod("setBearerToken", String.class).invoke(client, BEARER);
        CLIENTS.put(key, client);
        return client;
    }

    /** HTTP status code of a generated {@code ApiException}, or 0. */
    private static int httpCode(Throwable t) {
        // Each module has its own saasus.sdk.<module>.ApiException and this
        // harness is module-agnostic, so the status is read reflectively. Only
        // the numeric status is used, so no response body or PII is exposed.
        if (t == null || !"ApiException".equals(t.getClass().getSimpleName())) {
            return 0;
        }
        try {
            Object code = t.getClass().getMethod("getCode").invoke(t);
            return code instanceof Integer ? (Integer) code : 0;
        } catch (Exception e) {
            return 0;
        }
    }

    private static Class<?> apiCallbackClass(String module) throws ClassNotFoundException {
        return Class.forName("saasus.sdk." + module + ".ApiCallback");
    }

    private static Gson moduleGson(String module) throws Exception {
        Class<?> jsonClass = Class.forName("saasus.sdk." + module + ".JSON");
        return (Gson) jsonClass.getMethod("getGson").invoke(null);
    }

    // --- small helpers ------------------------------------------------------

    private static Class<?>[] append(Class<?>[] arr, Class<?> extra) {
        Class<?>[] out = Arrays.copyOf(arr, arr.length + 1);
        out[arr.length] = extra;
        return out;
    }

    private static Object[] append(Object[] arr, Object extra) {
        Object[] out = Arrays.copyOf(arr, arr.length + 1);
        out[arr.length] = extra;
        return out;
    }

    private static void require(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
