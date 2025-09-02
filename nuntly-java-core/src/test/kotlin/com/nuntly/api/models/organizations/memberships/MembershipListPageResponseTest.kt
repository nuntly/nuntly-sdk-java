// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.organizations.memberships

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MembershipListPageResponseTest {

    @Test
    fun create() {
        val membershipListPageResponse =
            MembershipListPageResponse.builder()
                .addData(
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
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(membershipListPageResponse.data().getOrNull())
            .containsExactly(
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
            )
        assertThat(membershipListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val membershipListPageResponse =
            MembershipListPageResponse.builder()
                .addData(
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
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedMembershipListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(membershipListPageResponse),
                jacksonTypeRef<MembershipListPageResponse>(),
            )

        assertThat(roundtrippedMembershipListPageResponse).isEqualTo(membershipListPageResponse)
    }
}
