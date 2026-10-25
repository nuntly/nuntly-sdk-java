package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class ResourceTest {

  @Test
  void pathParamEncodesASegmentThatWouldReachAnotherRoute() {
    assertEquals("x%2F..%2F..%2Fsegments", Resource.pathParam("contactId", "x/../../segments"));
    assertEquals("a%3Fb%23c", Resource.pathParam("contactId", "a?b#c"));
  }

  @Test
  void pathParamEncodesASpaceAndAPercentLikeEncodeUriComponent() {
    assertEquals("a%20b%25c", Resource.pathParam("contactId", "a b%c"));
  }

  @Test
  void pathParamKeepsAnIdUnchanged() {
    assertEquals("ct_01m5dfzmcy", Resource.pathParam("contactId", "ct_01m5dfzmcy"));
  }

  @Test
  void pathParamRejectsADotSegment() {
    assertThrows(NuntlyError.class, () -> Resource.pathParam("contactId", ".."));
  }

  @Test
  void withIdempotencyKeyGeneratesAUuidKeyWhenNoneIsSet() {
    var opts = Resource.withIdempotencyKey(IdempotentRequestOptions.none());

    var key = opts.headers().get("Idempotency-Key");
    assertEquals(key, UUID.fromString(key).toString());
    assertEquals(Optional.of(key), opts.idempotencyKey());
  }

  @Test
  void withIdempotencyKeySendsTheCallerKeyAndKeepsTheOtherOptions() {
    var opts =
        Resource.withIdempotencyKey(
            IdempotentRequestOptions.builder()
                .idempotencyKey("send-2026-10-21")
                .maxRetries(5)
                .headers(Map.of("X-Trace", "t1"))
                .build());

    assertEquals(Map.of("Idempotency-Key", "send-2026-10-21", "X-Trace", "t1"), opts.headers());
    assertEquals(Optional.of(5), opts.maxRetries());
  }

  @Test
  void withIdempotencyKeyKeepsAKeyHeaderTheCallerSet() {
    var opts =
        Resource.withIdempotencyKey(
            IdempotentRequestOptions.builder()
                .headers(Map.of("Idempotency-Key", "from-header"))
                .build());

    assertEquals("from-header", opts.headers().get("Idempotency-Key"));
    assertEquals(Optional.of("from-header"), opts.idempotencyKey());
  }

  @Test
  void withIdempotencyKeyTreatsANullKeyHeaderAsAbsent() {
    var callerHeaders = new HashMap<String, String>();
    callerHeaders.put("idempotency-key", null);
    callerHeaders.put("X-Trace", "t1");

    var opts =
        Resource.withIdempotencyKey(
            IdempotentRequestOptions.builder().headers(callerHeaders).build());

    var key = opts.headers().get("Idempotency-Key");
    assertEquals(key, UUID.fromString(key).toString());
    assertEquals(Map.of("Idempotency-Key", key, "X-Trace", "t1"), opts.headers());
    assertEquals(Optional.of(key), opts.idempotencyKey());
  }

  @Test
  void withIdempotencyKeySendsOneKeyHeaderWhenTheCallerSetSeveralCases() {
    var withNull = new HashMap<String, String>();
    withNull.put("Idempotency-Key", "send-2026-10-25");
    withNull.put("idempotency-key", null);
    var opts =
        Resource.withIdempotencyKey(IdempotentRequestOptions.builder().headers(withNull).build());
    assertEquals(Map.of("Idempotency-Key", "send-2026-10-25"), opts.headers());
    assertEquals(Optional.of("send-2026-10-25"), opts.idempotencyKey());

    // The exact spelling wins over another case variant, whatever the map order.
    for (var exactFirst : List.of(true, false)) {
      var headers = new LinkedHashMap<String, String>();
      if (exactFirst) headers.put("Idempotency-Key", "exact");
      headers.put("IDEMPOTENCY-KEY", "variant");
      if (!exactFirst) headers.put("Idempotency-Key", "exact");

      var twoValues =
          Resource.withIdempotencyKey(IdempotentRequestOptions.builder().headers(headers).build());

      assertEquals(Map.of("Idempotency-Key", "exact"), twoValues.headers());
      assertEquals(Optional.of("exact"), twoValues.idempotencyKey());
    }
  }

  @Test
  void withIdempotencyKeyMatchesTheCallerHeaderWhateverItsCase() {
    var opts =
        Resource.withIdempotencyKey(
            IdempotentRequestOptions.builder()
                .idempotencyKey("from-option")
                .headers(Map.of("idempotency-key", "from-header"))
                .build());

    assertEquals(Map.of("idempotency-key", "from-header"), opts.headers());
    assertEquals(Optional.of("from-header"), opts.idempotencyKey());
  }
}
