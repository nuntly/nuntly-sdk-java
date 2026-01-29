// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.core.JsonValue
import com.nuntly.models.emails.EmailSendParams
import com.nuntly.models.emails.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EmailServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailServiceAsync = client.emails()

        val emailFuture = emailServiceAsync.retrieve("em_01ka8k8s80gvx9604cn9am5st4")

        val email = emailFuture.get()
        email.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailServiceAsync = client.emails()

        val pageFuture = emailServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun cancel() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailServiceAsync = client.emails()

        val responseFuture = emailServiceAsync.cancel("em_01ka8k8s80gvx9604cn9am5st4")

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailServiceAsync = client.emails()

        val responseFuture =
            emailServiceAsync.send(
                EmailSendParams.builder()
                    .from("from")
                    .subject("subject")
                    .toOfStrings(listOf("string"))
                    .addAttachment(
                        EmailSendParams.Attachment.builder()
                            .content("content")
                            .contentType("contentType")
                            .filename("filename")
                            .build()
                    )
                    .bccOfStrings(listOf("string"))
                    .ccOfStrings(listOf("string"))
                    .context(
                        EmailSendParams.Context.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .headers(
                        EmailSendParams.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .html("html")
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .addTag(Tag.builder().name("name").value("value").build())
                    .text("text")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
