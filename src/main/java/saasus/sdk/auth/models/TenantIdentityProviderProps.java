/*
 * SaaSus Auth API Schema
 * Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.auth.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import saasus.sdk.auth.models.IdentityProviderSaml;



import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;

import saasus.sdk.auth.JSON;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-25T16:36:00.014827280Z[Etc/UTC]")
public class TenantIdentityProviderProps extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(TenantIdentityProviderProps.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!TenantIdentityProviderProps.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'TenantIdentityProviderProps' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<IdentityProviderSaml> adapterIdentityProviderSaml = gson.getDelegateAdapter(this, TypeToken.get(IdentityProviderSaml.class));

            return (TypeAdapter<T>) new TypeAdapter<TenantIdentityProviderProps>() {
                @Override
                public void write(JsonWriter out, TenantIdentityProviderProps value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `IdentityProviderSaml`
                    if (value.getActualInstance() instanceof IdentityProviderSaml) {
                      JsonElement element = adapterIdentityProviderSaml.toJsonTree((IdentityProviderSaml)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: IdentityProviderSaml");
                }

                @Override
                public TenantIdentityProviderProps read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize IdentityProviderSaml
                    try {
                      // validate the JSON object to see if any exception is thrown
                      IdentityProviderSaml.validateJsonElement(jsonElement);
                      actualAdapter = adapterIdentityProviderSaml;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'IdentityProviderSaml'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for IdentityProviderSaml failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'IdentityProviderSaml'", e);
                    }

                    if (match == 1) {
                        TenantIdentityProviderProps ret = new TenantIdentityProviderProps();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for TenantIdentityProviderProps: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public TenantIdentityProviderProps() {
        super("oneOf", Boolean.FALSE);
    }

    public TenantIdentityProviderProps(IdentityProviderSaml o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("IdentityProviderSaml", IdentityProviderSaml.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return TenantIdentityProviderProps.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * IdentityProviderSaml
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof IdentityProviderSaml) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be IdentityProviderSaml");
    }

    /**
     * Get the actual instance, which can be the following:
     * IdentityProviderSaml
     *
     * @return The actual instance (IdentityProviderSaml)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `IdentityProviderSaml`. If the actual instance is not `IdentityProviderSaml`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `IdentityProviderSaml`
     * @throws ClassCastException if the instance is not `IdentityProviderSaml`
     */
    public IdentityProviderSaml getIdentityProviderSaml() throws ClassCastException {
        return (IdentityProviderSaml)super.getActualInstance();
    }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TenantIdentityProviderProps
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    // validate oneOf schemas one by one
    int validCount = 0;
    ArrayList<String> errorMessages = new ArrayList<>();
    // validate the json string with IdentityProviderSaml
    try {
      IdentityProviderSaml.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for IdentityProviderSaml failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    if (validCount != 1) {
      throw new IOException(String.format("The JSON string is invalid for TenantIdentityProviderProps with oneOf schemas: IdentityProviderSaml. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
    }
  }

 /**
  * Create an instance of TenantIdentityProviderProps given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TenantIdentityProviderProps
  * @throws IOException if the JSON string is invalid with respect to TenantIdentityProviderProps
  */
  public static TenantIdentityProviderProps fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TenantIdentityProviderProps.class);
  }

 /**
  * Convert an instance of TenantIdentityProviderProps to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

