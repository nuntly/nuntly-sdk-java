package com.nuntly.sdk;

import com.google.gson.JsonParser;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.Optional;

public non-sealed class ApiError extends NuntlyError {
  private final int status;
  private final HttpHeaders headers;
  private final String body;
  private final Optional<String> requestId;
  private final HttpResponse<String> rawResponse;

  public ApiError(int status, String body, HttpHeaders headers, HttpResponse<String> rawResponse) {
    super("HTTP %d: %s".formatted(status, parseMessage(body)));
    this.status = status;
    this.body = body;
    this.headers = headers;
    this.requestId = headers.firstValue("x-request-id");
    this.rawResponse = rawResponse;
  }

  public int status() {
    return status;
  }

  public HttpHeaders headers() {
    return headers;
  }

  public String body() {
    return body;
  }

  public Optional<String> requestId() {
    return requestId;
  }

  public HttpResponse<String> rawResponse() {
    return rawResponse;
  }

  public static ApiError from(HttpResponse<String> response) {
    var status = response.statusCode();
    var body = response.body();
    var headers = response.headers();
    return switch (status) {
      case 400 -> new BadRequestError(body, headers, response);
      case 401 -> new AuthenticationError(body, headers, response);
      case 403 -> new PermissionDeniedError(body, headers, response);
      case 404 -> new NotFoundError(body, headers, response);
      case 409 -> new ConflictError(body, headers, response);
      case 422 -> new UnprocessableEntityError(body, headers, response);
      case 429 -> new RateLimitError(body, headers, response);
      default -> {
        if (status >= 500) yield new InternalServerError(status, body, headers, response);
        yield new ApiError(status, body, headers, response);
      }
    };
  }

  /**
   * Best-effort extraction of the human-readable error title from the canonical {@code { "error": {
   * "status", "code", "title", "details"? } }} payload returned by the Nuntly API. Uses the Gson
   * parser already on the classpath (shared with {@link NuntlyClient}) to avoid the fragile
   * substring scan that mis-rendered any body whose {@code details} string contained the literal
   * {@code "title"}. Falls back to a truncated raw body when the payload is not the canonical
   * envelope.
   */
  private static String parseMessage(String body) {
    if (body == null || body.isBlank()) return "Request failed";
    try {
      var root = JsonParser.parseString(body);
      if (root.isJsonObject()) {
        var obj = root.getAsJsonObject();
        if (obj.has("error") && obj.get("error").isJsonObject()) {
          var err = obj.getAsJsonObject("error");
          if (err.has("title") && err.get("title").isJsonPrimitive()) {
            return err.get("title").getAsString();
          }
        }
      }
    } catch (Exception ignored) {
      // fall through to truncated raw body
    }
    return body.length() > 200 ? body.substring(0, 200) : body;
  }

  public static final class BadRequestError extends ApiError {
    public BadRequestError(String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(400, body, headers, raw);
    }
  }

  public static final class AuthenticationError extends ApiError {
    public AuthenticationError(String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(401, body, headers, raw);
    }
  }

  public static final class PermissionDeniedError extends ApiError {
    public PermissionDeniedError(String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(403, body, headers, raw);
    }
  }

  public static final class NotFoundError extends ApiError {
    public NotFoundError(String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(404, body, headers, raw);
    }
  }

  public static final class ConflictError extends ApiError {
    public ConflictError(String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(409, body, headers, raw);
    }
  }

  public static final class UnprocessableEntityError extends ApiError {
    public UnprocessableEntityError(String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(422, body, headers, raw);
    }
  }

  public static final class RateLimitError extends ApiError {
    private final Optional<Long> retryAfter;

    public RateLimitError(String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(429, body, headers, raw);
      this.retryAfter =
          headers
              .firstValue("retry-after")
              .map(
                  v -> {
                    try {
                      return Long.parseLong(v) * 1000;
                    } catch (NumberFormatException e) {
                      return null;
                    }
                  });
    }

    public Optional<Long> retryAfter() {
      return retryAfter;
    }
  }

  public static final class InternalServerError extends ApiError {
    public InternalServerError(
        int status, String body, HttpHeaders headers, HttpResponse<String> raw) {
      super(status, body, headers, raw);
    }
  }
}
