// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.core.JsonValue
import com.nuntly.models.emails.EmailSendParams
import com.nuntly.models.emails.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EmailServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailService = client.emails()

        val email = emailService.retrieve("em_01ka8k8s80gvx9604cn9am5st4")

        email.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailService = client.emails()

        val page = emailService.list()

        page.response().validate()
    }

    @Test
    fun cancel() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailService = client.emails()

        val response = emailService.cancel("em_01ka8k8s80gvx9604cn9am5st4")

        response.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val emailService = client.emails()

        val response =
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
                    .html(
                        "<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>"
                    )
                    .replyToOfStrings(listOf("string"))
                    .scheduledAt("scheduledAt")
                    .addTag(Tag.builder().name("category").value("transactional").build())
                    .text("Thank you for signing up! Please verify your email address.")
                    .build()
            )

        response.validate()
    }
}
