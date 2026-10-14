package saasus.sdk.contract;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * Supplies request inputs (path/query/header parameters and request bodies)
 * for an operation by reading the OpenAPI spec, instead of hardcoding them.
 *
 * <p>Why spec-driven: the same mock (Prism) validates against this spec, so
 * values taken from the spec's {@code example}/schema are accepted by design.
 * The mapping is language-agnostic (operationId -&gt; path/body), so other
 * language SDKs can reuse the exact same approach with only a thin
 * "operationId -&gt; SDK method" binding.
 *
 * <p>Spec resolution order for a module:
 * <ol>
 *   <li>{@code CONTRACT_SPEC_DIR} env var holding {@code <module>.yml};</li>
 *   <li>repo-root {@code <module>api.yml} (or {@code integration.yml}), the
 *       filenames {@code generate.sh} consumes.</li>
 * </ol>
 */
public final class SpecInputs {

    /** Parsed spec per module ({@code null} value = no spec file for it). */
    private static final Map<String, SpecInputs> CACHE = new HashMap<String, SpecInputs>();

    private final Map<String, Object> root;
    /** operations keyed by the generated method name (operationId, first char lower-cased). */
    private final Map<String, Operation> operations = new LinkedHashMap<String, Operation>();

    private SpecInputs(Map<String, Object> root) {
        this.root = root;
        indexOperations();
    }

    /**
     * Loads the spec for a module, or returns {@code null} if none is found.
     * Parsed once per module: the suite asks for it per case, and re-reading the
     * YAML thousands of times dominates the run otherwise.
     */
    public static synchronized SpecInputs forModule(String module) {
        if (!CACHE.containsKey(module)) {
            CACHE.put(module, load(module));
        }
        return CACHE.get(module);
    }

    @SuppressWarnings("unchecked")
    private static SpecInputs load(String module) {
        File file = resolveSpecFile(module);
        if (file == null || !file.isFile()) {
            return null;
        }
        try (InputStream in = new FileInputStream(file)) {
            Object loaded = new Yaml().load(in);
            if (!(loaded instanceof Map)) {
                return null;
            }
            return new SpecInputs((Map<String, Object>) loaded);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to read spec for module '" + module + "'", e);
        }
    }

    private static File resolveSpecFile(String module) {
        String dir = System.getenv("CONTRACT_SPEC_DIR");
        if (dir != null && !dir.isEmpty()) {
            File f = new File(dir, module + ".yml");
            if (f.isFile()) {
                return f;
            }
        }
        // generate.sh maps every module to "<module>api.yml" except integration.
        String rootName = "integration".equals(module) ? "integration.yml" : module + "api.yml";
        File rootFile = new File(rootName);
        if (rootFile.isFile()) {
            return rootFile;
        }
        return null;
    }

    public List<Operation> allOperations() {
        return new ArrayList<Operation>(operations.values());
    }

    // --- indexing -----------------------------------------------------------

    @SuppressWarnings("unchecked")
    private void indexOperations() {
        Object pathsObj = root.get("paths");
        if (!(pathsObj instanceof Map)) {
            return;
        }
        Map<String, Object> paths = (Map<String, Object>) pathsObj;
        for (Map.Entry<String, Object> pathEntry : paths.entrySet()) {
            if (!(pathEntry.getValue() instanceof Map)) {
                continue;
            }
            Map<String, Object> pathItem = (Map<String, Object>) pathEntry.getValue();
            for (Map.Entry<String, Object> methodEntry : pathItem.entrySet()) {
                String httpMethod = methodEntry.getKey();
                if (!isHttpMethod(httpMethod) || !(methodEntry.getValue() instanceof Map)) {
                    continue;
                }
                Map<String, Object> op = (Map<String, Object>) methodEntry.getValue();
                Object opId = op.get("operationId");
                if (!(opId instanceof String)) {
                    continue;
                }
                Operation operation = new Operation();
                operation.operationId = (String) opId;
                operation.tag = firstTag(op);
                operation.parameters = loadParameters(pathItem, op);
                operation.bodySchema = resolveBodySchema(op);
                loadResponseStatuses(op, operation);
                operations.put(methodName(operation.operationId), operation);
            }
        }
    }

    private static boolean isHttpMethod(String s) {
        return "get".equals(s) || "put".equals(s) || "post".equals(s) || "delete".equals(s)
                || "patch".equals(s) || "head".equals(s) || "options".equals(s);
    }

