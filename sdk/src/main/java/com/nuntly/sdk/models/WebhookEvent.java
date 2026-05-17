package com.nuntly.sdk.models;

/**
 * A verified Nuntly webhook event.
 *
 * <p>{@code com.nuntly.sdk.lib.Webhook#verify(String, String, String)} returns one of the permitted
 * record types. Pattern-match on the concrete subtype to handle each event:
 *
 * <pre>{@code
 * var event = Webhook.verify(payload, signatureHeader, secret);
 * switch (event) {
 *   case EmailBouncedEvent e -> handleBounce(e);
 *   case MessageReceivedEvent e -> handleReceive(e);
 *   case UnknownWebhookEvent e -> log.warn("unknown event type: {}", e.type());
 *   default -> log.warn("unhandled event type: {}", event.type());
 * }
 * }</pre>
 *
 * <p>An {@link UnknownWebhookEvent} is returned when the payload {@code type} field does not match
 * any known event. This keeps consumers forward-compatible with new event types added by the Nuntly
 * API.
 */
public sealed interface WebhookEvent
    permits EmailQueuedEvent,
        EmailScheduledEvent,
        EmailProcessedEvent,
        EmailSendingEvent,
        EmailSentEvent,
        EmailDeliveredEvent,
        EmailOpenedEvent,
        EmailClickedEvent,
        EmailBouncedEvent,
        EmailComplainedEvent,
        EmailRejectedEvent,
        EmailDeliveryDelayedEvent,
        EmailFailedEvent,
        MessageReceivedEvent,
        MessageSecurityFlaggedEvent,
        MessageAgentTriggeredEvent,
        MessageSentEvent,
        MessageRejectedEvent,
        UnknownWebhookEvent {

  /** Stable event identifier (e.g. {@code evt_123}). */
  String id();

  /** ISO-8601 timestamp at which the event was created. */
  String createdAt();

  /** The event type string (e.g. {@code email.delivered}, {@code message.received}). */
  String type();
}
