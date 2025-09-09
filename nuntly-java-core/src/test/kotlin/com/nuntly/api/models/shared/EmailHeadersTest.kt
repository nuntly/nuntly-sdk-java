// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.shared

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.JsonValue
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmailHeadersTest {

    @Test
    fun create() {
        val emailHeaders =
            EmailHeaders.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val emailHeaders =
            EmailHeaders.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()

        val roundtrippedEmailHeaders =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(emailHeaders),
                jacksonTypeRef<EmailHeaders>(),
            )

        assertThat(roundtrippedEmailHeaders).isEqualTo(emailHeaders)
    }
}
