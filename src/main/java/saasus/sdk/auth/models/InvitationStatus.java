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
 * Gets or Sets InvitationStatus
 */
@JsonAdapter(InvitationStatus.Adapter.class)
public enum InvitationStatus {
  
  PENDING("pending"),
  
  ACCEPTED("accepted"),
  
  EXPIRED("expired");

  private String value;

  InvitationStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static InvitationStatus fromValue(String value) {
    for (InvitationStatus b : InvitationStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<InvitationStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final InvitationStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public InvitationStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return InvitationStatus.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    InvitationStatus.fromValue(value);
  }
}

