// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceUpdateResponseTest {

    @Test
    fun create() {
        val namespaceUpdateResponse = NamespaceUpdateResponse.builder().id("id").build()

        assertThat(namespaceUpdateResponse.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceUpdateResponse = NamespaceUpdateResponse.builder().id("id").build()

        val roundtrippedNamespaceUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceUpdateResponse),
                jacksonTypeRef<NamespaceUpdateResponse>(),
            )

        assertThat(roundtrippedNamespaceUpdateResponse).isEqualTo(namespaceUpdateResponse)
    }
}
