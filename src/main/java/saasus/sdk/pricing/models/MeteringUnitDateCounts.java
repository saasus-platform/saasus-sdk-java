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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import saasus.sdk.pricing.models.MeteringUnitDateCount;

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
 * MeteringUnitDateCounts
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-09T09:27:14.878317319Z[Etc/UTC]")
public class MeteringUnitDateCounts {
  public static final String SERIALIZED_NAME_COUNTS = "counts";
  @SerializedName(SERIALIZED_NAME_COUNTS)
  private List<MeteringUnitDateCount> counts = new ArrayList<>();

  public MeteringUnitDateCounts() {
  }

  public MeteringUnitDateCounts counts(List<MeteringUnitDateCount> counts) {
    this.counts = counts;
    return this;
  }

  public MeteringUnitDateCounts addCountsItem(MeteringUnitDateCount countsItem) {
    if (this.counts == null) {
      this.counts = new ArrayList<>();
    }
    this.counts.add(countsItem);
    return this;
  }

   /**
   * Get counts
   * @return counts
  **/
  @javax.annotation.Nonnull
  public List<MeteringUnitDateCount> getCounts() {
    return counts;
  }

  public void setCounts(List<MeteringUnitDateCount> counts) {
    this.counts = counts;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeteringUnitDateCounts meteringUnitDateCounts = (MeteringUnitDateCounts) o;
    return Objects.equals(this.counts, meteringUnitDateCounts.counts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(counts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeteringUnitDateCounts {\n");
    sb.append("    counts: ").append(toIndentedString(counts)).append("\n");
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
    openapiFields.add("counts");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("counts");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to MeteringUnitDateCounts
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!MeteringUnitDateCounts.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in MeteringUnitDateCounts is not found in the empty JSON string", MeteringUnitDateCounts.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!MeteringUnitDateCounts.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `MeteringUnitDateCounts` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : MeteringUnitDateCounts.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the json data is an array
      if (!jsonObj.get("counts").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `counts` to be an array in the JSON string but got `%s`", jsonObj.get("counts").toString()));
      }

      JsonArray jsonArraycounts = jsonObj.getAsJsonArray("counts");
      // validate the required field `counts` (array)
      for (int i = 0; i < jsonArraycounts.size(); i++) {
        MeteringUnitDateCount.validateJsonElement(jsonArraycounts.get(i));
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!MeteringUnitDateCounts.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'MeteringUnitDateCounts' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<MeteringUnitDateCounts> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(MeteringUnitDateCounts.class));

       return (TypeAdapter<T>) new TypeAdapter<MeteringUnitDateCounts>() {
           @Override
           public void write(JsonWriter out, MeteringUnitDateCounts value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public MeteringUnitDateCounts read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of MeteringUnitDateCounts given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of MeteringUnitDateCounts
  * @throws IOException if the JSON string is invalid with respect to MeteringUnitDateCounts
  */
  public static MeteringUnitDateCounts fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MeteringUnitDateCounts.class);
  }

 /**
  * Convert an instance of MeteringUnitDateCounts to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

