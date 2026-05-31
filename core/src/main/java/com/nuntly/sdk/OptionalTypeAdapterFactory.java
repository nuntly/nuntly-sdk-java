package com.nuntly.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Gson does not know about {@link Optional}. On JDK 17+ its reflective fallback fails because
 * {@code java.util} is not opened to unnamed modules.
 *
 * <p>This factory plugs in a TypeAdapter that:
 *
 * <ul>
 *   <li>Serializes {@code Optional.empty()} as JSON {@code null}. Combined with Gson's default
 *       (serializeNulls = false), the field is omitted from the request body, which is what Zod
 *       {@code .optional()} expects on the wire.
 *   <li>Serializes {@code Optional.of(v)} as the wrapped value.
 *   <li>Deserializes JSON {@code null} or a missing value as {@code Optional.empty()}.
 *   <li>Deserializes a present value as {@code Optional.of(value)}.
 * </ul>
 *
 * <p>It also wraps record types that have {@code Optional} components. Gson's native record adapter
 * only invokes a component's adapter when its JSON key is <em>present</em>; an absent key passes
 * {@code null} straight to the canonical constructor, leaving an {@code Optional} field null
 * instead of {@code Optional.empty()} (an NPE waiting to happen on {@code .isPresent()}). The
 * record wrapper injects an explicit JSON null for every missing {@code Optional} component before
 * delegating, so the {@code Optional} adapter runs and yields {@code Optional.empty()}.
 */
public final class OptionalTypeAdapterFactory implements TypeAdapterFactory {

  @Override
  @SuppressWarnings({"unchecked", "rawtypes"})
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
    Class<? super T> rawType = typeToken.getRawType();
    if (rawType.isRecord()) {
      return recordAdapter(gson, typeToken, rawType);
    }
    if (rawType != Optional.class) {
      return null;
    }

    Type type = typeToken.getType();
    Type elementType;
    if (type instanceof ParameterizedType parameterized) {
      elementType = parameterized.getActualTypeArguments()[0];
    } else {
      elementType = Object.class;
    }

    TypeAdapter<Object> innerAdapter =
        (TypeAdapter<Object>) gson.getAdapter(TypeToken.get(elementType));

    return (TypeAdapter<T>) new OptionalAdapter<>(innerAdapter);
  }

  /**
   * Adapter for record types carrying {@code Optional} components. Reads the JSON into a tree,
   * fills any missing {@code Optional} component with an explicit null, then delegates to Gson's
   * record adapter so the {@link OptionalAdapter} resolves the null to {@code Optional.empty()}.
   * Returns {@code null} (no wrapping) for records without {@code Optional} components.
   */
  private <T> TypeAdapter<T> recordAdapter(
      Gson gson, TypeToken<T> typeToken, Class<? super T> rawType) {
    List<String> optionalComponents = new ArrayList<>();
    for (RecordComponent component : rawType.getRecordComponents()) {
      if (component.getType() == Optional.class) {
        optionalComponents.add(component.getName());
      }
    }
    if (optionalComponents.isEmpty()) {
      return null;
    }

    TypeAdapter<T> delegate = gson.getDelegateAdapter(this, typeToken);
    TypeAdapter<JsonElement> jsonAdapter = gson.getAdapter(JsonElement.class);

    return new TypeAdapter<T>() {
      @Override
      public void write(JsonWriter out, T value) throws IOException {
        delegate.write(out, value);
      }

      @Override
      public T read(JsonReader in) throws IOException {
        JsonElement tree = jsonAdapter.read(in);
        if (tree != null && tree.isJsonObject()) {
          JsonObject object = tree.getAsJsonObject();
          for (String name : optionalComponents) {
            if (!object.has(name)) {
              object.add(name, JsonNull.INSTANCE);
            }
          }
        }
        return delegate.fromJsonTree(tree);
      }
    };
  }

  private static final class OptionalAdapter<T> extends TypeAdapter<Optional<T>> {
    private final TypeAdapter<T> innerAdapter;

    OptionalAdapter(TypeAdapter<T> innerAdapter) {
      this.innerAdapter = innerAdapter;
    }

    @Override
    public void write(JsonWriter out, Optional<T> value) throws IOException {
      if (value == null || value.isEmpty()) {
        out.nullValue();
        return;
      }
      innerAdapter.write(out, value.get());
    }

    @Override
    public Optional<T> read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return Optional.empty();
      }
      return Optional.ofNullable(innerAdapter.read(in));
    }
  }
}
