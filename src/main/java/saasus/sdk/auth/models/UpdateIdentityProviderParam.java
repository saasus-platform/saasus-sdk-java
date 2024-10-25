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
import saasus.sdk.auth.models.IdentityProviderProps;
import saasus.sdk.auth.models.ProviderName;

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
 * UpdateIdentityProviderParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-25T16:36:00.014827280Z[Etc/UTC]")
public class UpdateIdentityProviderParam {
  public static final String SERIALIZED_NAME_PROVIDER = "provider";
  @SerializedName(SERIALIZED_NAME_PROVIDER)
  private ProviderName provider;

  public static final String SERIALIZED_NAME_IDENTITY_PROVIDER_PROPS = "identity_provider_props";
  @SerializedName(SERIALIZED_NAME_IDENTITY_PROVIDER_PROPS)
  private IdentityProviderProps identityProviderProps;

  public UpdateIdentityProviderParam() {
  }

  public UpdateIdentityProviderParam provider(ProviderName provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @javax.annotation.Nonnull
  public ProviderName getProvider() {
    return provider;
  }

  public void setProvider(ProviderName provider) {
    this.provider = provider;
  }


  public UpdateIdentityProviderParam identityProviderProps(IdentityProviderProps identityProviderProps) {
    this.identityProviderProps = identityProviderProps;
    return this;
  }

   /**
   * Get identityProviderProps
   * @return identityProviderProps
  **/
  @javax.annotation.Nullable
  public IdentityProviderProps getIdentityProviderProps() {
    return identityProviderProps;
  }

  public void setIdentityProviderProps(IdentityProviderProps identityProviderProps) {
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
    UpdateIdentityProviderParam updateIdentityProviderParam = (UpdateIdentityProviderParam) o;
    return Objects.equals(this.provider, updateIdentityProviderParam.provider) &&
        Objects.equals(this.identityProviderProps, updateIdentityProviderParam.identityProviderProps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(provider, identityProviderProps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateIdentityProviderParam {\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
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
    openapiFields.add("provider");
    openapiFields.add("identity_provider_props");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("provider");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateIdentityProviderParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateIdentityProviderParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateIdentityProviderParam is not found in the empty JSON string", UpdateIdentityProviderParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateIdentityProviderParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateIdentityProviderParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UpdateIdentityProviderParam.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `provider`
      ProviderName.validateJsonElement(jsonObj.get("provider"));
      // validate the optional field `identity_provider_props`
      if (jsonObj.get("identity_provider_props") != null && !jsonObj.get("identity_provider_props").isJsonNull()) {
        IdentityProviderProps.validateJsonElement(jsonObj.get("identity_provider_props"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateIdentityProviderParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateIdentityProviderParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateIdentityProviderParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateIdentityProviderParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateIdentityProviderParam>() {
           @Override
           public void write(JsonWriter out, UpdateIdentityProviderParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateIdentityProviderParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateIdentityProviderParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateIdentityProviderParam
  * @throws IOException if the JSON string is invalid with respect to UpdateIdentityProviderParam
  */
  public static UpdateIdentityProviderParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateIdentityProviderParam.class);
  }

 /**
  * Convert an instance of UpdateIdentityProviderParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

