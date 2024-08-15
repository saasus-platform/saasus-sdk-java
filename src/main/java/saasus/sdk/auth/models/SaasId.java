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
 * SaasId
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-15T08:29:53.195185360Z[Etc/UTC]")
public class SaasId {
  public static final String SERIALIZED_NAME_TENANT_ID = "tenant_id";
  @SerializedName(SERIALIZED_NAME_TENANT_ID)
  private String tenantId;

  public static final String SERIALIZED_NAME_ENV_ID = "env_id";
  @SerializedName(SERIALIZED_NAME_ENV_ID)
  private Integer envId;

  public static final String SERIALIZED_NAME_SAAS_ID = "saas_id";
  @SerializedName(SERIALIZED_NAME_SAAS_ID)
  private String saasId;

  public SaasId() {
  }

  public SaasId tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

   /**
   * Get tenantId
   * @return tenantId
  **/
  @javax.annotation.Nonnull
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }


  public SaasId envId(Integer envId) {
    this.envId = envId;
    return this;
  }

   /**
   * Get envId
   * @return envId
  **/
  @javax.annotation.Nonnull
  public Integer getEnvId() {
    return envId;
  }

  public void setEnvId(Integer envId) {
    this.envId = envId;
  }


  public SaasId saasId(String saasId) {
    this.saasId = saasId;
    return this;
  }

   /**
   * SaaS ID
   * @return saasId
  **/
  @javax.annotation.Nonnull
  public String getSaasId() {
    return saasId;
  }

  public void setSaasId(String saasId) {
    this.saasId = saasId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaasId saasId = (SaasId) o;
    return Objects.equals(this.tenantId, saasId.tenantId) &&
        Objects.equals(this.envId, saasId.envId) &&
        Objects.equals(this.saasId, saasId.saasId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, envId, saasId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaasId {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    envId: ").append(toIndentedString(envId)).append("\n");
    sb.append("    saasId: ").append(toIndentedString(saasId)).append("\n");
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
    openapiFields.add("tenant_id");
    openapiFields.add("env_id");
    openapiFields.add("saas_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("tenant_id");
    openapiRequiredFields.add("env_id");
    openapiRequiredFields.add("saas_id");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SaasId
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SaasId.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SaasId is not found in the empty JSON string", SaasId.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SaasId.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SaasId` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SaasId.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("tenant_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tenant_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tenant_id").toString()));
      }
      if (!jsonObj.get("saas_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `saas_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("saas_id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SaasId.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SaasId' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SaasId> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SaasId.class));

       return (TypeAdapter<T>) new TypeAdapter<SaasId>() {
           @Override
           public void write(JsonWriter out, SaasId value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SaasId read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SaasId given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SaasId
  * @throws IOException if the JSON string is invalid with respect to SaasId
  */
  public static SaasId fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SaasId.class);
  }

 /**
  * Convert an instance of SaasId to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

