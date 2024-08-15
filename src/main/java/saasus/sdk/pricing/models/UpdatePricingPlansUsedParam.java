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
 * UpdatePricingPlansUsedParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-15T08:29:59.483160919Z[Etc/UTC]")
public class UpdatePricingPlansUsedParam {
  public static final String SERIALIZED_NAME_PLAN_IDS = "plan_ids";
  @SerializedName(SERIALIZED_NAME_PLAN_IDS)
  private List<String> planIds = new ArrayList<>();

  public UpdatePricingPlansUsedParam() {
  }

  public UpdatePricingPlansUsedParam planIds(List<String> planIds) {
    this.planIds = planIds;
    return this;
  }

  public UpdatePricingPlansUsedParam addPlanIdsItem(String planIdsItem) {
    if (this.planIds == null) {
      this.planIds = new ArrayList<>();
    }
    this.planIds.add(planIdsItem);
    return this;
  }

   /**
   * Get planIds
   * @return planIds
  **/
  @javax.annotation.Nonnull
  public List<String> getPlanIds() {
    return planIds;
  }

  public void setPlanIds(List<String> planIds) {
    this.planIds = planIds;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatePricingPlansUsedParam updatePricingPlansUsedParam = (UpdatePricingPlansUsedParam) o;
    return Objects.equals(this.planIds, updatePricingPlansUsedParam.planIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePricingPlansUsedParam {\n");
    sb.append("    planIds: ").append(toIndentedString(planIds)).append("\n");
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
    openapiFields.add("plan_ids");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("plan_ids");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdatePricingPlansUsedParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdatePricingPlansUsedParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdatePricingPlansUsedParam is not found in the empty JSON string", UpdatePricingPlansUsedParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdatePricingPlansUsedParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdatePricingPlansUsedParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UpdatePricingPlansUsedParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the required json array is present
      if (jsonObj.get("plan_ids") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("plan_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan_ids` to be an array in the JSON string but got `%s`", jsonObj.get("plan_ids").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdatePricingPlansUsedParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdatePricingPlansUsedParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdatePricingPlansUsedParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdatePricingPlansUsedParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdatePricingPlansUsedParam>() {
           @Override
           public void write(JsonWriter out, UpdatePricingPlansUsedParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdatePricingPlansUsedParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdatePricingPlansUsedParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdatePricingPlansUsedParam
  * @throws IOException if the JSON string is invalid with respect to UpdatePricingPlansUsedParam
  */
  public static UpdatePricingPlansUsedParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdatePricingPlansUsedParam.class);
  }

 /**
  * Convert an instance of UpdatePricingPlansUsedParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

