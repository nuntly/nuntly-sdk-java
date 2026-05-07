package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.nuntly.sdk.models.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class SdkTest {

  @Test
  void createEmailRequestBuilder() {
    var req =
        CreateEmailRequest.builder()
            .from("hello@nuntly.com")
            .to(List.of("user@example.com"))
            .subject("Welcome")
            .html("<h1>Hi</h1>")
            .build();

    assertEquals("hello@nuntly.com", req.from());
    assertEquals(List.of("user@example.com"), req.to());
    assertEquals("Welcome", req.subject());
    assertEquals(Optional.of("<h1>Hi</h1>"), req.html());
    assertEquals(Optional.empty(), req.cc());
  }

  @Test
  void createDomainRequestBuilder() {
    var req =
        CreateDomainRequest.builder().name("example.com").sending(true).receiving(false).build();

    assertEquals("example.com", req.name());
    assertEquals(java.util.Optional.of(true), req.sending());
    assertEquals(java.util.Optional.of(false), req.receiving());
  }

  @Test
  void clientOptionsDefaults() {
    var opts = ClientOptions.builder().apiKey("test_key").build();

    assertEquals("test_key", opts.apiKey());
    assertEquals("https://api.nuntly.com", opts.baseUrl());
    assertEquals(60, opts.timeout().getSeconds());
    assertEquals(2, opts.maxRetries());
    assertFalse(opts.debug());
  }

  @Test
  void clientOptionsCustom() {
    var opts =
        ClientOptions.builder()
            .apiKey("test_key")
            .baseUrl("https://custom.api.com")
            .maxRetries(5)
            .debug(true)
            .backoff(
                BackoffStrategy.builder()
                    .initialIntervalMs(100)
                    .maxIntervalMs(5000)
                    .exponent(1.5)
                    .build())
            .build();

    assertEquals("https://custom.api.com", opts.baseUrl());
    assertEquals(5, opts.maxRetries());
    assertTrue(opts.debug());
    assertEquals(100, opts.backoff().initialIntervalMs());
  }

  @Test
  void clientOptionsRequiresApiKey() {
    assertThrows(IllegalArgumentException.class, () -> ClientOptions.builder().build());
  }

  @Test
  void clientOptionsDisableRetry() {
    var opts = ClientOptions.builder().apiKey("test_key").disableRetry().build();

    assertFalse(opts.retryEnabled());
  }

  @Test
  void requestOptionsNone() {
    var opts = RequestOptions.none();
    assertTrue(opts.timeout().isEmpty());
    assertTrue(opts.maxRetries().isEmpty());
    assertTrue(opts.headers().isEmpty());
  }

  @Test
  void requestOptionsBuilder() {
    var opts =
        RequestOptions.builder()
            .maxRetries(0)
            .headers(java.util.Map.of("X-Custom", "value"))
            .build();

    assertEquals(Optional.of(0), opts.maxRetries());
    assertEquals("value", opts.headers().get("X-Custom"));
  }

  @Test
  void backoffStrategyDefaults() {
    var b = BackoffStrategy.DEFAULT;
    assertEquals(500, b.initialIntervalMs());
    assertEquals(8000, b.maxIntervalMs());
    assertEquals(2.0, b.exponent());
  }

  @Test
  void hooksBuilderNone() {
    var hooks = Hooks.NONE;
    assertNull(hooks.onRequest());
    assertNull(hooks.onResponse());
    assertNull(hooks.onError());
  }

  @Test
  void cursorPageIteration() {
    var page =
        new CursorPage<>(
            List.of("a", "b", "c"), null, cursor -> new CursorPage<>(List.of(), null, c -> null));

    assertEquals(3, page.data().size());
    assertFalse(page.hasNextPage());

    var items = new java.util.ArrayList<String>();
    for (var item : page) items.add(item);
    assertEquals(List.of("a", "b", "c"), items);
  }

  @Test
  void cursorPageStream() {
    var page =
        new CursorPage<>(
            List.of("x", "y"), null, cursor -> new CursorPage<>(List.of(), null, c -> null));

    var count = page.stream().count();
    assertEquals(2, count);
  }

  @Test
  void emailResponseRecord() {
    var resp =
        new EmailResponse(
            "em_1",
            "org_1",
            Optional.empty(),
            Optional.empty(),
            "a@b.com",
            List.of("c@d.com"),
            Optional.empty(),
            Optional.empty(),
            "delivered",
            Optional.empty(),
            "Hello",
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            "2026-01-01T00:00:00Z");

    assertEquals("em_1", resp.id());
    assertEquals("delivered", resp.status());
    assertEquals("Hello", resp.subject());
  }

  @Test
  void nuntlyCreateWithOptions() {
    var nuntly = Nuntly.create(ClientOptions.builder().apiKey("test_key").build());

    assertNotNull(nuntly.emails());
    assertNotNull(nuntly.domains());
    assertNotNull(nuntly.webhooks());
    // Lazy: same instance
    assertSame(nuntly.emails(), nuntly.emails());
  }
}
