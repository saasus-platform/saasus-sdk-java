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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * UserAvailableTenant
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:09:21.529968105Z[Etc/UTC]")
public class UserAvailableTenant {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_COMPLETED_SIGN_UP = "completed_sign_up";
  @SerializedName(SERIALIZED_NAME_COMPLETED_SIGN_UP)
  private Boolean completedSignUp;

  public static final String SERIALIZED_NAME_ENVS = "envs";
  @SerializedName(SERIALIZED_NAME_ENVS)
  private List<UserAvailableEnv> envs = new ArrayList<>();

  public static final String SERIALIZED_NAME_USER_ATTRIBUTE = "user_attribute";
  @SerializedName(SERIALIZED_NAME_USER_ATTRIBUTE)
  private Map<String, Object> userAttribute = new HashMap<>();

  public static final String SERIALIZED_NAME_BACK_OFFICE_STAFF_EMAIL = "back_office_staff_email";
  @SerializedName(SERIALIZED_NAME_BACK_OFFICE_STAFF_EMAIL)
  private String backOfficeStaffEmail;

  public static final String SERIALIZED_NAME_PLAN_ID = "plan_id";
  @SerializedName(SERIALIZED_NAME_PLAN_ID)
  private String planId;

  public static final String SERIALIZED_NAME_IS_PAID = "is_paid";
  @SerializedName(SERIALIZED_NAME_IS_PAID)
  private Boolean isPaid;

  public UserAvailableTenant() {
  }

  public UserAvailableTenant id(String id) {
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


  public UserAvailableTenant name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Tenant Name
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public UserAvailableTenant completedSignUp(Boolean completedSignUp) {
    this.completedSignUp = completedSignUp;
    return this;
  }

   /**
   * Get completedSignUp
   * @return completedSignUp
  **/
  @javax.annotation.Nonnull
  public Boolean getCompletedSignUp() {
    return completedSignUp;
  }

  public void setCompletedSignUp(Boolean completedSignUp) {
    this.completedSignUp = completedSignUp;
  }


  public UserAvailableTenant envs(List<UserAvailableEnv> envs) {
    this.envs = envs;
    return this;
  }

  public UserAvailableTenant addEnvsItem(UserAvailableEnv envsItem) {
    if (this.envs == null) {
      this.envs = new ArrayList<>();
    }
    this.envs.add(envsItem);
    return this;
  }

   /**
   * environmental info, role info
   * @return envs
  **/
  @javax.annotation.Nonnull
  public List<UserAvailableEnv> getEnvs() {
    return envs;
  }

  public void setEnvs(List<UserAvailableEnv> envs) {
    this.envs = envs;
  }


  public UserAvailableTenant userAttribute(Map<String, Object> userAttribute) {
    this.userAttribute = userAttribute;
    return this;
  }

  public UserAvailableTenant putUserAttributeItem(String key, Object userAttributeItem) {
    if (this.userAttribute == null) {
      this.userAttribute = new HashMap<>();
    }
    this.userAttribute.put(key, userAttributeItem);
    return this;
  }

   /**
   * user additional attributes
   * @return userAttribute
  **/
  @javax.annotation.Nonnull
  public Map<String, Object> getUserAttribute() {
    return userAttribute;
  }

  public void setUserAttribute(Map<String, Object> userAttribute) {
    this.userAttribute = userAttribute;
  }


  public UserAvailableTenant backOfficeStaffEmail(String backOfficeStaffEmail) {
    this.backOfficeStaffEmail = backOfficeStaffEmail;
    return this;
  }

   /**
   * back office contact email
   * @return backOfficeStaffEmail
  **/
  @javax.annotation.Nonnull
  public String getBackOfficeStaffEmail() {
    return backOfficeStaffEmail;
  }

  public void setBackOfficeStaffEmail(String backOfficeStaffEmail) {
    this.backOfficeStaffEmail = backOfficeStaffEmail;
  }


  public UserAvailableTenant planId(String planId) {
    this.planId = planId;
    return this;
  }

   /**
   * Get planId
   * @return planId
  **/
  @javax.annotation.Nullable
  public String getPlanId() {
    return planId;
  }

  public void setPlanId(String planId) {
    this.planId = planId;
  }


  public UserAvailableTenant isPaid(Boolean isPaid) {
    this.isPaid = isPaid;
    return this;
  }

   /**
   * tenant payment status ※ Currently, it is returned only when stripe is linked. 
   * @return isPaid
  **/
  @javax.annotation.Nullable
  public Boolean getIsPaid() {
    return isPaid;
  }

  public void setIsPaid(Boolean isPaid) {
    this.isPaid = isPaid;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAvailableTenant userAvailableTenant = (UserAvailableTenant) o;
    return Objects.equals(this.id, userAvailableTenant.id) &&
        Objects.equals(this.name, userAvailableTenant.name) &&
        Objects.equals(this.completedSignUp, userAvailableTenant.completedSignUp) &&
        Objects.equals(this.envs, userAvailableTenant.envs) &&
        Objects.equals(this.userAttribute, userAvailableTenant.userAttribute) &&
        Objects.equals(this.backOfficeStaffEmail, userAvailableTenant.backOfficeStaffEmail) &&
        Objects.equals(this.planId, userAvailableTenant.planId) &&
        Objects.equals(this.isPaid, userAvailableTenant.isPaid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, completedSignUp, envs, userAttribute, backOfficeStaffEmail, planId, isPaid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAvailableTenant {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    completedSignUp: ").append(toIndentedString(completedSignUp)).append("\n");
    sb.append("    envs: ").append(toIndentedString(envs)).append("\n");
    sb.append("    userAttribute: ").append(toIndentedString(userAttribute)).append("\n");
    sb.append("    backOfficeStaffEmail: ").append(toIndentedString(backOfficeStaffEmail)).append("\n");
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    isPaid: ").append(toIndentedString(isPaid)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("completed_sign_up");
    openapiFields.add("envs");
    openapiFields.add("user_attribute");
    openapiFields.add("back_office_staff_email");
    openapiFields.add("plan_id");
    openapiFields.add("is_paid");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("completed_sign_up");
    openapiRequiredFields.add("envs");
    openapiRequiredFields.add("user_attribute");
    openapiRequiredFields.add("back_office_staff_email");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UserAvailableTenant
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UserAvailableTenant.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UserAvailableTenant is not found in the empty JSON string", UserAvailableTenant.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UserAvailableTenant.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserAvailableTenant` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : UserAvailableTenant.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
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
      if (!jsonObj.get("back_office_staff_email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `back_office_staff_email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("back_office_staff_email").toString()));
      }
      if ((jsonObj.get("plan_id") != null && !jsonObj.get("plan_id").isJsonNull()) && !jsonObj.get("plan_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("plan_id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UserAvailableTenant.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UserAvailableTenant' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UserAvailableTenant> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UserAvailableTenant.class));

       return (TypeAdapter<T>) new TypeAdapter<UserAvailableTenant>() {
           @Override
           public void write(JsonWriter out, UserAvailableTenant value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UserAvailableTenant read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UserAvailableTenant given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UserAvailableTenant
  * @throws IOException if the JSON string is invalid with respect to UserAvailableTenant
  */
  public static UserAvailableTenant fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UserAvailableTenant.class);
  }

 /**
  * Convert an instance of UserAvailableTenant to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

