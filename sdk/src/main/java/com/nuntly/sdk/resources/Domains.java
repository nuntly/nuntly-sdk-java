package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class Domains extends Resource {

  public Domains(NuntlyClient client) {
    super(client);
  }

  /** Add a domain to start configuring DNS records for sending or receiving emails. */
  public DomainRecordsResponse create(CreateDomainRequest body) {
    return client.post("/domains", body, DomainRecordsResponse.class, RequestOptions.none());
  }

  /**
   * Permanently deletes a domain along with its inboxes, received messages, attachments, and
   * sending configuration. This action is irreversible.
   */
  public DeleteDomainResponse delete(String id) {
    return client.delete("/domains/" + id + "", DeleteDomainResponse.class, RequestOptions.none());
  }

  /** Returns all domains with their verification and capability status. */
  public CursorPage<DomainsResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    return client.list("/domains", DomainsResponseItem.class, query, RequestOptions.none());
  }

  public CursorPage<DomainsResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }

  /**
   * Returns a domain with its DNS record configuration and current verification status for each
   * record.
   */
  public DomainRecordsResponse retrieve(String id) {
    return client.get("/domains/" + id + "", DomainRecordsResponse.class, RequestOptions.none());
  }

  /** Toggle sending, receiving, open tracking, or click tracking capabilities for a domain. */
  public UpdateDomainResponse update(String id, UpdateDomainRequest body) {
    return client.patch(
        "/domains/" + id + "", body, UpdateDomainResponse.class, RequestOptions.none());
  }
}
