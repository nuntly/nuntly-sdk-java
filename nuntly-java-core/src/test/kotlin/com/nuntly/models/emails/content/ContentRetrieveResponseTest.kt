// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.content

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import com.nuntly.models.emails.EmailContentItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContentRetrieveResponseTest {

    @Test
    fun create() {
        val contentRetrieveResponse =
            ContentRetrieveResponse.builder()
                .html(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .htmlTemplate(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .mime(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .subjectTemplate(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .text(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .textTemplate(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .build()

        assertThat(contentRetrieveResponse.html())
            .contains(
                EmailContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
        assertThat(contentRetrieveResponse.htmlTemplate())
            .contains(
                EmailContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
        assertThat(contentRetrieveResponse.mime())
            .contains(
                EmailContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
        assertThat(contentRetrieveResponse.subjectTemplate())
            .contains(
                EmailContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
        assertThat(contentRetrieveResponse.text())
            .contains(
                EmailContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
        assertThat(contentRetrieveResponse.textTemplate())
            .contains(
                EmailContentItem.builder()
                    .downloadUrl("https://example.com")
                    .expiresAt("expiresAt")
                    .size(0.0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contentRetrieveResponse =
            ContentRetrieveResponse.builder()
                .html(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .htmlTemplate(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .mime(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .subjectTemplate(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .text(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .textTemplate(
                    EmailContentItem.builder()
                        .downloadUrl("https://example.com")
                        .expiresAt("expiresAt")
                        .size(0.0)
                        .build()
                )
                .build()

        val roundtrippedContentRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentRetrieveResponse),
                jacksonTypeRef<ContentRetrieveResponse>(),
            )

        assertThat(roundtrippedContentRetrieveResponse).isEqualTo(contentRetrieveResponse)
    }
}
