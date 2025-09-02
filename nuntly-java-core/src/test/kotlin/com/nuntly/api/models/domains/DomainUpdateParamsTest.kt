// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainUpdateParamsTest {

    @Test
    fun create() {
        DomainUpdateParams.builder()
            .id("dns_FdfQe2eZAzRrHCXKSr7VsxUz")
            .clickTracking(true)
            .openTracking(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params = DomainUpdateParams.builder().id("dns_FdfQe2eZAzRrHCXKSr7VsxUz").build()

        assertThat(params._pathParam(0)).isEqualTo("dns_FdfQe2eZAzRrHCXKSr7VsxUz")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            DomainUpdateParams.builder()
                .id("dns_FdfQe2eZAzRrHCXKSr7VsxUz")
                .clickTracking(true)
                .openTracking(true)
                .build()

        val body = params._body()

        assertThat(body.clickTracking()).contains(true)
        assertThat(body.openTracking()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = DomainUpdateParams.builder().id("dns_FdfQe2eZAzRrHCXKSr7VsxUz").build()

        val body = params._body()
    }
}
