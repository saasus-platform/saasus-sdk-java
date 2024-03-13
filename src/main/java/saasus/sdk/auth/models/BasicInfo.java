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
import saasus.sdk.auth.models.DnsRecord;

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
 * BasicInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-13T11:42:41.920763687Z[Etc/UTC]")
public class BasicInfo {
  public static final String SERIALIZED_NAME_DOMAIN_NAME = "domain_name";
  @SerializedName(SERIALIZED_NAME_DOMAIN_NAME)
  private String domainName;

  public static final String SERIALIZED_NAME_IS_DNS_VALIDATED = "is_dns_validated";
  @SerializedName(SERIALIZED_NAME_IS_DNS_VALIDATED)
  private Boolean isDnsValidated;

  public static final String SERIALIZED_NAME_CERTIFICATE_DNS_RECORD = "certificate_dns_record";
  @SerializedName(SERIALIZED_NAME_CERTIFICATE_DNS_RECORD)
  private DnsRecord certificateDnsRecord;

  public static final String SERIALIZED_NAME_CLOUD_FRONT_DNS_RECORD = "cloud_front_dns_record";
  @SerializedName(SERIALIZED_NAME_CLOUD_FRONT_DNS_RECORD)
  private DnsRecord cloudFrontDnsRecord;

  public static final String SERIALIZED_NAME_DKIM_DNS_RECORDS = "dkim_dns_records";
  @SerializedName(SERIALIZED_NAME_DKIM_DNS_RECORDS)
  private List<DnsRecord> dkimDnsRecords = new ArrayList<>();

  public static final String SERIALIZED_NAME_DEFAULT_DOMAIN_NAME = "default_domain_name";
  @SerializedName(SERIALIZED_NAME_DEFAULT_DOMAIN_NAME)
  private String defaultDomainName;

  public static final String SERIALIZED_NAME_FROM_EMAIL_ADDRESS = "from_email_address";
  @SerializedName(SERIALIZED_NAME_FROM_EMAIL_ADDRESS)
  private String fromEmailAddress;

  public static final String SERIALIZED_NAME_REPLY_EMAIL_ADDRESS = "reply_email_address";
  @SerializedName(SERIALIZED_NAME_REPLY_EMAIL_ADDRESS)
  private String replyEmailAddress;

  public static final String SERIALIZED_NAME_IS_SES_SANDBOX_GRANTED = "is_ses_sandbox_granted";
  @SerializedName(SERIALIZED_NAME_IS_SES_SANDBOX_GRANTED)
  private Boolean isSesSandboxGranted;

  public BasicInfo() {
  }

  public BasicInfo domainName(String domainName) {
    this.domainName = domainName;
    return this;
  }

   /**
   * Domain Name
   * @return domainName
  **/
  @javax.annotation.Nonnull
  public String getDomainName() {
    return domainName;
  }

  public void setDomainName(String domainName) {
    this.domainName = domainName;
  }


  public BasicInfo isDnsValidated(Boolean isDnsValidated) {
    this.isDnsValidated = isDnsValidated;
    return this;
  }

   /**
   * DNS Record Verification Results
   * @return isDnsValidated
  **/
  @javax.annotation.Nonnull
  public Boolean getIsDnsValidated() {
    return isDnsValidated;
  }

  public void setIsDnsValidated(Boolean isDnsValidated) {
    this.isDnsValidated = isDnsValidated;
  }


  public BasicInfo certificateDnsRecord(DnsRecord certificateDnsRecord) {
    this.certificateDnsRecord = certificateDnsRecord;
    return this;
  }

   /**
   * Get certificateDnsRecord
   * @return certificateDnsRecord
  **/
  @javax.annotation.Nonnull
  public DnsRecord getCertificateDnsRecord() {
    return certificateDnsRecord;
  }

  public void setCertificateDnsRecord(DnsRecord certificateDnsRecord) {
    this.certificateDnsRecord = certificateDnsRecord;
  }


  public BasicInfo cloudFrontDnsRecord(DnsRecord cloudFrontDnsRecord) {
    this.cloudFrontDnsRecord = cloudFrontDnsRecord;
    return this;
  }

