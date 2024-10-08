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
 * Password Policy
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-16T05:09:21.529968105Z[Etc/UTC]")
public class PasswordPolicy {
  public static final String SERIALIZED_NAME_MINIMUM_LENGTH = "minimum_length";
  @SerializedName(SERIALIZED_NAME_MINIMUM_LENGTH)
  private Integer minimumLength;

  public static final String SERIALIZED_NAME_IS_REQUIRE_LOWERCASE = "is_require_lowercase";
  @SerializedName(SERIALIZED_NAME_IS_REQUIRE_LOWERCASE)
  private Boolean isRequireLowercase;

  public static final String SERIALIZED_NAME_IS_REQUIRE_NUMBERS = "is_require_numbers";
  @SerializedName(SERIALIZED_NAME_IS_REQUIRE_NUMBERS)
  private Boolean isRequireNumbers;

  public static final String SERIALIZED_NAME_IS_REQUIRE_SYMBOLS = "is_require_symbols";
  @SerializedName(SERIALIZED_NAME_IS_REQUIRE_SYMBOLS)
  private Boolean isRequireSymbols;

  public static final String SERIALIZED_NAME_IS_REQUIRE_UPPERCASE = "is_require_uppercase";
  @SerializedName(SERIALIZED_NAME_IS_REQUIRE_UPPERCASE)
  private Boolean isRequireUppercase;

  public static final String SERIALIZED_NAME_TEMPORARY_PASSWORD_VALIDITY_DAYS = "temporary_password_validity_days";
  @SerializedName(SERIALIZED_NAME_TEMPORARY_PASSWORD_VALIDITY_DAYS)
  private Integer temporaryPasswordValidityDays;

  public PasswordPolicy() {
  }

  public PasswordPolicy minimumLength(Integer minimumLength) {
    this.minimumLength = minimumLength;
    return this;
  }

   /**
   * Minimum number of characters
   * @return minimumLength
  **/
  @javax.annotation.Nonnull
  public Integer getMinimumLength() {
    return minimumLength;
  }

  public void setMinimumLength(Integer minimumLength) {
    this.minimumLength = minimumLength;
  }


  public PasswordPolicy isRequireLowercase(Boolean isRequireLowercase) {
    this.isRequireLowercase = isRequireLowercase;
    return this;
  }

   /**
   * Contains one or more lowercase characters
   * @return isRequireLowercase
  **/
  @javax.annotation.Nonnull
  public Boolean getIsRequireLowercase() {
    return isRequireLowercase;
  }

  public void setIsRequireLowercase(Boolean isRequireLowercase) {
    this.isRequireLowercase = isRequireLowercase;
  }


  public PasswordPolicy isRequireNumbers(Boolean isRequireNumbers) {
    this.isRequireNumbers = isRequireNumbers;
    return this;
  }

   /**
   * Contains one or more numeric characters
   * @return isRequireNumbers
  **/
  @javax.annotation.Nonnull
  public Boolean getIsRequireNumbers() {
    return isRequireNumbers;
  }

  public void setIsRequireNumbers(Boolean isRequireNumbers) {
    this.isRequireNumbers = isRequireNumbers;
  }


  public PasswordPolicy isRequireSymbols(Boolean isRequireSymbols) {
    this.isRequireSymbols = isRequireSymbols;
    return this;
  }

   /**
   * Contains one or more special characters
   * @return isRequireSymbols
  **/
  @javax.annotation.Nonnull
  public Boolean getIsRequireSymbols() {
    return isRequireSymbols;
  }

  public void setIsRequireSymbols(Boolean isRequireSymbols) {
    this.isRequireSymbols = isRequireSymbols;
  }


  public PasswordPolicy isRequireUppercase(Boolean isRequireUppercase) {
    this.isRequireUppercase = isRequireUppercase;
    return this;
  }

   /**
   * Contains one or more uppercase letters
   * @return isRequireUppercase
  **/
  @javax.annotation.Nonnull
  public Boolean getIsRequireUppercase() {
    return isRequireUppercase;
  }

  public void setIsRequireUppercase(Boolean isRequireUppercase) {
    this.isRequireUppercase = isRequireUppercase;
  }


  public PasswordPolicy temporaryPasswordValidityDays(Integer temporaryPasswordValidityDays) {
    this.temporaryPasswordValidityDays = temporaryPasswordValidityDays;
    return this;
  }

   /**
   * Temporary password expiration date
   * @return temporaryPasswordValidityDays
  **/
  @javax.annotation.Nonnull
  public Integer getTemporaryPasswordValidityDays() {
    return temporaryPasswordValidityDays;
  }

  public void setTemporaryPasswordValidityDays(Integer temporaryPasswordValidityDays) {
    this.temporaryPasswordValidityDays = temporaryPasswordValidityDays;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasswordPolicy passwordPolicy = (PasswordPolicy) o;
    return Objects.equals(this.minimumLength, passwordPolicy.minimumLength) &&
        Objects.equals(this.isRequireLowercase, passwordPolicy.isRequireLowercase) &&
        Objects.equals(this.isRequireNumbers, passwordPolicy.isRequireNumbers) &&
        Objects.equals(this.isRequireSymbols, passwordPolicy.isRequireSymbols) &&
        Objects.equals(this.isRequireUppercase, passwordPolicy.isRequireUppercase) &&
        Objects.equals(this.temporaryPasswordValidityDays, passwordPolicy.temporaryPasswordValidityDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minimumLength, isRequireLowercase, isRequireNumbers, isRequireSymbols, isRequireUppercase, temporaryPasswordValidityDays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PasswordPolicy {\n");
    sb.append("    minimumLength: ").append(toIndentedString(minimumLength)).append("\n");
    sb.append("    isRequireLowercase: ").append(toIndentedString(isRequireLowercase)).append("\n");
    sb.append("    isRequireNumbers: ").append(toIndentedString(isRequireNumbers)).append("\n");
    sb.append("    isRequireSymbols: ").append(toIndentedString(isRequireSymbols)).append("\n");
    sb.append("    isRequireUppercase: ").append(toIndentedString(isRequireUppercase)).append("\n");
    sb.append("    temporaryPasswordValidityDays: ").append(toIndentedString(temporaryPasswordValidityDays)).append("\n");
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
    openapiFields.add("minimum_length");
    openapiFields.add("is_require_lowercase");
    openapiFields.add("is_require_numbers");
    openapiFields.add("is_require_symbols");
    openapiFields.add("is_require_uppercase");
    openapiFields.add("temporary_password_validity_days");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("minimum_length");
    openapiRequiredFields.add("is_require_lowercase");
    openapiRequiredFields.add("is_require_numbers");
    openapiRequiredFields.add("is_require_symbols");
    openapiRequiredFields.add("is_require_uppercase");
    openapiRequiredFields.add("temporary_password_validity_days");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PasswordPolicy
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PasswordPolicy.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PasswordPolicy is not found in the empty JSON string", PasswordPolicy.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PasswordPolicy.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PasswordPolicy` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PasswordPolicy.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PasswordPolicy.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PasswordPolicy' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PasswordPolicy> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PasswordPolicy.class));

       return (TypeAdapter<T>) new TypeAdapter<PasswordPolicy>() {
           @Override
           public void write(JsonWriter out, PasswordPolicy value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PasswordPolicy read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PasswordPolicy given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PasswordPolicy
  * @throws IOException if the JSON string is invalid with respect to PasswordPolicy
  */
  public static PasswordPolicy fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PasswordPolicy.class);
  }

 /**
  * Convert an instance of PasswordPolicy to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

