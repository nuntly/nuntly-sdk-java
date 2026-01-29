// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailDeliveredEventTest {

    @Test
    fun create() {
        val emailDeliveredEvent =
            EmailDeliveredEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailDeliveredEvent.Data.builder()
                        .id("id")
                        .delivery(
                            EmailDeliveredEvent.Data.Delivery.builder()
                                .deliveredAt("deliveredAt")
                                .addRecipient("string")
                                .remoteMtaIp("remoteMtaIp")
                                .reportingMta("reportingMta")
                                .smtpResponse("smtpResponse")
                                .processingTime(0.0)
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
                            EmailDeliveredEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailDeliveredEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailDeliveredEvent.Type.EMAIL_DELIVERED)
                .build()

        assertThat(emailDeliveredEvent.id()).isEqualTo("id")
        assertThat(emailDeliveredEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailDeliveredEvent.data())
            .isEqualTo(
                EmailDeliveredEvent.Data.builder()
                    .id("id")
                    .delivery(
                        EmailDeliveredEvent.Data.Delivery.builder()
                            .deliveredAt("deliveredAt")
                            .addRecipient("string")
                            .remoteMtaIp("remoteMtaIp")
                            .reportingMta("reportingMta")
                            .smtpResponse("smtpResponse")
                            .processingTime(0.0)
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
                        EmailDeliveredEvent.Data.Header.builder()
                            .name("name")
                            .value("value")
                            .build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailDeliveredEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailDeliveredEvent.type()).isEqualTo(EmailDeliveredEvent.Type.EMAIL_DELIVERED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailDeliveredEvent =
            EmailDeliveredEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailDeliveredEvent.Data.builder()
                        .id("id")
                        .delivery(
                            EmailDeliveredEvent.Data.Delivery.builder()
                                .deliveredAt("deliveredAt")
                                .addRecipient("string")
                                .remoteMtaIp("remoteMtaIp")
                                .reportingMta("reportingMta")
                                .smtpResponse("smtpResponse")
                                .processingTime(0.0)
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
                            EmailDeliveredEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailDeliveredEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailDeliveredEvent.Type.EMAIL_DELIVERED)
                .build()

        val roundtrippedEmailDeliveredEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailDeliveredEvent),
                jacksonTypeRef<EmailDeliveredEvent>(),
            )

        assertThat(roundtrippedEmailDeliveredEvent).isEqualTo(emailDeliveredEvent)
    }
}
