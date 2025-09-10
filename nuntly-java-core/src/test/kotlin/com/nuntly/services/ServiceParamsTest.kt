// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.nuntly.client.NuntlyClient
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.core.JsonValue
import com.nuntly.models.apikeys.ApiKeyCreateParams
import com.nuntly.models.emails.EmailSendParams
import com.nuntly.models.shared.EmailHeaders
import java.time.OffsetDateTime
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: NuntlyClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            NuntlyOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun create() {
        val apiKeyService = client.apiKeys()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        apiKeyService.create(
            ApiKeyCreateParams.builder()
                .name("My API key")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }

    @Test
    fun send() {
        val emailService = client.emails()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        emailService.send(
            EmailSendParams.builder()
                .from("ray@info.tomlinson.ai")
                .subject("Welcome to Tomlinson AI!")
                .to("carlo43@gmail.com")
                .addAttachment(
                    EmailSendParams.Attachment.builder()
                        .content("content")
                        .contentType("content_type")
                        .filename("filename")
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .ccOfStrings(listOf("string"))
                .context(JsonValue.from(mapOf<String, Any>()))
                .headers(
                    EmailHeaders.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .html(
                    "<html><body><p>Hi, Thank you for signing up! Please verify your email ...</p></body></html>"
                )
                .replyToOfStrings(listOf("string"))
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addTag(EmailSendParams.Tag.builder().name("name").value("value").build())
                .text("text")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
