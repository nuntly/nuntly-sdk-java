// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailStatus
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailListPageResponseTest {

    @Test
    fun create() {
        val emailListPageResponse =
            EmailListPageResponse.builder()
                .addData(
                    EmailListResponse.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                        .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                        .from("ray@info.tomlinson.ai")
                        .kind(EmailListResponse.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(EmailListResponse.Region.EU_WEST_1)
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .subject("Welcome to Tomlinson AI!")
                        .to("carlo43@gmail.com")
                        .bulkId("bulk_id")
                        .messageId("message_id")
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .addData(
                    EmailListResponse.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                        .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                        .from("ray@info.tomlinson.ai")
                        .kind(EmailListResponse.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(EmailListResponse.Region.EU_WEST_1)
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .subject("Welcome to Tomlinson AI!")
                        .to("pink42@yahoo.com")
                        .bulkId("bulk_id")
                        .messageId("message_id")
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        assertThat(emailListPageResponse.data().getOrNull())
            .containsExactly(
                EmailListResponse.builder()
                    .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                    .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                    .from("ray@info.tomlinson.ai")
                    .kind(EmailListResponse.Kind.EMAIL)
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .region(EmailListResponse.Region.EU_WEST_1)
                    .status(EmailStatus.DELIVERED)
                    .statusAt("2025-03-08T20:03:04.155Z")
                    .subject("Welcome to Tomlinson AI!")
                    .to("carlo43@gmail.com")
                    .bulkId("bulk_id")
                    .messageId("message_id")
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build(),
                EmailListResponse.builder()
                    .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                    .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                    .from("ray@info.tomlinson.ai")
                    .kind(EmailListResponse.Kind.EMAIL)
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .region(EmailListResponse.Region.EU_WEST_1)
                    .status(EmailStatus.DELIVERED)
                    .statusAt("2025-03-08T20:03:04.155Z")
                    .subject("Welcome to Tomlinson AI!")
                    .to("pink42@yahoo.com")
                    .bulkId("bulk_id")
                    .messageId("message_id")
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build(),
            )
        assertThat(emailListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailListPageResponse =
            EmailListPageResponse.builder()
                .addData(
                    EmailListResponse.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                        .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                        .from("ray@info.tomlinson.ai")
                        .kind(EmailListResponse.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(EmailListResponse.Region.EU_WEST_1)
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .subject("Welcome to Tomlinson AI!")
                        .to("carlo43@gmail.com")
                        .bulkId("bulk_id")
                        .messageId("message_id")
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .addData(
                    EmailListResponse.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                        .createdAt(OffsetDateTime.parse("2025-03-08T20:03:04.155Z"))
                        .from("ray@info.tomlinson.ai")
                        .kind(EmailListResponse.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .region(EmailListResponse.Region.EU_WEST_1)
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .subject("Welcome to Tomlinson AI!")
                        .to("pink42@yahoo.com")
                        .bulkId("bulk_id")
                        .messageId("message_id")
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .nextCursor("next_cursor")
                .build()

        val roundtrippedEmailListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailListPageResponse),
                jacksonTypeRef<EmailListPageResponse>(),
            )

        assertThat(roundtrippedEmailListPageResponse).isEqualTo(emailListPageResponse)
    }
}
