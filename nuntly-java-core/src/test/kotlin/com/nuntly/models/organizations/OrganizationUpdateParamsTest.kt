// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationUpdateParamsTest {

    @Test
    fun create() {
        OrganizationUpdateParams.builder()
            .id("org_9UTZz2PisZ68YwE3NJu9urQ9")
            .displayName("Ray Tomlinson org.")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrganizationUpdateParams.builder()
                .id("org_9UTZz2PisZ68YwE3NJu9urQ9")
                .displayName("Ray Tomlinson org.")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("org_9UTZz2PisZ68YwE3NJu9urQ9")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            OrganizationUpdateParams.builder()
                .id("org_9UTZz2PisZ68YwE3NJu9urQ9")
                .displayName("Ray Tomlinson org.")
                .build()

        val body = params._body()

        assertThat(body.displayName()).isEqualTo("Ray Tomlinson org.")
    }
}
