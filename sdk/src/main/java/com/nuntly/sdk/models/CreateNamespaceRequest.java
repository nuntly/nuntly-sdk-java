package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.namespaces().create(CreateNamespaceRequest.builder()
 *     .name("example.com")
 *     .build());
 * }</pre>
 */
public record CreateNamespaceRequest(
    /** The display name of the namespace. */
    String name,
    /** An optional external identifier for the namespace. */
    java.util.Optional<String> externalId) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String externalId;

    /** The display name of the namespace. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** An optional external identifier for the namespace. */
    public Builder externalId(String externalId) {
      this.externalId = externalId;
      return this;
    }

    public CreateNamespaceRequest build() {
      return new CreateNamespaceRequest(name, Optional.ofNullable(externalId));
    }
  }
}
