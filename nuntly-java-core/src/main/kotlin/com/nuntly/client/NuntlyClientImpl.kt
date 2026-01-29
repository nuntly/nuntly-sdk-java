// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.core.getPackageVersion
import com.nuntly.services.blocking.ApiKeyService
import com.nuntly.services.blocking.ApiKeyServiceImpl
import com.nuntly.services.blocking.DomainService
import com.nuntly.services.blocking.DomainServiceImpl
import com.nuntly.services.blocking.EmailService
import com.nuntly.services.blocking.EmailServiceImpl
import com.nuntly.services.blocking.OrganizationService
import com.nuntly.services.blocking.OrganizationServiceImpl
import com.nuntly.services.blocking.SharedService
import com.nuntly.services.blocking.SharedServiceImpl
import com.nuntly.services.blocking.WebhookService
import com.nuntly.services.blocking.WebhookServiceImpl
import java.util.function.Consumer

class NuntlyClientImpl(private val clientOptions: ClientOptions) : NuntlyClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: NuntlyClientAsync by lazy { NuntlyClientAsyncImpl(clientOptions) }

    private val withRawResponse: NuntlyClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val shared: SharedService by lazy { SharedServiceImpl(clientOptionsWithUserAgent) }

    private val apiKeys: ApiKeyService by lazy { ApiKeyServiceImpl(clientOptionsWithUserAgent) }

    private val domains: DomainService by lazy { DomainServiceImpl(clientOptionsWithUserAgent) }

    private val emails: EmailService by lazy { EmailServiceImpl(clientOptionsWithUserAgent) }

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptionsWithUserAgent) }

    private val organizations: OrganizationService by lazy {
        OrganizationServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): NuntlyClientAsync = async

    override fun withRawResponse(): NuntlyClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NuntlyClient =
        NuntlyClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun shared(): SharedService = shared

    override fun apiKeys(): ApiKeyService = apiKeys

    override fun domains(): DomainService = domains

    override fun emails(): EmailService = emails

    override fun webhooks(): WebhookService = webhooks

    override fun organizations(): OrganizationService = organizations

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NuntlyClient.WithRawResponse {

        private val shared: SharedService.WithRawResponse by lazy {
            SharedServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val apiKeys: ApiKeyService.WithRawResponse by lazy {
            ApiKeyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val domains: DomainService.WithRawResponse by lazy {
            DomainServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val emails: EmailService.WithRawResponse by lazy {
            EmailServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookService.WithRawResponse by lazy {
            WebhookServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val organizations: OrganizationService.WithRawResponse by lazy {
            OrganizationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NuntlyClient.WithRawResponse =
            NuntlyClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun shared(): SharedService.WithRawResponse = shared

        override fun apiKeys(): ApiKeyService.WithRawResponse = apiKeys

        override fun domains(): DomainService.WithRawResponse = domains

        override fun emails(): EmailService.WithRawResponse = emails

        override fun webhooks(): WebhookService.WithRawResponse = webhooks

        override fun organizations(): OrganizationService.WithRawResponse = organizations
    }
}