    /** Records the declared HTTP response statuses and whether any is a 2xx success. */
    @SuppressWarnings("unchecked")
    private void loadResponseStatuses(Map<String, Object> op, Operation operation) {
        Object responses = op.get("responses");
        if (!(responses instanceof Map)) {
            return;
        }
        for (Object key : ((Map<Object, Object>) responses).keySet()) {
            int status;
            if (key instanceof Integer) {
                status = (Integer) key;
            } else {
                try {
                    status = Integer.parseInt(String.valueOf(key).trim());
                } catch (NumberFormatException ignore) {
                    continue; // non-numeric keys such as "default" carry no status.
                }
            }
            operation.declaredStatuses.add(status);
            if (status >= 200 && status < 300) {
                operation.hasSuccess = true;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String firstTag(Map<String, Object> op) {
        Object tags = op.get("tags");
        if (tags instanceof List && !((List<Object>) tags).isEmpty()) {
            Object t = ((List<Object>) tags).get(0);
            if (t instanceof String) {
                return (String) t;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private List<Param> loadParameters(Map<String, Object> pathItem, Map<String, Object> op) {
        List<Param> out = new ArrayList<Param>();
        // Path-level parameters apply to every operation, then operation-level ones.
        addParameters(out, (List<Object>) asList(pathItem.get("parameters")));
        addParameters(out, (List<Object>) asList(op.get("parameters")));
        return out;
    }

    /**
     * Collects the declared parameters. {@code in} and {@code required} are
     * deliberately not recorded: the generator maps every parameter to a
     * positional argument regardless of its location, and the harness always
     * supplies a value for every argument (optional ones included) so that
     * optional path/query parameters are exercised too.
     */
    @SuppressWarnings("unchecked")
    private void addParameters(List<Param> out, List<Object> raw) {
        if (raw == null) {
            return;
        }
        for (Object o : raw) {
            if (!(o instanceof Map)) {
                continue;
            }
            Map<String, Object> p = resolve((Map<String, Object>) o);
            Param param = new Param();
            param.name = str(p.get("name"));
            param.schema = p.get("schema") instanceof Map
                    ? resolve((Map<String, Object>) p.get("schema")) : null;
            param.example = p.containsKey("example") ? p.get("example")
                    : (param.schema != null ? param.schema.get("example") : null);
            out.add(param);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> resolveBodySchema(Map<String, Object> op) {
        Object body = op.get("requestBody");
        if (!(body instanceof Map)) {
            return null;
        }
        Map<String, Object> rb = resolve((Map<String, Object>) body);
        Object content = rb.get("content");
        if (!(content instanceof Map)) {
            return null;
        }
        Object json = ((Map<String, Object>) content).get("application/json");
        if (!(json instanceof Map)) {
            return null;
        }
        Object schema = ((Map<String, Object>) json).get("schema");
        return schema instanceof Map ? resolve((Map<String, Object>) schema) : null;
    }

    // --- synthesis ----------------------------------------------------------

    /** Synthesizes a scalar value (as a String) for a path/query/header parameter. */
    public String synthParam(Param p) {
        if (p.example != null) {
            return String.valueOf(p.example);
        }
        Object v = synthFromSchema(p.schema);
        return v == null ? "synthetic" : String.valueOf(v);
    }

    /** Synthesizes a single element value (as a String) for an array parameter. */
    @SuppressWarnings("unchecked")
    public String synthArrayItem(Param p) {
        if (p.schema != null && "array".equals(p.schema.get("type"))
                && p.schema.get("items") instanceof Map) {
            Object v = synthFromSchema((Map<String, Object>) p.schema.get("items"));
            return v == null ? "synthetic" : String.valueOf(v);
        }
        return synthParam(p);
    }

    /**
     * Labels of the request body's top-level {@code oneOf}/{@code anyOf}
     * variants (the discriminator value when declared, otherwise the schema
     * name). Empty when the body is not a composite, i.e. a single case.
     */
    public List<String> bodyVariantLabels(Operation op) {
        List<String> labels = new ArrayList<String>();
        List<Object> variants = compositeVariants(op == null ? null : op.bodySchema);
        if (variants == null) {
            return labels;
        }
        Object disc = op.bodySchema.get("discriminator");
        for (Object v : variants) {
            String ref = v instanceof Map && ((Map<?, ?>) v).get("$ref") instanceof String
                    ? (String) ((Map<?, ?>) v).get("$ref") : null;
            labels.add(disc instanceof Map
                    ? discriminatorValue(asMap(disc), ref)
                    : (ref != null ? ref.substring(ref.lastIndexOf('/') + 1) : "variant"));
        }
        return labels;
    }

    /**
     * Synthesizes a JSON request body, selecting the given top-level
     * {@code oneOf}/{@code anyOf} variant. Returns {@code null} if the
     * operation has no request body.
     */
    public String synthBodyJson(Operation op, int variantIndex) {
        if (op.bodySchema == null) {
            return null;
        }
        List<Object> variants = compositeVariants(op.bodySchema);
        Object tree;
        if (variants != null && variantIndex < variants.size()) {
            tree = synthVariant(op.bodySchema, variants.get(variantIndex));
        } else {
            tree = synthFromSchema(op.bodySchema);
        }
        return new Gson().toJson(tree == null ? new LinkedHashMap<String, Object>() : tree);
    }

    /** The {@code oneOf}/{@code anyOf} member list of a schema, or {@code null}. */
    @SuppressWarnings("unchecked")
    private List<Object> compositeVariants(Map<String, Object> schema) {
        if (schema == null) {
            return null;
        }
        List<Object> variants = schema.get("oneOf") instanceof List
                ? (List<Object>) schema.get("oneOf")
                : (schema.get("anyOf") instanceof List ? (List<Object>) schema.get("anyOf") : null);
        return variants == null || variants.isEmpty() ? null : variants;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> asMap(Object o) {
        return (Map<String, Object>) o;
    }

    @SuppressWarnings("unchecked")
    private Object synthFromSchema(Map<String, Object> schema) {
        if (schema == null) {
            return null;
        }
        schema = resolve(schema);
        if (schema.containsKey("example")) {
            return schema.get("example");
        }
        if (schema.get("enum") instanceof List && !((List<Object>) schema.get("enum")).isEmpty()) {
            return ((List<Object>) schema.get("enum")).get(0);
        }
        // oneOf/anyOf: synthesize the first variant and, when a discriminator is
        // declared, set the discriminator property so the generated model can
        // resolve the variant (e.g. PricingUnitForSave -> type: "tiered_usage").
        List<Object> variants = compositeVariants(schema);
        if (variants != null) {
            return synthVariant(schema, variants.get(0));
        }
        // allOf: merge member schemas (sufficient for required/properties composition).
        if (schema.get("allOf") instanceof List) {
            Map<String, Object> merged = new LinkedHashMap<String, Object>();
            Map<String, Object> props = new LinkedHashMap<String, Object>();
            List<Object> required = new ArrayList<Object>();
            for (Object m : (List<Object>) schema.get("allOf")) {
                if (m instanceof Map) {
                    Map<String, Object> part = resolve((Map<String, Object>) m);
                    if (part.get("properties") instanceof Map) {
                        props.putAll((Map<String, Object>) part.get("properties"));
                    }
                    if (part.get("required") instanceof List) {
                        required.addAll((List<Object>) part.get("required"));
                    }
                }
            }
            merged.put("properties", props);
            merged.put("required", required);
            return synthObject(merged);
        }
        String type = str(schema.get("type"));
        if (type == null && schema.get("properties") instanceof Map) {
            type = "object";
        }
        if ("object".equals(type)) {
            return synthObject(schema);
        }
        if ("array".equals(type)) {
            List<Object> arr = new ArrayList<Object>();
            Object items = schema.get("items");
            if (items instanceof Map) {
                Object elem = synthFromSchema((Map<String, Object>) items);
                if (elem != null) {
                    arr.add(elem);
                }
            }
            return arr;
        }
        return synthScalar(type, str(schema.get("format")));
    }

    @SuppressWarnings("unchecked")
    private Object synthObject(Map<String, Object> schema) {
        Map<String, Object> out = new LinkedHashMap<String, Object>();
        Object propsObj = schema.get("properties");
        if (!(propsObj instanceof Map)) {
            return out;
        }
        Map<String, Object> props = (Map<String, Object>) propsObj;
        List<Object> required = schema.get("required") instanceof List
                ? (List<Object>) schema.get("required") : new ArrayList<Object>();
        for (Object req : required) {
            String name = String.valueOf(req);
            Object propSchema = props.get(name);
            if (propSchema instanceof Map) {
                out.put(name, synthFromSchema((Map<String, Object>) propSchema));
            } else {
                out.put(name, "synthetic");
            }
        }
        return out;
    }

    /**
     * Synthesizes one {@code oneOf}/{@code anyOf} member and, when the parent
     * declares a discriminator, sets the discriminator property so the value
     * resolves to that member (e.g. {@code type: "fixed"}).
     */
    @SuppressWarnings("unchecked")
    private Object synthVariant(Map<String, Object> schema, Object member) {
        if (!(member instanceof Map)) {
            return new LinkedHashMap<String, Object>();
        }
        Map<String, Object> memberNode = (Map<String, Object>) member;
        String ref = memberNode.get("$ref") instanceof String ? (String) memberNode.get("$ref") : null;
        Object value = synthFromSchema(memberNode);
        Object disc = schema.get("discriminator");
        if (disc instanceof Map && value instanceof Map) {
            String property = str(((Map<String, Object>) disc).get("propertyName"));
            if (property != null) {
                ((Map<String, Object>) value).put(property,
                        discriminatorValue((Map<String, Object>) disc, ref));
            }
        }
        return value;
    }

    /** Resolves the discriminator value whose mapping points at the chosen member. */
    @SuppressWarnings("unchecked")
    private String discriminatorValue(Map<String, Object> discriminator, String memberRef) {
        String memberName = memberRef != null
                ? memberRef.substring(memberRef.lastIndexOf('/') + 1) : null;
        Object mapping = discriminator.get("mapping");
        if (mapping instanceof Map && memberRef != null) {
            for (Map.Entry<String, Object> e : ((Map<String, Object>) mapping).entrySet()) {
                if (String.valueOf(e.getValue()).equals(memberRef)) {
                    return e.getKey();
                }
            }
        }
        return memberName != null ? memberName : "synthetic";
    }

    private Object synthScalar(String type, String format) {
        if ("integer".equals(type) || "number".equals(type)) {
            return Integer.valueOf(1);
        }
        if ("boolean".equals(type)) {
            return Boolean.TRUE;
        }
        // string (and unknown types) -> format-aware synthetic value.
        if ("date".equals(format)) {
            return "2024-01-01";
        }
        if ("date-time".equals(format)) {
            return "2024-01-01T00:00:00Z";
        }
        if ("email".equals(format)) {
            return "synthetic@example.com";
        }
        if ("uuid".equals(format)) {
            return "00000000-0000-0000-0000-000000000000";
        }
        return "synthetic";
    }

    // --- $ref resolution ----------------------------------------------------

    @SuppressWarnings("unchecked")
    private Map<String, Object> resolve(Map<String, Object> node) {
        int guard = 0;
        while (node != null && node.get("$ref") instanceof String && guard++ < 32) {
            node = resolveRef((String) node.get("$ref"));
        }
        return node == null ? new LinkedHashMap<String, Object>() : node;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> resolveRef(String ref) {
        if (!ref.startsWith("#/")) {
            return null;
        }
        Object cur = root;
        for (String seg : ref.substring(2).split("/")) {
            seg = seg.replace("~1", "/").replace("~0", "~");
            if (!(cur instanceof Map)) {
                return null;
            }
            cur = ((Map<String, Object>) cur).get(seg);
        }
        return cur instanceof Map ? (Map<String, Object>) cur : null;
    }

    // --- helpers ------------------------------------------------------------

    /** Generated method name = operationId with the first character lower-cased. */
    public static String methodName(String operationId) {
        if (operationId == null || operationId.isEmpty()) {
            return operationId;
        }
        return Character.toLowerCase(operationId.charAt(0)) + operationId.substring(1);
    }

    /**
     * Generated argument name for a spec parameter name: separators are dropped
     * and the following character capitalised, with a lower-case first letter
     * ({@code created_date -> createdDate}, {@code X-Saasus-Referer ->
     * xSaasusReferer}), mirroring the generator's parameter naming.
     */
    public static String argName(String specParamName) {
        if (specParamName == null || specParamName.isEmpty()) {
            return specParamName;
        }
        StringBuilder out = new StringBuilder(specParamName.length());
        boolean capitalise = false;
        for (char c : specParamName.toCharArray()) {
            if (c == '_' || c == '-' || c == '.' || c == ' ') {
                capitalise = true;
                continue;
            }
            out.append(capitalise ? Character.toUpperCase(c) : c);
            capitalise = false;
        }
        if (out.length() > 0) {
            out.setCharAt(0, Character.toLowerCase(out.charAt(0)));
        }
        return out.toString();
    }

    private static String str(Object o) {
        return o == null ? null : String.valueOf(o);
    }

    private static List<Object> asList(Object o) {
        return o instanceof List ? (List<Object>) o : null;
    }

    // --- data holders -------------------------------------------------------

    public static final class Operation {
        public String operationId;
        public String tag;
        public List<Param> parameters = new ArrayList<Param>();
        public Map<String, Object> bodySchema;
        /** All numeric HTTP status codes declared under the operation's responses. */
        public Set<Integer> declaredStatuses = new HashSet<Integer>();
        /** Whether the operation declares any 2xx success response. */
        public boolean hasSuccess;
    }

    public static final class Param {
        public String name;
        public Map<String, Object> schema;
        public Object example;
    }
}
