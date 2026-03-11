// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.messages

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.messages.content.ContentRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContentServiceTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contentService = client.messages().content()

        val messageContent =
            contentService.retrieve(
                ContentRetrieveParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .addFormat(ContentRetrieveParams.Format.HTML)
                    .build()
            )

        messageContent.validate()
    }
}
