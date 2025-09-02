// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailCancelResponseTest {

    @Test
    fun create() {
        val emailCancelResponse =
            EmailCancelResponse.builder()
                .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                .kind(EmailCancelResponse.Kind.EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        assertThat(emailCancelResponse.id()).isEqualTo("em_01jnvnn9avq52k5mrhn1gab0ch")
        assertThat(emailCancelResponse.kind()).isEqualTo(EmailCancelResponse.Kind.EMAIL)
        assertThat(emailCancelResponse.orgId()).isEqualTo("org_01jh6jk82zjq9deye73h0mzcaq")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailCancelResponse =
            EmailCancelResponse.builder()
                .id("em_01jnvnn9avq52k5mrhn1gab0ch")
                .kind(EmailCancelResponse.Kind.EMAIL)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .build()

        val roundtrippedEmailCancelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailCancelResponse),
                jacksonTypeRef<EmailCancelResponse>(),
            )

        assertThat(roundtrippedEmailCancelResponse).isEqualTo(emailCancelResponse)
    }
}
