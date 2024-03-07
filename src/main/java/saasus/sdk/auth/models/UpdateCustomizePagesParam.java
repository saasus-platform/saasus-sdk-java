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
import saasus.sdk.auth.models.CustomizePageProps;

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
 * UpdateCustomizePagesParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-07T05:43:38.036872771Z[Etc/UTC]")
public class UpdateCustomizePagesParam {
  public static final String SERIALIZED_NAME_SIGN_UP_PAGE = "sign_up_page";
  @SerializedName(SERIALIZED_NAME_SIGN_UP_PAGE)
  private CustomizePageProps signUpPage;

  public static final String SERIALIZED_NAME_SIGN_IN_PAGE = "sign_in_page";
  @SerializedName(SERIALIZED_NAME_SIGN_IN_PAGE)
  private CustomizePageProps signInPage;

  public static final String SERIALIZED_NAME_PASSWORD_RESET_PAGE = "password_reset_page";
  @SerializedName(SERIALIZED_NAME_PASSWORD_RESET_PAGE)
  private CustomizePageProps passwordResetPage;

  public UpdateCustomizePagesParam() {
  }

  public UpdateCustomizePagesParam signUpPage(CustomizePageProps signUpPage) {
    this.signUpPage = signUpPage;
    return this;
  }

   /**
   * Get signUpPage
   * @return signUpPage
  **/
  @javax.annotation.Nullable
  public CustomizePageProps getSignUpPage() {
    return signUpPage;
  }

  public void setSignUpPage(CustomizePageProps signUpPage) {
    this.signUpPage = signUpPage;
  }


  public UpdateCustomizePagesParam signInPage(CustomizePageProps signInPage) {
    this.signInPage = signInPage;
    return this;
  }

   /**
   * Get signInPage
   * @return signInPage
  **/
  @javax.annotation.Nullable
  public CustomizePageProps getSignInPage() {
    return signInPage;
  }

  public void setSignInPage(CustomizePageProps signInPage) {
    this.signInPage = signInPage;
  }


  public UpdateCustomizePagesParam passwordResetPage(CustomizePageProps passwordResetPage) {
    this.passwordResetPage = passwordResetPage;
    return this;
  }

   /**
   * Get passwordResetPage
   * @return passwordResetPage
  **/
  @javax.annotation.Nullable
  public CustomizePageProps getPasswordResetPage() {
    return passwordResetPage;
  }

  public void setPasswordResetPage(CustomizePageProps passwordResetPage) {
    this.passwordResetPage = passwordResetPage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateCustomizePagesParam updateCustomizePagesParam = (UpdateCustomizePagesParam) o;
    return Objects.equals(this.signUpPage, updateCustomizePagesParam.signUpPage) &&
        Objects.equals(this.signInPage, updateCustomizePagesParam.signInPage) &&
        Objects.equals(this.passwordResetPage, updateCustomizePagesParam.passwordResetPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signUpPage, signInPage, passwordResetPage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateCustomizePagesParam {\n");
    sb.append("    signUpPage: ").append(toIndentedString(signUpPage)).append("\n");
    sb.append("    signInPage: ").append(toIndentedString(signInPage)).append("\n");
    sb.append("    passwordResetPage: ").append(toIndentedString(passwordResetPage)).append("\n");
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
    openapiFields.add("sign_up_page");
    openapiFields.add("sign_in_page");
    openapiFields.add("password_reset_page");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateCustomizePagesParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateCustomizePagesParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateCustomizePagesParam is not found in the empty JSON string", UpdateCustomizePagesParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateCustomizePagesParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateCustomizePagesParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `sign_up_page`
      if (jsonObj.get("sign_up_page") != null && !jsonObj.get("sign_up_page").isJsonNull()) {
        CustomizePageProps.validateJsonElement(jsonObj.get("sign_up_page"));
      }
      // validate the optional field `sign_in_page`
      if (jsonObj.get("sign_in_page") != null && !jsonObj.get("sign_in_page").isJsonNull()) {
        CustomizePageProps.validateJsonElement(jsonObj.get("sign_in_page"));
      }
      // validate the optional field `password_reset_page`
      if (jsonObj.get("password_reset_page") != null && !jsonObj.get("password_reset_page").isJsonNull()) {
        CustomizePageProps.validateJsonElement(jsonObj.get("password_reset_page"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateCustomizePagesParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateCustomizePagesParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateCustomizePagesParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateCustomizePagesParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateCustomizePagesParam>() {
           @Override
           public void write(JsonWriter out, UpdateCustomizePagesParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateCustomizePagesParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateCustomizePagesParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateCustomizePagesParam
  * @throws IOException if the JSON string is invalid with respect to UpdateCustomizePagesParam
  */
  public static UpdateCustomizePagesParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateCustomizePagesParam.class);
  }

 /**
  * Convert an instance of UpdateCustomizePagesParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

