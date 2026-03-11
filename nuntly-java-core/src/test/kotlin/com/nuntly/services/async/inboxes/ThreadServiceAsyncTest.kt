// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.inboxes

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ThreadServiceAsyncTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.inboxes().threads()

        val pageFuture = threadServiceAsync.list("ibx_01kabn43yqyxn2bx4ve84mczd3")

        val page = pageFuture.get()
        page.response().validate()
    }
}
