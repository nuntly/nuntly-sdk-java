package com.nuntly.sdk;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Hooks called during each request, in this order: {@code onRequest} before every attempt, {@code
 * onRetry} before each retry, {@code onResponse} once on the final response (not when the last
 * attempt got no response), then {@code onSuccess} on a 2xx or {@code onError}. An exception a hook
 * other than {@code onError} throws ends the request with that exception, never retried.
 */
public record Hooks(
    Consumer<HttpRequest> onRequest,
    BiConsumer<HttpResponse<String>, HttpRequest> onResponse,
    BiConsumer<Object, HttpRequest> onSuccess,
    Consumer<RetryContext> onRetry,
    BiConsumer<Throwable, HttpRequest> onError) {
  public static final Hooks NONE = new Hooks(null, null, null, null, null);

  public static Builder builder() {
    return new Builder();
  }

  public record RetryContext(
      int attempt, HttpResponse<String> response, Throwable error, HttpRequest request) {}

  public static final class Builder {
    private Consumer<HttpRequest> onRequest;
    private BiConsumer<HttpResponse<String>, HttpRequest> onResponse;
    private BiConsumer<Object, HttpRequest> onSuccess;
    private Consumer<RetryContext> onRetry;
    private BiConsumer<Throwable, HttpRequest> onError;

    public Builder onRequest(Consumer<HttpRequest> hook) {
      this.onRequest = hook;
      return this;
    }

    public Builder onResponse(BiConsumer<HttpResponse<String>, HttpRequest> hook) {
      this.onResponse = hook;
      return this;
    }

    public Builder onSuccess(BiConsumer<Object, HttpRequest> hook) {
      this.onSuccess = hook;
      return this;
    }

    public Builder onRetry(Consumer<RetryContext> hook) {
      this.onRetry = hook;
      return this;
    }

    /**
     * Called with the error a request fails with, before it is thrown. Anything the hook throws,
     * other than that error itself or a {@link VirtualMachineError}, is added to it as suppressed:
     * the caller still receives the original error.
     */
    public Builder onError(BiConsumer<Throwable, HttpRequest> hook) {
      this.onError = hook;
      return this;
    }

    public Hooks build() {
      return new Hooks(onRequest, onResponse, onSuccess, onRetry, onError);
    }
  }
}
