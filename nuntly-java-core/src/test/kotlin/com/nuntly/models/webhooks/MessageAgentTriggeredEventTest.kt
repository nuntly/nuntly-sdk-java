// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageAgentTriggeredEventTest {

    @Test
    fun create() {
        val messageAgentTriggeredEvent =
            MessageAgentTriggeredEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageAgentTriggeredEvent.Data.builder()
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
                .type(MessageAgentTriggeredEvent.Type.MESSAGE_AGENT_TRIGGERED)
                .build()

        assertThat(messageAgentTriggeredEvent.id()).isEqualTo("id")
        assertThat(messageAgentTriggeredEvent.createdAt()).isEqualTo("createdAt")
        assertThat(messageAgentTriggeredEvent.data())
            .isEqualTo(
                MessageAgentTriggeredEvent.Data.builder()
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
        assertThat(messageAgentTriggeredEvent.type())
            .isEqualTo(MessageAgentTriggeredEvent.Type.MESSAGE_AGENT_TRIGGERED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageAgentTriggeredEvent =
            MessageAgentTriggeredEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageAgentTriggeredEvent.Data.builder()
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
                .type(MessageAgentTriggeredEvent.Type.MESSAGE_AGENT_TRIGGERED)
                .build()

        val roundtrippedMessageAgentTriggeredEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageAgentTriggeredEvent),
                jacksonTypeRef<MessageAgentTriggeredEvent>(),
            )

        assertThat(roundtrippedMessageAgentTriggeredEvent).isEqualTo(messageAgentTriggeredEvent)
    }
}
