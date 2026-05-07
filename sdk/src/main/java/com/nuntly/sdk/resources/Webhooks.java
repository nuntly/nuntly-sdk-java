package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class Webhooks extends Resource {
  private WebhooksEvents events;

  public Webhooks(NuntlyClient client) {
    super(client);
  }

  public WebhooksEvents events() {
    if (events == null) events = new WebhooksEvents(client);
    return events;
  }

  /** Returns a webhook endpoint with its URL, subscribed events, and configuration. */
  public WebhookResponse retrieve(String id) {
    return client.get("/webhooks/" + id + "", WebhookResponse.class, RequestOptions.none());
  }

  /** Update the endpoint URL, subscribed event types, or rotate the signing secret. */
  public UpdateWebhookResponse update(String id, UpdateWebhookRequest body) {
    return client.put(
        "/webhooks/" + id + "", body, UpdateWebhookResponse.class, RequestOptions.none());
  }

  /** Remove a webhook endpoint. No further events will be delivered to this URL. */
  public DeleteWebhookResponse delete(String id) {
    return client.delete(
        "/webhooks/" + id + "", DeleteWebhookResponse.class, RequestOptions.none());
  }

  /** Register an endpoint to start receiving webhook events for your organization. */
  public CreateWebhookResponse create(CreateWebhookRequest body) {
    return client.post("/webhooks", body, CreateWebhookResponse.class, RequestOptions.none());
  }

  /** Returns all registered webhook endpoints for the organization. */
  public CursorPage<WebhooksResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response = client.rawRequest("GET", "/webhooks", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), WebhooksResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(c, limit));
  }

  public CursorPage<WebhooksResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }
}
