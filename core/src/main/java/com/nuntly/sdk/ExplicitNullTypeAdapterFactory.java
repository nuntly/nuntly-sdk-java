package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/**
 * Writes the JSON {@code null}s a request means to send, while Gson keeps omitting every other null
 * field (serializeNulls = false): {@link JsonNullable#ofNull()}, and a null value in a map marked
 * with {@link MapNullValues} (at any depth), such as a contact property to remove. Each switches
 * serializeNulls on for that one value only. A null value in any other map, such as an email
 * header, is dropped.
 */
@SuppressWarnings("unchecked")
public final class ExplicitNullTypeAdapterFactory implements TypeAdapterFactory {

  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
    Class<? super T> rawType = typeToken.getRawType();
    if (rawType == JsonNullable.class) {
      Type type = typeToken.getType();
      Type elementType =
          type instanceof ParameterizedType parameterized
              ? parameterized.getActualTypeArguments()[0]
              : Object.class;
      var inner = (TypeAdapter<Object>) gson.getAdapter(TypeToken.get(elementType));
      return (TypeAdapter<T>) new JsonNullableAdapter(inner);
    }
    return null;
  }

  /**
   * For {@code @JsonAdapter} on a map field whose null values the API reads (a contact property to
   * remove, a null agent memory value): writes them as JSON {@code null}.
   */
  public static final class MapNullValues implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
      if (!Map.class.isAssignableFrom(typeToken.getRawType())) return null;
      return (TypeAdapter<T>) new NullValuesAdapter(gson, gson.getAdapter(typeToken));
    }
  }

  private static void writeNull(JsonWriter out) throws IOException {
    boolean serializeNulls = out.getSerializeNulls();
    out.setSerializeNulls(true);
    out.nullValue();
    out.setSerializeNulls(serializeNulls);
  }

  private static final class JsonNullableAdapter extends TypeAdapter<JsonNullable<Object>> {
    private final TypeAdapter<Object> inner;

    JsonNullableAdapter(TypeAdapter<Object> inner) {
      this.inner = inner;
    }

    @Override
    public void write(JsonWriter out, JsonNullable<Object> value) throws IOException {
      if (value == null || value.isAbsent()) {
        out.nullValue();
      } else if (value.isNull()) {
        writeNull(out);
      } else {
        inner.write(out, value.value().get());
      }
    }

    @Override
    public JsonNullable<Object> read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return JsonNullable.ofNull();
      }
      // The inner adapter can read a non-null token as null (an enum value it does not know).
      // Absent, not null: copying the record into an update must not clear the field.
      var value = inner.read(in);
      return value == null ? JsonNullable.absent() : JsonNullable.of(value);
    }
  }

  // Writes each map, collection and array itself, at any depth, so that only a null in them is
  // forced out, like JSON.stringify; any other value keeps Gson's omit-null rule
  // (an absent field of a record nested in it stays absent).
  private static final class NullValuesAdapter extends TypeAdapter<Map<Object, Object>> {
    private final Gson gson;
    private final TypeAdapter<Map<Object, Object>> delegate;

    NullValuesAdapter(Gson gson, TypeAdapter<?> delegate) {
      this.gson = gson;
      this.delegate = (TypeAdapter<Map<Object, Object>>) delegate;
    }

    @Override
    public void write(JsonWriter out, Map<Object, Object> value) throws IOException {
      if (value == null) {
        out.nullValue();
        return;
      }
      writeValue(out, value);
    }

    private void writeValue(JsonWriter out, Object value) throws IOException {
      if (value == null) {
        writeNull(out);
      } else if (value instanceof Map<?, ?> map) {
        out.beginObject();
        for (var entry : map.entrySet()) {
          out.name(String.valueOf(entry.getKey()));
          writeValue(out, entry.getValue());
        }
        out.endObject();
      } else if (value instanceof Collection<?> items) {
        out.beginArray();
        for (var item : items) writeValue(out, item);
        out.endArray();
      } else if (value.getClass().isArray()) {
        out.beginArray();
        for (int i = 0; i < Array.getLength(value); i++) writeValue(out, Array.get(value, i));
        out.endArray();
      } else {
        ((TypeAdapter<Object>) gson.getAdapter(value.getClass())).write(out, value);
      }
    }

    @Override
    public Map<Object, Object> read(JsonReader in) throws IOException {
      return delegate.read(in);
    }
  }
}
