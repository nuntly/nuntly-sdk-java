// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailSendResponseTest {

    @Test
    fun create() {
        val emailSendResponse =
            EmailSendResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .status(Status.QUEUED)
                .build()

        assertThat(emailSendResponse.id()).isEqualTo("em_01ka8k8s80gvx9604cn9am5st4")
        assertThat(emailSendResponse.status()).isEqualTo(Status.QUEUED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailSendResponse =
            EmailSendResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .status(Status.QUEUED)
                .build()

        val roundtrippedEmailSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailSendResponse),
                jacksonTypeRef<EmailSendResponse>(),
            )

        assertThat(roundtrippedEmailSendResponse).isEqualTo(emailSendResponse)
    }
}
