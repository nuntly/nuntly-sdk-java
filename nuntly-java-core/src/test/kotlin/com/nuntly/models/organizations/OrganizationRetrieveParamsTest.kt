// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationRetrieveParamsTest {

    @Test
    fun create() {
        OrganizationRetrieveParams.builder().id("org_9UTZz2PisZ68YwE3NJu9urQ9").build()
    }

    @Test
    fun pathParams() {
        val params = OrganizationRetrieveParams.builder().id("org_9UTZz2PisZ68YwE3NJu9urQ9").build()

        assertThat(params._pathParam(0)).isEqualTo("org_9UTZz2PisZ68YwE3NJu9urQ9")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
