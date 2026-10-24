package com.nuntly.sdk;

import java.util.Objects;
import java.util.Optional;

/**
 * A request field the API accepts as {@code null}: absent from the body (left unchanged), sent as
 * JSON {@code null} (cleared), or sent with a value.
 */
public final class JsonNullable<T> {
  private static final JsonNullable<?> ABSENT = new JsonNullable<>(false, null);
  private static final JsonNullable<?> NULL = new JsonNullable<>(true, null);

  private final boolean sent;
  private final T value;

  private JsonNullable(boolean sent, T value) {
    this.sent = sent;
    this.value = value;
  }

  /** Leaves the field out of the request body. */
  @SuppressWarnings("unchecked")
  public static <T> JsonNullable<T> absent() {
    return (JsonNullable<T>) ABSENT;
  }

  /** Sends the field as JSON {@code null}. */
  @SuppressWarnings("unchecked")
  public static <T> JsonNullable<T> ofNull() {
    return (JsonNullable<T>) NULL;
  }

  /** Sends the field with {@code value}. */
  public static <T> JsonNullable<T> of(T value) {
    return new JsonNullable<>(true, Objects.requireNonNull(value, "value"));
  }

  /** Sends the field with {@code value}, or leaves it out when {@code value} is null. */
  public static <T> JsonNullable<T> ofNullable(T value) {
    return value == null ? absent() : of(value);
  }

  public boolean isAbsent() {
    return !sent;
  }

  public boolean isNull() {
    return sent && value == null;
  }

  public Optional<T> value() {
    return Optional.ofNullable(value);
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof JsonNullable<?> other
        && sent == other.sent
        && Objects.equals(value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sent, value);
  }

  @Override
  public String toString() {
    if (!sent) return "JsonNullable.absent";
    return value == null ? "JsonNullable.null" : "JsonNullable[" + value + "]";
  }
}
