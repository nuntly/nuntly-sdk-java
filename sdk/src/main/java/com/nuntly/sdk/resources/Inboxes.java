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

  /** Create a new inbox on a verified domain. */
  public InboxResponse create(CreateInboxRequest body) {
    return client.post("/inboxes", body, InboxResponse.class, RequestOptions.none());
  }

  /** Soft-delete an inbox. */
  public IdResponse delete(String inboxId) {
    return client.delete("/inboxes/" + inboxId + "", IdResponse.class, RequestOptions.none());
  }

  /** List all inboxes. */
  public CursorPage<InboxesResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    return client.list("/inboxes", InboxesResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<InboxesResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /** Retrieve an inbox with thread stats. */
  public InboxDetailResponse retrieve(String inboxId) {
    return client.get("/inboxes/" + inboxId + "", InboxDetailResponse.class, RequestOptions.none());
  }

  /** Update an inbox. */
  public IdResponse update(String inboxId, UpdateInboxRequest body) {
    return client.patch("/inboxes/" + inboxId + "", body, IdResponse.class, RequestOptions.none());
  }
}
