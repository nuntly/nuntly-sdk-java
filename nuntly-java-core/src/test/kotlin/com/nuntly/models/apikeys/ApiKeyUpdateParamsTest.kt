// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateParamsTest {

    @Test
    fun create() {
        ApiKeyUpdateParams.builder()
            .id("apk_01ka8k8s80gvx9604cn9am5st4")
            .permission(ApiKeyUpdateParams.Permission.FULL_ACCESS)
            .addDomainId("string")
            .name("name")
            .status(ApiKeyUpdateParams.Status.ENABLED)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ApiKeyUpdateParams.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .permission(ApiKeyUpdateParams.Permission.FULL_ACCESS)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("apk_01ka8k8s80gvx9604cn9am5st4")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ApiKeyUpdateParams.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .permission(ApiKeyUpdateParams.Permission.FULL_ACCESS)
                .addDomainId("string")
                .name("name")
                .status(ApiKeyUpdateParams.Status.ENABLED)
                .build()

        val body = params._body()

        assertThat(body.permission()).isEqualTo(ApiKeyUpdateParams.Permission.FULL_ACCESS)
        assertThat(body.domainIds().getOrNull()).containsExactly("string")
        assertThat(body.name()).contains("name")
        assertThat(body.status()).contains(ApiKeyUpdateParams.Status.ENABLED)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ApiKeyUpdateParams.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .permission(ApiKeyUpdateParams.Permission.FULL_ACCESS)
                .build()

        val body = params._body()

        assertThat(body.permission()).isEqualTo(ApiKeyUpdateParams.Permission.FULL_ACCESS)
    }
}
