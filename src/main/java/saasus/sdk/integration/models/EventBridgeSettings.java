/*
 * SaaSus Eventbridge API Schema
 * SaaSus Eventbridge API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.integration.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import saasus.sdk.integration.models.AwsRegion;

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

import saasus.sdk.integration.JSON;

/**
 * EventBridgeSettings
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-16T09:17:44.335095441Z[Etc/UTC]")
public class EventBridgeSettings {
  public static final String SERIALIZED_NAME_AWS_ACCOUNT_ID = "aws_account_id";
  @SerializedName(SERIALIZED_NAME_AWS_ACCOUNT_ID)
  private String awsAccountId;

  public static final String SERIALIZED_NAME_AWS_REGION = "aws_region";
  @SerializedName(SERIALIZED_NAME_AWS_REGION)
  private AwsRegion awsRegion;

  public EventBridgeSettings() {
  }

  public EventBridgeSettings awsAccountId(String awsAccountId) {
    this.awsAccountId = awsAccountId;
    return this;
  }

   /**
   * AWS Account ID
   * @return awsAccountId
  **/
  @javax.annotation.Nonnull
  public String getAwsAccountId() {
    return awsAccountId;
  }

  public void setAwsAccountId(String awsAccountId) {
    this.awsAccountId = awsAccountId;
  }


  public EventBridgeSettings awsRegion(AwsRegion awsRegion) {
    this.awsRegion = awsRegion;
    return this;
  }

   /**
   * Get awsRegion
   * @return awsRegion
  **/
  @javax.annotation.Nonnull
  public AwsRegion getAwsRegion() {
    return awsRegion;
  }

  public void setAwsRegion(AwsRegion awsRegion) {
    this.awsRegion = awsRegion;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventBridgeSettings eventBridgeSettings = (EventBridgeSettings) o;
    return Objects.equals(this.awsAccountId, eventBridgeSettings.awsAccountId) &&
        Objects.equals(this.awsRegion, eventBridgeSettings.awsRegion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awsAccountId, awsRegion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventBridgeSettings {\n");
    sb.append("    awsAccountId: ").append(toIndentedString(awsAccountId)).append("\n");
    sb.append("    awsRegion: ").append(toIndentedString(awsRegion)).append("\n");
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
    openapiFields.add("aws_account_id");
    openapiFields.add("aws_region");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("aws_account_id");
    openapiRequiredFields.add("aws_region");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to EventBridgeSettings
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!EventBridgeSettings.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EventBridgeSettings is not found in the empty JSON string", EventBridgeSettings.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!EventBridgeSettings.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EventBridgeSettings` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : EventBridgeSettings.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("aws_account_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `aws_account_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("aws_account_id").toString()));
      }
      // validate the required field `aws_region`
      AwsRegion.validateJsonElement(jsonObj.get("aws_region"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EventBridgeSettings.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EventBridgeSettings' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EventBridgeSettings> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EventBridgeSettings.class));

       return (TypeAdapter<T>) new TypeAdapter<EventBridgeSettings>() {
           @Override
           public void write(JsonWriter out, EventBridgeSettings value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EventBridgeSettings read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EventBridgeSettings given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EventBridgeSettings
  * @throws IOException if the JSON string is invalid with respect to EventBridgeSettings
  */
  public static EventBridgeSettings fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EventBridgeSettings.class);
  }

 /**
  * Convert an instance of EventBridgeSettings to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

