// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.namespaces.Namespace
import com.nuntly.models.namespaces.NamespaceCreateParams
import com.nuntly.models.namespaces.NamespaceDeleteParams
import com.nuntly.models.namespaces.NamespaceDeleteResponse
import com.nuntly.models.namespaces.NamespaceDetail
import com.nuntly.models.namespaces.NamespaceListPage
import com.nuntly.models.namespaces.NamespaceListParams
import com.nuntly.models.namespaces.NamespaceRetrieveParams
import com.nuntly.models.namespaces.NamespaceUpdateParams
import com.nuntly.models.namespaces.NamespaceUpdateResponse
import com.nuntly.services.blocking.namespaces.InboxService
import java.util.function.Consumer

/**
 * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
 * namespaces to your own data model.
 */
interface NamespaceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceService

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    fun inboxes(): InboxService

    /** Create a new namespace. */
    fun create(params: NamespaceCreateParams): Namespace = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: NamespaceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Namespace

    /** Retrieve a namespace with inbox stats. */
    fun retrieve(namespaceId: String): NamespaceDetail =
        retrieve(namespaceId, NamespaceRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        namespaceId: String,
        params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceDetail =
        retrieve(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        namespaceId: String,
        params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
    ): NamespaceDetail = retrieve(namespaceId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: NamespaceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceDetail

    /** @see retrieve */
    fun retrieve(params: NamespaceRetrieveParams): NamespaceDetail =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(namespaceId: String, requestOptions: RequestOptions): NamespaceDetail =
        retrieve(namespaceId, NamespaceRetrieveParams.none(), requestOptions)

    /** Update a namespace. */
    fun update(namespaceId: String): NamespaceUpdateResponse =
        update(namespaceId, NamespaceUpdateParams.none())

    /** @see update */
    fun update(
        namespaceId: String,
        params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceUpdateResponse =
        update(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see update */
    fun update(
        namespaceId: String,
        params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
    ): NamespaceUpdateResponse = update(namespaceId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: NamespaceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceUpdateResponse

    /** @see update */
    fun update(params: NamespaceUpdateParams): NamespaceUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(namespaceId: String, requestOptions: RequestOptions): NamespaceUpdateResponse =
        update(namespaceId, NamespaceUpdateParams.none(), requestOptions)

    /** List all namespaces. */
    fun list(): NamespaceListPage = list(NamespaceListParams.none())

    /** @see list */
    fun list(
        params: NamespaceListParams = NamespaceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceListPage

    /** @see list */
    fun list(params: NamespaceListParams = NamespaceListParams.none()): NamespaceListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): NamespaceListPage =
        list(NamespaceListParams.none(), requestOptions)

    /** Soft-delete a namespace. Rejects if it has active inboxes. */
    fun delete(namespaceId: String): NamespaceDeleteResponse =
        delete(namespaceId, NamespaceDeleteParams.none())

    /** @see delete */
    fun delete(
        namespaceId: String,
        params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceDeleteResponse =
        delete(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

    /** @see delete */
    fun delete(
        namespaceId: String,
        params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
    ): NamespaceDeleteResponse = delete(namespaceId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: NamespaceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NamespaceDeleteResponse

    /** @see delete */
    fun delete(params: NamespaceDeleteParams): NamespaceDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(namespaceId: String, requestOptions: RequestOptions): NamespaceDeleteResponse =
        delete(namespaceId, NamespaceDeleteParams.none(), requestOptions)

    /** A view of [NamespaceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceService.WithRawResponse

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        fun inboxes(): InboxService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /namespaces`, but is otherwise the same as
         * [NamespaceService.create].
         */
        @MustBeClosed
        fun create(params: NamespaceCreateParams): HttpResponseFor<Namespace> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: NamespaceCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Namespace>

        /**
         * Returns a raw HTTP response for `get /namespaces/{namespaceId}`, but is otherwise the
         * same as [NamespaceService.retrieve].
         */
        @MustBeClosed
        fun retrieve(namespaceId: String): HttpResponseFor<NamespaceDetail> =
            retrieve(namespaceId, NamespaceRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            namespaceId: String,
            params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceDetail> =
            retrieve(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            namespaceId: String,
            params: NamespaceRetrieveParams = NamespaceRetrieveParams.none(),
        ): HttpResponseFor<NamespaceDetail> = retrieve(namespaceId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: NamespaceRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceDetail>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: NamespaceRetrieveParams): HttpResponseFor<NamespaceDetail> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceDetail> =
            retrieve(namespaceId, NamespaceRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /namespaces/{namespaceId}`, but is otherwise the
         * same as [NamespaceService.update].
         */
        @MustBeClosed
        fun update(namespaceId: String): HttpResponseFor<NamespaceUpdateResponse> =
            update(namespaceId, NamespaceUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            namespaceId: String,
            params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceUpdateResponse> =
            update(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            namespaceId: String,
            params: NamespaceUpdateParams = NamespaceUpdateParams.none(),
        ): HttpResponseFor<NamespaceUpdateResponse> =
            update(namespaceId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: NamespaceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: NamespaceUpdateParams): HttpResponseFor<NamespaceUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceUpdateResponse> =
            update(namespaceId, NamespaceUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /namespaces`, but is otherwise the same as
         * [NamespaceService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<NamespaceListPage> = list(NamespaceListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: NamespaceListParams = NamespaceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: NamespaceListParams = NamespaceListParams.none()
        ): HttpResponseFor<NamespaceListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<NamespaceListPage> =
            list(NamespaceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /namespaces/{namespaceId}`, but is otherwise the
         * same as [NamespaceService.delete].
         */
        @MustBeClosed
        fun delete(namespaceId: String): HttpResponseFor<NamespaceDeleteResponse> =
            delete(namespaceId, NamespaceDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            namespaceId: String,
            params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceDeleteResponse> =
            delete(params.toBuilder().namespaceId(namespaceId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            namespaceId: String,
            params: NamespaceDeleteParams = NamespaceDeleteParams.none(),
        ): HttpResponseFor<NamespaceDeleteResponse> =
            delete(namespaceId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: NamespaceDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NamespaceDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: NamespaceDeleteParams): HttpResponseFor<NamespaceDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            namespaceId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceDeleteResponse> =
            delete(namespaceId, NamespaceDeleteParams.none(), requestOptions)
    }
}
