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
 * PricingTieredUsageUnitForSave
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-07T10:06:29.421993530Z[Etc/UTC]")
public class PricingTieredUsageUnitForSave {
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

  public static final String SERIALIZED_NAME_UPPER_COUNT = "upper_count";
  @SerializedName(SERIALIZED_NAME_UPPER_COUNT)
  private Integer upperCount;

  public static final String SERIALIZED_NAME_METERING_UNIT_NAME = "metering_unit_name";
  @SerializedName(SERIALIZED_NAME_METERING_UNIT_NAME)
  private String meteringUnitName;

  public static final String SERIALIZED_NAME_AGGREGATE_USAGE = "aggregate_usage";
  @SerializedName(SERIALIZED_NAME_AGGREGATE_USAGE)
  private AggregateUsage aggregateUsage;

  public PricingTieredUsageUnitForSave() {
  }

  public PricingTieredUsageUnitForSave name(String name) {
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


  public PricingTieredUsageUnitForSave displayName(String displayName) {
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


  public PricingTieredUsageUnitForSave description(String description) {
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


  public PricingTieredUsageUnitForSave type(UnitType type) {
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


  public PricingTieredUsageUnitForSave currency(Currency currency) {
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


  public PricingTieredUsageUnitForSave tiers(List<PricingTier> tiers) {
    this.tiers = tiers;
    return this;
  }

  public PricingTieredUsageUnitForSave addTiersItem(PricingTier tiersItem) {
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


  public PricingTieredUsageUnitForSave upperCount(Integer upperCount) {
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


  public PricingTieredUsageUnitForSave meteringUnitName(String meteringUnitName) {
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


  public PricingTieredUsageUnitForSave aggregateUsage(AggregateUsage aggregateUsage) {
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricingTieredUsageUnitForSave pricingTieredUsageUnitForSave = (PricingTieredUsageUnitForSave) o;
    return Objects.equals(this.name, pricingTieredUsageUnitForSave.name) &&
        Objects.equals(this.displayName, pricingTieredUsageUnitForSave.displayName) &&
        Objects.equals(this.description, pricingTieredUsageUnitForSave.description) &&
        Objects.equals(this.type, pricingTieredUsageUnitForSave.type) &&
        Objects.equals(this.currency, pricingTieredUsageUnitForSave.currency) &&
        Objects.equals(this.tiers, pricingTieredUsageUnitForSave.tiers) &&
        Objects.equals(this.upperCount, pricingTieredUsageUnitForSave.upperCount) &&
        Objects.equals(this.meteringUnitName, pricingTieredUsageUnitForSave.meteringUnitName) &&
        Objects.equals(this.aggregateUsage, pricingTieredUsageUnitForSave.aggregateUsage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, displayName, description, type, currency, tiers, upperCount, meteringUnitName, aggregateUsage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingTieredUsageUnitForSave {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
    sb.append("    upperCount: ").append(toIndentedString(upperCount)).append("\n");
    sb.append("    meteringUnitName: ").append(toIndentedString(meteringUnitName)).append("\n");
    sb.append("    aggregateUsage: ").append(toIndentedString(aggregateUsage)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("display_name");
    openapiFields.add("description");
    openapiFields.add("type");
    openapiFields.add("currency");
    openapiFields.add("tiers");
    openapiFields.add("upper_count");
    openapiFields.add("metering_unit_name");
    openapiFields.add("aggregate_usage");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("display_name");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("tiers");
    openapiRequiredFields.add("upper_count");
    openapiRequiredFields.add("metering_unit_name");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingTieredUsageUnitForSave
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PricingTieredUsageUnitForSave.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PricingTieredUsageUnitForSave is not found in the empty JSON string", PricingTieredUsageUnitForSave.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PricingTieredUsageUnitForSave.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PricingTieredUsageUnitForSave` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PricingTieredUsageUnitForSave.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
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
      if (!jsonObj.get("metering_unit_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `metering_unit_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("metering_unit_name").toString()));
      }
      // validate the optional field `aggregate_usage`
      if (jsonObj.get("aggregate_usage") != null && !jsonObj.get("aggregate_usage").isJsonNull()) {
        AggregateUsage.validateJsonElement(jsonObj.get("aggregate_usage"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PricingTieredUsageUnitForSave.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PricingTieredUsageUnitForSave' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PricingTieredUsageUnitForSave> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PricingTieredUsageUnitForSave.class));

       return (TypeAdapter<T>) new TypeAdapter<PricingTieredUsageUnitForSave>() {
           @Override
           public void write(JsonWriter out, PricingTieredUsageUnitForSave value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PricingTieredUsageUnitForSave read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PricingTieredUsageUnitForSave given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingTieredUsageUnitForSave
  * @throws IOException if the JSON string is invalid with respect to PricingTieredUsageUnitForSave
  */
  public static PricingTieredUsageUnitForSave fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingTieredUsageUnitForSave.class);
  }

 /**
  * Convert an instance of PricingTieredUsageUnitForSave to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

