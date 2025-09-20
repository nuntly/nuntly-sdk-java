// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.errors.NuntlyInvalidDataException
import com.nuntly.models.shared.BounceDetail
import com.nuntly.models.shared.ClickDetail
import com.nuntly.models.shared.ComplaintDetail
import com.nuntly.models.shared.DeliveryDelayDetail
import com.nuntly.models.shared.DeliveryDetail
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import com.nuntly.models.shared.FailureDetail
import com.nuntly.models.shared.OpenDetail
import com.nuntly.models.shared.RejectDetail
import com.nuntly.models.shared.SendDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class UnwrapWebhookEventTest {

    @Test
    fun ofEmailSent() {
        val emailSent =
            EmailSentEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_SENT)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailSentEvent.Data.builder()
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
                        .send(SendDetail.builder().build())
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailSent(emailSent)

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
                    .createdAt("created_at")
                    .type(EventType.EMAIL_SENT)
                    .kind(BaseEvent.Kind.EVENT)
                    .data(
                        EmailSentEvent.Data.builder()
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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailEvent.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .send(SendDetail.builder().build())
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
    fun ofEmailDelivered() {
        val emailDelivered =
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailDelivered(emailDelivered)

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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
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
                .createdAt("created_at")
                .type(EventType.EMAIL_OPENED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailOpenedEvent.Data.builder()
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
                        .open(
                            OpenDetail.builder()
                                .openedAt("opened_at")
                                .userAgent("user_agent")
                                .build()
                        )
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailOpened(emailOpened)

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
                    .createdAt("created_at")
                    .type(EventType.EMAIL_OPENED)
                    .kind(BaseEvent.Kind.EVENT)
                    .data(
                        EmailOpenedEvent.Data.builder()
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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailEvent.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .open(
                                OpenDetail.builder()
                                    .openedAt("opened_at")
                                    .userAgent("user_agent")
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

    @Test
    fun ofEmailClicked() {
        val emailClicked =
            EmailClickedEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_CLICKED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailClickedEvent.Data.builder()
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
                        .click(
                            ClickDetail.builder()
                                .clickedAt("clicked_at")
                                .link("link")
                                .userAgent("user_agent")
                                .build()
                        )
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailClicked(emailClicked)

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
                    .createdAt("created_at")
                    .type(EventType.EMAIL_CLICKED)
                    .kind(BaseEvent.Kind.EVENT)
                    .data(
                        EmailClickedEvent.Data.builder()
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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailEvent.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .click(
                                ClickDetail.builder()
                                    .clickedAt("clicked_at")
                                    .link("link")
                                    .userAgent("user_agent")
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

    @Test
    fun ofEmailBounced() {
        val emailBounced =
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailBounced(emailBounced)

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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailComplained(emailComplained)

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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
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
                .createdAt("created_at")
                .type(EventType.EMAIL_REJECTED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailRejectedEvent.Data.builder()
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
                        .reject(RejectDetail.builder().reason("reason").build())
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailRejected(emailRejected)

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
                    .createdAt("created_at")
                    .type(EventType.EMAIL_REJECTED)
                    .kind(BaseEvent.Kind.EVENT)
                    .data(
                        EmailRejectedEvent.Data.builder()
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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailEvent.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .reject(RejectDetail.builder().reason("reason").build())
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

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailDeliveryDelayed(emailDeliveryDelayed)

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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
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
                .createdAt("created_at")
                .type(EventType.EMAIL_FAILED)
                .kind(BaseEvent.Kind.EVENT)
                .data(
                    EmailFailedEvent.Data.builder()
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
                        .failure(
                            FailureDetail.builder()
                                .error(JsonValue.from(mapOf<String, Any>()))
                                .build()
                        )
                        .build()
                )
                .build()

        val unwrapWebhookEvent = UnwrapWebhookEvent.ofEmailFailed(emailFailed)

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
                    .createdAt("created_at")
                    .type(EventType.EMAIL_FAILED)
                    .kind(BaseEvent.Kind.EVENT)
                    .data(
                        EmailFailedEvent.Data.builder()
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
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailEvent.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .failure(
                                FailureDetail.builder()
                                    .error(JsonValue.from(mapOf<String, Any>()))
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
