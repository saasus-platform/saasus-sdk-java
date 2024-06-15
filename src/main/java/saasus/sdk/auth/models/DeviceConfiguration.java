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
 * Settings for remembering trusted devices
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-15T13:42:12.890801135Z[Etc/UTC]")
public class DeviceConfiguration {
  /**
   * always: always remember userOptIn: user opt-in no: don&#39;t save 
   */
  @JsonAdapter(DeviceRememberingEnum.Adapter.class)
  public enum DeviceRememberingEnum {
    ALWAYS("always"),
    
    USEROPTIN("userOptIn"),
    
    NO("no");

    private String value;

    DeviceRememberingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DeviceRememberingEnum fromValue(String value) {
      for (DeviceRememberingEnum b : DeviceRememberingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DeviceRememberingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DeviceRememberingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DeviceRememberingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DeviceRememberingEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      DeviceRememberingEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_DEVICE_REMEMBERING = "device_remembering";
  @SerializedName(SERIALIZED_NAME_DEVICE_REMEMBERING)
  private DeviceRememberingEnum deviceRemembering;

  public DeviceConfiguration() {
  }

  public DeviceConfiguration deviceRemembering(DeviceRememberingEnum deviceRemembering) {
    this.deviceRemembering = deviceRemembering;
    return this;
  }

   /**
   * always: always remember userOptIn: user opt-in no: don&#39;t save 
   * @return deviceRemembering
  **/
  @javax.annotation.Nonnull
  public DeviceRememberingEnum getDeviceRemembering() {
    return deviceRemembering;
  }

  public void setDeviceRemembering(DeviceRememberingEnum deviceRemembering) {
    this.deviceRemembering = deviceRemembering;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceConfiguration deviceConfiguration = (DeviceConfiguration) o;
    return Objects.equals(this.deviceRemembering, deviceConfiguration.deviceRemembering);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceRemembering);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeviceConfiguration {\n");
    sb.append("    deviceRemembering: ").append(toIndentedString(deviceRemembering)).append("\n");
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
    openapiFields.add("device_remembering");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("device_remembering");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to DeviceConfiguration
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!DeviceConfiguration.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DeviceConfiguration is not found in the empty JSON string", DeviceConfiguration.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!DeviceConfiguration.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DeviceConfiguration` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : DeviceConfiguration.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("device_remembering").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `device_remembering` to be a primitive type in the JSON string but got `%s`", jsonObj.get("device_remembering").toString()));
      }
      // validate the required field `device_remembering`
      DeviceRememberingEnum.validateJsonElement(jsonObj.get("device_remembering"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DeviceConfiguration.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DeviceConfiguration' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DeviceConfiguration> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DeviceConfiguration.class));

       return (TypeAdapter<T>) new TypeAdapter<DeviceConfiguration>() {
           @Override
           public void write(JsonWriter out, DeviceConfiguration value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DeviceConfiguration read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DeviceConfiguration given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DeviceConfiguration
  * @throws IOException if the JSON string is invalid with respect to DeviceConfiguration
  */
  public static DeviceConfiguration fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DeviceConfiguration.class);
  }

 /**
  * Convert an instance of DeviceConfiguration to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

