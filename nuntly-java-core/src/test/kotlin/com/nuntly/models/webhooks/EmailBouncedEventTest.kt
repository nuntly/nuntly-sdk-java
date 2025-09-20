// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.BounceDetail
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailBouncedEventTest {

    @Test
    fun create() {
        val emailBouncedEvent =
            EmailBouncedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_BOUNCED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailBouncedEvent.Data.builder()
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
                        .bounce(
                            BounceDetail.builder()
                                .bounceSubtype("bounce_subtype")
                                .bounceType("bounce_type")
                                .bouncedAt("bounced_at")
                                .addBouncedRecipient(
                                    BounceDetail.BouncedRecipient.builder()
                                        .email("email")
                                        .action("action")
                                        .diagnosticCode("diagnostic_code")
                                        .status("status")
                                        .build()
                                )
                                .feedbackId("feedback_id")
                                .reportingMta("reporting_mta")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(emailBouncedEvent.id()).isEqualTo("id")
        assertThat(emailBouncedEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailBouncedEvent.type()).isEqualTo(EventType.EMAIL_BOUNCED)
        assertThat(emailBouncedEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailBouncedEvent.data())
            .isEqualTo(
                EmailBouncedEvent.Data.builder()
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
                    .bounce(
                        BounceDetail.builder()
                            .bounceSubtype("bounce_subtype")
                            .bounceType("bounce_type")
                            .bouncedAt("bounced_at")
                            .addBouncedRecipient(
                                BounceDetail.BouncedRecipient.builder()
                                    .email("email")
                                    .action("action")
                                    .diagnosticCode("diagnostic_code")
                                    .status("status")
                                    .build()
                            )
                            .feedbackId("feedback_id")
                            .reportingMta("reporting_mta")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailBouncedEvent =
            EmailBouncedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_BOUNCED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailBouncedEvent.Data.builder()
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
                        .bounce(
                            BounceDetail.builder()
                                .bounceSubtype("bounce_subtype")
                                .bounceType("bounce_type")
                                .bouncedAt("bounced_at")
                                .addBouncedRecipient(
                                    BounceDetail.BouncedRecipient.builder()
                                        .email("email")
                                        .action("action")
                                        .diagnosticCode("diagnostic_code")
                                        .status("status")
                                        .build()
                                )
                                .feedbackId("feedback_id")
                                .reportingMta("reporting_mta")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedEmailBouncedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailBouncedEvent),
                jacksonTypeRef<EmailBouncedEvent>(),
            )

        assertThat(roundtrippedEmailBouncedEvent).isEqualTo(emailBouncedEvent)
    }
}
