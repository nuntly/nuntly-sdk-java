// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.messages

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.messages.content.ContentRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContentServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contentServiceAsync = client.messages().content()

        val messageContentFuture =
            contentServiceAsync.retrieve(
                ContentRetrieveParams.builder()
                    .messageId("imsg_01kabn43yqyxn2bx4ve84mczd3")
                    .addFormat(ContentRetrieveParams.Format.HTML)
                    .build()
            )

        val messageContent = messageContentFuture.get()
        messageContent.validate()
    }
}
