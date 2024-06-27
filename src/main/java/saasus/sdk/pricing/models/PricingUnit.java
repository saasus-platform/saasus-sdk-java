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
import saasus.sdk.pricing.models.PricingFixedUnit;
import saasus.sdk.pricing.models.PricingTier;
import saasus.sdk.pricing.models.PricingTieredUnit;
import saasus.sdk.pricing.models.PricingTieredUsageUnit;
import saasus.sdk.pricing.models.PricingUsageUnit;
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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-27T08:48:33.533245744Z[Etc/UTC]")
public class PricingUnit extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(PricingUnit.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!PricingUnit.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'PricingUnit' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<PricingTieredUsageUnit> adapterPricingTieredUsageUnit = gson.getDelegateAdapter(this, TypeToken.get(PricingTieredUsageUnit.class));
            final TypeAdapter<PricingTieredUnit> adapterPricingTieredUnit = gson.getDelegateAdapter(this, TypeToken.get(PricingTieredUnit.class));
            final TypeAdapter<PricingUsageUnit> adapterPricingUsageUnit = gson.getDelegateAdapter(this, TypeToken.get(PricingUsageUnit.class));
            final TypeAdapter<PricingFixedUnit> adapterPricingFixedUnit = gson.getDelegateAdapter(this, TypeToken.get(PricingFixedUnit.class));

            return (TypeAdapter<T>) new TypeAdapter<PricingUnit>() {
                @Override
                public void write(JsonWriter out, PricingUnit value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `PricingTieredUsageUnit`
                    if (value.getActualInstance() instanceof PricingTieredUsageUnit) {
                      JsonElement element = adapterPricingTieredUsageUnit.toJsonTree((PricingTieredUsageUnit)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    // check if the actual instance is of the type `PricingTieredUnit`
                    if (value.getActualInstance() instanceof PricingTieredUnit) {
                      JsonElement element = adapterPricingTieredUnit.toJsonTree((PricingTieredUnit)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    // check if the actual instance is of the type `PricingUsageUnit`
                    if (value.getActualInstance() instanceof PricingUsageUnit) {
                      JsonElement element = adapterPricingUsageUnit.toJsonTree((PricingUsageUnit)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    // check if the actual instance is of the type `PricingFixedUnit`
                    if (value.getActualInstance() instanceof PricingFixedUnit) {
                      JsonElement element = adapterPricingFixedUnit.toJsonTree((PricingFixedUnit)value.getActualInstance());
                      elementAdapter.write(out, element);
                      return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: PricingFixedUnit, PricingTieredUnit, PricingTieredUsageUnit, PricingUsageUnit");
                }

                @Override
                public PricingUnit read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    JsonObject jsonObject = jsonElement.getAsJsonObject();

                    // use discriminator value for faster oneOf lookup
                    PricingUnit newPricingUnit = new PricingUnit();
                    if (jsonObject.get("type") == null) {
                        log.log(Level.WARNING, "Failed to lookup discriminator value for PricingUnit as `type` was not found in the payload or the payload is empty.");
                    } else  {
                        // look up the discriminator value in the field `type`
                        switch (jsonObject.get("type").getAsString()) {
                            case "fixed":
                                deserialized = adapterPricingFixedUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            case "tiered":
                                deserialized = adapterPricingTieredUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            case "tiered_usage":
                                deserialized = adapterPricingTieredUsageUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            case "usage":
                                deserialized = adapterPricingUsageUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            case "PricingFixedUnit":
                                deserialized = adapterPricingFixedUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            case "PricingTieredUnit":
                                deserialized = adapterPricingTieredUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            case "PricingTieredUsageUnit":
                                deserialized = adapterPricingTieredUsageUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            case "PricingUsageUnit":
                                deserialized = adapterPricingUsageUnit.fromJsonTree(jsonObject);
                                newPricingUnit.setActualInstance(deserialized);
                                return newPricingUnit;
                            default:
                                log.log(Level.WARNING, String.format("Failed to lookup discriminator value `%s` for PricingUnit. Possible values: fixed tiered tiered_usage usage PricingFixedUnit PricingTieredUnit PricingTieredUsageUnit PricingUsageUnit", jsonObject.get("type").getAsString()));
                        }
                    }

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize PricingTieredUsageUnit
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingTieredUsageUnit.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingTieredUsageUnit;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingTieredUsageUnit'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingTieredUsageUnit failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingTieredUsageUnit'", e);
                    }
                    // deserialize PricingTieredUnit
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingTieredUnit.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingTieredUnit;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingTieredUnit'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingTieredUnit failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingTieredUnit'", e);
                    }
                    // deserialize PricingUsageUnit
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingUsageUnit.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingUsageUnit;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingUsageUnit'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingUsageUnit failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingUsageUnit'", e);
                    }
                    // deserialize PricingFixedUnit
                    try {
                      // validate the JSON object to see if any exception is thrown
                      PricingFixedUnit.validateJsonElement(jsonElement);
                      actualAdapter = adapterPricingFixedUnit;
                      match++;
                      log.log(Level.FINER, "Input data matches schema 'PricingFixedUnit'");
                    } catch (Exception e) {
                      // deserialization failed, continue
                      errorMessages.add(String.format("Deserialization for PricingFixedUnit failed with `%s`.", e.getMessage()));
                      log.log(Level.FINER, "Input data does not match schema 'PricingFixedUnit'", e);
                    }

                    if (match == 1) {
                        PricingUnit ret = new PricingUnit();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for PricingUnit: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public PricingUnit() {
        super("oneOf", Boolean.FALSE);
    }

    public PricingUnit(PricingFixedUnit o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PricingUnit(PricingTieredUnit o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PricingUnit(PricingTieredUsageUnit o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public PricingUnit(PricingUsageUnit o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("PricingTieredUsageUnit", PricingTieredUsageUnit.class);
        schemas.put("PricingTieredUnit", PricingTieredUnit.class);
        schemas.put("PricingUsageUnit", PricingUsageUnit.class);
        schemas.put("PricingFixedUnit", PricingFixedUnit.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return PricingUnit.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * PricingFixedUnit, PricingTieredUnit, PricingTieredUsageUnit, PricingUsageUnit
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof PricingTieredUsageUnit) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof PricingTieredUnit) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof PricingUsageUnit) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof PricingFixedUnit) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be PricingFixedUnit, PricingTieredUnit, PricingTieredUsageUnit, PricingUsageUnit");
    }

    /**
     * Get the actual instance, which can be the following:
     * PricingFixedUnit, PricingTieredUnit, PricingTieredUsageUnit, PricingUsageUnit
     *
     * @return The actual instance (PricingFixedUnit, PricingTieredUnit, PricingTieredUsageUnit, PricingUsageUnit)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `PricingTieredUsageUnit`. If the actual instance is not `PricingTieredUsageUnit`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingTieredUsageUnit`
     * @throws ClassCastException if the instance is not `PricingTieredUsageUnit`
     */
    public PricingTieredUsageUnit getPricingTieredUsageUnit() throws ClassCastException {
        return (PricingTieredUsageUnit)super.getActualInstance();
    }
    /**
     * Get the actual instance of `PricingTieredUnit`. If the actual instance is not `PricingTieredUnit`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingTieredUnit`
     * @throws ClassCastException if the instance is not `PricingTieredUnit`
     */
    public PricingTieredUnit getPricingTieredUnit() throws ClassCastException {
        return (PricingTieredUnit)super.getActualInstance();
    }
    /**
     * Get the actual instance of `PricingUsageUnit`. If the actual instance is not `PricingUsageUnit`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingUsageUnit`
     * @throws ClassCastException if the instance is not `PricingUsageUnit`
     */
    public PricingUsageUnit getPricingUsageUnit() throws ClassCastException {
        return (PricingUsageUnit)super.getActualInstance();
    }
    /**
     * Get the actual instance of `PricingFixedUnit`. If the actual instance is not `PricingFixedUnit`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PricingFixedUnit`
     * @throws ClassCastException if the instance is not `PricingFixedUnit`
     */
    public PricingFixedUnit getPricingFixedUnit() throws ClassCastException {
        return (PricingFixedUnit)super.getActualInstance();
    }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingUnit
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    // validate oneOf schemas one by one
    int validCount = 0;
    ArrayList<String> errorMessages = new ArrayList<>();
    // validate the json string with PricingTieredUsageUnit
    try {
      PricingTieredUsageUnit.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingTieredUsageUnit failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    // validate the json string with PricingTieredUnit
    try {
      PricingTieredUnit.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingTieredUnit failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    // validate the json string with PricingUsageUnit
    try {
      PricingUsageUnit.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingUsageUnit failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    // validate the json string with PricingFixedUnit
    try {
      PricingFixedUnit.validateJsonElement(jsonElement);
      validCount++;
    } catch (Exception e) {
      errorMessages.add(String.format("Deserialization for PricingFixedUnit failed with `%s`.", e.getMessage()));
      // continue to the next one
    }
    if (validCount != 1) {
      throw new IOException(String.format("The JSON string is invalid for PricingUnit with oneOf schemas: PricingFixedUnit, PricingTieredUnit, PricingTieredUsageUnit, PricingUsageUnit. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
    }
  }

 /**
  * Create an instance of PricingUnit given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingUnit
  * @throws IOException if the JSON string is invalid with respect to PricingUnit
  */
  public static PricingUnit fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingUnit.class);
  }

 /**
  * Convert an instance of PricingUnit to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

