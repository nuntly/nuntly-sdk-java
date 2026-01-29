// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailComplainedEventTest {

    @Test
    fun create() {
        val emailComplainedEvent =
            EmailComplainedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailComplainedEvent.Data.builder()
                        .id("id")
                        .complaint(
                            EmailComplainedEvent.Data.Complaint.builder()
                                .complainedAt("complainedAt")
                                .feedbackId("feedbackId")
                                .addComplainedRecipient(
                                    EmailComplainedEvent.Data.Complaint.ComplainedRecipient
                                        .builder()
                                        .email("email")
                                        .build()
                                )
                                .complaintFeedbackType(
                                    EmailComplainedEvent.Data.Complaint.ComplaintFeedbackType.ABUSE
                                )
                                .complaintSubType(
                                    EmailComplainedEvent.Data.Complaint.ComplaintSubType
                                        .ON_ACCOUNT_SUPPRESSION_LIST
                                )
                                .receivedAt("receivedAt")
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
                            EmailComplainedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailComplainedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailComplainedEvent.Type.EMAIL_COMPLAINED)
                .build()

        assertThat(emailComplainedEvent.id()).isEqualTo("id")
        assertThat(emailComplainedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailComplainedEvent.data())
            .isEqualTo(
                EmailComplainedEvent.Data.builder()
                    .id("id")
                    .complaint(
                        EmailComplainedEvent.Data.Complaint.builder()
                            .complainedAt("complainedAt")
                            .feedbackId("feedbackId")
                            .addComplainedRecipient(
                                EmailComplainedEvent.Data.Complaint.ComplainedRecipient.builder()
                                    .email("email")
                                    .build()
                            )
                            .complaintFeedbackType(
                                EmailComplainedEvent.Data.Complaint.ComplaintFeedbackType.ABUSE
                            )
                            .complaintSubType(
                                EmailComplainedEvent.Data.Complaint.ComplaintSubType
                                    .ON_ACCOUNT_SUPPRESSION_LIST
                            )
                            .receivedAt("receivedAt")
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
                        EmailComplainedEvent.Data.Header.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailComplainedEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailComplainedEvent.type())
            .isEqualTo(EmailComplainedEvent.Type.EMAIL_COMPLAINED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailComplainedEvent =
            EmailComplainedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailComplainedEvent.Data.builder()
                        .id("id")
                        .complaint(
                            EmailComplainedEvent.Data.Complaint.builder()
                                .complainedAt("complainedAt")
                                .feedbackId("feedbackId")
                                .addComplainedRecipient(
                                    EmailComplainedEvent.Data.Complaint.ComplainedRecipient
                                        .builder()
                                        .email("email")
                                        .build()
                                )
                                .complaintFeedbackType(
                                    EmailComplainedEvent.Data.Complaint.ComplaintFeedbackType.ABUSE
                                )
                                .complaintSubType(
                                    EmailComplainedEvent.Data.Complaint.ComplaintSubType
                                        .ON_ACCOUNT_SUPPRESSION_LIST
                                )
                                .receivedAt("receivedAt")
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
                            EmailComplainedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailComplainedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailComplainedEvent.Type.EMAIL_COMPLAINED)
                .build()

        val roundtrippedEmailComplainedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailComplainedEvent),
                jacksonTypeRef<EmailComplainedEvent>(),
            )

        assertThat(roundtrippedEmailComplainedEvent).isEqualTo(emailComplainedEvent)
    }
}
