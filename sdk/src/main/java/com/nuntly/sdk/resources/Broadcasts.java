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
    return create(body, IdempotentRequestOptions.none());
  }

  public BroadcastResponse create(CreateBroadcastRequest body, IdempotentRequestOptions opts) {
    return postIdempotent("/broadcasts", body, BroadcastResponse.class, opts);
  }

  /** Delete a draft, scheduled, or failed broadcast. */
  public IdResponse delete(String broadcastId) {
    return delete(broadcastId, RequestOptions.none());
  }

  public IdResponse delete(String broadcastId, RequestOptions opts) {
    return client.delete(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "", IdResponse.class, opts);
  }

  /** List the organization broadcasts. */
  public CursorPage<BroadcastsResponseItem> list(BroadcastsListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<BroadcastsResponseItem> list(BroadcastsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/broadcasts", BroadcastsResponseItem.class, query, opts);
  }

  public CursorPage<BroadcastsResponseItem> list() {
    return list(BroadcastsListParams.builder().build());
  }

  public CursorPage<BroadcastsResponseItem> list(RequestOptions opts) {
    return list(BroadcastsListParams.builder().build(), opts);
  }

  /** Retrieve a broadcast and its status. */
  public BroadcastResponse retrieve(String broadcastId) {
    return retrieve(broadcastId, RequestOptions.none());
  }

  public BroadcastResponse retrieve(String broadcastId, RequestOptions opts) {
    return client.get(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "", BroadcastResponse.class, opts);
  }

  /** Send a broadcast now or schedule it. */
  public SendBroadcastResponse send(String broadcastId) {
    return send(broadcastId, (SendBroadcastRequest) null);
  }

  public SendBroadcastResponse send(String broadcastId, IdempotentRequestOptions opts) {
    return send(broadcastId, (SendBroadcastRequest) null, opts);
  }

  /** Send a broadcast now or schedule it. */
  public SendBroadcastResponse send(String broadcastId, SendBroadcastRequest body) {
    return send(broadcastId, body, IdempotentRequestOptions.none());
  }

  public SendBroadcastResponse send(
      String broadcastId, SendBroadcastRequest body, IdempotentRequestOptions opts) {
    return postIdempotent(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "/send",
        body,
        SendBroadcastResponse.class,
        opts);
  }

  /** Edit a draft or scheduled broadcast. */
  public IdResponse update(String broadcastId, UpdateBroadcastRequest body) {
    return update(broadcastId, body, RequestOptions.none());
  }

  public IdResponse update(String broadcastId, UpdateBroadcastRequest body, RequestOptions opts) {
    return client.patch(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "", body, IdResponse.class, opts);
  }
}
