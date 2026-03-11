// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailListResponseTest {

    @Test
    fun create() {
        val emailListResponse =
            EmailListResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                .status(Status.QUEUED)
                .subject("Verify your email address")
                .to("brian67@gmail.com")
                .scheduledAt("scheduledAt")
                .build()

        assertThat(emailListResponse.id()).isEqualTo("em_01ka8k8s80gvx9604cn9am5st4")
        assertThat(emailListResponse.createdAt()).isEqualTo("createdAt")
        assertThat(emailListResponse.from()).isEqualTo("Tomlinson AI <ray@info.tomlinson.ai>")
        assertThat(emailListResponse.status()).isEqualTo(Status.QUEUED)
        assertThat(emailListResponse.subject()).isEqualTo("Verify your email address")
        assertThat(emailListResponse.to())
            .isEqualTo(EmailListResponse.To.ofString("brian67@gmail.com"))
        assertThat(emailListResponse.scheduledAt()).contains("scheduledAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailListResponse =
            EmailListResponse.builder()
                .id("em_01ka8k8s80gvx9604cn9am5st4")
                .createdAt("createdAt")
                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                .status(Status.QUEUED)
                .subject("Verify your email address")
                .to("brian67@gmail.com")
                .scheduledAt("scheduledAt")
                .build()

        val roundtrippedEmailListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailListResponse),
                jacksonTypeRef<EmailListResponse>(),
            )

        assertThat(roundtrippedEmailListResponse).isEqualTo(emailListResponse)
    }
}
