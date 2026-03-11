// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateParamsTest {

    @Test
    fun create() {
        ApiKeyCreateParams.builder()
            .addDomainId("string")
            .name("name")
            .permission(ApiKeyCreateParams.Permission.FULL_ACCESS)
            .status(ApiKeyCreateParams.Status.ENABLED)
            .build()
    }

    @Test
    fun body() {
        val params =
            ApiKeyCreateParams.builder()
                .addDomainId("string")
                .name("name")
                .permission(ApiKeyCreateParams.Permission.FULL_ACCESS)
                .status(ApiKeyCreateParams.Status.ENABLED)
                .build()

        val body = params._body()

        assertThat(body.domainIds().getOrNull()).containsExactly("string")
        assertThat(body.name()).contains("name")
        assertThat(body.permission()).contains(ApiKeyCreateParams.Permission.FULL_ACCESS)
        assertThat(body.status()).contains(ApiKeyCreateParams.Status.ENABLED)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ApiKeyCreateParams.builder().build()

        val body = params._body()
    }
}
