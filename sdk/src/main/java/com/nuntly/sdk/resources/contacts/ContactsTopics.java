package com.nuntly.sdk.resources.contacts;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class ContactsTopics extends Resource {

  public ContactsTopics(NuntlyClient client) {
    super(client);
  }

  /** List a contact's subscription state per topic. */
  public List<ContactTopicMembershipsResponseItem> list(String contactId) {
    return list(contactId, RequestOptions.none());
  }

  public List<ContactTopicMembershipsResponseItem> list(String contactId, RequestOptions opts) {
    return List.of(
        client.get(
            "/contacts/" + pathParam("contactId", contactId) + "/topics",
            ContactTopicMembershipsResponseItem[].class,
            opts));
  }

  /** Subscribe or unsubscribe a contact from a topic. */
  public SetContactTopicMembershipResponse update(
      String contactId, String topicId, SetContactTopicMembershipRequest body) {
    return update(contactId, topicId, body, RequestOptions.none());
  }

  public SetContactTopicMembershipResponse update(
      String contactId,
      String topicId,
      SetContactTopicMembershipRequest body,
      RequestOptions opts) {
    return client.put(
        "/contacts/"
            + pathParam("contactId", contactId)
            + "/topics/"
            + pathParam("topicId", topicId)
            + "",
        body,
        SetContactTopicMembershipResponse.class,
        opts);
  }
}
