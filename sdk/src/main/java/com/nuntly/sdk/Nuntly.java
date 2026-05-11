package com.nuntly.sdk;

import com.nuntly.sdk.resources.*;

public final class Nuntly {
  private final NuntlyClient client;
  private Agents agents;
  private ApiKeys apiKeys;
  private Domains domains;
  private Emails emails;
  private Inboxes inboxes;
  private Messages messages;
  private Namespaces namespaces;
  private Organizations organizations;
  private Threads threads;
  private Webhooks webhooks;

  private Nuntly(ClientOptions options) {
    this.client = new NuntlyClient(options);
  }

  public static ClientOptions.Builder builder() {
    return ClientOptions.builder();
  }

  public static Nuntly create(ClientOptions options) {
    return new Nuntly(options);
  }

  public Agents agents() {
    if (agents == null) agents = new Agents(client);
    return agents;
  }

  public ApiKeys apiKeys() {
    if (apiKeys == null) apiKeys = new ApiKeys(client);
    return apiKeys;
  }

  public Domains domains() {
    if (domains == null) domains = new Domains(client);
    return domains;
  }

  public Emails emails() {
    if (emails == null) emails = new Emails(client);
    return emails;
  }

  public Inboxes inboxes() {
    if (inboxes == null) inboxes = new Inboxes(client);
    return inboxes;
  }

  public Messages messages() {
    if (messages == null) messages = new Messages(client);
    return messages;
  }

  public Namespaces namespaces() {
    if (namespaces == null) namespaces = new Namespaces(client);
    return namespaces;
  }

  public Organizations organizations() {
    if (organizations == null) organizations = new Organizations(client);
    return organizations;
  }

  public Threads threads() {
    if (threads == null) threads = new Threads(client);
    return threads;
  }

  public Webhooks webhooks() {
    if (webhooks == null) webhooks = new Webhooks(client);
    return webhooks;
  }
}
