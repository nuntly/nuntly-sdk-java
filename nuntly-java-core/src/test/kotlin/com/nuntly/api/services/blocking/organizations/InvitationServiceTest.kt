// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking.organizations

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClient
import com.nuntly.api.models.organizations.invitations.InvitationDeleteParams
import com.nuntly.api.models.organizations.invitations.InvitationSendParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InvitationServiceTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val invitationService = client.organizations().invitations()

        val page = invitationService.list("id")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val invitationService = client.organizations().invitations()

        val invitation =
            invitationService.delete(
                InvitationDeleteParams.builder().id("id").invitationId("invitation_id").build()
            )

        invitation.validate()
    }

    @Test
    fun send() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val invitationService = client.organizations().invitations()

        val response =
            invitationService.send(
                InvitationSendParams.builder().id("id").email("sarah.connor@sky.net").build()
            )

        response.validate()
    }
}
