package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.segments.*;
import java.util.*;

public final class Segments extends Resource {
  private SegmentsMembers members;

  public Segments(NuntlyClient client) {
    super(client);
  }

  public SegmentsMembers members() {
    if (members == null) members = new SegmentsMembers(client);
    return members;
  }

  /** Create an organization-level static segment. */
  public SegmentResponse create(CreateSegmentRequest body) {
    return client.post("/segments", body, SegmentResponse.class, RequestOptions.none());
  }

  /** Delete a segment. */
  public IdResponse delete(String segmentId) {
    return client.delete(
        "/segments/" + pathParam("segmentId", segmentId) + "",
        IdResponse.class,
        RequestOptions.none());
  }

  /** List the organization segments. */
  public CursorPage<SegmentsResponseItem> list(SegmentsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/segments", SegmentsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<SegmentsResponseItem> list() {
    return list(SegmentsListParams.builder().build());
  }

  /** Retrieve one segment. */
  public SegmentResponse retrieve(String segmentId) {
    return client.get(
        "/segments/" + pathParam("segmentId", segmentId) + "",
        SegmentResponse.class,
        RequestOptions.none());
  }

  /** Rename a segment. */
  public IdResponse update(String segmentId, UpdateSegmentRequest body) {
    return client.patch(
        "/segments/" + pathParam("segmentId", segmentId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
