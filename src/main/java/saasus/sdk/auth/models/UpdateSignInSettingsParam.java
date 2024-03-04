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
import saasus.sdk.auth.models.AccountVerification;
import saasus.sdk.auth.models.DeviceConfiguration;
import saasus.sdk.auth.models.MfaConfiguration;
import saasus.sdk.auth.models.PasswordPolicy;
import saasus.sdk.auth.models.RecaptchaProps;
import saasus.sdk.auth.models.SelfRegist;

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
 * UpdateSignInSettingsParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-04T15:36:36.586460884Z[Etc/UTC]")
public class UpdateSignInSettingsParam {
  public static final String SERIALIZED_NAME_PASSWORD_POLICY = "password_policy";
  @SerializedName(SERIALIZED_NAME_PASSWORD_POLICY)
  private PasswordPolicy passwordPolicy;

  public static final String SERIALIZED_NAME_DEVICE_CONFIGURATION = "device_configuration";
  @SerializedName(SERIALIZED_NAME_DEVICE_CONFIGURATION)
  private DeviceConfiguration deviceConfiguration;

  public static final String SERIALIZED_NAME_MFA_CONFIGURATION = "mfa_configuration";
  @SerializedName(SERIALIZED_NAME_MFA_CONFIGURATION)
  private MfaConfiguration mfaConfiguration;

  public static final String SERIALIZED_NAME_RECAPTCHA_PROPS = "recaptcha_props";
  @SerializedName(SERIALIZED_NAME_RECAPTCHA_PROPS)
  private RecaptchaProps recaptchaProps;

  public static final String SERIALIZED_NAME_ACCOUNT_VERIFICATION = "account_verification";
  @SerializedName(SERIALIZED_NAME_ACCOUNT_VERIFICATION)
  private AccountVerification accountVerification;

  public static final String SERIALIZED_NAME_SELF_REGIST = "self_regist";
  @SerializedName(SERIALIZED_NAME_SELF_REGIST)
  private SelfRegist selfRegist;

  public UpdateSignInSettingsParam() {
  }

  public UpdateSignInSettingsParam passwordPolicy(PasswordPolicy passwordPolicy) {
    this.passwordPolicy = passwordPolicy;
    return this;
  }

   /**
   * Get passwordPolicy
   * @return passwordPolicy
  **/
  @javax.annotation.Nullable
  public PasswordPolicy getPasswordPolicy() {
    return passwordPolicy;
  }

  public void setPasswordPolicy(PasswordPolicy passwordPolicy) {
    this.passwordPolicy = passwordPolicy;
  }


  public UpdateSignInSettingsParam deviceConfiguration(DeviceConfiguration deviceConfiguration) {
    this.deviceConfiguration = deviceConfiguration;
    return this;
  }

   /**
   * Get deviceConfiguration
   * @return deviceConfiguration
  **/
  @javax.annotation.Nullable
  public DeviceConfiguration getDeviceConfiguration() {
    return deviceConfiguration;
  }

  public void setDeviceConfiguration(DeviceConfiguration deviceConfiguration) {
    this.deviceConfiguration = deviceConfiguration;
  }


  public UpdateSignInSettingsParam mfaConfiguration(MfaConfiguration mfaConfiguration) {
    this.mfaConfiguration = mfaConfiguration;
    return this;
  }

   /**
   * Get mfaConfiguration
   * @return mfaConfiguration
  **/
  @javax.annotation.Nullable
  public MfaConfiguration getMfaConfiguration() {
    return mfaConfiguration;
  }

  public void setMfaConfiguration(MfaConfiguration mfaConfiguration) {
    this.mfaConfiguration = mfaConfiguration;
  }


  public UpdateSignInSettingsParam recaptchaProps(RecaptchaProps recaptchaProps) {
    this.recaptchaProps = recaptchaProps;
    return this;
  }

   /**
   * Get recaptchaProps
   * @return recaptchaProps
  **/
  @javax.annotation.Nullable
  public RecaptchaProps getRecaptchaProps() {
    return recaptchaProps;
  }

  public void setRecaptchaProps(RecaptchaProps recaptchaProps) {
    this.recaptchaProps = recaptchaProps;
  }


  public UpdateSignInSettingsParam accountVerification(AccountVerification accountVerification) {
    this.accountVerification = accountVerification;
    return this;
  }

   /**
   * Get accountVerification
   * @return accountVerification
  **/
  @javax.annotation.Nullable
  public AccountVerification getAccountVerification() {
    return accountVerification;
  }

