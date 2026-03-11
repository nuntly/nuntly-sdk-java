// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageReceivedEventTest {

    @Test
    fun create() {
        val messageReceivedEvent =
            MessageReceivedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageReceivedEvent.Data.builder()
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
                .type(MessageReceivedEvent.Type.MESSAGE_RECEIVED)
                .build()

        assertThat(messageReceivedEvent.id()).isEqualTo("id")
        assertThat(messageReceivedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(messageReceivedEvent.data())
            .isEqualTo(
                MessageReceivedEvent.Data.builder()
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
        assertThat(messageReceivedEvent.type())
            .isEqualTo(MessageReceivedEvent.Type.MESSAGE_RECEIVED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageReceivedEvent =
            MessageReceivedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageReceivedEvent.Data.builder()
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
                .type(MessageReceivedEvent.Type.MESSAGE_RECEIVED)
                .build()

        val roundtrippedMessageReceivedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageReceivedEvent),
                jacksonTypeRef<MessageReceivedEvent>(),
            )

        assertThat(roundtrippedMessageReceivedEvent).isEqualTo(messageReceivedEvent)
    }
}
