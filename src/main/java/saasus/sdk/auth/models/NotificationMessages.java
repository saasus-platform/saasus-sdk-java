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
import saasus.sdk.auth.models.MessageTemplate;

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
 * NotificationMessages
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-27T08:48:27.914948228Z[Etc/UTC]")
public class NotificationMessages {
  public static final String SERIALIZED_NAME_SIGN_UP = "sign_up";
  @SerializedName(SERIALIZED_NAME_SIGN_UP)
  private MessageTemplate signUp;

  public static final String SERIALIZED_NAME_CREATE_USER = "create_user";
  @SerializedName(SERIALIZED_NAME_CREATE_USER)
  private MessageTemplate createUser;

  public static final String SERIALIZED_NAME_RESEND_CODE = "resend_code";
  @SerializedName(SERIALIZED_NAME_RESEND_CODE)
  private MessageTemplate resendCode;

  public static final String SERIALIZED_NAME_FORGOT_PASSWORD = "forgot_password";
  @SerializedName(SERIALIZED_NAME_FORGOT_PASSWORD)
  private MessageTemplate forgotPassword;

  public static final String SERIALIZED_NAME_UPDATE_USER_ATTRIBUTE = "update_user_attribute";
  @SerializedName(SERIALIZED_NAME_UPDATE_USER_ATTRIBUTE)
  private MessageTemplate updateUserAttribute;

  public static final String SERIALIZED_NAME_VERIFY_USER_ATTRIBUTE = "verify_user_attribute";
  @SerializedName(SERIALIZED_NAME_VERIFY_USER_ATTRIBUTE)
  private MessageTemplate verifyUserAttribute;

  public static final String SERIALIZED_NAME_AUTHENTICATION_MFA = "authentication_mfa";
  @SerializedName(SERIALIZED_NAME_AUTHENTICATION_MFA)
  private MessageTemplate authenticationMfa;

  public static final String SERIALIZED_NAME_INVITE_TENANT_USER = "invite_tenant_user";
  @SerializedName(SERIALIZED_NAME_INVITE_TENANT_USER)
  private MessageTemplate inviteTenantUser;

  public static final String SERIALIZED_NAME_VERIFY_EXTERNAL_USER = "verify_external_user";
  @SerializedName(SERIALIZED_NAME_VERIFY_EXTERNAL_USER)
  private MessageTemplate verifyExternalUser;

  public NotificationMessages() {
  }

  public NotificationMessages signUp(MessageTemplate signUp) {
    this.signUp = signUp;
    return this;
  }

   /**
   * Get signUp
   * @return signUp
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getSignUp() {
    return signUp;
  }

  public void setSignUp(MessageTemplate signUp) {
    this.signUp = signUp;
  }


  public NotificationMessages createUser(MessageTemplate createUser) {
    this.createUser = createUser;
    return this;
  }

   /**
   * Get createUser
   * @return createUser
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getCreateUser() {
    return createUser;
  }

  public void setCreateUser(MessageTemplate createUser) {
    this.createUser = createUser;
  }


  public NotificationMessages resendCode(MessageTemplate resendCode) {
    this.resendCode = resendCode;
    return this;
  }

   /**
   * Get resendCode
   * @return resendCode
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getResendCode() {
    return resendCode;
  }

  public void setResendCode(MessageTemplate resendCode) {
    this.resendCode = resendCode;
  }


  public NotificationMessages forgotPassword(MessageTemplate forgotPassword) {
    this.forgotPassword = forgotPassword;
    return this;
  }

   /**
   * Get forgotPassword
   * @return forgotPassword
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getForgotPassword() {
    return forgotPassword;
  }

  public void setForgotPassword(MessageTemplate forgotPassword) {
    this.forgotPassword = forgotPassword;
  }


  public NotificationMessages updateUserAttribute(MessageTemplate updateUserAttribute) {
    this.updateUserAttribute = updateUserAttribute;
    return this;
  }

   /**
   * Get updateUserAttribute
   * @return updateUserAttribute
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getUpdateUserAttribute() {
    return updateUserAttribute;
  }

  public void setUpdateUserAttribute(MessageTemplate updateUserAttribute) {
    this.updateUserAttribute = updateUserAttribute;
  }


  public NotificationMessages verifyUserAttribute(MessageTemplate verifyUserAttribute) {
    this.verifyUserAttribute = verifyUserAttribute;
    return this;
  }

   /**
   * Get verifyUserAttribute
   * @return verifyUserAttribute
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getVerifyUserAttribute() {
    return verifyUserAttribute;
  }

  public void setVerifyUserAttribute(MessageTemplate verifyUserAttribute) {
    this.verifyUserAttribute = verifyUserAttribute;
  }


  public NotificationMessages authenticationMfa(MessageTemplate authenticationMfa) {
    this.authenticationMfa = authenticationMfa;
    return this;
  }

   /**
   * Get authenticationMfa
   * @return authenticationMfa
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getAuthenticationMfa() {
    return authenticationMfa;
  }

  public void setAuthenticationMfa(MessageTemplate authenticationMfa) {
    this.authenticationMfa = authenticationMfa;
  }


  public NotificationMessages inviteTenantUser(MessageTemplate inviteTenantUser) {
    this.inviteTenantUser = inviteTenantUser;
    return this;
  }

   /**
   * Get inviteTenantUser
   * @return inviteTenantUser
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getInviteTenantUser() {
    return inviteTenantUser;
  }

  public void setInviteTenantUser(MessageTemplate inviteTenantUser) {
    this.inviteTenantUser = inviteTenantUser;
  }


  public NotificationMessages verifyExternalUser(MessageTemplate verifyExternalUser) {
    this.verifyExternalUser = verifyExternalUser;
    return this;
  }

   /**
   * Get verifyExternalUser
   * @return verifyExternalUser
  **/
  @javax.annotation.Nonnull
  public MessageTemplate getVerifyExternalUser() {
    return verifyExternalUser;
  }

