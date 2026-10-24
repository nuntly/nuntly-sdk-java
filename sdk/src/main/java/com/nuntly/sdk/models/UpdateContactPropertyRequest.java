package com.nuntly.sdk.models;

import com.nuntly.sdk.JsonNullable;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.contactProperties().update(UpdateContactPropertyRequest.builder()
 *     .build());
 * }</pre>
 *
 * @param description An optional description of the property.
 */
public record UpdateContactPropertyRequest(
    JsonNullable<String> description, JsonNullable<Object> defaultValue) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private JsonNullable<String> description = JsonNullable.absent();
    private JsonNullable<Object> defaultValue = JsonNullable.absent();

    /**
     * Sets {@code description}; {@code null} leaves it unset. Use {@link #clearDescription()} to
     * send null.
     */
    public Builder description(String description) {
      this.description = JsonNullable.ofNullable(description);
      return this;
    }

    /** Sends {@code description} as null. An optional description of the property. */
    public Builder clearDescription() {
      this.description = JsonNullable.ofNull();
      return this;
    }

    /**
     * Sets {@code defaultValue}; {@code null} leaves it unset. Use {@link #clearDefaultValue()} to
     * send null.
     */
    public Builder defaultValue(Object defaultValue) {
      this.defaultValue = JsonNullable.ofNullable(defaultValue);
      return this;
    }

    /** Sends {@code defaultValue} as null. */
    public Builder clearDefaultValue() {
      this.defaultValue = JsonNullable.ofNull();
      return this;
    }

    public UpdateContactPropertyRequest build() {
      return new UpdateContactPropertyRequest(description, defaultValue);
    }
  }
}
