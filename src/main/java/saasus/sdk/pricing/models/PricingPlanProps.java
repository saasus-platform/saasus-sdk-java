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
 * PricingPlanProps
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-15T13:42:18.753207487Z[Etc/UTC]")
public class PricingPlanProps {
  public static final String SERIALIZED_NAME_PRICING_MENUS = "pricing_menus";
  @SerializedName(SERIALIZED_NAME_PRICING_MENUS)
  private List<PricingMenu> pricingMenus = new ArrayList<>();

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_USED = "used";
  @SerializedName(SERIALIZED_NAME_USED)
  private Boolean used;

  public PricingPlanProps() {
  }

  public PricingPlanProps pricingMenus(List<PricingMenu> pricingMenus) {
    this.pricingMenus = pricingMenus;
    return this;
  }

  public PricingPlanProps addPricingMenusItem(PricingMenu pricingMenusItem) {
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


  public PricingPlanProps name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Pricing plan name
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public PricingPlanProps displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Pricing plan display name
   * @return displayName
  **/
  @javax.annotation.Nonnull
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public PricingPlanProps description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Pricing plan description
   * @return description
  **/
  @javax.annotation.Nonnull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public PricingPlanProps used(Boolean used) {
    this.used = used;
    return this;
  }

   /**
   * Pricing plan used settings
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
    PricingPlanProps pricingPlanProps = (PricingPlanProps) o;
    return Objects.equals(this.pricingMenus, pricingPlanProps.pricingMenus) &&
        Objects.equals(this.name, pricingPlanProps.name) &&
        Objects.equals(this.displayName, pricingPlanProps.displayName) &&
        Objects.equals(this.description, pricingPlanProps.description) &&
        Objects.equals(this.used, pricingPlanProps.used);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pricingMenus, name, displayName, description, used);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingPlanProps {\n");
    sb.append("    pricingMenus: ").append(toIndentedString(pricingMenus)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
    openapiFields.add("pricing_menus");
    openapiFields.add("name");
    openapiFields.add("display_name");
    openapiFields.add("description");
    openapiFields.add("used");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("pricing_menus");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("display_name");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("used");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PricingPlanProps
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PricingPlanProps.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PricingPlanProps is not found in the empty JSON string", PricingPlanProps.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PricingPlanProps.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PricingPlanProps` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PricingPlanProps.openapiRequiredFields) {
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
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (!jsonObj.get("display_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display_name").toString()));
      }
      if (!jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PricingPlanProps.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PricingPlanProps' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PricingPlanProps> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PricingPlanProps.class));

       return (TypeAdapter<T>) new TypeAdapter<PricingPlanProps>() {
           @Override
           public void write(JsonWriter out, PricingPlanProps value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PricingPlanProps read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PricingPlanProps given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PricingPlanProps
  * @throws IOException if the JSON string is invalid with respect to PricingPlanProps
  */
  public static PricingPlanProps fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PricingPlanProps.class);
  }

 /**
  * Convert an instance of PricingPlanProps to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

