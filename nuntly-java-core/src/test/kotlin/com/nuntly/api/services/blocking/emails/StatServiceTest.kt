// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking.emails

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StatServiceTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val statService = client.emails().stats()

        val stats = statService.list()

        stats.validate()
    }
}
