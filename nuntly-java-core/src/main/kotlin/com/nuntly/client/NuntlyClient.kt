// File generated from our OpenAPI spec by Stainless.

package com.nuntly.client

import com.nuntly.core.ClientOptions
import com.nuntly.services.blocking.ApiKeyService
import com.nuntly.services.blocking.DomainService
import com.nuntly.services.blocking.EmailService
import com.nuntly.services.blocking.OrganizationService
import com.nuntly.services.blocking.SharedService
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

    /** Operations related to API keys management */
    fun apiKeys(): ApiKeyService

    /** Operations related to Domain management */
    fun domains(): DomainService

    /** Operations related to Email management */
    fun emails(): EmailService

    /** Operations related to Webhook management */
    fun webhooks(): WebhookService

    /** Operations related to Organization management */
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

        /** Operations related to API keys management */
        fun apiKeys(): ApiKeyService.WithRawResponse

        /** Operations related to Domain management */
        fun domains(): DomainService.WithRawResponse

        /** Operations related to Email management */
        fun emails(): EmailService.WithRawResponse

        /** Operations related to Webhook management */
        fun webhooks(): WebhookService.WithRawResponse

        /** Operations related to Organization management */
        fun organizations(): OrganizationService.WithRawResponse
    }
}
