// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSecurityFlaggedEventTest {

    @Test
    fun create() {
        val messageSecurityFlaggedEvent =
            MessageSecurityFlaggedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageSecurityFlaggedEvent.Data.builder()
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
                .type(MessageSecurityFlaggedEvent.Type.MESSAGE_SECURITY_FLAGGED)
                .build()

        assertThat(messageSecurityFlaggedEvent.id()).isEqualTo("id")
        assertThat(messageSecurityFlaggedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(messageSecurityFlaggedEvent.data())
            .isEqualTo(
                MessageSecurityFlaggedEvent.Data.builder()
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
        assertThat(messageSecurityFlaggedEvent.type())
            .isEqualTo(MessageSecurityFlaggedEvent.Type.MESSAGE_SECURITY_FLAGGED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageSecurityFlaggedEvent =
            MessageSecurityFlaggedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    MessageSecurityFlaggedEvent.Data.builder()
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
                .type(MessageSecurityFlaggedEvent.Type.MESSAGE_SECURITY_FLAGGED)
                .build()

        val roundtrippedMessageSecurityFlaggedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageSecurityFlaggedEvent),
                jacksonTypeRef<MessageSecurityFlaggedEvent>(),
            )

        assertThat(roundtrippedMessageSecurityFlaggedEvent).isEqualTo(messageSecurityFlaggedEvent)
    }
}
