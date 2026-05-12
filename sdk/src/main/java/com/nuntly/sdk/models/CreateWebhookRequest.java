package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.webhooks().create(CreateWebhookRequest.builder()
 *     .endpointUrl("https://example.com/webhooks")
 *     .events(List.of("email.delivered", "email.bounced"))
 *     .build());
 * }</pre>
 */
public record CreateWebhookRequest(
    /** The name of the webhook */
    java.util.Optional<String> name,
    /** The endpoint URL of the webhook */
    String endpointUrl,
    /** The status of the webhook. */
    java.util.Optional<String> status,
    /** The event types to subscribe to */
    java.util.List<EventType> events) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String endpointUrl;
    private String status;
    private java.util.List<EventType> events;

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

    /** The status of the webhook. */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /** The event types to subscribe to */
    public Builder events(java.util.List<EventType> events) {
      this.events = events;
      return this;
    }

    public CreateWebhookRequest build() {
      return new CreateWebhookRequest(
          Optional.ofNullable(name), endpointUrl, Optional.ofNullable(status), events);
    }
  }
}
