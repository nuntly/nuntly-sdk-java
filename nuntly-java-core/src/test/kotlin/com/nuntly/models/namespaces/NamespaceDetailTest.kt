// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceDetailTest {

    @Test
    fun create() {
        val namespaceDetail =
            NamespaceDetail.builder()
                .id("ns_01kabn43yqyxn2bx4ve84mczd3")
                .activeInboxCount(0.0)
                .createdAt("createdAt")
                .externalId("externalId")
                .inboxCount(0.0)
                .name("name")
                .updatedAt("updatedAt")
                .build()

        assertThat(namespaceDetail.id()).isEqualTo("ns_01kabn43yqyxn2bx4ve84mczd3")
        assertThat(namespaceDetail.activeInboxCount()).isEqualTo(0.0)
        assertThat(namespaceDetail.createdAt()).isEqualTo("createdAt")
        assertThat(namespaceDetail.externalId()).contains("externalId")
        assertThat(namespaceDetail.inboxCount()).isEqualTo(0.0)
        assertThat(namespaceDetail.name()).isEqualTo("name")
        assertThat(namespaceDetail.updatedAt()).contains("updatedAt")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceDetail =
            NamespaceDetail.builder()
                .id("ns_01kabn43yqyxn2bx4ve84mczd3")
                .activeInboxCount(0.0)
                .createdAt("createdAt")
                .externalId("externalId")
                .inboxCount(0.0)
                .name("name")
                .updatedAt("updatedAt")
                .build()

        val roundtrippedNamespaceDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceDetail),
                jacksonTypeRef<NamespaceDetail>(),
            )

        assertThat(roundtrippedNamespaceDetail).isEqualTo(namespaceDetail)
    }
}
