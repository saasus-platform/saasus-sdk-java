/*
 * SaaSus ApiLog API Schema
 * SaaSus ApiLog API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.apilog.models;

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
import saasus.sdk.apilog.models.ApiLog;

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

import saasus.sdk.apilog.JSON;

/**
 * ApiLogs
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:09:40.405574501Z[Etc/UTC]")
public class ApiLogs {
  public static final String SERIALIZED_NAME_API_LOGS = "api_logs";
  @SerializedName(SERIALIZED_NAME_API_LOGS)
  private List<ApiLog> apiLogs = new ArrayList<>();

  public static final String SERIALIZED_NAME_CURSOR = "cursor";
  @SerializedName(SERIALIZED_NAME_CURSOR)
  private String cursor;

  public ApiLogs() {
  }

  public ApiLogs apiLogs(List<ApiLog> apiLogs) {
    this.apiLogs = apiLogs;
    return this;
  }

  public ApiLogs addApiLogsItem(ApiLog apiLogsItem) {
    if (this.apiLogs == null) {
      this.apiLogs = new ArrayList<>();
    }
    this.apiLogs.add(apiLogsItem);
    return this;
  }

   /**
   * Get apiLogs
   * @return apiLogs
  **/
  @javax.annotation.Nonnull
  public List<ApiLog> getApiLogs() {
    return apiLogs;
  }

  public void setApiLogs(List<ApiLog> apiLogs) {
    this.apiLogs = apiLogs;
  }


  public ApiLogs cursor(String cursor) {
    this.cursor = cursor;
    return this;
  }

   /**
   * Cursor for cursor pagination
   * @return cursor
  **/
  @javax.annotation.Nullable
  public String getCursor() {
    return cursor;
  }

  public void setCursor(String cursor) {
    this.cursor = cursor;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiLogs apiLogs = (ApiLogs) o;
    return Objects.equals(this.apiLogs, apiLogs.apiLogs) &&
        Objects.equals(this.cursor, apiLogs.cursor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiLogs, cursor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiLogs {\n");
    sb.append("    apiLogs: ").append(toIndentedString(apiLogs)).append("\n");
    sb.append("    cursor: ").append(toIndentedString(cursor)).append("\n");
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
    openapiFields.add("api_logs");
    openapiFields.add("cursor");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("api_logs");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ApiLogs
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ApiLogs.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ApiLogs is not found in the empty JSON string", ApiLogs.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ApiLogs.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ApiLogs` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ApiLogs.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("api_logs").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `api_logs` to be an array in the JSON string but got `%s`", jsonObj.get("api_logs").toString()));
      }

      JsonArray jsonArrayapiLogs = jsonObj.getAsJsonArray("api_logs");
      // validate the required field `api_logs` (array)
      for (int i = 0; i < jsonArrayapiLogs.size(); i++) {
        ApiLog.validateJsonElement(jsonArrayapiLogs.get(i));
      };
      if ((jsonObj.get("cursor") != null && !jsonObj.get("cursor").isJsonNull()) && !jsonObj.get("cursor").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cursor` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cursor").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ApiLogs.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ApiLogs' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ApiLogs> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ApiLogs.class));

       return (TypeAdapter<T>) new TypeAdapter<ApiLogs>() {
           @Override
           public void write(JsonWriter out, ApiLogs value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ApiLogs read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ApiLogs given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ApiLogs
  * @throws IOException if the JSON string is invalid with respect to ApiLogs
  */
  public static ApiLogs fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ApiLogs.class);
  }

 /**
  * Convert an instance of ApiLogs to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

