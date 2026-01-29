// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.emails.Status
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkRetrieveResponseTest {

    @Test
    fun create() {
        val bulkRetrieveResponse =
            BulkRetrieveResponse.builder()
                .id("id")
                .addEmail(
                    BulkRetrieveResponse.Email.builder()
                        .id("em_01ka8k8s80gvx9604cn9am5st4")
                        .status(Status.QUEUED)
                        .detail("detail")
                        .build()
                )
                .build()

        assertThat(bulkRetrieveResponse.id()).isEqualTo("id")
        assertThat(bulkRetrieveResponse.emails())
            .containsExactly(
                BulkRetrieveResponse.Email.builder()
                    .id("em_01ka8k8s80gvx9604cn9am5st4")
                    .status(Status.QUEUED)
                    .detail("detail")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkRetrieveResponse =
            BulkRetrieveResponse.builder()
                .id("id")
                .addEmail(
                    BulkRetrieveResponse.Email.builder()
                        .id("em_01ka8k8s80gvx9604cn9am5st4")
                        .status(Status.QUEUED)
                        .detail("detail")
                        .build()
                )
                .build()

        val roundtrippedBulkRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkRetrieveResponse),
                jacksonTypeRef<BulkRetrieveResponse>(),
            )

        assertThat(roundtrippedBulkRetrieveResponse).isEqualTo(bulkRetrieveResponse)
    }
}
