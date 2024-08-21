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
 * Account authentication settings ※ This function is not yet provided, so it cannot be changed or saved. 
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-21T01:53:19.017419721Z[Etc/UTC]")
public class AccountVerification {
  /**
   * code: verification code link: verification link ※ This function is not yet provided, so it cannot be changed or saved. 
   */
  @JsonAdapter(VerificationMethodEnum.Adapter.class)
  public enum VerificationMethodEnum {
    CODE("code"),
    
    LINK("link");

    private String value;

    VerificationMethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static VerificationMethodEnum fromValue(String value) {
      for (VerificationMethodEnum b : VerificationMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<VerificationMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final VerificationMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public VerificationMethodEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return VerificationMethodEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      VerificationMethodEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_VERIFICATION_METHOD = "verification_method";
  @SerializedName(SERIALIZED_NAME_VERIFICATION_METHOD)
  private VerificationMethodEnum verificationMethod;

  /**
   * email: e-mail sms: SMS smsOrEmail: email if SMS is not possible 
   */
  @JsonAdapter(SendingToEnum.Adapter.class)
  public enum SendingToEnum {
    EMAIL("email"),
    
    SMS("sms"),
    
    SMSOREMAIL("smsOrEmail");

    private String value;

    SendingToEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SendingToEnum fromValue(String value) {
      for (SendingToEnum b : SendingToEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<SendingToEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SendingToEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SendingToEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return SendingToEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      SendingToEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_SENDING_TO = "sending_to";
  @SerializedName(SERIALIZED_NAME_SENDING_TO)
  private SendingToEnum sendingTo;

  public AccountVerification() {
  }

  public AccountVerification verificationMethod(VerificationMethodEnum verificationMethod) {
    this.verificationMethod = verificationMethod;
    return this;
  }

   /**
   * code: verification code link: verification link ※ This function is not yet provided, so it cannot be changed or saved. 
   * @return verificationMethod
  **/
  @javax.annotation.Nonnull
  public VerificationMethodEnum getVerificationMethod() {
    return verificationMethod;
  }

  public void setVerificationMethod(VerificationMethodEnum verificationMethod) {
    this.verificationMethod = verificationMethod;
  }


  public AccountVerification sendingTo(SendingToEnum sendingTo) {
    this.sendingTo = sendingTo;
    return this;
  }

   /**
   * email: e-mail sms: SMS smsOrEmail: email if SMS is not possible 
   * @return sendingTo
  **/
  @javax.annotation.Nonnull
  public SendingToEnum getSendingTo() {
    return sendingTo;
  }

  public void setSendingTo(SendingToEnum sendingTo) {
    this.sendingTo = sendingTo;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the AccountVerification instance itself
   */
  public AccountVerification putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountVerification accountVerification = (AccountVerification) o;
    return Objects.equals(this.verificationMethod, accountVerification.verificationMethod) &&
        Objects.equals(this.sendingTo, accountVerification.sendingTo)&&
        Objects.equals(this.additionalProperties, accountVerification.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(verificationMethod, sendingTo, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountVerification {\n");
    sb.append("    verificationMethod: ").append(toIndentedString(verificationMethod)).append("\n");
    sb.append("    sendingTo: ").append(toIndentedString(sendingTo)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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
    openapiFields.add("verification_method");
    openapiFields.add("sending_to");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("verification_method");
    openapiRequiredFields.add("sending_to");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to AccountVerification
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!AccountVerification.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in AccountVerification is not found in the empty JSON string", AccountVerification.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : AccountVerification.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("verification_method").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `verification_method` to be a primitive type in the JSON string but got `%s`", jsonObj.get("verification_method").toString()));
      }
      // validate the required field `verification_method`
      VerificationMethodEnum.validateJsonElement(jsonObj.get("verification_method"));
      if (!jsonObj.get("sending_to").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sending_to` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sending_to").toString()));
      }
      // validate the required field `sending_to`
      SendingToEnum.validateJsonElement(jsonObj.get("sending_to"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!AccountVerification.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'AccountVerification' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<AccountVerification> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(AccountVerification.class));

       return (TypeAdapter<T>) new TypeAdapter<AccountVerification>() {
           @Override
           public void write(JsonWriter out, AccountVerification value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additional properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public AccountVerification read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             JsonObject jsonObj = jsonElement.getAsJsonObject();
             // store additional fields in the deserialized instance
             AccountVerification instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of AccountVerification given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of AccountVerification
  * @throws IOException if the JSON string is invalid with respect to AccountVerification
  */
  public static AccountVerification fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, AccountVerification.class);
  }

 /**
  * Convert an instance of AccountVerification to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

