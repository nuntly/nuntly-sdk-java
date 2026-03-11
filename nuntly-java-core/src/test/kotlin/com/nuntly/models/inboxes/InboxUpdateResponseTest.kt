// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxUpdateResponseTest {

    @Test
    fun create() {
        val inboxUpdateResponse = InboxUpdateResponse.builder().id("id").build()

        assertThat(inboxUpdateResponse.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxUpdateResponse = InboxUpdateResponse.builder().id("id").build()

        val roundtrippedInboxUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxUpdateResponse),
                jacksonTypeRef<InboxUpdateResponse>(),
            )

        assertThat(roundtrippedInboxUpdateResponse).isEqualTo(inboxUpdateResponse)
    }
}
