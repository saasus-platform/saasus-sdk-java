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
 * reCAPTCHA authentication settings ※ This function is not yet provided, so it cannot be changed or saved. 
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:09:21.529968105Z[Etc/UTC]")
public class RecaptchaProps {
  public static final String SERIALIZED_NAME_SITE_KEY = "site_key";
  @SerializedName(SERIALIZED_NAME_SITE_KEY)
  private String siteKey;

  public static final String SERIALIZED_NAME_SECRET_KEY = "secret_key";
  @SerializedName(SERIALIZED_NAME_SECRET_KEY)
  private String secretKey;

  public RecaptchaProps() {
  }

  public RecaptchaProps siteKey(String siteKey) {
    this.siteKey = siteKey;
    return this;
  }

   /**
   * site key
   * @return siteKey
  **/
  @javax.annotation.Nonnull
  public String getSiteKey() {
    return siteKey;
  }

  public void setSiteKey(String siteKey) {
    this.siteKey = siteKey;
  }


  public RecaptchaProps secretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }

   /**
   * secret key
   * @return secretKey
  **/
  @javax.annotation.Nonnull
  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecaptchaProps recaptchaProps = (RecaptchaProps) o;
    return Objects.equals(this.siteKey, recaptchaProps.siteKey) &&
        Objects.equals(this.secretKey, recaptchaProps.secretKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(siteKey, secretKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecaptchaProps {\n");
    sb.append("    siteKey: ").append(toIndentedString(siteKey)).append("\n");
    sb.append("    secretKey: ").append(toIndentedString(secretKey)).append("\n");
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
    openapiFields.add("site_key");
    openapiFields.add("secret_key");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("site_key");
    openapiRequiredFields.add("secret_key");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to RecaptchaProps
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RecaptchaProps.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RecaptchaProps is not found in the empty JSON string", RecaptchaProps.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!RecaptchaProps.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RecaptchaProps` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : RecaptchaProps.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("site_key").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `site_key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("site_key").toString()));
      }
      if (!jsonObj.get("secret_key").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `secret_key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("secret_key").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RecaptchaProps.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RecaptchaProps' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RecaptchaProps> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RecaptchaProps.class));

       return (TypeAdapter<T>) new TypeAdapter<RecaptchaProps>() {
           @Override
           public void write(JsonWriter out, RecaptchaProps value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RecaptchaProps read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RecaptchaProps given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RecaptchaProps
  * @throws IOException if the JSON string is invalid with respect to RecaptchaProps
  */
  public static RecaptchaProps fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RecaptchaProps.class);
  }

 /**
  * Convert an instance of RecaptchaProps to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

