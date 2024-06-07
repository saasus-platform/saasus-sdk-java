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
import saasus.sdk.auth.models.ProviderType;
import saasus.sdk.auth.models.TenantIdentityProviderProps;

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
 * If identity_provider_props is null, the sign-in information for the external identity provider specified in provider_type is disabled. 
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-07T09:59:39.102185733Z[Etc/UTC]")
public class UpdateTenantIdentityProviderParam {
  public static final String SERIALIZED_NAME_PROVIDER_TYPE = "provider_type";
  @SerializedName(SERIALIZED_NAME_PROVIDER_TYPE)
  private ProviderType providerType;

  public static final String SERIALIZED_NAME_IDENTITY_PROVIDER_PROPS = "identity_provider_props";
  @SerializedName(SERIALIZED_NAME_IDENTITY_PROVIDER_PROPS)
  private TenantIdentityProviderProps identityProviderProps;

  public UpdateTenantIdentityProviderParam() {
  }

  public UpdateTenantIdentityProviderParam providerType(ProviderType providerType) {
    this.providerType = providerType;
    return this;
  }

   /**
   * Get providerType
   * @return providerType
  **/
  @javax.annotation.Nonnull
  public ProviderType getProviderType() {
    return providerType;
  }

  public void setProviderType(ProviderType providerType) {
    this.providerType = providerType;
  }


  public UpdateTenantIdentityProviderParam identityProviderProps(TenantIdentityProviderProps identityProviderProps) {
    this.identityProviderProps = identityProviderProps;
    return this;
  }

   /**
   * Get identityProviderProps
   * @return identityProviderProps
  **/
  @javax.annotation.Nullable
  public TenantIdentityProviderProps getIdentityProviderProps() {
    return identityProviderProps;
  }

  public void setIdentityProviderProps(TenantIdentityProviderProps identityProviderProps) {
    this.identityProviderProps = identityProviderProps;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateTenantIdentityProviderParam updateTenantIdentityProviderParam = (UpdateTenantIdentityProviderParam) o;
    return Objects.equals(this.providerType, updateTenantIdentityProviderParam.providerType) &&
        Objects.equals(this.identityProviderProps, updateTenantIdentityProviderParam.identityProviderProps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(providerType, identityProviderProps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTenantIdentityProviderParam {\n");
    sb.append("    providerType: ").append(toIndentedString(providerType)).append("\n");
    sb.append("    identityProviderProps: ").append(toIndentedString(identityProviderProps)).append("\n");
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
    openapiFields.add("provider_type");
    openapiFields.add("identity_provider_props");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("provider_type");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateTenantIdentityProviderParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateTenantIdentityProviderParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateTenantIdentityProviderParam is not found in the empty JSON string", UpdateTenantIdentityProviderParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateTenantIdentityProviderParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateTenantIdentityProviderParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UpdateTenantIdentityProviderParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `provider_type`
      ProviderType.validateJsonElement(jsonObj.get("provider_type"));
      // validate the optional field `identity_provider_props`
      if (jsonObj.get("identity_provider_props") != null && !jsonObj.get("identity_provider_props").isJsonNull()) {
        TenantIdentityProviderProps.validateJsonElement(jsonObj.get("identity_provider_props"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateTenantIdentityProviderParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateTenantIdentityProviderParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateTenantIdentityProviderParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateTenantIdentityProviderParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateTenantIdentityProviderParam>() {
           @Override
           public void write(JsonWriter out, UpdateTenantIdentityProviderParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateTenantIdentityProviderParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateTenantIdentityProviderParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateTenantIdentityProviderParam
  * @throws IOException if the JSON string is invalid with respect to UpdateTenantIdentityProviderParam
  */
  public static UpdateTenantIdentityProviderParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateTenantIdentityProviderParam.class);
  }

 /**
  * Convert an instance of UpdateTenantIdentityProviderParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

