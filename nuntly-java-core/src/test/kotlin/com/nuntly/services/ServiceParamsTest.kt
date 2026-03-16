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
import com.nuntly.models.emails.Tag
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
                .addDomainId("string")
                .name("name")
                .permission(ApiKeyCreateParams.Permission.FULL_ACCESS)
                .status(ApiKeyCreateParams.Status.ENABLED)
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
                .from("Tomlinson AI <ray@info.tomlinson.ai>")
                .subject("Verify your email address")
                .to("brian67@gmail.com")
                .addAttachment(
                    EmailSendParams.Attachment.builder()
                        .content("SGVsbG8gV29ybGQ=")
                        .contentType("application/pdf")
                        .filename("invoice.pdf")
                        .build()
                )
                .bccOfStrings(listOf("string"))
                .ccOfStrings(listOf("string"))
                .headers(
                    EmailSendParams.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .html(
                    "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                )
                .replyToOfStrings(listOf("string"))
                .scheduledAt("scheduledAt")
                .addTag(Tag.builder().name("category").value("transactional").build())
                .text("Thank you for signing up! Please verify your email address.")
                .variables(
                    EmailSendParams.Variables.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
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
