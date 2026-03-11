// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.messages.MessageForwardParams
import com.nuntly.models.messages.MessageReplyParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.messages()

        val messageDetailFuture = messageServiceAsync.retrieve("imsg_01kabn43yqyxn2bx4ve84mczd3")

        val messageDetail = messageDetailFuture.get()
        messageDetail.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.messages()

        val pageFuture = messageServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun forward() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.forward(
                MessageForwardParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .addTo("dev@stainless.com")
                    .text("text")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun reply() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.messages()

        val responseFuture =
            messageServiceAsync.reply(
                MessageReplyParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .html("html")
                    .replyAll(true)
                    .text("text")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
