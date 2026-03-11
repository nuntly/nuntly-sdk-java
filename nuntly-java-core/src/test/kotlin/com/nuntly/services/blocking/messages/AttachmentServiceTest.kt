// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.messages

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.messages.attachments.AttachmentRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AttachmentServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val attachmentService = client.messages().attachments()

        val messageAttachment =
            attachmentService.retrieve(
                AttachmentRetrieveParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .attachmentId("iatt_01kabn43yqyxn2bx4ve84mczd3")
                    .build()
            )

        messageAttachment.validate()
    }

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val attachmentService = client.messages().attachments()

        val messageAttachments = attachmentService.list("imsg_01kabn43yqyxn2bx4ve84mczd3")

        messageAttachments.forEach { it.validate() }
    }
}
