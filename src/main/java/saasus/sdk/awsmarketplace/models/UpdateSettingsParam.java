/*
 * SaaSus AWS Marketplace API Schema
 * SaaSus AWS Marketplace API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.awsmarketplace.models;

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

import saasus.sdk.awsmarketplace.JSON;

/**
 * UpdateSettingsParam
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-02T11:18:29.593592750Z[Etc/UTC]")
public class UpdateSettingsParam {
  public static final String SERIALIZED_NAME_PRODUCT_CODE = "product_code";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CODE)
  private String productCode;

  public static final String SERIALIZED_NAME_ROLE_ARN = "role_arn";
  @SerializedName(SERIALIZED_NAME_ROLE_ARN)
  private String roleArn;

  public static final String SERIALIZED_NAME_ROLE_EXTERNAL_ID = "role_external_id";
  @SerializedName(SERIALIZED_NAME_ROLE_EXTERNAL_ID)
  private String roleExternalId;

  public static final String SERIALIZED_NAME_SNS_TOPIC_ARN = "sns_topic_arn";
  @SerializedName(SERIALIZED_NAME_SNS_TOPIC_ARN)
  private String snsTopicArn;

  public static final String SERIALIZED_NAME_CAS_BUCKET_NAME = "cas_bucket_name";
  @SerializedName(SERIALIZED_NAME_CAS_BUCKET_NAME)
  private String casBucketName;

  public static final String SERIALIZED_NAME_CAS_SNS_TOPIC_ARN = "cas_sns_topic_arn";
  @SerializedName(SERIALIZED_NAME_CAS_SNS_TOPIC_ARN)
  private String casSnsTopicArn;

  public static final String SERIALIZED_NAME_SELLER_SNS_TOPIC_ARN = "seller_sns_topic_arn";
  @SerializedName(SERIALIZED_NAME_SELLER_SNS_TOPIC_ARN)
  private String sellerSnsTopicArn;

  public static final String SERIALIZED_NAME_SQS_ARN = "sqs_arn";
  @SerializedName(SERIALIZED_NAME_SQS_ARN)
  private String sqsArn;

  public UpdateSettingsParam() {
  }

  public UpdateSettingsParam productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

   /**
   * Get productCode
   * @return productCode
  **/
  @javax.annotation.Nullable
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }


  public UpdateSettingsParam roleArn(String roleArn) {
    this.roleArn = roleArn;
    return this;
  }

   /**
   * Get roleArn
   * @return roleArn
  **/
  @javax.annotation.Nullable
  public String getRoleArn() {
    return roleArn;
  }

  public void setRoleArn(String roleArn) {
    this.roleArn = roleArn;
  }


  public UpdateSettingsParam roleExternalId(String roleExternalId) {
    this.roleExternalId = roleExternalId;
    return this;
  }

   /**
   * Get roleExternalId
   * @return roleExternalId
  **/
  @javax.annotation.Nullable
  public String getRoleExternalId() {
    return roleExternalId;
  }

  public void setRoleExternalId(String roleExternalId) {
    this.roleExternalId = roleExternalId;
  }


  public UpdateSettingsParam snsTopicArn(String snsTopicArn) {
    this.snsTopicArn = snsTopicArn;
    return this;
  }

   /**
   * Get snsTopicArn
   * @return snsTopicArn
  **/
  @javax.annotation.Nullable
  public String getSnsTopicArn() {
    return snsTopicArn;
  }

  public void setSnsTopicArn(String snsTopicArn) {
    this.snsTopicArn = snsTopicArn;
  }


  public UpdateSettingsParam casBucketName(String casBucketName) {
    this.casBucketName = casBucketName;
    return this;
  }

   /**
   * Get casBucketName
   * @return casBucketName
  **/
  @javax.annotation.Nullable
  public String getCasBucketName() {
    return casBucketName;
  }

  public void setCasBucketName(String casBucketName) {
    this.casBucketName = casBucketName;
  }


  public UpdateSettingsParam casSnsTopicArn(String casSnsTopicArn) {
    this.casSnsTopicArn = casSnsTopicArn;
    return this;
  }

   /**
   * Get casSnsTopicArn
   * @return casSnsTopicArn
  **/
  @javax.annotation.Nullable
  public String getCasSnsTopicArn() {
    return casSnsTopicArn;
  }

  public void setCasSnsTopicArn(String casSnsTopicArn) {
    this.casSnsTopicArn = casSnsTopicArn;
  }


  public UpdateSettingsParam sellerSnsTopicArn(String sellerSnsTopicArn) {
    this.sellerSnsTopicArn = sellerSnsTopicArn;
    return this;
  }

   /**
   * Get sellerSnsTopicArn
   * @return sellerSnsTopicArn
  **/
  @javax.annotation.Nullable
  public String getSellerSnsTopicArn() {
    return sellerSnsTopicArn;
  }

  public void setSellerSnsTopicArn(String sellerSnsTopicArn) {
    this.sellerSnsTopicArn = sellerSnsTopicArn;
  }


  public UpdateSettingsParam sqsArn(String sqsArn) {
    this.sqsArn = sqsArn;
    return this;
  }

   /**
   * Get sqsArn
   * @return sqsArn
  **/
  @javax.annotation.Nullable
  public String getSqsArn() {
    return sqsArn;
  }

  public void setSqsArn(String sqsArn) {
    this.sqsArn = sqsArn;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSettingsParam updateSettingsParam = (UpdateSettingsParam) o;
    return Objects.equals(this.productCode, updateSettingsParam.productCode) &&
        Objects.equals(this.roleArn, updateSettingsParam.roleArn) &&
        Objects.equals(this.roleExternalId, updateSettingsParam.roleExternalId) &&
        Objects.equals(this.snsTopicArn, updateSettingsParam.snsTopicArn) &&
        Objects.equals(this.casBucketName, updateSettingsParam.casBucketName) &&
        Objects.equals(this.casSnsTopicArn, updateSettingsParam.casSnsTopicArn) &&
        Objects.equals(this.sellerSnsTopicArn, updateSettingsParam.sellerSnsTopicArn) &&
        Objects.equals(this.sqsArn, updateSettingsParam.sqsArn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCode, roleArn, roleExternalId, snsTopicArn, casBucketName, casSnsTopicArn, sellerSnsTopicArn, sqsArn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSettingsParam {\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    roleArn: ").append(toIndentedString(roleArn)).append("\n");
    sb.append("    roleExternalId: ").append(toIndentedString(roleExternalId)).append("\n");
    sb.append("    snsTopicArn: ").append(toIndentedString(snsTopicArn)).append("\n");
    sb.append("    casBucketName: ").append(toIndentedString(casBucketName)).append("\n");
    sb.append("    casSnsTopicArn: ").append(toIndentedString(casSnsTopicArn)).append("\n");
    sb.append("    sellerSnsTopicArn: ").append(toIndentedString(sellerSnsTopicArn)).append("\n");
    sb.append("    sqsArn: ").append(toIndentedString(sqsArn)).append("\n");
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
    openapiFields.add("product_code");
    openapiFields.add("role_arn");
    openapiFields.add("role_external_id");
    openapiFields.add("sns_topic_arn");
    openapiFields.add("cas_bucket_name");
    openapiFields.add("cas_sns_topic_arn");
    openapiFields.add("seller_sns_topic_arn");
    openapiFields.add("sqs_arn");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateSettingsParam
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateSettingsParam.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateSettingsParam is not found in the empty JSON string", UpdateSettingsParam.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateSettingsParam.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateSettingsParam` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("product_code") != null && !jsonObj.get("product_code").isJsonNull()) && !jsonObj.get("product_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `product_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("product_code").toString()));
      }
      if ((jsonObj.get("role_arn") != null && !jsonObj.get("role_arn").isJsonNull()) && !jsonObj.get("role_arn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_arn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role_arn").toString()));
      }
      if ((jsonObj.get("role_external_id") != null && !jsonObj.get("role_external_id").isJsonNull()) && !jsonObj.get("role_external_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_external_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role_external_id").toString()));
      }
      if ((jsonObj.get("sns_topic_arn") != null && !jsonObj.get("sns_topic_arn").isJsonNull()) && !jsonObj.get("sns_topic_arn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sns_topic_arn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sns_topic_arn").toString()));
      }
      if ((jsonObj.get("cas_bucket_name") != null && !jsonObj.get("cas_bucket_name").isJsonNull()) && !jsonObj.get("cas_bucket_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cas_bucket_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cas_bucket_name").toString()));
      }
      if ((jsonObj.get("cas_sns_topic_arn") != null && !jsonObj.get("cas_sns_topic_arn").isJsonNull()) && !jsonObj.get("cas_sns_topic_arn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cas_sns_topic_arn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cas_sns_topic_arn").toString()));
      }
      if ((jsonObj.get("seller_sns_topic_arn") != null && !jsonObj.get("seller_sns_topic_arn").isJsonNull()) && !jsonObj.get("seller_sns_topic_arn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `seller_sns_topic_arn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("seller_sns_topic_arn").toString()));
      }
      if ((jsonObj.get("sqs_arn") != null && !jsonObj.get("sqs_arn").isJsonNull()) && !jsonObj.get("sqs_arn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `sqs_arn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("sqs_arn").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateSettingsParam.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateSettingsParam' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateSettingsParam> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateSettingsParam.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateSettingsParam>() {
           @Override
           public void write(JsonWriter out, UpdateSettingsParam value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateSettingsParam read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateSettingsParam given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateSettingsParam
  * @throws IOException if the JSON string is invalid with respect to UpdateSettingsParam
  */
  public static UpdateSettingsParam fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateSettingsParam.class);
  }

 /**
  * Convert an instance of UpdateSettingsParam to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

