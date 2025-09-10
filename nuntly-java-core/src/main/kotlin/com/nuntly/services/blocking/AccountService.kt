// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.account.AccountRetrieveParams
import com.nuntly.models.account.AccountRetrieveResponse
import com.nuntly.models.account.AccountUpdateParams
import com.nuntly.models.account.AccountUpdateResponse
import java.util.function.Consumer

interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService

    /** Retrieve your account informations */
    fun retrieve(): AccountRetrieveResponse = retrieve(AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrieveResponse

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams = AccountRetrieveParams.none()
    ): AccountRetrieveResponse = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): AccountRetrieveResponse =
        retrieve(AccountRetrieveParams.none(), requestOptions)

    /** Update your account */
    fun update(params: AccountUpdateParams): AccountUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountUpdateResponse

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /account`, but is otherwise the same as
         * [AccountService.retrieve].
         */
        @MustBeClosed
        fun retrieve(): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(AccountRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams = AccountRetrieveParams.none()
        ): HttpResponseFor<AccountRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /account`, but is otherwise the same as
         * [AccountService.update].
         */
        @MustBeClosed
        fun update(params: AccountUpdateParams): HttpResponseFor<AccountUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: AccountUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountUpdateResponse>
    }
}
