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
import saasus.sdk.pricing.models.PricingTier;
import saasus.sdk.pricing.models.RecurringInterval;
import saasus.sdk.pricing.models.UnitType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import saasus.sdk.pricing.JSON;

/**
 * PricingTieredUsageUnit
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-14T09:09:28.364010647Z[Etc/UTC]")
public class PricingTieredUsageUnit {
  public static final String SERIALIZED_NAME_UPPER_COUNT = "upper_count";
  @SerializedName(SERIALIZED_NAME_UPPER_COUNT)
  private Integer upperCount;

  public static final String SERIALIZED_NAME_METERING_UNIT_NAME = "metering_unit_name";
  @SerializedName(SERIALIZED_NAME_METERING_UNIT_NAME)
  private String meteringUnitName;

  public static final String SERIALIZED_NAME_AGGREGATE_USAGE = "aggregate_usage";
  @SerializedName(SERIALIZED_NAME_AGGREGATE_USAGE)
  private AggregateUsage aggregateUsage;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private UnitType type;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private Currency currency;

  public static final String SERIALIZED_NAME_TIERS = "tiers";
  @SerializedName(SERIALIZED_NAME_TIERS)
  private List<PricingTier> tiers = new ArrayList<>();

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_METERING_UNIT_ID = "metering_unit_id";
  @SerializedName(SERIALIZED_NAME_METERING_UNIT_ID)
  private String meteringUnitId;

  public static final String SERIALIZED_NAME_RECURRING_INTERVAL = "recurring_interval";
  @SerializedName(SERIALIZED_NAME_RECURRING_INTERVAL)
  private RecurringInterval recurringInterval;

  public static final String SERIALIZED_NAME_USED = "used";
  @SerializedName(SERIALIZED_NAME_USED)
  private Boolean used;

  public PricingTieredUsageUnit() {
  }

  public PricingTieredUsageUnit upperCount(Integer upperCount) {
    this.upperCount = upperCount;
    return this;
  }

   /**
   * Upper limit
   * @return upperCount
  **/
  @javax.annotation.Nonnull
  public Integer getUpperCount() {
    return upperCount;
  }

  public void setUpperCount(Integer upperCount) {
    this.upperCount = upperCount;
  }


  public PricingTieredUsageUnit meteringUnitName(String meteringUnitName) {
    this.meteringUnitName = meteringUnitName;
    return this;
  }

   /**
   * Metering unit name
   * @return meteringUnitName
  **/
  @javax.annotation.Nonnull
  public String getMeteringUnitName() {
    return meteringUnitName;
  }

  public void setMeteringUnitName(String meteringUnitName) {
    this.meteringUnitName = meteringUnitName;
  }


  public PricingTieredUsageUnit aggregateUsage(AggregateUsage aggregateUsage) {
    this.aggregateUsage = aggregateUsage;
    return this;
  }

   /**
   * Get aggregateUsage
   * @return aggregateUsage
  **/
  @javax.annotation.Nullable
  public AggregateUsage getAggregateUsage() {
    return aggregateUsage;
  }

  public void setAggregateUsage(AggregateUsage aggregateUsage) {
    this.aggregateUsage = aggregateUsage;
  }


  public PricingTieredUsageUnit name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public PricingTieredUsageUnit displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Display Name
   * @return displayName
  **/
  @javax.annotation.Nonnull
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public PricingTieredUsageUnit description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description
   * @return description
  **/
  @javax.annotation.Nonnull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public PricingTieredUsageUnit type(UnitType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nonnull
  public UnitType getType() {
    return type;
  }

  public void setType(UnitType type) {
    this.type = type;
  }


  public PricingTieredUsageUnit currency(Currency currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @javax.annotation.Nonnull
  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }


  public PricingTieredUsageUnit tiers(List<PricingTier> tiers) {
    this.tiers = tiers;
    return this;
  }

  public PricingTieredUsageUnit addTiersItem(PricingTier tiersItem) {
    if (this.tiers == null) {
      this.tiers = new ArrayList<>();
    }
    this.tiers.add(tiersItem);
    return this;
  }

   /**
   * Get tiers
   * @return tiers
  **/
  @javax.annotation.Nonnull
  public List<PricingTier> getTiers() {
    return tiers;
  }

  public void setTiers(List<PricingTier> tiers) {
    this.tiers = tiers;
  }


  public PricingTieredUsageUnit id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Universally Unique Identifier
   * @return id
  **/
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public PricingTieredUsageUnit meteringUnitId(String meteringUnitId) {
    this.meteringUnitId = meteringUnitId;
    return this;
  }

   /**
   * Universally Unique Identifier
   * @return meteringUnitId
  **/
  @javax.annotation.Nonnull
  public String getMeteringUnitId() {
    return meteringUnitId;
  }

  public void setMeteringUnitId(String meteringUnitId) {
    this.meteringUnitId = meteringUnitId;
  }


  public PricingTieredUsageUnit recurringInterval(RecurringInterval recurringInterval) {
    this.recurringInterval = recurringInterval;
    return this;
  }

   /**
   * Get recurringInterval
   * @return recurringInterval
  **/
  @javax.annotation.Nonnull
  public RecurringInterval getRecurringInterval() {
    return recurringInterval;
  }

  public void setRecurringInterval(RecurringInterval recurringInterval) {
    this.recurringInterval = recurringInterval;
  }


  public PricingTieredUsageUnit used(Boolean used) {
    this.used = used;
    return this;
  }

   /**
   * Indicates if the unit is used
   * @return used
  **/
  @javax.annotation.Nonnull
  public Boolean getUsed() {
    return used;
  }

  public void setUsed(Boolean used) {
    this.used = used;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricingTieredUsageUnit pricingTieredUsageUnit = (PricingTieredUsageUnit) o;
    return Objects.equals(this.upperCount, pricingTieredUsageUnit.upperCount) &&
        Objects.equals(this.meteringUnitName, pricingTieredUsageUnit.meteringUnitName) &&
        Objects.equals(this.aggregateUsage, pricingTieredUsageUnit.aggregateUsage) &&
        Objects.equals(this.name, pricingTieredUsageUnit.name) &&
        Objects.equals(this.displayName, pricingTieredUsageUnit.displayName) &&
        Objects.equals(this.description, pricingTieredUsageUnit.description) &&
        Objects.equals(this.type, pricingTieredUsageUnit.type) &&
        Objects.equals(this.currency, pricingTieredUsageUnit.currency) &&
        Objects.equals(this.tiers, pricingTieredUsageUnit.tiers) &&
        Objects.equals(this.id, pricingTieredUsageUnit.id) &&
        Objects.equals(this.meteringUnitId, pricingTieredUsageUnit.meteringUnitId) &&
        Objects.equals(this.recurringInterval, pricingTieredUsageUnit.recurringInterval) &&
        Objects.equals(this.used, pricingTieredUsageUnit.used);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upperCount, meteringUnitName, aggregateUsage, name, displayName, description, type, currency, tiers, id, meteringUnitId, recurringInterval, used);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingTieredUsageUnit {\n");
    sb.append("    upperCount: ").append(toIndentedString(upperCount)).append("\n");
    sb.append("    meteringUnitName: ").append(toIndentedString(meteringUnitName)).append("\n");
    sb.append("    aggregateUsage: ").append(toIndentedString(aggregateUsage)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    meteringUnitId: ").append(toIndentedString(meteringUnitId)).append("\n");
    sb.append("    recurringInterval: ").append(toIndentedString(recurringInterval)).append("\n");
    sb.append("    used: ").append(toIndentedString(used)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("upper_count");
    openapiFields.add("metering_unit_name");
    openapiFields.add("aggregate_usage");
    openapiFields.add("name");
    openapiFields.add("display_name");
    openapiFields.add("description");
    openapiFields.add("type");
    openapiFields.add("currency");
    openapiFields.add("tiers");
    openapiFields.add("id");
    openapiFields.add("metering_unit_id");
    openapiFields.add("recurring_interval");
    openapiFields.add("used");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("upper_count");
    openapiRequiredFields.add("metering_unit_name");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("display_name");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("tiers");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("metering_unit_id");
    openapiRequiredFields.add("recurring_interval");
    openapiRequiredFields.add("used");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingTieredUsageUnit
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PricingTieredUsageUnit.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PricingTieredUsageUnit is not found in the empty JSON string", PricingTieredUsageUnit.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PricingTieredUsageUnit.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PricingTieredUsageUnit` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PricingTieredUsageUnit.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("metering_unit_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `metering_unit_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("metering_unit_name").toString()));
      }
      // validate the optional field `aggregate_usage`
      if (jsonObj.get("aggregate_usage") != null && !jsonObj.get("aggregate_usage").isJsonNull()) {
        AggregateUsage.validateJsonElement(jsonObj.get("aggregate_usage"));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (!jsonObj.get("display_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display_name").toString()));
      }
      if (!jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      // validate the required field `type`
      UnitType.validateJsonElement(jsonObj.get("type"));
      // validate the required field `currency`
      Currency.validateJsonElement(jsonObj.get("currency"));
      // ensure the json data is an array
      if (!jsonObj.get("tiers").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `tiers` to be an array in the JSON string but got `%s`", jsonObj.get("tiers").toString()));
      }

      JsonArray jsonArraytiers = jsonObj.getAsJsonArray("tiers");
      // validate the required field `tiers` (array)
      for (int i = 0; i < jsonArraytiers.size(); i++) {
        PricingTier.validateJsonElement(jsonArraytiers.get(i));
      };
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("metering_unit_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `metering_unit_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("metering_unit_id").toString()));
      }
      // validate the required field `recurring_interval`
      RecurringInterval.validateJsonElement(jsonObj.get("recurring_interval"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PricingTieredUsageUnit.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PricingTieredUsageUnit' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PricingTieredUsageUnit> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PricingTieredUsageUnit.class));

       return (TypeAdapter<T>) new TypeAdapter<PricingTieredUsageUnit>() {
           @Override
           public void write(JsonWriter out, PricingTieredUsageUnit value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PricingTieredUsageUnit read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PricingTieredUsageUnit given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingTieredUsageUnit
  * @throws IOException if the JSON string is invalid with respect to PricingTieredUsageUnit
  */
  public static PricingTieredUsageUnit fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingTieredUsageUnit.class);
  }

 /**
  * Convert an instance of PricingTieredUsageUnit to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

