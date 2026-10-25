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
    return list(topicId, params, RequestOptions.none());
  }

  public CursorPage<TopicMembershipsResponseItem> list(
      String topicId, TopicsMembershipsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list(
        "/topics/" + pathParam("topicId", topicId) + "/memberships",
        TopicMembershipsResponseItem.class,
        query,
        opts);
  }

  public CursorPage<TopicMembershipsResponseItem> list(String topicId) {
    return list(topicId, TopicsMembershipsListParams.builder().build());
  }

  public CursorPage<TopicMembershipsResponseItem> list(String topicId, RequestOptions opts) {
    return list(topicId, TopicsMembershipsListParams.builder().build(), opts);
  }
}
