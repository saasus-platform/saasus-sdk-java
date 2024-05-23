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
 * CustomizePages
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-23T12:17:13.780770927Z[Etc/UTC]")
public class CustomizePages {
  public static final String SERIALIZED_NAME_SIGN_UP_PAGE = "sign_up_page";
  @SerializedName(SERIALIZED_NAME_SIGN_UP_PAGE)
  private CustomizePageProps signUpPage;

  public static final String SERIALIZED_NAME_SIGN_IN_PAGE = "sign_in_page";
  @SerializedName(SERIALIZED_NAME_SIGN_IN_PAGE)
  private CustomizePageProps signInPage;

  public static final String SERIALIZED_NAME_PASSWORD_RESET_PAGE = "password_reset_page";
  @SerializedName(SERIALIZED_NAME_PASSWORD_RESET_PAGE)
  private CustomizePageProps passwordResetPage;

  public CustomizePages() {
  }

  public CustomizePages signUpPage(CustomizePageProps signUpPage) {
    this.signUpPage = signUpPage;
    return this;
  }

   /**
   * Get signUpPage
   * @return signUpPage
  **/
  @javax.annotation.Nonnull
  public CustomizePageProps getSignUpPage() {
    return signUpPage;
  }

  public void setSignUpPage(CustomizePageProps signUpPage) {
    this.signUpPage = signUpPage;
  }


  public CustomizePages signInPage(CustomizePageProps signInPage) {
    this.signInPage = signInPage;
    return this;
  }

   /**
   * Get signInPage
   * @return signInPage
  **/
  @javax.annotation.Nonnull
  public CustomizePageProps getSignInPage() {
    return signInPage;
  }

  public void setSignInPage(CustomizePageProps signInPage) {
    this.signInPage = signInPage;
  }


  public CustomizePages passwordResetPage(CustomizePageProps passwordResetPage) {
    this.passwordResetPage = passwordResetPage;
    return this;
  }

   /**
   * Get passwordResetPage
   * @return passwordResetPage
  **/
  @javax.annotation.Nonnull
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
    CustomizePages customizePages = (CustomizePages) o;
    return Objects.equals(this.signUpPage, customizePages.signUpPage) &&
        Objects.equals(this.signInPage, customizePages.signInPage) &&
        Objects.equals(this.passwordResetPage, customizePages.passwordResetPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signUpPage, signInPage, passwordResetPage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomizePages {\n");
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
    openapiRequiredFields.add("sign_up_page");
    openapiRequiredFields.add("sign_in_page");
    openapiRequiredFields.add("password_reset_page");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CustomizePages
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CustomizePages.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CustomizePages is not found in the empty JSON string", CustomizePages.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CustomizePages.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CustomizePages` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CustomizePages.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `sign_up_page`
      CustomizePageProps.validateJsonElement(jsonObj.get("sign_up_page"));
      // validate the required field `sign_in_page`
      CustomizePageProps.validateJsonElement(jsonObj.get("sign_in_page"));
      // validate the required field `password_reset_page`
      CustomizePageProps.validateJsonElement(jsonObj.get("password_reset_page"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CustomizePages.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CustomizePages' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CustomizePages> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CustomizePages.class));

       return (TypeAdapter<T>) new TypeAdapter<CustomizePages>() {
           @Override
           public void write(JsonWriter out, CustomizePages value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CustomizePages read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CustomizePages given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CustomizePages
  * @throws IOException if the JSON string is invalid with respect to CustomizePages
  */
  public static CustomizePages fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CustomizePages.class);
  }

 /**
  * Convert an instance of CustomizePages to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

