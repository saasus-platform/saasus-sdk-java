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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import saasus.sdk.auth.models.BillingInfo;
import saasus.sdk.auth.models.PlanHistory;
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
 * Tenant
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-07T10:06:23.578394622Z[Etc/UTC]")
public class Tenant {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_ATTRIBUTES = "attributes";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTES)
  private Map<String, Object> attributes = new HashMap<>();

  public static final String SERIALIZED_NAME_BACK_OFFICE_STAFF_EMAIL = "back_office_staff_email";
  @SerializedName(SERIALIZED_NAME_BACK_OFFICE_STAFF_EMAIL)
  private String backOfficeStaffEmail;

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

  public static final String SERIALIZED_NAME_PLAN_HISTORIES = "plan_histories";
  @SerializedName(SERIALIZED_NAME_PLAN_HISTORIES)
  private List<PlanHistory> planHistories = new ArrayList<>();

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_PLAN_ID = "plan_id";
  @SerializedName(SERIALIZED_NAME_PLAN_ID)
  private String planId;

  public static final String SERIALIZED_NAME_BILLING_INFO = "billing_info";
  @SerializedName(SERIALIZED_NAME_BILLING_INFO)
  private BillingInfo billingInfo;

  public Tenant() {
  }

  public Tenant name(String name) {
    this.name = name;
    return this;
  }

   /**
   * tenant name
   * @return name
  **/
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Tenant attributes(Map<String, Object> attributes) {
    this.attributes = attributes;
    return this;
  }

  public Tenant putAttributesItem(String key, Object attributesItem) {
    if (this.attributes == null) {
      this.attributes = new HashMap<>();
    }
    this.attributes.put(key, attributesItem);
    return this;
  }

   /**
   * attribute info
   * @return attributes
  **/
  @javax.annotation.Nonnull
  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }


  public Tenant backOfficeStaffEmail(String backOfficeStaffEmail) {
    this.backOfficeStaffEmail = backOfficeStaffEmail;
    return this;
  }

   /**
   * administrative staff email address
   * @return backOfficeStaffEmail
  **/
  @javax.annotation.Nonnull
  public String getBackOfficeStaffEmail() {
    return backOfficeStaffEmail;
  }

  public void setBackOfficeStaffEmail(String backOfficeStaffEmail) {
    this.backOfficeStaffEmail = backOfficeStaffEmail;
  }


  public Tenant nextPlanId(String nextPlanId) {
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


  public Tenant usingNextPlanFrom(Integer usingNextPlanFrom) {
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


  public Tenant nextPlanTaxRateId(String nextPlanTaxRateId) {
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


  public Tenant prorationBehavior(ProrationBehavior prorationBehavior) {
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


  public Tenant deleteUsage(Boolean deleteUsage) {
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


  public Tenant planHistories(List<PlanHistory> planHistories) {
    this.planHistories = planHistories;
    return this;
  }

  public Tenant addPlanHistoriesItem(PlanHistory planHistoriesItem) {
    if (this.planHistories == null) {
      this.planHistories = new ArrayList<>();
    }
    this.planHistories.add(planHistoriesItem);
    return this;
  }

   /**
   * Plan History
   * @return planHistories
  **/
  @javax.annotation.Nonnull
  public List<PlanHistory> getPlanHistories() {
    return planHistories;
  }

  public void setPlanHistories(List<PlanHistory> planHistories) {
    this.planHistories = planHistories;
  }


  public Tenant id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Tenant planId(String planId) {
    this.planId = planId;
    return this;
  }

   /**
   * Get planId
   * @return planId
  **/
  @javax.annotation.Nullable
  public String getPlanId() {
    return planId;
  }

  public void setPlanId(String planId) {
    this.planId = planId;
  }


  public Tenant billingInfo(BillingInfo billingInfo) {
    this.billingInfo = billingInfo;
    return this;
  }

   /**
   * Get billingInfo
   * @return billingInfo
  **/
  @javax.annotation.Nullable
  public BillingInfo getBillingInfo() {
    return billingInfo;
  }

  public void setBillingInfo(BillingInfo billingInfo) {
    this.billingInfo = billingInfo;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tenant tenant = (Tenant) o;
    return Objects.equals(this.name, tenant.name) &&
        Objects.equals(this.attributes, tenant.attributes) &&
        Objects.equals(this.backOfficeStaffEmail, tenant.backOfficeStaffEmail) &&
        Objects.equals(this.nextPlanId, tenant.nextPlanId) &&
        Objects.equals(this.usingNextPlanFrom, tenant.usingNextPlanFrom) &&
        Objects.equals(this.nextPlanTaxRateId, tenant.nextPlanTaxRateId) &&
        Objects.equals(this.prorationBehavior, tenant.prorationBehavior) &&
        Objects.equals(this.deleteUsage, tenant.deleteUsage) &&
        Objects.equals(this.planHistories, tenant.planHistories) &&
        Objects.equals(this.id, tenant.id) &&
        Objects.equals(this.planId, tenant.planId) &&
        Objects.equals(this.billingInfo, tenant.billingInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, attributes, backOfficeStaffEmail, nextPlanId, usingNextPlanFrom, nextPlanTaxRateId, prorationBehavior, deleteUsage, planHistories, id, planId, billingInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tenant {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    backOfficeStaffEmail: ").append(toIndentedString(backOfficeStaffEmail)).append("\n");
    sb.append("    nextPlanId: ").append(toIndentedString(nextPlanId)).append("\n");
    sb.append("    usingNextPlanFrom: ").append(toIndentedString(usingNextPlanFrom)).append("\n");
    sb.append("    nextPlanTaxRateId: ").append(toIndentedString(nextPlanTaxRateId)).append("\n");
    sb.append("    prorationBehavior: ").append(toIndentedString(prorationBehavior)).append("\n");
    sb.append("    deleteUsage: ").append(toIndentedString(deleteUsage)).append("\n");
    sb.append("    planHistories: ").append(toIndentedString(planHistories)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    billingInfo: ").append(toIndentedString(billingInfo)).append("\n");
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
    openapiFields.add("attributes");
    openapiFields.add("back_office_staff_email");
    openapiFields.add("next_plan_id");
    openapiFields.add("using_next_plan_from");
    openapiFields.add("next_plan_tax_rate_id");
    openapiFields.add("proration_behavior");
    openapiFields.add("delete_usage");
    openapiFields.add("plan_histories");
    openapiFields.add("id");
    openapiFields.add("plan_id");
    openapiFields.add("billing_info");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("attributes");
    openapiRequiredFields.add("back_office_staff_email");
    openapiRequiredFields.add("plan_histories");
    openapiRequiredFields.add("id");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Tenant
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Tenant.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Tenant is not found in the empty JSON string", Tenant.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Tenant.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Tenant` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Tenant.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (!jsonObj.get("back_office_staff_email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `back_office_staff_email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("back_office_staff_email").toString()));
      }
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
      // ensure the json data is an array
      if (!jsonObj.get("plan_histories").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan_histories` to be an array in the JSON string but got `%s`", jsonObj.get("plan_histories").toString()));
      }

      JsonArray jsonArrayplanHistories = jsonObj.getAsJsonArray("plan_histories");
      // validate the required field `plan_histories` (array)
      for (int i = 0; i < jsonArrayplanHistories.size(); i++) {
        PlanHistory.validateJsonElement(jsonArrayplanHistories.get(i));
      };
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("plan_id") != null && !jsonObj.get("plan_id").isJsonNull()) && !jsonObj.get("plan_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("plan_id").toString()));
      }
      // validate the optional field `billing_info`
      if (jsonObj.get("billing_info") != null && !jsonObj.get("billing_info").isJsonNull()) {
        BillingInfo.validateJsonElement(jsonObj.get("billing_info"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Tenant.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Tenant' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Tenant> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Tenant.class));

       return (TypeAdapter<T>) new TypeAdapter<Tenant>() {
           @Override
           public void write(JsonWriter out, Tenant value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Tenant read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Tenant given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Tenant
  * @throws IOException if the JSON string is invalid with respect to Tenant
  */
  public static Tenant fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Tenant.class);
  }

 /**
  * Convert an instance of Tenant to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

