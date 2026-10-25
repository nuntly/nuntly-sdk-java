package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class NuntlyClientRetryTest {

  private static final BackoffStrategy FAST = new BackoffStrategy(1, 1, 1.0);

  private HttpServer server;
  private ServerSocket socket;
  private final List<String> idempotencyKeys = new CopyOnWriteArrayList<>();

  @AfterEach
  void stop() throws IOException {
    if (server != null) server.stop(0);
    if (socket != null) socket.close();
  }

  private record Reply(int status, Map<String, String> headers) {}

  private NuntlyClient serve(IntFunction<Reply> replyForCall) throws IOException {
    return serve(replyForCall, Hooks.builder().onRetry(ctx -> retries.incrementAndGet()).build());
  }

  private NuntlyClient serve(IntFunction<Reply> replyForCall, Hooks hooks) throws IOException {
    var calls = new AtomicInteger();
    server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    server.createContext(
        "/",
        exchange -> {
          exchange.getRequestBody().readAllBytes();
          idempotencyKeys.add(
              Optional.ofNullable(exchange.getRequestHeaders().getFirst("Idempotency-Key"))
                  .orElse(""));
          var reply = replyForCall.apply(calls.incrementAndGet());
          reply.headers().forEach((k, v) -> exchange.getResponseHeaders().add(k, v));
          var body = "{\"data\":{\"id\":\"em_1\"}}".getBytes();
          exchange.sendResponseHeaders(reply.status(), body.length);
          exchange.getResponseBody().write(body);
          exchange.close();
        });
    server.start();
    return client("http://127.0.0.1:" + server.getAddress().getPort(), hooks);
  }

  private final AtomicInteger retries = new AtomicInteger();

  private NuntlyClient client(String baseUrl) {
    return client(baseUrl, Hooks.builder().onRetry(ctx -> retries.incrementAndGet()).build());
  }

  private NuntlyClient client(String baseUrl, Hooks hooks) {
    return new NuntlyClient(
        ClientOptions.builder()
            .apiKey("test_key")
            .baseUrl(baseUrl)
            .timeout(Duration.ofSeconds(2))
            .backoff(FAST)
            .hooks(hooks)
            .build());
  }

  private static RequestOptions withKey(String key) {
    return RequestOptions.builder().headers(Map.of("Idempotency-Key", key)).build();
  }

  @Test
  void neverRetriesA409() throws IOException {
    var nuntly = serve(call -> new Reply(409, Map.of()));

    assertThrows(
        ApiError.ConflictError.class,
        () -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
    assertEquals(1, idempotencyKeys.size());
  }

  @Test
  void doesNotRetryAnUnkeyedPostOn503() throws IOException {
    var nuntly = serve(call -> new Reply(503, Map.of()));

    assertThrows(
        ApiError.InternalServerError.class,
        () -> nuntly.post("/domains", Map.of(), Object.class, RequestOptions.none()));
    assertEquals(1, idempotencyKeys.size());
  }

  @Test
  void retriesAnUnkeyedPostOn429() throws IOException {
    var nuntly = serve(call -> new Reply(call == 1 ? 429 : 201, Map.of()));

    nuntly.post("/domains", Map.of(), Object.class, RequestOptions.none());
    assertEquals(2, idempotencyKeys.size());
  }

  @Test
  void retriesAKeyedIdempotentPostOn503WithTheSameKey() throws IOException {
    var nuntly = serve(call -> new Reply(call == 1 ? 503 : 202, Map.of()));

    nuntly.postIdempotent(
        "/emails",
        Map.of(),
        Object.class,
        IdempotentRequestOptions.builder().idempotencyKey("send-2026-10-21").build());
    assertEquals(List.of("send-2026-10-21", "send-2026-10-21"), idempotencyKeys);
  }

  @Test
  void doesNotRetryAPostOn503ForACallerKeyHeaderAlone() throws IOException {
    var nuntly = serve(call -> new Reply(503, Map.of()));

    assertThrows(
        ApiError.InternalServerError.class,
        () -> nuntly.post("/domains", Map.of(), Object.class, withKey("domain-2026-10-25")));
    assertEquals(1, idempotencyKeys.size());
  }

  @Test
  void sendsTheKeyOfIdempotentOptionsOrAGeneratedOne() throws IOException {
    var nuntly = serve(call -> new Reply(202, Map.of()));

    nuntly.postIdempotent(
        "/emails",
        Map.of(),
        Object.class,
        IdempotentRequestOptions.builder().idempotencyKey("send-2026-10-25").build());
    nuntly.postIdempotent("/emails", Map.of(), Object.class, IdempotentRequestOptions.none());
    assertEquals("send-2026-10-25", idempotencyKeys.get(0));
    assertEquals(36, idempotencyKeys.get(1).length());
  }

  @Test
  void doesNotRetryAnUnkeyedPatchOn503() throws IOException {
    var nuntly = serve(call -> new Reply(503, Map.of()));

    assertThrows(
        ApiError.InternalServerError.class,
        () -> nuntly.patch("/domains/dns_1", Map.of(), Object.class, RequestOptions.none()));
    assertEquals(1, idempotencyKeys.size());
  }

  @Test
  void doesNotRetryAKeyedPatchOn503() throws IOException {
    var nuntly = serve(call -> new Reply(503, Map.of()));

    assertThrows(
        ApiError.InternalServerError.class,
        () -> nuntly.patch("/domains/dns_1", Map.of(), Object.class, withKey("patch-2026-10-24")));
    assertEquals(1, idempotencyKeys.size());
  }

  @Test
  void retriesAnUnkeyedPutAndDeleteOn503() throws IOException {
    var nuntly = serve(call -> new Reply(call % 2 == 1 ? 503 : 200, Map.of()));

    nuntly.put("/domains/dns_1", Map.of(), Object.class, RequestOptions.none());
    nuntly.delete("/domains/dns_1", Object.class, RequestOptions.none());
    assertEquals(4, idempotencyKeys.size());
  }

  @Test
  void aThrowingOnErrorHookKeepsTheOriginalApiError() throws IOException {
    var hookFailure = new IllegalStateException("hook failed");
    var nuntly =
        serve(
            call -> new Reply(404, Map.of()),
            Hooks.builder()
                .onError(
                    (error, req) -> {
                      throw hookFailure;
                    })
                .build());

    var error =
        assertThrows(
            ApiError.NotFoundError.class,
            () -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
    assertEquals(List.of(hookFailure), List.of(error.getSuppressed()));
  }

  @Test
  void aThrowingOnErrorHookKeepsTheOriginalConnectionError() throws IOException {
    var hookFailure = new IllegalStateException("hook failed");
    var nuntly =
        dropConnections(
            new AtomicInteger(),
            Hooks.builder()
                .onError(
                    (error, req) -> {
                      throw hookFailure;
                    })
                .build());

    var error =
        assertThrows(
            ConnectionError.class,
            () -> nuntly.post("/domains", Map.of(), Object.class, RequestOptions.none()));
    assertEquals(List.of(hookFailure), List.of(error.getSuppressed()));
  }

  @Test
  void anOnErrorHookThatRethrowsTheErrorThrowsItUnchanged() throws IOException {
    var nuntly =
        serve(
            call -> new Reply(404, Map.of()),
            Hooks.builder()
                .onError(
                    (error, req) -> {
                      throw (RuntimeException) error;
                    })
                .build());

    var error =
        assertThrows(
            ApiError.NotFoundError.class,
            () -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
    assertEquals(0, error.getSuppressed().length);
  }

  @Test
  void aVirtualMachineErrorFromTheOnErrorHookIsNotSwallowed() throws IOException {
    var nuntly =
        serve(
            call -> new Reply(404, Map.of()),
            Hooks.builder()
                .onError(
                    (error, req) -> {
                      throw new StackOverflowError("hook overflow");
                    })
                .build());

    var fatal =
        assertThrows(
            StackOverflowError.class,
            () -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
    // Rethrown untouched: HotSpot can share one preallocated instance of such an error.
    assertEquals(0, fatal.getSuppressed().length);
  }

  @Test
  void anOnErrorHookThatThrowsAnErrorKeepsTheOriginalError() throws IOException {
    var hookFailure = new AssertionError("hook assertion");
    var nuntly =
        serve(
            call -> new Reply(404, Map.of()),
            Hooks.builder()
                .onError(
                    (error, req) -> {
                      throw hookFailure;
                    })
                .build());

    var error =
        assertThrows(
            ApiError.NotFoundError.class,
            () -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
    assertEquals(List.of(hookFailure), List.of(error.getSuppressed()));
  }

  // Accepts each connection and closes it before any response, so the client gets an IOException.
  private NuntlyClient dropConnections(AtomicInteger accepted) throws IOException {
    return dropConnections(
        accepted, Hooks.builder().onRetry(ctx -> retries.incrementAndGet()).build());
  }

  private NuntlyClient dropConnections(AtomicInteger accepted, Hooks hooks) throws IOException {
    socket = new ServerSocket(0);
    var acceptor =
        new Thread(
            () -> {
              while (!socket.isClosed()) {
                try (var conn = socket.accept()) {
                  accepted.incrementAndGet();
                } catch (IOException ignored) {
                  return;
                }
              }
            });
    acceptor.setDaemon(true);
    acceptor.start();
    return client("http://127.0.0.1:" + socket.getLocalPort(), hooks);
  }

  @Test
  void doesNotRetryAnIoExceptionOnAnUnkeyedPost() throws IOException {
    var accepted = new AtomicInteger();
    var nuntly = dropConnections(accepted);

    assertThrows(
        ConnectionError.class,
        () -> nuntly.post("/domains", Map.of(), Object.class, RequestOptions.none()));
    assertEquals(1, accepted.get());
    assertEquals(0, retries.get());
  }

  // Even a refused connection is not replayed for an unkeyed POST, as in TypeScript.
  @Test
  void doesNotRetryAConnectExceptionOnAnUnkeyedPost() throws IOException {
    int port;
    try (var closed = new ServerSocket(0)) {
      port = closed.getLocalPort();
    }
    var nuntly = client("http://127.0.0.1:" + port);

    var error =
        assertThrows(
            ConnectionError.class,
            () -> nuntly.post("/domains", Map.of(), Object.class, RequestOptions.none()));
    assertTrue(error.getCause() instanceof ConnectException, "cause was " + error.getCause());
    assertEquals(0, retries.get());
  }

  // The JDK client also replays a GET once on its own, so count the SDK retries, not connections.
  @Test
  void retriesAnIoExceptionOnAGet() throws IOException {
    var nuntly = dropConnections(new AtomicInteger());

    assertThrows(
        ConnectionError.class,
        () -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
    assertEquals(2, retries.get());
  }

  @Test
  void anInterruptDuringARequestIsAConnectionErrorNotATimeout() throws IOException {
    var nuntly = serve(call -> new Reply(200, Map.of()));
    Thread.currentThread().interrupt();

    assertInterrupted(() -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
  }

  @Test
  void anInterruptDuringTheRetryWaitIsAConnectionErrorNotATimeout() throws IOException {
    var nuntly =
        serve(
            call -> new Reply(503, Map.of()),
            Hooks.builder().onRetry(ctx -> Thread.currentThread().interrupt()).build());

    assertInterrupted(() -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
  }

  @Test
  void anInterruptDuringTheWaitAfterAnIoExceptionIsAConnectionError() throws IOException {
    var nuntly =
        dropConnections(
            new AtomicInteger(),
            Hooks.builder().onRetry(ctx -> Thread.currentThread().interrupt()).build());

    assertInterrupted(() -> nuntly.get("/emails/em_1", Object.class, RequestOptions.none()));
  }

  // Clears the interrupt flag even on a failed assertion, so it cannot leak into later tests.
  private static void assertInterrupted(Executable call) {
    try {
      var error = assertThrows(ConnectionError.class, call);
      assertFalse(error instanceof ConnectionError.TimeoutError);
      assertEquals("Request interrupted", error.getMessage());
      assertTrue(error.getCause() instanceof InterruptedException);
      assertTrue(Thread.currentThread().isInterrupted(), "the interrupt flag is restored");
    } finally {
      Thread.interrupted();
    }
  }

  @Test
  void honorsRetryAfterInSeconds() {
    assertEquals(2000, NuntlyClient.computeRetryDelay(0, Optional.of("2"), FAST));
  }

  @Test
  void honorsRetryAfterAsAnHttpDate() {
    var date = ZonedDateTime.now().plusSeconds(30).format(DateTimeFormatter.RFC_1123_DATE_TIME);
    var delay = NuntlyClient.computeRetryDelay(0, Optional.of(date), FAST);
    assertTrue(delay > 25_000 && delay <= 30_000, "delay was " + delay);
  }

  @Test
  void jitterOnlyShortensTheBackoff() {
    var backoff = new BackoffStrategy(1000, 8000, 2.0);
    for (int i = 0; i < 100; i++) {
      var delay = NuntlyClient.computeRetryDelay(1, Optional.empty(), backoff);
      assertTrue(delay >= 1500 && delay <= 2000, "delay was " + delay);
    }
  }

  @Test
  void honorsXShouldRetryWhateverItsCase() throws IOException {
    var nuntly = serve(call -> new Reply(call == 1 ? 400 : 200, Map.of("X-Should-Retry", "TRUE")));
    nuntly.get("/emails/em_1", Object.class, RequestOptions.none());
    assertEquals(1, retries.get());

    stop();
    var refused = serve(call -> new Reply(503, Map.of("X-Should-Retry", "False")));
    assertThrows(
        ApiError.InternalServerError.class,
        () -> refused.get("/emails/em_1", Object.class, RequestOptions.none()));
    assertEquals(1, retries.get());
  }
}
