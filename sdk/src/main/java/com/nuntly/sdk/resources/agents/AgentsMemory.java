package com.nuntly.sdk.resources.agents;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class AgentsMemory extends Resource {

  public AgentsMemory(NuntlyClient client) {
    super(client);
  }

  /**
   * Retrieves the key-value memory and summary saved for an AI agent, at organization level or
   * scoped to one inbox or thread via query parameters.
   */
  public AgentMemory retrieve(String agentId, AgentsMemoryRetrieveParams params) {
    return retrieve(agentId, params, RequestOptions.none());
  }

  public AgentMemory retrieve(
      String agentId, AgentsMemoryRetrieveParams params, RequestOptions opts) {
    var query = new HashMap<String, Object>();
    params.inboxId().ifPresent(v -> query.put("inboxId", v));
    params.threadId().ifPresent(v -> query.put("threadId", v));
    return client.get(
        "/agents/" + pathParam("agentId", agentId) + "/memory", AgentMemory.class, query, opts);
  }

  public AgentMemory retrieve(String agentId) {
    return retrieve(agentId, AgentsMemoryRetrieveParams.builder().build());
  }

  public AgentMemory retrieve(String agentId, RequestOptions opts) {
    return retrieve(agentId, AgentsMemoryRetrieveParams.builder().build(), opts);
  }

  /**
   * Saves the key-value memory and optional summary of an AI agent, at organization level or scoped
   * to a specific inbox or thread. Returns the saved memory.
   */
  public AgentMemory upsert(String agentId, AgentMemoryRequest body) {
    return upsert(agentId, body, RequestOptions.none());
  }

  public AgentMemory upsert(String agentId, AgentMemoryRequest body, RequestOptions opts) {
    return client.put(
        "/agents/" + pathParam("agentId", agentId) + "/memory", body, AgentMemory.class, opts);
  }
}
