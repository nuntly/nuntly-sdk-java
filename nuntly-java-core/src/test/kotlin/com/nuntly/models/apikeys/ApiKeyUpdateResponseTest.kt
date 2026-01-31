// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyUpdateResponseTest {

    @Test
    fun create() {
        val apiKeyUpdateResponse =
            ApiKeyUpdateResponse.builder().id("apk_01ka8k8s80gvx9604cn9am5st4").build()

        assertThat(apiKeyUpdateResponse.id()).isEqualTo("apk_01ka8k8s80gvx9604cn9am5st4")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyUpdateResponse =
            ApiKeyUpdateResponse.builder().id("apk_01ka8k8s80gvx9604cn9am5st4").build()

        val roundtrippedApiKeyUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyUpdateResponse),
                jacksonTypeRef<ApiKeyUpdateResponse>(),
            )

        assertThat(roundtrippedApiKeyUpdateResponse).isEqualTo(apiKeyUpdateResponse)
    }
}
