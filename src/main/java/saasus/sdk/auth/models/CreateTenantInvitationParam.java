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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import saasus.sdk.auth.models.InvitedUserEnvironmentInformationInner;

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
 * CreateTenantInvitationParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-04-19T13:07:09.593761729Z[Etc/UTC]")
public class CreateTenantInvitationParam {
  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_ACCESS_TOKEN = "access_token";
  @SerializedName(SERIALIZED_NAME_ACCESS_TOKEN)
  private String accessToken;

  public static final String SERIALIZED_NAME_ENVS = "envs";
  @SerializedName(SERIALIZED_NAME_ENVS)
  private List<InvitedUserEnvironmentInformationInner> envs = new ArrayList<>();

  public CreateTenantInvitationParam() {
  }

  public CreateTenantInvitationParam email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email address of the user to be invited
   * @return email
  **/
  @javax.annotation.Nonnull
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public CreateTenantInvitationParam accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * Access token of the user who creates an invitation
   * @return accessToken
  **/
  @javax.annotation.Nonnull
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  public CreateTenantInvitationParam envs(List<InvitedUserEnvironmentInformationInner> envs) {
    this.envs = envs;
    return this;
  }

  public CreateTenantInvitationParam addEnvsItem(InvitedUserEnvironmentInformationInner envsItem) {
    if (this.envs == null) {
      this.envs = new ArrayList<>();
    }
    this.envs.add(envsItem);
    return this;
  }

   /**
   * Get envs
   * @return envs
  **/
  @javax.annotation.Nonnull
  public List<InvitedUserEnvironmentInformationInner> getEnvs() {
    return envs;
  }

  public void setEnvs(List<InvitedUserEnvironmentInformationInner> envs) {
    this.envs = envs;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTenantInvitationParam createTenantInvitationParam = (CreateTenantInvitationParam) o;
    return Objects.equals(this.email, createTenantInvitationParam.email) &&
        Objects.equals(this.accessToken, createTenantInvitationParam.accessToken) &&
        Objects.equals(this.envs, createTenantInvitationParam.envs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, accessToken, envs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTenantInvitationParam {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    envs: ").append(toIndentedString(envs)).append("\n");
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
    openapiFields.add("email");
    openapiFields.add("access_token");
    openapiFields.add("envs");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("email");
    openapiRequiredFields.add("access_token");
    openapiRequiredFields.add("envs");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CreateTenantInvitationParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CreateTenantInvitationParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateTenantInvitationParam is not found in the empty JSON string", CreateTenantInvitationParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CreateTenantInvitationParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateTenantInvitationParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateTenantInvitationParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if (!jsonObj.get("access_token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `access_token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("access_token").toString()));
      }
      // ensure the json data is an array
      if (!jsonObj.get("envs").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `envs` to be an array in the JSON string but got `%s`", jsonObj.get("envs").toString()));
      }

      JsonArray jsonArrayenvs = jsonObj.getAsJsonArray("envs");
      // validate the required field `envs` (array)
      for (int i = 0; i < jsonArrayenvs.size(); i++) {
        InvitedUserEnvironmentInformationInner.validateJsonElement(jsonArrayenvs.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateTenantInvitationParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateTenantInvitationParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateTenantInvitationParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateTenantInvitationParam.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateTenantInvitationParam>() {
           @Override
           public void write(JsonWriter out, CreateTenantInvitationParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateTenantInvitationParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CreateTenantInvitationParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateTenantInvitationParam
  * @throws IOException if the JSON string is invalid with respect to CreateTenantInvitationParam
  */
  public static CreateTenantInvitationParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateTenantInvitationParam.class);
  }

 /**
  * Convert an instance of CreateTenantInvitationParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

