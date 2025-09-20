// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaseEventTest {

    @Test
    fun create() {
        val baseEvent =
            BaseEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_SENT)
                .kind(BaseEvent.Kind.EVENT)
                .build()

        assertThat(baseEvent.id()).isEqualTo("id")
        assertThat(baseEvent.createdAt()).isEqualTo("created_at")
        assertThat(baseEvent.type()).isEqualTo(EventType.EMAIL_SENT)
        assertThat(baseEvent.kind()).contains(BaseEvent.Kind.EVENT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val baseEvent =
            BaseEvent.builder()
                .id("id")
                .createdAt("created_at")
                .type(EventType.EMAIL_SENT)
                .kind(BaseEvent.Kind.EVENT)
                .build()

        val roundtrippedBaseEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(baseEvent),
                jacksonTypeRef<BaseEvent>(),
            )

        assertThat(roundtrippedBaseEvent).isEqualTo(baseEvent)
    }
}
