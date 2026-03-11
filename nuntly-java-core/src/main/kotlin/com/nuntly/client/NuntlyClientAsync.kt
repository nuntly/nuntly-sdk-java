// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.services.async.AgentServiceAsync
import com.nuntly.services.async.ApiKeyServiceAsync
import com.nuntly.services.async.DomainServiceAsync
import com.nuntly.services.async.EmailServiceAsync
import com.nuntly.services.async.InboxServiceAsync
import com.nuntly.services.async.MessageServiceAsync
import com.nuntly.services.async.NamespaceServiceAsync
import com.nuntly.services.async.OrganizationServiceAsync
import com.nuntly.services.async.SharedServiceAsync
import com.nuntly.services.async.ThreadServiceAsync
import com.nuntly.services.async.WebhookServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Nuntly REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
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
interface NuntlyClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): NuntlyClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NuntlyClientAsync

    fun shared(): SharedServiceAsync

    /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
    fun apiKeys(): ApiKeyServiceAsync

    /**
     * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
     * enable inbound email routing.
     */
    fun domains(): DomainServiceAsync

    /**
     * Send transactional emails, retrieve sending history, and track delivery status per message.
     */
    fun emails(): EmailServiceAsync

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    fun namespaces(): NamespaceServiceAsync

    /**
     * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes to
     * namespaces or AI agents.
     */
    fun inboxes(): InboxServiceAsync

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    fun threads(): ThreadServiceAsync

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    fun messages(): MessageServiceAsync

    fun agents(): AgentServiceAsync

    /**
     * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
     * clicks.
     */
    fun webhooks(): WebhookServiceAsync

    /** Manage your organization profile, team members, and account-level settings. */
    fun organizations(): OrganizationServiceAsync

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

    /** A view of [NuntlyClientAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NuntlyClientAsync.WithRawResponse

        fun shared(): SharedServiceAsync.WithRawResponse

        /** Create and revoke API keys used to authenticate requests to the Nuntly API. */
        fun apiKeys(): ApiKeyServiceAsync.WithRawResponse

        /**
         * Add and verify sending and receiving domains. Manage DKIM records, SPF configuration, and
         * enable inbound email routing.
         */
        fun domains(): DomainServiceAsync.WithRawResponse

        /**
         * Send transactional emails, retrieve sending history, and track delivery status per
         * message.
         */
        fun emails(): EmailServiceAsync.WithRawResponse

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        fun namespaces(): NamespaceServiceAsync.WithRawResponse

        /**
         * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes
         * to namespaces or AI agents.
         */
        fun inboxes(): InboxServiceAsync.WithRawResponse

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        fun threads(): ThreadServiceAsync.WithRawResponse

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        fun messages(): MessageServiceAsync.WithRawResponse

        fun agents(): AgentServiceAsync.WithRawResponse

        /**
         * Register HTTP endpoints to receive real-time delivery events such as bounces, opens, and
         * clicks.
         */
        fun webhooks(): WebhookServiceAsync.WithRawResponse

        /** Manage your organization profile, team members, and account-level settings. */
        fun organizations(): OrganizationServiceAsync.WithRawResponse
    }
}
