// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.shared.EmailStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkRetrieveResponseTest {

    @Test
    fun create() {
        val bulkRetrieveResponse =
            BulkRetrieveResponse.builder()
                .id("blk_E9usgNhRPB8n11YujfZUHMSUztadfFDYUDWBp4zxVamsF18Y")
                .addEmail(
                    BulkRetrieveResponse.Email.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                        .kind(BulkRetrieveResponse.Email.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .build()
                )
                .addEmail(
                    BulkRetrieveResponse.Email.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0cj")
                        .kind(BulkRetrieveResponse.Email.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .build()
                )
                .kind(BulkRetrieveResponse.Kind.BULK_EMAIL)
                .build()

        assertThat(bulkRetrieveResponse.id())
            .isEqualTo("blk_E9usgNhRPB8n11YujfZUHMSUztadfFDYUDWBp4zxVamsF18Y")
        assertThat(bulkRetrieveResponse.emails())
            .containsExactly(
                BulkRetrieveResponse.Email.builder()
                    .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                    .kind(BulkRetrieveResponse.Email.Kind.EMAIL)
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .status(EmailStatus.DELIVERED)
                    .statusAt("2025-03-08T20:03:04.155Z")
                    .build(),
                BulkRetrieveResponse.Email.builder()
                    .id("em_01jnvnn9avq52k5mrhn1gab0cj")
                    .kind(BulkRetrieveResponse.Email.Kind.EMAIL)
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .status(EmailStatus.DELIVERED)
                    .statusAt("2025-03-08T20:03:04.155Z")
                    .build(),
            )
        assertThat(bulkRetrieveResponse.kind()).isEqualTo(BulkRetrieveResponse.Kind.BULK_EMAIL)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkRetrieveResponse =
            BulkRetrieveResponse.builder()
                .id("blk_E9usgNhRPB8n11YujfZUHMSUztadfFDYUDWBp4zxVamsF18Y")
                .addEmail(
                    BulkRetrieveResponse.Email.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                        .kind(BulkRetrieveResponse.Email.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .build()
                )
                .addEmail(
                    BulkRetrieveResponse.Email.builder()
                        .id("em_01jnvnn9avq52k5mrhn1gab0cj")
                        .kind(BulkRetrieveResponse.Email.Kind.EMAIL)
                        .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                        .status(EmailStatus.DELIVERED)
                        .statusAt("2025-03-08T20:03:04.155Z")
                        .build()
                )
                .kind(BulkRetrieveResponse.Kind.BULK_EMAIL)
                .build()

        val roundtrippedBulkRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkRetrieveResponse),
                jacksonTypeRef<BulkRetrieveResponse>(),
            )

        assertThat(roundtrippedBulkRetrieveResponse).isEqualTo(bulkRetrieveResponse)
    }
}
