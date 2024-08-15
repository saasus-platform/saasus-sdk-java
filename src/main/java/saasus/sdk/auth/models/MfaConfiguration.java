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
 * MFA device authentication settings ※ This function is not yet provided, so it cannot be changed or saved. 
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-15T08:29:53.195185360Z[Etc/UTC]")
public class MfaConfiguration {
  /**
   * on: apply when all users log in optional: apply to individual users with MFA factor enabled ※ The parameter is currently optional and fixed. 
   */
  @JsonAdapter(MfaConfigurationEnum.Adapter.class)
  public enum MfaConfigurationEnum {
    ON("on"),
    
    OPTIONAL("optional");

    private String value;

    MfaConfigurationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MfaConfigurationEnum fromValue(String value) {
      for (MfaConfigurationEnum b : MfaConfigurationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MfaConfigurationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MfaConfigurationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MfaConfigurationEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return MfaConfigurationEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      MfaConfigurationEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_MFA_CONFIGURATION = "mfa_configuration";
  @SerializedName(SERIALIZED_NAME_MFA_CONFIGURATION)
  private MfaConfigurationEnum mfaConfiguration;

  public MfaConfiguration() {
  }

  public MfaConfiguration mfaConfiguration(MfaConfigurationEnum mfaConfiguration) {
    this.mfaConfiguration = mfaConfiguration;
    return this;
  }

   /**
   * on: apply when all users log in optional: apply to individual users with MFA factor enabled ※ The parameter is currently optional and fixed. 
   * @return mfaConfiguration
  **/
  @javax.annotation.Nonnull
  public MfaConfigurationEnum getMfaConfiguration() {
    return mfaConfiguration;
  }

  public void setMfaConfiguration(MfaConfigurationEnum mfaConfiguration) {
    this.mfaConfiguration = mfaConfiguration;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MfaConfiguration mfaConfiguration = (MfaConfiguration) o;
    return Objects.equals(this.mfaConfiguration, mfaConfiguration.mfaConfiguration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mfaConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MfaConfiguration {\n");
    sb.append("    mfaConfiguration: ").append(toIndentedString(mfaConfiguration)).append("\n");
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
    openapiFields.add("mfa_configuration");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("mfa_configuration");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to MfaConfiguration
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!MfaConfiguration.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in MfaConfiguration is not found in the empty JSON string", MfaConfiguration.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!MfaConfiguration.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `MfaConfiguration` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : MfaConfiguration.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("mfa_configuration").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mfa_configuration` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mfa_configuration").toString()));
      }
      // validate the required field `mfa_configuration`
      MfaConfigurationEnum.validateJsonElement(jsonObj.get("mfa_configuration"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!MfaConfiguration.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'MfaConfiguration' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<MfaConfiguration> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(MfaConfiguration.class));

       return (TypeAdapter<T>) new TypeAdapter<MfaConfiguration>() {
           @Override
           public void write(JsonWriter out, MfaConfiguration value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public MfaConfiguration read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of MfaConfiguration given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of MfaConfiguration
  * @throws IOException if the JSON string is invalid with respect to MfaConfiguration
  */
  public static MfaConfiguration fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MfaConfiguration.class);
  }

 /**
  * Convert an instance of MfaConfiguration to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

