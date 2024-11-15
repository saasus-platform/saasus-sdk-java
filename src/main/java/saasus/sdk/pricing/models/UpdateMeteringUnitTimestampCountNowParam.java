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
import saasus.sdk.pricing.models.UpdateMeteringUnitTimestampCountMethod;

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
 * UpdateMeteringUnitTimestampCountNowParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-11-15T14:19:29.264965125Z[Etc/UTC]")
public class UpdateMeteringUnitTimestampCountNowParam {
  public static final String SERIALIZED_NAME_METHOD = "method";
  @SerializedName(SERIALIZED_NAME_METHOD)
  private UpdateMeteringUnitTimestampCountMethod method;

  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;

  public UpdateMeteringUnitTimestampCountNowParam() {
  }

  public UpdateMeteringUnitTimestampCountNowParam method(UpdateMeteringUnitTimestampCountMethod method) {
    this.method = method;
    return this;
  }

   /**
   * Get method
   * @return method
  **/
  @javax.annotation.Nonnull
  public UpdateMeteringUnitTimestampCountMethod getMethod() {
    return method;
  }

  public void setMethod(UpdateMeteringUnitTimestampCountMethod method) {
    this.method = method;
  }


  public UpdateMeteringUnitTimestampCountNowParam count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Count
   * @return count
  **/
  @javax.annotation.Nonnull
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMeteringUnitTimestampCountNowParam updateMeteringUnitTimestampCountNowParam = (UpdateMeteringUnitTimestampCountNowParam) o;
    return Objects.equals(this.method, updateMeteringUnitTimestampCountNowParam.method) &&
        Objects.equals(this.count, updateMeteringUnitTimestampCountNowParam.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateMeteringUnitTimestampCountNowParam {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
    openapiFields.add("method");
    openapiFields.add("count");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("method");
    openapiRequiredFields.add("count");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateMeteringUnitTimestampCountNowParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateMeteringUnitTimestampCountNowParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateMeteringUnitTimestampCountNowParam is not found in the empty JSON string", UpdateMeteringUnitTimestampCountNowParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateMeteringUnitTimestampCountNowParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateMeteringUnitTimestampCountNowParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UpdateMeteringUnitTimestampCountNowParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `method`
      UpdateMeteringUnitTimestampCountMethod.validateJsonElement(jsonObj.get("method"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateMeteringUnitTimestampCountNowParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateMeteringUnitTimestampCountNowParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateMeteringUnitTimestampCountNowParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateMeteringUnitTimestampCountNowParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateMeteringUnitTimestampCountNowParam>() {
           @Override
           public void write(JsonWriter out, UpdateMeteringUnitTimestampCountNowParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateMeteringUnitTimestampCountNowParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateMeteringUnitTimestampCountNowParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateMeteringUnitTimestampCountNowParam
  * @throws IOException if the JSON string is invalid with respect to UpdateMeteringUnitTimestampCountNowParam
  */
  public static UpdateMeteringUnitTimestampCountNowParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateMeteringUnitTimestampCountNowParam.class);
  }

 /**
  * Convert an instance of UpdateMeteringUnitTimestampCountNowParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

