// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.emails

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.core.JsonValue
import com.nuntly.models.emails.Tag
import com.nuntly.models.emails.bulk.BulkSendParams
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

        val bulkFuture = bulkServiceAsync.retrieve("blk_01ka8k8s80gvx9604cn9am5st4")

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
                            .bccOfStrings(listOf("string"))
                            .ccOfStrings(listOf("string"))
                            .context(
                                BulkSendParams.Email.Context.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .from("from")
                            .headers(
                                BulkSendParams.Email.Headers.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .html("html")
                            .replyToOfStrings(listOf("string"))
                            .scheduledAt("scheduledAt")
                            .subject("subject")
                            .addTag(Tag.builder().name("name").value("value").build())
                            .text("text")
                            .toOfStrings(listOf("string"))
                            .build()
                    )
                    .fallback(
                        BulkSendParams.Fallback.builder()
                            .bccOfStrings(listOf("string"))
                            .ccOfStrings(listOf("string"))
                            .context(
                                BulkSendParams.Fallback.Context.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .from("from")
                            .headers(
                                BulkSendParams.Fallback.Headers.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .html("html")
                            .replyToOfStrings(listOf("string"))
                            .scheduledAt("scheduledAt")
                            .subject("subject")
                            .addTag(Tag.builder().name("name").value("value").build())
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
