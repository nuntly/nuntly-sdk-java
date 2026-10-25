package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.nuntly.sdk.models.*;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.*;

class WireTest {

  static HttpServer server;
  static int port;
  static String lastMethod;
  static String lastPath;
  static String lastAuth;
  static String lastUserAgent;
  static String lastBody;

  @BeforeAll
  static void startServer() throws IOException {
    server = HttpServer.create(new InetSocketAddress(0), 0);
    port = server.getAddress().getPort();

    server.createContext(
        "/",
        exchange -> {
          lastMethod = exchange.getRequestMethod();
          lastPath = exchange.getRequestURI().toString();
          lastAuth = exchange.getRequestHeaders().getFirst("Authorization");
          lastUserAgent = exchange.getRequestHeaders().getFirst("User-Agent");
          lastBody = new String(exchange.getRequestBody().readAllBytes());

          var response =
              switch (lastPath) {
                case String p when p.startsWith("/emails/em_not_found") ->
                    new MockResponse(
                        404,
                        """
                        {"error":{"status":404,"code":"not_found","title":"Resource not found"}}\
                        """);
                case String p when p.startsWith("/emails/em_title_in_details") ->
                    new MockResponse(
                        404,
                        """
                        {"error":{"status":404,"code":"not_found","title":"Resource not found","details":"the literal string \\"title\\" appears inside details"}}\
                        """);
                case String p when p.equals("/emails") && lastMethod.equals("POST") ->
                    new MockResponse(
                        201,
                        """
                        {"data":{"id":"em_new","status":"queued"}}\
                        """);
                case String p
                    when p.startsWith("/emails/")
                        && !p.startsWith("/emails/bulk/")
                        && lastMethod.equals("GET") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"id":"em_123","orgId":"org_1","from":"a@b.com","to":["c@d.com"],"status":"delivered","subject":"Test","createdAt":"2026-01-01T00:00:00Z"}}\
                        """);
                case String p when p.startsWith("/templates/tpl_1/versions/tpv_1/content") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"html":{"status":"available","downloadUrl":"https://files.example.com/h","expiresAt":"2026-01-01T00:00:00Z"},"text":{"status":"absent"}}}\
                        """);
                case String p when p.startsWith("/templates/tpl_2/versions/tpv_2/content") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"html":{"status":"expired"},"text":{"status":"unavailable"}}}\
                        """);
                case String p when p.startsWith("/webhooks/wh_disabled") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"id":"wh_disabled","name":"Production webhook","status":"disabled","disabledReason":"auto_consecutive_failures","disabledAt":"2026-01-01T00:00:00Z"}}\
                        """);
                case String p when p.startsWith("/webhooks/wh_enabled") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"id":"wh_enabled","name":"Production webhook","status":"enabled","disabledReason":null,"disabledAt":null}}\
                        """);
                case String p when p.startsWith("/domains/dns_records") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"id":"dns_records","name":"example.com","status":"verified","records":[{"name":"nuntly._domainkey","fullname":"nuntly._domainkey.example.com","recordType":"CNAME","ttl":"3600","group":"DKIM","selector":"nuntly","value":"dkim.nuntly.com","status":"verified","statusAt":"2026-01-01T00:00:00Z"}]}}\
                        """);
                case String p when p.startsWith("/emails/bulk/blk_1") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"id":"blk_1","emails":[{"id":"em_1","status":"queued"},{"id":"em_2","status":"failed","detail":"Invalid recipient"}]}}\
                        """);
                case String p when p.startsWith("/organizations/org_1/usage") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"email":{"daily":{"used":12,"limit":null,"breakdown":{"transactional":{"sent":10,"received":1},"broadcast":{"sent":1}},"resetsAt":"2026-01-02T00:00:00Z"},"monthly":{"used":40,"limit":3000,"breakdown":{"transactional":{"sent":30,"received":5},"broadcast":{"sent":5}},"resetsAt":null}}}}\
                        """);
                case String p when p.startsWith("/templates/tpl_1/versions/tpv_1") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"id":"tpv_1","variables":[{"name":"month","type":"string"},{"name":"plan","type":"string","default":"free"}]}}\
                        """);
                case String p when p.startsWith("/broadcasts/bc_1/recipients") ->
                    new MockResponse(
                        200,
                        """
                        {"data":[{"id":"bcr_1","contactId":null,"email":"jane@example.com","outcome":"delivered","createdAt":"2026-01-01T00:00:00Z"}],"nextCursor":null}\
                        """);
                case String p when p.equals("/contacts/ct_1/segments") ->
                    new MockResponse(
                        200,
                        """
                        {"data":[{"segmentId":"seg_1","createdAt":"2026-01-01T00:00:00Z"},{"segmentId":"seg_2","createdAt":"2026-01-02T00:00:00Z"}]}\
                        """);
                case String p when p.startsWith("/messages/msg_null/content") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"text":null,"html":{"downloadUrl":"https://files.example.com/h","size":null,"expiresAt":"2026-01-01T00:00:00Z"}}}\
                        """);
                case String p when p.equals("/domains") && lastMethod.equals("POST") ->
                    new MockResponse(
                        201,
                        """
                        {"data":{"id":"dns_123","name":"example.com","status":"pending","region":"eu-west-1","createdAt":"2026-01-01T00:00:00Z","statusAt":"2026-01-01T00:00:00Z","sending":true,"receiving":false,"sendingStatus":"enabled","sendingStatusAt":"2026-01-01T00:00:00Z","receivingStatus":"pending","receivingStatusAt":"2026-01-01T00:00:00Z","openTracking":true,"clickTracking":true,"records":[]}}\
                        """);
                default ->
                    new MockResponse(
                        200,
                        """
                        {"data":{}}\
                        """);
              };

          exchange.getResponseHeaders().set("Content-Type", "application/json");
          exchange.getResponseHeaders().set("x-request-id", "req_test_123");
          exchange.sendResponseHeaders(response.status(), response.body().getBytes().length);
          exchange.getResponseBody().write(response.body().getBytes());
          exchange.getResponseBody().close();
        });

    server.start();
  }

  @AfterAll
  static void stopServer() {
    server.stop(0);
  }

  record MockResponse(int status, String body) {}

  Nuntly createClient() {
    return Nuntly.create(
        ClientOptions.builder()
            .apiKey("test_wire_key")
            .baseUrl("http://localhost:" + port)
            .disableRetry()
            .build());
  }

  @Test
  void aNonPaginatedListReadsTheItemsUnderData() {
    var segments = createClient().contacts().segments().list("ct_1");

    assertEquals("GET", lastMethod);
    assertEquals(
        List.of(
            new ContactSegmentsResponseItem("seg_1", "2026-01-01T00:00:00Z"),
            new ContactSegmentsResponseItem("seg_2", "2026-01-02T00:00:00Z")),
        segments);
  }

  @Test
  void sendsAuthorizationHeader() {
    var nuntly = createClient();
    nuntly.emails().retrieve("em_1");
    assertEquals("Bearer test_wire_key", lastAuth);
  }

  @Test
  void sendsUserAgentWithSdkVersionAndRuntime() {
    var nuntly = createClient();
    nuntly.emails().retrieve("em_1");
    assertTrue(
        lastUserAgent.startsWith("@nuntly/sdk-java/" + Version.SDK_VERSION + " "), lastUserAgent);
    assertTrue(lastUserAgent.endsWith("/" + System.getProperty("java.version")), lastUserAgent);
  }

  @Test
  void sendsCorrectHttpMethod() {
    var nuntly = createClient();
    nuntly.emails().retrieve("em_1");
    assertEquals("GET", lastMethod);
  }

  @Test
  void buildsPathCorrectly() {
    var nuntly = createClient();
    nuntly.emails().retrieve("em_abc123");
    assertEquals("/emails/em_abc123", lastPath);
  }

  @Test
  void unwrapsDataEnvelope() {
    var nuntly = createClient();
    var email = nuntly.emails().retrieve("em_1");
    assertEquals("em_123", email.id());
    assertEquals(EmailStatus.DELIVERED, email.status());
  }

  @Test
  void postSerializesBody() {
    var nuntly = createClient();
    var result =
        nuntly
            .emails()
            .send(
                CreateEmailRequest.builder()
                    .from("a@b.com")
                    .to(List.of("c@d.com"))
                    .subject("Test")
                    .build());
    assertEquals("POST", lastMethod);
    assertEquals("/emails", lastPath);
    assertEquals("em_new", result.id());
  }

  @Test
  void throwsNotFoundError() {
    var nuntly = createClient();
    var error =
        assertThrows(ApiError.NotFoundError.class, () -> nuntly.emails().retrieve("em_not_found"));
    assertEquals(404, error.status());
    assertTrue(error.requestId().isPresent());
    assertEquals("req_test_123", error.requestId().get());
  }

  @Test
  void errorHasRawResponse() {
    var nuntly = createClient();
    var error =
        assertThrows(ApiError.NotFoundError.class, () -> nuntly.emails().retrieve("em_not_found"));
    assertNotNull(error.rawResponse());
    assertEquals(404, error.rawResponse().statusCode());
  }

  @Test
  void errorMessageExtractsCanonicalTitle() {
    var nuntly = createClient();
    var error =
        assertThrows(ApiError.NotFoundError.class, () -> nuntly.emails().retrieve("em_not_found"));
    assertTrue(
        error.getMessage().contains("Resource not found"),
        "expected canonical title in message, got: " + error.getMessage());
  }

  @Test
  void errorMessageIgnoresTitleLiteralInsideDetails() {
    var nuntly = createClient();
    var error =
        assertThrows(
            ApiError.NotFoundError.class, () -> nuntly.emails().retrieve("em_title_in_details"));
    // The Gson-based parser must extract the real `error.title`, not the substring after the
    // first occurrence of `"title"` (which lives inside `details`).
    assertTrue(
        error.getMessage().contains("Resource not found"),
        "expected canonical title, got: " + error.getMessage());
    assertFalse(
        error.getMessage().contains("appears inside details"),
        "must not bleed details into message, got: " + error.getMessage());
  }

  @Test
  void createDomainWithBuilder() {
    var nuntly = createClient();
    var domain =
        nuntly
            .domains()
            .create(
                CreateDomainRequest.builder()
                    .name("example.com")
                    .sending(true)
                    .receiving(false)
                    .build());
    assertEquals("POST", lastMethod);
    assertEquals("/domains", lastPath);
    assertEquals("dns_123", domain.id());
  }

  @Test
  void retrieveAgentMemorySendsScopeQuery() {
    var nuntly = createClient();
    nuntly
        .agents()
        .memory()
        .retrieve("agent_1", AgentsMemoryRetrieveParams.builder().inboxId("ibx_1").build());
    assertEquals("/agents/agent_1/memory?inboxId=ibx_1", lastPath);
  }

  @Test
  void retrieveMessageContentRepeatsFormatKey() {
    var nuntly = createClient();
    nuntly
        .messages()
        .content()
        .retrieve(
            "msg_1",
            MessagesContentRetrieveParams.builder()
                .format(List.of(MessageContentQueryFormat.HTML, MessageContentQueryFormat.TEXT))
                .build());
    assertEquals("/messages/msg_1/content?format=html&format=text", lastPath);
  }

  @Test
  void retrieveThreadSendsMarkRead() {
    var nuntly = createClient();
    nuntly.threads().retrieve("thr_1", ThreadsRetrieveParams.builder().markRead(true).build());
    assertEquals("/threads/thr_1?markRead=true", lastPath);
    nuntly.threads().retrieve("thr_1", ThreadsRetrieveParams.builder().markRead(false).build());
    assertEquals("/threads/thr_1?markRead=false", lastPath);
  }

  @Test
  void renamedOptionalComponentReadsAsEmptyWhenAbsent() {
    var nuntly = createClient();
    var version = nuntly.templates().versions().retrieve("tpl_1", "tpv_1");
    assertEquals(Optional.empty(), version.variables().get(0).defaultValue());
    assertEquals(Optional.of("free"), version.variables().get(1).defaultValue());
  }

  @Test
  void nullInNullableRequiredFieldReadsAsEmpty() {
    var nuntly = createClient();
    var page = nuntly.broadcasts().recipients().list("bc_1");
    assertEquals(Optional.empty(), page.data().get(0).contactId());
  }

  @Test
  void nullContentSizeParsesAsEmpty() {
    var nuntly = createClient();
    var content = nuntly.messages().content().retrieve("msg_null");
    assertEquals(Optional.empty(), content.text());
    assertEquals(Optional.empty(), content.html().orElseThrow().size());
    assertEquals(Optional.empty(), content.mime());
  }

  @Test
  void templateContentIsTypedByStatus() {
    var nuntly = createClient();
    var content = nuntly.templates().versions().content().retrieve("tpl_1", "tpv_1");
    var html = assertInstanceOf(ContentOutcome.Available.class, content.html());
    assertEquals("https://files.example.com/h", html.downloadUrl());
    assertInstanceOf(ContentOutcome.Absent.class, content.text());
  }

  @Test
  void unknownContentStatusParsesAsUnknown() {
    var nuntly = createClient();
    var content = nuntly.templates().versions().content().retrieve("tpl_2", "tpv_2");
    assertEquals(new ContentOutcome.Unknown("expired"), content.html());
    assertInstanceOf(ContentOutcome.Unavailable.class, content.text());
  }

  @Test
  void nullableLiteralUnionIsAnEnum() {
    var nuntly = createClient();
    assertEquals(
        Optional.of(WebhookDisabledReason.AUTO_CONSECUTIVE_FAILURES),
        nuntly.webhooks().retrieve("wh_disabled").disabledReason());
    assertEquals(Optional.empty(), nuntly.webhooks().retrieve("wh_enabled").disabledReason());
  }

  @Test
  void listOfInlineObjectsIsTyped() {
    var nuntly = createClient();
    var record = nuntly.domains().retrieve("dns_records").records().get(0);
    assertEquals(DnsRecordType.CNAME, record.recordType());
    assertEquals(DnsRecordGroup.DKIM, record.group());
    assertEquals(Optional.of("nuntly"), record.selector());
    assertEquals(Optional.empty(), record.priority());
  }

  @Test
  void bulkEmailItemsAreTyped() {
    var nuntly = createClient();
    var emails = nuntly.emails().bulk().retrieve("blk_1").emails();
    assertEquals(EmailStatus.QUEUED, emails.get(0).status());
    assertEquals(Optional.empty(), emails.get(0).detail());
    assertEquals(Optional.of("Invalid recipient"), emails.get(1).detail());
  }

  @Test
  void organizationUsageIsTyped() {
    var nuntly = createClient();
    var email = nuntly.organizations().usage().retrieve("org_1").email();
    assertEquals(12, email.daily().used());
    assertEquals(Optional.empty(), email.daily().limit());
    assertEquals(1, email.daily().breakdown().broadcast().sent());
    assertEquals(Optional.of(3000L), email.monthly().limit());
    assertEquals(Optional.empty(), email.monthly().resetsAt());
  }

  @Test
  void clearedPatchFieldIsSentAsNullAndUntouchedFieldsStayAbsent() {
    var nuntly = createClient();
    nuntly
        .broadcasts()
        .update(
            "bc_1",
            UpdateBroadcastRequest.builder().clearTemplateId().subject("Spring sale").build());
    assertEquals("PATCH", lastMethod);
    assertEquals("{\"templateId\":null,\"subject\":\"Spring sale\"}", lastBody);
  }

  @Test
  void nullSetterLeavesTheFieldUnchanged() {
    var nuntly = createClient();
    nuntly.broadcasts().update("bc_1", UpdateBroadcastRequest.builder().topicId(null).build());
    assertEquals("{}", lastBody);
  }

  @Test
  void clearedPropertyDefaultIsSentAsNull() {
    var nuntly = createClient();
    nuntly
        .contactProperties()
        .update("cpd_1", UpdateContactPropertyRequest.builder().clearDefaultValue().build());
    assertEquals("{\"defaultValue\":null}", lastBody);
  }

  @Test
  void nullContactPropertyValueIsSent() {
    var nuntly = createClient();
    var properties = new HashMap<String, Object>();
    properties.put("plan", null);
    properties.put("seats", 5);
    nuntly.contacts().update("ct_1", UpdateContactRequest.builder().properties(properties).build());
    assertTrue(lastBody.contains("\"plan\":null"), lastBody);
    assertTrue(lastBody.contains("\"seats\":5"), lastBody);
  }

  @Test
  void nullAgentMemoryValueIsSent() {
    var nuntly = createClient();
    var memory = new HashMap<String, Object>();
    memory.put("lastReply", null);
    nuntly.agents().memory().upsert("agent_1", AgentMemoryRequest.builder().memory(memory).build());
    assertEquals("{\"memory\":{\"lastReply\":null}}", lastBody);
  }

  @Test
  void nullHeaderValueIsDropped() {
    var nuntly = createClient();
    var headers = new HashMap<String, String>();
    headers.put("X-Campaign", null);
    headers.put("X-Entity-Ref-ID", "order-1042");
    nuntly
        .emails()
        .send(
            CreateEmailRequest.builder()
                .from("billing@acme.com")
                .to(List.of("jane@example.com"))
                .subject("Your invoice")
                .headers(headers)
                .build());
    assertTrue(lastBody.contains("\"headers\":{\"X-Entity-Ref-ID\":\"order-1042\"}"), lastBody);
  }

  @Test
  void nullEmailVariableIsSent() {
    var nuntly = createClient();
    var variables = new HashMap<String, Object>();
    variables.put("middleName", null);
    variables.put("firstName", "Jane");
    nuntly
        .emails()
        .send(
            CreateEmailRequest.builder()
                .from("billing@acme.com")
                .to(List.of("jane@example.com"))
                .subject("Your invoice")
                .variables(variables)
                .build());
    assertTrue(lastBody.contains("\"middleName\":null"), lastBody);
    assertTrue(lastBody.contains("\"firstName\":\"Jane\""), lastBody);
  }

  @Test
  void nullBulkEmailAndFallbackVariablesAreSent() {
    var nuntly = createClient();
    var emailVariables = new HashMap<String, Object>();
    emailVariables.put("middleName", null);
    var fallbackVariables = new HashMap<String, Object>();
    fallbackVariables.put("coupon", null);
    var email =
        CreateBulkEmail.builder().to(List.of("jane@example.com")).variables(emailVariables).build();
    var fallback =
        CreateBulkFallback.builder()
            .from("billing@acme.com")
            .subject("Your invoice")
            .variables(fallbackVariables)
            .build();
    nuntly
        .emails()
        .bulk()
        .send(CreateBulkEmailsRequest.builder().fallback(fallback).emails(List.of(email)).build());
    assertTrue(lastBody.contains("\"middleName\":null"), lastBody);
    assertTrue(lastBody.contains("\"coupon\":null"), lastBody);
  }

  @Test
  void nullBroadcastVariableIsDropped() {
    var nuntly = createClient();
    var variables = new HashMap<String, Object>();
    variables.put("coupon", null);
    variables.put("season", "spring");
    nuntly
        .broadcasts()
        .create(
            CreateBroadcastRequest.builder()
                .from("news@acme.com")
                .templateId("tpl_1")
                .segmentId("seg_1")
                .variables(variables)
                .build());
    assertTrue(lastBody.contains("\"variables\":{\"season\":\"spring\"}"), lastBody);
  }

  @Test
  void nullBroadcastUpdateVariableIsDropped() {
    var nuntly = createClient();
    var variables = new HashMap<String, Object>();
    variables.put("coupon", null);
    nuntly
        .broadcasts()
        .update("bc_1", UpdateBroadcastRequest.builder().variables(variables).build());
    assertEquals("{\"variables\":{}}", lastBody);
  }

  @Test
  void listParamsAreSentAsQuery() {
    var nuntly = createClient();
    nuntly
        .broadcasts()
        .recipients()
        .list("bc_1", BroadcastsRecipientsListParams.builder().limit(20).cursor("cur_1").build());
    assertTrue(lastPath.startsWith("/broadcasts/bc_1/recipients?"), lastPath);
    assertTrue(lastPath.contains("limit=20"), lastPath);
    assertTrue(lastPath.contains("cursor=cur_1"), lastPath);
  }

  @Test
  void listWithoutParamsSendsNoQuery() {
    var nuntly = createClient();
    nuntly.broadcasts().recipients().list("bc_1");
    assertEquals("/broadcasts/bc_1/recipients", lastPath);
  }

  @Test
  void sendBroadcastWithoutBody() {
    var nuntly = createClient();
    nuntly.broadcasts().send("bc_1");
    assertEquals("POST", lastMethod);
    assertEquals("/broadcasts/bc_1/send", lastPath);
  }

  @Test
  void pathOnlyOverloadSendsNoQuery() {
    var nuntly = createClient();
    nuntly.messages().content().retrieve("msg_1");
    assertEquals("/messages/msg_1/content", lastPath);
  }
}
