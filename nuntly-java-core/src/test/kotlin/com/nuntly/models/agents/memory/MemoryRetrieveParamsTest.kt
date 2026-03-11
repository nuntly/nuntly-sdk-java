// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.agents.memory

import com.nuntly.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryRetrieveParamsTest {

    @Test
    fun create() {
        MemoryRetrieveParams.builder().agentId("x").inboxId("inboxId").threadId("threadId").build()
    }

    @Test
    fun pathParams() {
        val params = MemoryRetrieveParams.builder().agentId("x").build()

        assertThat(params._pathParam(0)).isEqualTo("x")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            MemoryRetrieveParams.builder()
                .agentId("x")
                .inboxId("inboxId")
                .threadId("threadId")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("inboxId", "inboxId").put("threadId", "threadId").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = MemoryRetrieveParams.builder().agentId("x").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
