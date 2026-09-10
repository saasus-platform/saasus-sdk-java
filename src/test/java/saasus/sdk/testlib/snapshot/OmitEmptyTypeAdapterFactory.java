package saasus.sdk.testlib.snapshot;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Gson factory that reproduces Go's {@code omitempty} behaviour for fields annotated with
 * {@link OmitEmpty}. The base {@link com.google.gson.GsonBuilder#serializeNulls()} keeps emitting
 * {@code null} for ordinary (non-{@code omitempty}) members — matching Go's nil pointers, maps and
 * non-{@code omitempty} slices — while members backed by an {@link OmitEmpty} field are dropped
 * when their serialized value is empty (null, {@code ""}, {@code []} or <code>{}</code>).
 *
 * <p>Only the top-level members of an annotated model object are considered, so arbitrary payload
 * maps (for example {@code json_data}) are never touched.
 */
final class OmitEmptyTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, TypeToken<T> type) {
        final Set<String> omitNames = omitEmptyMemberNames(type.getRawType());
        if (omitNames.isEmpty()) {
            return null; // No annotated fields: fall back to the default adapter.
        }
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                JsonElement tree = delegate.toJsonTree(value);
                if (tree.isJsonObject()) {
                    JsonObject obj = tree.getAsJsonObject();
                    for (String name : omitNames) {
                        JsonElement member = obj.get(name);
                        if (member != null && isEmpty(member)) {
                            obj.remove(name);
                        }
                    }
                }
                elementAdapter.write(out, tree);
            }

            @Override
            public T read(JsonReader in) throws IOException {
                return delegate.read(in);
            }
        };
    }

    /** Serialized (snake_case) names of the {@link OmitEmpty} fields declared on {@code raw}. */
    private static Set<String> omitEmptyMemberNames(Class<?> raw) {
        Set<String> names = new HashSet<String>();
        for (Class<?> c = raw; c != null && c != Object.class; c = c.getSuperclass()) {
            for (Field f : c.getDeclaredFields()) {
                if (f.isAnnotationPresent(OmitEmpty.class)) {
                    names.add(toSnakeCase(f.getName()));
                }
            }
        }
        return names;
    }

    /**
     * Mirrors Gson's {@link com.google.gson.FieldNamingPolicy#LOWER_CASE_WITH_UNDERSCORES}:
     * inserts an underscore before each interior upper-case letter, then lower-cases.
     */
    private static String toSnakeCase(String name) {
        StringBuilder sb = new StringBuilder(name.length() + 4);
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (Character.isUpperCase(ch) && sb.length() > 0) {
                sb.append('_');
            }
            sb.append(ch);
        }
        return sb.toString().toLowerCase(Locale.ENGLISH);
    }

    /** Empty in Go's {@code omitempty} sense: null, empty string, empty array or empty object. */
    private static boolean isEmpty(JsonElement element) {
        if (element.isJsonNull()) {
            return true;
        }
        if (element.isJsonArray()) {
            return ((JsonArray) element).size() == 0;
        }
        if (element.isJsonObject()) {
            return ((JsonObject) element).size() == 0;
        }
        if (element.isJsonPrimitive()) {
            JsonPrimitive primitive = element.getAsJsonPrimitive();
            return primitive.isString() && primitive.getAsString().isEmpty();
        }
        return false;
    }
}
