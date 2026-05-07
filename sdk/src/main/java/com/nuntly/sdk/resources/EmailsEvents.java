package com.nuntly.sdk.resources;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class EmailsEvents extends Resource {

  public EmailsEvents(NuntlyClient client) {
    super(client);
  }

  /**
   * Returns the full delivery event history for an email (sent, delivered, opened, bounced, etc.).
   */
  public java.util.List<EmailEventsResponseItem> list(String id) {
    var response =
        client.rawRequest("GET", "/emails/" + id + "/events", null, RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items = client.gson().fromJson(json.get("data"), EmailEventsResponseItem[].class);
    return java.util.List.of(items);
  }
}
