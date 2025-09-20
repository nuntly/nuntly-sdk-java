// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OpenDetailTest {

    @Test
    fun create() {
        val openDetail = OpenDetail.builder().openedAt("opened_at").userAgent("user_agent").build()

        assertThat(openDetail.openedAt()).isEqualTo("opened_at")
        assertThat(openDetail.userAgent()).isEqualTo("user_agent")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val openDetail = OpenDetail.builder().openedAt("opened_at").userAgent("user_agent").build()

        val roundtrippedOpenDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(openDetail),
                jacksonTypeRef<OpenDetail>(),
            )

        assertThat(roundtrippedOpenDetail).isEqualTo(openDetail)
    }
}
