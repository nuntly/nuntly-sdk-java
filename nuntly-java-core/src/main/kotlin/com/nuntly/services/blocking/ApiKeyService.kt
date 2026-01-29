// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.apikeys.ApiKeyCreateParams
import com.nuntly.models.apikeys.ApiKeyCreateResponse
import com.nuntly.models.apikeys.ApiKeyDeleteParams
import com.nuntly.models.apikeys.ApiKeyDeleteResponse
import com.nuntly.models.apikeys.ApiKeyListPage
import com.nuntly.models.apikeys.ApiKeyListParams
import com.nuntly.models.apikeys.ApiKeyRetrieveParams
import com.nuntly.models.apikeys.ApiKeyRetrieveResponse
import com.nuntly.models.apikeys.ApiKeyUpdateParams
import com.nuntly.models.apikeys.ApiKeyUpdateResponse
import java.util.function.Consumer

interface ApiKeyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService

    /** Create an API key */
    fun create(): ApiKeyCreateResponse = create(ApiKeyCreateParams.none())

    /** @see create */
    fun create(
        params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyCreateResponse

    /** @see create */
    fun create(params: ApiKeyCreateParams = ApiKeyCreateParams.none()): ApiKeyCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ApiKeyCreateResponse =
        create(ApiKeyCreateParams.none(), requestOptions)

    /** Retrieve an API key */
    fun retrieve(id: String): ApiKeyRetrieveResponse = retrieve(id, ApiKeyRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
    ): ApiKeyRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: ApiKeyRetrieveParams): ApiKeyRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ApiKeyRetrieveResponse =
        retrieve(id, ApiKeyRetrieveParams.none(), requestOptions)

    /** Update an API key */
    fun update(id: String): ApiKeyUpdateResponse = update(id, ApiKeyUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
    ): ApiKeyUpdateResponse = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ApiKeyUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyUpdateResponse

    /** @see update */
    fun update(params: ApiKeyUpdateParams): ApiKeyUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): ApiKeyUpdateResponse =
        update(id, ApiKeyUpdateParams.none(), requestOptions)

    /** List API keys */
    fun list(): ApiKeyListPage = list(ApiKeyListParams.none())

    /** @see list */
    fun list(
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyListPage

    /** @see list */
    fun list(params: ApiKeyListParams = ApiKeyListParams.none()): ApiKeyListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ApiKeyListPage =
        list(ApiKeyListParams.none(), requestOptions)

    /** Delete an API key */
    fun delete(id: String): ApiKeyDeleteResponse = delete(id, ApiKeyDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
    ): ApiKeyDeleteResponse = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyDeleteResponse

    /** @see delete */
    fun delete(params: ApiKeyDeleteParams): ApiKeyDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): ApiKeyDeleteResponse =
        delete(id, ApiKeyDeleteParams.none(), requestOptions)

    /** A view of [ApiKeyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiKeyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api-keys`, but is otherwise the same as
         * [ApiKeyService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<ApiKeyCreateResponse> = create(ApiKeyCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: ApiKeyCreateParams = ApiKeyCreateParams.none()
        ): HttpResponseFor<ApiKeyCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ApiKeyCreateResponse> =
            create(ApiKeyCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ApiKeyRetrieveResponse> =
            retrieve(id, ApiKeyRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ApiKeyRetrieveParams = ApiKeyRetrieveParams.none(),
        ): HttpResponseFor<ApiKeyRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ApiKeyRetrieveParams): HttpResponseFor<ApiKeyRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyRetrieveResponse> =
            retrieve(id, ApiKeyRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<ApiKeyUpdateResponse> =
            update(id, ApiKeyUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: ApiKeyUpdateParams = ApiKeyUpdateParams.none(),
        ): HttpResponseFor<ApiKeyUpdateResponse> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ApiKeyUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: ApiKeyUpdateParams): HttpResponseFor<ApiKeyUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyUpdateResponse> =
            update(id, ApiKeyUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api-keys`, but is otherwise the same as
         * [ApiKeyService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<ApiKeyListPage> = list(ApiKeyListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ApiKeyListParams = ApiKeyListParams.none()
        ): HttpResponseFor<ApiKeyListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ApiKeyListPage> =
            list(ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api-keys/{id}`, but is otherwise the same as
         * [ApiKeyService.delete].
         */
        @MustBeClosed
        fun delete(id: String): HttpResponseFor<ApiKeyDeleteResponse> =
            delete(id, ApiKeyDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: ApiKeyDeleteParams = ApiKeyDeleteParams.none(),
        ): HttpResponseFor<ApiKeyDeleteResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: ApiKeyDeleteParams): HttpResponseFor<ApiKeyDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyDeleteResponse> =
            delete(id, ApiKeyDeleteParams.none(), requestOptions)
    }
}
