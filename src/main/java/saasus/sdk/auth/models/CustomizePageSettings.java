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
 * CustomizePageSettings
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-01T14:26:52.404557738Z[Etc/UTC]")
public class CustomizePageSettings {
  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_TERMS_OF_SERVICE_URL = "terms_of_service_url";
  @SerializedName(SERIALIZED_NAME_TERMS_OF_SERVICE_URL)
  private String termsOfServiceUrl;

  public static final String SERIALIZED_NAME_PRIVACY_POLICY_URL = "privacy_policy_url";
  @SerializedName(SERIALIZED_NAME_PRIVACY_POLICY_URL)
  private String privacyPolicyUrl;

  public static final String SERIALIZED_NAME_GOOGLE_TAG_MANAGER_CONTAINER_ID = "google_tag_manager_container_id";
  @SerializedName(SERIALIZED_NAME_GOOGLE_TAG_MANAGER_CONTAINER_ID)
  private String googleTagManagerContainerId;

  public static final String SERIALIZED_NAME_ICON = "icon";
  @SerializedName(SERIALIZED_NAME_ICON)
  private String icon;

  public static final String SERIALIZED_NAME_FAVICON = "favicon";
  @SerializedName(SERIALIZED_NAME_FAVICON)
  private String favicon;

  public CustomizePageSettings() {
  }

  public CustomizePageSettings title(String title) {
    this.title = title;
    return this;
  }

   /**
   * service name
   * @return title
  **/
  @javax.annotation.Nonnull
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public CustomizePageSettings termsOfServiceUrl(String termsOfServiceUrl) {
    this.termsOfServiceUrl = termsOfServiceUrl;
    return this;
  }

   /**
   * terms of service URL
   * @return termsOfServiceUrl
  **/
  @javax.annotation.Nonnull
  public String getTermsOfServiceUrl() {
    return termsOfServiceUrl;
  }

  public void setTermsOfServiceUrl(String termsOfServiceUrl) {
    this.termsOfServiceUrl = termsOfServiceUrl;
  }


  public CustomizePageSettings privacyPolicyUrl(String privacyPolicyUrl) {
    this.privacyPolicyUrl = privacyPolicyUrl;
    return this;
  }

   /**
   * privacy policy URL
   * @return privacyPolicyUrl
  **/
  @javax.annotation.Nonnull
  public String getPrivacyPolicyUrl() {
    return privacyPolicyUrl;
  }

  public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
    this.privacyPolicyUrl = privacyPolicyUrl;
  }


  public CustomizePageSettings googleTagManagerContainerId(String googleTagManagerContainerId) {
    this.googleTagManagerContainerId = googleTagManagerContainerId;
    return this;
  }

   /**
   * Google Tag Manager container ID
   * @return googleTagManagerContainerId
  **/
  @javax.annotation.Nonnull
  public String getGoogleTagManagerContainerId() {
    return googleTagManagerContainerId;
  }

  public void setGoogleTagManagerContainerId(String googleTagManagerContainerId) {
    this.googleTagManagerContainerId = googleTagManagerContainerId;
  }


  public CustomizePageSettings icon(String icon) {
    this.icon = icon;
    return this;
  }

   /**
   * service icon
   * @return icon
  **/
  @javax.annotation.Nonnull
  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public CustomizePageSettings favicon(String favicon) {
    this.favicon = favicon;
    return this;
  }

   /**
   * favicon
   * @return favicon
  **/
  @javax.annotation.Nonnull
  public String getFavicon() {
    return favicon;
  }

  public void setFavicon(String favicon) {
    this.favicon = favicon;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomizePageSettings customizePageSettings = (CustomizePageSettings) o;
    return Objects.equals(this.title, customizePageSettings.title) &&
        Objects.equals(this.termsOfServiceUrl, customizePageSettings.termsOfServiceUrl) &&
        Objects.equals(this.privacyPolicyUrl, customizePageSettings.privacyPolicyUrl) &&
        Objects.equals(this.googleTagManagerContainerId, customizePageSettings.googleTagManagerContainerId) &&
        Objects.equals(this.icon, customizePageSettings.icon) &&
        Objects.equals(this.favicon, customizePageSettings.favicon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, termsOfServiceUrl, privacyPolicyUrl, googleTagManagerContainerId, icon, favicon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomizePageSettings {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    termsOfServiceUrl: ").append(toIndentedString(termsOfServiceUrl)).append("\n");
    sb.append("    privacyPolicyUrl: ").append(toIndentedString(privacyPolicyUrl)).append("\n");
    sb.append("    googleTagManagerContainerId: ").append(toIndentedString(googleTagManagerContainerId)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    favicon: ").append(toIndentedString(favicon)).append("\n");
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
    openapiFields.add("title");
    openapiFields.add("terms_of_service_url");
    openapiFields.add("privacy_policy_url");
    openapiFields.add("google_tag_manager_container_id");
    openapiFields.add("icon");
    openapiFields.add("favicon");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("title");
    openapiRequiredFields.add("terms_of_service_url");
    openapiRequiredFields.add("privacy_policy_url");
    openapiRequiredFields.add("google_tag_manager_container_id");
    openapiRequiredFields.add("icon");
    openapiRequiredFields.add("favicon");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CustomizePageSettings
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CustomizePageSettings.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CustomizePageSettings is not found in the empty JSON string", CustomizePageSettings.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CustomizePageSettings.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CustomizePageSettings` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CustomizePageSettings.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if (!jsonObj.get("terms_of_service_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `terms_of_service_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("terms_of_service_url").toString()));
      }
      if (!jsonObj.get("privacy_policy_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `privacy_policy_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("privacy_policy_url").toString()));
      }
      if (!jsonObj.get("google_tag_manager_container_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `google_tag_manager_container_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("google_tag_manager_container_id").toString()));
      }
      if (!jsonObj.get("icon").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `icon` to be a primitive type in the JSON string but got `%s`", jsonObj.get("icon").toString()));
      }
      if (!jsonObj.get("favicon").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `favicon` to be a primitive type in the JSON string but got `%s`", jsonObj.get("favicon").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CustomizePageSettings.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CustomizePageSettings' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CustomizePageSettings> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CustomizePageSettings.class));

       return (TypeAdapter<T>) new TypeAdapter<CustomizePageSettings>() {
           @Override
           public void write(JsonWriter out, CustomizePageSettings value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CustomizePageSettings read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CustomizePageSettings given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CustomizePageSettings
  * @throws IOException if the JSON string is invalid with respect to CustomizePageSettings
  */
  public static CustomizePageSettings fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CustomizePageSettings.class);
  }

 /**
  * Convert an instance of CustomizePageSettings to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

