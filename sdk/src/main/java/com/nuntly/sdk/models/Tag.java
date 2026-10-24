package com.nuntly.sdk.models;

/**
 * @param name The name of the tag
 * @param value The tag to add to the email
 */
public record Tag(String name, String value) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String value;

    /** The name of the tag */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** The tag to add to the email */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    public Tag build() {
      return new Tag(name, value);
    }
  }
}
