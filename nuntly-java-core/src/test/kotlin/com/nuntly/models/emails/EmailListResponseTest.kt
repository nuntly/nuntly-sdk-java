// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailStatus
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailListResponseTest {

    @Test
    fun create() {
        val emailListResponse =
            EmailListResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .from("from")
                .kind(EmailListResponse.Kind.EMAIL)
                .orgId("org_id")
                .region(EmailListResponse.Region.EU_WEST_1)
                .status(EmailStatus.QUEUED)
                .statusAt("status_at")
                .subject("subject")
                .toOfStrings(listOf("string"))
                .bulkId("bulk_id")
                .messageId("message_id")
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(emailListResponse.id()).isEqualTo("id")
        assertThat(emailListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(emailListResponse.from()).isEqualTo("from")
        assertThat(emailListResponse.kind()).isEqualTo(EmailListResponse.Kind.EMAIL)
        assertThat(emailListResponse.orgId()).isEqualTo("org_id")
        assertThat(emailListResponse.region()).isEqualTo(EmailListResponse.Region.EU_WEST_1)
        assertThat(emailListResponse.status()).isEqualTo(EmailStatus.QUEUED)
        assertThat(emailListResponse.statusAt()).isEqualTo("status_at")
        assertThat(emailListResponse.subject()).isEqualTo("subject")
        assertThat(emailListResponse.to())
            .isEqualTo(EmailListResponse.To.ofStrings(listOf("string")))
        assertThat(emailListResponse.bulkId()).contains("bulk_id")
        assertThat(emailListResponse.messageId()).contains("message_id")
        assertThat(emailListResponse.scheduledAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailListResponse =
            EmailListResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .from("from")
                .kind(EmailListResponse.Kind.EMAIL)
                .orgId("org_id")
                .region(EmailListResponse.Region.EU_WEST_1)
                .status(EmailStatus.QUEUED)
                .statusAt("status_at")
                .subject("subject")
                .toOfStrings(listOf("string"))
                .bulkId("bulk_id")
                .messageId("message_id")
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedEmailListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailListResponse),
                jacksonTypeRef<EmailListResponse>(),
            )

        assertThat(roundtrippedEmailListResponse).isEqualTo(emailListResponse)
    }
}
