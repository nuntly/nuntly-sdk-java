// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.threads.ThreadUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ThreadServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.threads()

        val threadFuture = threadServiceAsync.retrieve("thr_01kabn43yqyxn2bx4ve84mczd3")

        val thread = threadFuture.get()
        thread.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val threadServiceAsync = client.threads()

        val threadFuture =
            threadServiceAsync.update(
                ThreadUpdateParams.builder()
                    .threadId("thr_01kabn43yqyxn2bx4ve84mczd3")
                    .agentId("agentId")
                    .isRead(true)
                    .isSpam(true)
                    .build()
            )

        val thread = threadFuture.get()
        thread.validate()
    }
}
