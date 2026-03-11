// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListResponseTest {

    @Test
    fun create() {
        val messageListResponse =
            MessageListResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .attachmentCount(0.0)
                .addBcc("string")
                .addCc("string")
                .createdAt("createdAt")
                .from("from")
                .messageId("messageId")
                .receivedAt("receivedAt")
                .addReplyTo("string")
                .status(MessageListResponse.Status.RECEIVED)
                .subject("subject")
                .threadId("threadId")
                .addTo("string")
                .build()

        assertThat(messageListResponse.id()).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(messageListResponse.attachmentCount()).isEqualTo(0.0)
        assertThat(messageListResponse.bcc().getOrNull()).containsExactly("string")
        assertThat(messageListResponse.cc().getOrNull()).containsExactly("string")
        assertThat(messageListResponse.createdAt()).isEqualTo("createdAt")
        assertThat(messageListResponse.from()).isEqualTo("from")
        assertThat(messageListResponse.messageId()).isEqualTo("messageId")
        assertThat(messageListResponse.receivedAt()).isEqualTo("receivedAt")
        assertThat(messageListResponse.replyTo().getOrNull()).containsExactly("string")
        assertThat(messageListResponse.status()).isEqualTo(MessageListResponse.Status.RECEIVED)
        assertThat(messageListResponse.subject()).isEqualTo("subject")
        assertThat(messageListResponse.threadId()).isEqualTo("threadId")
        assertThat(messageListResponse.to()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageListResponse =
            MessageListResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .attachmentCount(0.0)
                .addBcc("string")
                .addCc("string")
                .createdAt("createdAt")
                .from("from")
                .messageId("messageId")
                .receivedAt("receivedAt")
                .addReplyTo("string")
                .status(MessageListResponse.Status.RECEIVED)
                .subject("subject")
                .threadId("threadId")
                .addTo("string")
                .build()

        val roundtrippedMessageListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageListResponse),
                jacksonTypeRef<MessageListResponse>(),
            )

        assertThat(roundtrippedMessageListResponse).isEqualTo(messageListResponse)
    }
}
