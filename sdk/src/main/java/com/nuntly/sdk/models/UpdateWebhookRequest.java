package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.webhooks().update("wh_01ka8k8s80gvx9604cn9am5st4", UpdateWebhookRequest.builder()
 *     .name("Production webhook")
 *     .events(List.of(WebhookEventType.EMAIL_SENT))
 *     .build());
 * }</pre>
 *
 * @param name The name of the webhook
 * @param endpointUrl The endpoint URL of the webhook
 * @param events The event types to subscribe to
 * @param status The status of the webhook.
 * @param rotateSecret If true, a new signing secret will be generated
 */
public record UpdateWebhookRequest(
    Optional<String> name,
    Optional<String> endpointUrl,
    List<WebhookEventType> events,
    Optional<WebhookMutableStatus> status,
    Optional<Boolean> rotateSecret) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String endpointUrl;
    private List<WebhookEventType> events;
    private WebhookMutableStatus status;
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
    public Builder events(List<WebhookEventType> events) {
      this.events = events;
      return this;
    }

    /** The status of the webhook. */
    public Builder status(WebhookMutableStatus status) {
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
          events,
          Optional.ofNullable(status),
          Optional.ofNullable(rotateSecret));
    }
  }
}
