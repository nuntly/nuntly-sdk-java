// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.memberships

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MembershipRevokeParamsTest {

    @Test
    fun create() {
        MembershipRevokeParams.builder().id("id").userId("user_id").build()
    }

    @Test
    fun pathParams() {
        val params = MembershipRevokeParams.builder().id("id").userId("user_id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
