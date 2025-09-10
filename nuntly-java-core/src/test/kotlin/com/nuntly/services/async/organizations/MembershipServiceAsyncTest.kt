// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async.organizations

import com.nuntly.TestServerExtension
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.models.organizations.memberships.MembershipRevokeParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MembershipServiceAsyncTest {

    @Test
    fun list() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val membershipServiceAsync = client.organizations().memberships()

        val pageFuture = membershipServiceAsync.list("id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun revoke() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val membershipServiceAsync = client.organizations().memberships()

        val responseFuture =
            membershipServiceAsync.revoke(
                MembershipRevokeParams.builder().id("id").userId("user_id").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
