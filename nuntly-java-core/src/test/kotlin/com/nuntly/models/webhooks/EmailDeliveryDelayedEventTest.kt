// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.DeliveryDelayDetail
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailDeliveryDelayedEventTest {

    @Test
    fun create() {
        val emailDeliveryDelayedEvent =
            EmailDeliveryDelayedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_DELIVERY_DELAYED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailDeliveryDelayedEvent.Data.builder()
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
                        .deliveryDelay(
                            DeliveryDelayDetail.builder()
                                .delayType("delay_type")
                                .delayedAt("delayed_at")
                                .addDelayedRecipient(
                                    DeliveryDelayDetail.DelayedRecipient.builder()
                                        .email("email")
                                        .diagnosticCode("diagnostic_code")
                                        .status("status")
                                        .build()
                                )
                                .deliveryStoppedAt("delivery_stopped_at")
                                .reportingMta("reporting_mta")
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(emailDeliveryDelayedEvent.id()).isEqualTo("id")
        assertThat(emailDeliveryDelayedEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailDeliveryDelayedEvent.type()).isEqualTo(EventType.EMAIL_DELIVERY_DELAYED)
        assertThat(emailDeliveryDelayedEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailDeliveryDelayedEvent.data())
            .isEqualTo(
                EmailDeliveryDelayedEvent.Data.builder()
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
                    .deliveryDelay(
                        DeliveryDelayDetail.builder()
                            .delayType("delay_type")
                            .delayedAt("delayed_at")
                            .addDelayedRecipient(
                                DeliveryDelayDetail.DelayedRecipient.builder()
                                    .email("email")
                                    .diagnosticCode("diagnostic_code")
                                    .status("status")
                                    .build()
                            )
                            .deliveryStoppedAt("delivery_stopped_at")
                            .reportingMta("reporting_mta")
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailDeliveryDelayedEvent =
            EmailDeliveryDelayedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_DELIVERY_DELAYED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailDeliveryDelayedEvent.Data.builder()
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
                        .deliveryDelay(
                            DeliveryDelayDetail.builder()
                                .delayType("delay_type")
                                .delayedAt("delayed_at")
                                .addDelayedRecipient(
                                    DeliveryDelayDetail.DelayedRecipient.builder()
                                        .email("email")
                                        .diagnosticCode("diagnostic_code")
                                        .status("status")
                                        .build()
                                )
                                .deliveryStoppedAt("delivery_stopped_at")
                                .reportingMta("reporting_mta")
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedEmailDeliveryDelayedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailDeliveryDelayedEvent),
                jacksonTypeRef<EmailDeliveryDelayedEvent>(),
            )

        assertThat(roundtrippedEmailDeliveryDelayedEvent).isEqualTo(emailDeliveryDelayedEvent)
    }
}
