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
 * TenantIdentityProvidersSaml
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-23T07:14:31.359457335Z[Etc/UTC]")
public class TenantIdentityProvidersSaml {
  public static final String SERIALIZED_NAME_METADATA_URL = "metadata_url";
  @SerializedName(SERIALIZED_NAME_METADATA_URL)
  private String metadataUrl;

  public static final String SERIALIZED_NAME_EMAIL_ATTRIBUTE = "email_attribute";
  @SerializedName(SERIALIZED_NAME_EMAIL_ATTRIBUTE)
  private String emailAttribute;

  public static final String SERIALIZED_NAME_SIGN_IN_URL = "sign_in_url";
  @SerializedName(SERIALIZED_NAME_SIGN_IN_URL)
  private String signInUrl;

  public TenantIdentityProvidersSaml() {
  }

  public TenantIdentityProvidersSaml metadataUrl(String metadataUrl) {
    this.metadataUrl = metadataUrl;
    return this;
  }

   /**
   * Get metadataUrl
   * @return metadataUrl
  **/
  @javax.annotation.Nonnull
  public String getMetadataUrl() {
    return metadataUrl;
  }

  public void setMetadataUrl(String metadataUrl) {
    this.metadataUrl = metadataUrl;
  }


  public TenantIdentityProvidersSaml emailAttribute(String emailAttribute) {
    this.emailAttribute = emailAttribute;
    return this;
  }

   /**
   * Get emailAttribute
   * @return emailAttribute
  **/
  @javax.annotation.Nonnull
  public String getEmailAttribute() {
    return emailAttribute;
  }

  public void setEmailAttribute(String emailAttribute) {
    this.emailAttribute = emailAttribute;
  }


  public TenantIdentityProvidersSaml signInUrl(String signInUrl) {
    this.signInUrl = signInUrl;
    return this;
  }

   /**
   * Get signInUrl
   * @return signInUrl
  **/
  @javax.annotation.Nonnull
  public String getSignInUrl() {
    return signInUrl;
  }

  public void setSignInUrl(String signInUrl) {
    this.signInUrl = signInUrl;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantIdentityProvidersSaml tenantIdentityProvidersSaml = (TenantIdentityProvidersSaml) o;
    return Objects.equals(this.metadataUrl, tenantIdentityProvidersSaml.metadataUrl) &&
        Objects.equals(this.emailAttribute, tenantIdentityProvidersSaml.emailAttribute) &&
        Objects.equals(this.signInUrl, tenantIdentityProvidersSaml.signInUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataUrl, emailAttribute, signInUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantIdentityProvidersSaml {\n");
    sb.append("    metadataUrl: ").append(toIndentedString(metadataUrl)).append("\n");
    sb.append("    emailAttribute: ").append(toIndentedString(emailAttribute)).append("\n");
    sb.append("    signInUrl: ").append(toIndentedString(signInUrl)).append("\n");
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
    openapiFields.add("metadata_url");
    openapiFields.add("email_attribute");
    openapiFields.add("sign_in_url");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("metadata_url");
    openapiRequiredFields.add("email_attribute");
    openapiRequiredFields.add("sign_in_url");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TenantIdentityProvidersSaml
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TenantIdentityProvidersSaml.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TenantIdentityProvidersSaml is not found in the empty JSON string", TenantIdentityProvidersSaml.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TenantIdentityProvidersSaml.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TenantIdentityProvidersSaml` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TenantIdentityProvidersSaml.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("metadata_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `metadata_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("metadata_url").toString()));
      }
      if (!jsonObj.get("email_attribute").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email_attribute` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email_attribute").toString()));
      }
      if (!jsonObj.get("sign_in_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sign_in_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sign_in_url").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TenantIdentityProvidersSaml.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TenantIdentityProvidersSaml' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TenantIdentityProvidersSaml> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TenantIdentityProvidersSaml.class));

       return (TypeAdapter<T>) new TypeAdapter<TenantIdentityProvidersSaml>() {
           @Override
           public void write(JsonWriter out, TenantIdentityProvidersSaml value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TenantIdentityProvidersSaml read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TenantIdentityProvidersSaml given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TenantIdentityProvidersSaml
  * @throws IOException if the JSON string is invalid with respect to TenantIdentityProvidersSaml
  */
  public static TenantIdentityProvidersSaml fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TenantIdentityProvidersSaml.class);
  }

 /**
  * Convert an instance of TenantIdentityProvidersSaml to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

