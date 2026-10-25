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
    return create(body, RequestOptions.none());
  }

  public ContactResponse create(CreateContactRequest body, RequestOptions opts) {
    return client.post("/contacts", body, ContactResponse.class, opts);
  }

  /** Delete a contact. */
  public IdResponse delete(String contactId) {
    return delete(contactId, RequestOptions.none());
  }

  public IdResponse delete(String contactId, RequestOptions opts) {
    return client.delete(
        "/contacts/" + pathParam("contactId", contactId) + "", IdResponse.class, opts);
  }

  /** List the organization contacts. */
  public CursorPage<ContactsResponseItem> list(ContactsListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<ContactsResponseItem> list(ContactsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/contacts", ContactsResponseItem.class, query, opts);
  }

  public CursorPage<ContactsResponseItem> list() {
    return list(ContactsListParams.builder().build());
  }

  public CursorPage<ContactsResponseItem> list(RequestOptions opts) {
    return list(ContactsListParams.builder().build(), opts);
  }

  /** Retrieve one contact. */
  public ContactResponse retrieve(String contactId) {
    return retrieve(contactId, RequestOptions.none());
  }

  public ContactResponse retrieve(String contactId, RequestOptions opts) {
    return client.get(
        "/contacts/" + pathParam("contactId", contactId) + "", ContactResponse.class, opts);
  }

  /** Update a contact's properties. */
  public IdResponse update(String contactId, UpdateContactRequest body) {
    return update(contactId, body, RequestOptions.none());
  }

  public IdResponse update(String contactId, UpdateContactRequest body, RequestOptions opts) {
    return client.patch(
        "/contacts/" + pathParam("contactId", contactId) + "", body, IdResponse.class, opts);
  }
}
