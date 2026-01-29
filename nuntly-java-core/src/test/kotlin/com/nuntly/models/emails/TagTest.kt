// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TagTest {

    @Test
    fun create() {
        val tag = Tag.builder().name("name").value("value").build()

        assertThat(tag.name()).isEqualTo("name")
        assertThat(tag.value()).isEqualTo("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tag = Tag.builder().name("name").value("value").build()

        val roundtrippedTag =
            jsonMapper.readValue(jsonMapper.writeValueAsString(tag), jacksonTypeRef<Tag>())

        assertThat(roundtrippedTag).isEqualTo(tag)
    }
}
