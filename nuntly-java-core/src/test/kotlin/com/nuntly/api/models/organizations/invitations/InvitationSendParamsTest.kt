// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.invitations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvitationSendParamsTest {

    @Test
    fun create() {
        InvitationSendParams.builder().id("id").email("sarah.connor@sky.net").build()
    }

    @Test
    fun pathParams() {
        val params = InvitationSendParams.builder().id("id").email("sarah.connor@sky.net").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = InvitationSendParams.builder().id("id").email("sarah.connor@sky.net").build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("sarah.connor@sky.net")
    }
}
