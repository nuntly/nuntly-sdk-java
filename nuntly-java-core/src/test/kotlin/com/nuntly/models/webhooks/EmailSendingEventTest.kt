// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailSendingEventTest {

    @Test
    fun create() {
        val emailSendingEvent =
            EmailSendingEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailSendingEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .sending(JsonValue.from(mapOf<String, Any>()))
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailSendingEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailSendingEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailSendingEvent.Type.EMAIL_SENDING)
                .build()

        assertThat(emailSendingEvent.id()).isEqualTo("id")
        assertThat(emailSendingEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailSendingEvent.data())
            .isEqualTo(
                EmailSendingEvent.Data.builder()
                    .id("id")
                    .domainId("domainId")
                    .domainName("domainName")
                    .enqueuedAt("enqueuedAt")
                    .from("from")
                    .messageId("messageId")
                    .orgId("orgId")
                    .sending(JsonValue.from(mapOf<String, Any>()))
                    .sentAt("sentAt")
                    .subject("subject")
                    .to("string")
                    .bcc("string")
                    .bulkId("bulkId")
                    .cc("string")
                    .addHeader(
                        EmailSendingEvent.Data.Header.builder().name("name").value("value").build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailSendingEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailSendingEvent.type()).isEqualTo(EmailSendingEvent.Type.EMAIL_SENDING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailSendingEvent =
            EmailSendingEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailSendingEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .sending(JsonValue.from(mapOf<String, Any>()))
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailSendingEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailSendingEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailSendingEvent.Type.EMAIL_SENDING)
                .build()

        val roundtrippedEmailSendingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailSendingEvent),
                jacksonTypeRef<EmailSendingEvent>(),
            )

        assertThat(roundtrippedEmailSendingEvent).isEqualTo(emailSendingEvent)
    }
}
