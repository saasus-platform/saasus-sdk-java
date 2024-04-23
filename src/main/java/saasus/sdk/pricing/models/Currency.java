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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Unit of currency
 */
@JsonAdapter(Currency.Adapter.class)
public enum Currency {
  
  JPY("JPY"),
  
  USD("USD");

  private String value;

  Currency(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static Currency fromValue(String value) {
    for (Currency b : Currency.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<Currency> {
    @Override
    public void write(final JsonWriter jsonWriter, final Currency enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public Currency read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return Currency.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    Currency.fromValue(value);
  }
}

