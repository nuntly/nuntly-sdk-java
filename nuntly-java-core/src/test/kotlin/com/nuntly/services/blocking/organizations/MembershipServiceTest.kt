// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.organizations

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClient
import com.nuntly.models.organizations.memberships.MembershipRevokeParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MembershipServiceTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val membershipService = client.organizations().memberships()

        val page = membershipService.list("id")

        page.response().validate()
    }

    @Test
    fun revoke() {
        val client =
            NuntlyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val membershipService = client.organizations().memberships()

        val response =
            membershipService.revoke(
                MembershipRevokeParams.builder().id("id").userId("user_id").build()
            )

        response.validate()
    }
}
