// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSentEventTest {

    @Test
    fun create() {
        val messageSentEvent =
            MessageSentEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageSentEvent.Data.builder()
                        .domainId("domainId")
                        .domainName("domainName")
                        .from("from")
                        .inboxId("inboxId")
                        .messageId("messageId")
                        .orgId("orgId")
                        .subject("subject")
                        .threadId("threadId")
                        .agentId("agentId")
                        .build()
                )
                .type(MessageSentEvent.Type.MESSAGE_SENT)
                .build()

        assertThat(messageSentEvent.id()).isEqualTo("id")
        assertThat(messageSentEvent.createdAt()).isEqualTo("createdAt")
        assertThat(messageSentEvent.data())
            .isEqualTo(
                MessageSentEvent.Data.builder()
                    .domainId("domainId")
                    .domainName("domainName")
                    .from("from")
                    .inboxId("inboxId")
                    .messageId("messageId")
                    .orgId("orgId")
                    .subject("subject")
                    .threadId("threadId")
                    .agentId("agentId")
                    .build()
            )
        assertThat(messageSentEvent.type()).isEqualTo(MessageSentEvent.Type.MESSAGE_SENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageSentEvent =
            MessageSentEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageSentEvent.Data.builder()
                        .domainId("domainId")
                        .domainName("domainName")
                        .from("from")
                        .inboxId("inboxId")
                        .messageId("messageId")
                        .orgId("orgId")
                        .subject("subject")
                        .threadId("threadId")
                        .agentId("agentId")
                        .build()
                )
                .type(MessageSentEvent.Type.MESSAGE_SENT)
                .build()

        val roundtrippedMessageSentEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageSentEvent),
                jacksonTypeRef<MessageSentEvent>(),
            )

        assertThat(roundtrippedMessageSentEvent).isEqualTo(messageSentEvent)
    }
}
