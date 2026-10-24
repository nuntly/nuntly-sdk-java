package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.broadcasts.*;
import java.util.*;

public final class Broadcasts extends Resource {
  private BroadcastsRecipients recipients;

  public Broadcasts(NuntlyClient client) {
    super(client);
  }

  public BroadcastsRecipients recipients() {
    if (recipients == null) recipients = new BroadcastsRecipients(client);
    return recipients;
  }

  /** Create a broadcast for your contacts. */
  public BroadcastResponse create(CreateBroadcastRequest body) {
    return create(body, RequestOptions.none());
  }

  public BroadcastResponse create(CreateBroadcastRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(UUID.randomUUID().toString());
    var headers = new HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(opts.timeout(), opts.maxRetries(), headers, Optional.of(idempotencyKey));
    return client.post("/broadcasts", body, BroadcastResponse.class, optsWithKey);
  }

  /** Delete a draft, scheduled, or failed broadcast. */
  public IdResponse delete(String broadcastId) {
    return client.delete(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "",
        IdResponse.class,
        RequestOptions.none());
  }

  /** List the organization broadcasts. */
  public CursorPage<BroadcastsResponseItem> list(BroadcastsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/broadcasts", BroadcastsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<BroadcastsResponseItem> list() {
    return list(BroadcastsListParams.builder().build());
  }

  /** Retrieve a broadcast and its status. */
  public BroadcastResponse retrieve(String broadcastId) {
    return client.get(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "",
        BroadcastResponse.class,
        RequestOptions.none());
  }

  /** Send a broadcast now or schedule it. */
  public SendBroadcastResponse send(String broadcastId) {
    return send(broadcastId, null);
  }

  /** Send a broadcast now or schedule it. */
  public SendBroadcastResponse send(String broadcastId, SendBroadcastRequest body) {
    return send(broadcastId, body, RequestOptions.none());
  }

  public SendBroadcastResponse send(
      String broadcastId, SendBroadcastRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(UUID.randomUUID().toString());
    var headers = new HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(opts.timeout(), opts.maxRetries(), headers, Optional.of(idempotencyKey));
    return client.post(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "/send",
        body,
        SendBroadcastResponse.class,
        optsWithKey);
  }

  /** Edit a draft or scheduled broadcast. */
  public IdResponse update(String broadcastId, UpdateBroadcastRequest body) {
    return client.patch(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
