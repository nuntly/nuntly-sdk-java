// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.organizations

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UsageServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val usageService = client.organizations().usage()

        val usage = usageService.retrieve("id")

        usage.validate()
    }
}
