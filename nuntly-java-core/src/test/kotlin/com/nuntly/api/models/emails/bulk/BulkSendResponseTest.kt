// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import com.nuntly.api.models.shared.BulkEmailsStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkSendResponseTest {

    @Test
    fun create() {
        val bulkSendResponse =
            BulkSendResponse.builder()
                .id("blk_01jnvnn9avq52k5mrhn1gab0ce")
                .emails(
                    listOf(
                        BulkSendResponse.Email.builder()
                            .kind(BulkSendResponse.Email.Kind.EMAIL)
                            .status(BulkEmailsStatus.QUEUED)
                            .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                            .error("error")
                            .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                            .build(),
                        BulkSendResponse.Email.builder()
                            .kind(BulkSendResponse.Email.Kind.EMAIL)
                            .status(BulkEmailsStatus.QUEUED)
                            .id("em_01jnvnn9avq52k5mrhn1gab0cj")
                            .error("error")
                            .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                            .build(),
                        BulkSendResponse.Email.builder()
                            .kind(BulkSendResponse.Email.Kind.EMAIL)
                            .status(BulkEmailsStatus.REJECTED)
                            .id("id")
                            .error("The domain is not verified")
                            .orgId("org_id")
                            .build(),
                    )
                )
                .kind(BulkSendResponse.Kind.BULK_EMAIL)
                .build()

        assertThat(bulkSendResponse.id()).isEqualTo("blk_01jnvnn9avq52k5mrhn1gab0ce")
        assertThat(bulkSendResponse.emails())
            .containsExactly(
                BulkSendResponse.Email.builder()
                    .kind(BulkSendResponse.Email.Kind.EMAIL)
                    .status(BulkEmailsStatus.QUEUED)
                    .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                    .error("error")
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .build(),
                BulkSendResponse.Email.builder()
                    .kind(BulkSendResponse.Email.Kind.EMAIL)
                    .status(BulkEmailsStatus.QUEUED)
                    .id("em_01jnvnn9avq52k5mrhn1gab0cj")
                    .error("error")
                    .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                    .build(),
                BulkSendResponse.Email.builder()
                    .kind(BulkSendResponse.Email.Kind.EMAIL)
                    .status(BulkEmailsStatus.REJECTED)
                    .id("id")
                    .error("The domain is not verified")
                    .orgId("org_id")
                    .build(),
            )
        assertThat(bulkSendResponse.kind()).isEqualTo(BulkSendResponse.Kind.BULK_EMAIL)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkSendResponse =
            BulkSendResponse.builder()
                .id("blk_01jnvnn9avq52k5mrhn1gab0ce")
                .emails(
                    listOf(
                        BulkSendResponse.Email.builder()
                            .kind(BulkSendResponse.Email.Kind.EMAIL)
                            .status(BulkEmailsStatus.QUEUED)
                            .id("em_01jnvnn9avq52k5mrhn1gab0ci")
                            .error("error")
                            .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                            .build(),
                        BulkSendResponse.Email.builder()
                            .kind(BulkSendResponse.Email.Kind.EMAIL)
                            .status(BulkEmailsStatus.QUEUED)
                            .id("em_01jnvnn9avq52k5mrhn1gab0cj")
                            .error("error")
                            .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                            .build(),
                        BulkSendResponse.Email.builder()
                            .kind(BulkSendResponse.Email.Kind.EMAIL)
                            .status(BulkEmailsStatus.REJECTED)
                            .id("id")
                            .error("The domain is not verified")
                            .orgId("org_id")
                            .build(),
                    )
                )
                .kind(BulkSendResponse.Kind.BULK_EMAIL)
                .build()

        val roundtrippedBulkSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkSendResponse),
                jacksonTypeRef<BulkSendResponse>(),
            )

        assertThat(roundtrippedBulkSendResponse).isEqualTo(bulkSendResponse)
    }
}
