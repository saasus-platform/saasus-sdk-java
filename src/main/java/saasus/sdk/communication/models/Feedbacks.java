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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import saasus.sdk.communication.models.Feedback;

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
 * Feedbacks
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-02T11:18:38.971294484Z[Etc/UTC]")
public class Feedbacks {
  public static final String SERIALIZED_NAME_FEEDBACKS = "feedbacks";
  @SerializedName(SERIALIZED_NAME_FEEDBACKS)
  private List<Feedback> feedbacks = new ArrayList<>();

  public Feedbacks() {
  }

  public Feedbacks feedbacks(List<Feedback> feedbacks) {
    this.feedbacks = feedbacks;
    return this;
  }

  public Feedbacks addFeedbacksItem(Feedback feedbacksItem) {
    if (this.feedbacks == null) {
      this.feedbacks = new ArrayList<>();
    }
    this.feedbacks.add(feedbacksItem);
    return this;
  }

   /**
   * Get feedbacks
   * @return feedbacks
  **/
  @javax.annotation.Nonnull
  public List<Feedback> getFeedbacks() {
    return feedbacks;
  }

  public void setFeedbacks(List<Feedback> feedbacks) {
    this.feedbacks = feedbacks;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feedbacks feedbacks = (Feedbacks) o;
    return Objects.equals(this.feedbacks, feedbacks.feedbacks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feedbacks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feedbacks {\n");
    sb.append("    feedbacks: ").append(toIndentedString(feedbacks)).append("\n");
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
    openapiFields.add("feedbacks");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("feedbacks");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Feedbacks
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Feedbacks.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Feedbacks is not found in the empty JSON string", Feedbacks.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Feedbacks.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Feedbacks` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Feedbacks.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("feedbacks").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `feedbacks` to be an array in the JSON string but got `%s`", jsonObj.get("feedbacks").toString()));
      }

      JsonArray jsonArrayfeedbacks = jsonObj.getAsJsonArray("feedbacks");
      // validate the required field `feedbacks` (array)
      for (int i = 0; i < jsonArrayfeedbacks.size(); i++) {
        Feedback.validateJsonElement(jsonArrayfeedbacks.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Feedbacks.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Feedbacks' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Feedbacks> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Feedbacks.class));

       return (TypeAdapter<T>) new TypeAdapter<Feedbacks>() {
           @Override
           public void write(JsonWriter out, Feedbacks value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Feedbacks read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Feedbacks given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Feedbacks
  * @throws IOException if the JSON string is invalid with respect to Feedbacks
  */
  public static Feedbacks fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Feedbacks.class);
  }

 /**
  * Convert an instance of Feedbacks to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

