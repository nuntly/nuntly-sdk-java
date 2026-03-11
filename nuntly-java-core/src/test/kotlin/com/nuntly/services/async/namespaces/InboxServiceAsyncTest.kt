// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.namespaces

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InboxServiceAsyncTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.namespaces().inboxes()

        val pageFuture = inboxServiceAsync.list("ns_01kabn43yqyxn2bx4ve84mczd3")

        val page = pageFuture.get()
        page.response().validate()
    }
}
