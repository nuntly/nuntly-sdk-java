// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.domains.DomainCreateParams
import com.nuntly.models.domains.DomainCreateResponse
import com.nuntly.models.domains.DomainDeleteParams
import com.nuntly.models.domains.DomainDeleteResponse
import com.nuntly.models.domains.DomainListPage
import com.nuntly.models.domains.DomainListParams
import com.nuntly.models.domains.DomainRetrieveParams
import com.nuntly.models.domains.DomainRetrieveResponse
import com.nuntly.models.domains.DomainUpdateParams
import com.nuntly.models.domains.DomainUpdateResponse
import java.util.function.Consumer

interface DomainService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DomainService

    /** Create a domain */
    fun create(params: DomainCreateParams): DomainCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: DomainCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainCreateResponse

    /** Retrieve a domain */
    fun retrieve(id: String): DomainRetrieveResponse = retrieve(id, DomainRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DomainRetrieveParams = DomainRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DomainRetrieveParams = DomainRetrieveParams.none(),
    ): DomainRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DomainRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: DomainRetrieveParams): DomainRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): DomainRetrieveResponse =
        retrieve(id, DomainRetrieveParams.none(), requestOptions)

    /** Update a domain */
    fun update(id: String): DomainUpdateResponse = update(id, DomainUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: DomainUpdateParams = DomainUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: DomainUpdateParams = DomainUpdateParams.none(),
    ): DomainUpdateResponse = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DomainUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainUpdateResponse

    /** @see update */
    fun update(params: DomainUpdateParams): DomainUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): DomainUpdateResponse =
        update(id, DomainUpdateParams.none(), requestOptions)

    /** List all domains */
    fun list(): DomainListPage = list(DomainListParams.none())

    /** @see list */
    fun list(
        params: DomainListParams = DomainListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainListPage

    /** @see list */
    fun list(params: DomainListParams = DomainListParams.none()): DomainListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): DomainListPage =
        list(DomainListParams.none(), requestOptions)

    /** Delete a domain */
    fun delete(id: String): DomainDeleteResponse = delete(id, DomainDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: DomainDeleteParams = DomainDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: DomainDeleteParams = DomainDeleteParams.none(),
    ): DomainDeleteResponse = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: DomainDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DomainDeleteResponse

    /** @see delete */
    fun delete(params: DomainDeleteParams): DomainDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): DomainDeleteResponse =
        delete(id, DomainDeleteParams.none(), requestOptions)

    /** A view of [DomainService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DomainService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /domains`, but is otherwise the same as
         * [DomainService.create].
         */
        @MustBeClosed
        fun create(params: DomainCreateParams): HttpResponseFor<DomainCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: DomainCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainCreateResponse>

        /**
         * Returns a raw HTTP response for `get /domains/{id}`, but is otherwise the same as
         * [DomainService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<DomainRetrieveResponse> =
            retrieve(id, DomainRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: DomainRetrieveParams = DomainRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: DomainRetrieveParams = DomainRetrieveParams.none(),
        ): HttpResponseFor<DomainRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: DomainRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: DomainRetrieveParams): HttpResponseFor<DomainRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainRetrieveResponse> =
            retrieve(id, DomainRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /domains/{id}`, but is otherwise the same as
         * [DomainService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<DomainUpdateResponse> =
            update(id, DomainUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: DomainUpdateParams = DomainUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: DomainUpdateParams = DomainUpdateParams.none(),
        ): HttpResponseFor<DomainUpdateResponse> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: DomainUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: DomainUpdateParams): HttpResponseFor<DomainUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainUpdateResponse> =
            update(id, DomainUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /domains`, but is otherwise the same as
         * [DomainService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<DomainListPage> = list(DomainListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: DomainListParams = DomainListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: DomainListParams = DomainListParams.none()
        ): HttpResponseFor<DomainListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<DomainListPage> =
            list(DomainListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /domains/{id}`, but is otherwise the same as
         * [DomainService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<DomainDeleteResponse> =
            delete(id, DomainDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: DomainDeleteParams = DomainDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: DomainDeleteParams = DomainDeleteParams.none(),
        ): HttpResponseFor<DomainDeleteResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: DomainDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DomainDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: DomainDeleteParams): HttpResponseFor<DomainDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DomainDeleteResponse> =
            delete(id, DomainDeleteParams.none(), requestOptions)
    }
}
