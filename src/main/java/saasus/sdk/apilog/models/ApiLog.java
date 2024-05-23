/*
 * SaaSus ApiLog API Schema
 * SaaSus ApiLog API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.apilog.models;

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

import saasus.sdk.apilog.JSON;

/**
 * ApiLog
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-23T14:26:20.714688393Z[Etc/UTC]")
public class ApiLog {
  public static final String SERIALIZED_NAME_TRACE_ID = "trace_id";
  @SerializedName(SERIALIZED_NAME_TRACE_ID)
  private String traceId;

  public static final String SERIALIZED_NAME_API_LOG_ID = "api_log_id";
  @SerializedName(SERIALIZED_NAME_API_LOG_ID)
  private String apiLogId;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private Integer createdAt;

  public static final String SERIALIZED_NAME_CREATED_DATE = "created_date";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE)
  private String createdDate;

  public static final String SERIALIZED_NAME_TTL = "ttl";
  @SerializedName(SERIALIZED_NAME_TTL)
  private Integer ttl;

  public static final String SERIALIZED_NAME_REQUEST_METHOD = "request_method";
  @SerializedName(SERIALIZED_NAME_REQUEST_METHOD)
  private String requestMethod;

  public static final String SERIALIZED_NAME_SAAS_ID = "saas_id";
  @SerializedName(SERIALIZED_NAME_SAAS_ID)
  private String saasId;

  public static final String SERIALIZED_NAME_API_KEY = "api_key";
  @SerializedName(SERIALIZED_NAME_API_KEY)
  private String apiKey;

  public static final String SERIALIZED_NAME_RESPONSE_STATUS = "response_status";
  @SerializedName(SERIALIZED_NAME_RESPONSE_STATUS)
  private String responseStatus;

  public static final String SERIALIZED_NAME_REQUEST_URI = "request_uri";
  @SerializedName(SERIALIZED_NAME_REQUEST_URI)
  private String requestUri;

  public static final String SERIALIZED_NAME_REMOTE_ADDRESS = "remote_address";
  @SerializedName(SERIALIZED_NAME_REMOTE_ADDRESS)
  private String remoteAddress;

  public static final String SERIALIZED_NAME_REFERER = "referer";
  @SerializedName(SERIALIZED_NAME_REFERER)
  private String referer;

  public static final String SERIALIZED_NAME_REQUEST_BODY = "request_body";
  @SerializedName(SERIALIZED_NAME_REQUEST_BODY)
  private String requestBody;

  public static final String SERIALIZED_NAME_RESPONSE_BODY = "response_body";
  @SerializedName(SERIALIZED_NAME_RESPONSE_BODY)
  private String responseBody;

  public ApiLog() {
  }

  public ApiLog traceId(String traceId) {
    this.traceId = traceId;
    return this;
  }

   /**
   * Trace ID
   * @return traceId
  **/
  @javax.annotation.Nonnull
  public String getTraceId() {
    return traceId;
  }

  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }


  public ApiLog apiLogId(String apiLogId) {
    this.apiLogId = apiLogId;
    return this;
  }

   /**
   * Get apiLogId
   * @return apiLogId
  **/
  @javax.annotation.Nonnull
  public String getApiLogId() {
    return apiLogId;
  }

  public void setApiLogId(String apiLogId) {
    this.apiLogId = apiLogId;
  }


  public ApiLog createdAt(Integer createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Epoch second of API log registration timestamp
   * @return createdAt
  **/
  @javax.annotation.Nonnull
  public Integer getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }


  public ApiLog createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * API log registration date
   * @return createdDate
  **/
  @javax.annotation.Nonnull
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }


  public ApiLog ttl(Integer ttl) {
    this.ttl = ttl;
    return this;
  }

   /**
   * Epoch second of planned API log deletion
   * @return ttl
  **/
  @javax.annotation.Nonnull
  public Integer getTtl() {
    return ttl;
  }

  public void setTtl(Integer ttl) {
    this.ttl = ttl;
  }


  public ApiLog requestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
    return this;
  }

   /**
   * Request method
   * @return requestMethod
  **/
  @javax.annotation.Nonnull
  public String getRequestMethod() {
    return requestMethod;
  }

  public void setRequestMethod(String requestMethod) {
    this.requestMethod = requestMethod;
  }


  public ApiLog saasId(String saasId) {
    this.saasId = saasId;
    return this;
  }

   /**
   * Get saasId
   * @return saasId
  **/
  @javax.annotation.Nonnull
  public String getSaasId() {
    return saasId;
  }

  public void setSaasId(String saasId) {
    this.saasId = saasId;
  }


  public ApiLog apiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

   /**
   * API Key
   * @return apiKey
  **/
  @javax.annotation.Nonnull
  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }


  public ApiLog responseStatus(String responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

   /**
   * Response status
   * @return responseStatus
  **/
  @javax.annotation.Nonnull
  public String getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(String responseStatus) {
    this.responseStatus = responseStatus;
  }


  public ApiLog requestUri(String requestUri) {
    this.requestUri = requestUri;
    return this;
  }

   /**
   * Request URI
   * @return requestUri
  **/
  @javax.annotation.Nonnull
  public String getRequestUri() {
    return requestUri;
  }

  public void setRequestUri(String requestUri) {
    this.requestUri = requestUri;
  }


  public ApiLog remoteAddress(String remoteAddress) {
    this.remoteAddress = remoteAddress;
    return this;
  }

   /**
   * Client IP Address
   * @return remoteAddress
  **/
  @javax.annotation.Nonnull
  public String getRemoteAddress() {
    return remoteAddress;
  }

  public void setRemoteAddress(String remoteAddress) {
    this.remoteAddress = remoteAddress;
  }


  public ApiLog referer(String referer) {
    this.referer = referer;
    return this;
  }

   /**
   * The referrer of the request
   * @return referer
  **/
  @javax.annotation.Nonnull
  public String getReferer() {
    return referer;
  }

  public void setReferer(String referer) {
    this.referer = referer;
  }


  public ApiLog requestBody(String requestBody) {
    this.requestBody = requestBody;
    return this;
  }

   /**
   * The body of the request
   * @return requestBody
  **/
  @javax.annotation.Nonnull
  public String getRequestBody() {
    return requestBody;
  }

  public void setRequestBody(String requestBody) {
    this.requestBody = requestBody;
  }


  public ApiLog responseBody(String responseBody) {
    this.responseBody = responseBody;
    return this;
  }

   /**
   * The body of the response
   * @return responseBody
  **/
  @javax.annotation.Nonnull
  public String getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiLog apiLog = (ApiLog) o;
    return Objects.equals(this.traceId, apiLog.traceId) &&
        Objects.equals(this.apiLogId, apiLog.apiLogId) &&
        Objects.equals(this.createdAt, apiLog.createdAt) &&
        Objects.equals(this.createdDate, apiLog.createdDate) &&
        Objects.equals(this.ttl, apiLog.ttl) &&
        Objects.equals(this.requestMethod, apiLog.requestMethod) &&
        Objects.equals(this.saasId, apiLog.saasId) &&
        Objects.equals(this.apiKey, apiLog.apiKey) &&
        Objects.equals(this.responseStatus, apiLog.responseStatus) &&
        Objects.equals(this.requestUri, apiLog.requestUri) &&
        Objects.equals(this.remoteAddress, apiLog.remoteAddress) &&
        Objects.equals(this.referer, apiLog.referer) &&
        Objects.equals(this.requestBody, apiLog.requestBody) &&
        Objects.equals(this.responseBody, apiLog.responseBody);
  }

  @Override
  public int hashCode() {
    return Objects.hash(traceId, apiLogId, createdAt, createdDate, ttl, requestMethod, saasId, apiKey, responseStatus, requestUri, remoteAddress, referer, requestBody, responseBody);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiLog {\n");
    sb.append("    traceId: ").append(toIndentedString(traceId)).append("\n");
    sb.append("    apiLogId: ").append(toIndentedString(apiLogId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
    sb.append("    requestMethod: ").append(toIndentedString(requestMethod)).append("\n");
    sb.append("    saasId: ").append(toIndentedString(saasId)).append("\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    requestUri: ").append(toIndentedString(requestUri)).append("\n");
    sb.append("    remoteAddress: ").append(toIndentedString(remoteAddress)).append("\n");
    sb.append("    referer: ").append(toIndentedString(referer)).append("\n");
    sb.append("    requestBody: ").append(toIndentedString(requestBody)).append("\n");
    sb.append("    responseBody: ").append(toIndentedString(responseBody)).append("\n");
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
    openapiFields.add("trace_id");
    openapiFields.add("api_log_id");
    openapiFields.add("created_at");
    openapiFields.add("created_date");
    openapiFields.add("ttl");
    openapiFields.add("request_method");
    openapiFields.add("saas_id");
    openapiFields.add("api_key");
    openapiFields.add("response_status");
    openapiFields.add("request_uri");
    openapiFields.add("remote_address");
    openapiFields.add("referer");
    openapiFields.add("request_body");
    openapiFields.add("response_body");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("trace_id");
    openapiRequiredFields.add("api_log_id");
    openapiRequiredFields.add("created_at");
    openapiRequiredFields.add("created_date");
    openapiRequiredFields.add("ttl");
    openapiRequiredFields.add("request_method");
    openapiRequiredFields.add("saas_id");
    openapiRequiredFields.add("api_key");
    openapiRequiredFields.add("response_status");
    openapiRequiredFields.add("request_uri");
    openapiRequiredFields.add("remote_address");
    openapiRequiredFields.add("referer");
    openapiRequiredFields.add("request_body");
    openapiRequiredFields.add("response_body");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ApiLog
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ApiLog.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ApiLog is not found in the empty JSON string", ApiLog.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ApiLog.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ApiLog` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ApiLog.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("trace_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `trace_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("trace_id").toString()));
      }
      if (!jsonObj.get("api_log_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `api_log_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("api_log_id").toString()));
      }
      if (!jsonObj.get("created_date").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created_date` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created_date").toString()));
      }
      if (!jsonObj.get("request_method").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `request_method` to be a primitive type in the JSON string but got `%s`", jsonObj.get("request_method").toString()));
      }
      if (!jsonObj.get("saas_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `saas_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("saas_id").toString()));
      }
      if (!jsonObj.get("api_key").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `api_key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("api_key").toString()));
      }
      if (!jsonObj.get("response_status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `response_status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("response_status").toString()));
      }
      if (!jsonObj.get("request_uri").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `request_uri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("request_uri").toString()));
      }
      if (!jsonObj.get("remote_address").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `remote_address` to be a primitive type in the JSON string but got `%s`", jsonObj.get("remote_address").toString()));
      }
      if (!jsonObj.get("referer").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `referer` to be a primitive type in the JSON string but got `%s`", jsonObj.get("referer").toString()));
      }
      if (!jsonObj.get("request_body").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `request_body` to be a primitive type in the JSON string but got `%s`", jsonObj.get("request_body").toString()));
      }
      if (!jsonObj.get("response_body").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `response_body` to be a primitive type in the JSON string but got `%s`", jsonObj.get("response_body").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ApiLog.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ApiLog' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ApiLog> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ApiLog.class));

       return (TypeAdapter<T>) new TypeAdapter<ApiLog>() {
           @Override
           public void write(JsonWriter out, ApiLog value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ApiLog read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ApiLog given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ApiLog
  * @throws IOException if the JSON string is invalid with respect to ApiLog
  */
  public static ApiLog fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ApiLog.class);
  }

 /**
  * Convert an instance of ApiLog to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

