package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.topics.*;
import java.util.*;

public final class Topics extends Resource {
  private TopicsMemberships memberships;

  public Topics(NuntlyClient client) {
    super(client);
  }

  public TopicsMemberships memberships() {
    if (memberships == null) memberships = new TopicsMemberships(client);
    return memberships;
  }

  /** Create a topic. */
  public TopicResponse create(CreateTopicRequest body) {
    return client.post("/topics", body, TopicResponse.class, RequestOptions.none());
  }

  /** Delete a topic. */
  public IdResponse delete(String topicId) {
    return client.delete(
        "/topics/" + pathParam("topicId", topicId) + "", IdResponse.class, RequestOptions.none());
  }

  /** List the organization topics. */
  public CursorPage<TopicsResponseItem> list(TopicsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/topics", TopicsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<TopicsResponseItem> list() {
    return list(TopicsListParams.builder().build());
  }

  /** Retrieve one topic. */
  public TopicResponse retrieve(String topicId) {
    return client.get(
        "/topics/" + pathParam("topicId", topicId) + "",
        TopicResponse.class,
        RequestOptions.none());
  }

  /** Rename a topic. */
  public IdResponse update(String topicId, UpdateTopicRequest body) {
    return client.patch(
        "/topics/" + pathParam("topicId", topicId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
