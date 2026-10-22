package saasus.sdk.contract;

import com.google.gson.Gson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
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

import org.junit.jupiter.api.Assertions;

/**
 * Reflective contract engine behind the JUnit suite ({@link ContractTest}).
 *
 * <p>Sync and {@code Async} are the only call forms run: {@code Call} and
 * {@code WithHttpInfo} are sub-paths of sync ({@code foo -> fooWithHttpInfo ->
 * fooValidateBeforeCall -> fooCall}), whereas {@code Async}
 * ({@code executeAsync}/{@code ApiCallback}) is not, so it runs on its own.
 * Being reflective, it runs whichever modules are generated and overlays on any
 * SDK generation.
 */
public final class ContractEngine {

    /** All SDK modules. A module is tested only if it is generated AND has a Prism endpoint. */
    public static final List<String> MODULES = Arrays.asList(
            "auth", "pricing", "billing", "awsmarketplace", "integration", "apilog", "communication");

    private static final String BEARER = "synthetic-bearer-token";
    private static final long ASYNC_TIMEOUT_SECONDS = 30;

    private static final Map<String, Object> CLIENTS = new ConcurrentHashMap<String, Object>();

    public enum Form {
        SYNC, ASYNC
    }

    private ContractEngine() {
    }

    // --- discovery ----------------------------------------------------------

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

