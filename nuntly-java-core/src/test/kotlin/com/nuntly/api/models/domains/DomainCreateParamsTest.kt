// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainCreateParamsTest {

    @Test
    fun create() {
        DomainCreateParams.builder()
            .name("acme.com")
            .region(DomainCreateParams.Region.EU_WEST_1)
            .build()
    }

    @Test
    fun body() {
        val params =
            DomainCreateParams.builder()
                .name("acme.com")
                .region(DomainCreateParams.Region.EU_WEST_1)
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("acme.com")
        assertThat(body.region()).isEqualTo(DomainCreateParams.Region.EU_WEST_1)
    }
}
