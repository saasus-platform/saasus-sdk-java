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
 * UpdateNotificationMessagesParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:08:24.906218523Z[Etc/UTC]")
public class UpdateNotificationMessagesParam {
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

  public UpdateNotificationMessagesParam() {
  }

  public UpdateNotificationMessagesParam signUp(MessageTemplate signUp) {
    this.signUp = signUp;
    return this;
  }

   /**
   * Get signUp
   * @return signUp
  **/
  @javax.annotation.Nullable
  public MessageTemplate getSignUp() {
    return signUp;
  }

  public void setSignUp(MessageTemplate signUp) {
    this.signUp = signUp;
  }


  public UpdateNotificationMessagesParam createUser(MessageTemplate createUser) {
    this.createUser = createUser;
    return this;
  }

   /**
   * Get createUser
   * @return createUser
  **/
  @javax.annotation.Nullable
  public MessageTemplate getCreateUser() {
    return createUser;
  }

  public void setCreateUser(MessageTemplate createUser) {
    this.createUser = createUser;
  }


  public UpdateNotificationMessagesParam resendCode(MessageTemplate resendCode) {
    this.resendCode = resendCode;
    return this;
  }

   /**
   * Get resendCode
   * @return resendCode
  **/
  @javax.annotation.Nullable
  public MessageTemplate getResendCode() {
    return resendCode;
  }

  public void setResendCode(MessageTemplate resendCode) {
    this.resendCode = resendCode;
  }


  public UpdateNotificationMessagesParam forgotPassword(MessageTemplate forgotPassword) {
    this.forgotPassword = forgotPassword;
    return this;
  }

   /**
   * Get forgotPassword
   * @return forgotPassword
  **/
  @javax.annotation.Nullable
  public MessageTemplate getForgotPassword() {
    return forgotPassword;
  }

  public void setForgotPassword(MessageTemplate forgotPassword) {
    this.forgotPassword = forgotPassword;
  }


  public UpdateNotificationMessagesParam updateUserAttribute(MessageTemplate updateUserAttribute) {
    this.updateUserAttribute = updateUserAttribute;
    return this;
  }

   /**
   * Get updateUserAttribute
   * @return updateUserAttribute
  **/
  @javax.annotation.Nullable
  public MessageTemplate getUpdateUserAttribute() {
    return updateUserAttribute;
  }

  public void setUpdateUserAttribute(MessageTemplate updateUserAttribute) {
    this.updateUserAttribute = updateUserAttribute;
  }


  public UpdateNotificationMessagesParam verifyUserAttribute(MessageTemplate verifyUserAttribute) {
    this.verifyUserAttribute = verifyUserAttribute;
    return this;
  }

   /**
   * Get verifyUserAttribute
   * @return verifyUserAttribute
  **/
  @javax.annotation.Nullable
  public MessageTemplate getVerifyUserAttribute() {
    return verifyUserAttribute;
  }

  public void setVerifyUserAttribute(MessageTemplate verifyUserAttribute) {
    this.verifyUserAttribute = verifyUserAttribute;
  }


  public UpdateNotificationMessagesParam authenticationMfa(MessageTemplate authenticationMfa) {
    this.authenticationMfa = authenticationMfa;
    return this;
  }

   /**
   * Get authenticationMfa
   * @return authenticationMfa
  **/
  @javax.annotation.Nullable
  public MessageTemplate getAuthenticationMfa() {
    return authenticationMfa;
  }

  public void setAuthenticationMfa(MessageTemplate authenticationMfa) {
    this.authenticationMfa = authenticationMfa;
  }


  public UpdateNotificationMessagesParam inviteTenantUser(MessageTemplate inviteTenantUser) {
    this.inviteTenantUser = inviteTenantUser;
    return this;
  }

   /**
   * Get inviteTenantUser
   * @return inviteTenantUser
  **/
  @javax.annotation.Nullable
  public MessageTemplate getInviteTenantUser() {
    return inviteTenantUser;
  }

  public void setInviteTenantUser(MessageTemplate inviteTenantUser) {
    this.inviteTenantUser = inviteTenantUser;
  }


