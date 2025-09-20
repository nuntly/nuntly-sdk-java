// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventDeliveriesResponseTest {

    @Test
    fun create() {
        val eventDeliveriesResponse =
            EventDeliveriesResponse.builder()
                .id("id")
                .code("code")
                .deliveredAt("delivered_at")
                .response(
                    EventDeliveriesResponse.Response.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .status(EventDeliveriesResponse.Status.PENDING)
                .build()

        assertThat(eventDeliveriesResponse.id()).isEqualTo("id")
        assertThat(eventDeliveriesResponse.code()).isEqualTo("code")
        assertThat(eventDeliveriesResponse.deliveredAt()).isEqualTo("delivered_at")
        assertThat(eventDeliveriesResponse.response())
            .contains(
                EventDeliveriesResponse.Response.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(eventDeliveriesResponse.status())
            .isEqualTo(EventDeliveriesResponse.Status.PENDING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventDeliveriesResponse =
            EventDeliveriesResponse.builder()
                .id("id")
                .code("code")
                .deliveredAt("delivered_at")
                .response(
                    EventDeliveriesResponse.Response.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .status(EventDeliveriesResponse.Status.PENDING)
                .build()

        val roundtrippedEventDeliveriesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventDeliveriesResponse),
                jacksonTypeRef<EventDeliveriesResponse>(),
            )

        assertThat(roundtrippedEventDeliveriesResponse).isEqualTo(eventDeliveriesResponse)
    }
}
