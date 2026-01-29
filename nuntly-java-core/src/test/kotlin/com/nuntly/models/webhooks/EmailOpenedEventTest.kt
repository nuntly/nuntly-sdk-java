// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailOpenedEventTest {

    @Test
    fun create() {
        val emailOpenedEvent =
            EmailOpenedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailOpenedEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .open(
                            EmailOpenedEvent.Data.Open.builder()
                                .openedAt("openedAt")
                                .userAgent("userAgent")
                                .build()
                        )
                        .orgId("orgId")
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailOpenedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailOpenedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailOpenedEvent.Type.EMAIL_OPENED)
                .build()

        assertThat(emailOpenedEvent.id()).isEqualTo("id")
        assertThat(emailOpenedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailOpenedEvent.data())
            .isEqualTo(
                EmailOpenedEvent.Data.builder()
                    .id("id")
                    .domainId("domainId")
                    .domainName("domainName")
                    .enqueuedAt("enqueuedAt")
                    .from("from")
                    .messageId("messageId")
                    .open(
                        EmailOpenedEvent.Data.Open.builder()
                            .openedAt("openedAt")
                            .userAgent("userAgent")
                            .build()
                    )
                    .orgId("orgId")
                    .sentAt("sentAt")
                    .subject("subject")
                    .to("string")
                    .bcc("string")
                    .bulkId("bulkId")
                    .cc("string")
                    .addHeader(
                        EmailOpenedEvent.Data.Header.builder().name("name").value("value").build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailOpenedEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailOpenedEvent.type()).isEqualTo(EmailOpenedEvent.Type.EMAIL_OPENED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailOpenedEvent =
            EmailOpenedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailOpenedEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .open(
                            EmailOpenedEvent.Data.Open.builder()
                                .openedAt("openedAt")
                                .userAgent("userAgent")
                                .build()
                        )
                        .orgId("orgId")
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailOpenedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailOpenedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailOpenedEvent.Type.EMAIL_OPENED)
                .build()

        val roundtrippedEmailOpenedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailOpenedEvent),
                jacksonTypeRef<EmailOpenedEvent>(),
            )

        assertThat(roundtrippedEmailOpenedEvent).isEqualTo(emailOpenedEvent)
    }
}
