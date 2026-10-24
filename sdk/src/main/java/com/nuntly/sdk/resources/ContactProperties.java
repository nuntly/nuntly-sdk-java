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
    return client.post(
        "/contact-properties", body, ContactPropertyResponse.class, RequestOptions.none());
  }

  /** Delete a contact property. */
  public IdResponse delete(String contactPropertyId) {
    return client.delete(
        "/contact-properties/" + pathParam("contactPropertyId", contactPropertyId) + "",
        IdResponse.class,
        RequestOptions.none());
  }

  /** List the organization contact properties. */
  public CursorPage<ContactPropertiesResponseItem> list(ContactPropertiesListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list(
        "/contact-properties", ContactPropertiesResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<ContactPropertiesResponseItem> list() {
    return list(ContactPropertiesListParams.builder().build());
  }

  /** Retrieve one contact property. */
  public ContactPropertyResponse retrieve(String contactPropertyId) {
    return client.get(
        "/contact-properties/" + pathParam("contactPropertyId", contactPropertyId) + "",
        ContactPropertyResponse.class,
        RequestOptions.none());
  }

  /** Update a contact property. */
  public IdResponse update(String contactPropertyId, UpdateContactPropertyRequest body) {
    return client.patch(
        "/contact-properties/" + pathParam("contactPropertyId", contactPropertyId) + "",
        body,
        IdResponse.class,
        RequestOptions.none());
  }
}
