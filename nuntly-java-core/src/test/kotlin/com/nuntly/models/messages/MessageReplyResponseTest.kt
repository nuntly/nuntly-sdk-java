// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageReplyResponseTest {

    @Test
    fun create() {
        val messageReplyResponse =
            MessageReplyResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .messageId("messageId")
                .subject("subject")
                .threadId("threadId")
                .build()

        assertThat(messageReplyResponse.id()).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(messageReplyResponse.messageId()).isEqualTo("messageId")
        assertThat(messageReplyResponse.subject()).isEqualTo("subject")
        assertThat(messageReplyResponse.threadId()).isEqualTo("threadId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageReplyResponse =
            MessageReplyResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .messageId("messageId")
                .subject("subject")
                .threadId("threadId")
                .build()

        val roundtrippedMessageReplyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageReplyResponse),
                jacksonTypeRef<MessageReplyResponse>(),
            )

        assertThat(roundtrippedMessageReplyResponse).isEqualTo(messageReplyResponse)
    }
}
