// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailContentItemTest {

    @Test
    fun create() {
        val emailContentItem =
            EmailContentItem.builder()
                .downloadUrl("https://example.com")
                .expiresAt("expiresAt")
                .size(0.0)
                .build()

        assertThat(emailContentItem.downloadUrl()).isEqualTo("https://example.com")
        assertThat(emailContentItem.expiresAt()).isEqualTo("expiresAt")
        assertThat(emailContentItem.size()).contains(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailContentItem =
            EmailContentItem.builder()
                .downloadUrl("https://example.com")
                .expiresAt("expiresAt")
                .size(0.0)
                .build()

        val roundtrippedEmailContentItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailContentItem),
                jacksonTypeRef<EmailContentItem>(),
            )

        assertThat(roundtrippedEmailContentItem).isEqualTo(emailContentItem)
    }
}
