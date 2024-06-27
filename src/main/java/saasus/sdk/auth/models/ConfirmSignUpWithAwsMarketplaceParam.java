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
 * ConfirmSignUpWithAwsMarketplaceParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-27T08:20:37.222119495Z[Etc/UTC]")
public class ConfirmSignUpWithAwsMarketplaceParam {
  public static final String SERIALIZED_NAME_TENANT_NAME = "tenant_name";
  @SerializedName(SERIALIZED_NAME_TENANT_NAME)
  private String tenantName;

  public static final String SERIALIZED_NAME_ACCESS_TOKEN = "access_token";
  @SerializedName(SERIALIZED_NAME_ACCESS_TOKEN)
  private String accessToken;

  public static final String SERIALIZED_NAME_REGISTRATION_TOKEN = "registration_token";
  @SerializedName(SERIALIZED_NAME_REGISTRATION_TOKEN)
  private String registrationToken;

  public ConfirmSignUpWithAwsMarketplaceParam() {
  }

  public ConfirmSignUpWithAwsMarketplaceParam tenantName(String tenantName) {
    this.tenantName = tenantName;
    return this;
  }

   /**
   * Tenant name
   * @return tenantName
  **/
  @javax.annotation.Nullable
  public String getTenantName() {
    return tenantName;
  }

  public void setTenantName(String tenantName) {
    this.tenantName = tenantName;
  }


  public ConfirmSignUpWithAwsMarketplaceParam accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * Access token
   * @return accessToken
  **/
  @javax.annotation.Nonnull
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  public ConfirmSignUpWithAwsMarketplaceParam registrationToken(String registrationToken) {
    this.registrationToken = registrationToken;
    return this;
  }

   /**
   * Registration Token
   * @return registrationToken
  **/
  @javax.annotation.Nonnull
  public String getRegistrationToken() {
    return registrationToken;
  }

  public void setRegistrationToken(String registrationToken) {
    this.registrationToken = registrationToken;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfirmSignUpWithAwsMarketplaceParam confirmSignUpWithAwsMarketplaceParam = (ConfirmSignUpWithAwsMarketplaceParam) o;
    return Objects.equals(this.tenantName, confirmSignUpWithAwsMarketplaceParam.tenantName) &&
        Objects.equals(this.accessToken, confirmSignUpWithAwsMarketplaceParam.accessToken) &&
        Objects.equals(this.registrationToken, confirmSignUpWithAwsMarketplaceParam.registrationToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantName, accessToken, registrationToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfirmSignUpWithAwsMarketplaceParam {\n");
    sb.append("    tenantName: ").append(toIndentedString(tenantName)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    registrationToken: ").append(toIndentedString(registrationToken)).append("\n");
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
    openapiFields.add("tenant_name");
    openapiFields.add("access_token");
    openapiFields.add("registration_token");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("access_token");
    openapiRequiredFields.add("registration_token");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ConfirmSignUpWithAwsMarketplaceParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ConfirmSignUpWithAwsMarketplaceParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ConfirmSignUpWithAwsMarketplaceParam is not found in the empty JSON string", ConfirmSignUpWithAwsMarketplaceParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ConfirmSignUpWithAwsMarketplaceParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ConfirmSignUpWithAwsMarketplaceParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ConfirmSignUpWithAwsMarketplaceParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("tenant_name") != null && !jsonObj.get("tenant_name").isJsonNull()) && !jsonObj.get("tenant_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tenant_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tenant_name").toString()));
      }
      if (!jsonObj.get("access_token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `access_token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("access_token").toString()));
      }
      if (!jsonObj.get("registration_token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `registration_token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("registration_token").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ConfirmSignUpWithAwsMarketplaceParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ConfirmSignUpWithAwsMarketplaceParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ConfirmSignUpWithAwsMarketplaceParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ConfirmSignUpWithAwsMarketplaceParam.class));

       return (TypeAdapter<T>) new TypeAdapter<ConfirmSignUpWithAwsMarketplaceParam>() {
           @Override
           public void write(JsonWriter out, ConfirmSignUpWithAwsMarketplaceParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ConfirmSignUpWithAwsMarketplaceParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ConfirmSignUpWithAwsMarketplaceParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ConfirmSignUpWithAwsMarketplaceParam
  * @throws IOException if the JSON string is invalid with respect to ConfirmSignUpWithAwsMarketplaceParam
  */
  public static ConfirmSignUpWithAwsMarketplaceParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ConfirmSignUpWithAwsMarketplaceParam.class);
  }

 /**
  * Convert an instance of ConfirmSignUpWithAwsMarketplaceParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

