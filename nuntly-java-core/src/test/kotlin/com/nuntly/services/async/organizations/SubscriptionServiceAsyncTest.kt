// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.organizations

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SubscriptionServiceAsyncTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val subscriptionServiceAsync = client.organizations().subscriptions()

        val subscriptionsFuture = subscriptionServiceAsync.list("id")

        val subscriptions = subscriptionsFuture.get()
        subscriptions.forEach { it.validate() }
    }
}
