// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.namespaces

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.namespaces.inboxes.InboxListPage
import com.nuntly.models.namespaces.inboxes.InboxListParams
import java.util.function.Consumer

/**
 * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
 * namespaces to your own data model.
 */
interface InboxService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxService

    /** List inboxes in a namespace. */
    fun list(namespaceId: String): InboxListPage = list(namespaceId, InboxListParams.none())

    /** @see list */
    fun list(
        namespaceId: String,
        params: InboxListParams = InboxListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxListPage = list(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see list */
    fun list(namespaceId: String, params: InboxListParams = InboxListParams.none()): InboxListPage =
        list(namespaceId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: InboxListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboxListPage

    /** @see list */
    fun list(params: InboxListParams): InboxListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(namespaceId: String, requestOptions: RequestOptions): InboxListPage =
        list(namespaceId, InboxListParams.none(), requestOptions)

    /** A view of [InboxService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /namespaces/{namespaceId}/inboxes`, but is otherwise
         * the same as [InboxService.list].
         */
        @MustBeClosed
        fun list(namespaceId: String): HttpResponseFor<InboxListPage> =
            list(namespaceId, InboxListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            namespaceId: String,
            params: InboxListParams = InboxListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxListPage> =
            list(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            namespaceId: String,
            params: InboxListParams = InboxListParams.none(),
        ): HttpResponseFor<InboxListPage> = list(namespaceId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: InboxListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboxListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: InboxListParams): HttpResponseFor<InboxListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxListPage> =
            list(namespaceId, InboxListParams.none(), requestOptions)
    }
}
