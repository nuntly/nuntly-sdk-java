// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.invitations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvitationListResponseTest {

    @Test
    fun create() {
        val invitationListResponse =
            InvitationListResponse.builder()
                .id("invit_01jnxn8wd3gvcr98yscpctd9vw")
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .email("sarah.connor@sky.net")
                .invitationExpiredAt("2025-01-16T22:22:41.247Z")
                .inviterEmail("ray@info.tomlinson.ai")
                .kind(InvitationListResponse.Kind.INVITATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(InvitationListResponse.Region.EU_WEST_1)
                .status(InvitationListResponse.Status.PENDING)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        assertThat(invitationListResponse.id()).isEqualTo("invit_01jnxn8wd3gvcr98yscpctd9vw")
        assertThat(invitationListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
        assertThat(invitationListResponse.email()).isEqualTo("sarah.connor@sky.net")
        assertThat(invitationListResponse.invitationExpiredAt())
            .isEqualTo("2025-01-16T22:22:41.247Z")
        assertThat(invitationListResponse.inviterEmail()).isEqualTo("ray@info.tomlinson.ai")
        assertThat(invitationListResponse.kind()).isEqualTo(InvitationListResponse.Kind.INVITATION)
        assertThat(invitationListResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(invitationListResponse.region())
            .isEqualTo(InvitationListResponse.Region.EU_WEST_1)
        assertThat(invitationListResponse.status()).isEqualTo(InvitationListResponse.Status.PENDING)
        assertThat(invitationListResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invitationListResponse =
            InvitationListResponse.builder()
                .id("invit_01jnxn8wd3gvcr98yscpctd9vw")
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .email("sarah.connor@sky.net")
                .invitationExpiredAt("2025-01-16T22:22:41.247Z")
                .inviterEmail("ray@info.tomlinson.ai")
                .kind(InvitationListResponse.Kind.INVITATION)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(InvitationListResponse.Region.EU_WEST_1)
                .status(InvitationListResponse.Status.PENDING)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        val roundtrippedInvitationListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invitationListResponse),
                jacksonTypeRef<InvitationListResponse>(),
            )

        assertThat(roundtrippedInvitationListResponse).isEqualTo(invitationListResponse)
    }
}
