package com.nuntly.sdk;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import javax.net.ssl.SSLSession;

/**
 * A response whose {@link #request()} carries no API key: hooks, errors and {@code rawRequest}
 * callers get this one, never the response the HTTP client returned.
 */
final class RedactedResponse implements HttpResponse<String> {
  static final String REDACTED_AUTHORIZATION = "Bearer [redacted]";

  private final HttpResponse<String> response;
  private final HttpRequest request;

  RedactedResponse(HttpResponse<String> response, HttpRequest request) {
    this.response = response;
    this.request = request;
  }

  /** A copy of {@code request} whose Authorization header hides the API key. */
  static HttpRequest redact(HttpRequest request) {
    return HttpRequest.newBuilder(request, (name, value) -> !name.equalsIgnoreCase("Authorization"))
        .header("Authorization", REDACTED_AUTHORIZATION)
        .build();
  }

  @Override
  public int statusCode() {
    return response.statusCode();
  }

  @Override
  public HttpRequest request() {
    return request;
  }

  @Override
  public Optional<HttpResponse<String>> previousResponse() {
    return response
        .previousResponse()
        .map(previous -> new RedactedResponse(previous, redact(previous.request())));
  }

  @Override
  public HttpHeaders headers() {
    return response.headers();
  }

  @Override
  public String body() {
    return response.body();
  }

  @Override
  public Optional<SSLSession> sslSession() {
    return response.sslSession();
  }

  @Override
  public URI uri() {
    return response.uri();
  }

  @Override
  public HttpClient.Version version() {
    return response.version();
  }

  @Override
  public String toString() {
    return response.toString();
  }
}
