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
    var response =
        client.rawRequest(
            "GET", "/emails/" + pathParam("id", id) + "/events", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), EmailEventsResponseItem[].class);
    return List.of(items);
  }
}
