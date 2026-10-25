package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.webhooks().create(CreateWebhookRequest.builder()
 *     .name("Production webhook")
 *     .endpointUrl("https://example.com/webhooks")
 *     .events(List.of(WebhookEventType.EMAIL_SENT))
 *     .build());
 * }</pre>
 *
 * @param name The name of the webhook
 * @param endpointUrl The endpoint URL of the webhook
 * @param status The status of the webhook.
 * @param events The event types to subscribe to
 */
public record CreateWebhookRequest(
    Optional<String> name,
    String endpointUrl,
    Optional<WebhookMutableStatus> status,
    List<WebhookEventType> events) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String endpointUrl;
    private WebhookMutableStatus status;
    private List<WebhookEventType> events;

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
    public Builder status(WebhookMutableStatus status) {
      this.status = status;
      return this;
    }

    /** The event types to subscribe to */
    public Builder events(List<WebhookEventType> events) {
      this.events = events;
      return this;
    }

    public CreateWebhookRequest build() {
      return new CreateWebhookRequest(
          Optional.ofNullable(name), endpointUrl, Optional.ofNullable(status), events);
    }
  }
}
