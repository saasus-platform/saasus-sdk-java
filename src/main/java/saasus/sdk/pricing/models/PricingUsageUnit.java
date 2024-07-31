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
import java.util.Arrays;
import saasus.sdk.pricing.models.AggregateUsage;
import saasus.sdk.pricing.models.Currency;
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
 * PricingUsageUnit
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-18T06:15:46.013551151Z[Etc/UTC]")
public class PricingUsageUnit {
  public static final String SERIALIZED_NAME_UPPER_COUNT = "upper_count";
  @SerializedName(SERIALIZED_NAME_UPPER_COUNT)
  private Integer upperCount;

  public static final String SERIALIZED_NAME_UNIT_AMOUNT = "unit_amount";
  @SerializedName(SERIALIZED_NAME_UNIT_AMOUNT)
  private Integer unitAmount;

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

  public PricingUsageUnit() {
  }

  public PricingUsageUnit upperCount(Integer upperCount) {
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


  public PricingUsageUnit unitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
    return this;
  }

   /**
   * Amount per usage
   * @return unitAmount
  **/
  @javax.annotation.Nonnull
  public Integer getUnitAmount() {
    return unitAmount;
  }

  public void setUnitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
  }


  public PricingUsageUnit meteringUnitName(String meteringUnitName) {
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


  public PricingUsageUnit aggregateUsage(AggregateUsage aggregateUsage) {
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


  public PricingUsageUnit name(String name) {
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


  public PricingUsageUnit displayName(String displayName) {
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


  public PricingUsageUnit description(String description) {
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


  public PricingUsageUnit type(UnitType type) {
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


  public PricingUsageUnit currency(Currency currency) {
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


  public PricingUsageUnit id(String id) {
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


  public PricingUsageUnit meteringUnitId(String meteringUnitId) {
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


  public PricingUsageUnit recurringInterval(RecurringInterval recurringInterval) {
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


  public PricingUsageUnit used(Boolean used) {
    this.used = used;
    return this;
  }

   /**
   * Get used
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
    PricingUsageUnit pricingUsageUnit = (PricingUsageUnit) o;
    return Objects.equals(this.upperCount, pricingUsageUnit.upperCount) &&
        Objects.equals(this.unitAmount, pricingUsageUnit.unitAmount) &&
        Objects.equals(this.meteringUnitName, pricingUsageUnit.meteringUnitName) &&
        Objects.equals(this.aggregateUsage, pricingUsageUnit.aggregateUsage) &&
        Objects.equals(this.name, pricingUsageUnit.name) &&
        Objects.equals(this.displayName, pricingUsageUnit.displayName) &&
        Objects.equals(this.description, pricingUsageUnit.description) &&
        Objects.equals(this.type, pricingUsageUnit.type) &&
        Objects.equals(this.currency, pricingUsageUnit.currency) &&
        Objects.equals(this.id, pricingUsageUnit.id) &&
        Objects.equals(this.meteringUnitId, pricingUsageUnit.meteringUnitId) &&
        Objects.equals(this.recurringInterval, pricingUsageUnit.recurringInterval) &&
        Objects.equals(this.used, pricingUsageUnit.used);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upperCount, unitAmount, meteringUnitName, aggregateUsage, name, displayName, description, type, currency, id, meteringUnitId, recurringInterval, used);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingUsageUnit {\n");
    sb.append("    upperCount: ").append(toIndentedString(upperCount)).append("\n");
    sb.append("    unitAmount: ").append(toIndentedString(unitAmount)).append("\n");
    sb.append("    meteringUnitName: ").append(toIndentedString(meteringUnitName)).append("\n");
    sb.append("    aggregateUsage: ").append(toIndentedString(aggregateUsage)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
    openapiFields.add("unit_amount");
    openapiFields.add("metering_unit_name");
    openapiFields.add("aggregate_usage");
    openapiFields.add("name");
    openapiFields.add("display_name");
    openapiFields.add("description");
    openapiFields.add("type");
    openapiFields.add("currency");
    openapiFields.add("id");
    openapiFields.add("metering_unit_id");
    openapiFields.add("recurring_interval");
    openapiFields.add("used");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("upper_count");
    openapiRequiredFields.add("unit_amount");
    openapiRequiredFields.add("metering_unit_name");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("display_name");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("metering_unit_id");
    openapiRequiredFields.add("recurring_interval");
    openapiRequiredFields.add("used");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingUsageUnit
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PricingUsageUnit.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PricingUsageUnit is not found in the empty JSON string", PricingUsageUnit.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PricingUsageUnit.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PricingUsageUnit` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PricingUsageUnit.openapiRequiredFields) {
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
       if (!PricingUsageUnit.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PricingUsageUnit' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PricingUsageUnit> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PricingUsageUnit.class));

       return (TypeAdapter<T>) new TypeAdapter<PricingUsageUnit>() {
           @Override
           public void write(JsonWriter out, PricingUsageUnit value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PricingUsageUnit read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PricingUsageUnit given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingUsageUnit
  * @throws IOException if the JSON string is invalid with respect to PricingUsageUnit
  */
  public static PricingUsageUnit fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingUsageUnit.class);
  }

 /**
  * Convert an instance of PricingUsageUnit to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

