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
 * Unit of measurement type fixed: Fixed unit usage: Usage unit tiered: Tiered unit tiered_usage: Tiered usage unit 
 */
@JsonAdapter(UnitType.Adapter.class)
public enum UnitType {
  
  FIXED("fixed"),
  
  USAGE("usage"),
  
  TIERED("tiered"),
  
  TIERED_USAGE("tiered_usage");

  private String value;

  UnitType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static UnitType fromValue(String value) {
    for (UnitType b : UnitType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<UnitType> {
    @Override
    public void write(final JsonWriter jsonWriter, final UnitType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UnitType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UnitType.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    UnitType.fromValue(value);
  }
}

