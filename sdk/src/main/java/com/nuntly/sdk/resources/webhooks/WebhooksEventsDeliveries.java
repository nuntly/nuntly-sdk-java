package com.nuntly.sdk.resources.webhooks;

import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.*;

public final class WebhooksEventsDeliveries extends Resource {

  public WebhooksEventsDeliveries(NuntlyClient client) {
    super(client);
  }

  /**
   * Lists the delivery attempts of a webhook event to an endpoint, with the status, HTTP response
   * code, response data, and delivery time of each attempt.
   */
  public List<WebhookEventDeliveriesResponseItem> list(String id, String eventId) {
    var response =
        client.rawRequest(
            "GET",
            "/webhooks/"
                + pathParam("id", id)
                + "/events/"
                + pathParam("eventId", eventId)
                + "/deliveries",
            null,
            RequestOptions.none());
    var json = com.google.gson.JsonParser.parseString(response.body()).getAsJsonObject();
    var items =
        client.gson().fromJson(json.get("data"), WebhookEventDeliveriesResponseItem[].class);
    return List.of(items);
  }
}
