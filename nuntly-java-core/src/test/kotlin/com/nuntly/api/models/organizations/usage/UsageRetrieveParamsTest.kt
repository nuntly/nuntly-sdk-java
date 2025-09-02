// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.usage

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageRetrieveParamsTest {

    @Test
    fun create() {
        UsageRetrieveParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = UsageRetrieveParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
