package com.nuntly.sdk;

import com.nuntly.sdk.resources.*;

public final class Nuntly {
  private final NuntlyClient client;
  private Agents agents;
  private ApiKeys apiKeys;
  private Broadcasts broadcasts;
  private ContactProperties contactProperties;
  private Contacts contacts;
  private Domains domains;
  private Emails emails;
  private Inboxes inboxes;
  private Messages messages;
  private Namespaces namespaces;
  private Organizations organizations;
  private Segments segments;
  private Templates templates;
  private Threads threads;
  private Topics topics;
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

  public Broadcasts broadcasts() {
    if (broadcasts == null) broadcasts = new Broadcasts(client);
    return broadcasts;
  }

  public ContactProperties contactProperties() {
    if (contactProperties == null) contactProperties = new ContactProperties(client);
    return contactProperties;
  }

  public Contacts contacts() {
    if (contacts == null) contacts = new Contacts(client);
    return contacts;
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

  public Segments segments() {
    if (segments == null) segments = new Segments(client);
    return segments;
  }

  public Templates templates() {
    if (templates == null) templates = new Templates(client);
    return templates;
  }

  public Threads threads() {
    if (threads == null) threads = new Threads(client);
    return threads;
  }

  public Topics topics() {
    if (topics == null) topics = new Topics(client);
    return topics;
  }

  public Webhooks webhooks() {
    if (webhooks == null) webhooks = new Webhooks(client);
    return webhooks;
  }
}
