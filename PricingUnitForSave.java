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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-14T05:49:40.753989212Z[Etc/UTC]")
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

                    JsonObject jsonObject = jsonElement.getAsJsonObject();

                    // use discriminator value for faster oneOf lookup
                    PricingUnitForSave newPricingUnitForSave = new PricingUnitForSave();
                    if (jsonObject.get("type") == null) {
                        log.log(Level.WARNING, "Failed to lookup discriminator value for PricingUnitForSave as `type` was not found in the payload or the payload is empty.");
                    } else  {
                        // look up the discriminator value in the field `type`
                        switch (jsonObject.get("type").getAsString()) {
                            case "fixed":
                                deserialized = adapterPricingFixedUnitForSave.fromJsonTree(jsonObject);
                                newPricingUnitForSave.setActualInstance(deserialized);
                                return newPricingUnitForSave;
                            case "tiered":
                                deserialized = adapterPricingTieredUnitForSave.fromJsonTree(jsonObject);
                                newPricingUnitForSave.setActualInstance(deserialized);
                                return newPricingUnitForSave;
                            case "tiered_usage":
                                deserialized = adapterPricingTieredUsageUnitForSave.fromJsonTree(jsonObject);
                                newPricingUnitForSave.setActualInstance(deserialized);
                                return newPricingUnitForSave;
                            case "usage":
                                deserialized = adapterPricingUsageUnitForSave.fromJsonTree(jsonObject);
                                newPricingUnitForSave.setActualInstance(deserialized);
                                return newPricingUnitForSave;
                            default:
                                log.log(Level.WARNING, String.format("Failed to lookup discriminator value `%s` for PricingUnitForSave. Possible values: fixed tiered tiered_usage usage", jsonObject.get("type").getAsString()));
                        }
                    }

                    throw new IOException(String.format("JSON: %s", jsonElement.toString()));
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
    JsonObject jsonObject = jsonElement.getAsJsonObject();

    if (jsonObject.get("type") == null) {
        throw new IOException("Discriminator field `type` is missing");
    }

    String discriminatorValue = jsonObject.get("type").getAsString();
    switch (discriminatorValue) {
        case "fixed":
            PricingFixedUnitForSave.validateJsonElement(jsonElement);
            break;
        case "tiered":
            PricingTieredUnitForSave.validateJsonElement(jsonElement);
            break;
        case "tiered_usage":
            PricingTieredUsageUnitForSave.validateJsonElement(jsonElement);
            break;
        case "usage":
            PricingUsageUnitForSave.validateJsonElement(jsonElement);
            break;
        default:
            throw new IOException("Unknown discriminator value: " + discriminatorValue);
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

