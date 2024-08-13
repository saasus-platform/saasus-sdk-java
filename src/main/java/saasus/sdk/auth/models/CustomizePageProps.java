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

import saasus.sdk.auth.JSON;

/**
 * CustomizePageProps
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T09:25:44.043629664Z[Etc/UTC]")
public class CustomizePageProps {
  public static final String SERIALIZED_NAME_HTML_CONTENTS = "html_contents";
  @SerializedName(SERIALIZED_NAME_HTML_CONTENTS)
  private String htmlContents;

  public static final String SERIALIZED_NAME_IS_TERMS_OF_SERVICE = "is_terms_of_service";
  @SerializedName(SERIALIZED_NAME_IS_TERMS_OF_SERVICE)
  private Boolean isTermsOfService;

  public static final String SERIALIZED_NAME_IS_PRIVACY_POLICY = "is_privacy_policy";
  @SerializedName(SERIALIZED_NAME_IS_PRIVACY_POLICY)
  private Boolean isPrivacyPolicy;

  public CustomizePageProps() {
  }

  public CustomizePageProps htmlContents(String htmlContents) {
    this.htmlContents = htmlContents;
    return this;
  }

   /**
   * Edit page HTML ※ This function is not yet provided, so it cannot be changed or saved. 
   * @return htmlContents
  **/
  @javax.annotation.Nonnull
  public String getHtmlContents() {
    return htmlContents;
  }

  public void setHtmlContents(String htmlContents) {
    this.htmlContents = htmlContents;
  }


  public CustomizePageProps isTermsOfService(Boolean isTermsOfService) {
    this.isTermsOfService = isTermsOfService;
    return this;
  }

   /**
   * display the terms of use agreement check box
   * @return isTermsOfService
  **/
  @javax.annotation.Nonnull
  public Boolean getIsTermsOfService() {
    return isTermsOfService;
  }

  public void setIsTermsOfService(Boolean isTermsOfService) {
    this.isTermsOfService = isTermsOfService;
  }


  public CustomizePageProps isPrivacyPolicy(Boolean isPrivacyPolicy) {
    this.isPrivacyPolicy = isPrivacyPolicy;
    return this;
  }

   /**
   * show the privacy policy checkbox
   * @return isPrivacyPolicy
  **/
  @javax.annotation.Nonnull
  public Boolean getIsPrivacyPolicy() {
    return isPrivacyPolicy;
  }

  public void setIsPrivacyPolicy(Boolean isPrivacyPolicy) {
    this.isPrivacyPolicy = isPrivacyPolicy;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomizePageProps customizePageProps = (CustomizePageProps) o;
    return Objects.equals(this.htmlContents, customizePageProps.htmlContents) &&
        Objects.equals(this.isTermsOfService, customizePageProps.isTermsOfService) &&
        Objects.equals(this.isPrivacyPolicy, customizePageProps.isPrivacyPolicy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(htmlContents, isTermsOfService, isPrivacyPolicy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomizePageProps {\n");
    sb.append("    htmlContents: ").append(toIndentedString(htmlContents)).append("\n");
    sb.append("    isTermsOfService: ").append(toIndentedString(isTermsOfService)).append("\n");
    sb.append("    isPrivacyPolicy: ").append(toIndentedString(isPrivacyPolicy)).append("\n");
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
    openapiFields.add("html_contents");
    openapiFields.add("is_terms_of_service");
    openapiFields.add("is_privacy_policy");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("html_contents");
    openapiRequiredFields.add("is_terms_of_service");
    openapiRequiredFields.add("is_privacy_policy");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CustomizePageProps
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CustomizePageProps.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CustomizePageProps is not found in the empty JSON string", CustomizePageProps.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CustomizePageProps.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CustomizePageProps` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CustomizePageProps.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("html_contents").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `html_contents` to be a primitive type in the JSON string but got `%s`", jsonObj.get("html_contents").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CustomizePageProps.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CustomizePageProps' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CustomizePageProps> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CustomizePageProps.class));

       return (TypeAdapter<T>) new TypeAdapter<CustomizePageProps>() {
           @Override
           public void write(JsonWriter out, CustomizePageProps value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CustomizePageProps read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CustomizePageProps given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CustomizePageProps
  * @throws IOException if the JSON string is invalid with respect to CustomizePageProps
  */
  public static CustomizePageProps fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CustomizePageProps.class);
  }

 /**
  * Convert an instance of CustomizePageProps to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

