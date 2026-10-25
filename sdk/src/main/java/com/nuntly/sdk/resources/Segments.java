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
    return create(body, RequestOptions.none());
  }

  public SegmentResponse create(CreateSegmentRequest body, RequestOptions opts) {
    return client.post("/segments", body, SegmentResponse.class, opts);
  }

  /** Delete a segment. */
  public IdResponse delete(String segmentId) {
    return delete(segmentId, RequestOptions.none());
  }

  public IdResponse delete(String segmentId, RequestOptions opts) {
    return client.delete(
        "/segments/" + pathParam("segmentId", segmentId) + "", IdResponse.class, opts);
  }

  /** List the organization segments. */
  public CursorPage<SegmentsResponseItem> list(SegmentsListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<SegmentsResponseItem> list(SegmentsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/segments", SegmentsResponseItem.class, query, opts);
  }

  public CursorPage<SegmentsResponseItem> list() {
    return list(SegmentsListParams.builder().build());
  }

  public CursorPage<SegmentsResponseItem> list(RequestOptions opts) {
    return list(SegmentsListParams.builder().build(), opts);
  }

  /** Retrieve one segment. */
  public SegmentResponse retrieve(String segmentId) {
    return retrieve(segmentId, RequestOptions.none());
  }

  public SegmentResponse retrieve(String segmentId, RequestOptions opts) {
    return client.get(
        "/segments/" + pathParam("segmentId", segmentId) + "", SegmentResponse.class, opts);
  }

  /** Rename a segment. */
  public IdResponse update(String segmentId, UpdateSegmentRequest body) {
    return update(segmentId, body, RequestOptions.none());
  }

  public IdResponse update(String segmentId, UpdateSegmentRequest body, RequestOptions opts) {
    return client.patch(
        "/segments/" + pathParam("segmentId", segmentId) + "", body, IdResponse.class, opts);
  }
}
