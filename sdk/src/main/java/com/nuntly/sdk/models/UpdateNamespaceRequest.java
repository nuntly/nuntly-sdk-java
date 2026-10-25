package com.nuntly.sdk.models;

import com.nuntly.sdk.JsonNullable;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.namespaces().update("ns_01kabn43yqyxn2bx4ve84mczd3", UpdateNamespaceRequest.builder()
 *     .name("Customer support")
 *     .build());
 * }</pre>
 *
 * @param name The display name of the namespace.
 * @param externalId An optional external identifier for the namespace.
 */
public record UpdateNamespaceRequest(Optional<String> name, JsonNullable<String> externalId) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private JsonNullable<String> externalId = JsonNullable.absent();

    /** The display name of the namespace. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Sets {@code externalId}; {@code null} leaves it unset. Use {@link #clearExternalId()} to send
     * null.
     */
    public Builder externalId(String externalId) {
      this.externalId = JsonNullable.ofNullable(externalId);
      return this;
    }

    /** Sends {@code externalId} as null. An optional external identifier for the namespace. */
    public Builder clearExternalId() {
      this.externalId = JsonNullable.ofNull();
      return this;
    }

    public UpdateNamespaceRequest build() {
      return new UpdateNamespaceRequest(Optional.ofNullable(name), externalId);
    }
  }
}
