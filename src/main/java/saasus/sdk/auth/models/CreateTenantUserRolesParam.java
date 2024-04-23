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
 * CreateTenantUserRolesParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-04-23T13:10:10.348449134Z[Etc/UTC]")
public class CreateTenantUserRolesParam {
  public static final String SERIALIZED_NAME_ROLE_NAMES = "role_names";
  @SerializedName(SERIALIZED_NAME_ROLE_NAMES)
  private List<String> roleNames = new ArrayList<>();

  public CreateTenantUserRolesParam() {
  }

  public CreateTenantUserRolesParam roleNames(List<String> roleNames) {
    this.roleNames = roleNames;
    return this;
  }

  public CreateTenantUserRolesParam addRoleNamesItem(String roleNamesItem) {
    if (this.roleNames == null) {
      this.roleNames = new ArrayList<>();
    }
    this.roleNames.add(roleNamesItem);
    return this;
  }

   /**
   * Role Info
   * @return roleNames
  **/
  @javax.annotation.Nonnull
  public List<String> getRoleNames() {
    return roleNames;
  }

  public void setRoleNames(List<String> roleNames) {
    this.roleNames = roleNames;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTenantUserRolesParam createTenantUserRolesParam = (CreateTenantUserRolesParam) o;
    return Objects.equals(this.roleNames, createTenantUserRolesParam.roleNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTenantUserRolesParam {\n");
    sb.append("    roleNames: ").append(toIndentedString(roleNames)).append("\n");
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
    openapiFields.add("role_names");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("role_names");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CreateTenantUserRolesParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CreateTenantUserRolesParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateTenantUserRolesParam is not found in the empty JSON string", CreateTenantUserRolesParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CreateTenantUserRolesParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateTenantUserRolesParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateTenantUserRolesParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the required json array is present
      if (jsonObj.get("role_names") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("role_names").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_names` to be an array in the JSON string but got `%s`", jsonObj.get("role_names").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateTenantUserRolesParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateTenantUserRolesParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateTenantUserRolesParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateTenantUserRolesParam.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateTenantUserRolesParam>() {
           @Override
           public void write(JsonWriter out, CreateTenantUserRolesParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateTenantUserRolesParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CreateTenantUserRolesParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateTenantUserRolesParam
  * @throws IOException if the JSON string is invalid with respect to CreateTenantUserRolesParam
  */
  public static CreateTenantUserRolesParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateTenantUserRolesParam.class);
  }

 /**
  * Convert an instance of CreateTenantUserRolesParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

