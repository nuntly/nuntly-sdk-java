// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.threads.ThreadUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ThreadServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.threads()

        val thread = threadService.retrieve("thr_01kabn43yqyxn2bx4ve84mczd3")

        thread.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadService = client.threads()

        val thread =
            threadService.update(
                ThreadUpdateParams.builder()
                    .threadId("thr_01kabn43yqyxn2bx4ve84mczd3")
                    .agentId("agentId")
                    .isRead(true)
                    .isSpam(true)
                    .build()
            )

        thread.validate()
    }
}
