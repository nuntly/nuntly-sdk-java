// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.emails

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.emails.events.EventListParams
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
        val eventServiceAsync = client.emails().events()

        val eventsFuture =
            eventServiceAsync.list(
                EventListParams.builder()
                    .id("em_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
                    .cursor("cursor")
                    .limit(1.0)
                    .build()
            )

        val events = eventsFuture.get()
        events.forEach { it.validate() }
    }
}
