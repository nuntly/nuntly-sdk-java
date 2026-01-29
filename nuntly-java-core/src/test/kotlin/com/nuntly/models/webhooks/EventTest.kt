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

internal class EventTest {

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

        val event = Event.ofEmailQueued(emailQueued)

        assertThat(event.emailQueued()).contains(emailQueued)
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailQueuedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailQueued(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailScheduled(emailScheduled)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).contains(emailScheduled)
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailScheduledRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailScheduled(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailProcessed(emailProcessed)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).contains(emailProcessed)
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailProcessedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailProcessed(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailSending(emailSending)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).contains(emailSending)
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailSendingRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailSending(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailSent(emailSent)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).contains(emailSent)
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailSentRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailSent(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailDelivered(emailDelivered)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).contains(emailDelivered)
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailDeliveredRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailDelivered(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailOpened(emailOpened)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).contains(emailOpened)
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailOpenedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailOpened(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailClicked(emailClicked)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).contains(emailClicked)
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailClickedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailClicked(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailBounced(emailBounced)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).contains(emailBounced)
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailBouncedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailBounced(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailComplained(emailComplained)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).contains(emailComplained)
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailComplainedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailComplained(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailRejected(emailRejected)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).contains(emailRejected)
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailRejectedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailRejected(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailDeliveryDelayed(emailDeliveryDelayed)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).contains(emailDeliveryDelayed)
        assertThat(event.emailFailed()).isEmpty
    }

    @Test
    fun ofEmailDeliveryDelayedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailDeliveryDelayed(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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

        val event = Event.ofEmailFailed(emailFailed)

        assertThat(event.emailQueued()).isEmpty
        assertThat(event.emailScheduled()).isEmpty
        assertThat(event.emailProcessed()).isEmpty
        assertThat(event.emailSending()).isEmpty
        assertThat(event.emailSent()).isEmpty
        assertThat(event.emailDelivered()).isEmpty
        assertThat(event.emailOpened()).isEmpty
        assertThat(event.emailClicked()).isEmpty
        assertThat(event.emailBounced()).isEmpty
        assertThat(event.emailComplained()).isEmpty
        assertThat(event.emailRejected()).isEmpty
        assertThat(event.emailDeliveryDelayed()).isEmpty
        assertThat(event.emailFailed()).contains(emailFailed)
    }

    @Test
    fun ofEmailFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailFailed(
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

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
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
        val event = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Event>())

        val e = assertThrows<NuntlyInvalidDataException> { event.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
