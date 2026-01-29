// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailRejectedEventTest {

    @Test
    fun create() {
        val emailRejectedEvent =
            EmailRejectedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailRejectedEvent.Data.builder()
                        .reject(EmailRejectedEvent.Data.Reject.builder().reason("reason").build())
                        .id("id")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .addHeader(
                            EmailRejectedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .messageId("messageId")
                        .orgId("orgId")
                        .replyTo("string")
                        .sentAt("sentAt")
                        .subject("subject")
                        .tags(
                            EmailRejectedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .to("string")
                        .build()
                )
                .build()

        assertThat(emailRejectedEvent.id()).isEqualTo("id")
        assertThat(emailRejectedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailRejectedEvent.data())
            .isEqualTo(
                EmailRejectedEvent.Data.builder()
                    .reject(EmailRejectedEvent.Data.Reject.builder().reason("reason").build())
                    .id("id")
                    .bcc("string")
                    .bulkId("bulkId")
                    .cc("string")
                    .domainId("domainId")
                    .domainName("domainName")
                    .enqueuedAt("enqueuedAt")
                    .from("from")
                    .addHeader(
                        EmailRejectedEvent.Data.Header.builder().name("name").value("value").build()
                    )
                    .messageId("messageId")
                    .orgId("orgId")
                    .replyTo("string")
                    .sentAt("sentAt")
                    .subject("subject")
                    .tags(
                        EmailRejectedEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .to("string")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailRejectedEvent =
            EmailRejectedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailRejectedEvent.Data.builder()
                        .reject(EmailRejectedEvent.Data.Reject.builder().reason("reason").build())
                        .id("id")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .addHeader(
                            EmailRejectedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .messageId("messageId")
                        .orgId("orgId")
                        .replyTo("string")
                        .sentAt("sentAt")
                        .subject("subject")
                        .tags(
                            EmailRejectedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .to("string")
                        .build()
                )
                .build()

        val roundtrippedEmailRejectedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailRejectedEvent),
                jacksonTypeRef<EmailRejectedEvent>(),
            )

        assertThat(roundtrippedEmailRejectedEvent).isEqualTo(emailRejectedEvent)
    }
}
