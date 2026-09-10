package saasus.sdk.testlib.snapshot;

import com.google.gson.Gson;

/**
 * Helpers to normalise arbitrary SDK response objects into a canonical structure of
 * {@code Map}/{@code List}/{@code String}/{@code Double}/{@code Boolean}/{@code null}
 * via Gson. Using a single representation for both the current run and the stored baseline
 * keeps structural comparison consistent.
 */
final class SnapshotSupport {

    private static final Gson GSON = new Gson();

    private SnapshotSupport() {
    }

    /** Converts any object into the canonical map/list/primitive representation. */
    static Object normalize(Object value) {
        if (value == null) {
            return null;
        }
        // toJsonTree then back to Object yields LinkedTreeMap/ArrayList/Double/String/Boolean.
        return GSON.fromJson(GSON.toJsonTree(value), Object.class);
    }

    /** Human-readable Java type name of a normalized value, used for type-mismatch reporting. */
    static String typeName(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof java.util.Map) {
            return "object";
        }
        if (value instanceof java.util.List) {
            return "array";
        }
        if (value instanceof Boolean) {
            return "boolean";
        }
        if (value instanceof Number) {
            return "number";
        }
        if (value instanceof String) {
            return "string";
        }
        return value.getClass().getSimpleName();
    }
}
