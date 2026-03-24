// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageForwardResponseTest {

    @Test
    fun create() {
        val messageForwardResponse =
            MessageForwardResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .messageId("messageId")
                .subject("subject")
                .threadId("threadId")
                .build()

        assertThat(messageForwardResponse.id()).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(messageForwardResponse.messageId()).isEqualTo("messageId")
        assertThat(messageForwardResponse.subject()).isEqualTo("subject")
        assertThat(messageForwardResponse.threadId()).isEqualTo("threadId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageForwardResponse =
            MessageForwardResponse.builder()
                .id("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .messageId("messageId")
                .subject("subject")
                .threadId("threadId")
                .build()

        val roundtrippedMessageForwardResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageForwardResponse),
                jacksonTypeRef<MessageForwardResponse>(),
            )

        assertThat(roundtrippedMessageForwardResponse).isEqualTo(messageForwardResponse)
    }
}
