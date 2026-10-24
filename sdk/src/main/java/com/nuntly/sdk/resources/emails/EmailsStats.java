package com.nuntly.sdk.resources.emails;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsStats extends Resource {

  public EmailsStats(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns daily email counts for the last 30 days and today, per status and engagement type
   * (sent, delivered, bounced, opened, clicked and more).
   */
  public EmailsStatsResponse retrieve() {
    return client.get("/emails/stats", EmailsStatsResponse.class, RequestOptions.none());
  }
}
