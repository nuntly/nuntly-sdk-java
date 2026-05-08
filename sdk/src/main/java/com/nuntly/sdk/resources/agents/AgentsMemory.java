package com.nuntly.sdk.resources.agents;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class AgentsMemory extends Resource {

  public AgentsMemory(NuntlyClient client) {
    super(client);
  }

  /** Retrieve the memory for an AI agent. */
  public AgentMemory retrieve(String agentId) {
    return client.get("/agents/" + agentId + "/memory", AgentMemory.class, RequestOptions.none());
  }

  /** Create or update the memory for an AI agent. */
  public AgentMemory upsert(String agentId, AgentMemoryRequest body) {
    return client.put(
        "/agents/" + agentId + "/memory", body, AgentMemory.class, RequestOptions.none());
  }
}
