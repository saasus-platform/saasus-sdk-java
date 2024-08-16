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
 * UpdateSingleTenantSettingsParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:09:21.529968105Z[Etc/UTC]")
public class UpdateSingleTenantSettingsParam {
  public static final String SERIALIZED_NAME_ENABLED = "enabled";
  @SerializedName(SERIALIZED_NAME_ENABLED)
  private Boolean enabled;

  public static final String SERIALIZED_NAME_ROLE_ARN = "role_arn";
  @SerializedName(SERIALIZED_NAME_ROLE_ARN)
  private String roleArn;

  public static final String SERIALIZED_NAME_CLOUDFORMATION_TEMPLATE = "cloudformation_template";
  @SerializedName(SERIALIZED_NAME_CLOUDFORMATION_TEMPLATE)
  private String cloudformationTemplate;

  public static final String SERIALIZED_NAME_DDL_TEMPLATE = "ddl_template";
  @SerializedName(SERIALIZED_NAME_DDL_TEMPLATE)
  private String ddlTemplate;

  public static final String SERIALIZED_NAME_ROLE_EXTERNAL_ID = "role_external_id";
  @SerializedName(SERIALIZED_NAME_ROLE_EXTERNAL_ID)
  private String roleExternalId;

  public UpdateSingleTenantSettingsParam() {
  }

  public UpdateSingleTenantSettingsParam enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * enable Single Tenant settings or not
   * @return enabled
  **/
  @javax.annotation.Nullable
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  public UpdateSingleTenantSettingsParam roleArn(String roleArn) {
    this.roleArn = roleArn;
    return this;
  }

   /**
   * ARN of the role for SaaS Platform to AssumeRole
   * @return roleArn
  **/
  @javax.annotation.Nullable
  public String getRoleArn() {
    return roleArn;
  }

  public void setRoleArn(String roleArn) {
    this.roleArn = roleArn;
  }


  public UpdateSingleTenantSettingsParam cloudformationTemplate(String cloudformationTemplate) {
    this.cloudformationTemplate = cloudformationTemplate;
    return this;
  }

   /**
   * CloudFormation template file
   * @return cloudformationTemplate
  **/
  @javax.annotation.Nullable
  public String getCloudformationTemplate() {
    return cloudformationTemplate;
  }

  public void setCloudformationTemplate(String cloudformationTemplate) {
    this.cloudformationTemplate = cloudformationTemplate;
  }


  public UpdateSingleTenantSettingsParam ddlTemplate(String ddlTemplate) {
    this.ddlTemplate = ddlTemplate;
    return this;
  }

   /**
   * ddl file to run in SaaS environment
   * @return ddlTemplate
  **/
  @javax.annotation.Nullable
  public String getDdlTemplate() {
    return ddlTemplate;
  }

  public void setDdlTemplate(String ddlTemplate) {
    this.ddlTemplate = ddlTemplate;
  }


  public UpdateSingleTenantSettingsParam roleExternalId(String roleExternalId) {
    this.roleExternalId = roleExternalId;
    return this;
  }

   /**
   * External id used by SaaSus when AssumeRole to operate SaaS
   * @return roleExternalId
  **/
  @javax.annotation.Nullable
  public String getRoleExternalId() {
    return roleExternalId;
  }

  public void setRoleExternalId(String roleExternalId) {
    this.roleExternalId = roleExternalId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSingleTenantSettingsParam updateSingleTenantSettingsParam = (UpdateSingleTenantSettingsParam) o;
    return Objects.equals(this.enabled, updateSingleTenantSettingsParam.enabled) &&
        Objects.equals(this.roleArn, updateSingleTenantSettingsParam.roleArn) &&
        Objects.equals(this.cloudformationTemplate, updateSingleTenantSettingsParam.cloudformationTemplate) &&
        Objects.equals(this.ddlTemplate, updateSingleTenantSettingsParam.ddlTemplate) &&
        Objects.equals(this.roleExternalId, updateSingleTenantSettingsParam.roleExternalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, roleArn, cloudformationTemplate, ddlTemplate, roleExternalId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSingleTenantSettingsParam {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    roleArn: ").append(toIndentedString(roleArn)).append("\n");
    sb.append("    cloudformationTemplate: ").append(toIndentedString(cloudformationTemplate)).append("\n");
    sb.append("    ddlTemplate: ").append(toIndentedString(ddlTemplate)).append("\n");
    sb.append("    roleExternalId: ").append(toIndentedString(roleExternalId)).append("\n");
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
    openapiFields.add("enabled");
    openapiFields.add("role_arn");
    openapiFields.add("cloudformation_template");
    openapiFields.add("ddl_template");
    openapiFields.add("role_external_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateSingleTenantSettingsParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateSingleTenantSettingsParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateSingleTenantSettingsParam is not found in the empty JSON string", UpdateSingleTenantSettingsParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateSingleTenantSettingsParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateSingleTenantSettingsParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("role_arn") != null && !jsonObj.get("role_arn").isJsonNull()) && !jsonObj.get("role_arn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_arn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role_arn").toString()));
      }
      if ((jsonObj.get("cloudformation_template") != null && !jsonObj.get("cloudformation_template").isJsonNull()) && !jsonObj.get("cloudformation_template").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cloudformation_template` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cloudformation_template").toString()));
      }
      if ((jsonObj.get("ddl_template") != null && !jsonObj.get("ddl_template").isJsonNull()) && !jsonObj.get("ddl_template").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ddl_template` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ddl_template").toString()));
      }
      if ((jsonObj.get("role_external_id") != null && !jsonObj.get("role_external_id").isJsonNull()) && !jsonObj.get("role_external_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_external_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role_external_id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateSingleTenantSettingsParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateSingleTenantSettingsParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateSingleTenantSettingsParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateSingleTenantSettingsParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateSingleTenantSettingsParam>() {
           @Override
           public void write(JsonWriter out, UpdateSingleTenantSettingsParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateSingleTenantSettingsParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateSingleTenantSettingsParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateSingleTenantSettingsParam
  * @throws IOException if the JSON string is invalid with respect to UpdateSingleTenantSettingsParam
  */
  public static UpdateSingleTenantSettingsParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateSingleTenantSettingsParam.class);
  }

 /**
  * Convert an instance of UpdateSingleTenantSettingsParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

