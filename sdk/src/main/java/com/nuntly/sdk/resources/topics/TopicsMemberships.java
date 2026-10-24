package com.nuntly.sdk.resources.topics;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class TopicsMemberships extends Resource {

  public TopicsMemberships(NuntlyClient client) {
    super(client);
  }

  /**
   * List a topic's explicit membership records only. A contact without one is subscribed by
   * default.
   */
  public CursorPage<TopicMembershipsResponseItem> list(
      String topicId, TopicsMembershipsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list(
        "/topics/" + pathParam("topicId", topicId) + "/memberships",
        TopicMembershipsResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<TopicMembershipsResponseItem> list(String topicId) {
    return list(topicId, TopicsMembershipsListParams.builder().build());
  }
}
