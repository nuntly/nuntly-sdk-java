// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.core.getPackageVersion
import com.nuntly.services.async.AccountServiceAsync
import com.nuntly.services.async.AccountServiceAsyncImpl
import com.nuntly.services.async.ApiKeyServiceAsync
import com.nuntly.services.async.ApiKeyServiceAsyncImpl
import com.nuntly.services.async.DomainServiceAsync
import com.nuntly.services.async.DomainServiceAsyncImpl
import com.nuntly.services.async.EmailServiceAsync
import com.nuntly.services.async.EmailServiceAsyncImpl
import com.nuntly.services.async.OrganizationServiceAsync
import com.nuntly.services.async.OrganizationServiceAsyncImpl
import com.nuntly.services.async.SharedServiceAsync
import com.nuntly.services.async.SharedServiceAsyncImpl
import com.nuntly.services.async.WebhookServiceAsync
import com.nuntly.services.async.WebhookServiceAsyncImpl
import java.util.function.Consumer

class NuntlyClientAsyncImpl(private val clientOptions: ClientOptions) : NuntlyClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: NuntlyClient by lazy { NuntlyClientImpl(clientOptions) }

    private val withRawResponse: NuntlyClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val shared: SharedServiceAsync by lazy {
        SharedServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val apiKeys: ApiKeyServiceAsync by lazy {
        ApiKeyServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val domains: DomainServiceAsync by lazy {
        DomainServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val emails: EmailServiceAsync by lazy {
        EmailServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val webhooks: WebhookServiceAsync by lazy {
        WebhookServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val organizations: OrganizationServiceAsync by lazy {
        OrganizationServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val account: AccountServiceAsync by lazy {
        AccountServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): NuntlyClient = sync

    override fun withRawResponse(): NuntlyClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NuntlyClientAsync =
        NuntlyClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun shared(): SharedServiceAsync = shared

    override fun apiKeys(): ApiKeyServiceAsync = apiKeys

    override fun domains(): DomainServiceAsync = domains

    override fun emails(): EmailServiceAsync = emails

    override fun webhooks(): WebhookServiceAsync = webhooks

    override fun organizations(): OrganizationServiceAsync = organizations

    override fun account(): AccountServiceAsync = account

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NuntlyClientAsync.WithRawResponse {

        private val shared: SharedServiceAsync.WithRawResponse by lazy {
            SharedServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val apiKeys: ApiKeyServiceAsync.WithRawResponse by lazy {
            ApiKeyServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val domains: DomainServiceAsync.WithRawResponse by lazy {
            DomainServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val emails: EmailServiceAsync.WithRawResponse by lazy {
            EmailServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookServiceAsync.WithRawResponse by lazy {
            WebhookServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val organizations: OrganizationServiceAsync.WithRawResponse by lazy {
            OrganizationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val account: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NuntlyClientAsync.WithRawResponse =
            NuntlyClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun shared(): SharedServiceAsync.WithRawResponse = shared

        override fun apiKeys(): ApiKeyServiceAsync.WithRawResponse = apiKeys

        override fun domains(): DomainServiceAsync.WithRawResponse = domains

        override fun emails(): EmailServiceAsync.WithRawResponse = emails

        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks

        override fun organizations(): OrganizationServiceAsync.WithRawResponse = organizations

        override fun account(): AccountServiceAsync.WithRawResponse = account
    }
}
