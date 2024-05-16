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
 * Customer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-16T09:17:41.129104528Z[Etc/UTC]")
public class Customer {
  public static final String SERIALIZED_NAME_CUSTOMER_IDENTIFIER = "customer_identifier";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_IDENTIFIER)
  private String customerIdentifier;

  public static final String SERIALIZED_NAME_CUSTOMER_AWS_ACCOUNT_ID = "customer_aws_account_id";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_AWS_ACCOUNT_ID)
  private String customerAwsAccountId;

  public static final String SERIALIZED_NAME_TENANT_ID = "tenant_id";
  @SerializedName(SERIALIZED_NAME_TENANT_ID)
  private String tenantId;

  public Customer() {
  }

  public Customer customerIdentifier(String customerIdentifier) {
    this.customerIdentifier = customerIdentifier;
    return this;
  }

   /**
   * Get customerIdentifier
   * @return customerIdentifier
  **/
  @javax.annotation.Nonnull
  public String getCustomerIdentifier() {
    return customerIdentifier;
  }

  public void setCustomerIdentifier(String customerIdentifier) {
    this.customerIdentifier = customerIdentifier;
  }


  public Customer customerAwsAccountId(String customerAwsAccountId) {
    this.customerAwsAccountId = customerAwsAccountId;
    return this;
  }

   /**
   * Get customerAwsAccountId
   * @return customerAwsAccountId
  **/
  @javax.annotation.Nonnull
  public String getCustomerAwsAccountId() {
    return customerAwsAccountId;
  }

  public void setCustomerAwsAccountId(String customerAwsAccountId) {
    this.customerAwsAccountId = customerAwsAccountId;
  }


  public Customer tenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

   /**
   * Get tenantId
   * @return tenantId
  **/
  @javax.annotation.Nonnull
  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.customerIdentifier, customer.customerIdentifier) &&
        Objects.equals(this.customerAwsAccountId, customer.customerAwsAccountId) &&
        Objects.equals(this.tenantId, customer.tenantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerIdentifier, customerAwsAccountId, tenantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    sb.append("    customerIdentifier: ").append(toIndentedString(customerIdentifier)).append("\n");
    sb.append("    customerAwsAccountId: ").append(toIndentedString(customerAwsAccountId)).append("\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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
    openapiFields.add("customer_identifier");
    openapiFields.add("customer_aws_account_id");
    openapiFields.add("tenant_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("customer_identifier");
    openapiRequiredFields.add("customer_aws_account_id");
    openapiRequiredFields.add("tenant_id");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Customer
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Customer.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Customer is not found in the empty JSON string", Customer.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Customer.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Customer` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Customer.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("customer_identifier").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `customer_identifier` to be a primitive type in the JSON string but got `%s`", jsonObj.get("customer_identifier").toString()));
      }
      if (!jsonObj.get("customer_aws_account_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `customer_aws_account_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("customer_aws_account_id").toString()));
      }
      if (!jsonObj.get("tenant_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tenant_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tenant_id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Customer.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Customer' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Customer> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Customer.class));

       return (TypeAdapter<T>) new TypeAdapter<Customer>() {
           @Override
           public void write(JsonWriter out, Customer value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Customer read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Customer given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Customer
  * @throws IOException if the JSON string is invalid with respect to Customer
  */
  public static Customer fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Customer.class);
  }

 /**
  * Convert an instance of Customer to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

