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
 * SavePricingMenuParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-23T07:11:37.686429890Z[Etc/UTC]")
public class SavePricingMenuParam {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_UNIT_IDS = "unit_ids";
  @SerializedName(SERIALIZED_NAME_UNIT_IDS)
  private List<String> unitIds = new ArrayList<>();

  public SavePricingMenuParam() {
  }

  public SavePricingMenuParam name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Menu name
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public SavePricingMenuParam displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Menu display name
   * @return displayName
  **/
  @javax.annotation.Nonnull
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public SavePricingMenuParam description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Menu description
   * @return description
  **/
  @javax.annotation.Nonnull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public SavePricingMenuParam unitIds(List<String> unitIds) {
    this.unitIds = unitIds;
    return this;
  }

  public SavePricingMenuParam addUnitIdsItem(String unitIdsItem) {
    if (this.unitIds == null) {
      this.unitIds = new ArrayList<>();
    }
    this.unitIds.add(unitIdsItem);
    return this;
  }

   /**
   * Unit IDs to add
   * @return unitIds
  **/
  @javax.annotation.Nonnull
  public List<String> getUnitIds() {
    return unitIds;
  }

  public void setUnitIds(List<String> unitIds) {
    this.unitIds = unitIds;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SavePricingMenuParam savePricingMenuParam = (SavePricingMenuParam) o;
    return Objects.equals(this.name, savePricingMenuParam.name) &&
        Objects.equals(this.displayName, savePricingMenuParam.displayName) &&
        Objects.equals(this.description, savePricingMenuParam.description) &&
        Objects.equals(this.unitIds, savePricingMenuParam.unitIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, displayName, description, unitIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SavePricingMenuParam {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    unitIds: ").append(toIndentedString(unitIds)).append("\n");
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
    openapiFields.add("unit_ids");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("display_name");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("unit_ids");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SavePricingMenuParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SavePricingMenuParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SavePricingMenuParam is not found in the empty JSON string", SavePricingMenuParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SavePricingMenuParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SavePricingMenuParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SavePricingMenuParam.openapiRequiredFields) {
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
      // ensure the required json array is present
      if (jsonObj.get("unit_ids") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("unit_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `unit_ids` to be an array in the JSON string but got `%s`", jsonObj.get("unit_ids").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SavePricingMenuParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SavePricingMenuParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SavePricingMenuParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SavePricingMenuParam.class));

       return (TypeAdapter<T>) new TypeAdapter<SavePricingMenuParam>() {
           @Override
           public void write(JsonWriter out, SavePricingMenuParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SavePricingMenuParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SavePricingMenuParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SavePricingMenuParam
  * @throws IOException if the JSON string is invalid with respect to SavePricingMenuParam
  */
  public static SavePricingMenuParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SavePricingMenuParam.class);
  }

 /**
  * Convert an instance of SavePricingMenuParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

