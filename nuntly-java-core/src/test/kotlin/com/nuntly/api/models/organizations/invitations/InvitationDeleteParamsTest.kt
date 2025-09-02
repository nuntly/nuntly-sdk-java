// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.invitations

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvitationDeleteParamsTest {

    @Test
    fun create() {
        InvitationDeleteParams.builder().id("id").invitationId("invitation_id").build()
    }

    @Test
    fun pathParams() {
        val params = InvitationDeleteParams.builder().id("id").invitationId("invitation_id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("invitation_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
