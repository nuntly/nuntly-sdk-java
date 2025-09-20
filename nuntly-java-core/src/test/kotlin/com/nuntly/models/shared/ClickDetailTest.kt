// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClickDetailTest {

    @Test
    fun create() {
        val clickDetail =
            ClickDetail.builder()
                .clickedAt("clicked_at")
                .link("link")
                .userAgent("user_agent")
                .build()

        assertThat(clickDetail.clickedAt()).isEqualTo("clicked_at")
        assertThat(clickDetail.link()).isEqualTo("link")
        assertThat(clickDetail.userAgent()).isEqualTo("user_agent")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val clickDetail =
            ClickDetail.builder()
                .clickedAt("clicked_at")
                .link("link")
                .userAgent("user_agent")
                .build()

        val roundtrippedClickDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clickDetail),
                jacksonTypeRef<ClickDetail>(),
            )

        assertThat(roundtrippedClickDetail).isEqualTo(clickDetail)
    }
}
