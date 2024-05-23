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
import saasus.sdk.auth.models.ProrationBehavior;

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
 * PlanReservation
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-23T12:17:13.780770927Z[Etc/UTC]")
public class PlanReservation {
  public static final String SERIALIZED_NAME_NEXT_PLAN_ID = "next_plan_id";
  @SerializedName(SERIALIZED_NAME_NEXT_PLAN_ID)
  private String nextPlanId;

  public static final String SERIALIZED_NAME_USING_NEXT_PLAN_FROM = "using_next_plan_from";
  @SerializedName(SERIALIZED_NAME_USING_NEXT_PLAN_FROM)
  private Integer usingNextPlanFrom;

  public static final String SERIALIZED_NAME_NEXT_PLAN_TAX_RATE_ID = "next_plan_tax_rate_id";
  @SerializedName(SERIALIZED_NAME_NEXT_PLAN_TAX_RATE_ID)
  private String nextPlanTaxRateId;

  public static final String SERIALIZED_NAME_PRORATION_BEHAVIOR = "proration_behavior";
  @SerializedName(SERIALIZED_NAME_PRORATION_BEHAVIOR)
  private ProrationBehavior prorationBehavior;

  public static final String SERIALIZED_NAME_DELETE_USAGE = "delete_usage";
  @SerializedName(SERIALIZED_NAME_DELETE_USAGE)
  private Boolean deleteUsage;

  public PlanReservation() {
  }

  public PlanReservation nextPlanId(String nextPlanId) {
    this.nextPlanId = nextPlanId;
    return this;
  }

   /**
   * Get nextPlanId
   * @return nextPlanId
  **/
  @javax.annotation.Nullable
  public String getNextPlanId() {
    return nextPlanId;
  }

  public void setNextPlanId(String nextPlanId) {
    this.nextPlanId = nextPlanId;
  }


  public PlanReservation usingNextPlanFrom(Integer usingNextPlanFrom) {
    this.usingNextPlanFrom = usingNextPlanFrom;
    return this;
  }

   /**
   * Next billing plan start time (When using stripe, you can create a subscription that starts at the beginning of the current month by specifying 00:00 (UTC) at the beginning of the current month. Ex. 1672531200 for January 2023.) 
   * @return usingNextPlanFrom
  **/
  @javax.annotation.Nullable
  public Integer getUsingNextPlanFrom() {
    return usingNextPlanFrom;
  }

  public void setUsingNextPlanFrom(Integer usingNextPlanFrom) {
    this.usingNextPlanFrom = usingNextPlanFrom;
  }


  public PlanReservation nextPlanTaxRateId(String nextPlanTaxRateId) {
    this.nextPlanTaxRateId = nextPlanTaxRateId;
    return this;
  }

   /**
   * Get nextPlanTaxRateId
   * @return nextPlanTaxRateId
  **/
  @javax.annotation.Nullable
  public String getNextPlanTaxRateId() {
    return nextPlanTaxRateId;
  }

  public void setNextPlanTaxRateId(String nextPlanTaxRateId) {
    this.nextPlanTaxRateId = nextPlanTaxRateId;
  }


  public PlanReservation prorationBehavior(ProrationBehavior prorationBehavior) {
    this.prorationBehavior = prorationBehavior;
    return this;
  }

   /**
   * Get prorationBehavior
   * @return prorationBehavior
  **/
  @javax.annotation.Nullable
  public ProrationBehavior getProrationBehavior() {
    return prorationBehavior;
  }

  public void setProrationBehavior(ProrationBehavior prorationBehavior) {
    this.prorationBehavior = prorationBehavior;
  }


  public PlanReservation deleteUsage(Boolean deleteUsage) {
    this.deleteUsage = deleteUsage;
    return this;
  }

   /**
   * If you have a stripe linkage,  you can set whether to delete pay-as-you-go items when changing plans. When you change plan, you can remove all pay-as-you-go items included in your current subscription to stop being billed based on pay-as-you-go items. The recorded usage is cleared immediately. Since it cannot be restored, please note that plan change reservations with delete_usage set to true cannot be canceled. 
   * @return deleteUsage
  **/
  @javax.annotation.Nullable
  public Boolean getDeleteUsage() {
    return deleteUsage;
  }

  public void setDeleteUsage(Boolean deleteUsage) {
    this.deleteUsage = deleteUsage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanReservation planReservation = (PlanReservation) o;
    return Objects.equals(this.nextPlanId, planReservation.nextPlanId) &&
        Objects.equals(this.usingNextPlanFrom, planReservation.usingNextPlanFrom) &&
        Objects.equals(this.nextPlanTaxRateId, planReservation.nextPlanTaxRateId) &&
        Objects.equals(this.prorationBehavior, planReservation.prorationBehavior) &&
        Objects.equals(this.deleteUsage, planReservation.deleteUsage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextPlanId, usingNextPlanFrom, nextPlanTaxRateId, prorationBehavior, deleteUsage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanReservation {\n");
    sb.append("    nextPlanId: ").append(toIndentedString(nextPlanId)).append("\n");
    sb.append("    usingNextPlanFrom: ").append(toIndentedString(usingNextPlanFrom)).append("\n");
    sb.append("    nextPlanTaxRateId: ").append(toIndentedString(nextPlanTaxRateId)).append("\n");
    sb.append("    prorationBehavior: ").append(toIndentedString(prorationBehavior)).append("\n");
    sb.append("    deleteUsage: ").append(toIndentedString(deleteUsage)).append("\n");
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
    openapiFields.add("next_plan_id");
    openapiFields.add("using_next_plan_from");
    openapiFields.add("next_plan_tax_rate_id");
    openapiFields.add("proration_behavior");
    openapiFields.add("delete_usage");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PlanReservation
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PlanReservation.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PlanReservation is not found in the empty JSON string", PlanReservation.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PlanReservation.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PlanReservation` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("next_plan_id") != null && !jsonObj.get("next_plan_id").isJsonNull()) && !jsonObj.get("next_plan_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `next_plan_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("next_plan_id").toString()));
      }
      if ((jsonObj.get("next_plan_tax_rate_id") != null && !jsonObj.get("next_plan_tax_rate_id").isJsonNull()) && !jsonObj.get("next_plan_tax_rate_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `next_plan_tax_rate_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("next_plan_tax_rate_id").toString()));
      }
      // validate the optional field `proration_behavior`
      if (jsonObj.get("proration_behavior") != null && !jsonObj.get("proration_behavior").isJsonNull()) {
        ProrationBehavior.validateJsonElement(jsonObj.get("proration_behavior"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PlanReservation.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PlanReservation' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PlanReservation> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PlanReservation.class));

       return (TypeAdapter<T>) new TypeAdapter<PlanReservation>() {
           @Override
           public void write(JsonWriter out, PlanReservation value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PlanReservation read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PlanReservation given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PlanReservation
  * @throws IOException if the JSON string is invalid with respect to PlanReservation
  */
  public static PlanReservation fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PlanReservation.class);
  }

 /**
  * Convert an instance of PlanReservation to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

