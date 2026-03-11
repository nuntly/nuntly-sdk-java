// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.namespaces.Namespace
import com.nuntly.models.namespaces.NamespaceCreateParams
import com.nuntly.models.namespaces.NamespaceDeleteParams
import com.nuntly.models.namespaces.NamespaceDeleteResponse
import com.nuntly.models.namespaces.NamespaceDetail
import com.nuntly.models.namespaces.NamespaceListPageAsync
import com.nuntly.models.namespaces.NamespaceListParams
import com.nuntly.models.namespaces.NamespaceRetrieveParams
import com.nuntly.models.namespaces.NamespaceUpdateParams
import com.nuntly.models.namespaces.NamespaceUpdateResponse
import com.nuntly.services.async.namespaces.InboxServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
 * namespaces to your own data model.
 */
interface NamespaceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceServiceAsync

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    fun inboxes(): InboxServiceAsync

    /** Create a new namespace. */
    fun create(params: NamespaceCreateParams): CompletableFuture<Namespace> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: NamespaceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Namespace>

    /** Retrieve a namespace with inbox stats. */
    fun retrieve(namespaceId: String): CompletableFuture<NamespaceDetail> =
        retrieve(namespaceId, NamespaceRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        namespaceId: String,
        params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDetail> =
        retrieve(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        namespaceId: String,
        params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
    ): CompletableFuture<NamespaceDetail> = retrieve(namespaceId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: NamespaceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDetail>

    /** @see retrieve */
    fun retrieve(params: NamespaceRetrieveParams): CompletableFuture<NamespaceDetail> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        namespaceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceDetail> =
        retrieve(namespaceId, NamespaceRetrieveParams.none(), requestOptions)

    /** Update a namespace. */
    fun update(namespaceId: String): CompletableFuture<NamespaceUpdateResponse> =
        update(namespaceId, NamespaceUpdateParams.none())

    /** @see update */
    fun update(
        namespaceId: String,
        params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceUpdateResponse> =
        update(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see update */
    fun update(
        namespaceId: String,
        params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
    ): CompletableFuture<NamespaceUpdateResponse> =
        update(namespaceId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: NamespaceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceUpdateResponse>

    /** @see update */
    fun update(params: NamespaceUpdateParams): CompletableFuture<NamespaceUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        namespaceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceUpdateResponse> =
        update(namespaceId, NamespaceUpdateParams.none(), requestOptions)

    /** List all namespaces. */
    fun list(): CompletableFuture<NamespaceListPageAsync> = list(NamespaceListParams.none())

    /** @see list */
    fun list(
        params: NamespaceListParams = NamespaceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceListPageAsync>

    /** @see list */
    fun list(
        params: NamespaceListParams = NamespaceListParams.none()
    ): CompletableFuture<NamespaceListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<NamespaceListPageAsync> =
        list(NamespaceListParams.none(), requestOptions)

    /** Soft-delete a namespace. Rejects if it has active inboxes. */
    fun delete(namespaceId: String): CompletableFuture<NamespaceDeleteResponse> =
        delete(namespaceId, NamespaceDeleteParams.none())

    /** @see delete */
    fun delete(
        namespaceId: String,
        params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDeleteResponse> =
        delete(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see delete */
    fun delete(
        namespaceId: String,
        params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
    ): CompletableFuture<NamespaceDeleteResponse> =
        delete(namespaceId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: NamespaceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NamespaceDeleteResponse>

    /** @see delete */
    fun delete(params: NamespaceDeleteParams): CompletableFuture<NamespaceDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        namespaceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceDeleteResponse> =
        delete(namespaceId, NamespaceDeleteParams.none(), requestOptions)

    /**
     * A view of [NamespaceServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NamespaceServiceAsync.WithRawResponse

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        fun inboxes(): InboxServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /namespaces`, but is otherwise the same as
         * [NamespaceServiceAsync.create].
         */
        fun create(params: NamespaceCreateParams): CompletableFuture<HttpResponseFor<Namespace>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: NamespaceCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Namespace>>

        /**
         * Returns a raw HTTP response for `get /namespaces/{namespaceId}`, but is otherwise the
         * same as [NamespaceServiceAsync.retrieve].
         */
        fun retrieve(namespaceId: String): CompletableFuture<HttpResponseFor<NamespaceDetail>> =
            retrieve(namespaceId, NamespaceRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            namespaceId: String,
            params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDetail>> =
            retrieve(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            namespaceId: String,
            params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDetail>> =
            retrieve(namespaceId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: NamespaceRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDetail>>

        /** @see retrieve */
        fun retrieve(
            params: NamespaceRetrieveParams
        ): CompletableFuture<HttpResponseFor<NamespaceDetail>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceDetail>> =
            retrieve(namespaceId, NamespaceRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /namespaces/{namespaceId}`, but is otherwise the
         * same as [NamespaceServiceAsync.update].
         */
        fun update(
            namespaceId: String
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateResponse>> =
            update(namespaceId, NamespaceUpdateParams.none())

        /** @see update */
        fun update(
            namespaceId: String,
            params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateResponse>> =
            update(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see update */
        fun update(
            namespaceId: String,
            params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateResponse>> =
            update(namespaceId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: NamespaceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateResponse>>

        /** @see update */
        fun update(
            params: NamespaceUpdateParams
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateResponse>> =
            update(namespaceId, NamespaceUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /namespaces`, but is otherwise the same as
         * [NamespaceServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>> =
            list(NamespaceListParams.none())

        /** @see list */
        fun list(
            params: NamespaceListParams = NamespaceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>>

        /** @see list */
        fun list(
            params: NamespaceListParams = NamespaceListParams.none()
        ): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>> =
            list(NamespaceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /namespaces/{namespaceId}`, but is otherwise the
         * same as [NamespaceServiceAsync.delete].
         */
        fun delete(
            namespaceId: String
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteResponse>> =
            delete(namespaceId, NamespaceDeleteParams.none())

        /** @see delete */
        fun delete(
            namespaceId: String,
            params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteResponse>> =
            delete(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see delete */
        fun delete(
            namespaceId: String,
            params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteResponse>> =
            delete(namespaceId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: NamespaceDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteResponse>>

        /** @see delete */
        fun delete(
            params: NamespaceDeleteParams
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteResponse>> =
            delete(namespaceId, NamespaceDeleteParams.none(), requestOptions)
    }
}
