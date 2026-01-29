// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.emails

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContentServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contentServiceAsync = client.emails().content()

        val contentFuture = contentServiceAsync.retrieve("em_01ka8k8s80gvx9604cn9am5st4")

        val content = contentFuture.get()
        content.validate()
    }
}
