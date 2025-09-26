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
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListPageResponseTest {

    @Test
    fun create() {
        val eventListPageResponse =
            EventListPageResponse.builder()
                .addData(
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
                                            EmailEvent.Header.builder()
                                                .name("name")
                                                .value("value")
                                                .build()
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
                        .event(EventType.EMAIL_DELIVERED)
                        .orgId("org_id")
                        .receivedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(EventListResponse.Status.SUCCESS)
                        .webhookId("webhook_id")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(eventListPageResponse.data().getOrNull())
            .containsExactly(
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
                                        EmailEvent.Header.builder()
                                            .name("name")
                                            .value("value")
                                            .build()
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
                    .event(EventType.EMAIL_DELIVERED)
                    .orgId("org_id")
                    .receivedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(EventListResponse.Status.SUCCESS)
                    .webhookId("webhook_id")
                    .build()
            )
        assertThat(eventListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventListPageResponse =
            EventListPageResponse.builder()
                .addData(
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
                                            EmailEvent.Header.builder()
                                                .name("name")
                                                .value("value")
                                                .build()
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
                        .event(EventType.EMAIL_DELIVERED)
                        .orgId("org_id")
                        .receivedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(EventListResponse.Status.SUCCESS)
                        .webhookId("webhook_id")
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedEventListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListPageResponse),
                jacksonTypeRef<EventListPageResponse>(),
            )

        assertThat(roundtrippedEventListPageResponse).isEqualTo(eventListPageResponse)
    }
}
