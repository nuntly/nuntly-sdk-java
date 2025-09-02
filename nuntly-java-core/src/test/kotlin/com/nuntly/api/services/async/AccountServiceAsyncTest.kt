// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async

import com.nuntly.api.TestServerExtension
import com.nuntly.api.client.okhttp.NuntlyOkHttpClientAsync
import com.nuntly.api.models.account.AccountUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AccountServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.account()

        val accountFuture = accountServiceAsync.retrieve()

        val account = accountFuture.get()
        account.validate()
    }

    @Test
    fun update() {
        val client =
            NuntlyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountServiceAsync = client.account()

        val accountFuture =
            accountServiceAsync.update(
                AccountUpdateParams.builder().displayName("Ray Tomlinson").build()
            )

        val account = accountFuture.get()
        account.validate()
    }
}
