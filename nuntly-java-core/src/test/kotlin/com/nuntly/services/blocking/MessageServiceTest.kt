// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.messages.MessageForwardParams
import com.nuntly.models.messages.MessageReplyParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val messageDetail = messageService.retrieve("imsg_01kabn43yqyxn2bx4ve84mczd3")

        messageDetail.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val page = messageService.list()

        page.response().validate()
    }

    @Test
    fun forward() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val response =
            messageService.forward(
                MessageForwardParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .addTo("dev@stainless.com")
                    .text("text")
                    .build()
            )

        response.validate()
    }

    @Test
    fun reply() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val response =
            messageService.reply(
                MessageReplyParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .html("html")
                    .replyAll(true)
                    .text("text")
                    .build()
            )

        response.validate()
    }
}
