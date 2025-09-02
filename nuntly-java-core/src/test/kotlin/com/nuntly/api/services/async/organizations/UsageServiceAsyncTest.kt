// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.organizations

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UsageServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val usageServiceAsync = client.organizations().usage()

        val usageFuture = usageServiceAsync.retrieve("id")

        val usage = usageFuture.get()
        usage.validate()
    }
}
