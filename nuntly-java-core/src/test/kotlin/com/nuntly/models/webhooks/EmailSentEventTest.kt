// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailSentEventTest {

    @Test
    fun create() {
        val emailSentEvent =
            EmailSentEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailSentEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .send(JsonValue.from(mapOf<String, Any>()))
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailSentEvent.Data.Header.builder().name("name").value("value").build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailSentEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailSentEvent.Type.EMAIL_SENT)
                .build()

        assertThat(emailSentEvent.id()).isEqualTo("id")
        assertThat(emailSentEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailSentEvent.data())
            .isEqualTo(
                EmailSentEvent.Data.builder()
                    .id("id")
                    .domainId("domainId")
                    .domainName("domainName")
                    .enqueuedAt("enqueuedAt")
                    .from("from")
                    .messageId("messageId")
                    .orgId("orgId")
                    .send(JsonValue.from(mapOf<String, Any>()))
                    .sentAt("sentAt")
                    .subject("subject")
                    .to("string")
                    .bcc("string")
                    .bulkId("bulkId")
                    .cc("string")
                    .addHeader(
                        EmailSentEvent.Data.Header.builder().name("name").value("value").build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailSentEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailSentEvent.type()).isEqualTo(EmailSentEvent.Type.EMAIL_SENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailSentEvent =
            EmailSentEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailSentEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .send(JsonValue.from(mapOf<String, Any>()))
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailSentEvent.Data.Header.builder().name("name").value("value").build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailSentEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailSentEvent.Type.EMAIL_SENT)
                .build()

        val roundtrippedEmailSentEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailSentEvent),
                jacksonTypeRef<EmailSentEvent>(),
            )

        assertThat(roundtrippedEmailSentEvent).isEqualTo(emailSentEvent)
    }
}
