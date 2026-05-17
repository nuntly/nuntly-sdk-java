package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.domains().create(CreateDomainRequest.builder()
 *     .name("example.com")
 *     .build());
 * }</pre>
 */
public record CreateDomainRequest(
    /** The name of the domain to send e-mails' */
    String name,
    /** Enable sending */
    Optional<Boolean> sending,
    /** Enable receiving */
    Optional<Boolean> receiving) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private Boolean sending;
    private Boolean receiving;

    /** The name of the domain to send e-mails' */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** Enable sending */
    public Builder sending(Boolean sending) {
      this.sending = sending;
      return this;
    }

    /** Enable receiving */
    public Builder receiving(Boolean receiving) {
      this.receiving = receiving;
      return this;
    }

    public CreateDomainRequest build() {
      return new CreateDomainRequest(
          name, Optional.ofNullable(sending), Optional.ofNullable(receiving));
    }
  }
}
