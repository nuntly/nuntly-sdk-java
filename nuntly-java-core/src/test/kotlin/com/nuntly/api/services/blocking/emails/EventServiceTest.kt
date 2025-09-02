// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking.emails

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClient
import com.nuntly.api.models.emails.events.EventListParams
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
        val eventService = client.emails().events()

        val events =
            eventService.list(
                EventListParams.builder()
                    .id("em_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")
                    .cursor("cursor")
                    .limit(1.0)
                    .build()
            )

        events.forEach { it.validate() }
    }
}
