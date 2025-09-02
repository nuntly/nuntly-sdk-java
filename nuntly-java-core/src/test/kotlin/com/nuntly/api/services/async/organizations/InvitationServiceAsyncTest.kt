// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async.organizations

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.api.models.organizations.invitations.InvitationDeleteParams
import com.nuntly.api.models.organizations.invitations.InvitationSendParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InvitationServiceAsyncTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val invitationServiceAsync = client.organizations().invitations()

        val pageFuture = invitationServiceAsync.list("id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val invitationServiceAsync = client.organizations().invitations()

        val invitationFuture =
            invitationServiceAsync.delete(
                InvitationDeleteParams.builder().id("id").invitationId("invitation_id").build()
            )

        val invitation = invitationFuture.get()
        invitation.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val invitationServiceAsync = client.organizations().invitations()

        val responseFuture =
            invitationServiceAsync.send(
                InvitationSendParams.builder().id("id").email("sarah.connor@sky.net").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
