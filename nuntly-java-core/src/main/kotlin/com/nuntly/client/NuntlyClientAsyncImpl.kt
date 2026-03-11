// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.core.getPackageVersion
import com.nuntly.services.async.AgentServiceAsync
import com.nuntly.services.async.AgentServiceAsyncImpl
import com.nuntly.services.async.ApiKeyServiceAsync
import com.nuntly.services.async.ApiKeyServiceAsyncImpl
import com.nuntly.services.async.DomainServiceAsync
import com.nuntly.services.async.DomainServiceAsyncImpl
import com.nuntly.services.async.EmailServiceAsync
import com.nuntly.services.async.EmailServiceAsyncImpl
import com.nuntly.services.async.InboxServiceAsync
import com.nuntly.services.async.InboxServiceAsyncImpl
import com.nuntly.services.async.MessageServiceAsync
import com.nuntly.services.async.MessageServiceAsyncImpl
import com.nuntly.services.async.NamespaceServiceAsync
import com.nuntly.services.async.NamespaceServiceAsyncImpl
import com.nuntly.services.async.OrganizationServiceAsync
import com.nuntly.services.async.OrganizationServiceAsyncImpl
import com.nuntly.services.async.SharedServiceAsync
import com.nuntly.services.async.SharedServiceAsyncImpl
import com.nuntly.services.async.ThreadServiceAsync
import com.nuntly.services.async.ThreadServiceAsyncImpl
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

    private val namespaces: NamespaceServiceAsync by lazy {
        NamespaceServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val inboxes: InboxServiceAsync by lazy {
        InboxServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val threads: ThreadServiceAsync by lazy {
        ThreadServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val messages: MessageServiceAsync by lazy {
        MessageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val agents: AgentServiceAsync by lazy {
        AgentServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val webhooks: WebhookServiceAsync by lazy {
        WebhookServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val organizations: OrganizationServiceAsync by lazy {
        OrganizationServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): NuntlyClient = sync

    override fun withRawResponse(): NuntlyClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NuntlyClientAsync =
        NuntlyClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun shared(): SharedServiceAsync = shared

    /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
    override fun apiKeys(): ApiKeyServiceAsync = apiKeys

    /**
     * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
     * enable inbound email routing.
     */
    override fun domains(): DomainServiceAsync = domains

    /**
     * Send transactional emails, retrieve sending history, and track delivery status per message.
     */
    override fun emails(): EmailServiceAsync = emails

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    override fun namespaces(): NamespaceServiceAsync = namespaces

    /**
     * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes to
     * namespaces or AI agents.
     */
    override fun inboxes(): InboxServiceAsync = inboxes

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    override fun threads(): ThreadServiceAsync = threads

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    override fun messages(): MessageServiceAsync = messages

    override fun agents(): AgentServiceAsync = agents

    /**
     * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
     * clicks.
     */
    override fun webhooks(): WebhookServiceAsync = webhooks

    /** Manage your organization profile, team members, and account-level settings. */
    override fun organizations(): OrganizationServiceAsync = organizations

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

        private val namespaces: NamespaceServiceAsync.WithRawResponse by lazy {
            NamespaceServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val inboxes: InboxServiceAsync.WithRawResponse by lazy {
            InboxServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadServiceAsync.WithRawResponse by lazy {
            ThreadServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val agents: AgentServiceAsync.WithRawResponse by lazy {
            AgentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookServiceAsync.WithRawResponse by lazy {
            WebhookServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val organizations: OrganizationServiceAsync.WithRawResponse by lazy {
            OrganizationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NuntlyClientAsync.WithRawResponse =
            NuntlyClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun shared(): SharedServiceAsync.WithRawResponse = shared

        /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
        override fun apiKeys(): ApiKeyServiceAsync.WithRawResponse = apiKeys

        /**
         * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
         * enable inbound email routing.
         */
        override fun domains(): DomainServiceAsync.WithRawResponse = domains

        /**
         * Send transactional emails, retrieve sending history, and track delivery status per
         * message.
         */
        override fun emails(): EmailServiceAsync.WithRawResponse = emails

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        override fun namespaces(): NamespaceServiceAsync.WithRawResponse = namespaces

        /**
         * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes
         * to namespaces or AI agents.
         */
        override fun inboxes(): InboxServiceAsync.WithRawResponse = inboxes

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        override fun threads(): ThreadServiceAsync.WithRawResponse = threads

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        override fun agents(): AgentServiceAsync.WithRawResponse = agents

        /**
         * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
         * clicks.
         */
        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks

        /** Manage your organization profile, team members, and account-level settings. */
        override fun organizations(): OrganizationServiceAsync.WithRawResponse = organizations
    }
}
