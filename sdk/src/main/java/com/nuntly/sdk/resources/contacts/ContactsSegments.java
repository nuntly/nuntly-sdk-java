package com.nuntly.sdk.resources.contacts;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class ContactsSegments extends Resource {

  public ContactsSegments(NuntlyClient client) {
    super(client);
  }

  /** Add a contact to a segment. Idempotent. */
  public ContactSegmentMembershipResponse add(String contactId, String segmentId) {
    return add(contactId, segmentId, RequestOptions.none());
  }

  public ContactSegmentMembershipResponse add(
      String contactId, String segmentId, RequestOptions opts) {
    return client.post(
        "/contacts/"
            + pathParam("contactId", contactId)
            + "/segments/"
            + pathParam("segmentId", segmentId)
            + "",
        null,
        ContactSegmentMembershipResponse.class,
        opts);
  }

  /** List a contact's segments. */
  public List<ContactSegmentsResponseItem> list(String contactId) {
    return list(contactId, RequestOptions.none());
  }

  public List<ContactSegmentsResponseItem> list(String contactId, RequestOptions opts) {
    return List.of(
        client.get(
            "/contacts/" + pathParam("contactId", contactId) + "/segments",
            ContactSegmentsResponseItem[].class,
            opts));
  }

  /** Remove a contact from a segment. */
  public ContactSegmentMembershipIdResponse remove(String contactId, String segmentId) {
    return remove(contactId, segmentId, RequestOptions.none());
  }

  public ContactSegmentMembershipIdResponse remove(
      String contactId, String segmentId, RequestOptions opts) {
    return client.delete(
        "/contacts/"
            + pathParam("contactId", contactId)
            + "/segments/"
            + pathParam("segmentId", segmentId)
            + "",
        ContactSegmentMembershipIdResponse.class,
        opts);
  }

  /** Check if a contact is in a segment. */
  public ContactSegmentMembershipResponse retrieve(String contactId, String segmentId) {
    return retrieve(contactId, segmentId, RequestOptions.none());
  }

  public ContactSegmentMembershipResponse retrieve(
      String contactId, String segmentId, RequestOptions opts) {
    return client.get(
        "/contacts/"
            + pathParam("contactId", contactId)
            + "/segments/"
            + pathParam("segmentId", segmentId)
            + "",
        ContactSegmentMembershipResponse.class,
        opts);
  }
}
