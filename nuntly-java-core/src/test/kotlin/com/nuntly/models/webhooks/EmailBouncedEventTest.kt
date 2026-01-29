// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailBouncedEventTest {

    @Test
    fun create() {
        val emailBouncedEvent =
            EmailBouncedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailBouncedEvent.Data.builder()
                        .id("id")
                        .bounce(
                            EmailBouncedEvent.Data.Bounce.builder()
                                .bouncedAt("bouncedAt")
                                .addBouncedRecipient(
                                    EmailBouncedEvent.Data.Bounce.BouncedRecipient.builder()
                                        .email("email")
                                        .action("action")
                                        .diagnosticCode("diagnosticCode")
                                        .status("status")
                                        .build()
                                )
                                .bounceSubType(
                                    EmailBouncedEvent.Data.Bounce.BounceSubType.UNDETERMINED
                                )
                                .bounceType(EmailBouncedEvent.Data.Bounce.BounceType.PERMANENT)
                                .feedbackId("feedbackId")
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
                            EmailBouncedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailBouncedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailBouncedEvent.Type.EMAIL_BOUNCED)
                .build()

        assertThat(emailBouncedEvent.id()).isEqualTo("id")
        assertThat(emailBouncedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailBouncedEvent.data())
            .isEqualTo(
                EmailBouncedEvent.Data.builder()
                    .id("id")
                    .bounce(
                        EmailBouncedEvent.Data.Bounce.builder()
                            .bouncedAt("bouncedAt")
                            .addBouncedRecipient(
                                EmailBouncedEvent.Data.Bounce.BouncedRecipient.builder()
                                    .email("email")
                                    .action("action")
                                    .diagnosticCode("diagnosticCode")
                                    .status("status")
                                    .build()
                            )
                            .bounceSubType(EmailBouncedEvent.Data.Bounce.BounceSubType.UNDETERMINED)
                            .bounceType(EmailBouncedEvent.Data.Bounce.BounceType.PERMANENT)
                            .feedbackId("feedbackId")
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
                        EmailBouncedEvent.Data.Header.builder().name("name").value("value").build()
                    )
                    .replyTo("string")
                    .tags(
                        EmailBouncedEvent.Data.Tags.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .build()
            )
        assertThat(emailBouncedEvent.type()).isEqualTo(EmailBouncedEvent.Type.EMAIL_BOUNCED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailBouncedEvent =
            EmailBouncedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailBouncedEvent.Data.builder()
                        .id("id")
                        .bounce(
                            EmailBouncedEvent.Data.Bounce.builder()
                                .bouncedAt("bouncedAt")
                                .addBouncedRecipient(
                                    EmailBouncedEvent.Data.Bounce.BouncedRecipient.builder()
                                        .email("email")
                                        .action("action")
                                        .diagnosticCode("diagnosticCode")
                                        .status("status")
                                        .build()
                                )
                                .bounceSubType(
                                    EmailBouncedEvent.Data.Bounce.BounceSubType.UNDETERMINED
                                )
                                .bounceType(EmailBouncedEvent.Data.Bounce.BounceType.PERMANENT)
                                .feedbackId("feedbackId")
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
                            EmailBouncedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailBouncedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailBouncedEvent.Type.EMAIL_BOUNCED)
                .build()

        val roundtrippedEmailBouncedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailBouncedEvent),
                jacksonTypeRef<EmailBouncedEvent>(),
            )

        assertThat(roundtrippedEmailBouncedEvent).isEqualTo(emailBouncedEvent)
    }
}
