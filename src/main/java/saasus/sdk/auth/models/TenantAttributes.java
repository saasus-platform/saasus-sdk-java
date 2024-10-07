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
 * TenantAttributes
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-07T03:24:10.100234378Z[Etc/UTC]")
public class TenantAttributes {
  public static final String SERIALIZED_NAME_TENANT_ATTRIBUTES = "tenant_attributes";
  @SerializedName(SERIALIZED_NAME_TENANT_ATTRIBUTES)
  private List<Attribute> tenantAttributes = new ArrayList<>();

  public TenantAttributes() {
  }

  public TenantAttributes tenantAttributes(List<Attribute> tenantAttributes) {
    this.tenantAttributes = tenantAttributes;
    return this;
  }

  public TenantAttributes addTenantAttributesItem(Attribute tenantAttributesItem) {
    if (this.tenantAttributes == null) {
      this.tenantAttributes = new ArrayList<>();
    }
    this.tenantAttributes.add(tenantAttributesItem);
    return this;
  }

   /**
   * Tenant Attribute Definition
   * @return tenantAttributes
  **/
  @javax.annotation.Nonnull
  public List<Attribute> getTenantAttributes() {
    return tenantAttributes;
  }

  public void setTenantAttributes(List<Attribute> tenantAttributes) {
    this.tenantAttributes = tenantAttributes;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantAttributes tenantAttributes = (TenantAttributes) o;
    return Objects.equals(this.tenantAttributes, tenantAttributes.tenantAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantAttributes {\n");
    sb.append("    tenantAttributes: ").append(toIndentedString(tenantAttributes)).append("\n");
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
    openapiFields.add("tenant_attributes");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("tenant_attributes");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TenantAttributes
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TenantAttributes.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TenantAttributes is not found in the empty JSON string", TenantAttributes.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TenantAttributes.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TenantAttributes` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TenantAttributes.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("tenant_attributes").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `tenant_attributes` to be an array in the JSON string but got `%s`", jsonObj.get("tenant_attributes").toString()));
      }

      JsonArray jsonArraytenantAttributes = jsonObj.getAsJsonArray("tenant_attributes");
      // validate the required field `tenant_attributes` (array)
      for (int i = 0; i < jsonArraytenantAttributes.size(); i++) {
        Attribute.validateJsonElement(jsonArraytenantAttributes.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TenantAttributes.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TenantAttributes' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TenantAttributes> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TenantAttributes.class));

       return (TypeAdapter<T>) new TypeAdapter<TenantAttributes>() {
           @Override
           public void write(JsonWriter out, TenantAttributes value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TenantAttributes read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TenantAttributes given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TenantAttributes
  * @throws IOException if the JSON string is invalid with respect to TenantAttributes
  */
  public static TenantAttributes fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TenantAttributes.class);
  }

 /**
  * Convert an instance of TenantAttributes to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

