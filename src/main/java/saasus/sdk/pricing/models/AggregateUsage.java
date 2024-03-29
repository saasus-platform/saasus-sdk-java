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
 * 使用量の集計方法(aggregate usage) sum: 期間内の使用量の合計(total usage during the period) max: 期間内の使用量の最大値(maximum usage during the period) 
 */
@JsonAdapter(AggregateUsage.Adapter.class)
public enum AggregateUsage {
  
  SUM("sum"),
  
  MAX("max");

  private String value;

  AggregateUsage(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static AggregateUsage fromValue(String value) {
    for (AggregateUsage b : AggregateUsage.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<AggregateUsage> {
    @Override
    public void write(final JsonWriter jsonWriter, final AggregateUsage enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public AggregateUsage read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return AggregateUsage.fromValue(value);
    }
  }
}

