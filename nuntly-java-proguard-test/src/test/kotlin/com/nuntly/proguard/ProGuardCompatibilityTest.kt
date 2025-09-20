// File generated from our OpenAPI spec by Stainless.

package com.nuntly.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.core.JsonValue
import com.nuntly.core.jsonMapper
import com.nuntly.models.apikeys.ApiKeyCreateResponse
import com.nuntly.models.shared.BulkEmailsStatus
import com.nuntly.models.shared.EmailEvent
import com.nuntly.models.shared.EventType
import com.nuntly.models.shared.SendDetail
import com.nuntly.models.webhooks.BaseEvent
import com.nuntly.models.webhooks.EmailSentEvent
import com.nuntly.models.webhooks.Event
import java.time.OffsetDateTime
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
        assertThat(client.account()).isNotNull()
    }

    @Test
    fun apiKeyCreateResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyCreateResponse =
            ApiKeyCreateResponse.builder()
                .id("apk_01jnx372zj49s3zqnn7ew8hzpk")
                .apikey("ntly_****_***************")
                .apikeyTruncated("GGvLoL")
                .createdAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                .kind(ApiKeyCreateResponse.Kind.API_KEY)
                .orgId("org_01jh6jk82zjq9deye73h0mzcaq")
                .region(ApiKeyCreateResponse.Region.EU_WEST_1)
                .status(ApiKeyCreateResponse.Status.ENABLED)
                .userId("user_01jh6jk831bzen14edngw38we9")
                .modifiedAt(OffsetDateTime.parse("2025-03-09T09:19:13.394Z"))
                .name("My API key")
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
            Event.ofEmailSent(
                EmailSentEvent.builder()
                    .id("id")
                    .createdAt("created_at")
                    .type(EventType.EMAIL_SENT)
                    .kind(BaseEvent.Kind.EVENT)
                    .data(
                        EmailSentEvent.Data.builder()
                            .id("id")
                            .domain("domain")
                            .domainId("domain_id")
                            .enqueueAt("enqueue_at")
                            .from("from")
                            .messageId("message_id")
                            .orgId("org_id")
                            .sentAt("sent_at")
                            .subject("subject")
                            .to("string")
                            .bcc("string")
                            .bulkId("bulk_id")
                            .cc("string")
                            .addHeader(
                                EmailEvent.Header.builder().name("name").value("value").build()
                            )
                            .replyTo("string")
                            .tags(
                                EmailEvent.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .send(SendDetail.builder().build())
                            .build()
                    )
                    .build()
            )

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
    }

    @Test
    fun bulkEmailsStatusRoundtrip() {
        val jsonMapper = jsonMapper()
        val bulkEmailsStatus = BulkEmailsStatus.QUEUED

        val roundtrippedBulkEmailsStatus =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bulkEmailsStatus),
                jacksonTypeRef<BulkEmailsStatus>(),
            )

        assertThat(roundtrippedBulkEmailsStatus).isEqualTo(bulkEmailsStatus)
    }
}
