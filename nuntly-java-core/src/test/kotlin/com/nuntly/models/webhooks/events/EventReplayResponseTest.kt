// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventReplayResponseTest {

    @Test
    fun create() {
        val eventReplayResponse = EventReplayResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventReplayResponse = EventReplayResponse.builder().build()

        val roundtrippedEventReplayResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventReplayResponse),
                jacksonTypeRef<EventReplayResponse>(),
            )

        assertThat(roundtrippedEventReplayResponse).isEqualTo(eventReplayResponse)
    }
}
