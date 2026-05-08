package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import com.nuntly.sdk.resources.agents.*;
import java.util.*;

public final class Agents extends Resource {
  private AgentsMemory memory;

  public Agents(NuntlyClient client) {
    super(client);
  }

  public AgentsMemory memory() {
    if (memory == null) memory = new AgentsMemory(client);
    return memory;
  }
}
