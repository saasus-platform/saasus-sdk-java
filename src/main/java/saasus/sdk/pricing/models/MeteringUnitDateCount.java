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
 * MeteringUnitDateCount
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-27T08:48:33.533245744Z[Etc/UTC]")
public class MeteringUnitDateCount {
  public static final String SERIALIZED_NAME_METERING_UNIT_NAME = "metering_unit_name";
  @SerializedName(SERIALIZED_NAME_METERING_UNIT_NAME)
  private String meteringUnitName;

  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private String date;

  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;

  public MeteringUnitDateCount() {
  }

  public MeteringUnitDateCount meteringUnitName(String meteringUnitName) {
    this.meteringUnitName = meteringUnitName;
    return this;
  }

   /**
   * Metering unit name
   * @return meteringUnitName
  **/
  @javax.annotation.Nonnull
  public String getMeteringUnitName() {
    return meteringUnitName;
  }

  public void setMeteringUnitName(String meteringUnitName) {
    this.meteringUnitName = meteringUnitName;
  }


  public MeteringUnitDateCount date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Date
   * @return date
  **/
  @javax.annotation.Nonnull
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  public MeteringUnitDateCount count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Count
   * @return count
  **/
  @javax.annotation.Nonnull
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeteringUnitDateCount meteringUnitDateCount = (MeteringUnitDateCount) o;
    return Objects.equals(this.meteringUnitName, meteringUnitDateCount.meteringUnitName) &&
        Objects.equals(this.date, meteringUnitDateCount.date) &&
        Objects.equals(this.count, meteringUnitDateCount.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meteringUnitName, date, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeteringUnitDateCount {\n");
    sb.append("    meteringUnitName: ").append(toIndentedString(meteringUnitName)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
    openapiFields.add("metering_unit_name");
    openapiFields.add("date");
    openapiFields.add("count");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("metering_unit_name");
    openapiRequiredFields.add("date");
    openapiRequiredFields.add("count");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to MeteringUnitDateCount
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!MeteringUnitDateCount.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in MeteringUnitDateCount is not found in the empty JSON string", MeteringUnitDateCount.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!MeteringUnitDateCount.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `MeteringUnitDateCount` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : MeteringUnitDateCount.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("metering_unit_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `metering_unit_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("metering_unit_name").toString()));
      }
      if (!jsonObj.get("date").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!MeteringUnitDateCount.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'MeteringUnitDateCount' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<MeteringUnitDateCount> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(MeteringUnitDateCount.class));

       return (TypeAdapter<T>) new TypeAdapter<MeteringUnitDateCount>() {
           @Override
           public void write(JsonWriter out, MeteringUnitDateCount value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public MeteringUnitDateCount read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of MeteringUnitDateCount given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of MeteringUnitDateCount
  * @throws IOException if the JSON string is invalid with respect to MeteringUnitDateCount
  */
  public static MeteringUnitDateCount fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MeteringUnitDateCount.class);
  }

 /**
  * Convert an instance of MeteringUnitDateCount to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

