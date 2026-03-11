// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.core.getPackageVersion
import com.nuntly.services.blocking.AgentService
import com.nuntly.services.blocking.AgentServiceImpl
import com.nuntly.services.blocking.ApiKeyService
import com.nuntly.services.blocking.ApiKeyServiceImpl
import com.nuntly.services.blocking.DomainService
import com.nuntly.services.blocking.DomainServiceImpl
import com.nuntly.services.blocking.EmailService
import com.nuntly.services.blocking.EmailServiceImpl
import com.nuntly.services.blocking.InboxService
import com.nuntly.services.blocking.InboxServiceImpl
import com.nuntly.services.blocking.MessageService
import com.nuntly.services.blocking.MessageServiceImpl
import com.nuntly.services.blocking.NamespaceService
import com.nuntly.services.blocking.NamespaceServiceImpl
import com.nuntly.services.blocking.OrganizationService
import com.nuntly.services.blocking.OrganizationServiceImpl
import com.nuntly.services.blocking.SharedService
import com.nuntly.services.blocking.SharedServiceImpl
import com.nuntly.services.blocking.ThreadService
import com.nuntly.services.blocking.ThreadServiceImpl
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

    private val namespaces: NamespaceService by lazy {
        NamespaceServiceImpl(clientOptionsWithUserAgent)
    }

    private val inboxes: InboxService by lazy { InboxServiceImpl(clientOptionsWithUserAgent) }

    private val threads: ThreadService by lazy { ThreadServiceImpl(clientOptionsWithUserAgent) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptionsWithUserAgent) }

    private val agents: AgentService by lazy { AgentServiceImpl(clientOptionsWithUserAgent) }

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptionsWithUserAgent) }

    private val organizations: OrganizationService by lazy {
        OrganizationServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): NuntlyClientAsync = async

    override fun withRawResponse(): NuntlyClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NuntlyClient =
        NuntlyClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun shared(): SharedService = shared

    /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
    override fun apiKeys(): ApiKeyService = apiKeys

    /**
     * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
     * enable inbound email routing.
     */
    override fun domains(): DomainService = domains

    /**
     * Send transactional emails, retrieve sending history, and track delivery status per message.
     */
    override fun emails(): EmailService = emails

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    override fun namespaces(): NamespaceService = namespaces

    /**
     * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes to
     * namespaces or AI agents.
     */
    override fun inboxes(): InboxService = inboxes

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    override fun threads(): ThreadService = threads

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    override fun messages(): MessageService = messages

    override fun agents(): AgentService = agents

    /**
     * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
     * clicks.
     */
    override fun webhooks(): WebhookService = webhooks

    /** Manage your organization profile, team members, and account-level settings. */
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

        private val namespaces: NamespaceService.WithRawResponse by lazy {
            NamespaceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val inboxes: InboxService.WithRawResponse by lazy {
            InboxServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadService.WithRawResponse by lazy {
            ThreadServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val agents: AgentService.WithRawResponse by lazy {
            AgentServiceImpl.WithRawResponseImpl(clientOptions)
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

        /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
        override fun apiKeys(): ApiKeyService.WithRawResponse = apiKeys

        /**
         * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
         * enable inbound email routing.
         */
        override fun domains(): DomainService.WithRawResponse = domains

        /**
         * Send transactional emails, retrieve sending history, and track delivery status per
         * message.
         */
        override fun emails(): EmailService.WithRawResponse = emails

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        override fun namespaces(): NamespaceService.WithRawResponse = namespaces

        /**
         * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes
         * to namespaces or AI agents.
         */
        override fun inboxes(): InboxService.WithRawResponse = inboxes

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        override fun threads(): ThreadService.WithRawResponse = threads

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        override fun messages(): MessageService.WithRawResponse = messages

        override fun agents(): AgentService.WithRawResponse = agents

        /**
         * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
         * clicks.
         */
        override fun webhooks(): WebhookService.WithRawResponse = webhooks

        /** Manage your organization profile, team members, and account-level settings. */
        override fun organizations(): OrganizationService.WithRawResponse = organizations
    }
}
