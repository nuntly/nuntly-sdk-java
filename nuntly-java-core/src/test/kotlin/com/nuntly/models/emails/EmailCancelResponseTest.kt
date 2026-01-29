// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailCancelResponseTest {

    @Test
    fun create() {
        val emailCancelResponse =
            EmailCancelResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .status(Status.QUEUED)
                .build()

        assertThat(emailCancelResponse.id()).isEqualTo("em_01ka8k8s80gvx9604cn9am5st4")
        assertThat(emailCancelResponse.status()).isEqualTo(Status.QUEUED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailCancelResponse =
            EmailCancelResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .status(Status.QUEUED)
                .build()

        val roundtrippedEmailCancelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailCancelResponse),
                jacksonTypeRef<EmailCancelResponse>(),
            )

        assertThat(roundtrippedEmailCancelResponse).isEqualTo(emailCancelResponse)
    }
}
