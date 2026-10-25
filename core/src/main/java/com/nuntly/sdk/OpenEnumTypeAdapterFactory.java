package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * Reads a value this SDK version does not know as the enum's {@code UNKNOWN} member, where Gson
 * would read {@code null}, so a value the API adds later does not break a response. Set with
 * {@code @JsonAdapter} on the response enums; {@code UNKNOWN} is written as {@code null}, so a
 * field holding it is left out of a request.
 */
public final class OpenEnumTypeAdapterFactory implements TypeAdapterFactory {

  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    var unknown = unknownMember(type.getRawType());
    if (unknown == null) return null;
    var delegate = gson.getDelegateAdapter(this, type);
    return new TypeAdapter<T>() {
      @Override
      public void write(JsonWriter out, T value) throws IOException {
        // UNKNOWN has no wire value: a response read with one serializes it as null.
        if (value == unknown) {
          out.nullValue();
          return;
        }
        delegate.write(out, value);
      }

      @Override
      @SuppressWarnings("unchecked")
      public T read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
          in.nextNull();
          return null;
        }
        var value = delegate.read(in);
        return value == null ? (T) unknown : value;
      }
    };
  }

  private static Object unknownMember(Class<?> raw) {
    if (!raw.isEnum()) return null;
    for (var member : raw.getEnumConstants()) {
      if (((Enum<?>) member).name().equals("UNKNOWN")) return member;
    }
    // Not IllegalStateException, which Gson reports as a JsonSyntaxException, a payload error.
    throw new IllegalArgumentException(raw.getName() + " has no UNKNOWN member");
  }
}
