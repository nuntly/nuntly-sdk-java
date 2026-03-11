// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListPageResponseTest {

    @Test
    fun create() {
        val messageListPageResponse =
            MessageListPageResponse.builder()
                .addData(
                    Message.builder()
                        .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                        .attachmentCount(0.0)
                        .addBcc("string")
                        .addCc("string")
                        .createdAt("createdAt")
                        .from("from")
                        .inboxId("inboxId")
                        .messageId("messageId")
                        .receivedAt("receivedAt")
                        .addReplyTo("string")
                        .status(Message.Status.RECEIVED)
                        .subject("subject")
                        .threadId("threadId")
                        .addTo("string")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(messageListPageResponse.data())
            .containsExactly(
                Message.builder()
                    .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .attachmentCount(0.0)
                    .addBcc("string")
                    .addCc("string")
                    .createdAt("createdAt")
                    .from("from")
                    .inboxId("inboxId")
                    .messageId("messageId")
                    .receivedAt("receivedAt")
                    .addReplyTo("string")
                    .status(Message.Status.RECEIVED)
                    .subject("subject")
                    .threadId("threadId")
                    .addTo("string")
                    .build()
            )
        assertThat(messageListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageListPageResponse =
            MessageListPageResponse.builder()
                .addData(
                    Message.builder()
                        .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                        .attachmentCount(0.0)
                        .addBcc("string")
                        .addCc("string")
                        .createdAt("createdAt")
                        .from("from")
                        .inboxId("inboxId")
                        .messageId("messageId")
                        .receivedAt("receivedAt")
                        .addReplyTo("string")
                        .status(Message.Status.RECEIVED)
                        .subject("subject")
                        .threadId("threadId")
                        .addTo("string")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedMessageListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageListPageResponse),
                jacksonTypeRef<MessageListPageResponse>(),
            )

        assertThat(roundtrippedMessageListPageResponse).isEqualTo(messageListPageResponse)
    }
}