  public void setAccountVerification(AccountVerification accountVerification) {
    this.accountVerification = accountVerification;
  }


  public UpdateSignInSettingsParam selfRegist(SelfRegist selfRegist) {
    this.selfRegist = selfRegist;
    return this;
  }

   /**
   * Get selfRegist
   * @return selfRegist
  **/
  @javax.annotation.Nullable
  public SelfRegist getSelfRegist() {
    return selfRegist;
  }

  public void setSelfRegist(SelfRegist selfRegist) {
    this.selfRegist = selfRegist;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSignInSettingsParam updateSignInSettingsParam = (UpdateSignInSettingsParam) o;
    return Objects.equals(this.passwordPolicy, updateSignInSettingsParam.passwordPolicy) &&
        Objects.equals(this.deviceConfiguration, updateSignInSettingsParam.deviceConfiguration) &&
        Objects.equals(this.mfaConfiguration, updateSignInSettingsParam.mfaConfiguration) &&
        Objects.equals(this.recaptchaProps, updateSignInSettingsParam.recaptchaProps) &&
        Objects.equals(this.accountVerification, updateSignInSettingsParam.accountVerification) &&
        Objects.equals(this.selfRegist, updateSignInSettingsParam.selfRegist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passwordPolicy, deviceConfiguration, mfaConfiguration, recaptchaProps, accountVerification, selfRegist);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSignInSettingsParam {\n");
    sb.append("    passwordPolicy: ").append(toIndentedString(passwordPolicy)).append("\n");
    sb.append("    deviceConfiguration: ").append(toIndentedString(deviceConfiguration)).append("\n");
    sb.append("    mfaConfiguration: ").append(toIndentedString(mfaConfiguration)).append("\n");
    sb.append("    recaptchaProps: ").append(toIndentedString(recaptchaProps)).append("\n");
    sb.append("    accountVerification: ").append(toIndentedString(accountVerification)).append("\n");
    sb.append("    selfRegist: ").append(toIndentedString(selfRegist)).append("\n");
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
    openapiFields.add("password_policy");
    openapiFields.add("device_configuration");
    openapiFields.add("mfa_configuration");
    openapiFields.add("recaptcha_props");
    openapiFields.add("account_verification");
    openapiFields.add("self_regist");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateSignInSettingsParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateSignInSettingsParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateSignInSettingsParam is not found in the empty JSON string", UpdateSignInSettingsParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateSignInSettingsParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateSignInSettingsParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `password_policy`
      if (jsonObj.get("password_policy") != null && !jsonObj.get("password_policy").isJsonNull()) {
        PasswordPolicy.validateJsonElement(jsonObj.get("password_policy"));
      }
      // validate the optional field `device_configuration`
      if (jsonObj.get("device_configuration") != null && !jsonObj.get("device_configuration").isJsonNull()) {
        DeviceConfiguration.validateJsonElement(jsonObj.get("device_configuration"));
      }
      // validate the optional field `mfa_configuration`
      if (jsonObj.get("mfa_configuration") != null && !jsonObj.get("mfa_configuration").isJsonNull()) {
        MfaConfiguration.validateJsonElement(jsonObj.get("mfa_configuration"));
      }
      // validate the optional field `recaptcha_props`
      if (jsonObj.get("recaptcha_props") != null && !jsonObj.get("recaptcha_props").isJsonNull()) {
        RecaptchaProps.validateJsonElement(jsonObj.get("recaptcha_props"));
      }
      // validate the optional field `account_verification`
      if (jsonObj.get("account_verification") != null && !jsonObj.get("account_verification").isJsonNull()) {
        AccountVerification.validateJsonElement(jsonObj.get("account_verification"));
      }
      // validate the optional field `self_regist`
      if (jsonObj.get("self_regist") != null && !jsonObj.get("self_regist").isJsonNull()) {
        SelfRegist.validateJsonElement(jsonObj.get("self_regist"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateSignInSettingsParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateSignInSettingsParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateSignInSettingsParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateSignInSettingsParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateSignInSettingsParam>() {
           @Override
           public void write(JsonWriter out, UpdateSignInSettingsParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateSignInSettingsParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateSignInSettingsParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateSignInSettingsParam
  * @throws IOException if the JSON string is invalid with respect to UpdateSignInSettingsParam
  */
  public static UpdateSignInSettingsParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateSignInSettingsParam.class);
  }

 /**
  * Convert an instance of UpdateSignInSettingsParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

