// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.apikeys.ApiKeyCreateParams
import com.nuntly.models.apikeys.ApiKeyCreateResponse
import com.nuntly.models.apikeys.ApiKeyDeleteParams
import com.nuntly.models.apikeys.ApiKeyDeleteResponse
import com.nuntly.models.apikeys.ApiKeyListPageAsync
import com.nuntly.models.apikeys.ApiKeyListParams
import com.nuntly.models.apikeys.ApiKeyRetrieveParams
import com.nuntly.models.apikeys.ApiKeyRetrieveResponse
import com.nuntly.models.apikeys.ApiKeyUpdateParams
import com.nuntly.models.apikeys.ApiKeyUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ApiKeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyServiceAsync

    /** Create an API key */
    fun create(): CompletableFuture<ApiKeyCreateResponse> = create(ApiKeyCreateParams.none())

    /** @see create */
    fun create(
        params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyCreateResponse>

    /** @see create */
    fun create(
        params: ApiKeyCreateParams = ApiKeyCreateParams.none()
    ): CompletableFuture<ApiKeyCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiKeyCreateResponse> =
        create(ApiKeyCreateParams.none(), requestOptions)

    /** Retrieve an API key */
    fun retrieve(id: String): CompletableFuture<ApiKeyRetrieveResponse> =
        retrieve(id, ApiKeyRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
    ): CompletableFuture<ApiKeyRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: ApiKeyRetrieveParams): CompletableFuture<ApiKeyRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiKeyRetrieveResponse> =
        retrieve(id, ApiKeyRetrieveParams.none(), requestOptions)

    /** Update an API key */
    fun update(id: String): CompletableFuture<ApiKeyUpdateResponse> =
        update(id, ApiKeyUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
    ): CompletableFuture<ApiKeyUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ApiKeyUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyUpdateResponse>

    /** @see update */
    fun update(params: ApiKeyUpdateParams): CompletableFuture<ApiKeyUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiKeyUpdateResponse> =
        update(id, ApiKeyUpdateParams.none(), requestOptions)

    /** List API keys */
    fun list(): CompletableFuture<ApiKeyListPageAsync> = list(ApiKeyListParams.none())

    /** @see list */
    fun list(
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyListPageAsync>

    /** @see list */
    fun list(
        params: ApiKeyListParams = ApiKeyListParams.none()
    ): CompletableFuture<ApiKeyListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ApiKeyListPageAsync> =
        list(ApiKeyListParams.none(), requestOptions)

    /** Delete an API key */
    fun delete(id: String): CompletableFuture<ApiKeyDeleteResponse> =
        delete(id, ApiKeyDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
    ): CompletableFuture<ApiKeyDeleteResponse> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiKeyDeleteResponse>

    /** @see delete */
    fun delete(params: ApiKeyDeleteParams): CompletableFuture<ApiKeyDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiKeyDeleteResponse> =
        delete(id, ApiKeyDeleteParams.none(), requestOptions)

    /**
     * A view of [ApiKeyServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ApiKeyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api-keys`, but is otherwise the same as
         * [ApiKeyServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(ApiKeyCreateParams.none())

        /** @see create */
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>>

        /** @see create */
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiKeyCreateResponse>> =
            create(ApiKeyCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ApiKeyRetrieveResponse>> =
            retrieve(id, ApiKeyRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: ApiKeyRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiKeyRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiKeyRetrieveResponse>> =
            retrieve(id, ApiKeyRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<ApiKeyUpdateResponse>> =
            update(id, ApiKeyUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ApiKeyUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyUpdateResponse>>

        /** @see update */
        fun update(
            params: ApiKeyUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiKeyUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiKeyUpdateResponse>> =
            update(id, ApiKeyUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api-keys`, but is otherwise the same as
         * [ApiKeyServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(ApiKeyListParams.none())

        /** @see list */
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>>

        /** @see list */
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none()
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiKeyListPageAsync>> =
            list(ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(id, ApiKeyDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>>

        /** @see delete */
        fun delete(
            params: ApiKeyDeleteParams
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiKeyDeleteResponse>> =
            delete(id, ApiKeyDeleteParams.none(), requestOptions)
    }
}
