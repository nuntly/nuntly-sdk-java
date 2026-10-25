package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.apiKeys().update("apk_01ka8k8s80gvx9604cn9am5st4", UpdateApiKeyRequest.builder()
 *     .name("Production")
 *     .build());
 * }</pre>
 *
 * @param name The name of the api key
 * @param permission The permission type for the api key
 * @param domainIds The domain ids to restrict the api key to (only for sendingAccess)
 */
public record UpdateApiKeyRequest(
    Optional<String> name,
    Optional<UpdateApiKeyRequestStatus> status,
    Optional<CreateApiKeyRequestPermission> permission,
    List<String> domainIds) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private UpdateApiKeyRequestStatus status;
    private CreateApiKeyRequestPermission permission;
    private List<String> domainIds;

    /** The name of the api key */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder status(UpdateApiKeyRequestStatus status) {
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
