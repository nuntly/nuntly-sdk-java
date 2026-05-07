package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.domains().update(UpdateDomainRequest.builder()
 *     .build());
 * }</pre>
 */
public record UpdateDomainRequest(
    /** Emit an event for each recipient opens an email their email client */
    java.util.Optional<Boolean> openTracking,
    /** Emit an event for each time the recipient clicks a link in the email */
    java.util.Optional<Boolean> clickTracking,
    /** Enable or disable sending */
    java.util.Optional<Boolean> sending,
    /** Enable or disable receiving */
    java.util.Optional<Boolean> receiving) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Boolean openTracking;
    private Boolean clickTracking;
    private Boolean sending;
    private Boolean receiving;

    /** Emit an event for each recipient opens an email their email client */
    public Builder openTracking(Boolean openTracking) {
      this.openTracking = openTracking;
      return this;
    }

    /** Emit an event for each time the recipient clicks a link in the email */
    public Builder clickTracking(Boolean clickTracking) {
      this.clickTracking = clickTracking;
      return this;
    }

    /** Enable or disable sending */
    public Builder sending(Boolean sending) {
      this.sending = sending;
      return this;
    }

    /** Enable or disable receiving */
    public Builder receiving(Boolean receiving) {
      this.receiving = receiving;
      return this;
    }

    public UpdateDomainRequest build() {
      return new UpdateDomainRequest(
          Optional.ofNullable(openTracking),
          Optional.ofNullable(clickTracking),
          Optional.ofNullable(sending),
          Optional.ofNullable(receiving));
    }
  }
}
