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
 * UpdateBasicInfoParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-18T06:13:20.737609438Z[Etc/UTC]")
public class UpdateBasicInfoParam {
  public static final String SERIALIZED_NAME_DOMAIN_NAME = "domain_name";
  @SerializedName(SERIALIZED_NAME_DOMAIN_NAME)
  private String domainName;

  public static final String SERIALIZED_NAME_FROM_EMAIL_ADDRESS = "from_email_address";
  @SerializedName(SERIALIZED_NAME_FROM_EMAIL_ADDRESS)
  private String fromEmailAddress;

  public static final String SERIALIZED_NAME_REPLY_EMAIL_ADDRESS = "reply_email_address";
  @SerializedName(SERIALIZED_NAME_REPLY_EMAIL_ADDRESS)
  private String replyEmailAddress;

  public UpdateBasicInfoParam() {
  }

  public UpdateBasicInfoParam domainName(String domainName) {
    this.domainName = domainName;
    return this;
  }

   /**
   * Domain Name
   * @return domainName
  **/
  @javax.annotation.Nonnull
  public String getDomainName() {
    return domainName;
  }

  public void setDomainName(String domainName) {
    this.domainName = domainName;
  }


  public UpdateBasicInfoParam fromEmailAddress(String fromEmailAddress) {
    this.fromEmailAddress = fromEmailAddress;
    return this;
  }

   /**
   * Sender email of authentication email
   * @return fromEmailAddress
  **/
  @javax.annotation.Nonnull
  public String getFromEmailAddress() {
    return fromEmailAddress;
  }

  public void setFromEmailAddress(String fromEmailAddress) {
    this.fromEmailAddress = fromEmailAddress;
  }


  public UpdateBasicInfoParam replyEmailAddress(String replyEmailAddress) {
    this.replyEmailAddress = replyEmailAddress;
    return this;
  }

   /**
   * Reply-from email address of authentication email
   * @return replyEmailAddress
  **/
  @javax.annotation.Nullable
  public String getReplyEmailAddress() {
    return replyEmailAddress;
  }

  public void setReplyEmailAddress(String replyEmailAddress) {
    this.replyEmailAddress = replyEmailAddress;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBasicInfoParam updateBasicInfoParam = (UpdateBasicInfoParam) o;
    return Objects.equals(this.domainName, updateBasicInfoParam.domainName) &&
        Objects.equals(this.fromEmailAddress, updateBasicInfoParam.fromEmailAddress) &&
        Objects.equals(this.replyEmailAddress, updateBasicInfoParam.replyEmailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domainName, fromEmailAddress, replyEmailAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBasicInfoParam {\n");
    sb.append("    domainName: ").append(toIndentedString(domainName)).append("\n");
    sb.append("    fromEmailAddress: ").append(toIndentedString(fromEmailAddress)).append("\n");
    sb.append("    replyEmailAddress: ").append(toIndentedString(replyEmailAddress)).append("\n");
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
    openapiFields.add("domain_name");
    openapiFields.add("from_email_address");
    openapiFields.add("reply_email_address");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("domain_name");
    openapiRequiredFields.add("from_email_address");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateBasicInfoParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateBasicInfoParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateBasicInfoParam is not found in the empty JSON string", UpdateBasicInfoParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateBasicInfoParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateBasicInfoParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UpdateBasicInfoParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("domain_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `domain_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("domain_name").toString()));
      }
      if (!jsonObj.get("from_email_address").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `from_email_address` to be a primitive type in the JSON string but got `%s`", jsonObj.get("from_email_address").toString()));
      }
      if ((jsonObj.get("reply_email_address") != null && !jsonObj.get("reply_email_address").isJsonNull()) && !jsonObj.get("reply_email_address").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `reply_email_address` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reply_email_address").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateBasicInfoParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateBasicInfoParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateBasicInfoParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateBasicInfoParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateBasicInfoParam>() {
           @Override
           public void write(JsonWriter out, UpdateBasicInfoParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateBasicInfoParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateBasicInfoParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateBasicInfoParam
  * @throws IOException if the JSON string is invalid with respect to UpdateBasicInfoParam
  */
  public static UpdateBasicInfoParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateBasicInfoParam.class);
  }

 /**
  * Convert an instance of UpdateBasicInfoParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

