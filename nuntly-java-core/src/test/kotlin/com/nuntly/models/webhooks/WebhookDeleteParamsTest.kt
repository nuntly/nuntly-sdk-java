// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookDeleteParamsTest {

    @Test
    fun create() {
        WebhookDeleteParams.builder().id("wh_YNtYn86oYZmP1ZHbnUBvXXFt").build()
    }

    @Test
    fun pathParams() {
        val params = WebhookDeleteParams.builder().id("wh_YNtYn86oYZmP1ZHbnUBvXXFt").build()

        assertThat(params._pathParam(0)).isEqualTo("wh_YNtYn86oYZmP1ZHbnUBvXXFt")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
