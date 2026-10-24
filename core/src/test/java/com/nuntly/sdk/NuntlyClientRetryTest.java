package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
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
  void retriesAKeyedPostOn503WithTheSameKey() throws IOException {
    var nuntly = serve(call -> new Reply(call == 1 ? 503 : 202, Map.of()));

    nuntly.post("/emails", Map.of(), Object.class, withKey("send-2026-10-21"));
    assertEquals(List.of("send-2026-10-21", "send-2026-10-21"), idempotencyKeys);
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
}
