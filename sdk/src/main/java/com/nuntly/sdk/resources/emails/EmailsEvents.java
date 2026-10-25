package com.nuntly.sdk.resources.emails;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsEvents extends Resource {

  public EmailsEvents(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns the full event history of an email, newest first, such as queued, sent, delivered,
   * opened, clicked or bounced. The list is not paginated.
   */
  public List<EmailEventsResponseItem> list(String id) {
    return List.of(
        client.get(
            "/emails/" + pathParam("id", id) + "/events",
            EmailEventsResponseItem[].class,
            RequestOptions.none()));
  }
}
