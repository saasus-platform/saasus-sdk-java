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
import saasus.sdk.auth.models.BillingAddress;
import saasus.sdk.auth.models.InvoiceLanguage;

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
 * BillingInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T09:43:05.063392808Z[Etc/UTC]")
public class BillingInfo {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_ADDRESS = "address";
  @SerializedName(SERIALIZED_NAME_ADDRESS)
  private BillingAddress address;

  public static final String SERIALIZED_NAME_INVOICE_LANGUAGE = "invoice_language";
  @SerializedName(SERIALIZED_NAME_INVOICE_LANGUAGE)
  private InvoiceLanguage invoiceLanguage;

  public BillingInfo() {
  }

  public BillingInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Tenant name for billing
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public BillingInfo address(BillingAddress address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nonnull
  public BillingAddress getAddress() {
    return address;
  }

  public void setAddress(BillingAddress address) {
    this.address = address;
  }


  public BillingInfo invoiceLanguage(InvoiceLanguage invoiceLanguage) {
    this.invoiceLanguage = invoiceLanguage;
    return this;
  }

   /**
   * Get invoiceLanguage
   * @return invoiceLanguage
  **/
  @javax.annotation.Nonnull
  public InvoiceLanguage getInvoiceLanguage() {
    return invoiceLanguage;
  }

  public void setInvoiceLanguage(InvoiceLanguage invoiceLanguage) {
    this.invoiceLanguage = invoiceLanguage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingInfo billingInfo = (BillingInfo) o;
    return Objects.equals(this.name, billingInfo.name) &&
        Objects.equals(this.address, billingInfo.address) &&
        Objects.equals(this.invoiceLanguage, billingInfo.invoiceLanguage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, invoiceLanguage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingInfo {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    invoiceLanguage: ").append(toIndentedString(invoiceLanguage)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("address");
    openapiFields.add("invoice_language");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("address");
    openapiRequiredFields.add("invoice_language");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to BillingInfo
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!BillingInfo.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in BillingInfo is not found in the empty JSON string", BillingInfo.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!BillingInfo.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `BillingInfo` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : BillingInfo.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      // validate the required field `address`
      BillingAddress.validateJsonElement(jsonObj.get("address"));
      // validate the required field `invoice_language`
      InvoiceLanguage.validateJsonElement(jsonObj.get("invoice_language"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!BillingInfo.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'BillingInfo' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<BillingInfo> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(BillingInfo.class));

       return (TypeAdapter<T>) new TypeAdapter<BillingInfo>() {
           @Override
           public void write(JsonWriter out, BillingInfo value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public BillingInfo read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of BillingInfo given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of BillingInfo
  * @throws IOException if the JSON string is invalid with respect to BillingInfo
  */
  public static BillingInfo fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, BillingInfo.class);
  }

 /**
  * Convert an instance of BillingInfo to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

