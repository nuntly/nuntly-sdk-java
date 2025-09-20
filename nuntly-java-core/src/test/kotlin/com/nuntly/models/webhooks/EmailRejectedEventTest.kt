// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import com.nuntly.models.shared.RejectDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailRejectedEventTest {

    @Test
    fun create() {
        val emailRejectedEvent =
            EmailRejectedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_REJECTED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailRejectedEvent.Data.builder()
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
                        .reject(RejectDetail.builder().reason("reason").build())
                        .build()
                )
                .build()

        assertThat(emailRejectedEvent.id()).isEqualTo("id")
        assertThat(emailRejectedEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailRejectedEvent.type()).isEqualTo(EventType.EMAIL_REJECTED)
        assertThat(emailRejectedEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailRejectedEvent.data())
            .isEqualTo(
                EmailRejectedEvent.Data.builder()
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
                    .reject(RejectDetail.builder().reason("reason").build())
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailRejectedEvent =
            EmailRejectedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_REJECTED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailRejectedEvent.Data.builder()
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
                        .reject(RejectDetail.builder().reason("reason").build())
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
