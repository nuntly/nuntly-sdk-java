// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.emails

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
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

        val eventsFuture = eventServiceAsync.list("em_01ka8k8s80gvx9604cn9am5st4")

        val events = eventsFuture.get()
        events.forEach { it.validate() }
    }
}
