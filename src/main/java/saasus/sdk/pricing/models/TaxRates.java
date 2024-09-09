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
import saasus.sdk.pricing.models.TaxRate;

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
 * TaxRates
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-09T09:27:14.878317319Z[Etc/UTC]")
public class TaxRates {
  public static final String SERIALIZED_NAME_TAX_RATES = "tax_rates";
  @SerializedName(SERIALIZED_NAME_TAX_RATES)
  private List<TaxRate> taxRates = new ArrayList<>();

  public TaxRates() {
  }

  public TaxRates taxRates(List<TaxRate> taxRates) {
    this.taxRates = taxRates;
    return this;
  }

  public TaxRates addTaxRatesItem(TaxRate taxRatesItem) {
    if (this.taxRates == null) {
      this.taxRates = new ArrayList<>();
    }
    this.taxRates.add(taxRatesItem);
    return this;
  }

   /**
   * Get taxRates
   * @return taxRates
  **/
  @javax.annotation.Nonnull
  public List<TaxRate> getTaxRates() {
    return taxRates;
  }

  public void setTaxRates(List<TaxRate> taxRates) {
    this.taxRates = taxRates;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxRates taxRates = (TaxRates) o;
    return Objects.equals(this.taxRates, taxRates.taxRates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxRates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxRates {\n");
    sb.append("    taxRates: ").append(toIndentedString(taxRates)).append("\n");
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
    openapiFields.add("tax_rates");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("tax_rates");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TaxRates
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TaxRates.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TaxRates is not found in the empty JSON string", TaxRates.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TaxRates.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TaxRates` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TaxRates.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("tax_rates").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `tax_rates` to be an array in the JSON string but got `%s`", jsonObj.get("tax_rates").toString()));
      }

      JsonArray jsonArraytaxRates = jsonObj.getAsJsonArray("tax_rates");
      // validate the required field `tax_rates` (array)
      for (int i = 0; i < jsonArraytaxRates.size(); i++) {
        TaxRate.validateJsonElement(jsonArraytaxRates.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TaxRates.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TaxRates' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TaxRates> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TaxRates.class));

       return (TypeAdapter<T>) new TypeAdapter<TaxRates>() {
           @Override
           public void write(JsonWriter out, TaxRates value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TaxRates read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TaxRates given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TaxRates
  * @throws IOException if the JSON string is invalid with respect to TaxRates
  */
  public static TaxRates fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TaxRates.class);
  }

 /**
  * Convert an instance of TaxRates to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

