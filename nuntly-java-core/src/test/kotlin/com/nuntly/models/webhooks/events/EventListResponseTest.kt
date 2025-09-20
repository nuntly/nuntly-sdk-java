// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import com.nuntly.models.shared.SendDetail
import com.nuntly.models.webhooks.BaseEvent
import com.nuntly.models.webhooks.EmailSentEvent
import com.nuntly.models.webhooks.Event
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListResponseTest {

    @Test
    fun create() {
        val eventListResponse =
            EventListResponse.builder()
                .id("id")
                .data(
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
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(listOf("string")),
                                        )
                                        .build()
                                )
                                .send(SendDetail.builder().build())
                                .build()
                        )
                        .build()
                )
                .event(EventType.EMAIL_SENT)
                .orgId("org_id")
                .receivedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(EventListResponse.Status.SUCCESS)
                .webhookId("webhook_id")
                .build()

        assertThat(eventListResponse.id()).isEqualTo("id")
        assertThat(eventListResponse.data())
            .isEqualTo(
                Event.ofEmailSent(
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
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(listOf("string")),
                                        )
                                        .build()
                                )
                                .send(SendDetail.builder().build())
                                .build()
                        )
                        .build()
                )
            )
        assertThat(eventListResponse.event()).isEqualTo(EventType.EMAIL_SENT)
        assertThat(eventListResponse.orgId()).isEqualTo("org_id")
        assertThat(eventListResponse.receivedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(eventListResponse.status()).isEqualTo(EventListResponse.Status.SUCCESS)
        assertThat(eventListResponse.webhookId()).isEqualTo("webhook_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventListResponse =
            EventListResponse.builder()
                .id("id")
                .data(
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
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(listOf("string")),
                                        )
                                        .build()
                                )
                                .send(SendDetail.builder().build())
                                .build()
                        )
                        .build()
                )
                .event(EventType.EMAIL_SENT)
                .orgId("org_id")
                .receivedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(EventListResponse.Status.SUCCESS)
                .webhookId("webhook_id")
                .build()

        val roundtrippedEventListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListResponse),
                jacksonTypeRef<EventListResponse>(),
            )

        assertThat(roundtrippedEventListResponse).isEqualTo(eventListResponse)
    }
}
