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
 * MeteringUnitTimestampCount
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:09:27.364679080Z[Etc/UTC]")
public class MeteringUnitTimestampCount {
  public static final String SERIALIZED_NAME_METERING_UNIT_NAME = "metering_unit_name";
  @SerializedName(SERIALIZED_NAME_METERING_UNIT_NAME)
  private String meteringUnitName;

  public static final String SERIALIZED_NAME_TIMESTAMP = "timestamp";
  @SerializedName(SERIALIZED_NAME_TIMESTAMP)
  private Integer timestamp;

  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;

  public MeteringUnitTimestampCount() {
  }

  public MeteringUnitTimestampCount meteringUnitName(String meteringUnitName) {
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


  public MeteringUnitTimestampCount timestamp(Integer timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Timestamp
   * @return timestamp
  **/
  @javax.annotation.Nonnull
  public Integer getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Integer timestamp) {
    this.timestamp = timestamp;
  }


  public MeteringUnitTimestampCount count(Integer count) {
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
    MeteringUnitTimestampCount meteringUnitTimestampCount = (MeteringUnitTimestampCount) o;
    return Objects.equals(this.meteringUnitName, meteringUnitTimestampCount.meteringUnitName) &&
        Objects.equals(this.timestamp, meteringUnitTimestampCount.timestamp) &&
        Objects.equals(this.count, meteringUnitTimestampCount.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meteringUnitName, timestamp, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeteringUnitTimestampCount {\n");
    sb.append("    meteringUnitName: ").append(toIndentedString(meteringUnitName)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
    openapiFields.add("timestamp");
    openapiFields.add("count");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("metering_unit_name");
    openapiRequiredFields.add("timestamp");
    openapiRequiredFields.add("count");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to MeteringUnitTimestampCount
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!MeteringUnitTimestampCount.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in MeteringUnitTimestampCount is not found in the empty JSON string", MeteringUnitTimestampCount.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!MeteringUnitTimestampCount.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `MeteringUnitTimestampCount` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : MeteringUnitTimestampCount.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("metering_unit_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `metering_unit_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("metering_unit_name").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!MeteringUnitTimestampCount.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'MeteringUnitTimestampCount' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<MeteringUnitTimestampCount> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(MeteringUnitTimestampCount.class));

       return (TypeAdapter<T>) new TypeAdapter<MeteringUnitTimestampCount>() {
           @Override
           public void write(JsonWriter out, MeteringUnitTimestampCount value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public MeteringUnitTimestampCount read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of MeteringUnitTimestampCount given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of MeteringUnitTimestampCount
  * @throws IOException if the JSON string is invalid with respect to MeteringUnitTimestampCount
  */
  public static MeteringUnitTimestampCount fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MeteringUnitTimestampCount.class);
  }

 /**
  * Convert an instance of MeteringUnitTimestampCount to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

