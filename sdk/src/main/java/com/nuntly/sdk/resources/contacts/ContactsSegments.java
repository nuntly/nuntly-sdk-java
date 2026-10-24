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
    return client.post(
        "/contacts/"
            + pathParam("contactId", contactId)
            + "/segments/"
            + pathParam("segmentId", segmentId)
            + "",
        null,
        ContactSegmentMembershipResponse.class,
        RequestOptions.none());
  }

  /** List a contact's segments. */
  public List<ContactSegmentsResponseItem> list(String contactId) {
    var response =
        client.rawRequest(
            "GET",
            "/contacts/" + pathParam("contactId", contactId) + "/segments",
            null,
            RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), ContactSegmentsResponseItem[].class);
    return List.of(items);
  }

  /** Remove a contact from a segment. */
  public ContactSegmentMembershipIdResponse remove(String contactId, String segmentId) {
    return client.delete(
        "/contacts/"
            + pathParam("contactId", contactId)
            + "/segments/"
            + pathParam("segmentId", segmentId)
            + "",
        ContactSegmentMembershipIdResponse.class,
        RequestOptions.none());
  }

  /** Check if a contact is in a segment. */
  public ContactSegmentMembershipResponse retrieve(String contactId, String segmentId) {
    return client.get(
        "/contacts/"
            + pathParam("contactId", contactId)
            + "/segments/"
            + pathParam("segmentId", segmentId)
            + "",
        ContactSegmentMembershipResponse.class,
        RequestOptions.none());
  }
}
