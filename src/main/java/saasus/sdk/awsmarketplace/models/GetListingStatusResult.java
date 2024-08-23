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
import saasus.sdk.awsmarketplace.models.ListingStatus;

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
 * GetListingStatusResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-23T07:14:44.001397480Z[Etc/UTC]")
public class GetListingStatusResult {
  public static final String SERIALIZED_NAME_LISTING_STATUS = "listing_status";
  @SerializedName(SERIALIZED_NAME_LISTING_STATUS)
  private ListingStatus listingStatus;

  public GetListingStatusResult() {
  }

  public GetListingStatusResult listingStatus(ListingStatus listingStatus) {
    this.listingStatus = listingStatus;
    return this;
  }

   /**
   * Get listingStatus
   * @return listingStatus
  **/
  @javax.annotation.Nonnull
  public ListingStatus getListingStatus() {
    return listingStatus;
  }

  public void setListingStatus(ListingStatus listingStatus) {
    this.listingStatus = listingStatus;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetListingStatusResult getListingStatusResult = (GetListingStatusResult) o;
    return Objects.equals(this.listingStatus, getListingStatusResult.listingStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listingStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetListingStatusResult {\n");
    sb.append("    listingStatus: ").append(toIndentedString(listingStatus)).append("\n");
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
    openapiFields.add("listing_status");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("listing_status");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to GetListingStatusResult
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!GetListingStatusResult.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetListingStatusResult is not found in the empty JSON string", GetListingStatusResult.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!GetListingStatusResult.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetListingStatusResult` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : GetListingStatusResult.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `listing_status`
      ListingStatus.validateJsonElement(jsonObj.get("listing_status"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetListingStatusResult.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetListingStatusResult' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetListingStatusResult> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetListingStatusResult.class));

       return (TypeAdapter<T>) new TypeAdapter<GetListingStatusResult>() {
           @Override
           public void write(JsonWriter out, GetListingStatusResult value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetListingStatusResult read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetListingStatusResult given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetListingStatusResult
  * @throws IOException if the JSON string is invalid with respect to GetListingStatusResult
  */
  public static GetListingStatusResult fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetListingStatusResult.class);
  }

 /**
  * Convert an instance of GetListingStatusResult to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

