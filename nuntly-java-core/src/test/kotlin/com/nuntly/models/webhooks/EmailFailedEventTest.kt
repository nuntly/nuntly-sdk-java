// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import com.nuntly.models.shared.FailureDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailFailedEventTest {

    @Test
    fun create() {
        val emailFailedEvent =
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

        assertThat(emailFailedEvent.id()).isEqualTo("id")
        assertThat(emailFailedEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailFailedEvent.type()).isEqualTo(EventType.EMAIL_FAILED)
        assertThat(emailFailedEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailFailedEvent.data())
            .isEqualTo(
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
                        FailureDetail.builder().error(JsonValue.from(mapOf<String, Any>())).build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailFailedEvent =
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

        val roundtrippedEmailFailedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailFailedEvent),
                jacksonTypeRef<EmailFailedEvent>(),
            )

        assertThat(roundtrippedEmailFailedEvent).isEqualTo(emailFailedEvent)
    }
}
