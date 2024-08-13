/*
 * SaaSus Auth API Schema
 * Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.auth.models;

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
import saasus.sdk.auth.models.PlanHistory;

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

import saasus.sdk.auth.JSON;

/**
 * PlanHistories
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T07:38:53.895588628Z[Etc/UTC]")
public class PlanHistories {
  public static final String SERIALIZED_NAME_PLAN_HISTORIES = "plan_histories";
  @SerializedName(SERIALIZED_NAME_PLAN_HISTORIES)
  private List<PlanHistory> planHistories = new ArrayList<>();

  public PlanHistories() {
  }

  public PlanHistories planHistories(List<PlanHistory> planHistories) {
    this.planHistories = planHistories;
    return this;
  }

  public PlanHistories addPlanHistoriesItem(PlanHistory planHistoriesItem) {
    if (this.planHistories == null) {
      this.planHistories = new ArrayList<>();
    }
    this.planHistories.add(planHistoriesItem);
    return this;
  }

   /**
   * Plan History
   * @return planHistories
  **/
  @javax.annotation.Nonnull
  public List<PlanHistory> getPlanHistories() {
    return planHistories;
  }

  public void setPlanHistories(List<PlanHistory> planHistories) {
    this.planHistories = planHistories;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanHistories planHistories = (PlanHistories) o;
    return Objects.equals(this.planHistories, planHistories.planHistories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planHistories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanHistories {\n");
    sb.append("    planHistories: ").append(toIndentedString(planHistories)).append("\n");
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
    openapiFields.add("plan_histories");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("plan_histories");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PlanHistories
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PlanHistories.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PlanHistories is not found in the empty JSON string", PlanHistories.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PlanHistories.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PlanHistories` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PlanHistories.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("plan_histories").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan_histories` to be an array in the JSON string but got `%s`", jsonObj.get("plan_histories").toString()));
      }

      JsonArray jsonArrayplanHistories = jsonObj.getAsJsonArray("plan_histories");
      // validate the required field `plan_histories` (array)
      for (int i = 0; i < jsonArrayplanHistories.size(); i++) {
        PlanHistory.validateJsonElement(jsonArrayplanHistories.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PlanHistories.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PlanHistories' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PlanHistories> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PlanHistories.class));

       return (TypeAdapter<T>) new TypeAdapter<PlanHistories>() {
           @Override
           public void write(JsonWriter out, PlanHistories value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PlanHistories read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PlanHistories given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PlanHistories
  * @throws IOException if the JSON string is invalid with respect to PlanHistories
  */
  public static PlanHistories fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PlanHistories.class);
  }

 /**
  * Convert an instance of PlanHistories to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

