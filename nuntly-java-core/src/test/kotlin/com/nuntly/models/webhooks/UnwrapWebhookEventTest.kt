// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.errors.NuntlyInvalidDataException
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class UnwrapWebhookEventTest {

    @Test
    fun ofEmailQueued() {
        val emailQueued =
            EmailQueuedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailQueuedEvent.Data.builder()
                        .queue(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .type(EmailQueuedEvent.Type.EMAIL_QUEUED)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailQueued(emailQueued)

        assertThat(unwrapWebhookEvent.emailQueued()).contains(emailQueued)
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailQueuedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailQueued(
                EmailQueuedEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailQueuedEvent.Data.builder()
                            .queue(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                    .type(EmailQueuedEvent.Type.EMAIL_QUEUED)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailScheduled() {
        val emailScheduled =
            EmailScheduledEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailScheduledEvent.Data.builder()
                        .schedule(
                            EmailScheduledEvent.Data.Schedule.builder()
                                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .build()
                )
                .type(EmailScheduledEvent.Type.EMAIL_SCHEDULED)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailScheduled(emailScheduled)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).contains(emailScheduled)
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailScheduledRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailScheduled(
                EmailScheduledEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailScheduledEvent.Data.builder()
                            .schedule(
                                EmailScheduledEvent.Data.Schedule.builder()
                                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .build()
                            )
                            .build()
                    )
                    .type(EmailScheduledEvent.Type.EMAIL_SCHEDULED)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailProcessed() {
        val emailProcessed =
            EmailProcessedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailProcessedEvent.Data.builder()
                        .processed(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .type(EmailProcessedEvent.Type.EMAIL_PROCESSED)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailProcessed(emailProcessed)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).contains(emailProcessed)
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailProcessedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailProcessed(
                EmailProcessedEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailProcessedEvent.Data.builder()
                            .processed(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                    .type(EmailProcessedEvent.Type.EMAIL_PROCESSED)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailSending() {
        val emailSending =
            EmailSendingEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailSendingEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .sending(JsonValue.from(mapOf<String, Any>()))
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailSendingEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailSendingEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailSendingEvent.Type.EMAIL_SENDING)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailSending(emailSending)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).contains(emailSending)
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailSendingRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailSending(
                EmailSendingEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailSendingEvent.Data.builder()
                            .id("id")
                            .domainId("domainId")
                            .domainName("domainName")
                            .enqueuedAt("enqueuedAt")
                            .from("from")
                            .messageId("messageId")
                            .orgId("orgId")
                            .sending(JsonValue.from(mapOf<String, Any>()))
                            .sentAt("sentAt")
                            .subject("subject")
                            .to("string")
                            .bcc("string")
                            .bulkId("bulkId")
                            .cc("string")
                            .addHeader(
                                EmailSendingEvent.Data.Header.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailSendingEvent.Data.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .build()
                    )
                    .type(EmailSendingEvent.Type.EMAIL_SENDING)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailSent() {
        val emailSent =
            EmailSentEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailSentEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .orgId("orgId")
                        .send(JsonValue.from(mapOf<String, Any>()))
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailSentEvent.Data.Header.builder().name("name").value("value").build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailSentEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailSentEvent.Type.EMAIL_SENT)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailSent(emailSent)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).contains(emailSent)
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailSentRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailSent(
                EmailSentEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailSentEvent.Data.builder()
                            .id("id")
                            .domainId("domainId")
                            .domainName("domainName")
                            .enqueuedAt("enqueuedAt")
                            .from("from")
                            .messageId("messageId")
                            .orgId("orgId")
                            .send(JsonValue.from(mapOf<String, Any>()))
                            .sentAt("sentAt")
                            .subject("subject")
                            .to("string")
                            .bcc("string")
                            .bulkId("bulkId")
                            .cc("string")
                            .addHeader(
                                EmailSentEvent.Data.Header.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailSentEvent.Data.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .build()
                    )
                    .type(EmailSentEvent.Type.EMAIL_SENT)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailDelivered() {
        val emailDelivered =
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailDelivered(emailDelivered)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).contains(emailDelivered)
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailDeliveredRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailDelivered(
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
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailOpened() {
        val emailOpened =
            EmailOpenedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailOpenedEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .messageId("messageId")
                        .open(
                            EmailOpenedEvent.Data.Open.builder()
                                .openedAt("openedAt")
                                .userAgent("userAgent")
                                .build()
                        )
                        .orgId("orgId")
                        .sentAt("sentAt")
                        .subject("subject")
                        .to("string")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .addHeader(
                            EmailOpenedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailOpenedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailOpenedEvent.Type.EMAIL_OPENED)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailOpened(emailOpened)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).contains(emailOpened)
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailOpenedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailOpened(
                EmailOpenedEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailOpenedEvent.Data.builder()
                            .id("id")
                            .domainId("domainId")
                            .domainName("domainName")
                            .enqueuedAt("enqueuedAt")
                            .from("from")
                            .messageId("messageId")
                            .open(
                                EmailOpenedEvent.Data.Open.builder()
                                    .openedAt("openedAt")
                                    .userAgent("userAgent")
                                    .build()
                            )
                            .orgId("orgId")
                            .sentAt("sentAt")
                            .subject("subject")
                            .to("string")
                            .bcc("string")
                            .bulkId("bulkId")
                            .cc("string")
                            .addHeader(
                                EmailOpenedEvent.Data.Header.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailOpenedEvent.Data.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .build()
                    )
                    .type(EmailOpenedEvent.Type.EMAIL_OPENED)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailClicked() {
        val emailClicked =
            EmailClickedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailClickedEvent.Data.builder()
                        .id("id")
                        .click(
                            EmailClickedEvent.Data.Click.builder()
                                .clickedAt("clickedAt")
                                .link("link")
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
                            EmailClickedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailClickedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .type(EmailClickedEvent.Type.EMAIL_CLICKED)
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailClicked(emailClicked)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).contains(emailClicked)
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailClickedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailClicked(
                EmailClickedEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailClickedEvent.Data.builder()
                            .id("id")
                            .click(
                                EmailClickedEvent.Data.Click.builder()
                                    .clickedAt("clickedAt")
                                    .link("link")
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
                                EmailClickedEvent.Data.Header.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailClickedEvent.Data.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .build()
                    )
                    .type(EmailClickedEvent.Type.EMAIL_CLICKED)
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailBounced() {
        val emailBounced =
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailBounced(emailBounced)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).contains(emailBounced)
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailBouncedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailBounced(
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
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailComplained() {
        val emailComplained =
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailComplained(emailComplained)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).contains(emailComplained)
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailComplainedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailComplained(
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
                                        EmailComplainedEvent.Data.Complaint.ComplaintFeedbackType
                                            .ABUSE
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
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailRejected() {
        val emailRejected =
            EmailRejectedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailRejectedEvent.Data.builder()
                        .reject(EmailRejectedEvent.Data.Reject.builder().reason("reason").build())
                        .id("id")
                        .bcc("string")
                        .bulkId("bulkId")
                        .cc("string")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .from("from")
                        .addHeader(
                            EmailRejectedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .messageId("messageId")
                        .orgId("orgId")
                        .replyTo("string")
                        .sentAt("sentAt")
                        .subject("subject")
                        .tags(
                            EmailRejectedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .to("string")
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailRejected(emailRejected)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).contains(emailRejected)
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailRejectedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailRejected(
                EmailRejectedEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailRejectedEvent.Data.builder()
                            .reject(
                                EmailRejectedEvent.Data.Reject.builder().reason("reason").build()
                            )
                            .id("id")
                            .bcc("string")
                            .bulkId("bulkId")
                            .cc("string")
                            .domainId("domainId")
                            .domainName("domainName")
                            .enqueuedAt("enqueuedAt")
                            .from("from")
                            .addHeader(
                                EmailRejectedEvent.Data.Header.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .messageId("messageId")
                            .orgId("orgId")
                            .replyTo("string")
                            .sentAt("sentAt")
                            .subject("subject")
                            .tags(
                                EmailRejectedEvent.Data.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .to("string")
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailDeliveryDelayed() {
        val emailDeliveryDelayed =
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailDeliveryDelayed(emailDeliveryDelayed)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).contains(emailDeliveryDelayed)
        assertThat(unwrapWebhookEvent.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailDeliveryDelayedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailDeliveryDelayed(
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
                                        EmailDeliveryDelayedEvent.Data.DeliveryDelay
                                            .DelayedRecipient
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
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    @Test
    fun ofEmailFailed() {
        val emailFailed =
            EmailFailedEvent.builder()
                .id("id")
                .createdAt("createdAt")
                .data(
                    EmailFailedEvent.Data.builder()
                        .id("id")
                        .domainId("domainId")
                        .domainName("domainName")
                        .enqueuedAt("enqueuedAt")
                        .failure(
                            EmailFailedEvent.Data.Failure.builder()
                                .error(JsonValue.from(mapOf<String, Any>()))
                                .build()
                        )
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
                            EmailFailedEvent.Data.Header.builder()
                                .name("name")
                                .value("value")
                                .build()
                        )
                        .replyTo("string")
                        .tags(
                            EmailFailedEvent.Data.Tags.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailFailed(emailFailed)

        assertThat(unwrapWebhookEvent.emailQueued()).isEmpty
        assertThat(unwrapWebhookEvent.emailScheduled()).isEmpty
        assertThat(unwrapWebhookEvent.emailProcessed()).isEmpty
        assertThat(unwrapWebhookEvent.emailSending()).isEmpty
        assertThat(unwrapWebhookEvent.emailSent()).isEmpty
        assertThat(unwrapWebhookEvent.emailDelivered()).isEmpty
        assertThat(unwrapWebhookEvent.emailOpened()).isEmpty
        assertThat(unwrapWebhookEvent.emailClicked()).isEmpty
        assertThat(unwrapWebhookEvent.emailBounced()).isEmpty
        assertThat(unwrapWebhookEvent.emailComplained()).isEmpty
        assertThat(unwrapWebhookEvent.emailRejected()).isEmpty
        assertThat(unwrapWebhookEvent.emailDeliveryDelayed()).isEmpty
        assertThat(unwrapWebhookEvent.emailFailed()).contains(emailFailed)
    }

    @Test
    fun ofEmailFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val unwrapWebhookEvent =
            UnwrapWebhookEvent.ofEmailFailed(
                EmailFailedEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailFailedEvent.Data.builder()
                            .id("id")
                            .domainId("domainId")
                            .domainName("domainName")
                            .enqueuedAt("enqueuedAt")
                            .failure(
                                EmailFailedEvent.Data.Failure.builder()
                                    .error(JsonValue.from(mapOf<String, Any>()))
                                    .build()
                            )
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
                                EmailFailedEvent.Data.Header.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailFailedEvent.Data.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedUnwrapWebhookEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(unwrapWebhookEvent),
                jacksonTypeRef<UnwrapWebhookEvent>(),
            )

        assertThat(roundtrippedUnwrapWebhookEvent).isEqualTo(unwrapWebhookEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val unwrapWebhookEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<UnwrapWebhookEvent>())

        val e = assertThrows<NuntlyInvalidDataException> { unwrapWebhookEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
