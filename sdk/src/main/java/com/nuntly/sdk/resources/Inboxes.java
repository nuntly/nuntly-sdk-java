package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.inboxes.*;
import java.util.*;

public final class Inboxes extends Resource {
  private InboxesMessages messages;
  private InboxesThreads threads;

  public Inboxes(NuntlyClient client) {
    super(client);
  }

  public InboxesMessages messages() {
    if (messages == null) messages = new InboxesMessages(client);
    return messages;
  }

  public InboxesThreads threads() {
    if (threads == null) threads = new InboxesThreads(client);
    return threads;
  }

  /**
   * Creates an inbox address on a verified domain with receiving active, or on your provided domain
   * if none is given. Can assign a namespace and agent id.
   */
  public InboxResponse create(CreateInboxRequest body) {
    return create(body, RequestOptions.none());
  }

  public InboxResponse create(CreateInboxRequest body, RequestOptions opts) {
    var idempotencyKey = opts.idempotencyKey().orElse(UUID.randomUUID().toString());
    var headers = new HashMap<String, String>(opts.headers());
    headers.putIfAbsent("Idempotency-Key", idempotencyKey);
    var optsWithKey =
        new RequestOptions(opts.timeout(), opts.maxRetries(), headers, Optional.of(idempotencyKey));
    return client.post("/inboxes", body, InboxResponse.class, optsWithKey);
  }

  /**
   * Deletes an inbox so it no longer appears in lists and stops matching incoming mail. The default
   * catch-all inbox of a domain cannot be deleted.
   */
  public IdResponse delete(String inboxId) {
    return client.delete(
        "/inboxes/" + pathParam("inboxId", inboxId) + "", IdResponse.class, RequestOptions.none());
  }

  /**
   * Lists the active inboxes of your organization, newest first, with cursor pagination. Optionally
   * filter the results to a single namespace.
   */
  public CursorPage<InboxesResponseItem> list(InboxesListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    params.namespaceId().ifPresent(v -> query.put("namespaceId", v));
    return client.list("/inboxes", InboxesResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<InboxesResponseItem> list() {
    return list(InboxesListParams.builder().build());
  }

  /**
   * Retrieves an inbox by id, including its address, domain, display name, namespace, and assigned
   * agent id. Deleted inboxes return a not found error.
   */
  public InboxResponse retrieve(String inboxId) {
    return client.get(
        "/inboxes/" + pathParam("inboxId", inboxId) + "",
        InboxResponse.class,
        RequestOptions.none());
  }

  /**
   * Updates the display name of an inbox, used as the sender name on messages it sends. Set the
   * name to null to clear it. Returns the inbox id.
   */
  public IdResponse update(String inboxId, UpdateInboxRequest body) {
    return client.patch(
        "/inboxes/" + pathParam("inboxId", inboxId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
