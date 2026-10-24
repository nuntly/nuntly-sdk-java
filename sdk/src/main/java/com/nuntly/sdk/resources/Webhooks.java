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

  /**
   * Registers an HTTPS endpoint to receive the event types you subscribe to. The response includes
   * the signing secret used to verify webhook payloads.
   */
  public CreateWebhookResponse create(CreateWebhookRequest body) {
    return client.post("/webhooks", body, CreateWebhookResponse.class, RequestOptions.none());
  }

  /**
   * Permanently deletes a webhook endpoint. Events are no longer delivered to its URL after
   * deletion. This cannot be undone.
   */
  public DeleteWebhookResponse delete(String id) {
    return client.delete(
        "/webhooks/" + pathParam("id", id) + "",
        DeleteWebhookResponse.class,
        RequestOptions.none());
  }

  /**
   * Lists the webhook endpoints of your organization, newest first, with cursor pagination. Each
   * entry shows its URL, event types, and status.
   */
  public CursorPage<WebhooksResponseItem> list(WebhooksListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/webhooks", WebhooksResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<WebhooksResponseItem> list() {
    return list(WebhooksListParams.builder().build());
  }

  /**
   * Retrieves a webhook endpoint with its URL, subscribed event types, status, and the reason and
   * time it was disabled, if it is disabled.
   */
  public WebhookResponse retrieve(String id) {
    return client.get(
        "/webhooks/" + pathParam("id", id) + "", WebhookResponse.class, RequestOptions.none());
  }

  /**
   * Updates the name, URL, event types, or status of a webhook, or rotates its signing secret. The
   * new secret is returned only when you rotate it.
   */
  public UpdateWebhookResponse update(String id, UpdateWebhookRequest body) {
    return client.patch(
        "/webhooks/" + pathParam("id", id) + "",
        body,
        UpdateWebhookResponse.class,
        RequestOptions.none());
  }
}
