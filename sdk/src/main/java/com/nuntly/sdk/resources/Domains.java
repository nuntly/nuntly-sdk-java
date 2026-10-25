package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class Domains extends Resource {

  public Domains(NuntlyClient client) {
    super(client);
  }

  /**
   * Adds a domain for sending, receiving, or both, and returns the DNS records to publish.
   * Verification starts automatically and the plan domain limit applies.
   */
  public DomainRecordsResponse create(CreateDomainRequest body) {
    return create(body, RequestOptions.none());
  }

  public DomainRecordsResponse create(CreateDomainRequest body, RequestOptions opts) {
    return client.post("/domains", body, DomainRecordsResponse.class, opts);
  }

  /**
   * Permanently deletes a domain along with its inboxes, received messages, attachments, and
   * sending configuration. This action is irreversible.
   */
  public DeleteDomainResponse delete(String id) {
    return delete(id, RequestOptions.none());
  }

  public DeleteDomainResponse delete(String id, RequestOptions opts) {
    return client.delete("/domains/" + pathParam("id", id) + "", DeleteDomainResponse.class, opts);
  }

  /**
   * Lists the domains of your organization, newest first, with cursor pagination. Each domain shows
   * its verification status and sending and receiving status.
   */
  public CursorPage<DomainsResponseItem> list(DomainsListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<DomainsResponseItem> list(DomainsListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/domains", DomainsResponseItem.class, query, opts);
  }

  public CursorPage<DomainsResponseItem> list() {
    return list(DomainsListParams.builder().build());
  }

  public CursorPage<DomainsResponseItem> list(RequestOptions opts) {
    return list(DomainsListParams.builder().build(), opts);
  }

  /**
   * Retrieves a domain with its capabilities, tracking settings, statuses, and the DNS records to
   * publish, each with its own verification status.
   */
  public DomainRecordsResponse retrieve(String id) {
    return retrieve(id, RequestOptions.none());
  }

  public DomainRecordsResponse retrieve(String id, RequestOptions opts) {
    return client.get("/domains/" + pathParam("id", id) + "", DomainRecordsResponse.class, opts);
  }

  /**
   * Turns sending, receiving, open tracking, or click tracking on or off for a domain. Enabling a
   * capability adds its DNS records and restarts verification.
   */
  public UpdateDomainResponse update(String id, UpdateDomainRequest body) {
    return update(id, body, RequestOptions.none());
  }

  public UpdateDomainResponse update(String id, UpdateDomainRequest body, RequestOptions opts) {
    return client.patch(
        "/domains/" + pathParam("id", id) + "", body, UpdateDomainResponse.class, opts);
  }
}
