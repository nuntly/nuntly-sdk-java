package com.nuntly.sdk.resources.organizations;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class OrganizationsUsage extends Resource {

  public OrganizationsUsage(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns the daily and monthly email usage of the organization, with each limit, its reset time,
   * and a breakdown by channel.
   */
  public OrganizationUsageResponse retrieve(String id) {
    return client.get(
        "/organizations/" + pathParam("id", id) + "/usage",
        OrganizationUsageResponse.class,
        RequestOptions.none());
  }
}
