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
 * FeedbackSaveProps
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T07:40:49.572039578Z[Etc/UTC]")
public class FeedbackSaveProps {
  public static final String SERIALIZED_NAME_FEEDBACK_TITLE = "feedback_title";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_TITLE)
  private String feedbackTitle;

  public static final String SERIALIZED_NAME_FEEDBACK_DESCRIPTION = "feedback_description";
  @SerializedName(SERIALIZED_NAME_FEEDBACK_DESCRIPTION)
  private String feedbackDescription;

  public FeedbackSaveProps() {
  }

  public FeedbackSaveProps feedbackTitle(String feedbackTitle) {
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


  public FeedbackSaveProps feedbackDescription(String feedbackDescription) {
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

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the FeedbackSaveProps instance itself
   */
  public FeedbackSaveProps putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeedbackSaveProps feedbackSaveProps = (FeedbackSaveProps) o;
    return Objects.equals(this.feedbackTitle, feedbackSaveProps.feedbackTitle) &&
        Objects.equals(this.feedbackDescription, feedbackSaveProps.feedbackDescription)&&
        Objects.equals(this.additionalProperties, feedbackSaveProps.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feedbackTitle, feedbackDescription, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeedbackSaveProps {\n");
    sb.append("    feedbackTitle: ").append(toIndentedString(feedbackTitle)).append("\n");
    sb.append("    feedbackDescription: ").append(toIndentedString(feedbackDescription)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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
  * @throws IOException if the JSON Element is invalid with respect to FeedbackSaveProps
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!FeedbackSaveProps.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in FeedbackSaveProps is not found in the empty JSON string", FeedbackSaveProps.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : FeedbackSaveProps.openapiRequiredFields) {
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
       if (!FeedbackSaveProps.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'FeedbackSaveProps' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<FeedbackSaveProps> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(FeedbackSaveProps.class));

       return (TypeAdapter<T>) new TypeAdapter<FeedbackSaveProps>() {
           @Override
           public void write(JsonWriter out, FeedbackSaveProps value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additional properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public FeedbackSaveProps read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             JsonObject jsonObj = jsonElement.getAsJsonObject();
             // store additional fields in the deserialized instance
             FeedbackSaveProps instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of FeedbackSaveProps given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of FeedbackSaveProps
  * @throws IOException if the JSON string is invalid with respect to FeedbackSaveProps
  */
  public static FeedbackSaveProps fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, FeedbackSaveProps.class);
  }

 /**
  * Convert an instance of FeedbackSaveProps to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

