package com.nuntly.sdk.resources.webhooks;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class WebhooksEvents extends Resource {
  private WebhooksEventsDeliveries deliveries;

  public WebhooksEvents(NuntlyClient client) {
    super(client);
  }

  public WebhooksEventsDeliveries deliveries() {
    if (deliveries == null) deliveries = new WebhooksEventsDeliveries(client);
    return deliveries;
  }

  /**
   * Lists the webhook events of the last 48 hours across all your endpoints, with their delivery
   * status and payload. Results use cursor pagination.
   */
  public CursorPage<WebhookEventsResponseItem> list(WebhooksEventsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list(
        "/webhooks/events", WebhookEventsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<WebhookEventsResponseItem> list() {
    return list(WebhooksEventsListParams.builder().build());
  }

  /**
   * Queues a new delivery of a past webhook event to the endpoint. The request is accepted
   * asynchronously and returns 202 before the delivery runs.
   */
  public void replay(String id, String eventId) {
    client.rawRequest(
        "POST",
        "/webhooks/" + pathParam("id", id) + "/events/" + pathParam("eventId", eventId) + "/replay",
        null,
        RequestOptions.none());
  }
}
