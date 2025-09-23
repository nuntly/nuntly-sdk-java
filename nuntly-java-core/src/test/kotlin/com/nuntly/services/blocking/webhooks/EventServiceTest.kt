// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.webhooks

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.webhooks.events.EventDeliveriesParams
import com.nuntly.models.webhooks.events.EventReplayParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EventServiceTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventService = client.webhooks().events()

        val page = eventService.list()

        page.response().validate()
    }

    @Test
    fun deliveries() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventService = client.webhooks().events()

        val response =
            eventService.deliveries(
                EventDeliveriesParams.builder().id("id").eventId("event_id").build()
            )

        response.forEach { it.validate() }
    }

    @Test
    fun replay() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventService = client.webhooks().events()

        val response =
            eventService.replay(
                EventReplayParams.builder()
                    .id("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
                    .eventId("event_id")
                    .build()
            )

        response.validate()
    }
}
