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
 * SingleTenantSettings
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-08T02:50:30.611858448Z[Etc/UTC]")
public class SingleTenantSettings {
  public static final String SERIALIZED_NAME_ENABLED = "enabled";
  @SerializedName(SERIALIZED_NAME_ENABLED)
  private Boolean enabled;

  public static final String SERIALIZED_NAME_ROLE_ARN = "role_arn";
  @SerializedName(SERIALIZED_NAME_ROLE_ARN)
  private String roleArn;

  public static final String SERIALIZED_NAME_CLOUDFORMATION_TEMPLATE_URL = "cloudformation_template_url";
  @SerializedName(SERIALIZED_NAME_CLOUDFORMATION_TEMPLATE_URL)
  private String cloudformationTemplateUrl;

  public static final String SERIALIZED_NAME_DDL_TEMPLATE_URL = "ddl_template_url";
  @SerializedName(SERIALIZED_NAME_DDL_TEMPLATE_URL)
  private String ddlTemplateUrl;

  public static final String SERIALIZED_NAME_ROLE_EXTERNAL_ID = "role_external_id";
  @SerializedName(SERIALIZED_NAME_ROLE_EXTERNAL_ID)
  private String roleExternalId;

  public SingleTenantSettings() {
  }

  public SingleTenantSettings enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * enable Single Tenant settings or not
   * @return enabled
  **/
  @javax.annotation.Nonnull
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  public SingleTenantSettings roleArn(String roleArn) {
    this.roleArn = roleArn;
    return this;
  }

   /**
   * ARN of the role for SaaS Platform to AssumeRole
   * @return roleArn
  **/
  @javax.annotation.Nonnull
  public String getRoleArn() {
    return roleArn;
  }

  public void setRoleArn(String roleArn) {
    this.roleArn = roleArn;
  }


  public SingleTenantSettings cloudformationTemplateUrl(String cloudformationTemplateUrl) {
    this.cloudformationTemplateUrl = cloudformationTemplateUrl;
    return this;
  }

   /**
   * S3 URL where the CloudFormationTemplate to be executed in the SaaS environment is stored
   * @return cloudformationTemplateUrl
  **/
  @javax.annotation.Nonnull
  public String getCloudformationTemplateUrl() {
    return cloudformationTemplateUrl;
  }

  public void setCloudformationTemplateUrl(String cloudformationTemplateUrl) {
    this.cloudformationTemplateUrl = cloudformationTemplateUrl;
  }


  public SingleTenantSettings ddlTemplateUrl(String ddlTemplateUrl) {
    this.ddlTemplateUrl = ddlTemplateUrl;
    return this;
  }

   /**
   * S3 URL where the CloudFormationTemplate to be executed in the SaaS environment is stored
   * @return ddlTemplateUrl
  **/
  @javax.annotation.Nonnull
  public String getDdlTemplateUrl() {
    return ddlTemplateUrl;
  }

  public void setDdlTemplateUrl(String ddlTemplateUrl) {
    this.ddlTemplateUrl = ddlTemplateUrl;
  }


  public SingleTenantSettings roleExternalId(String roleExternalId) {
    this.roleExternalId = roleExternalId;
    return this;
  }

   /**
   * External id used by SaaSus when AssumeRole to operate SaaS
   * @return roleExternalId
  **/
  @javax.annotation.Nonnull
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
    SingleTenantSettings singleTenantSettings = (SingleTenantSettings) o;
    return Objects.equals(this.enabled, singleTenantSettings.enabled) &&
        Objects.equals(this.roleArn, singleTenantSettings.roleArn) &&
        Objects.equals(this.cloudformationTemplateUrl, singleTenantSettings.cloudformationTemplateUrl) &&
        Objects.equals(this.ddlTemplateUrl, singleTenantSettings.ddlTemplateUrl) &&
        Objects.equals(this.roleExternalId, singleTenantSettings.roleExternalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enabled, roleArn, cloudformationTemplateUrl, ddlTemplateUrl, roleExternalId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SingleTenantSettings {\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    roleArn: ").append(toIndentedString(roleArn)).append("\n");
    sb.append("    cloudformationTemplateUrl: ").append(toIndentedString(cloudformationTemplateUrl)).append("\n");
    sb.append("    ddlTemplateUrl: ").append(toIndentedString(ddlTemplateUrl)).append("\n");
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
    openapiFields.add("cloudformation_template_url");
    openapiFields.add("ddl_template_url");
    openapiFields.add("role_external_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("enabled");
    openapiRequiredFields.add("role_arn");
    openapiRequiredFields.add("cloudformation_template_url");
    openapiRequiredFields.add("ddl_template_url");
    openapiRequiredFields.add("role_external_id");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to SingleTenantSettings
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!SingleTenantSettings.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SingleTenantSettings is not found in the empty JSON string", SingleTenantSettings.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!SingleTenantSettings.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SingleTenantSettings` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SingleTenantSettings.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("role_arn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_arn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role_arn").toString()));
      }
      if (!jsonObj.get("cloudformation_template_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cloudformation_template_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cloudformation_template_url").toString()));
      }
      if (!jsonObj.get("ddl_template_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ddl_template_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ddl_template_url").toString()));
      }
      if (!jsonObj.get("role_external_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_external_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role_external_id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SingleTenantSettings.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SingleTenantSettings' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SingleTenantSettings> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SingleTenantSettings.class));

       return (TypeAdapter<T>) new TypeAdapter<SingleTenantSettings>() {
           @Override
           public void write(JsonWriter out, SingleTenantSettings value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SingleTenantSettings read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SingleTenantSettings given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SingleTenantSettings
  * @throws IOException if the JSON string is invalid with respect to SingleTenantSettings
  */
  public static SingleTenantSettings fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SingleTenantSettings.class);
  }

 /**
  * Convert an instance of SingleTenantSettings to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

