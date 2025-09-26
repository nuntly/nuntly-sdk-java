// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventReplayParamsTest {

    @Test
    fun create() {
        EventReplayParams.builder().id("wh_YNtYn86oYZmP1ZHbnUBvXXFt").eventId("event_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            EventReplayParams.builder()
                .id("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
                .eventId("event_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
        assertThat(params._pathParam(1)).isEqualTo("event_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
