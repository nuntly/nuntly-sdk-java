// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailProcessedEventTest {

    @Test
    fun create() {
        val emailProcessedEvent =
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

        assertThat(emailProcessedEvent.id()).isEqualTo("id")
        assertThat(emailProcessedEvent.createdAt()).isEqualTo("createdAt")
        assertThat(emailProcessedEvent.data())
            .isEqualTo(
                EmailProcessedEvent.Data.builder()
                    .processed(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
        assertThat(emailProcessedEvent.type()).isEqualTo(EmailProcessedEvent.Type.EMAIL_PROCESSED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailProcessedEvent =
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

        val roundtrippedEmailProcessedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailProcessedEvent),
                jacksonTypeRef<EmailProcessedEvent>(),
            )

        assertThat(roundtrippedEmailProcessedEvent).isEqualTo(emailProcessedEvent)
    }
}
