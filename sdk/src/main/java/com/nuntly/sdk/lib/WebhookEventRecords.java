package com.nuntly.sdk.lib;

import com.nuntly.sdk.models.EmailBouncedEvent;
import com.nuntly.sdk.models.EmailClickedEvent;
import com.nuntly.sdk.models.EmailComplainedEvent;
import com.nuntly.sdk.models.EmailDeliveredEvent;
import com.nuntly.sdk.models.EmailDeliveryDelayedEvent;
import com.nuntly.sdk.models.EmailFailedEvent;
import com.nuntly.sdk.models.EmailOpenedEvent;
import com.nuntly.sdk.models.EmailRejectedEvent;
import com.nuntly.sdk.models.EmailSentEvent;
import com.nuntly.sdk.models.MessageAgentTriggeredEvent;
import com.nuntly.sdk.models.MessageReceivedEvent;
import com.nuntly.sdk.models.MessageRejectedEvent;
import com.nuntly.sdk.models.MessageSecurityFlaggedEvent;
import com.nuntly.sdk.models.MessageSentEvent;
import com.nuntly.sdk.models.WebhookEvent;
import java.util.Map;

final class WebhookEventRecords {
  static final Map<String, Class<? extends WebhookEvent>> BY_TYPE =
      Map.ofEntries(
          Map.entry("email.sent", EmailSentEvent.class),
          Map.entry("email.delivered", EmailDeliveredEvent.class),
          Map.entry("email.opened", EmailOpenedEvent.class),
          Map.entry("email.clicked", EmailClickedEvent.class),
          Map.entry("email.bounced", EmailBouncedEvent.class),
          Map.entry("email.complained", EmailComplainedEvent.class),
          Map.entry("email.rejected", EmailRejectedEvent.class),
          Map.entry("email.deliveryDelayed", EmailDeliveryDelayedEvent.class),
          Map.entry("email.failed", EmailFailedEvent.class),
          Map.entry("message.received", MessageReceivedEvent.class),
          Map.entry("message.security.flagged", MessageSecurityFlaggedEvent.class),
          Map.entry("message.agent.triggered", MessageAgentTriggeredEvent.class),
          Map.entry("message.sent", MessageSentEvent.class),
          Map.entry("message.rejected", MessageRejectedEvent.class));

  private WebhookEventRecords() {}
}
