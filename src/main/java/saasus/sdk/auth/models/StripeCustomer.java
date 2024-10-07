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
 * StripeCustomer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-07T03:24:10.100234378Z[Etc/UTC]")
public class StripeCustomer {
  public static final String SERIALIZED_NAME_CUSTOMER_ID = "customer_id";
  @SerializedName(SERIALIZED_NAME_CUSTOMER_ID)
  private String customerId;

  public static final String SERIALIZED_NAME_SUBSCRIPTION_SCHEDULE_ID = "subscription_schedule_id";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_SCHEDULE_ID)
  private String subscriptionScheduleId;

  public StripeCustomer() {
  }

  public StripeCustomer customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * stripe Customer ID
   * @return customerId
  **/
  @javax.annotation.Nonnull
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public StripeCustomer subscriptionScheduleId(String subscriptionScheduleId) {
    this.subscriptionScheduleId = subscriptionScheduleId;
    return this;
  }

   /**
   * stripe Subscription Schedule ID
   * @return subscriptionScheduleId
  **/
  @javax.annotation.Nonnull
  public String getSubscriptionScheduleId() {
    return subscriptionScheduleId;
  }

  public void setSubscriptionScheduleId(String subscriptionScheduleId) {
    this.subscriptionScheduleId = subscriptionScheduleId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StripeCustomer stripeCustomer = (StripeCustomer) o;
    return Objects.equals(this.customerId, stripeCustomer.customerId) &&
        Objects.equals(this.subscriptionScheduleId, stripeCustomer.subscriptionScheduleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, subscriptionScheduleId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StripeCustomer {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    subscriptionScheduleId: ").append(toIndentedString(subscriptionScheduleId)).append("\n");
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
    openapiFields.add("customer_id");
    openapiFields.add("subscription_schedule_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("customer_id");
    openapiRequiredFields.add("subscription_schedule_id");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to StripeCustomer
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!StripeCustomer.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in StripeCustomer is not found in the empty JSON string", StripeCustomer.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!StripeCustomer.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `StripeCustomer` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : StripeCustomer.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("customer_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `customer_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("customer_id").toString()));
      }
      if (!jsonObj.get("subscription_schedule_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `subscription_schedule_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("subscription_schedule_id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!StripeCustomer.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'StripeCustomer' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<StripeCustomer> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(StripeCustomer.class));

       return (TypeAdapter<T>) new TypeAdapter<StripeCustomer>() {
           @Override
           public void write(JsonWriter out, StripeCustomer value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public StripeCustomer read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of StripeCustomer given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of StripeCustomer
  * @throws IOException if the JSON string is invalid with respect to StripeCustomer
  */
  public static StripeCustomer fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, StripeCustomer.class);
  }

 /**
  * Convert an instance of StripeCustomer to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

