package com.nuntly.sdk;

/**
 * Base class for SDK resources (Emails, Domains, Webhooks, ...). Holds the shared {@link
 * NuntlyClient} used to issue HTTP calls.
 *
 * <p>Raw {@code HttpResponse} access is planned for 1.0 via per-method {@code
 * sendWithResponse(...)} overloads that return a {@link ResponseWithData} record. The previous
 * {@code withResponse(T data)} helper, which read from a shared mutable slot on {@link
 * NuntlyClient}, has been removed because it was racy in multi-threaded contexts and silently
 * ignored the passed-in {@code data}. Use {@link ApiError#rawResponse()} for error inspection until
 * per-method response accessors land.
 */
public abstract class Resource {
  protected final NuntlyClient client;

  protected Resource(NuntlyClient client) {
    this.client = client;
  }
}
