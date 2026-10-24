package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.inboxes().create(CreateInboxRequest.builder()
 *     .address("jane@example.com")
 *     .build());
 * }</pre>
 *
 * @param domainId The id of the domain for this inbox. Defaults to your provided domain when
 *     omitted.
 * @param address The local-part of the email address (before the @).
 * @param name The display name of the inbox.
 * @param namespaceId The id of the namespace to assign the inbox to.
 * @param agentId The external AI agent identifier.
 */
public record CreateInboxRequest(
    Optional<String> domainId,
    String address,
    Optional<String> name,
    Optional<String> namespaceId,
    Optional<String> agentId) {

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
