package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.apiKeys().create(CreateApiKeyRequest.builder()
 *     .permission("permission_value")
 *     .build());
 * }</pre>
 */
public record CreateApiKeyRequest(
    /** The name of the api key */
    java.util.Optional<String> name,
    /** The status for the api key */
    java.util.Optional<String> status,
    /** The permission type for the api key */
    String permission,
    /** The domain ids to restrict the api key to (only for sendingAccess) */
    java.util.Optional<java.util.List<String>> domainIds) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String status;
    private String permission;
    private java.util.List<String> domainIds;

    /** The name of the api key */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** The status for the api key */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /** The permission type for the api key */
    public Builder permission(String permission) {
      this.permission = permission;
      return this;
    }

    /** The domain ids to restrict the api key to (only for sendingAccess) */
    public Builder domainIds(java.util.List<String> domainIds) {
      this.domainIds = domainIds;
      return this;
    }

    public CreateApiKeyRequest build() {
      return new CreateApiKeyRequest(
          Optional.ofNullable(name),
          Optional.ofNullable(status),
          permission,
          Optional.ofNullable(domainIds));
    }
  }
}
