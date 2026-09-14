package saasus.sdk.testlib.snapshot;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Shared JSON helpers that make Java snapshot output line up with the Go implementation:
 *
 * <ul>
 *   <li>snake_case field names ({@link FieldNamingPolicy#LOWER_CASE_WITH_UNDERSCORES});</li>
 *   <li>{@code null} members are emitted (Go emits {@code null} for absent pointers, nil maps and
 *       non-{@code omitempty} slices such as the validation error lists), via
 *       {@code serializeNulls()};</li>
 *   <li>fields annotated {@link OmitEmpty} are dropped when empty, reproducing Go's
 *       {@code json:",omitempty"} tags (via {@link OmitEmptyTypeAdapterFactory});</li>
 *   <li>map keys are sorted lexicographically ({@code encoding/json} sorts object keys);</li>
 *   <li>HTML escaping disabled so base64 values ({@code +}, {@code =}) stay verbatim like Go;</li>
 *   <li>integral JSON numbers are read as {@code Long} (not {@code Double}) so timestamps and ids
 *       render as {@code 1763529623} rather than {@code 1.763529623E9}, matching Go's
 *       {@code encoding/json};</li>
 *   <li>two-space indentation, matching {@code json.MarshalIndent(v, "", "  ")}.</li>
 * </ul>
 */
final class SnapshotJson {

    /** Serializer for the snapshot/validation model objects (snake_case, nulls, 2-space). */
    static final Gson SNAKE = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .serializeNulls()
            .registerTypeAdapterFactory(new OmitEmptyTypeAdapterFactory())
            .disableHtmlEscaping()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .setPrettyPrinting()
            .create();

    /** Plain parser/normalizer (no naming policy) for arbitrary response payloads. */
    static final Gson PLAIN = new GsonBuilder()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create();

    /** Pretty writer for embedded body strings (matches Go's indented, key-sorted body). */
    private static final Gson BODY = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();

    private SnapshotJson() {
    }

    /** Converts any object into the canonical map/list/primitive representation. */
    static Object normalize(Object value) {
        if (value == null) {
            return null;
        }
        return PLAIN.fromJson(PLAIN.toJsonTree(value), Object.class);
    }

    /** Parses a JSON string into map/list/primitives, or {@code null} if not valid JSON. */
    static Object parse(String json) {
        if (json == null) {
            return null;
        }
        try {
            return PLAIN.fromJson(json, Object.class);
        } catch (RuntimeException e) {
            return null;
        }
    }

    /**
     * Recursively rewrites every {@link Map} as a lexicographically sorted map, matching the
     * key ordering produced by Go's {@code encoding/json}. Lists are preserved in order.
     */
    @SuppressWarnings("unchecked")
    static Object deepSort(Object value) {
        if (value instanceof Map) {
            Map<Object, Object> src = (Map<Object, Object>) value;
            TreeMap<String, Object> sorted = new TreeMap<String, Object>();
            for (Map.Entry<Object, Object> e : src.entrySet()) {
                sorted.put(String.valueOf(e.getKey()), deepSort(e.getValue()));
            }
            return sorted;
        }
        if (value instanceof List) {
            List<Object> src = (List<Object>) value;
            List<Object> out = new ArrayList<Object>(src.size());
            for (Object item : src) {
                out.add(deepSort(item));
            }
            return out;
        }
        return canonicalizeNumber(value);
    }

    /**
     * Renders integer-valued floating point numbers as {@code Long} so they serialize as
     * {@code 1763529623} instead of {@code 1.763529623E9}. This matches Go's {@code encoding/json},
     * which prints integer-valued {@code float64} without an exponent. Genuine fractional values
     * and out-of-range magnitudes are left untouched.
     */
    private static Object canonicalizeNumber(Object value) {
        if (value instanceof Double || value instanceof Float) {
            double d = ((Number) value).doubleValue();
            if (!Double.isNaN(d) && !Double.isInfinite(d)
                    && d == Math.floor(d)
                    && Math.abs(d) < 9.007199254740992E15) { // 2^53: exact integer range
                return (long) d;
            }
        }
        return value;
    }

    /** Serializes an already-normalized/masked value as an indented, key-sorted body string. */
    static String prettyBody(Object value) {
        return BODY.toJson(deepSort(value));
    }
}
