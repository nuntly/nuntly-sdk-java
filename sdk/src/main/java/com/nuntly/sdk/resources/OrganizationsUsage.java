package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class OrganizationsUsage extends Resource {

  public OrganizationsUsage(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns current period usage metrics (daily and monthly) for sending and receiving, against
   * your plan limits.
   */
  public OrganizationUsageResponse retrieve(String id) {
    return client.get(
        "/organizations/" + id + "/usage", OrganizationUsageResponse.class, RequestOptions.none());
  }
}
