// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.inboxes

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ThreadServiceTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.inboxes().threads()

        val page = threadService.list("ibx_01kabn43yqyxn2bx4ve84mczd3")

        page.response().validate()
    }
}
