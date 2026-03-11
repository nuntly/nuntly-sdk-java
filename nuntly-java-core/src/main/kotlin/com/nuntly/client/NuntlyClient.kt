// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.services.blocking.AgentService
import com.nuntly.services.blocking.ApiKeyService
import com.nuntly.services.blocking.DomainService
import com.nuntly.services.blocking.EmailService
import com.nuntly.services.blocking.InboxService
import com.nuntly.services.blocking.MessageService
import com.nuntly.services.blocking.NamespaceService
import com.nuntly.services.blocking.OrganizationService
import com.nuntly.services.blocking.SharedService
import com.nuntly.services.blocking.ThreadService
import com.nuntly.services.blocking.WebhookService
import java.util.function.Consumer

/**
 * A client for interacting with the Nuntly REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface NuntlyClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): NuntlyClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NuntlyClient

    fun shared(): SharedService

    /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
    fun apiKeys(): ApiKeyService

    /**
     * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
     * enable inbound email routing.
     */
    fun domains(): DomainService

    /**
     * Send transactional emails, retrieve sending history, and track delivery status per message.
     */
    fun emails(): EmailService

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    fun namespaces(): NamespaceService

    /**
     * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes to
     * namespaces or AI agents.
     */
    fun inboxes(): InboxService

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    fun threads(): ThreadService

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    fun messages(): MessageService

    fun agents(): AgentService

    /**
     * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
     * clicks.
     */
    fun webhooks(): WebhookService

    /** Manage your organization profile, team members, and account-level settings. */
    fun organizations(): OrganizationService

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /** A view of [NuntlyClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): NuntlyClient.WithRawResponse

        fun shared(): SharedService.WithRawResponse

        /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
        fun apiKeys(): ApiKeyService.WithRawResponse

        /**
         * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
         * enable inbound email routing.
         */
        fun domains(): DomainService.WithRawResponse

        /**
         * Send transactional emails, retrieve sending history, and track delivery status per
         * message.
         */
        fun emails(): EmailService.WithRawResponse

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        fun namespaces(): NamespaceService.WithRawResponse

        /**
         * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes
         * to namespaces or AI agents.
         */
        fun inboxes(): InboxService.WithRawResponse

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        fun threads(): ThreadService.WithRawResponse

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        fun messages(): MessageService.WithRawResponse

        fun agents(): AgentService.WithRawResponse

        /**
         * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
         * clicks.
         */
        fun webhooks(): WebhookService.WithRawResponse

        /** Manage your organization profile, team members, and account-level settings. */
        fun organizations(): OrganizationService.WithRawResponse
    }
}
