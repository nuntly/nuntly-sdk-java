package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Writes the JSON {@code null}s a request means to send, while Gson keeps omitting every other null
 * field (serializeNulls = false): {@link JsonNullable#ofNull()}, and a null value in a map marked
 * with {@link MapNullValues}, such as a contact property to remove. Each switches serializeNulls on
 * for that one value only. A null value in any other map, such as an email header, is dropped.
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
      return JsonNullable.of(inner.read(in));
    }
  }

  // Writes each entry itself so that only a null value is forced out; any other
  // value keeps Gson's omit-null rule (an absent field nested in it stays absent).
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
      out.beginObject();
      for (var entry : value.entrySet()) {
        out.name(String.valueOf(entry.getKey()));
        if (entry.getValue() == null) {
          writeNull(out);
        } else {
          var adapter = (TypeAdapter<Object>) gson.getAdapter(entry.getValue().getClass());
          adapter.write(out, entry.getValue());
        }
      }
      out.endObject();
    }

    @Override
    public Map<Object, Object> read(JsonReader in) throws IOException {
      return delegate.read(in);
    }
  }
}
