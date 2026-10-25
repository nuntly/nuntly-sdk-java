package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class ContactProperties extends Resource {

  public ContactProperties(NuntlyClient client) {
    super(client);
  }

  /** Create a contact property. */
  public ContactPropertyResponse create(CreateContactPropertyRequest body) {
    return create(body, RequestOptions.none());
  }

  public ContactPropertyResponse create(CreateContactPropertyRequest body, RequestOptions opts) {
    return client.post("/contact-properties", body, ContactPropertyResponse.class, opts);
  }

  /** Delete a contact property. */
  public IdResponse delete(String contactPropertyId) {
    return delete(contactPropertyId, RequestOptions.none());
  }

  public IdResponse delete(String contactPropertyId, RequestOptions opts) {
    return client.delete(
        "/contact-properties/" + pathParam("contactPropertyId", contactPropertyId) + "",
        IdResponse.class,
        opts);
  }

  /** List the organization contact properties. */
  public CursorPage<ContactPropertiesResponseItem> list(ContactPropertiesListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<ContactPropertiesResponseItem> list(
      ContactPropertiesListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/contact-properties", ContactPropertiesResponseItem.class, query, opts);
  }

  public CursorPage<ContactPropertiesResponseItem> list() {
    return list(ContactPropertiesListParams.builder().build());
  }

  public CursorPage<ContactPropertiesResponseItem> list(RequestOptions opts) {
    return list(ContactPropertiesListParams.builder().build(), opts);
  }

  /** Retrieve one contact property. */
  public ContactPropertyResponse retrieve(String contactPropertyId) {
    return retrieve(contactPropertyId, RequestOptions.none());
  }

  public ContactPropertyResponse retrieve(String contactPropertyId, RequestOptions opts) {
    return client.get(
        "/contact-properties/" + pathParam("contactPropertyId", contactPropertyId) + "",
        ContactPropertyResponse.class,
        opts);
  }

  /** Update a contact property. */
  public IdResponse update(String contactPropertyId, UpdateContactPropertyRequest body) {
    return update(contactPropertyId, body, RequestOptions.none());
  }

  public IdResponse update(
      String contactPropertyId, UpdateContactPropertyRequest body, RequestOptions opts) {
    return client.patch(
        "/contact-properties/" + pathParam("contactPropertyId", contactPropertyId) + "",
        body,
        IdResponse.class,
        opts);
  }
}
