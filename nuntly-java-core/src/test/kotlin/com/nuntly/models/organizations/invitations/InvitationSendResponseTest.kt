// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.invitations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvitationSendResponseTest {

    @Test
    fun create() {
        val invitationSendResponse =
            InvitationSendResponse.builder()
                .id("invit_01jnxn8wd3gvcr98yscpctd9vw")
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .email("sarah.connor@sky.net")
                .invitationExpiredAt("2025-01-16T22:22:41.247Z")
                .inviterEmail("ray@info.tomlinson.ai")
                .kind(InvitationSendResponse.Kind.INVITATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(InvitationSendResponse.Region.EU_WEST_1)
                .status(InvitationSendResponse.Status.PENDING)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        assertThat(invitationSendResponse.id()).isEqualTo("invit_01jnxn8wd3gvcr98yscpctd9vw")
        assertThat(invitationSendResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
        assertThat(invitationSendResponse.email()).isEqualTo("sarah.connor@sky.net")
        assertThat(invitationSendResponse.invitationExpiredAt())
            .isEqualTo("2025-01-16T22:22:41.247Z")
        assertThat(invitationSendResponse.inviterEmail()).isEqualTo("ray@info.tomlinson.ai")
        assertThat(invitationSendResponse.kind()).isEqualTo(InvitationSendResponse.Kind.INVITATION)
        assertThat(invitationSendResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(invitationSendResponse.region())
            .isEqualTo(InvitationSendResponse.Region.EU_WEST_1)
        assertThat(invitationSendResponse.status()).isEqualTo(InvitationSendResponse.Status.PENDING)
        assertThat(invitationSendResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invitationSendResponse =
            InvitationSendResponse.builder()
                .id("invit_01jnxn8wd3gvcr98yscpctd9vw")
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .email("sarah.connor@sky.net")
                .invitationExpiredAt("2025-01-16T22:22:41.247Z")
                .inviterEmail("ray@info.tomlinson.ai")
                .kind(InvitationSendResponse.Kind.INVITATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(InvitationSendResponse.Region.EU_WEST_1)
                .status(InvitationSendResponse.Status.PENDING)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        val roundtrippedInvitationSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invitationSendResponse),
                jacksonTypeRef<InvitationSendResponse>(),
            )

        assertThat(roundtrippedInvitationSendResponse).isEqualTo(invitationSendResponse)
    }
}
