// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.messages

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.messages.attachments.AttachmentRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AttachmentServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val attachmentServiceAsync = client.messages().attachments()

        val messageAttachmentFuture =
            attachmentServiceAsync.retrieve(
                AttachmentRetrieveParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .attachmentId("iatt_01kabn43yqyxn2bx4ve84mczd3")
                    .build()
            )

        val messageAttachment = messageAttachmentFuture.get()
        messageAttachment.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val attachmentServiceAsync = client.messages().attachments()

        val messageAttachmentsFuture =
            attachmentServiceAsync.list("imsg_01kabn43yqyxn2bx4ve84mczd3")

        val messageAttachments = messageAttachmentsFuture.get()
        messageAttachments.forEach { it.validate() }
    }
}
