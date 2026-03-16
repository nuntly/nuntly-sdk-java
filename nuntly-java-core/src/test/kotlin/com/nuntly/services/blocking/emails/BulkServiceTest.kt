// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.emails

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.core.JsonValue
import com.nuntly.models.emails.Tag
import com.nuntly.models.emails.bulk.BulkSendParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bulkService = client.emails().bulk()

        val bulk = bulkService.retrieve("blk_01ka8k8s80gvx9604cn9am5st4")

        bulk.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bulkService = client.emails().bulk()

        val response =
            bulkService.send(
                BulkSendParams.builder()
                    .addEmail(
                        BulkSendParams.Email.builder()
                            .bccOfStrings(listOf("string"))
                            .ccOfStrings(listOf("string"))
                            .from("Tomlinson AI <ray@info.tomlinson.ai>")
                            .headers(
                                BulkSendParams.Email.Headers.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .html(
                                "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                            )
                            .replyToOfStrings(listOf("string"))
                            .scheduledAt("scheduledAt")
                            .subject("Verify your email address")
                            .addTag(Tag.builder().name("category").value("transactional").build())
                            .text("Thank you for signing up! Please verify your email address.")
                            .to("brian67@gmail.com")
                            .variables(
                                BulkSendParams.Email.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .fallback(
                        BulkSendParams.Fallback.builder()
                            .bccOfStrings(listOf("string"))
                            .ccOfStrings(listOf("string"))
                            .from("Tomlinson AI <ray@info.tomlinson.ai>")
                            .headers(
                                BulkSendParams.Fallback.Headers.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .html(
                                "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                            )
                            .replyToOfStrings(listOf("string"))
                            .scheduledAt("scheduledAt")
                            .subject("Verify your email address")
                            .addTag(Tag.builder().name("category").value("transactional").build())
                            .text("Thank you for signing up! Please verify your email address.")
                            .to("brian67@gmail.com")
                            .variables(
                                BulkSendParams.Fallback.Variables.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        response.validate()
    }
}
