// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailQueuedEventTest {

    @Test
    fun create() {
        val emailQueuedEvent =
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

        assertThat(emailQueuedEvent.id()).isEqualTo("id")
        assertThat(emailQueuedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailQueuedEvent.data())
            .isEqualTo(
                EmailQueuedEvent.Data.builder().queue(JsonValue.from(mapOf<String, Any>())).build()
            )
        assertThat(emailQueuedEvent.type()).isEqualTo(EmailQueuedEvent.Type.EMAIL_QUEUED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailQueuedEvent =
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

        val roundtrippedEmailQueuedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailQueuedEvent),
                jacksonTypeRef<EmailQueuedEvent>(),
            )

        assertThat(roundtrippedEmailQueuedEvent).isEqualTo(emailQueuedEvent)
    }
}
