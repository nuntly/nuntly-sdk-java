// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailDeliveryDelayedEventTest {

    @Test
    fun create() {
        val emailDeliveryDelayedEvent =
            EmailDeliveryDelayedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailDeliveryDelayedEvent.Data.builder()
                        .id("id")
                        .deliveryDelay(
                            EmailDeliveryDelayedEvent.Data.DeliveryDelay.builder()
                                .delayedAt("delayedAt")
                                .addDelayedRecipient(
                                    EmailDeliveryDelayedEvent.Data.DeliveryDelay.DelayedRecipient
                                        .builder()
                                        .email("email")
                                        .diagnosticCode("diagnosticCode")
                                        .status("status")
                                        .build()
                                )
                                .delayType(
                                    EmailDeliveryDelayedEvent.Data.DeliveryDelay.DelayType
                                        .INTERNAL_FAILURE
                                )
                                .deliveryStoppedAt("deliveryStoppedAt")
                                .reportingMta("reportingMta")
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
                            EmailDeliveryDelayedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailDeliveryDelayedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailDeliveryDelayedEvent.Type.EMAIL_DELIVERY_DELAYED)
                .build()

        assertThat(emailDeliveryDelayedEvent.id()).isEqualTo("id")
        assertThat(emailDeliveryDelayedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailDeliveryDelayedEvent.data())
            .isEqualTo(
                EmailDeliveryDelayedEvent.Data.builder()
                    .id("id")
                    .deliveryDelay(
                        EmailDeliveryDelayedEvent.Data.DeliveryDelay.builder()
                            .delayedAt("delayedAt")
                            .addDelayedRecipient(
                                EmailDeliveryDelayedEvent.Data.DeliveryDelay.DelayedRecipient
                                    .builder()
                                    .email("email")
                                    .diagnosticCode("diagnosticCode")
                                    .status("status")
                                    .build()
                            )
                            .delayType(
                                EmailDeliveryDelayedEvent.Data.DeliveryDelay.DelayType
                                    .INTERNAL_FAILURE
                            )
                            .deliveryStoppedAt("deliveryStoppedAt")
                            .reportingMta("reportingMta")
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
                        EmailDeliveryDelayedEvent.Data.Header.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailDeliveryDelayedEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailDeliveryDelayedEvent.type())
            .isEqualTo(EmailDeliveryDelayedEvent.Type.EMAIL_DELIVERY_DELAYED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailDeliveryDelayedEvent =
            EmailDeliveryDelayedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailDeliveryDelayedEvent.Data.builder()
                        .id("id")
                        .deliveryDelay(
                            EmailDeliveryDelayedEvent.Data.DeliveryDelay.builder()
                                .delayedAt("delayedAt")
                                .addDelayedRecipient(
                                    EmailDeliveryDelayedEvent.Data.DeliveryDelay.DelayedRecipient
                                        .builder()
                                        .email("email")
                                        .diagnosticCode("diagnosticCode")
                                        .status("status")
                                        .build()
                                )
                                .delayType(
                                    EmailDeliveryDelayedEvent.Data.DeliveryDelay.DelayType
                                        .INTERNAL_FAILURE
                                )
                                .deliveryStoppedAt("deliveryStoppedAt")
                                .reportingMta("reportingMta")
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
                            EmailDeliveryDelayedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailDeliveryDelayedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailDeliveryDelayedEvent.Type.EMAIL_DELIVERY_DELAYED)
                .build()

        val roundtrippedEmailDeliveryDelayedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailDeliveryDelayedEvent),
                jacksonTypeRef<EmailDeliveryDelayedEvent>(),
            )

        assertThat(roundtrippedEmailDeliveryDelayedEvent).isEqualTo(emailDeliveryDelayedEvent)
    }
}
