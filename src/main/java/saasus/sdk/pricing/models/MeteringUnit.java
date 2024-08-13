/*
 * SaaSus Pricing API Schema
 * SaaSus Pricing API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.pricing.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import saasus.sdk.pricing.models.AggregateUsage;

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

import saasus.sdk.pricing.JSON;

/**
 * MeteringUnit
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-13T07:38:58.928261552Z[Etc/UTC]")
public class MeteringUnit {
  public static final String SERIALIZED_NAME_UNIT_NAME = "unit_name";
  @SerializedName(SERIALIZED_NAME_UNIT_NAME)
  private String unitName;

  public static final String SERIALIZED_NAME_AGGREGATE_USAGE = "aggregate_usage";
  @SerializedName(SERIALIZED_NAME_AGGREGATE_USAGE)
  private AggregateUsage aggregateUsage;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_USED = "used";
  @SerializedName(SERIALIZED_NAME_USED)
  private Boolean used;

  public MeteringUnit() {
  }

  public MeteringUnit unitName(String unitName) {
    this.unitName = unitName;
    return this;
  }

   /**
   * Metering unit name
   * @return unitName
  **/
  @javax.annotation.Nonnull
  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }


  public MeteringUnit aggregateUsage(AggregateUsage aggregateUsage) {
    this.aggregateUsage = aggregateUsage;
    return this;
  }

   /**
   * Get aggregateUsage
   * @return aggregateUsage
  **/
  @javax.annotation.Nullable
  public AggregateUsage getAggregateUsage() {
    return aggregateUsage;
  }

  public void setAggregateUsage(AggregateUsage aggregateUsage) {
    this.aggregateUsage = aggregateUsage;
  }


  public MeteringUnit displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Display name
   * @return displayName
  **/
  @javax.annotation.Nonnull
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public MeteringUnit description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description
   * @return description
  **/
  @javax.annotation.Nonnull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public MeteringUnit id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Universally Unique Identifier
   * @return id
  **/
  @javax.annotation.Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public MeteringUnit used(Boolean used) {
    this.used = used;
    return this;
  }

   /**
   * Metering unit used settings
   * @return used
  **/
  @javax.annotation.Nonnull
  public Boolean getUsed() {
    return used;
  }

  public void setUsed(Boolean used) {
    this.used = used;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeteringUnit meteringUnit = (MeteringUnit) o;
    return Objects.equals(this.unitName, meteringUnit.unitName) &&
        Objects.equals(this.aggregateUsage, meteringUnit.aggregateUsage) &&
        Objects.equals(this.displayName, meteringUnit.displayName) &&
        Objects.equals(this.description, meteringUnit.description) &&
        Objects.equals(this.id, meteringUnit.id) &&
        Objects.equals(this.used, meteringUnit.used);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unitName, aggregateUsage, displayName, description, id, used);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeteringUnit {\n");
    sb.append("    unitName: ").append(toIndentedString(unitName)).append("\n");
    sb.append("    aggregateUsage: ").append(toIndentedString(aggregateUsage)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    used: ").append(toIndentedString(used)).append("\n");
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
    openapiFields.add("unit_name");
    openapiFields.add("aggregate_usage");
    openapiFields.add("display_name");
    openapiFields.add("description");
    openapiFields.add("id");
    openapiFields.add("used");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("unit_name");
    openapiRequiredFields.add("display_name");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("used");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to MeteringUnit
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!MeteringUnit.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in MeteringUnit is not found in the empty JSON string", MeteringUnit.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!MeteringUnit.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `MeteringUnit` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : MeteringUnit.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("unit_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unit_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unit_name").toString()));
      }
      // validate the optional field `aggregate_usage`
      if (jsonObj.get("aggregate_usage") != null && !jsonObj.get("aggregate_usage").isJsonNull()) {
        AggregateUsage.validateJsonElement(jsonObj.get("aggregate_usage"));
      }
      if (!jsonObj.get("display_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display_name").toString()));
      }
      if (!jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if (!jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!MeteringUnit.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'MeteringUnit' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<MeteringUnit> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(MeteringUnit.class));

       return (TypeAdapter<T>) new TypeAdapter<MeteringUnit>() {
           @Override
           public void write(JsonWriter out, MeteringUnit value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public MeteringUnit read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of MeteringUnit given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of MeteringUnit
  * @throws IOException if the JSON string is invalid with respect to MeteringUnit
  */
  public static MeteringUnit fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MeteringUnit.class);
  }

 /**
  * Convert an instance of MeteringUnit to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

