// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import com.nuntly.models.shared.SendDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailSentEventTest {

    @Test
    fun create() {
        val emailSentEvent =
            EmailSentEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_SENT)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailSentEvent.Data.builder()
                        .id("id")
                        .domain("domain")
                        .domainId("domain_id")
                        .enqueueAt("enqueue_at")
                        .from("from")
                        .messageId("message_id")
                        .orgId("org_id")
                        .sentAt("sent_at")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulk_id")
                        .cc("string")
                        .addHeader(EmailEvent.Header.builder().name("name").value("value").build())
                        .replyTo("string")
                        .tags(
                            EmailEvent.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .send(SendDetail.builder().build())
                        .build()
                )
                .build()

        assertThat(emailSentEvent.id()).isEqualTo("id")
        assertThat(emailSentEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailSentEvent.type()).isEqualTo(EventType.EMAIL_SENT)
        assertThat(emailSentEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailSentEvent.data())
            .isEqualTo(
                EmailSentEvent.Data.builder()
                    .id("id")
                    .domain("domain")
                    .domainId("domain_id")
                    .enqueueAt("enqueue_at")
                    .from("from")
                    .messageId("message_id")
                    .orgId("org_id")
                    .sentAt("sent_at")
                    .subject("subject")
                    .to("string")
                    .bcc("string")
                    .bulkId("bulk_id")
                    .cc("string")
                    .addHeader(EmailEvent.Header.builder().name("name").value("value").build())
                    .replyTo("string")
                    .tags(
                        EmailEvent.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .send(SendDetail.builder().build())
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailSentEvent =
            EmailSentEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_SENT)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailSentEvent.Data.builder()
                        .id("id")
                        .domain("domain")
                        .domainId("domain_id")
                        .enqueueAt("enqueue_at")
                        .from("from")
                        .messageId("message_id")
                        .orgId("org_id")
                        .sentAt("sent_at")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulk_id")
                        .cc("string")
                        .addHeader(EmailEvent.Header.builder().name("name").value("value").build())
                        .replyTo("string")
                        .tags(
                            EmailEvent.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .send(SendDetail.builder().build())
                        .build()
                )
                .build()

        val roundtrippedEmailSentEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailSentEvent),
                jacksonTypeRef<EmailSentEvent>(),
            )

        assertThat(roundtrippedEmailSentEvent).isEqualTo(emailSentEvent)
    }
}
