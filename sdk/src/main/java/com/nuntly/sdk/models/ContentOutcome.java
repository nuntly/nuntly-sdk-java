package com.nuntly.sdk.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;

/** One of the records nested in this interface, chosen by its {@code status}. */
@JsonAdapter(ContentOutcome.Deserializer.class)
public sealed interface ContentOutcome {
  /**
   * @param downloadUrl Presigned download URL.
   * @param expiresAt When the URL expires.
   */
  public record Available(String downloadUrl, String expiresAt) implements ContentOutcome {}

  public record Absent() implements ContentOutcome {}

  public record Unavailable() implements ContentOutcome {}

  /** A {@code status} this SDK version does not know yet. */
  record Unknown(String status) implements ContentOutcome {}

  final class Deserializer implements JsonDeserializer<ContentOutcome> {
    @Override
    public ContentOutcome deserialize(
        JsonElement json, Type type, JsonDeserializationContext context) {
      var discriminator = json.getAsJsonObject().get("status");
      if (discriminator == null || !discriminator.isJsonPrimitive()) {
        throw new JsonParseException("ContentOutcome without a status");
      }
      var value = discriminator.getAsString();
      return switch (value) {
        case "available" -> context.deserialize(json, Available.class);
        case "absent" -> context.deserialize(json, Absent.class);
        case "unavailable" -> context.deserialize(json, Unavailable.class);
        default -> new Unknown(value);
      };
    }
  }
}
