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
import saasus.sdk.auth.models.InvitationStatus;
import saasus.sdk.auth.models.UserAvailableEnv;

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
 * Invitation
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-08T02:48:55.881140815Z[Etc/UTC]")
public class Invitation {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_INVITATION_URL = "invitation_url";
  @SerializedName(SERIALIZED_NAME_INVITATION_URL)
  private String invitationUrl;

  public static final String SERIALIZED_NAME_ENVS = "envs";
  @SerializedName(SERIALIZED_NAME_ENVS)
  private List<UserAvailableEnv> envs = new ArrayList<>();

  public static final String SERIALIZED_NAME_EXPIRED_AT = "expired_at";
  @SerializedName(SERIALIZED_NAME_EXPIRED_AT)
  private Integer expiredAt;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private InvitationStatus status;

  public Invitation() {
  }

  public Invitation id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Invitation email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email address of the invited user
   * @return email
  **/
  @javax.annotation.Nonnull
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Invitation invitationUrl(String invitationUrl) {
    this.invitationUrl = invitationUrl;
    return this;
  }

   /**
   * Invitation URL
   * @return invitationUrl
  **/
  @javax.annotation.Nonnull
  public String getInvitationUrl() {
    return invitationUrl;
  }

  public void setInvitationUrl(String invitationUrl) {
    this.invitationUrl = invitationUrl;
  }


  public Invitation envs(List<UserAvailableEnv> envs) {
    this.envs = envs;
    return this;
  }

  public Invitation addEnvsItem(UserAvailableEnv envsItem) {
    if (this.envs == null) {
      this.envs = new ArrayList<>();
    }
    this.envs.add(envsItem);
    return this;
  }

   /**
   * Get envs
   * @return envs
  **/
  @javax.annotation.Nonnull
  public List<UserAvailableEnv> getEnvs() {
    return envs;
  }

  public void setEnvs(List<UserAvailableEnv> envs) {
    this.envs = envs;
  }


  public Invitation expiredAt(Integer expiredAt) {
    this.expiredAt = expiredAt;
    return this;
  }

   /**
   * Expiration date of the invitation
   * @return expiredAt
  **/
  @javax.annotation.Nonnull
  public Integer getExpiredAt() {
    return expiredAt;
  }

  public void setExpiredAt(Integer expiredAt) {
    this.expiredAt = expiredAt;
  }


  public Invitation status(InvitationStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  public InvitationStatus getStatus() {
    return status;
  }

  public void setStatus(InvitationStatus status) {
    this.status = status;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invitation invitation = (Invitation) o;
    return Objects.equals(this.id, invitation.id) &&
        Objects.equals(this.email, invitation.email) &&
        Objects.equals(this.invitationUrl, invitation.invitationUrl) &&
        Objects.equals(this.envs, invitation.envs) &&
        Objects.equals(this.expiredAt, invitation.expiredAt) &&
        Objects.equals(this.status, invitation.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, invitationUrl, envs, expiredAt, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invitation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    invitationUrl: ").append(toIndentedString(invitationUrl)).append("\n");
    sb.append("    envs: ").append(toIndentedString(envs)).append("\n");
    sb.append("    expiredAt: ").append(toIndentedString(expiredAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("email");
    openapiFields.add("invitation_url");
    openapiFields.add("envs");
    openapiFields.add("expired_at");
    openapiFields.add("status");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("email");
    openapiRequiredFields.add("invitation_url");
    openapiRequiredFields.add("envs");
    openapiRequiredFields.add("expired_at");
    openapiRequiredFields.add("status");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Invitation
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Invitation.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Invitation is not found in the empty JSON string", Invitation.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Invitation.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Invitation` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Invitation.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if (!jsonObj.get("invitation_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `invitation_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("invitation_url").toString()));
      }
      // ensure the json data is an array
      if (!jsonObj.get("envs").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `envs` to be an array in the JSON string but got `%s`", jsonObj.get("envs").toString()));
      }

      JsonArray jsonArrayenvs = jsonObj.getAsJsonArray("envs");
      // validate the required field `envs` (array)
      for (int i = 0; i < jsonArrayenvs.size(); i++) {
        UserAvailableEnv.validateJsonElement(jsonArrayenvs.get(i));
      };
      // validate the required field `status`
      InvitationStatus.validateJsonElement(jsonObj.get("status"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Invitation.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Invitation' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Invitation> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Invitation.class));

       return (TypeAdapter<T>) new TypeAdapter<Invitation>() {
           @Override
           public void write(JsonWriter out, Invitation value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Invitation read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Invitation given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Invitation
  * @throws IOException if the JSON string is invalid with respect to Invitation
  */
  public static Invitation fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Invitation.class);
  }

 /**
  * Convert an instance of Invitation to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

