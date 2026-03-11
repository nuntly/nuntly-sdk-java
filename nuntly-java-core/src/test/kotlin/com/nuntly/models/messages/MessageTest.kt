// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageTest {

    @Test
    fun create() {
        val message =
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

        assertThat(message.id()).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(message.attachmentCount()).isEqualTo(0.0)
        assertThat(message.bcc().getOrNull()).containsExactly("string")
        assertThat(message.cc().getOrNull()).containsExactly("string")
        assertThat(message.createdAt()).isEqualTo("createdAt")
        assertThat(message.from()).isEqualTo("from")
        assertThat(message.inboxId()).contains("inboxId")
        assertThat(message.messageId()).isEqualTo("messageId")
        assertThat(message.receivedAt()).isEqualTo("receivedAt")
        assertThat(message.replyTo().getOrNull()).containsExactly("string")
        assertThat(message.status()).isEqualTo(Message.Status.RECEIVED)
        assertThat(message.subject()).isEqualTo("subject")
        assertThat(message.threadId()).isEqualTo("threadId")
        assertThat(message.to()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val message =
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

        val roundtrippedMessage =
            jsonMapper.readValue(jsonMapper.writeValueAsString(message), jacksonTypeRef<Message>())

        assertThat(roundtrippedMessage).isEqualTo(message)
    }
}
