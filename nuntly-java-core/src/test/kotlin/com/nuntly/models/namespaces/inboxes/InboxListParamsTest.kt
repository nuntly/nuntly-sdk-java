// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces.inboxes

import com.nuntly.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxListParamsTest {

    @Test
    fun create() {
        InboxListParams.builder()
            .namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3")
            .cursor("cursor")
            .limit(1.0)
            .build()
    }

    @Test
    fun pathParams() {
        val params = InboxListParams.builder().namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("ns_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            InboxListParams.builder()
                .namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3")
                .cursor("cursor")
                .limit(1.0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("cursor", "cursor").put("limit", "1.0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = InboxListParams.builder().namespaceId("ns_01kabn43yqyxn2bx4ve84mczd3").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
