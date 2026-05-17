package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.apiKeys().update(UpdateApiKeyRequest.builder()
 *     .build());
 * }</pre>
 */
public record UpdateApiKeyRequest(
    /** The name of the api key */
    Optional<String> name,
    Optional<CreateWebhookRequestStatus> status,
    /** The permission type for the api key */
    Optional<CreateApiKeyRequestPermission> permission,
    /** The domain ids to restrict the api key to (only for sendingAccess) */
    List<String> domainIds) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private CreateWebhookRequestStatus status;
    private CreateApiKeyRequestPermission permission;
    private List<String> domainIds;

    /** The name of the api key */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder status(CreateWebhookRequestStatus status) {
      this.status = status;
      return this;
    }

    /** The permission type for the api key */
    public Builder permission(CreateApiKeyRequestPermission permission) {
      this.permission = permission;
      return this;
    }

    /** The domain ids to restrict the api key to (only for sendingAccess) */
    public Builder domainIds(List<String> domainIds) {
      this.domainIds = domainIds;
      return this;
    }

    public UpdateApiKeyRequest build() {
      return new UpdateApiKeyRequest(
          Optional.ofNullable(name),
          Optional.ofNullable(status),
          Optional.ofNullable(permission),
          domainIds);
    }
  }
}
