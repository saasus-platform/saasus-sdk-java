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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import saasus.sdk.auth.models.Attribute;

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
 * UserAttributes
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-14T16:56:09.227959148Z[Etc/UTC]")
public class UserAttributes {
  public static final String SERIALIZED_NAME_USER_ATTRIBUTES = "user_attributes";
  @SerializedName(SERIALIZED_NAME_USER_ATTRIBUTES)
  private List<Attribute> userAttributes = new ArrayList<>();

  public UserAttributes() {
  }

  public UserAttributes userAttributes(List<Attribute> userAttributes) {
    this.userAttributes = userAttributes;
    return this;
  }

  public UserAttributes addUserAttributesItem(Attribute userAttributesItem) {
    if (this.userAttributes == null) {
      this.userAttributes = new ArrayList<>();
    }
    this.userAttributes.add(userAttributesItem);
    return this;
  }

   /**
   * User Attribute Definition
   * @return userAttributes
  **/
  @javax.annotation.Nonnull
  public List<Attribute> getUserAttributes() {
    return userAttributes;
  }

  public void setUserAttributes(List<Attribute> userAttributes) {
    this.userAttributes = userAttributes;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAttributes userAttributes = (UserAttributes) o;
    return Objects.equals(this.userAttributes, userAttributes.userAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAttributes {\n");
    sb.append("    userAttributes: ").append(toIndentedString(userAttributes)).append("\n");
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
    openapiFields.add("user_attributes");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("user_attributes");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UserAttributes
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UserAttributes.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UserAttributes is not found in the empty JSON string", UserAttributes.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UserAttributes.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserAttributes` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UserAttributes.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("user_attributes").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `user_attributes` to be an array in the JSON string but got `%s`", jsonObj.get("user_attributes").toString()));
      }

      JsonArray jsonArrayuserAttributes = jsonObj.getAsJsonArray("user_attributes");
      // validate the required field `user_attributes` (array)
      for (int i = 0; i < jsonArrayuserAttributes.size(); i++) {
        Attribute.validateJsonElement(jsonArrayuserAttributes.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UserAttributes.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UserAttributes' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UserAttributes> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UserAttributes.class));

       return (TypeAdapter<T>) new TypeAdapter<UserAttributes>() {
           @Override
           public void write(JsonWriter out, UserAttributes value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UserAttributes read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UserAttributes given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UserAttributes
  * @throws IOException if the JSON string is invalid with respect to UserAttributes
  */
  public static UserAttributes fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UserAttributes.class);
  }

 /**
  * Convert an instance of UserAttributes to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

