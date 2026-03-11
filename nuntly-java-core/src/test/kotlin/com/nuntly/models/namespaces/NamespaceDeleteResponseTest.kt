// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceDeleteResponseTest {

    @Test
    fun create() {
        val namespaceDeleteResponse = NamespaceDeleteResponse.builder().id("id").build()

        assertThat(namespaceDeleteResponse.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceDeleteResponse = NamespaceDeleteResponse.builder().id("id").build()

        val roundtrippedNamespaceDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceDeleteResponse),
                jacksonTypeRef<NamespaceDeleteResponse>(),
            )

        assertThat(roundtrippedNamespaceDeleteResponse).isEqualTo(namespaceDeleteResponse)
    }
}
