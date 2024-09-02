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
import saasus.sdk.pricing.models.PricingMenu;

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
 * PricingMenus
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-02T11:18:22.618166876Z[Etc/UTC]")
public class PricingMenus {
  public static final String SERIALIZED_NAME_PRICING_MENUS = "pricing_menus";
  @SerializedName(SERIALIZED_NAME_PRICING_MENUS)
  private List<PricingMenu> pricingMenus = new ArrayList<>();

  public PricingMenus() {
  }

  public PricingMenus pricingMenus(List<PricingMenu> pricingMenus) {
    this.pricingMenus = pricingMenus;
    return this;
  }

  public PricingMenus addPricingMenusItem(PricingMenu pricingMenusItem) {
    if (this.pricingMenus == null) {
      this.pricingMenus = new ArrayList<>();
    }
    this.pricingMenus.add(pricingMenusItem);
    return this;
  }

   /**
   * Get pricingMenus
   * @return pricingMenus
  **/
  @javax.annotation.Nonnull
  public List<PricingMenu> getPricingMenus() {
    return pricingMenus;
  }

  public void setPricingMenus(List<PricingMenu> pricingMenus) {
    this.pricingMenus = pricingMenus;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricingMenus pricingMenus = (PricingMenus) o;
    return Objects.equals(this.pricingMenus, pricingMenus.pricingMenus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pricingMenus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingMenus {\n");
    sb.append("    pricingMenus: ").append(toIndentedString(pricingMenus)).append("\n");
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
    openapiFields.add("pricing_menus");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("pricing_menus");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingMenus
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PricingMenus.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PricingMenus is not found in the empty JSON string", PricingMenus.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PricingMenus.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PricingMenus` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PricingMenus.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("pricing_menus").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `pricing_menus` to be an array in the JSON string but got `%s`", jsonObj.get("pricing_menus").toString()));
      }

      JsonArray jsonArraypricingMenus = jsonObj.getAsJsonArray("pricing_menus");
      // validate the required field `pricing_menus` (array)
      for (int i = 0; i < jsonArraypricingMenus.size(); i++) {
        PricingMenu.validateJsonElement(jsonArraypricingMenus.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PricingMenus.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PricingMenus' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PricingMenus> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PricingMenus.class));

       return (TypeAdapter<T>) new TypeAdapter<PricingMenus>() {
           @Override
           public void write(JsonWriter out, PricingMenus value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PricingMenus read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PricingMenus given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingMenus
  * @throws IOException if the JSON string is invalid with respect to PricingMenus
  */
  public static PricingMenus fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingMenus.class);
  }

 /**
  * Convert an instance of PricingMenus to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

