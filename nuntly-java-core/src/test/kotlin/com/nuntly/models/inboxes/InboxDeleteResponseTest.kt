// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxDeleteResponseTest {

    @Test
    fun create() {
        val inboxDeleteResponse = InboxDeleteResponse.builder().id("id").build()

        assertThat(inboxDeleteResponse.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxDeleteResponse = InboxDeleteResponse.builder().id("id").build()

        val roundtrippedInboxDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxDeleteResponse),
                jacksonTypeRef<InboxDeleteResponse>(),
            )

        assertThat(roundtrippedInboxDeleteResponse).isEqualTo(inboxDeleteResponse)
    }
}
