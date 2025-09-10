// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.account.AccountRetrieveParams
import com.nuntly.models.account.AccountRetrieveResponse
import com.nuntly.models.account.AccountUpdateParams
import com.nuntly.models.account.AccountUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountServiceAsync

    /** Retrieve your account informations */
    fun retrieve(): CompletableFuture<AccountRetrieveResponse> =
        retrieve(AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none()
    ): CompletableFuture<AccountRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<AccountRetrieveResponse> =
        retrieve(AccountRetrieveParams.none(), requestOptions)

    /** Update your account */
    fun update(params: AccountUpdateParams): CompletableFuture<AccountUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccountUpdateResponse>

    /**
     * A view of [AccountServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccountServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /account`, but is otherwise the same as
         * [AccountServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>> =
            retrieve(AccountRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AccountRetrieveResponse>> =
            retrieve(AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /account`, but is otherwise the same as
         * [AccountServiceAsync.update].
         */
        fun update(
            params: AccountUpdateParams
        ): CompletableFuture<HttpResponseFor<AccountUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: AccountUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccountUpdateResponse>>
    }
}
