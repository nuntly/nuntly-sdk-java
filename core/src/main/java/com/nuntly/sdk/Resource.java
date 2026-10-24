package com.nuntly.sdk;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Base class for SDK resources (Emails, Domains, Webhooks, ...). Holds the shared {@link
 * NuntlyClient} used to issue HTTP calls. Use {@link ApiError#rawResponse()} to inspect the HTTP
 * response of a failed call.
 */
public abstract class Resource {
  protected final NuntlyClient client;

  protected Resource(NuntlyClient client) {
    this.client = client;
  }

  // The server resolves these into another route: /contacts/../segments/s is /segments/s.
  protected static String pathParam(String name, String value) {
    if (value == null) throw new NuntlyError("Missing path param '" + name + "'.");
    if (value.isEmpty() || value.equals(".") || value.equals("..")) {
      throw new NuntlyError("Path param '" + name + "' must not be '" + value + "'.");
    }
    // Percent-encoded, so a '/', '?' or '#' in the value cannot change the route.
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }
}