   /**
   * Get cloudFrontDnsRecord
   * @return cloudFrontDnsRecord
  **/
  @javax.annotation.Nonnull
  public DnsRecord getCloudFrontDnsRecord() {
    return cloudFrontDnsRecord;
  }

  public void setCloudFrontDnsRecord(DnsRecord cloudFrontDnsRecord) {
    this.cloudFrontDnsRecord = cloudFrontDnsRecord;
  }


  public BasicInfo dkimDnsRecords(List<DnsRecord> dkimDnsRecords) {
    this.dkimDnsRecords = dkimDnsRecords;
    return this;
  }

  public BasicInfo addDkimDnsRecordsItem(DnsRecord dkimDnsRecordsItem) {
    if (this.dkimDnsRecords == null) {
      this.dkimDnsRecords = new ArrayList<>();
    }
    this.dkimDnsRecords.add(dkimDnsRecordsItem);
    return this;
  }

   /**
   * DKIM DNS Records
   * @return dkimDnsRecords
  **/
  @javax.annotation.Nonnull
  public List<DnsRecord> getDkimDnsRecords() {
    return dkimDnsRecords;
  }

  public void setDkimDnsRecords(List<DnsRecord> dkimDnsRecords) {
    this.dkimDnsRecords = dkimDnsRecords;
  }


  public BasicInfo defaultDomainName(String defaultDomainName) {
    this.defaultDomainName = defaultDomainName;
    return this;
  }

   /**
   * Default Domain Name
   * @return defaultDomainName
  **/
  @javax.annotation.Nonnull
  public String getDefaultDomainName() {
    return defaultDomainName;
  }

  public void setDefaultDomainName(String defaultDomainName) {
    this.defaultDomainName = defaultDomainName;
  }


  public BasicInfo fromEmailAddress(String fromEmailAddress) {
    this.fromEmailAddress = fromEmailAddress;
    return this;
  }

   /**
   * Sender Email for Authentication Email
   * @return fromEmailAddress
  **/
  @javax.annotation.Nonnull
  public String getFromEmailAddress() {
    return fromEmailAddress;
  }

  public void setFromEmailAddress(String fromEmailAddress) {
    this.fromEmailAddress = fromEmailAddress;
  }


  public BasicInfo replyEmailAddress(String replyEmailAddress) {
    this.replyEmailAddress = replyEmailAddress;
    return this;
  }

   /**
   * Reply-from email address of authentication email
   * @return replyEmailAddress
  **/
  @javax.annotation.Nonnull
  public String getReplyEmailAddress() {
    return replyEmailAddress;
  }

  public void setReplyEmailAddress(String replyEmailAddress) {
    this.replyEmailAddress = replyEmailAddress;
  }


  public BasicInfo isSesSandboxGranted(Boolean isSesSandboxGranted) {
    this.isSesSandboxGranted = isSesSandboxGranted;
    return this;
  }

   /**
   * SES sandbox release and Cognito SES configuration results
   * @return isSesSandboxGranted
  **/
  @javax.annotation.Nonnull
  public Boolean getIsSesSandboxGranted() {
    return isSesSandboxGranted;
  }

