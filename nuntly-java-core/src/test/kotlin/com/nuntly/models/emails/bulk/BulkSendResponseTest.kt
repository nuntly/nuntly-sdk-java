// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.bulk

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.emails.Status
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BulkSendResponseTest {

    @Test
    fun create() {
        val bulkSendResponse =
            BulkSendResponse.builder()
                .addEmail(
                    BulkSendResponse.Email.builder()
                        .status(Status.QUEUED)
                        .id("em_01ka8k8s80gvx9604cn9am5st4")
                        .build()
                )
                .id("id")
                .build()

        assertThat(bulkSendResponse.emails())
            .containsExactly(
                BulkSendResponse.Email.builder()
                    .status(Status.QUEUED)
                    .id("em_01ka8k8s80gvx9604cn9am5st4")
                    .build()
            )
        assertThat(bulkSendResponse.id()).contains("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bulkSendResponse =
            BulkSendResponse.builder()
                .addEmail(
                    BulkSendResponse.Email.builder()
                        .status(Status.QUEUED)
                        .id("em_01ka8k8s80gvx9604cn9am5st4")
                        .build()
                )
                .id("id")
                .build()

        val roundtrippedBulkSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkSendResponse),
                jacksonTypeRef<BulkSendResponse>(),
            )

        assertThat(roundtrippedBulkSendResponse).isEqualTo(bulkSendResponse)
    }
}
