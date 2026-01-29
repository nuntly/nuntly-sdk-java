// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.organizations

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
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

        val usageFuture = usageServiceAsync.retrieve("org_01ka8k8s80gvx9604cn9am5st4")

        val usage = usageFuture.get()
        usage.validate()
    }
}
