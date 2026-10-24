package com.nuntly.sdk.models;

import com.google.gson.annotations.SerializedName;
import java.util.Optional;

/**
 * @param name The variable name, case-sensitive.
 * @param type The variable type.
 * @param defaultValue Used when a broadcast sets no value.
 */
public record VariableDeclaration(
    String name,
    VariableDeclarationType type,
    @SerializedName("default") Optional<Object> defaultValue) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private VariableDeclarationType type;
    private Object defaultValue;

    /** The variable name, case-sensitive. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** The variable type. */
    public Builder type(VariableDeclarationType type) {
      this.type = type;
      return this;
    }

    /** Used when a broadcast sets no value. */
    public Builder defaultValue(Object defaultValue) {
      this.defaultValue = defaultValue;
      return this;
    }

    public VariableDeclaration build() {
      return new VariableDeclaration(name, type, Optional.ofNullable(defaultValue));
    }
  }
}
