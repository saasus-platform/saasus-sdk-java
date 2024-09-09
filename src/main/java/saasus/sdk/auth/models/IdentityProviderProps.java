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
 * IdentityProviderProps
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-09T09:10:50.445997561Z[Etc/UTC]")
public class IdentityProviderProps {
  public static final String SERIALIZED_NAME_APPLICATION_ID = "application_id";
  @SerializedName(SERIALIZED_NAME_APPLICATION_ID)
  private String applicationId;

  public static final String SERIALIZED_NAME_APPLICATION_SECRET = "application_secret";
  @SerializedName(SERIALIZED_NAME_APPLICATION_SECRET)
  private String applicationSecret;

  public static final String SERIALIZED_NAME_APPROVAL_SCOPE = "approval_scope";
  @SerializedName(SERIALIZED_NAME_APPROVAL_SCOPE)
  private String approvalScope;

  public static final String SERIALIZED_NAME_IS_BUTTON_HIDDEN = "is_button_hidden";
  @SerializedName(SERIALIZED_NAME_IS_BUTTON_HIDDEN)
  private Boolean isButtonHidden;

  public IdentityProviderProps() {
  }

  public IdentityProviderProps applicationId(String applicationId) {
    this.applicationId = applicationId;
    return this;
  }

   /**
   * Get applicationId
   * @return applicationId
  **/
  @javax.annotation.Nonnull
  public String getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }


  public IdentityProviderProps applicationSecret(String applicationSecret) {
    this.applicationSecret = applicationSecret;
    return this;
  }

   /**
   * Get applicationSecret
   * @return applicationSecret
  **/
  @javax.annotation.Nonnull
  public String getApplicationSecret() {
    return applicationSecret;
  }

  public void setApplicationSecret(String applicationSecret) {
    this.applicationSecret = applicationSecret;
  }


  public IdentityProviderProps approvalScope(String approvalScope) {
    this.approvalScope = approvalScope;
    return this;
  }

   /**
   * Get approvalScope
   * @return approvalScope
  **/
  @javax.annotation.Nonnull
  public String getApprovalScope() {
    return approvalScope;
  }

  public void setApprovalScope(String approvalScope) {
    this.approvalScope = approvalScope;
  }


  public IdentityProviderProps isButtonHidden(Boolean isButtonHidden) {
    this.isButtonHidden = isButtonHidden;
    return this;
  }

   /**
   * Get isButtonHidden
   * @return isButtonHidden
  **/
  @javax.annotation.Nullable
  public Boolean getIsButtonHidden() {
    return isButtonHidden;
  }

  public void setIsButtonHidden(Boolean isButtonHidden) {
    this.isButtonHidden = isButtonHidden;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityProviderProps identityProviderProps = (IdentityProviderProps) o;
    return Objects.equals(this.applicationId, identityProviderProps.applicationId) &&
        Objects.equals(this.applicationSecret, identityProviderProps.applicationSecret) &&
        Objects.equals(this.approvalScope, identityProviderProps.approvalScope) &&
        Objects.equals(this.isButtonHidden, identityProviderProps.isButtonHidden);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, applicationSecret, approvalScope, isButtonHidden);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityProviderProps {\n");
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
    sb.append("    applicationSecret: ").append(toIndentedString(applicationSecret)).append("\n");
    sb.append("    approvalScope: ").append(toIndentedString(approvalScope)).append("\n");
    sb.append("    isButtonHidden: ").append(toIndentedString(isButtonHidden)).append("\n");
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
    openapiFields.add("application_id");
    openapiFields.add("application_secret");
    openapiFields.add("approval_scope");
    openapiFields.add("is_button_hidden");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("application_id");
    openapiRequiredFields.add("application_secret");
    openapiRequiredFields.add("approval_scope");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to IdentityProviderProps
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!IdentityProviderProps.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IdentityProviderProps is not found in the empty JSON string", IdentityProviderProps.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!IdentityProviderProps.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdentityProviderProps` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : IdentityProviderProps.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("application_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `application_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("application_id").toString()));
      }
      if (!jsonObj.get("application_secret").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `application_secret` to be a primitive type in the JSON string but got `%s`", jsonObj.get("application_secret").toString()));
      }
      if (!jsonObj.get("approval_scope").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `approval_scope` to be a primitive type in the JSON string but got `%s`", jsonObj.get("approval_scope").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IdentityProviderProps.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IdentityProviderProps' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IdentityProviderProps> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IdentityProviderProps.class));

       return (TypeAdapter<T>) new TypeAdapter<IdentityProviderProps>() {
           @Override
           public void write(JsonWriter out, IdentityProviderProps value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IdentityProviderProps read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IdentityProviderProps given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IdentityProviderProps
  * @throws IOException if the JSON string is invalid with respect to IdentityProviderProps
  */
  public static IdentityProviderProps fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IdentityProviderProps.class);
  }

 /**
  * Convert an instance of IdentityProviderProps to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

