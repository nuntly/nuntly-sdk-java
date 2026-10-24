package com.nuntly.sdk.models;

import com.nuntly.sdk.JsonNullable;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.contactProperties().create(CreateContactPropertyRequest.builder()
 *     .name("example.com")
 *     .type(ContactPropertyType.STRING)
 *     .build());
 * }</pre>
 *
 * @param name A name for the property, used as its key in a contact's properties. Stored trimmed,
 *     with the letter case it was typed with.
 * @param type The declared type of the property. Immutable after creation.
 * @param description An optional description of the property.
 * @param defaultValue Applied to new contacts that omit this property.
 */
public record CreateContactPropertyRequest(
    String name,
    ContactPropertyType type,
    JsonNullable<String> description,
    JsonNullable<Object> defaultValue) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private ContactPropertyType type;
    private JsonNullable<String> description = JsonNullable.absent();
    private JsonNullable<Object> defaultValue = JsonNullable.absent();

    /**
     * A name for the property, used as its key in a contact's properties. Stored trimmed, with the
     * letter case it was typed with.
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** The declared type of the property. Immutable after creation. */
    public Builder type(ContactPropertyType type) {
      this.type = type;
      return this;
    }

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

    /** Sends {@code defaultValue} as null. Applied to new contacts that omit this property. */
    public Builder clearDefaultValue() {
      this.defaultValue = JsonNullable.ofNull();
      return this;
    }

    public CreateContactPropertyRequest build() {
      return new CreateContactPropertyRequest(name, type, description, defaultValue);
    }
  }
}
