/*
 * SaaSus Pricing API Schema
 * SaaSus Pricing API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.pricing.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import saasus.sdk.pricing.models.AggregateUsage;
import saasus.sdk.pricing.models.Currency;
import saasus.sdk.pricing.models.PricingFixedUnitForSave;
import saasus.sdk.pricing.models.PricingTier;
import saasus.sdk.pricing.models.PricingTieredUnitForSave;
import saasus.sdk.pricing.models.PricingTieredUsageUnitForSave;
import saasus.sdk.pricing.models.PricingUsageUnitForSave;
import saasus.sdk.pricing.models.RecurringInterval;
import saasus.sdk.pricing.models.UnitType;



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

import saasus.sdk.pricing.JSON;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-14T06:45:57.727429184Z[Etc/UTC]")
public class PricingUnitForSave extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PricingUnitForSave.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!PricingUnitForSave.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'PricingUnitForSave' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<PricingTieredUsageUnitForSave> adapterPricingTieredUsageUnitForSave = gson.getDelegateAdapter(this, TypeToken.get(PricingTieredUsageUnitForSave.class));
            final TypeAdapter<PricingTieredUnitForSave> adapterPricingTieredUnitForSave = gson.getDelegateAdapter(this, TypeToken.get(PricingTieredUnitForSave.class));
            final TypeAdapter<PricingUsageUnitForSave> adapterPricingUsageUnitForSave = gson.getDelegateAdapter(this, TypeToken.get(PricingUsageUnitForSave.class));
            final TypeAdapter<PricingFixedUnitForSave> adapterPricingFixedUnitForSave = gson.getDelegateAdapter(this, TypeToken.get(PricingFixedUnitForSave.class));

            return (TypeAdapter<T>) new TypeAdapter<PricingUnitForSave>() {
                @Override
                public void write(JsonWriter out, PricingUnitForSave value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `PricingTieredUsageUnitForSave`
                    if (value.getActualInstance() instanceof PricingTieredUsageUnitForSave) {
                      JsonElement element = adapterPricingTieredUsageUnitForSave.toJsonTree((PricingTieredUsageUnitForSave)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    // check if the actual instance is of the type `PricingTieredUnitForSave`
                    if (value.getActualInstance() instanceof PricingTieredUnitForSave) {
                      JsonElement element = adapterPricingTieredUnitForSave.toJsonTree((PricingTieredUnitForSave)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    // check if the actual instance is of the type `PricingUsageUnitForSave`
                    if (value.getActualInstance() instanceof PricingUsageUnitForSave) {
                      JsonElement element = adapterPricingUsageUnitForSave.toJsonTree((PricingUsageUnitForSave)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    // check if the actual instance is of the type `PricingFixedUnitForSave`
                    if (value.getActualInstance() instanceof PricingFixedUnitForSave) {
                      JsonElement element = adapterPricingFixedUnitForSave.toJsonTree((PricingFixedUnitForSave)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: PricingFixedUnitForSave, PricingTieredUnitForSave, PricingTieredUsageUnitForSave, PricingUsageUnitForSave");
                }

                @Override
                public PricingUnitForSave read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize PricingTieredUsageUnitForSave
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingTieredUsageUnitForSave.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingTieredUsageUnitForSave;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingTieredUsageUnitForSave'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingTieredUsageUnitForSave failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingTieredUsageUnitForSave'", e);
                    }
                    // deserialize PricingTieredUnitForSave
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingTieredUnitForSave.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingTieredUnitForSave;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingTieredUnitForSave'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingTieredUnitForSave failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingTieredUnitForSave'", e);
                    }
                    // deserialize PricingUsageUnitForSave
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingUsageUnitForSave.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingUsageUnitForSave;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingUsageUnitForSave'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingUsageUnitForSave failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingUsageUnitForSave'", e);
                    }
                    // deserialize PricingFixedUnitForSave
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingFixedUnitForSave.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingFixedUnitForSave;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingFixedUnitForSave'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingFixedUnitForSave failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingFixedUnitForSave'", e);
                    }

                    if (match == 1) {
                        PricingUnitForSave ret = new PricingUnitForSave();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for PricingUnitForSave: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PricingUnitForSave() {
        super("oneOf", Boolean.FALSE);
    }

    public PricingUnitForSave(PricingFixedUnitForSave o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PricingUnitForSave(PricingTieredUnitForSave o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PricingUnitForSave(PricingTieredUsageUnitForSave o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PricingUnitForSave(PricingUsageUnitForSave o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("PricingTieredUsageUnitForSave", PricingTieredUsageUnitForSave.class);
        schemas.put("PricingTieredUnitForSave", PricingTieredUnitForSave.class);
        schemas.put("PricingUsageUnitForSave", PricingUsageUnitForSave.class);
        schemas.put("PricingFixedUnitForSave", PricingFixedUnitForSave.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PricingUnitForSave.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * PricingFixedUnitForSave, PricingTieredUnitForSave, PricingTieredUsageUnitForSave, PricingUsageUnitForSave
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof PricingTieredUsageUnitForSave) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof PricingTieredUnitForSave) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof PricingUsageUnitForSave) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof PricingFixedUnitForSave) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be PricingFixedUnitForSave, PricingTieredUnitForSave, PricingTieredUsageUnitForSave, PricingUsageUnitForSave");
    }

    /**
     * Get the actual instance, which can be the following:
     * PricingFixedUnitForSave, PricingTieredUnitForSave, PricingTieredUsageUnitForSave, PricingUsageUnitForSave
     *
     * @return The actual instance (PricingFixedUnitForSave, PricingTieredUnitForSave, PricingTieredUsageUnitForSave, PricingUsageUnitForSave)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `PricingTieredUsageUnitForSave`. If the actual instance is not `PricingTieredUsageUnitForSave`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingTieredUsageUnitForSave`
     * @throws ClassCastException if the instance is not `PricingTieredUsageUnitForSave`
     */
    public PricingTieredUsageUnitForSave getPricingTieredUsageUnitForSave() throws ClassCastException {
        return (PricingTieredUsageUnitForSave)super.getActualInstance();
    }
    /**
     * Get the actual instance of `PricingTieredUnitForSave`. If the actual instance is not `PricingTieredUnitForSave`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingTieredUnitForSave`
     * @throws ClassCastException if the instance is not `PricingTieredUnitForSave`
     */
    public PricingTieredUnitForSave getPricingTieredUnitForSave() throws ClassCastException {
        return (PricingTieredUnitForSave)super.getActualInstance();
    }
    /**
     * Get the actual instance of `PricingUsageUnitForSave`. If the actual instance is not `PricingUsageUnitForSave`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingUsageUnitForSave`
     * @throws ClassCastException if the instance is not `PricingUsageUnitForSave`
     */
    public PricingUsageUnitForSave getPricingUsageUnitForSave() throws ClassCastException {
        return (PricingUsageUnitForSave)super.getActualInstance();
    }
    /**
     * Get the actual instance of `PricingFixedUnitForSave`. If the actual instance is not `PricingFixedUnitForSave`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingFixedUnitForSave`
     * @throws ClassCastException if the instance is not `PricingFixedUnitForSave`
     */
    public PricingFixedUnitForSave getPricingFixedUnitForSave() throws ClassCastException {
        return (PricingFixedUnitForSave)super.getActualInstance();
    }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingUnitForSave
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    // validate oneOf schemas one by one
    int validCount = 0;
    ArrayList<String> errorMessages = new ArrayList<>();
    // validate the json string with PricingTieredUsageUnitForSave
    try {
      PricingTieredUsageUnitForSave.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingTieredUsageUnitForSave failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    // validate the json string with PricingTieredUnitForSave
    try {
      PricingTieredUnitForSave.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingTieredUnitForSave failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    // validate the json string with PricingUsageUnitForSave
    try {
      PricingUsageUnitForSave.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingUsageUnitForSave failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    // validate the json string with PricingFixedUnitForSave
    try {
      PricingFixedUnitForSave.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingFixedUnitForSave failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    if (validCount != 1) {
      throw new IOException(String.format("The JSON string is invalid for PricingUnitForSave with oneOf schemas: PricingFixedUnitForSave, PricingTieredUnitForSave, PricingTieredUsageUnitForSave, PricingUsageUnitForSave. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
    }
  }

 /**
  * Create an instance of PricingUnitForSave given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingUnitForSave
  * @throws IOException if the JSON string is invalid with respect to PricingUnitForSave
  */
  public static PricingUnitForSave fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingUnitForSave.class);
  }

 /**
  * Convert an instance of PricingUnitForSave to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

