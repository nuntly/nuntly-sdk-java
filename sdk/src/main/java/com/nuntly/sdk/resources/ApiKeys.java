package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class ApiKeys extends Resource {

  public ApiKeys(NuntlyClient client) {
    super(client);
  }

  /**
   * Creates an API key with full access or send-only access, optionally limited to chosen domains.
   * The secret key value is returned only in this response.
   */
  public CreateApiKeyResponse create(CreateApiKeyRequest body) {
    return create(body, RequestOptions.none());
  }

  public CreateApiKeyResponse create(CreateApiKeyRequest body, RequestOptions opts) {
    return client.post("/api-keys", body, CreateApiKeyResponse.class, opts);
  }

  /**
   * Permanently deletes an API key. Any request that authenticates with this key is rejected from
   * then on. This cannot be undone.
   */
  public DeleteApiKeyResponse delete(String id) {
    return delete(id, RequestOptions.none());
  }

  public DeleteApiKeyResponse delete(String id, RequestOptions opts) {
    return client.delete("/api-keys/" + pathParam("id", id) + "", DeleteApiKeyResponse.class, opts);
  }

  /**
   * Lists the API keys of your organization, newest first, with cursor pagination. Each key shows
   * its name, status, creation date, and a short token hint.
   */
  public CursorPage<ApiKeysResponseItem> list(ApiKeysListParams params) {
    return list(params, RequestOptions.none());
  }

  public CursorPage<ApiKeysResponseItem> list(ApiKeysListParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.cursor().ifPresent(v -> query.put("cursor", v));
    params.limit().ifPresent(v -> query.put("limit", v));
    return client.list("/api-keys", ApiKeysResponseItem.class, query, opts);
  }

  public CursorPage<ApiKeysResponseItem> list() {
    return list(ApiKeysListParams.builder().build());
  }

  public CursorPage<ApiKeysResponseItem> list(RequestOptions opts) {
    return list(ApiKeysListParams.builder().build(), opts);
  }

  /**
   * Retrieves an API key by id with its name, status, creation date, and a short token hint. The
   * full secret key value is never returned after creation.
   */
  public ApiKeyResponse retrieve(String id) {
    return retrieve(id, RequestOptions.none());
  }

  public ApiKeyResponse retrieve(String id, RequestOptions opts) {
    return client.get("/api-keys/" + pathParam("id", id) + "", ApiKeyResponse.class, opts);
  }

  /**
   * Updates the name of an API key, enables or disables it, or changes its access level and domain
   * restrictions. Returns the id of the updated key.
   */
  public UpdateApiKeyResponse update(String id, UpdateApiKeyRequest body) {
    return update(id, body, RequestOptions.none());
  }

  public UpdateApiKeyResponse update(String id, UpdateApiKeyRequest body, RequestOptions opts) {
    return client.patch(
        "/api-keys/" + pathParam("id", id) + "", body, UpdateApiKeyResponse.class, opts);
  }
}
