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
import saasus.sdk.auth.models.IdentityProviderConfiguration;
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
 * SignInSettings
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-09T09:10:50.445997561Z[Etc/UTC]")
public class SignInSettings {
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

  public static final String SERIALIZED_NAME_IDENTITY_PROVIDER_CONFIGURATION = "identity_provider_configuration";
  @SerializedName(SERIALIZED_NAME_IDENTITY_PROVIDER_CONFIGURATION)
  private IdentityProviderConfiguration identityProviderConfiguration;

  public SignInSettings() {
  }

  public SignInSettings passwordPolicy(PasswordPolicy passwordPolicy) {
    this.passwordPolicy = passwordPolicy;
    return this;
  }

   /**
   * Get passwordPolicy
   * @return passwordPolicy
  **/
  @javax.annotation.Nonnull
  public PasswordPolicy getPasswordPolicy() {
    return passwordPolicy;
  }

  public void setPasswordPolicy(PasswordPolicy passwordPolicy) {
    this.passwordPolicy = passwordPolicy;
  }


  public SignInSettings deviceConfiguration(DeviceConfiguration deviceConfiguration) {
    this.deviceConfiguration = deviceConfiguration;
    return this;
  }

   /**
   * Get deviceConfiguration
   * @return deviceConfiguration
  **/
  @javax.annotation.Nonnull
  public DeviceConfiguration getDeviceConfiguration() {
    return deviceConfiguration;
  }

  public void setDeviceConfiguration(DeviceConfiguration deviceConfiguration) {
    this.deviceConfiguration = deviceConfiguration;
  }


  public SignInSettings mfaConfiguration(MfaConfiguration mfaConfiguration) {
    this.mfaConfiguration = mfaConfiguration;
    return this;
  }

   /**
   * Get mfaConfiguration
   * @return mfaConfiguration
  **/
  @javax.annotation.Nonnull
  public MfaConfiguration getMfaConfiguration() {
    return mfaConfiguration;
  }

  public void setMfaConfiguration(MfaConfiguration mfaConfiguration) {
    this.mfaConfiguration = mfaConfiguration;
  }


  public SignInSettings recaptchaProps(RecaptchaProps recaptchaProps) {
    this.recaptchaProps = recaptchaProps;
    return this;
  }

   /**
   * Get recaptchaProps
   * @return recaptchaProps
  **/
  @javax.annotation.Nonnull
  public RecaptchaProps getRecaptchaProps() {
    return recaptchaProps;
  }

  public void setRecaptchaProps(RecaptchaProps recaptchaProps) {
    this.recaptchaProps = recaptchaProps;
  }


  public SignInSettings accountVerification(AccountVerification accountVerification) {
    this.accountVerification = accountVerification;
    return this;
  }

   /**
   * Get accountVerification
   * @return accountVerification
  **/
  @javax.annotation.Nonnull
  public AccountVerification getAccountVerification() {
    return accountVerification;
  }

  public void setAccountVerification(AccountVerification accountVerification) {
    this.accountVerification = accountVerification;
  }


  public SignInSettings selfRegist(SelfRegist selfRegist) {
    this.selfRegist = selfRegist;
    return this;
  }

   /**
   * Get selfRegist
   * @return selfRegist
  **/
  @javax.annotation.Nonnull
  public SelfRegist getSelfRegist() {
    return selfRegist;
  }

  public void setSelfRegist(SelfRegist selfRegist) {
    this.selfRegist = selfRegist;
  }


  public SignInSettings identityProviderConfiguration(IdentityProviderConfiguration identityProviderConfiguration) {
    this.identityProviderConfiguration = identityProviderConfiguration;
    return this;
  }

   /**
   * Get identityProviderConfiguration
   * @return identityProviderConfiguration
  **/
  @javax.annotation.Nonnull
  public IdentityProviderConfiguration getIdentityProviderConfiguration() {
    return identityProviderConfiguration;
  }

  public void setIdentityProviderConfiguration(IdentityProviderConfiguration identityProviderConfiguration) {
    this.identityProviderConfiguration = identityProviderConfiguration;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignInSettings signInSettings = (SignInSettings) o;
    return Objects.equals(this.passwordPolicy, signInSettings.passwordPolicy) &&
        Objects.equals(this.deviceConfiguration, signInSettings.deviceConfiguration) &&
        Objects.equals(this.mfaConfiguration, signInSettings.mfaConfiguration) &&
        Objects.equals(this.recaptchaProps, signInSettings.recaptchaProps) &&
        Objects.equals(this.accountVerification, signInSettings.accountVerification) &&
        Objects.equals(this.selfRegist, signInSettings.selfRegist) &&
        Objects.equals(this.identityProviderConfiguration, signInSettings.identityProviderConfiguration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passwordPolicy, deviceConfiguration, mfaConfiguration, recaptchaProps, accountVerification, selfRegist, identityProviderConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignInSettings {\n");
    sb.append("    passwordPolicy: ").append(toIndentedString(passwordPolicy)).append("\n");
    sb.append("    deviceConfiguration: ").append(toIndentedString(deviceConfiguration)).append("\n");
    sb.append("    mfaConfiguration: ").append(toIndentedString(mfaConfiguration)).append("\n");
    sb.append("    recaptchaProps: ").append(toIndentedString(recaptchaProps)).append("\n");
    sb.append("    accountVerification: ").append(toIndentedString(accountVerification)).append("\n");
    sb.append("    selfRegist: ").append(toIndentedString(selfRegist)).append("\n");
    sb.append("    identityProviderConfiguration: ").append(toIndentedString(identityProviderConfiguration)).append("\n");
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
    openapiFields.add("identity_provider_configuration");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("password_policy");
    openapiRequiredFields.add("device_configuration");
    openapiRequiredFields.add("mfa_configuration");
    openapiRequiredFields.add("recaptcha_props");
    openapiRequiredFields.add("account_verification");
    openapiRequiredFields.add("self_regist");
    openapiRequiredFields.add("identity_provider_configuration");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SignInSettings
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SignInSettings.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SignInSettings is not found in the empty JSON string", SignInSettings.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SignInSettings.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SignInSettings` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SignInSettings.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `password_policy`
      PasswordPolicy.validateJsonElement(jsonObj.get("password_policy"));
      // validate the required field `device_configuration`
      DeviceConfiguration.validateJsonElement(jsonObj.get("device_configuration"));
      // validate the required field `mfa_configuration`
      MfaConfiguration.validateJsonElement(jsonObj.get("mfa_configuration"));
      // validate the required field `recaptcha_props`
      RecaptchaProps.validateJsonElement(jsonObj.get("recaptcha_props"));
      // validate the required field `account_verification`
      AccountVerification.validateJsonElement(jsonObj.get("account_verification"));
      // validate the required field `self_regist`
      SelfRegist.validateJsonElement(jsonObj.get("self_regist"));
      // validate the required field `identity_provider_configuration`
      IdentityProviderConfiguration.validateJsonElement(jsonObj.get("identity_provider_configuration"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SignInSettings.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SignInSettings' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SignInSettings> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SignInSettings.class));

       return (TypeAdapter<T>) new TypeAdapter<SignInSettings>() {
           @Override
           public void write(JsonWriter out, SignInSettings value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SignInSettings read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SignInSettings given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SignInSettings
  * @throws IOException if the JSON string is invalid with respect to SignInSettings
  */
  public static SignInSettings fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SignInSettings.class);
  }

 /**
  * Convert an instance of SignInSettings to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

