// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import com.nuntly.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainListParamsTest {

    @Test
    fun create() {
        DomainListParams.builder().cursor("cursor").limit(1.0).build()
    }

    @Test
    fun queryParams() {
        val params = DomainListParams.builder().cursor("cursor").limit(1.0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("cursor", "cursor").put("limit", "1.0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = DomainListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
