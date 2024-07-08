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
 * PricingFixedUnit
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-08T02:49:01.459005724Z[Etc/UTC]")
public class PricingFixedUnit {
  public static final String SERIALIZED_NAME_UNIT_AMOUNT = "unit_amount";
  @SerializedName(SERIALIZED_NAME_UNIT_AMOUNT)
  private Integer unitAmount;

  public static final String SERIALIZED_NAME_RECURRING_INTERVAL = "recurring_interval";
  @SerializedName(SERIALIZED_NAME_RECURRING_INTERVAL)
  private RecurringInterval recurringInterval;

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

  public static final String SERIALIZED_NAME_USED = "used";
  @SerializedName(SERIALIZED_NAME_USED)
  private Boolean used;

  public PricingFixedUnit() {
  }

  public PricingFixedUnit unitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
    return this;
  }

   /**
   * Price
   * @return unitAmount
  **/
  @javax.annotation.Nonnull
  public Integer getUnitAmount() {
    return unitAmount;
  }

  public void setUnitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
  }


  public PricingFixedUnit recurringInterval(RecurringInterval recurringInterval) {
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


  public PricingFixedUnit name(String name) {
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


  public PricingFixedUnit displayName(String displayName) {
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


  public PricingFixedUnit description(String description) {
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


  public PricingFixedUnit type(UnitType type) {
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


  public PricingFixedUnit currency(Currency currency) {
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


  public PricingFixedUnit id(String id) {
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


  public PricingFixedUnit used(Boolean used) {
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
    PricingFixedUnit pricingFixedUnit = (PricingFixedUnit) o;
    return Objects.equals(this.unitAmount, pricingFixedUnit.unitAmount) &&
        Objects.equals(this.recurringInterval, pricingFixedUnit.recurringInterval) &&
        Objects.equals(this.name, pricingFixedUnit.name) &&
        Objects.equals(this.displayName, pricingFixedUnit.displayName) &&
        Objects.equals(this.description, pricingFixedUnit.description) &&
        Objects.equals(this.type, pricingFixedUnit.type) &&
        Objects.equals(this.currency, pricingFixedUnit.currency) &&
        Objects.equals(this.id, pricingFixedUnit.id) &&
        Objects.equals(this.used, pricingFixedUnit.used);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unitAmount, recurringInterval, name, displayName, description, type, currency, id, used);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingFixedUnit {\n");
    sb.append("    unitAmount: ").append(toIndentedString(unitAmount)).append("\n");
    sb.append("    recurringInterval: ").append(toIndentedString(recurringInterval)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
    openapiFields.add("unit_amount");
    openapiFields.add("recurring_interval");
    openapiFields.add("name");
    openapiFields.add("display_name");
    openapiFields.add("description");
    openapiFields.add("type");
    openapiFields.add("currency");
    openapiFields.add("id");
    openapiFields.add("used");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("unit_amount");
    openapiRequiredFields.add("recurring_interval");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("display_name");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("currency");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("used");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingFixedUnit
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PricingFixedUnit.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PricingFixedUnit is not found in the empty JSON string", PricingFixedUnit.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PricingFixedUnit.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PricingFixedUnit` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PricingFixedUnit.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `recurring_interval`
      RecurringInterval.validateJsonElement(jsonObj.get("recurring_interval"));
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
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PricingFixedUnit.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PricingFixedUnit' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PricingFixedUnit> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PricingFixedUnit.class));

       return (TypeAdapter<T>) new TypeAdapter<PricingFixedUnit>() {
           @Override
           public void write(JsonWriter out, PricingFixedUnit value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PricingFixedUnit read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PricingFixedUnit given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingFixedUnit
  * @throws IOException if the JSON string is invalid with respect to PricingFixedUnit
  */
  public static PricingFixedUnit fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingFixedUnit.class);
  }

 /**
  * Convert an instance of PricingFixedUnit to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

