// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.ClickDetail
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailClickedEventTest {

    @Test
    fun create() {
        val emailClickedEvent =
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

        assertThat(emailClickedEvent.id()).isEqualTo("id")
        assertThat(emailClickedEvent.createdAt()).isEqualTo("created_at")
        assertThat(emailClickedEvent.type()).isEqualTo(EventType.EMAIL_CLICKED)
        assertThat(emailClickedEvent.kind()).contains(BaseEvent.Kind.EVENT)
        assertThat(emailClickedEvent.data())
            .isEqualTo(
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailClickedEvent =
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

        val roundtrippedEmailClickedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailClickedEvent),
                jacksonTypeRef<EmailClickedEvent>(),
            )

        assertThat(roundtrippedEmailClickedEvent).isEqualTo(emailClickedEvent)
    }
}
