// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailClickedEventTest {

    @Test
    fun create() {
        val emailClickedEvent =
            EmailClickedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailClickedEvent.Data.builder()
                        .id("id")
                        .click(
                            EmailClickedEvent.Data.Click.builder()
                                .clickedAt("clickedAt")
                                .link("link")
                                .userAgent("userAgent")
                                .build()
                        )
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailClickedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailClickedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailClickedEvent.Type.EMAIL_CLICKED)
                .build()

        assertThat(emailClickedEvent.id()).isEqualTo("id")
        assertThat(emailClickedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailClickedEvent.data())
            .isEqualTo(
                EmailClickedEvent.Data.builder()
                    .id("id")
                    .click(
                        EmailClickedEvent.Data.Click.builder()
                            .clickedAt("clickedAt")
                            .link("link")
                            .userAgent("userAgent")
                            .build()
                    )
                    .domainId("domainId")
                    .domainName("domainName")
                    .enqueuedAt("enqueuedAt")
                    .from("from")
                    .messageId("messageId")
                    .orgId("orgId")
                    .sentAt("sentAt")
                    .subject("subject")
                    .to("string")
                    .bcc("string")
                    .bulkId("bulkId")
                    .cc("string")
                    .addHeader(
                        EmailClickedEvent.Data.Header.builder().name("name").value("value").build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailClickedEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailClickedEvent.type()).isEqualTo(EmailClickedEvent.Type.EMAIL_CLICKED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailClickedEvent =
            EmailClickedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailClickedEvent.Data.builder()
                        .id("id")
                        .click(
                            EmailClickedEvent.Data.Click.builder()
                                .clickedAt("clickedAt")
                                .link("link")
                                .userAgent("userAgent")
                                .build()
                        )
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailClickedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailClickedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailClickedEvent.Type.EMAIL_CLICKED)
                .build()

        val roundtrippedEmailClickedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailClickedEvent),
                jacksonTypeRef<EmailClickedEvent>(),
            )

        assertThat(roundtrippedEmailClickedEvent).isEqualTo(emailClickedEvent)
    }
}
