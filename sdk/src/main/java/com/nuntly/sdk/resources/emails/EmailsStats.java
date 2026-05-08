package com.nuntly.sdk.resources.emails;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsStats extends Resource {

  public EmailsStats(NuntlyClient client) {
    super(client);
  }

  /** Returns aggregated daily sending statistics for the current period. */
  public EmailsStatsResponse retrieve() {
    return client.get("/emails/stats", EmailsStatsResponse.class, RequestOptions.none());
  }
}
