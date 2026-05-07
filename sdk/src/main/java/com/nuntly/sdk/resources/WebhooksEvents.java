package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class WebhooksEvents extends Resource {

  public WebhooksEvents(NuntlyClient client) {
    super(client);
  }

  /** Returns recent webhook events across all registered endpoints. */
  public CursorPage<WebhookEventsResponseItem> list(
      Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response = client.rawRequest("GET", "/webhooks/events", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), WebhookEventsResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(c, limit));
  }

  public CursorPage<WebhookEventsResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /** Re-deliver a webhook event to its endpoint. Useful for retrying failed deliveries. */
  public void replay(String id, String eventId) {
    client.deleteVoid("/webhooks/" + id + "/events/" + eventId + "/replay", RequestOptions.none());
  }

  /**
   * Returns all delivery attempts for a webhook event, including HTTP status codes and response
   * times.
   */
  public java.util.List<WebhookEventDeliveriesResponseItem> deliveries(String id, String eventId) {
    var response =
        client.rawRequest(
            "GET",
            "/webhooks/" + id + "/events/" + eventId + "/deliveries",
            null,
            RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items =
        client.gson().fromJson(json.get("data"), WebhookEventDeliveriesResponseItem[].class);
    return java.util.List.of(items);
  }
}