  public void setVerifyExternalUser(MessageTemplate verifyExternalUser) {
    this.verifyExternalUser = verifyExternalUser;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationMessages notificationMessages = (NotificationMessages) o;
    return Objects.equals(this.signUp, notificationMessages.signUp) &&
        Objects.equals(this.createUser, notificationMessages.createUser) &&
        Objects.equals(this.resendCode, notificationMessages.resendCode) &&
        Objects.equals(this.forgotPassword, notificationMessages.forgotPassword) &&
        Objects.equals(this.updateUserAttribute, notificationMessages.updateUserAttribute) &&
        Objects.equals(this.verifyUserAttribute, notificationMessages.verifyUserAttribute) &&
        Objects.equals(this.authenticationMfa, notificationMessages.authenticationMfa) &&
        Objects.equals(this.inviteTenantUser, notificationMessages.inviteTenantUser) &&
        Objects.equals(this.verifyExternalUser, notificationMessages.verifyExternalUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signUp, createUser, resendCode, forgotPassword, updateUserAttribute, verifyUserAttribute, authenticationMfa, inviteTenantUser, verifyExternalUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationMessages {\n");
    sb.append("    signUp: ").append(toIndentedString(signUp)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    resendCode: ").append(toIndentedString(resendCode)).append("\n");
    sb.append("    forgotPassword: ").append(toIndentedString(forgotPassword)).append("\n");
    sb.append("    updateUserAttribute: ").append(toIndentedString(updateUserAttribute)).append("\n");
    sb.append("    verifyUserAttribute: ").append(toIndentedString(verifyUserAttribute)).append("\n");
    sb.append("    authenticationMfa: ").append(toIndentedString(authenticationMfa)).append("\n");
    sb.append("    inviteTenantUser: ").append(toIndentedString(inviteTenantUser)).append("\n");
    sb.append("    verifyExternalUser: ").append(toIndentedString(verifyExternalUser)).append("\n");
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
    openapiFields.add("sign_up");
    openapiFields.add("create_user");
    openapiFields.add("resend_code");
    openapiFields.add("forgot_password");
    openapiFields.add("update_user_attribute");
    openapiFields.add("verify_user_attribute");
    openapiFields.add("authentication_mfa");
    openapiFields.add("invite_tenant_user");
    openapiFields.add("verify_external_user");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("sign_up");
    openapiRequiredFields.add("create_user");
    openapiRequiredFields.add("resend_code");
    openapiRequiredFields.add("forgot_password");
    openapiRequiredFields.add("update_user_attribute");
    openapiRequiredFields.add("verify_user_attribute");
    openapiRequiredFields.add("authentication_mfa");
    openapiRequiredFields.add("invite_tenant_user");
    openapiRequiredFields.add("verify_external_user");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to NotificationMessages
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!NotificationMessages.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in NotificationMessages is not found in the empty JSON string", NotificationMessages.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!NotificationMessages.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `NotificationMessages` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : NotificationMessages.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `sign_up`
      MessageTemplate.validateJsonElement(jsonObj.get("sign_up"));
      // validate the required field `create_user`
      MessageTemplate.validateJsonElement(jsonObj.get("create_user"));
      // validate the required field `resend_code`
      MessageTemplate.validateJsonElement(jsonObj.get("resend_code"));
      // validate the required field `forgot_password`
      MessageTemplate.validateJsonElement(jsonObj.get("forgot_password"));
      // validate the required field `update_user_attribute`
      MessageTemplate.validateJsonElement(jsonObj.get("update_user_attribute"));
      // validate the required field `verify_user_attribute`
      MessageTemplate.validateJsonElement(jsonObj.get("verify_user_attribute"));
      // validate the required field `authentication_mfa`
      MessageTemplate.validateJsonElement(jsonObj.get("authentication_mfa"));
      // validate the required field `invite_tenant_user`
      MessageTemplate.validateJsonElement(jsonObj.get("invite_tenant_user"));
      // validate the required field `verify_external_user`
      MessageTemplate.validateJsonElement(jsonObj.get("verify_external_user"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!NotificationMessages.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'NotificationMessages' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<NotificationMessages> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(NotificationMessages.class));

       return (TypeAdapter<T>) new TypeAdapter<NotificationMessages>() {
           @Override
           public void write(JsonWriter out, NotificationMessages value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public NotificationMessages read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of NotificationMessages given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of NotificationMessages
  * @throws IOException if the JSON string is invalid with respect to NotificationMessages
  */
  public static NotificationMessages fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, NotificationMessages.class);
  }

 /**
  * Convert an instance of NotificationMessages to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

