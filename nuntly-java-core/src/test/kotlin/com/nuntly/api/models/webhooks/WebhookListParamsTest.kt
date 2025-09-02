// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.webhooks

import com.nuntly.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListParamsTest {

    @Test
    fun create() {
        WebhookListParams.builder().cursor("cursor").limit(1.0).build()
    }

    @Test
    fun queryParams() {
        val params = WebhookListParams.builder().cursor("cursor").limit(1.0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("cursor", "cursor").put("limit", "1.0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = WebhookListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
