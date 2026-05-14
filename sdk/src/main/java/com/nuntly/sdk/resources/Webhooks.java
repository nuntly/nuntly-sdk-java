package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.webhooks.*;
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

  /** Register an endpoint to start receiving webhook events for your organization. */
  public CreateWebhookResponse create(CreateWebhookRequest body) {
    return client.post("/webhooks", body, CreateWebhookResponse.class, RequestOptions.none());
  }

  /** Remove a webhook endpoint. No further events will be delivered to this URL. */
  public DeleteWebhookResponse delete(String id) {
    return client.delete(
        "/webhooks/" + id + "", DeleteWebhookResponse.class, RequestOptions.none());
  }

  /** Returns all registered webhook endpoints for the organization. */
  public CursorPage<WebhooksResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    return client.list("/webhooks", WebhooksResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<WebhooksResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /** Returns a webhook endpoint with its URL, subscribed events, and configuration. */
  public WebhookResponse retrieve(String id) {
    return client.get("/webhooks/" + id + "", WebhookResponse.class, RequestOptions.none());
  }

  /** Update the endpoint URL, subscribed event types, or rotate the signing secret. */
  public UpdateWebhookResponse update(String id, UpdateWebhookRequest body) {
    return client.patch(
        "/webhooks/" + id + "", body, UpdateWebhookResponse.class, RequestOptions.none());
  }
}
