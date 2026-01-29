// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailListPageResponseTest {

    @Test
    fun create() {
        val emailListPageResponse =
            EmailListPageResponse.builder()
                .addData(
                    EmailListResponse.builder()
                        .id("em_01ka8k8s80gvx9604cn9am5st4")
                        .createdAt("createdAt")
                        .from("from")
                        .status(Status.QUEUED)
                        .subject("subject")
                        .toOfStrings(listOf("string"))
                        .scheduledAt("scheduledAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(emailListPageResponse.data())
            .containsExactly(
                EmailListResponse.builder()
                    .id("em_01ka8k8s80gvx9604cn9am5st4")
                    .createdAt("createdAt")
                    .from("from")
                    .status(Status.QUEUED)
                    .subject("subject")
                    .toOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .build()
            )
        assertThat(emailListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailListPageResponse =
            EmailListPageResponse.builder()
                .addData(
                    EmailListResponse.builder()
                        .id("em_01ka8k8s80gvx9604cn9am5st4")
                        .createdAt("createdAt")
                        .from("from")
                        .status(Status.QUEUED)
                        .subject("subject")
                        .toOfStrings(listOf("string"))
                        .scheduledAt("scheduledAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedEmailListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailListPageResponse),
                jacksonTypeRef<EmailListPageResponse>(),
            )

        assertThat(roundtrippedEmailListPageResponse).isEqualTo(emailListPageResponse)
    }
}
