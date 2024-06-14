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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * If you have a strine linkage, you can set the behavior of the proportional allocation when changing plans. When a plan is changed, you can set whether to prorate the billing amount and reflect it on the next invoice, to issue a prorated invoice immediately, or not to prorate at all. 
 */
@JsonAdapter(ProrationBehavior.Adapter.class)
public enum ProrationBehavior {
  
  CREATE_PRORATIONS("create_prorations"),
  
  NONE("none"),
  
  ALWAYS_INVOICE("always_invoice");

  private String value;

  ProrationBehavior(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ProrationBehavior fromValue(String value) {
    for (ProrationBehavior b : ProrationBehavior.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ProrationBehavior> {
    @Override
    public void write(final JsonWriter jsonWriter, final ProrationBehavior enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ProrationBehavior read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ProrationBehavior.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    ProrationBehavior.fromValue(value);
  }
}

