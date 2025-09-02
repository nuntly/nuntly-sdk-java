// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.memberships

import com.nuntly.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MembershipListParamsTest {

    @Test
    fun create() {
        MembershipListParams.builder().id("id").cursor("cursor").limit(1.0).build()
    }

    @Test
    fun pathParams() {
        val params = MembershipListParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params = MembershipListParams.builder().id("id").cursor("cursor").limit(1.0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("cursor", "cursor").put("limit", "1.0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MembershipListParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
