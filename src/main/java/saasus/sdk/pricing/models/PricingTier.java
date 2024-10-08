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
 * PricingTier
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:09:27.364679080Z[Etc/UTC]")
public class PricingTier {
  public static final String SERIALIZED_NAME_UP_TO = "up_to";
  @SerializedName(SERIALIZED_NAME_UP_TO)
  private Integer upTo;

  public static final String SERIALIZED_NAME_UNIT_AMOUNT = "unit_amount";
  @SerializedName(SERIALIZED_NAME_UNIT_AMOUNT)
  private Integer unitAmount;

  public static final String SERIALIZED_NAME_FLAT_AMOUNT = "flat_amount";
  @SerializedName(SERIALIZED_NAME_FLAT_AMOUNT)
  private Integer flatAmount;

  public static final String SERIALIZED_NAME_INF = "inf";
  @SerializedName(SERIALIZED_NAME_INF)
  private Boolean inf;

  public PricingTier() {
  }

  public PricingTier upTo(Integer upTo) {
    this.upTo = upTo;
    return this;
  }

   /**
   * Upper limit
   * @return upTo
  **/
  @javax.annotation.Nonnull
  public Integer getUpTo() {
    return upTo;
  }

  public void setUpTo(Integer upTo) {
    this.upTo = upTo;
  }


  public PricingTier unitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
    return this;
  }

   /**
   * Amount per unit
   * @return unitAmount
  **/
  @javax.annotation.Nonnull
  public Integer getUnitAmount() {
    return unitAmount;
  }

  public void setUnitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
  }


  public PricingTier flatAmount(Integer flatAmount) {
    this.flatAmount = flatAmount;
    return this;
  }

   /**
   * Fixed amount
   * @return flatAmount
  **/
  @javax.annotation.Nonnull
  public Integer getFlatAmount() {
    return flatAmount;
  }

  public void setFlatAmount(Integer flatAmount) {
    this.flatAmount = flatAmount;
  }


  public PricingTier inf(Boolean inf) {
    this.inf = inf;
    return this;
  }

   /**
   * Indefinite
   * @return inf
  **/
  @javax.annotation.Nonnull
  public Boolean getInf() {
    return inf;
  }

  public void setInf(Boolean inf) {
    this.inf = inf;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricingTier pricingTier = (PricingTier) o;
    return Objects.equals(this.upTo, pricingTier.upTo) &&
        Objects.equals(this.unitAmount, pricingTier.unitAmount) &&
        Objects.equals(this.flatAmount, pricingTier.flatAmount) &&
        Objects.equals(this.inf, pricingTier.inf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upTo, unitAmount, flatAmount, inf);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingTier {\n");
    sb.append("    upTo: ").append(toIndentedString(upTo)).append("\n");
    sb.append("    unitAmount: ").append(toIndentedString(unitAmount)).append("\n");
    sb.append("    flatAmount: ").append(toIndentedString(flatAmount)).append("\n");
    sb.append("    inf: ").append(toIndentedString(inf)).append("\n");
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
    openapiFields.add("up_to");
    openapiFields.add("unit_amount");
    openapiFields.add("flat_amount");
    openapiFields.add("inf");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("up_to");
    openapiRequiredFields.add("unit_amount");
    openapiRequiredFields.add("flat_amount");
    openapiRequiredFields.add("inf");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingTier
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PricingTier.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PricingTier is not found in the empty JSON string", PricingTier.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PricingTier.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PricingTier` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PricingTier.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PricingTier.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PricingTier' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PricingTier> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PricingTier.class));

       return (TypeAdapter<T>) new TypeAdapter<PricingTier>() {
           @Override
           public void write(JsonWriter out, PricingTier value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PricingTier read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PricingTier given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingTier
  * @throws IOException if the JSON string is invalid with respect to PricingTier
  */
  public static PricingTier fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingTier.class);
  }

 /**
  * Convert an instance of PricingTier to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

