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
    return create(body, RequestOptions.none());
  }

  public TopicResponse create(CreateTopicRequest body, RequestOptions opts) {
    return client.post("/topics", body, TopicResponse.class, opts);
  }

  /** Delete a topic. */
  public IdResponse delete(String topicId) {
    return delete(topicId, RequestOptions.none());
  }

  public IdResponse delete(String topicId, RequestOptions opts) {
    return client.delete("/topics/" + pathParam("topicId", topicId) + "", IdResponse.class, opts);
  }

  /** List the organization topics. */
  public CursorPage<TopicsResponseItem> list(TopicsListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<TopicsResponseItem> list(TopicsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/topics", TopicsResponseItem.class, query, opts);
  }

  public CursorPage<TopicsResponseItem> list() {
    return list(TopicsListParams.builder().build());
  }

  public CursorPage<TopicsResponseItem> list(RequestOptions opts) {
    return list(TopicsListParams.builder().build(), opts);
  }

  /** Retrieve one topic. */
  public TopicResponse retrieve(String topicId) {
    return retrieve(topicId, RequestOptions.none());
  }

  public TopicResponse retrieve(String topicId, RequestOptions opts) {
    return client.get("/topics/" + pathParam("topicId", topicId) + "", TopicResponse.class, opts);
  }

  /** Rename a topic. */
  public IdResponse update(String topicId, UpdateTopicRequest body) {
    return update(topicId, body, RequestOptions.none());
  }

  public IdResponse update(String topicId, UpdateTopicRequest body, RequestOptions opts) {
    return client.patch(
        "/topics/" + pathParam("topicId", topicId) + "", body, IdResponse.class, opts);
  }
}
