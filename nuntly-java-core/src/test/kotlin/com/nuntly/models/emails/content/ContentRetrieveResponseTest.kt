// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.content

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContentRetrieveResponseTest {

    @Test
    fun create() {
        val contentRetrieveResponse =
            ContentRetrieveResponse.builder()
                .htmlTemplateUrl("htmlTemplateUrl")
                .htmlUrl("htmlUrl")
                .mineUrl("mineUrl")
                .subjectTemplateUrl("subjectTemplateUrl")
                .textTemplateUrl("textTemplateUrl")
                .textUrl("textUrl")
                .build()

        assertThat(contentRetrieveResponse.htmlTemplateUrl()).contains("htmlTemplateUrl")
        assertThat(contentRetrieveResponse.htmlUrl()).contains("htmlUrl")
        assertThat(contentRetrieveResponse.mineUrl()).contains("mineUrl")
        assertThat(contentRetrieveResponse.subjectTemplateUrl()).contains("subjectTemplateUrl")
        assertThat(contentRetrieveResponse.textTemplateUrl()).contains("textTemplateUrl")
        assertThat(contentRetrieveResponse.textUrl()).contains("textUrl")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contentRetrieveResponse =
            ContentRetrieveResponse.builder()
                .htmlTemplateUrl("htmlTemplateUrl")
                .htmlUrl("htmlUrl")
                .mineUrl("mineUrl")
                .subjectTemplateUrl("subjectTemplateUrl")
                .textTemplateUrl("textTemplateUrl")
                .textUrl("textUrl")
                .build()

        val roundtrippedContentRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentRetrieveResponse),
                jacksonTypeRef<ContentRetrieveResponse>(),
            )

        assertThat(roundtrippedContentRetrieveResponse).isEqualTo(contentRetrieveResponse)
    }
}
