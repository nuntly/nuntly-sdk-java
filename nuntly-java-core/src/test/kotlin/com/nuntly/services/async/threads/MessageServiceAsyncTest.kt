// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.threads

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceAsyncTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.threads().messages()

        val pageFuture = messageServiceAsync.list("thr_01kabn43yqyxn2bx4ve84mczd3")

        val page = pageFuture.get()
        page.response().validate()
    }
}
