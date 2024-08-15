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
import saasus.sdk.auth.models.TenantIdentityProvidersSaml;

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
 * TenantIdentityProviders
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-15T08:29:53.195185360Z[Etc/UTC]")
public class TenantIdentityProviders {
  public static final String SERIALIZED_NAME_SAML = "saml";
  @SerializedName(SERIALIZED_NAME_SAML)
  private TenantIdentityProvidersSaml saml;

  public TenantIdentityProviders() {
  }

  public TenantIdentityProviders saml(TenantIdentityProvidersSaml saml) {
    this.saml = saml;
    return this;
  }

   /**
   * Get saml
   * @return saml
  **/
  @javax.annotation.Nullable
  public TenantIdentityProvidersSaml getSaml() {
    return saml;
  }

  public void setSaml(TenantIdentityProvidersSaml saml) {
    this.saml = saml;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantIdentityProviders tenantIdentityProviders = (TenantIdentityProviders) o;
    return Objects.equals(this.saml, tenantIdentityProviders.saml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantIdentityProviders {\n");
    sb.append("    saml: ").append(toIndentedString(saml)).append("\n");
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
    openapiFields.add("saml");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to TenantIdentityProviders
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TenantIdentityProviders.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TenantIdentityProviders is not found in the empty JSON string", TenantIdentityProviders.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!TenantIdentityProviders.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TenantIdentityProviders` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `saml`
      if (jsonObj.get("saml") != null && !jsonObj.get("saml").isJsonNull()) {
        TenantIdentityProvidersSaml.validateJsonElement(jsonObj.get("saml"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TenantIdentityProviders.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TenantIdentityProviders' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TenantIdentityProviders> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TenantIdentityProviders.class));

       return (TypeAdapter<T>) new TypeAdapter<TenantIdentityProviders>() {
           @Override
           public void write(JsonWriter out, TenantIdentityProviders value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TenantIdentityProviders read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TenantIdentityProviders given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TenantIdentityProviders
  * @throws IOException if the JSON string is invalid with respect to TenantIdentityProviders
  */
  public static TenantIdentityProviders fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TenantIdentityProviders.class);
  }

 /**
  * Convert an instance of TenantIdentityProviders to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

