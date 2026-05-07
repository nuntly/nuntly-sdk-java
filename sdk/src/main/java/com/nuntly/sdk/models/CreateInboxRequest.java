package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.inboxes().create(CreateInboxRequest.builder()
 *     .address("address_value")
 *     .build());
 * }</pre>
 */
public record CreateInboxRequest(
    /** The id of the domain for this inbox. Defaults to your provided domain when omitted. */
    java.util.Optional<String> domainId,
    /** The local-part of the email address (before the @). */
    String address,
    /** The display name of the inbox. */
    java.util.Optional<String> name,
    /** The id of the namespace to assign the inbox to. */
    java.util.Optional<String> namespaceId,
    /** The external AI agent identifier. */
    java.util.Optional<String> agentId) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String domainId;
    private String address;
    private String name;
    private String namespaceId;
    private String agentId;

    /** The id of the domain for this inbox. Defaults to your provided domain when omitted. */
    public Builder domainId(String domainId) {
      this.domainId = domainId;
      return this;
    }

    /** The local-part of the email address (before the @). */
    public Builder address(String address) {
      this.address = address;
      return this;
    }

    /** The display name of the inbox. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** The id of the namespace to assign the inbox to. */
    public Builder namespaceId(String namespaceId) {
      this.namespaceId = namespaceId;
      return this;
    }

    /** The external AI agent identifier. */
    public Builder agentId(String agentId) {
      this.agentId = agentId;
      return this;
    }

    public CreateInboxRequest build() {
      return new CreateInboxRequest(
          Optional.ofNullable(domainId),
          address,
          Optional.ofNullable(name),
          Optional.ofNullable(namespaceId),
          Optional.ofNullable(agentId));
    }
  }
}
