package com.nuntly.sdk;

import com.nuntly.sdk.models.*;
import java.util.List;

final class CodeSamples {
  private CodeSamples() {}

  static void addContactSegment(Nuntly nuntly) {
    var response =
        nuntly
            .contacts()
            .segments()
            .add("ct_01kabn43yqyxn2bx4ve84mczd3", "seg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void cancelEmail(Nuntly nuntly) {
    var response = nuntly.emails().cancel("em_01ka8k8s80gvx9604cn9am5st4");
  }

  static void createApiKey(Nuntly nuntly) {
    var response =
        nuntly.apiKeys().create(CreateApiKeyRequest.builder().name("Production").build());
  }

  static void createBroadcast(Nuntly nuntly) {
    var response =
        nuntly
            .broadcasts()
            .create(
                CreateBroadcastRequest.builder()
                    .from("Tomlinson AI <ray@info.tomlinson.ai>")
                    .name("October newsletter")
                    .build());
  }

  static void createContact(Nuntly nuntly) {
    var response =
        nuntly.contacts().create(CreateContactRequest.builder().email("jane@example.com").build());
  }

  static void createContactProperty(Nuntly nuntly) {
    var response =
        nuntly
            .contactProperties()
            .create(
                CreateContactPropertyRequest.builder()
                    .name("plan")
                    .type(ContactPropertyType.STRING)
                    .build());
  }

  static void createDomain(Nuntly nuntly) {
    var response =
        nuntly.domains().create(CreateDomainRequest.builder().name("example.com").build());
  }

  static void createInbox(Nuntly nuntly) {
    var response = nuntly.inboxes().create(CreateInboxRequest.builder().address("support").build());
  }

  static void createNamespace(Nuntly nuntly) {
    var response =
        nuntly
            .namespaces()
            .create(CreateNamespaceRequest.builder().name("Customer support").build());
  }

  static void createSegment(Nuntly nuntly) {
    var response =
        nuntly.segments().create(CreateSegmentRequest.builder().name("vip customers").build());
  }

  static void createTemplate(Nuntly nuntly) {
    var response =
        nuntly.templates().create(CreateTemplateRequest.builder().name("Welcome email").build());
  }

  static void createTemplateVersion(Nuntly nuntly) {
    var response =
        nuntly
            .templates()
            .versions()
            .create(
                "tpl_01kabn43yqyxn2bx4ve84mczd3",
                CreateTemplateVersionRequest.builder()
                    .subject("Verify your email address")
                    .html(
                        "<h1>Welcome</h1><p>Thank you for signing up! Please verify your email"
                            + " address.</p>")
                    .text("Thank you for signing up! Please verify your email address.")
                    .build());
  }

  static void createTopic(Nuntly nuntly) {
    var response =
        nuntly.topics().create(CreateTopicRequest.builder().name("product updates").build());
  }

  static void createWebhook(Nuntly nuntly) {
    var response =
        nuntly
            .webhooks()
            .create(
                CreateWebhookRequest.builder()
                    .name("Production webhook")
                    .endpointUrl("https://example.com/webhooks")
                    .events(List.of(WebhookEventType.EMAIL_SENT))
                    .build());
  }

  static void deleteApiKey(Nuntly nuntly) {
    var response = nuntly.apiKeys().delete("apk_01ka8k8s80gvx9604cn9am5st4");
  }

  static void deleteBroadcast(Nuntly nuntly) {
    var response = nuntly.broadcasts().delete("bc_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteContact(Nuntly nuntly) {
    var response = nuntly.contacts().delete("ct_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteContactProperty(Nuntly nuntly) {
    var response = nuntly.contactProperties().delete("ctpd_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteDomain(Nuntly nuntly) {
    var response = nuntly.domains().delete("dns_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteInbox(Nuntly nuntly) {
    var response = nuntly.inboxes().delete("ibx_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteNamespace(Nuntly nuntly) {
    var response = nuntly.namespaces().delete("ns_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteSegment(Nuntly nuntly) {
    var response = nuntly.segments().delete("seg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteTemplate(Nuntly nuntly) {
    var response = nuntly.templates().delete("tpl_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteTopic(Nuntly nuntly) {
    var response = nuntly.topics().delete("tpc_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void deleteWebhook(Nuntly nuntly) {
    var response = nuntly.webhooks().delete("wh_01ka8k8s80gvx9604cn9am5st4");
  }

  static void forwardMessage(Nuntly nuntly) {
    var response =
        nuntly
            .messages()
            .forward(
                "imsg_01kabn43yqyxn2bx4ve84mczd3",
                ForwardMessageRequest.builder()
                    .to(List.of("brian67@gmail.com"))
                    .text("Thank you for signing up! Please verify your email address.")
                    .build());
  }

  static void listApiKeys(Nuntly nuntly) {
    var response = nuntly.apiKeys().list();
  }

  static void listBroadcastRecipients(Nuntly nuntly) {
    var response = nuntly.broadcasts().recipients().list("bc_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listBroadcasts(Nuntly nuntly) {
    var response = nuntly.broadcasts().list();
  }

  static void listContactProperties(Nuntly nuntly) {
    var response = nuntly.contactProperties().list();
  }

  static void listContactSegments(Nuntly nuntly) {
    var response = nuntly.contacts().segments().list("ct_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listContactTopics(Nuntly nuntly) {
    var response = nuntly.contacts().topics().list("ct_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listContacts(Nuntly nuntly) {
    var response = nuntly.contacts().list();
  }

  static void listDomains(Nuntly nuntly) {
    var response = nuntly.domains().list();
  }

  static void listEmailEvents(Nuntly nuntly) {
    var response = nuntly.emails().events().list("em_01ka8k8s80gvx9604cn9am5st4");
  }

  static void listEmails(Nuntly nuntly) {
    var response = nuntly.emails().list();
  }

  static void listInboxThreads(Nuntly nuntly) {
    var response = nuntly.inboxes().threads().list("ibx_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listInboxes(Nuntly nuntly) {
    var response = nuntly.inboxes().list();
  }

  static void listMessageAttachments(Nuntly nuntly) {
    var response = nuntly.messages().attachments().list("imsg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listMessages(Nuntly nuntly) {
    var response = nuntly.messages().list();
  }

  static void listNamespaceInboxes(Nuntly nuntly) {
    var response = nuntly.namespaces().inboxes().list("ns_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listNamespaces(Nuntly nuntly) {
    var response = nuntly.namespaces().list();
  }

  static void listOrganizations(Nuntly nuntly) {
    var response = nuntly.organizations().list();
  }

  static void listSegmentMembers(Nuntly nuntly) {
    var response = nuntly.segments().members().list("seg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listSegments(Nuntly nuntly) {
    var response = nuntly.segments().list();
  }

  static void listTemplateVersions(Nuntly nuntly) {
    var response = nuntly.templates().versions().list("tpl_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listTemplates(Nuntly nuntly) {
    var response = nuntly.templates().list();
  }

  static void listThreadMessages(Nuntly nuntly) {
    var response = nuntly.threads().messages().list("thr_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listTopicMemberships(Nuntly nuntly) {
    var response = nuntly.topics().memberships().list("tpc_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void listTopics(Nuntly nuntly) {
    var response = nuntly.topics().list();
  }

  static void listWebhookEventDeliveries(Nuntly nuntly) {
    var response =
        nuntly
            .webhooks()
            .events()
            .deliveries()
            .list("wh_01ka8k8s80gvx9604cn9am5st4", "evt_01ka8k8s80gvx9604cn9am5st4");
  }

  static void listWebhookEvents(Nuntly nuntly) {
    var response = nuntly.webhooks().events().list();
  }

  static void listWebhooks(Nuntly nuntly) {
    var response = nuntly.webhooks().list();
  }

  static void publishTemplateVersion(Nuntly nuntly) {
    var response =
        nuntly
            .templates()
            .versions()
            .publish("tpl_01kabn43yqyxn2bx4ve84mczd3", "tpv_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void removeContactSegment(Nuntly nuntly) {
    var response =
        nuntly
            .contacts()
            .segments()
            .remove("ct_01kabn43yqyxn2bx4ve84mczd3", "seg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void replayWebhookEvent(Nuntly nuntly) {
    nuntly
        .webhooks()
        .events()
        .replay("wh_01ka8k8s80gvx9604cn9am5st4", "evt_01ka8k8s80gvx9604cn9am5st4");
  }

  static void replyMessage(Nuntly nuntly) {
    var response =
        nuntly
            .messages()
            .reply(
                "imsg_01kabn43yqyxn2bx4ve84mczd3",
                ReplyMessageRequest.builder()
                    .text("Thank you for signing up! Please verify your email address.")
                    .html(
                        "<h1>Welcome</h1><p>Thank you for signing up! Please verify your email"
                            + " address.</p>")
                    .build());
  }

  static void retrieveAgentMemory(Nuntly nuntly) {
    var response = nuntly.agents().memory().retrieve("aB3dE7fG");
  }

  static void retrieveApiKey(Nuntly nuntly) {
    var response = nuntly.apiKeys().retrieve("apk_01ka8k8s80gvx9604cn9am5st4");
  }

  static void retrieveBroadcast(Nuntly nuntly) {
    var response = nuntly.broadcasts().retrieve("bc_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveContact(Nuntly nuntly) {
    var response = nuntly.contacts().retrieve("ct_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveContactProperty(Nuntly nuntly) {
    var response = nuntly.contactProperties().retrieve("ctpd_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveContactSegment(Nuntly nuntly) {
    var response =
        nuntly
            .contacts()
            .segments()
            .retrieve("ct_01kabn43yqyxn2bx4ve84mczd3", "seg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveDomain(Nuntly nuntly) {
    var response = nuntly.domains().retrieve("dns_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveEmail(Nuntly nuntly) {
    var response = nuntly.emails().retrieve("em_01ka8k8s80gvx9604cn9am5st4");
  }

  static void retrieveEmailBulk(Nuntly nuntly) {
    var response = nuntly.emails().bulk().retrieve("blk_01ka8k8s80gvx9604cn9am5st4");
  }

  static void retrieveEmailContent(Nuntly nuntly) {
    var response = nuntly.emails().content().retrieve("em_01ka8k8s80gvx9604cn9am5st4");
  }

  static void retrieveEmailStats(Nuntly nuntly) {
    var response = nuntly.emails().stats().retrieve();
  }

  static void retrieveInbox(Nuntly nuntly) {
    var response = nuntly.inboxes().retrieve("ibx_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveMessage(Nuntly nuntly) {
    var response = nuntly.messages().retrieve("imsg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveMessageAttachment(Nuntly nuntly) {
    var response =
        nuntly
            .messages()
            .attachments()
            .retrieve("imsg_01kabn43yqyxn2bx4ve84mczd3", "iatt_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveMessageContent(Nuntly nuntly) {
    var response = nuntly.messages().content().retrieve("imsg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveNamespace(Nuntly nuntly) {
    var response = nuntly.namespaces().retrieve("ns_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveOrganization(Nuntly nuntly) {
    var response = nuntly.organizations().retrieve("org_01ka8k8s80gvx9604cn9am5st4");
  }

  static void retrieveOrganizationUsage(Nuntly nuntly) {
    var response = nuntly.organizations().usage().retrieve("org_01ka8k8s80gvx9604cn9am5st4");
  }

  static void retrieveSegment(Nuntly nuntly) {
    var response = nuntly.segments().retrieve("seg_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveTemplate(Nuntly nuntly) {
    var response = nuntly.templates().retrieve("tpl_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveTemplateVersion(Nuntly nuntly) {
    var response =
        nuntly
            .templates()
            .versions()
            .retrieve("tpl_01kabn43yqyxn2bx4ve84mczd3", "tpv_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveTemplateVersionContent(Nuntly nuntly) {
    var response =
        nuntly
            .templates()
            .versions()
            .content()
            .retrieve("tpl_01kabn43yqyxn2bx4ve84mczd3", "tpv_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveThread(Nuntly nuntly) {
    var response = nuntly.threads().retrieve("thr_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveTopic(Nuntly nuntly) {
    var response = nuntly.topics().retrieve("tpc_01kabn43yqyxn2bx4ve84mczd3");
  }

  static void retrieveWebhook(Nuntly nuntly) {
    var response = nuntly.webhooks().retrieve("wh_01ka8k8s80gvx9604cn9am5st4");
  }

  static void sendBroadcast(Nuntly nuntly) {
    var response =
        nuntly
            .broadcasts()
            .send(
                "bc_01kabn43yqyxn2bx4ve84mczd3",
                SendBroadcastRequest.builder().scheduledAt("2026-03-30T09:00:00.000Z").build());
  }

  static void sendEmail(Nuntly nuntly) {
    var response =
        nuntly
            .emails()
            .send(
                CreateEmailRequest.builder()
                    .from("Tomlinson AI <ray@info.tomlinson.ai>")
                    .to(List.of("brian67@gmail.com"))
                    .subject("Verify your email address")
                    .text("Thank you for signing up! Please verify your email address.")
                    .html(
                        "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email"
                            + " address.</p>")
                    .tags(List.of(Tag.builder().name("category").value("transactional").build()))
                    .build());
  }

  static void sendEmailBulk(Nuntly nuntly) {
    var response =
        nuntly
            .emails()
            .bulk()
            .send(
                CreateBulkEmailsRequest.builder()
                    .emails(
                        List.of(
                            CreateBulkEmail.builder()
                                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                                .to(List.of("brian67@gmail.com"))
                                .subject("Verify your email address")
                                .text("Thank you for signing up! Please verify your email address.")
                                .build()))
                    .build());
  }

  static void sendInboxMessage(Nuntly nuntly) {
    var response =
        nuntly
            .inboxes()
            .messages()
            .send(
                "ibx_01kabn43yqyxn2bx4ve84mczd3",
                SendMessageRequest.builder()
                    .to(List.of("brian67@gmail.com"))
                    .subject("Verify your email address")
                    .text("Thank you for signing up! Please verify your email address.")
                    .html(
                        "<h1>Welcome</h1><p>Thank you for signing up! Please verify your email"
                            + " address.</p>")
                    .build());
  }

  static void updateApiKey(Nuntly nuntly) {
    var response =
        nuntly
            .apiKeys()
            .update(
                "apk_01ka8k8s80gvx9604cn9am5st4",
                UpdateApiKeyRequest.builder().name("Production").build());
  }

  static void updateBroadcast(Nuntly nuntly) {
    var response =
        nuntly
            .broadcasts()
            .update(
                "bc_01kabn43yqyxn2bx4ve84mczd3",
                UpdateBroadcastRequest.builder().name("October newsletter").build());
  }

  static void updateContact(Nuntly nuntly) {
    var response =
        nuntly
            .contacts()
            .update(
                "ct_01kabn43yqyxn2bx4ve84mczd3",
                UpdateContactRequest.builder().properties(java.util.Map.of("plan", "pro")).build());
  }

  static void updateContactProperty(Nuntly nuntly) {
    var response =
        nuntly
            .contactProperties()
            .update(
                "ctpd_01kabn43yqyxn2bx4ve84mczd3",
                UpdateContactPropertyRequest.builder()
                    .description("The plan the customer is on.")
                    .build());
  }

  static void updateContactTopic(Nuntly nuntly) {
    var response =
        nuntly
            .contacts()
            .topics()
            .update(
                "ct_01kabn43yqyxn2bx4ve84mczd3",
                "tpc_01kabn43yqyxn2bx4ve84mczd3",
                SetContactTopicMembershipRequest.builder()
                    .state(TopicMembershipState.SUBSCRIBED)
                    .build());
  }

  static void updateDomain(Nuntly nuntly) {
    var response =
        nuntly
            .domains()
            .update(
                "dns_01kabn43yqyxn2bx4ve84mczd3",
                UpdateDomainRequest.builder().openTracking(true).clickTracking(true).build());
  }

  static void updateInbox(Nuntly nuntly) {
    var response =
        nuntly
            .inboxes()
            .update(
                "ibx_01kabn43yqyxn2bx4ve84mczd3",
                UpdateInboxRequest.builder().name("Support team").build());
  }

  static void updateMessage(Nuntly nuntly) {
    var response =
        nuntly
            .messages()
            .update(
                "imsg_01kabn43yqyxn2bx4ve84mczd3",
                UpdateMessageRequest.builder().addLabels(List.of("urgent")).build());
  }

  static void updateNamespace(Nuntly nuntly) {
    var response =
        nuntly
            .namespaces()
            .update(
                "ns_01kabn43yqyxn2bx4ve84mczd3",
                UpdateNamespaceRequest.builder().name("Customer support").build());
  }

  static void updateSegment(Nuntly nuntly) {
    var response =
        nuntly
            .segments()
            .update(
                "seg_01kabn43yqyxn2bx4ve84mczd3",
                UpdateSegmentRequest.builder().name("vip customers").build());
  }

  static void updateTemplate(Nuntly nuntly) {
    var response =
        nuntly
            .templates()
            .update(
                "tpl_01kabn43yqyxn2bx4ve84mczd3",
                UpdateTemplateRequest.builder().name("Welcome email").build());
  }

  static void updateThread(Nuntly nuntly) {
    var response =
        nuntly
            .threads()
            .update(
                "thr_01kabn43yqyxn2bx4ve84mczd3",
                UpdateThreadRequest.builder().addLabels(List.of("urgent")).build());
  }

  static void updateTopic(Nuntly nuntly) {
    var response =
        nuntly
            .topics()
            .update(
                "tpc_01kabn43yqyxn2bx4ve84mczd3",
                UpdateTopicRequest.builder().name("product updates").build());
  }

  static void updateWebhook(Nuntly nuntly) {
    var response =
        nuntly
            .webhooks()
            .update(
                "wh_01ka8k8s80gvx9604cn9am5st4",
                UpdateWebhookRequest.builder()
                    .name("Production webhook")
                    .events(List.of(WebhookEventType.EMAIL_SENT))
                    .build());
  }

  static void upsertAgentMemory(Nuntly nuntly) {
    var response =
        nuntly
            .agents()
            .memory()
            .upsert(
                "aB3dE7fG",
                AgentMemoryRequest.builder()
                    .memory(java.util.Map.of("lastTopic", "billing", "openTickets", 2))
                    .build());
  }
}
