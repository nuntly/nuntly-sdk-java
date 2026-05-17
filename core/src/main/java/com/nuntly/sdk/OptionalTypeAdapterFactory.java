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
import java.util.Optional;

/**
 * Gson does not know about {@link Optional}. On JDK 17+ its reflective fallback
 * fails because {@code java.util} is not opened to unnamed modules.
 *
 * <p>This factory plugs in a TypeAdapter that:
 * <ul>
 *   <li>Serializes {@code Optional.empty()} as JSON {@code null}. Combined with
 *       Gson's default (serializeNulls = false), the field is omitted from the
 *       request body, which is what Zod {@code .optional()} expects on the wire.
 *   <li>Serializes {@code Optional.of(v)} as the wrapped value.
 *   <li>Deserializes JSON {@code null} or a missing value as {@code Optional.empty()}.
 *   <li>Deserializes a present value as {@code Optional.of(value)}.
 * </ul>
 */
public final class OptionalTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getRawType() != Optional.class) {
            return null;
        }

        Type type = typeToken.getType();
        Type elementType;
        if (type instanceof ParameterizedType parameterized) {
            elementType = parameterized.getActualTypeArguments()[0];
        } else {
            elementType = Object.class;
        }

        TypeAdapter<Object> innerAdapter = (TypeAdapter<Object>) gson.getAdapter(TypeToken.get(elementType));

        return (TypeAdapter<T>) new OptionalAdapter<>(innerAdapter);
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
