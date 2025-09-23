// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.webhooks

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.webhooks.events.EventDeliveriesParams
import com.nuntly.models.webhooks.events.EventReplayParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EventServiceAsyncTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventServiceAsync = client.webhooks().events()

        val pageFuture = eventServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun deliveries() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventServiceAsync = client.webhooks().events()

        val responseFuture =
            eventServiceAsync.deliveries(
                EventDeliveriesParams.builder().id("id").eventId("event_id").build()
            )

        val response = responseFuture.get()
        response.forEach { it.validate() }
    }

    @Test
    fun replay() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventServiceAsync = client.webhooks().events()

        val responseFuture =
            eventServiceAsync.replay(
                EventReplayParams.builder()
                    .id("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
                    .eventId("event_id")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
