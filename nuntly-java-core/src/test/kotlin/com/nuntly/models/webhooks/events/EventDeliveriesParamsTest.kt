// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks.events

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventDeliveriesParamsTest {

    @Test
    fun create() {
        EventDeliveriesParams.builder().id("id").eventId("event_id").build()
    }

    @Test
    fun pathParams() {
        val params = EventDeliveriesParams.builder().id("id").eventId("event_id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("event_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
