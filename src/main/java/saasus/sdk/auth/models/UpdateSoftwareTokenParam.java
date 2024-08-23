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
 * UpdateSoftwareTokenParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-23T07:11:31.927189736Z[Etc/UTC]")
public class UpdateSoftwareTokenParam {
  public static final String SERIALIZED_NAME_ACCESS_TOKEN = "access_token";
  @SerializedName(SERIALIZED_NAME_ACCESS_TOKEN)
  private String accessToken;

  public static final String SERIALIZED_NAME_VERIFICATION_CODE = "verification_code";
  @SerializedName(SERIALIZED_NAME_VERIFICATION_CODE)
  private String verificationCode;

  public UpdateSoftwareTokenParam() {
  }

  public UpdateSoftwareTokenParam accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * access token
   * @return accessToken
  **/
  @javax.annotation.Nonnull
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  public UpdateSoftwareTokenParam verificationCode(String verificationCode) {
    this.verificationCode = verificationCode;
    return this;
  }

   /**
   * verification code
   * @return verificationCode
  **/
  @javax.annotation.Nonnull
  public String getVerificationCode() {
    return verificationCode;
  }

  public void setVerificationCode(String verificationCode) {
    this.verificationCode = verificationCode;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSoftwareTokenParam updateSoftwareTokenParam = (UpdateSoftwareTokenParam) o;
    return Objects.equals(this.accessToken, updateSoftwareTokenParam.accessToken) &&
        Objects.equals(this.verificationCode, updateSoftwareTokenParam.verificationCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, verificationCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSoftwareTokenParam {\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    verificationCode: ").append(toIndentedString(verificationCode)).append("\n");
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
    openapiFields.add("access_token");
    openapiFields.add("verification_code");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("access_token");
    openapiRequiredFields.add("verification_code");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateSoftwareTokenParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateSoftwareTokenParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateSoftwareTokenParam is not found in the empty JSON string", UpdateSoftwareTokenParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateSoftwareTokenParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateSoftwareTokenParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UpdateSoftwareTokenParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("access_token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `access_token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("access_token").toString()));
      }
      if (!jsonObj.get("verification_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `verification_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("verification_code").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateSoftwareTokenParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateSoftwareTokenParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateSoftwareTokenParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateSoftwareTokenParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateSoftwareTokenParam>() {
           @Override
           public void write(JsonWriter out, UpdateSoftwareTokenParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateSoftwareTokenParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateSoftwareTokenParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateSoftwareTokenParam
  * @throws IOException if the JSON string is invalid with respect to UpdateSoftwareTokenParam
  */
  public static UpdateSoftwareTokenParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateSoftwareTokenParam.class);
  }

 /**
  * Convert an instance of UpdateSoftwareTokenParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

