// File generated from our OpenAPI spec by Stainless.

package com.nuntly.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.apikeys.ApiKeyCreateResponse
import com.nuntly.models.emails.Status
import com.nuntly.models.webhooks.EmailQueuedEvent
import com.nuntly.models.webhooks.Event
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/nuntly-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = NuntlyOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.shared()).isNotNull()
        assertThat(client.apiKeys()).isNotNull()
        assertThat(client.domains()).isNotNull()
        assertThat(client.emails()).isNotNull()
        assertThat(client.webhooks()).isNotNull()
        assertThat(client.organizations()).isNotNull()
    }

    @Test
    fun apiKeyCreateResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("apk_01ka8k8s80gvx9604cn9am5st4")
                .apiKey("apiKey")
                .shortToken("shortToken")
                .status(ApiKeyCreateResponse.Status.ENABLED)
                .name("name")
                .build()

        val roundtrippedApiKeyCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyCreateResponse),
                jacksonTypeRef<ApiKeyCreateResponse>(),
            )

        assertThat(roundtrippedApiKeyCreateResponse).isEqualTo(apiKeyCreateResponse)
    }

    @Test
    fun eventRoundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.ofEmailQueued(
                EmailQueuedEvent.builder()
                    .id("id")
                    .createdAt("createdAt")
                    .data(
                        EmailQueuedEvent.Data.builder()
                            .queue(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                    .type(EmailQueuedEvent.Type.EMAIL_QUEUED)
                    .build()
            )

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
    }

    @Test
    fun statusRoundtrip() {
        val jsonMapper = jsonMapper()
        val status = Status.QUEUED

        val roundtrippedStatus =
            jsonMapper.readValue(jsonMapper.writeValueAsString(status), jacksonTypeRef<Status>())

        assertThat(roundtrippedStatus).isEqualTo(status)
    }
}
