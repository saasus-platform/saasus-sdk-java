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
 * SoftwareTokenSecretCode
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T09:43:05.063392808Z[Etc/UTC]")
public class SoftwareTokenSecretCode {
  public static final String SERIALIZED_NAME_SECRET_CODE = "secret_code";
  @SerializedName(SERIALIZED_NAME_SECRET_CODE)
  private String secretCode;

  public SoftwareTokenSecretCode() {
  }

  public SoftwareTokenSecretCode secretCode(String secretCode) {
    this.secretCode = secretCode;
    return this;
  }

   /**
   * secret code
   * @return secretCode
  **/
  @javax.annotation.Nonnull
  public String getSecretCode() {
    return secretCode;
  }

  public void setSecretCode(String secretCode) {
    this.secretCode = secretCode;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SoftwareTokenSecretCode softwareTokenSecretCode = (SoftwareTokenSecretCode) o;
    return Objects.equals(this.secretCode, softwareTokenSecretCode.secretCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secretCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoftwareTokenSecretCode {\n");
    sb.append("    secretCode: ").append(toIndentedString(secretCode)).append("\n");
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
    openapiFields.add("secret_code");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("secret_code");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SoftwareTokenSecretCode
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SoftwareTokenSecretCode.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SoftwareTokenSecretCode is not found in the empty JSON string", SoftwareTokenSecretCode.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SoftwareTokenSecretCode.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SoftwareTokenSecretCode` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SoftwareTokenSecretCode.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("secret_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `secret_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("secret_code").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SoftwareTokenSecretCode.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SoftwareTokenSecretCode' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SoftwareTokenSecretCode> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SoftwareTokenSecretCode.class));

       return (TypeAdapter<T>) new TypeAdapter<SoftwareTokenSecretCode>() {
           @Override
           public void write(JsonWriter out, SoftwareTokenSecretCode value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SoftwareTokenSecretCode read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SoftwareTokenSecretCode given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SoftwareTokenSecretCode
  * @throws IOException if the JSON string is invalid with respect to SoftwareTokenSecretCode
  */
  public static SoftwareTokenSecretCode fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SoftwareTokenSecretCode.class);
  }

 /**
  * Convert an instance of SoftwareTokenSecretCode to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

