// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceTest {

    @Test
    fun create() {
        val namespace =
            Namespace.builder()
                .id("ns_01kabn43yqyxn2bx4ve84mczd3")
                .createdAt("createdAt")
                .externalId("externalId")
                .name("name")
                .updatedAt("updatedAt")
                .build()

        assertThat(namespace.id()).isEqualTo("ns_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(namespace.createdAt()).isEqualTo("createdAt")
        assertThat(namespace.externalId()).contains("externalId")
        assertThat(namespace.name()).isEqualTo("name")
        assertThat(namespace.updatedAt()).contains("updatedAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespace =
            Namespace.builder()
                .id("ns_01kabn43yqyxn2bx4ve84mczd3")
                .createdAt("createdAt")
                .externalId("externalId")
                .name("name")
                .updatedAt("updatedAt")
                .build()

        val roundtrippedNamespace =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespace),
                jacksonTypeRef<Namespace>(),
            )

        assertThat(roundtrippedNamespace).isEqualTo(namespace)
    }
}