  public UpdateNotificationMessagesParam verifyExternalUser(MessageTemplate verifyExternalUser) {
    this.verifyExternalUser = verifyExternalUser;
    return this;
  }

   /**
   * Get verifyExternalUser
   * @return verifyExternalUser
  **/
  @javax.annotation.Nullable
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
    UpdateNotificationMessagesParam updateNotificationMessagesParam = (UpdateNotificationMessagesParam) o;
    return Objects.equals(this.signUp, updateNotificationMessagesParam.signUp) &&
        Objects.equals(this.createUser, updateNotificationMessagesParam.createUser) &&
        Objects.equals(this.resendCode, updateNotificationMessagesParam.resendCode) &&
        Objects.equals(this.forgotPassword, updateNotificationMessagesParam.forgotPassword) &&
        Objects.equals(this.updateUserAttribute, updateNotificationMessagesParam.updateUserAttribute) &&
        Objects.equals(this.verifyUserAttribute, updateNotificationMessagesParam.verifyUserAttribute) &&
        Objects.equals(this.authenticationMfa, updateNotificationMessagesParam.authenticationMfa) &&
        Objects.equals(this.inviteTenantUser, updateNotificationMessagesParam.inviteTenantUser) &&
        Objects.equals(this.verifyExternalUser, updateNotificationMessagesParam.verifyExternalUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signUp, createUser, resendCode, forgotPassword, updateUserAttribute, verifyUserAttribute, authenticationMfa, inviteTenantUser, verifyExternalUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateNotificationMessagesParam {\n");
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
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateNotificationMessagesParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateNotificationMessagesParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateNotificationMessagesParam is not found in the empty JSON string", UpdateNotificationMessagesParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateNotificationMessagesParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateNotificationMessagesParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `sign_up`
      if (jsonObj.get("sign_up") != null && !jsonObj.get("sign_up").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("sign_up"));
      }
      // validate the optional field `create_user`
      if (jsonObj.get("create_user") != null && !jsonObj.get("create_user").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("create_user"));
      }
      // validate the optional field `resend_code`
      if (jsonObj.get("resend_code") != null && !jsonObj.get("resend_code").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("resend_code"));
      }
      // validate the optional field `forgot_password`
      if (jsonObj.get("forgot_password") != null && !jsonObj.get("forgot_password").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("forgot_password"));
      }
      // validate the optional field `update_user_attribute`
      if (jsonObj.get("update_user_attribute") != null && !jsonObj.get("update_user_attribute").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("update_user_attribute"));
      }
      // validate the optional field `verify_user_attribute`
      if (jsonObj.get("verify_user_attribute") != null && !jsonObj.get("verify_user_attribute").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("verify_user_attribute"));
      }
      // validate the optional field `authentication_mfa`
      if (jsonObj.get("authentication_mfa") != null && !jsonObj.get("authentication_mfa").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("authentication_mfa"));
      }
      // validate the optional field `invite_tenant_user`
      if (jsonObj.get("invite_tenant_user") != null && !jsonObj.get("invite_tenant_user").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("invite_tenant_user"));
      }
      // validate the optional field `verify_external_user`
      if (jsonObj.get("verify_external_user") != null && !jsonObj.get("verify_external_user").isJsonNull()) {
        MessageTemplate.validateJsonElement(jsonObj.get("verify_external_user"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateNotificationMessagesParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateNotificationMessagesParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateNotificationMessagesParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateNotificationMessagesParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateNotificationMessagesParam>() {
           @Override
           public void write(JsonWriter out, UpdateNotificationMessagesParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateNotificationMessagesParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateNotificationMessagesParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateNotificationMessagesParam
  * @throws IOException if the JSON string is invalid with respect to UpdateNotificationMessagesParam
  */
  public static UpdateNotificationMessagesParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateNotificationMessagesParam.class);
  }

 /**
  * Convert an instance of UpdateNotificationMessagesParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

