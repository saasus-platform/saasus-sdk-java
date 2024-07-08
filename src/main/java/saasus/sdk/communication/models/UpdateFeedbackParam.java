/*
 * SaaSus Communication API Schema
 * SaaSus Communication API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.communication.models;

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

import saasus.sdk.communication.JSON;

/**
 * UpdateFeedbackParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-08T02:50:52.625090151Z[Etc/UTC]")
public class UpdateFeedbackParam {
  public static final String SERIALIZED_NAME_FEEDBACK_TITLE = "feedback_title";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_TITLE)
  private String feedbackTitle;

  public static final String SERIALIZED_NAME_FEEDBACK_DESCRIPTION = "feedback_description";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_DESCRIPTION)
  private String feedbackDescription;

  public UpdateFeedbackParam() {
  }

  public UpdateFeedbackParam feedbackTitle(String feedbackTitle) {
    this.feedbackTitle = feedbackTitle;
    return this;
  }

   /**
   * Get feedbackTitle
   * @return feedbackTitle
  **/
  @javax.annotation.Nonnull
  public String getFeedbackTitle() {
    return feedbackTitle;
  }

  public void setFeedbackTitle(String feedbackTitle) {
    this.feedbackTitle = feedbackTitle;
  }


  public UpdateFeedbackParam feedbackDescription(String feedbackDescription) {
    this.feedbackDescription = feedbackDescription;
    return this;
  }

   /**
   * Get feedbackDescription
   * @return feedbackDescription
  **/
  @javax.annotation.Nonnull
  public String getFeedbackDescription() {
    return feedbackDescription;
  }

  public void setFeedbackDescription(String feedbackDescription) {
    this.feedbackDescription = feedbackDescription;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateFeedbackParam updateFeedbackParam = (UpdateFeedbackParam) o;
    return Objects.equals(this.feedbackTitle, updateFeedbackParam.feedbackTitle) &&
        Objects.equals(this.feedbackDescription, updateFeedbackParam.feedbackDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feedbackTitle, feedbackDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateFeedbackParam {\n");
    sb.append("    feedbackTitle: ").append(toIndentedString(feedbackTitle)).append("\n");
    sb.append("    feedbackDescription: ").append(toIndentedString(feedbackDescription)).append("\n");
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
    openapiFields.add("feedback_title");
    openapiFields.add("feedback_description");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("feedback_title");
    openapiRequiredFields.add("feedback_description");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateFeedbackParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateFeedbackParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateFeedbackParam is not found in the empty JSON string", UpdateFeedbackParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateFeedbackParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateFeedbackParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UpdateFeedbackParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("feedback_title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `feedback_title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("feedback_title").toString()));
      }
      if (!jsonObj.get("feedback_description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `feedback_description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("feedback_description").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateFeedbackParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateFeedbackParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateFeedbackParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateFeedbackParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateFeedbackParam>() {
           @Override
           public void write(JsonWriter out, UpdateFeedbackParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateFeedbackParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateFeedbackParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateFeedbackParam
  * @throws IOException if the JSON string is invalid with respect to UpdateFeedbackParam
  */
  public static UpdateFeedbackParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateFeedbackParam.class);
  }

 /**
  * Convert an instance of UpdateFeedbackParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

