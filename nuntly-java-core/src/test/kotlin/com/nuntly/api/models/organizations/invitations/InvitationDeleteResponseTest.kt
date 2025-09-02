// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.invitations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvitationDeleteResponseTest {

    @Test
    fun create() {
        val invitationDeleteResponse =
            InvitationDeleteResponse.builder()
                .id("org_01jh6jk82zjq9deye73h0mzcaq")
                .invitationId("invit_01jnxn8wd3gvcr98yscpctd9vw")
                .kind(InvitationDeleteResponse.Kind.INVITATION)
                .build()

        assertThat(invitationDeleteResponse.id()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(invitationDeleteResponse.invitationId())
            .isEqualTo("invit_01jnxn8wd3gvcr98yscpctd9vw")
        assertThat(invitationDeleteResponse.kind())
            .isEqualTo(InvitationDeleteResponse.Kind.INVITATION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invitationDeleteResponse =
            InvitationDeleteResponse.builder()
                .id("org_01jh6jk82zjq9deye73h0mzcaq")
                .invitationId("invit_01jnxn8wd3gvcr98yscpctd9vw")
                .kind(InvitationDeleteResponse.Kind.INVITATION)
                .build()

        val roundtrippedInvitationDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invitationDeleteResponse),
                jacksonTypeRef<InvitationDeleteResponse>(),
            )

        assertThat(roundtrippedInvitationDeleteResponse).isEqualTo(invitationDeleteResponse)
    }
}
