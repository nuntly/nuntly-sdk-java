// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.apikeys

import com.nuntly.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyListParamsTest {

    @Test
    fun create() {
        ApiKeyListParams.builder().cursor("cursor").limit(1.0).build()
    }

    @Test
    fun queryParams() {
        val params = ApiKeyListParams.builder().cursor("cursor").limit(1.0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("cursor", "cursor").put("limit", "1.0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ApiKeyListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
