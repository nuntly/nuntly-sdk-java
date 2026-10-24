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
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list(
        "/broadcasts/" + pathParam("broadcastId", broadcastId) + "/recipients",
        BroadcastRecipientsResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<BroadcastRecipientsResponseItem> list(String broadcastId) {
    return list(broadcastId, BroadcastsRecipientsListParams.builder().build());
  }
}
