// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages.content

import com.nuntly.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContentRetrieveParamsTest {

    @Test
    fun create() {
        ContentRetrieveParams.builder()
            .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
            .addFormat(ContentRetrieveParams.Format.HTML)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ContentRetrieveParams.builder().messageId("imsg_01kabn43yqyxn2bx4ve84mczd3").build()

        assertThat(params._pathParam(0)).isEqualTo("imsg_01kabn43yqyxn2bx4ve84mczd3")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ContentRetrieveParams.builder()
                .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                .addFormat(ContentRetrieveParams.Format.HTML)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("format", listOf("html").joinToString(",")).build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ContentRetrieveParams.builder().messageId("imsg_01kabn43yqyxn2bx4ve84mczd3").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
