// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.events

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListParamsTest {

    @Test
    fun create() {
        EventListParams.builder().id("em_01ka8k8s80gvx9604cn9am5st4").build()
    }

    @Test
    fun pathParams() {
        val params = EventListParams.builder().id("em_01ka8k8s80gvx9604cn9am5st4").build()

        assertThat(params._pathParam(0)).isEqualTo("em_01ka8k8s80gvx9604cn9am5st4")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
