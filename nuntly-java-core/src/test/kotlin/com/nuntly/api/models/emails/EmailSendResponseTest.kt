// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailSendResponseTest {

    @Test
    fun create() {
        val emailSendResponse =
            EmailSendResponse.builder()
                .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                .kind(EmailSendResponse.Kind.EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .status(EmailSendResponse.Status.QUEUED)
                .build()

        assertThat(emailSendResponse.id()).isEqualTo("em_01jnvnn9avq52k5mrhn1gab0ch")
        assertThat(emailSendResponse.kind()).isEqualTo(EmailSendResponse.Kind.EMAIL)
        assertThat(emailSendResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
        assertThat(emailSendResponse.status()).isEqualTo(EmailSendResponse.Status.QUEUED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailSendResponse =
            EmailSendResponse.builder()
                .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                .kind(EmailSendResponse.Kind.EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .status(EmailSendResponse.Status.QUEUED)
                .build()

        val roundtrippedEmailSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailSendResponse),
                jacksonTypeRef<EmailSendResponse>(),
            )

        assertThat(roundtrippedEmailSendResponse).isEqualTo(emailSendResponse)
    }
}
