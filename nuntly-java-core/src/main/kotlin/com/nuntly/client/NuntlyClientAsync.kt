// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.services.async.AccountServiceAsync
import com.nuntly.services.async.ApiKeyServiceAsync
import com.nuntly.services.async.DomainServiceAsync
import com.nuntly.services.async.EmailServiceAsync
import com.nuntly.services.async.OrganizationServiceAsync
import com.nuntly.services.async.SharedServiceAsync
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

    fun apiKeys(): ApiKeyServiceAsync

    fun domains(): DomainServiceAsync

    fun emails(): EmailServiceAsync

    fun webhooks(): WebhookServiceAsync

    fun organizations(): OrganizationServiceAsync

    fun account(): AccountServiceAsync

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

        fun apiKeys(): ApiKeyServiceAsync.WithRawResponse

        fun domains(): DomainServiceAsync.WithRawResponse

        fun emails(): EmailServiceAsync.WithRawResponse

        fun webhooks(): WebhookServiceAsync.WithRawResponse

        fun organizations(): OrganizationServiceAsync.WithRawResponse

        fun account(): AccountServiceAsync.WithRawResponse
    }
}
