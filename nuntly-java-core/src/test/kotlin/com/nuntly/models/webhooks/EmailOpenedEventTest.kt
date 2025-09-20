// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import com.nuntly.models.shared.OpenDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailOpenedEventTest {

    @Test
    fun create() {
        val emailOpenedEvent =
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

        assertThat(emailOpenedEvent.id()).isEqualTo("id")
        assertThat(emailOpenedEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailOpenedEvent.type()).isEqualTo(EventType.EMAIL_OPENED)
        assertThat(emailOpenedEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailOpenedEvent.data())
            .isEqualTo(
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
                        OpenDetail.builder().openedAt("opened_at").userAgent("user_agent").build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailOpenedEvent =
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

        val roundtrippedEmailOpenedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailOpenedEvent),
                jacksonTypeRef<EmailOpenedEvent>(),
            )

        assertThat(roundtrippedEmailOpenedEvent).isEqualTo(emailOpenedEvent)
    }
}
