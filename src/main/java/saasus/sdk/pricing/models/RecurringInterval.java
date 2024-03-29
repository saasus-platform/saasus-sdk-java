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
import java.util.Arrays;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * 繰り返し期間(cycle) month: 月単位(monthly) year: 年単位(yearly) 
 */
@JsonAdapter(RecurringInterval.Adapter.class)
public enum RecurringInterval {
  
  MONTH("month"),
  
  YEAR("year");

  private String value;

  RecurringInterval(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static RecurringInterval fromValue(String value) {
    for (RecurringInterval b : RecurringInterval.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<RecurringInterval> {
    @Override
    public void write(final JsonWriter jsonWriter, final RecurringInterval enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public RecurringInterval read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return RecurringInterval.fromValue(value);
    }
  }
}

