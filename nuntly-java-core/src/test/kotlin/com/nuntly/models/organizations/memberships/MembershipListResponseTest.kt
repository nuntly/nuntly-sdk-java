// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.memberships

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MembershipListResponseTest {

    @Test
    fun create() {
        val membershipListResponse =
            MembershipListResponse.builder()
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .displayName("Ray Tomlinson org")
                .email("ray@info.tomlinson.ai")
                .kind(MembershipListResponse.Kind.ORG_MEMBERSHIP)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(MembershipListResponse.Region.EU_WEST_1)
                .role(MembershipListResponse.Role.OWNER)
                .status(MembershipListResponse.Status.ACTIVE)
                .userId("user_01jh6jk831bzen14edngw38we9")
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        assertThat(membershipListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
        assertThat(membershipListResponse.displayName()).isEqualTo("Ray Tomlinson org")
        assertThat(membershipListResponse.email()).isEqualTo("ray@info.tomlinson.ai")
        assertThat(membershipListResponse.kind())
            .isEqualTo(MembershipListResponse.Kind.ORG_MEMBERSHIP)
        assertThat(membershipListResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(membershipListResponse.region())
            .isEqualTo(MembershipListResponse.Region.EU_WEST_1)
        assertThat(membershipListResponse.role()).isEqualTo(MembershipListResponse.Role.OWNER)
        assertThat(membershipListResponse.status()).isEqualTo(MembershipListResponse.Status.ACTIVE)
        assertThat(membershipListResponse.userId()).isEqualTo("user_01jh6jk831bzen14edngw38we9")
        assertThat(membershipListResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val membershipListResponse =
            MembershipListResponse.builder()
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .displayName("Ray Tomlinson org")
                .email("ray@info.tomlinson.ai")
                .kind(MembershipListResponse.Kind.ORG_MEMBERSHIP)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(MembershipListResponse.Region.EU_WEST_1)
                .role(MembershipListResponse.Role.OWNER)
                .status(MembershipListResponse.Status.ACTIVE)
                .userId("user_01jh6jk831bzen14edngw38we9")
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.247Z"))
                .build()

        val roundtrippedMembershipListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(membershipListResponse),
                jacksonTypeRef<MembershipListResponse>(),
            )

        assertThat(roundtrippedMembershipListResponse).isEqualTo(membershipListResponse)
    }
}
