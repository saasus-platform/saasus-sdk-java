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
 * PlanHistory
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-14T09:09:22.553151855Z[Etc/UTC]")
public class PlanHistory {
  public static final String SERIALIZED_NAME_PLAN_ID = "plan_id";
  @SerializedName(SERIALIZED_NAME_PLAN_ID)
  private String planId;

  public static final String SERIALIZED_NAME_PLAN_APPLIED_AT = "plan_applied_at";
  @SerializedName(SERIALIZED_NAME_PLAN_APPLIED_AT)
  private Integer planAppliedAt;

  public static final String SERIALIZED_NAME_TAX_RATE_ID = "tax_rate_id";
  @SerializedName(SERIALIZED_NAME_TAX_RATE_ID)
  private String taxRateId;

  public static final String SERIALIZED_NAME_PRORATION_BEHAVIOR = "proration_behavior";
  @SerializedName(SERIALIZED_NAME_PRORATION_BEHAVIOR)
  private ProrationBehavior prorationBehavior;

  public static final String SERIALIZED_NAME_DELETE_USAGE = "delete_usage";
  @SerializedName(SERIALIZED_NAME_DELETE_USAGE)
  private Boolean deleteUsage;

  public PlanHistory() {
  }

  public PlanHistory planId(String planId) {
    this.planId = planId;
    return this;
  }

   /**
   * Get planId
   * @return planId
  **/
  @javax.annotation.Nonnull
  public String getPlanId() {
    return planId;
  }

  public void setPlanId(String planId) {
    this.planId = planId;
  }


  public PlanHistory planAppliedAt(Integer planAppliedAt) {
    this.planAppliedAt = planAppliedAt;
    return this;
  }

   /**
   * Registration date
   * @return planAppliedAt
  **/
  @javax.annotation.Nonnull
  public Integer getPlanAppliedAt() {
    return planAppliedAt;
  }

  public void setPlanAppliedAt(Integer planAppliedAt) {
    this.planAppliedAt = planAppliedAt;
  }


  public PlanHistory taxRateId(String taxRateId) {
    this.taxRateId = taxRateId;
    return this;
  }

   /**
   * Get taxRateId
   * @return taxRateId
  **/
  @javax.annotation.Nullable
  public String getTaxRateId() {
    return taxRateId;
  }

  public void setTaxRateId(String taxRateId) {
    this.taxRateId = taxRateId;
  }


  public PlanHistory prorationBehavior(ProrationBehavior prorationBehavior) {
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


  public PlanHistory deleteUsage(Boolean deleteUsage) {
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
    PlanHistory planHistory = (PlanHistory) o;
    return Objects.equals(this.planId, planHistory.planId) &&
        Objects.equals(this.planAppliedAt, planHistory.planAppliedAt) &&
        Objects.equals(this.taxRateId, planHistory.taxRateId) &&
        Objects.equals(this.prorationBehavior, planHistory.prorationBehavior) &&
        Objects.equals(this.deleteUsage, planHistory.deleteUsage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, planAppliedAt, taxRateId, prorationBehavior, deleteUsage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanHistory {\n");
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    planAppliedAt: ").append(toIndentedString(planAppliedAt)).append("\n");
    sb.append("    taxRateId: ").append(toIndentedString(taxRateId)).append("\n");
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
    openapiFields.add("plan_id");
    openapiFields.add("plan_applied_at");
    openapiFields.add("tax_rate_id");
    openapiFields.add("proration_behavior");
    openapiFields.add("delete_usage");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("plan_id");
    openapiRequiredFields.add("plan_applied_at");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PlanHistory
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PlanHistory.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PlanHistory is not found in the empty JSON string", PlanHistory.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PlanHistory.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PlanHistory` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PlanHistory.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("plan_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("plan_id").toString()));
      }
      if ((jsonObj.get("tax_rate_id") != null && !jsonObj.get("tax_rate_id").isJsonNull()) && !jsonObj.get("tax_rate_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tax_rate_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tax_rate_id").toString()));
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
       if (!PlanHistory.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PlanHistory' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PlanHistory> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PlanHistory.class));

       return (TypeAdapter<T>) new TypeAdapter<PlanHistory>() {
           @Override
           public void write(JsonWriter out, PlanHistory value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PlanHistory read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PlanHistory given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PlanHistory
  * @throws IOException if the JSON string is invalid with respect to PlanHistory
  */
  public static PlanHistory fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PlanHistory.class);
  }

 /**
  * Convert an instance of PlanHistory to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

