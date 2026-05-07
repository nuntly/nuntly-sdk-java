package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.webhooks().update(UpdateWebhookRequest.builder()
 *     .build());
 * }</pre>
 */
public record UpdateWebhookRequest(
    /** The name of the webhook */
    java.util.Optional<String> name,
    /** The endpoint URL of the webhook */
    java.util.Optional<String> endpointUrl,
    /** The event types to subscribe to */
    java.util.Optional<java.util.List<String>> events,
    /** The status of the webhook. */
    java.util.Optional<String> status,
    /** If true, a new signing secret will be generated */
    java.util.Optional<Boolean> rotateSecret) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String endpointUrl;
    private java.util.List<String> events;
    private String status;
    private Boolean rotateSecret;

    /** The name of the webhook */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** The endpoint URL of the webhook */
    public Builder endpointUrl(String endpointUrl) {
      this.endpointUrl = endpointUrl;
      return this;
    }

    /** The event types to subscribe to */
    public Builder events(java.util.List<String> events) {
      this.events = events;
      return this;
    }

    /** The status of the webhook. */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /** If true, a new signing secret will be generated */
    public Builder rotateSecret(Boolean rotateSecret) {
      this.rotateSecret = rotateSecret;
      return this;
    }

    public UpdateWebhookRequest build() {
      return new UpdateWebhookRequest(
          Optional.ofNullable(name),
          Optional.ofNullable(endpointUrl),
          Optional.ofNullable(events),
          Optional.ofNullable(status),
          Optional.ofNullable(rotateSecret));
    }
  }
}
