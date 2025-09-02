// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async

import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.domains.DomainCreateParams
import com.nuntly.api.models.domains.DomainCreateResponse
import com.nuntly.api.models.domains.DomainDeleteParams
import com.nuntly.api.models.domains.DomainDeleteResponse
import com.nuntly.api.models.domains.DomainListPageAsync
import com.nuntly.api.models.domains.DomainListParams
import com.nuntly.api.models.domains.DomainRetrieveParams
import com.nuntly.api.models.domains.DomainRetrieveResponse
import com.nuntly.api.models.domains.DomainUpdateParams
import com.nuntly.api.models.domains.DomainUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface DomainServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DomainServiceAsync

    /** Return the domain with the given ID */
    fun create(params: DomainCreateParams): CompletableFuture<DomainCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: DomainCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainCreateResponse>

    /** Return the domain with the given id */
    fun retrieve(id: String): CompletableFuture<DomainRetrieveResponse> =
        retrieve(id, DomainRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DomainRetrieveParams = DomainRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DomainRetrieveParams = DomainRetrieveParams.none(),
    ): CompletableFuture<DomainRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DomainRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: DomainRetrieveParams): CompletableFuture<DomainRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DomainRetrieveResponse> =
        retrieve(id, DomainRetrieveParams.none(), requestOptions)

    /** Updates domain tracking settings */
    fun update(id: String): CompletableFuture<DomainUpdateResponse> =
        update(id, DomainUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: DomainUpdateParams = DomainUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: DomainUpdateParams = DomainUpdateParams.none(),
    ): CompletableFuture<DomainUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: DomainUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainUpdateResponse>

    /** @see update */
    fun update(params: DomainUpdateParams): CompletableFuture<DomainUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DomainUpdateResponse> =
        update(id, DomainUpdateParams.none(), requestOptions)

    /** Return a list of your domains */
    fun list(): CompletableFuture<DomainListPageAsync> = list(DomainListParams.none())

    /** @see list */
    fun list(
        params: DomainListParams = DomainListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainListPageAsync>

    /** @see list */
    fun list(
        params: DomainListParams = DomainListParams.none()
    ): CompletableFuture<DomainListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<DomainListPageAsync> =
        list(DomainListParams.none(), requestOptions)

    /** Delete the domain with the given ID */
    fun delete(id: String): CompletableFuture<DomainDeleteResponse> =
        delete(id, DomainDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: DomainDeleteParams = DomainDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: DomainDeleteParams = DomainDeleteParams.none(),
    ): CompletableFuture<DomainDeleteResponse> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: DomainDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DomainDeleteResponse>

    /** @see delete */
    fun delete(params: DomainDeleteParams): CompletableFuture<DomainDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<DomainDeleteResponse> =
        delete(id, DomainDeleteParams.none(), requestOptions)

    /**
     * A view of [DomainServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DomainServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /domains`, but is otherwise the same as
         * [DomainServiceAsync.create].
         */
        fun create(
            params: DomainCreateParams
        ): CompletableFuture<HttpResponseFor<DomainCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: DomainCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /domains/{id}`, but is otherwise the same as
         * [DomainServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<DomainRetrieveResponse>> =
            retrieve(id, DomainRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DomainRetrieveParams = DomainRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DomainRetrieveParams = DomainRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<DomainRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: DomainRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: DomainRetrieveParams
        ): CompletableFuture<HttpResponseFor<DomainRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DomainRetrieveResponse>> =
            retrieve(id, DomainRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /domains/{id}`, but is otherwise the same as
         * [DomainServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<DomainUpdateResponse>> =
            update(id, DomainUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: DomainUpdateParams = DomainUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: DomainUpdateParams = DomainUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<DomainUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: DomainUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainUpdateResponse>>

        /** @see update */
        fun update(
            params: DomainUpdateParams
        ): CompletableFuture<HttpResponseFor<DomainUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DomainUpdateResponse>> =
            update(id, DomainUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /domains`, but is otherwise the same as
         * [DomainServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<DomainListPageAsync>> =
            list(DomainListParams.none())

        /** @see list */
        fun list(
            params: DomainListParams = DomainListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainListPageAsync>>

        /** @see list */
        fun list(
            params: DomainListParams = DomainListParams.none()
        ): CompletableFuture<HttpResponseFor<DomainListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<DomainListPageAsync>> =
            list(DomainListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /domains/{id}`, but is otherwise the same as
         * [DomainServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponseFor<DomainDeleteResponse>> =
            delete(id, DomainDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: DomainDeleteParams = DomainDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: DomainDeleteParams = DomainDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<DomainDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: DomainDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DomainDeleteResponse>>

        /** @see delete */
        fun delete(
            params: DomainDeleteParams
        ): CompletableFuture<HttpResponseFor<DomainDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DomainDeleteResponse>> =
            delete(id, DomainDeleteParams.none(), requestOptions)
    }
}
