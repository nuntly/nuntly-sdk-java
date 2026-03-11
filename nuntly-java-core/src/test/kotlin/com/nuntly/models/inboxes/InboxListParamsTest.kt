// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import com.nuntly.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxListParamsTest {

    @Test
    fun create() {
        InboxListParams.builder().cursor("cursor").limit(1.0).namespaceId("namespaceId").build()
    }

    @Test
    fun queryParams() {
        val params =
            InboxListParams.builder().cursor("cursor").limit(1.0).namespaceId("namespaceId").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("limit", "1.0")
                    .put("namespaceId", "namespaceId")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = InboxListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
