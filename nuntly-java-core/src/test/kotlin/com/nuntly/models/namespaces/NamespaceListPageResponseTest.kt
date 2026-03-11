// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceListPageResponseTest {

    @Test
    fun create() {
        val namespaceListPageResponse =
            NamespaceListPageResponse.builder()
                .addData(
                    Namespace.builder()
                        .id("ns_01kabn43yqyxn2bx4ve84mczd3")
                        .createdAt("createdAt")
                        .externalId("externalId")
                        .name("name")
                        .updatedAt("updatedAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(namespaceListPageResponse.data())
            .containsExactly(
                Namespace.builder()
                    .id("ns_01kabn43yqyxn2bx4ve84mczd3")
                    .createdAt("createdAt")
                    .externalId("externalId")
                    .name("name")
                    .updatedAt("updatedAt")
                    .build()
            )
        assertThat(namespaceListPageResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceListPageResponse =
            NamespaceListPageResponse.builder()
                .addData(
                    Namespace.builder()
                        .id("ns_01kabn43yqyxn2bx4ve84mczd3")
                        .createdAt("createdAt")
                        .externalId("externalId")
                        .name("name")
                        .updatedAt("updatedAt")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedNamespaceListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceListPageResponse),
                jacksonTypeRef<NamespaceListPageResponse>(),
            )

        assertThat(roundtrippedNamespaceListPageResponse).isEqualTo(namespaceListPageResponse)
    }
}
