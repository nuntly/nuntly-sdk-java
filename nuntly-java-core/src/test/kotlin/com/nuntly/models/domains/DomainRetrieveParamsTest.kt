// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DomainRetrieveParamsTest {

    @Test
    fun create() {
        DomainRetrieveParams.builder().id("dns_FdfQe2eZAzRrHCXKSr7VsxUz").build()
    }

    @Test
    fun pathParams() {
        val params = DomainRetrieveParams.builder().id("dns_FdfQe2eZAzRrHCXKSr7VsxUz").build()

        assertThat(params._pathParam(0)).isEqualTo("dns_FdfQe2eZAzRrHCXKSr7VsxUz")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
