// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.nuntly.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListParamsTest {

    @Test
    fun create() {
        MessageListParams.builder()
            .cursor("cursor")
            .domainId("domainId")
            .from("from")
            .limit(1.0)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            MessageListParams.builder()
                .cursor("cursor")
                .domainId("domainId")
                .from("from")
                .limit(1.0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("domainId", "domainId")
                    .put("from", "from")
                    .put("limit", "1.0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MessageListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
