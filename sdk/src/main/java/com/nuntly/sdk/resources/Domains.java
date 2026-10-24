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
    return client.post("/domains", body, DomainRecordsResponse.class, RequestOptions.none());
  }

  /**
   * Permanently deletes a domain along with its inboxes, received messages, attachments, and
   * sending configuration. This action is irreversible.
   */
  public DeleteDomainResponse delete(String id) {
    return client.delete(
        "/domains/" + pathParam("id", id) + "", DeleteDomainResponse.class, RequestOptions.none());
  }

  /**
   * Lists the domains of your organization, newest first, with cursor pagination. Each domain shows
   * its verification status and sending and receiving status.
   */
  public CursorPage<DomainsResponseItem> list(DomainsListParams params) {
    var query = new HashMap<String, String>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v.toString()));
    return client.list("/domains", DomainsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<DomainsResponseItem> list() {
    return list(DomainsListParams.builder().build());
  }

  /**
   * Retrieves a domain with its capabilities, tracking settings, statuses, and the DNS records to
   * publish, each with its own verification status.
   */
  public DomainRecordsResponse retrieve(String id) {
    return client.get(
        "/domains/" + pathParam("id", id) + "", DomainRecordsResponse.class, RequestOptions.none());
  }

  /**
   * Turns sending, receiving, open tracking, or click tracking on or off for a domain. Enabling a
   * capability adds its DNS records and restarts verification.
   */
  public UpdateDomainResponse update(String id, UpdateDomainRequest body) {
    return client.patch(
        "/domains/" + pathParam("id", id) + "",
        body,
        UpdateDomainResponse.class,
        RequestOptions.none());
  }
}
