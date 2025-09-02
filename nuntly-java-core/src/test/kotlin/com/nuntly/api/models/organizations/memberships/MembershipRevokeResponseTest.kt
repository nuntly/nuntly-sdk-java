// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.memberships

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MembershipRevokeResponseTest {

    @Test
    fun create() {
        val membershipRevokeResponse =
            MembershipRevokeResponse.builder()
                .kind(MembershipRevokeResponse.Kind.ORG_MEMBERSHIP)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .userId("user_01jh6jk831bzen14edngw38we9")
                .build()

        assertThat(membershipRevokeResponse.kind())
            .isEqualTo(MembershipRevokeResponse.Kind.ORG_MEMBERSHIP)
        assertThat(membershipRevokeResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(membershipRevokeResponse.userId()).isEqualTo("user_01jh6jk831bzen14edngw38we9")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val membershipRevokeResponse =
            MembershipRevokeResponse.builder()
                .kind(MembershipRevokeResponse.Kind.ORG_MEMBERSHIP)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .userId("user_01jh6jk831bzen14edngw38we9")
                .build()

        val roundtrippedMembershipRevokeResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(membershipRevokeResponse),
                jacksonTypeRef<MembershipRevokeResponse>(),
            )

        assertThat(roundtrippedMembershipRevokeResponse).isEqualTo(membershipRevokeResponse)
    }
}
