// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.account

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountUpdateParamsTest {

    @Test
    fun create() {
        AccountUpdateParams.builder().displayName("Ray Tomlinson").build()
    }

    @Test
    fun body() {
        val params = AccountUpdateParams.builder().displayName("Ray Tomlinson").build()

        val body = params._body()

        assertThat(body.displayName()).isEqualTo("Ray Tomlinson")
    }
}