    /** Spec operations with no generated SDK method; an older SDK legitimately lacks newer ones. */
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
     * The generated sync method for a spec operation, or {@code null} when this
     * SDK lacks it (so an older SDK excludes it naturally). Single source of the
     * operationId -> SDK method mapping, so enumeration and the completeness
     * check cannot drift apart.
     */
    private static Method resolveSyncMethod(String module, SpecInputs.Operation op) {
        if (op.tag == null) {
            return null;
        }
        Class<?> api = tryClass("saasus.sdk." + module + ".api." + apiClassName(op.tag));
        if (api == null) {
            return null;
        }
        Method sync = findDeclaredMethod(api, SpecInputs.methodName(op.operationId));
        // A real operation also has a <name>Call form, which rejects names
        // colliding with the API class's own accessors (getApiClient, ...).
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
     * The public declared method with that name, or {@code null}. The name is
     * operationId-derived, so the {@code Call}/{@code Async}/{@code WithHttpInfo}
     * forms cannot match.
     */
    private static Method findDeclaredMethod(Class<?> api, String name) {
        for (Method m : api.getDeclaredMethods()) {
            int mod = m.getModifiers();
            if (!Modifier.isPublic(mod) || Modifier.isStatic(mod) || m.isSynthetic() || m.isBridge()) {
                continue;
            }
            if (m.getName().equals(name)) {
                return m;
            }
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

        /** Stable, human-readable id, e.g. {@code pricing.PricingUnitsApi.createPricingUnit(fixed)}. */
        public String id() {
            return module + "." + apiClass.getSimpleName() + "." + syncMethod.getName()
                    + (variantLabel == null ? "" : "(" + variantLabel + ")");
        }

        /**
         * Invokes one call form against the mock and asserts the round trip.
         * Any exception fails, except the declared error of an operation with
         * no 2xx response (see {@link #classify}).
         */
        public void invoke(Form form, String baseUrl) throws Throwable {
            try {
                Object client = apiClient(module, baseUrl);
                Object api = apiClass.getConstructor(client.getClass()).newInstance(client);
                Class<?>[] params = syncMethod.getParameterTypes();
                Object[] args = buildArgs(syncMethod, op, spec, module, variantIndex);

                String name = syncMethod.getName();
                switch (form) {
                    case SYNC: {
                        Object result = syncMethod.invoke(api, args);
                        if (syncMethod.getReturnType() != void.class) {
                            Assertions.assertNotNull(result, "sync result deserialized to null");
                        }
                        break;
                    }
                    case ASYNC: {
                        Class<?> cb = apiCallbackClass(module);
                        Method m = apiClass.getMethod(name + "Async", append(params, cb));
                        // As in sync: a non-void operation must deliver a payload.
                        awaitAsync(m, api, args, cb, syncMethod.getReturnType() != void.class);
                        break;
                    }
                    default:
                        throw new IllegalStateException("unknown form");
                }
            } catch (AssertionError e) {
                // Only from this harness ("... deserialized to null"): the
                // message carries no response body, so it is reported as is.
                throw e;
            } catch (Throwable t) {
                // Unwrap so the declared-error check sees the real ApiException.
                Throwable err = t instanceof InvocationTargetException && t.getCause() != null
                        ? t.getCause() : t;
                if (classify(err) != null) {
                    throw failure(form, err);
                }
            }
        }

        /**
         * The reported failure, built from the operation, the call form, the
         * exception type and the HTTP status only. The original exception is
         * neither chained nor quoted: generated models put the response body in
         * their deserialization message ({@code PricingUnit}: "... JSON: %s")
         * and surefire prints the whole chain into the uploaded report.
         * Diagnosis needs a local re-run.
         */
        private AssertionError failure(Form form, Throwable err) {
            int code = httpCode(err);
            return new AssertionError(id() + " [" + form + "] failed: "
                    + err.getClass().getName()
                    + (code != 0 ? " (HTTP " + code + ")" : "")
                    + " — response bodies are deliberately not reported;"
                    + " re-run locally for the detail");
        }

        /**
         * Pass ({@code null}) or failure. For an operation declaring no 2xx
         * response (e.g. ReturnInternalServerError) surfacing the declared error
         * IS the check, so an {@code ApiException} with a spec-declared status
         * passes. Everything else fails: a 4xx means the mock rejected a request
         * built from the same spec it validates against, so the SDK or the spec
         * is wrong; a 5xx means Prism (static mode) could not produce the
         * declared response, a spec defect. Skipping either would leave that
         * operation's response deserialization unverified.
         */
        private Throwable classify(Throwable err) {
            int code = httpCode(err);
            if (!op.hasSuccess && code != 0 && op.declaredStatuses.contains(code)) {
                return null;
            }
            return err;
        }

    }

    /**
     * Invokes the {@code Async} form with a dynamic {@code ApiCallback} and
     * waits for the result. With {@code expectNonNull}, {@code onSuccess} must
     * deliver a non-null payload; a void operation may deliver {@code null}.
     * Package-private so it can be unit-tested without a live mock.
     */
    static void awaitAsync(Method asyncMethod, Object api, Object[] args, Class<?> cbClass,
            boolean expectNonNull) throws Throwable {
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicBoolean success = new AtomicBoolean(false);
        final AtomicReference<Object> result = new AtomicReference<Object>();
        final AtomicReference<Throwable> failure = new AtomicReference<Throwable>();
        Object callback = Proxy.newProxyInstance(cbClass.getClassLoader(),
                new Class<?>[] {cbClass}, new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] a) {
                        String n = method.getName();
                        if ("onSuccess".equals(n)) {
                            // ApiCallback.onSuccess(result, statusCode, headers)
                            result.set(a != null && a.length > 0 ? a[0] : null);
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
        if (expectNonNull) {
            Assertions.assertNotNull(result.get(), "async result deserialized to null");
        }
    }

    // --- argument synthesis -------------------------------------------------

    private static Object[] buildArgs(Method sync, SpecInputs.Operation op, SpecInputs spec,
            String module, int variantIndex) throws Exception {
        Class<?>[] params = sync.getParameterTypes();
        java.lang.reflect.Type[] generics = sync.getGenericParameterTypes();
        SpecInputs.Param[] bound = bindParams(sync, op);
        // The body is the only argument with no spec parameter, so exactly one
        // argument is unbound when the operation has a body and none otherwise.
        // Anything else is an unbound spec parameter, which must not be filled
        // with a constant: the request would carry a value the spec never
        // declared (the forward-compat run found such a mis-binding).
        int unbound = 0;
        int bodyIndex = -1;
        for (int i = 0; i < params.length; i++) {
            if (bound[i] == null) {
                unbound++;
                bodyIndex = i;
            }
        }
        int expected = op.bodySchema != null ? 1 : 0;
        if (unbound != expected) {
            throw new IllegalStateException("parameter binding failed for " + sync.getName()
                    + ": expected " + expected + " unbound argument(s) (the request body), got "
                    + unbound + " of " + params.length);
        }
        Object[] args = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            if (i == bodyIndex) {
                args[i] = buildBody(op, params[i], spec, module, variantIndex);
            } else if (Collection.class.isAssignableFrom(params[i])) {
                // Array parameter: supply a single spec-derived element.
                Class<?> element = elementType(generics[i]);
                args[i] = Collections.singletonList(coerce(spec.synthArrayItem(bound[i]), element));
            } else {
                args[i] = coerce(spec.synthParam(bound[i]), params[i]);
            }
        }
        return args;
    }

    /**
     * Binds each generated argument to the spec parameter it carries,
     * {@code null} for the one that carries none (the request body).
     *
     * <p>By name: the generator derives the argument name from the spec
     * parameter name ({@code created_date -> createdDate}), so an SDK generated
     * from another spec revision — the forward-compat case, where a parameter
     * may have been inserted mid-list — still binds every value to the right
     * argument. {@code -parameters} puts the names in the bytecode, and every
     * release bundling this suite bundles that {@code pom.xml}, so they are
     * always present. If not, binding fails loudly instead of falling back to
     * declaration order, which would silently send a valid-looking request
     * built from the wrong values.
     */
    private static SpecInputs.Param[] bindParams(Method sync, SpecInputs.Operation op) {
        java.lang.reflect.Parameter[] declared = sync.getParameters();
        SpecInputs.Param[] bound = new SpecInputs.Param[declared.length];
        if (declared.length == 0) {
            return bound;
        }
        if (!declared[0].isNamePresent()) {
            throw new IllegalStateException("argument names are missing from " + sync.getName()
                    + "; the SDK must be compiled with -parameters for name-based binding");
        }
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
        // reporting that this argument is uncovered.
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
        // A spec value that does not parse into the argument type means the
        // synthesis is wrong or the example contradicts its declared type;
        // substituting a constant would hide both and send a value the spec
        // never declared, so it fails.
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
        // An unsupported type is a coverage gap: fail so the operation is
        // visibly not verified.
        throw new IllegalArgumentException("unsupported parameter type " + t.getName());
    }

    private static Boolean parseBoolean(String v) {
        if ("true".equalsIgnoreCase(v) || "false".equalsIgnoreCase(v)) {
            return Boolean.valueOf(v);
        }
        throw new IllegalArgumentException("not a boolean");
    }

    private static Object toEnum(Class<?> t, String v) throws Exception {
        // Generated enums expose fromValue(String), and with
        // enumUnknownDefaultCase=true it never throws: an unknown value yields
        // UNKNOWN_DEFAULT_OPEN_API and would be sent to the mock as
        // "unknown_default_open_api". Report it instead.
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
     * The module's {@code ApiClient}, created once and shared across the
     * module's cases: an OkHttp client owns connection and thread pools, so it
     * is not rebuilt per case.
     */
    private static Object apiClient(String module, String baseUrl) throws Exception {
        Object cached = CLIENTS.get(module);
        if (cached != null) {
            return cached;
        }
        Class<?> clientClass = Class.forName("saasus.sdk." + module + ".ApiClient");
        Object client = clientClass.getConstructor().newInstance();
        clientClass.getMethod("setBasePath", String.class).invoke(client, baseUrl);
        // The specs declare an http "Bearer" scheme and Prism (--errors)
        // rejects requests without credentials; it does not validate the value,
        // so a synthetic token suffices. Synthetic data only.
        clientClass.getMethod("setBearerToken", String.class).invoke(client, BEARER);
        CLIENTS.put(module, client);
        return client;
    }

    /** HTTP status code of a generated {@code ApiException}, or 0. */
    private static int httpCode(Throwable t) {
        // Each module has its own saasus.sdk.<module>.ApiException and this
        // harness is module-agnostic, so the status is read reflectively. Only
        // the number is used: no response body or PII is exposed.
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
}
