package com.nuntly.sdk.resources.broadcasts;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class BroadcastsRecipients extends Resource {

  public BroadcastsRecipients(NuntlyClient client) {
    super(client);
  }

  /** List the recipients of a broadcast. */
  public CursorPage<BroadcastRecipientsResponseItem> list(
      String broadcastId, BroadcastsRecipientsListParams params) {
    return list(broadcastId, params, RequestOptions.none());
  }

  public CursorPage<BroadcastRecipientsResponseItem> list(
      String broadcastId, BroadcastsRecipientsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "/recipients",
        BroadcastRecipientsResponseItem.class,
        query,
        opts);
  }

  public CursorPage<BroadcastRecipientsResponseItem> list(String broadcastId) {
    return list(broadcastId, BroadcastsRecipientsListParams.builder().build());
  }

  public CursorPage<BroadcastRecipientsResponseItem> list(String broadcastId, RequestOptions opts) {
    return list(broadcastId, BroadcastsRecipientsListParams.builder().build(), opts);
  }
}
