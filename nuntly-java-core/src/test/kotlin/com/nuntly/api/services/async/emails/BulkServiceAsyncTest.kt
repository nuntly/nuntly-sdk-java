// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.emails

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.api.core.JsonValue
import com.nuntly.api.models.emails.bulk.BulkSendParams
import com.nuntly.api.models.shared.EmailHeaders
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BulkServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bulkServiceAsync = client.emails().bulk()

        val bulkFuture =
            bulkServiceAsync.retrieve("blk_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")

        val bulk = bulkFuture.get()
        bulk.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bulkServiceAsync = client.emails().bulk()

        val responseFuture =
            bulkServiceAsync.send(
                BulkSendParams.builder()
                    .addEmail(
                        BulkSendParams.Email.builder()
                            .to("carlo43@gmail.com")
                            .bccOfStrings(listOf("string"))
                            .ccOfStrings(listOf("string"))
                            .context(JsonValue.from(mapOf<String, Any>()))
                            .from("ray@info.tomlinson.ai")
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
                            .subject("Welcome to Tomlinson AI!")
                            .addTag(
                                BulkSendParams.Email.Tag.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .text("text")
                            .build()
                    )
                    .addEmail(
                        BulkSendParams.Email.builder()
                            .to("pink42@yahoo.com")
                            .bccOfStrings(listOf("string"))
                            .ccOfStrings(listOf("string"))
                            .context(JsonValue.from(mapOf<String, Any>()))
                            .from("ray@info.tomlinson.ai")
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
                            .subject("Welcome to Tomlinson AI!")
                            .addTag(
                                BulkSendParams.Email.Tag.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .text("text")
                            .build()
                    )
                    .fallback(
                        BulkSendParams.Fallback.builder()
                            .bccOfStrings(listOf("string"))
                            .ccOfStrings(listOf("string"))
                            .context(JsonValue.from(mapOf<String, Any>()))
                            .from("from")
                            .headers(
                                EmailHeaders.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .html("html")
                            .replyToOfStrings(listOf("string"))
                            .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .subject("subject")
                            .addTag(
                                BulkSendParams.Fallback.Tag.builder()
                                    .name("name")
                                    .value("value")
                                    .build()
                            )
                            .text("text")
                            .toOfStrings(listOf("string"))
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
