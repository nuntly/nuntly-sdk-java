package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.nuntly.sdk.models.*;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import org.junit.jupiter.api.*;

class WireTest {

  static HttpServer server;
  static int port;
  static String lastMethod;
  static String lastPath;
  static String lastAuth;

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

          var response =
              switch (lastPath) {
                case String p when p.startsWith("/emails/em_not_found") ->
                    new MockResponse(
                        404,
                        """
                        {"message":"Not found","code":"RESOURCE_NOT_FOUND"}\
                        """);
                case String p when p.equals("/emails") && lastMethod.equals("POST") ->
                    new MockResponse(
                        201,
                        """
                        {"data":{"id":"em_new","status":"queued"}}\
                        """);
                case String p when p.startsWith("/emails/") && lastMethod.equals("GET") ->
                    new MockResponse(
                        200,
                        """
                        {"data":{"id":"em_123","orgId":"org_1","from":"a@b.com","to":["c@d.com"],"status":"delivered","subject":"Test","createdAt":"2026-01-01T00:00:00Z"}}\
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
  void sendsAuthorizationHeader() {
    var nuntly = createClient();
    nuntly.emails().retrieve("em_1");
    assertEquals("Bearer test_wire_key", lastAuth);
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
    assertEquals("delivered", email.status());
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
}
