package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.contacts.*;
import java.util.*;

public final class Contacts extends Resource {
  private ContactsSegments segments;
  private ContactsTopics topics;

  public Contacts(NuntlyClient client) {
    super(client);
  }

  public ContactsSegments segments() {
    if (segments == null) segments = new ContactsSegments(client);
    return segments;
  }

  public ContactsTopics topics() {
    if (topics == null) topics = new ContactsTopics(client);
    return topics;
  }

  /** Create a contact. */
  public ContactResponse create(CreateContactRequest body) {
    return client.post("/contacts", body, ContactResponse.class, RequestOptions.none());
  }

  /** Delete a contact. */
  public IdResponse delete(String contactId) {
    return client.delete(
        "/contacts/" + pathParam("contactId", contactId) + "",
        IdResponse.class,
        RequestOptions.none());
  }

  /** List the organization contacts. */
  public CursorPage<ContactsResponseItem> list(ContactsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/contacts", ContactsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<ContactsResponseItem> list() {
    return list(ContactsListParams.builder().build());
  }

  /** Retrieve one contact. */
  public ContactResponse retrieve(String contactId) {
    return client.get(
        "/contacts/" + pathParam("contactId", contactId) + "",
        ContactResponse.class,
        RequestOptions.none());
  }

  /** Update a contact's properties. */
  public IdResponse update(String contactId, UpdateContactRequest body) {
    return client.patch(
        "/contacts/" + pathParam("contactId", contactId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
