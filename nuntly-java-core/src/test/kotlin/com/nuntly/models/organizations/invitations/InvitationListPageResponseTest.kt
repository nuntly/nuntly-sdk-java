// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.invitations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvitationListPageResponseTest {

    @Test
    fun create() {
        val invitationListPageResponse =
            InvitationListPageResponse.builder()
                .addData(
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
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(invitationListPageResponse.data().getOrNull())
            .containsExactly(
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
            )
        assertThat(invitationListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invitationListPageResponse =
            InvitationListPageResponse.builder()
                .addData(
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
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedInvitationListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invitationListPageResponse),
                jacksonTypeRef<InvitationListPageResponse>(),
            )

        assertThat(roundtrippedInvitationListPageResponse).isEqualTo(invitationListPageResponse)
    }
}
