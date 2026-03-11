// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageDetailTest {

    @Test
    fun create() {
        val messageDetail =
            MessageDetail.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .attachmentCount(0.0)
                .addBcc("string")
                .addCc("string")
                .createdAt("createdAt")
                .from("from")
                .headers(
                    MessageDetail.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .inboxId("inboxId")
                .messageId("messageId")
                .receivedAt("receivedAt")
                .addReplyTo("string")
                .status(MessageDetail.Status.RECEIVED)
                .subject("subject")
                .threadId("threadId")
                .addTo("string")
                .build()

        assertThat(messageDetail.id()).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(messageDetail.attachmentCount()).isEqualTo(0.0)
        assertThat(messageDetail.bcc().getOrNull()).containsExactly("string")
        assertThat(messageDetail.cc().getOrNull()).containsExactly("string")
        assertThat(messageDetail.createdAt()).isEqualTo("createdAt")
        assertThat(messageDetail.from()).isEqualTo("from")
        assertThat(messageDetail.headers())
            .contains(
                MessageDetail.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(messageDetail.inboxId()).contains("inboxId")
        assertThat(messageDetail.messageId()).isEqualTo("messageId")
        assertThat(messageDetail.receivedAt()).isEqualTo("receivedAt")
        assertThat(messageDetail.replyTo().getOrNull()).containsExactly("string")
        assertThat(messageDetail.status()).isEqualTo(MessageDetail.Status.RECEIVED)
        assertThat(messageDetail.subject()).isEqualTo("subject")
        assertThat(messageDetail.threadId()).isEqualTo("threadId")
        assertThat(messageDetail.to()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageDetail =
            MessageDetail.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .attachmentCount(0.0)
                .addBcc("string")
                .addCc("string")
                .createdAt("createdAt")
                .from("from")
                .headers(
                    MessageDetail.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .inboxId("inboxId")
                .messageId("messageId")
                .receivedAt("receivedAt")
                .addReplyTo("string")
                .status(MessageDetail.Status.RECEIVED)
                .subject("subject")
                .threadId("threadId")
                .addTo("string")
                .build()

        val roundtrippedMessageDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageDetail),
                jacksonTypeRef<MessageDetail>(),
            )

        assertThat(roundtrippedMessageDetail).isEqualTo(messageDetail)
    }
}
