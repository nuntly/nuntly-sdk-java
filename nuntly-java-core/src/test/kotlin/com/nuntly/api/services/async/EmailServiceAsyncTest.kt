// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.api.core.JsonValue
import com.nuntly.api.models.emails.EmailSendParams
import java.time.OffsetDateTime
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

        val emailFuture =
            emailServiceAsync.retrieve("em_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")

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

        val responseFuture =
            emailServiceAsync.cancel("em_qiPSkLrTmXvDohbxCcYt3pFEMGgnjHD6kbDL8d4uGKvNGboT")

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
                        EmailSendParams.Headers.builder()
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
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
