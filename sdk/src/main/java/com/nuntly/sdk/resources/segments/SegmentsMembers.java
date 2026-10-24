package com.nuntly.sdk.resources.segments;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class SegmentsMembers extends Resource {

  public SegmentsMembers(NuntlyClient client) {
    super(client);
  }

  /** List the members of a segment. */
  public CursorPage<SegmentMembersResponseItem> list(
      String segmentId, SegmentsMembersListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list(
        "/segments/" + pathParam("segmentId", segmentId) + "/members",
        SegmentMembersResponseItem.class,
        query,
        RequestOptions.none());
  }

  public CursorPage<SegmentMembersResponseItem> list(String segmentId) {
    return list(segmentId, SegmentsMembersListParams.builder().build());
  }
}
