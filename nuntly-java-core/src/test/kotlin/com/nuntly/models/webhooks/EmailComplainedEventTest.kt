// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.ComplaintDetail
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailComplainedEventTest {

    @Test
    fun create() {
        val emailComplainedEvent =
            EmailComplainedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_COMPLAINED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailComplainedEvent.Data.builder()
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
                        .complaint(
                            ComplaintDetail.builder()
                                .complainedAt("complained_at")
                                .feedbackId("feedback_id")
                                .addComplainedRecipient(
                                    ComplaintDetail.ComplainedRecipient.builder()
                                        .email("email")
                                        .build()
                                )
                                .complaintFeedbackType("complaint_feedback_type")
                                .complaintSubtype("complaint_subtype")
                                .receivedAt("received_at")
                                .userAgent("user_agent")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(emailComplainedEvent.id()).isEqualTo("id")
        assertThat(emailComplainedEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailComplainedEvent.type()).isEqualTo(EventType.EMAIL_COMPLAINED)
        assertThat(emailComplainedEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailComplainedEvent.data())
            .isEqualTo(
                EmailComplainedEvent.Data.builder()
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
                    .complaint(
                        ComplaintDetail.builder()
                            .complainedAt("complained_at")
                            .feedbackId("feedback_id")
                            .addComplainedRecipient(
                                ComplaintDetail.ComplainedRecipient.builder().email("email").build()
                            )
                            .complaintFeedbackType("complaint_feedback_type")
                            .complaintSubtype("complaint_subtype")
                            .receivedAt("received_at")
                            .userAgent("user_agent")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailComplainedEvent =
            EmailComplainedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_COMPLAINED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailComplainedEvent.Data.builder()
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
                        .complaint(
                            ComplaintDetail.builder()
                                .complainedAt("complained_at")
                                .feedbackId("feedback_id")
                                .addComplainedRecipient(
                                    ComplaintDetail.ComplainedRecipient.builder()
                                        .email("email")
                                        .build()
                                )
                                .complaintFeedbackType("complaint_feedback_type")
                                .complaintSubtype("complaint_subtype")
                                .receivedAt("received_at")
                                .userAgent("user_agent")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedEmailComplainedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailComplainedEvent),
                jacksonTypeRef<EmailComplainedEvent>(),
            )

        assertThat(roundtrippedEmailComplainedEvent).isEqualTo(emailComplainedEvent)
    }
}