  public void setIsSesSandboxGranted(Boolean isSesSandboxGranted) {
    this.isSesSandboxGranted = isSesSandboxGranted;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicInfo basicInfo = (BasicInfo) o;
    return Objects.equals(this.domainName, basicInfo.domainName) &&
        Objects.equals(this.isDnsValidated, basicInfo.isDnsValidated) &&
        Objects.equals(this.certificateDnsRecord, basicInfo.certificateDnsRecord) &&
        Objects.equals(this.cloudFrontDnsRecord, basicInfo.cloudFrontDnsRecord) &&
        Objects.equals(this.dkimDnsRecords, basicInfo.dkimDnsRecords) &&
        Objects.equals(this.defaultDomainName, basicInfo.defaultDomainName) &&
        Objects.equals(this.fromEmailAddress, basicInfo.fromEmailAddress) &&
        Objects.equals(this.replyEmailAddress, basicInfo.replyEmailAddress) &&
        Objects.equals(this.isSesSandboxGranted, basicInfo.isSesSandboxGranted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domainName, isDnsValidated, certificateDnsRecord, cloudFrontDnsRecord, dkimDnsRecords, defaultDomainName, fromEmailAddress, replyEmailAddress, isSesSandboxGranted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicInfo {\n");
    sb.append("    domainName: ").append(toIndentedString(domainName)).append("\n");
    sb.append("    isDnsValidated: ").append(toIndentedString(isDnsValidated)).append("\n");
    sb.append("    certificateDnsRecord: ").append(toIndentedString(certificateDnsRecord)).append("\n");
    sb.append("    cloudFrontDnsRecord: ").append(toIndentedString(cloudFrontDnsRecord)).append("\n");
    sb.append("    dkimDnsRecords: ").append(toIndentedString(dkimDnsRecords)).append("\n");
    sb.append("    defaultDomainName: ").append(toIndentedString(defaultDomainName)).append("\n");
    sb.append("    fromEmailAddress: ").append(toIndentedString(fromEmailAddress)).append("\n");
    sb.append("    replyEmailAddress: ").append(toIndentedString(replyEmailAddress)).append("\n");
    sb.append("    isSesSandboxGranted: ").append(toIndentedString(isSesSandboxGranted)).append("\n");
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
    openapiFields.add("domain_name");
    openapiFields.add("is_dns_validated");
    openapiFields.add("certificate_dns_record");
    openapiFields.add("cloud_front_dns_record");
    openapiFields.add("dkim_dns_records");
    openapiFields.add("default_domain_name");
    openapiFields.add("from_email_address");
    openapiFields.add("reply_email_address");
    openapiFields.add("is_ses_sandbox_granted");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("domain_name");
    openapiRequiredFields.add("is_dns_validated");
    openapiRequiredFields.add("certificate_dns_record");
    openapiRequiredFields.add("cloud_front_dns_record");
    openapiRequiredFields.add("dkim_dns_records");
    openapiRequiredFields.add("default_domain_name");
    openapiRequiredFields.add("from_email_address");
    openapiRequiredFields.add("reply_email_address");
    openapiRequiredFields.add("is_ses_sandbox_granted");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to BasicInfo
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!BasicInfo.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in BasicInfo is not found in the empty JSON string", BasicInfo.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!BasicInfo.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `BasicInfo` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : BasicInfo.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("domain_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `domain_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("domain_name").toString()));
      }
      // validate the required field `certificate_dns_record`
      DnsRecord.validateJsonElement(jsonObj.get("certificate_dns_record"));
      // validate the required field `cloud_front_dns_record`
      DnsRecord.validateJsonElement(jsonObj.get("cloud_front_dns_record"));
      // ensure the json data is an array
      if (!jsonObj.get("dkim_dns_records").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `dkim_dns_records` to be an array in the JSON string but got `%s`", jsonObj.get("dkim_dns_records").toString()));
      }

      JsonArray jsonArraydkimDnsRecords = jsonObj.getAsJsonArray("dkim_dns_records");
      // validate the required field `dkim_dns_records` (array)
      for (int i = 0; i < jsonArraydkimDnsRecords.size(); i++) {
        DnsRecord.validateJsonElement(jsonArraydkimDnsRecords.get(i));
      };
      if (!jsonObj.get("default_domain_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `default_domain_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("default_domain_name").toString()));
      }
      if (!jsonObj.get("from_email_address").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `from_email_address` to be a primitive type in the JSON string but got `%s`", jsonObj.get("from_email_address").toString()));
      }
      if (!jsonObj.get("reply_email_address").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `reply_email_address` to be a primitive type in the JSON string but got `%s`", jsonObj.get("reply_email_address").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!BasicInfo.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'BasicInfo' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<BasicInfo> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(BasicInfo.class));

       return (TypeAdapter<T>) new TypeAdapter<BasicInfo>() {
           @Override
           public void write(JsonWriter out, BasicInfo value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public BasicInfo read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of BasicInfo given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of BasicInfo
  * @throws IOException if the JSON string is invalid with respect to BasicInfo
  */
  public static BasicInfo fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, BasicInfo.class);
  }

 /**
  * Convert an instance of BasicInfo to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

