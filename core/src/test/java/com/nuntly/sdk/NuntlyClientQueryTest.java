package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class NuntlyClientQueryTest {

  private enum Format {
    @SerializedName("html")
    HTML,
    @SerializedName("text")
    TEXT
  }

  @JsonAdapter(OpenEnumTypeAdapterFactory.class)
  private enum Status {
    @SerializedName("on")
    ON,
    UNKNOWN
  }

  private ConformanceTest.ScriptedHttpClient http;

  private NuntlyClient serve(String... bodies) {
    http =
        new ConformanceTest.ScriptedHttpClient(
            Arrays.stream(bodies)
                .map(b -> JsonParser.parseString("{\"status\":200,\"body\":" + b + "}"))
                .map(e -> e.getAsJsonObject())
                .toList());
    return new NuntlyClient(
        ClientOptions.builder()
            .apiKey("test_key")
            .baseUrl("https://api.test.com")
            .disableRetry()
            .build(),
        http,
        ms -> {});
  }

  private String sentQuery(int call) {
    return http.requests.get(call).uri().getRawQuery();
  }

  @Test
  void aNullQueryParamIsNotSent() {
    var nuntly = serve("{\"data\":{}}");
    var query = new HashMap<String, Object>();
    query.put("cursor", null);
    query.put("limit", 20);

    nuntly.get("/emails", JsonObject.class, query, RequestOptions.none());

    assertEquals("limit=20", sentQuery(0));
  }

  @Test
  void aQueryOfNullParamsSendsNoQueryString() {
    var nuntly = serve("{\"data\":{}}");
    var query = new HashMap<String, Object>();
    query.put("cursor", null);

    nuntly.get("/emails", JsonObject.class, query, RequestOptions.none());

    assertEquals("https://api.test.com/emails", http.requests.get(0).uri().toString());
  }

  @Test
  void listSendsTypedParamsLikeGetAndReplaysThemWithTheCursor() {
    var nuntly =
        serve(
            "{\"data\":[{\"id\":\"em_1\"}],\"nextCursor\":\"cur_2\"}",
            "{\"data\":[{\"id\":\"em_2\"}],\"nextCursor\":null}");
    Map<String, Object> query = Map.of("limit", 1, "format", List.of(Format.HTML, Format.TEXT));

    var ids =
        nuntly.list("/messages", JsonObject.class, query, RequestOptions.none()).stream()
            .map(item -> item.get("id").getAsString())
            .toList();

    assertEquals(List.of("em_1", "em_2"), ids);
    assertEquals(
        List.of("format=html", "format=text", "limit=1"),
        Arrays.stream(sentQuery(0).split("&")).sorted().toList());
    assertEquals(
        List.of("cursor=cur_2", "format=html", "format=text", "limit=1"),
        Arrays.stream(sentQuery(1).split("&")).sorted().toList());
  }

  @Test
  void anUnknownEnumQueryValueFailsBeforeSending() {
    var nuntly = serve("{\"data\":{}}");

    for (Object value : List.of(Status.UNKNOWN, List.of(Status.ON, Status.UNKNOWN))) {
      var error =
          assertThrows(
              NuntlyError.class,
              () ->
                  nuntly.get(
                      "/emails", JsonObject.class, Map.of("status", value), RequestOptions.none()));
      assertEquals(
          "Query param 'status' cannot send Status.UNKNOWN, a value read from the API.",
          error.getMessage());
    }
    assertEquals(0, http.requests.size());
  }

  @Test
  void aNullElementInAQueryListFailsBeforeSending() {
    var nuntly = serve("{\"data\":{}}");

    var error =
        assertThrows(
            NuntlyError.class,
            () ->
                nuntly.get(
                    "/emails",
                    JsonObject.class,
                    Map.of("format", Arrays.asList("html", null)),
                    RequestOptions.none()));
    assertEquals("Query param 'format' must not contain null.", error.getMessage());
    assertEquals(0, http.requests.size());
  }
}
