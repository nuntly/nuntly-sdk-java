// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventRetryResponseTest {

    @Test
    fun create() {
        val eventRetryResponse = EventRetryResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventRetryResponse = EventRetryResponse.builder().build()

        val roundtrippedEventRetryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventRetryResponse),
                jacksonTypeRef<EventRetryResponse>(),
            )

        assertThat(roundtrippedEventRetryResponse).isEqualTo(eventRetryResponse)
    }
}
