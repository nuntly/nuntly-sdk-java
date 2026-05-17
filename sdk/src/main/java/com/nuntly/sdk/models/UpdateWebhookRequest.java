package com.nuntly.sdk.models;

import java.util.List;
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
    Optional<String> name,
    /** The endpoint URL of the webhook */
    Optional<String> endpointUrl,
    /** The event types to subscribe to */
    List<EventType> events,
    /** The status of the webhook. */
    Optional<CreateWebhookRequestStatus> status,
    /** If true, a new signing secret will be generated */
    Optional<Boolean> rotateSecret) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;
    private String endpointUrl;
    private List<EventType> events;
    private CreateWebhookRequestStatus status;
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
    public Builder events(List<EventType> events) {
      this.events = events;
      return this;
    }

    /** The status of the webhook. */
    public Builder status(CreateWebhookRequestStatus status) {
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
