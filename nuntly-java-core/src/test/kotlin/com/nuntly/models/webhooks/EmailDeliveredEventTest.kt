// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.DeliveryDetail
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailDeliveredEventTest {

    @Test
    fun create() {
        val emailDeliveredEvent =
            EmailDeliveredEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_DELIVERED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailDeliveredEvent.Data.builder()
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
                        .delivery(
                            DeliveryDetail.builder()
                                .deliveredAt("delivered_at")
                                .addRecipient("string")
                                .remoteMtaIp("remote_mta_ip")
                                .reportingMta("reporting_mta")
                                .smtpResponse("smtp_response")
                                .processingTime(0.0)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(emailDeliveredEvent.id()).isEqualTo("id")
        assertThat(emailDeliveredEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailDeliveredEvent.type()).isEqualTo(EventType.EMAIL_DELIVERED)
        assertThat(emailDeliveredEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailDeliveredEvent.data())
            .isEqualTo(
                EmailDeliveredEvent.Data.builder()
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
                    .delivery(
                        DeliveryDetail.builder()
                            .deliveredAt("delivered_at")
                            .addRecipient("string")
                            .remoteMtaIp("remote_mta_ip")
                            .reportingMta("reporting_mta")
                            .smtpResponse("smtp_response")
                            .processingTime(0.0)
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailDeliveredEvent =
            EmailDeliveredEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_DELIVERED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailDeliveredEvent.Data.builder()
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
                        .delivery(
                            DeliveryDetail.builder()
                                .deliveredAt("delivered_at")
                                .addRecipient("string")
                                .remoteMtaIp("remote_mta_ip")
                                .reportingMta("reporting_mta")
                                .smtpResponse("smtp_response")
                                .processingTime(0.0)
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedEmailDeliveredEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailDeliveredEvent),
                jacksonTypeRef<EmailDeliveredEvent>(),
            )

        assertThat(roundtrippedEmailDeliveredEvent).isEqualTo(emailDeliveredEvent)
    }
}
