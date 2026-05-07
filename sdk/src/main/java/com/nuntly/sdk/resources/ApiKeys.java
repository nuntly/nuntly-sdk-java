package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class ApiKeys extends Resource {

  public ApiKeys(NuntlyClient client) {
    super(client);
  }

  /** Returns API key metadata. The key value is never returned after creation. */
  public ApiKeyResponse retrieve(String id) {
    return client.get("/api-keys/" + id + "", ApiKeyResponse.class, RequestOptions.none());
  }

  /** Update the key name, permissions, or restrict it to specific sending domains. */
  public UpdateApiKeyResponse update(String id, UpdateApiKeyRequest body) {
    return client.put(
        "/api-keys/" + id + "", body, UpdateApiKeyResponse.class, RequestOptions.none());
  }

  /** Revoke an API key. Requests authenticating with this key will be rejected immediately. */
  public DeleteApiKeyResponse delete(String id) {
    return client.delete("/api-keys/" + id + "", DeleteApiKeyResponse.class, RequestOptions.none());
  }

  /** Generate a new API key. The key value is only returned once — store it securely. */
  public CreateApiKeyResponse create(CreateApiKeyRequest body) {
    return client.post("/api-keys", body, CreateApiKeyResponse.class, RequestOptions.none());
  }

  /** Returns all API keys for the organization. Key values are never included in list responses. */
  public CursorPage<ApiKeysResponseItem> list(Optional<String> cursor, Optional<Integer> limit) {
    var query = new HashMap<String, String>();
    cursor.ifPresent(c -> query.put("cursor", c));
    limit.ifPresent(l -> query.put("limit", l.toString()));
    var response = client.rawRequest("GET", "/api-keys", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), ApiKeysResponseItem[].class);
    var next =
        json.has("nextCursor") && !json.get("nextCursor").isJsonNull()
            ? json.get("nextCursor").getAsString()
            : null;
    return new CursorPage<>(java.util.List.of(items), next, (c) -> list(c, limit));
  }

  public CursorPage<ApiKeysResponseItem> list() {
    return list(Optional.empty(), Optional.empty());
  }
}
