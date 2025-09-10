// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.models.emails.EmailCancelParams
import com.nuntly.models.emails.EmailCancelResponse
import com.nuntly.models.emails.EmailListPageAsync
import com.nuntly.models.emails.EmailListParams
import com.nuntly.models.emails.EmailRetrieveParams
import com.nuntly.models.emails.EmailRetrieveResponse
import com.nuntly.models.emails.EmailSendParams
import com.nuntly.models.emails.EmailSendResponse
import com.nuntly.services.async.emails.BulkServiceAsync
import com.nuntly.services.async.emails.EventServiceAsync
import com.nuntly.services.async.emails.StatServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EmailServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmailServiceAsync

    fun bulk(): BulkServiceAsync

    fun events(): EventServiceAsync

    fun stats(): StatServiceAsync

    /** Return the email with the given id */
    fun retrieve(id: String): CompletableFuture<EmailRetrieveResponse> =
        retrieve(id, EmailRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EmailRetrieveParams = EmailRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EmailRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EmailRetrieveParams = EmailRetrieveParams.none(),
    ): CompletableFuture<EmailRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: EmailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EmailRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: EmailRetrieveParams): CompletableFuture<EmailRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EmailRetrieveResponse> =
        retrieve(id, EmailRetrieveParams.none(), requestOptions)

    /** Return a list of your last emails */
    fun list(): CompletableFuture<EmailListPageAsync> = list(EmailListParams.none())

    /** @see list */
    fun list(
        params: EmailListParams = EmailListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EmailListPageAsync>

    /** @see list */
    fun list(
        params: EmailListParams = EmailListParams.none()
    ): CompletableFuture<EmailListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<EmailListPageAsync> =
        list(EmailListParams.none(), requestOptions)

    /** Cancel a scheduled email */
    fun cancel(id: String): CompletableFuture<EmailCancelResponse> =
        cancel(id, EmailCancelParams.none())

    /** @see cancel */
    fun cancel(
        id: String,
        params: EmailCancelParams = EmailCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EmailCancelResponse> =
        cancel(params.toBuilder().id(id).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        id: String,
        params: EmailCancelParams = EmailCancelParams.none(),
    ): CompletableFuture<EmailCancelResponse> = cancel(id, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: EmailCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EmailCancelResponse>

    /** @see cancel */
    fun cancel(params: EmailCancelParams): CompletableFuture<EmailCancelResponse> =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(id: String, requestOptions: RequestOptions): CompletableFuture<EmailCancelResponse> =
        cancel(id, EmailCancelParams.none(), requestOptions)

    /**
     * Send transactional emails through the Nuntly platform. It supports HTML and plain-text
     * emails, attachments, labels, custom headers and scheduling.
     */
    fun send(params: EmailSendParams): CompletableFuture<EmailSendResponse> =
        send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: EmailSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EmailSendResponse>

    /** A view of [EmailServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EmailServiceAsync.WithRawResponse

        fun bulk(): BulkServiceAsync.WithRawResponse

        fun events(): EventServiceAsync.WithRawResponse

        fun stats(): StatServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/{id}`, but is otherwise the same as
         * [EmailServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<EmailRetrieveResponse>> =
            retrieve(id, EmailRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: EmailRetrieveParams = EmailRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EmailRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: EmailRetrieveParams = EmailRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<EmailRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: EmailRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EmailRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: EmailRetrieveParams
        ): CompletableFuture<HttpResponseFor<EmailRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EmailRetrieveResponse>> =
            retrieve(id, EmailRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /emails`, but is otherwise the same as
         * [EmailServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<EmailListPageAsync>> =
            list(EmailListParams.none())

        /** @see list */
        fun list(
            params: EmailListParams = EmailListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EmailListPageAsync>>

        /** @see list */
        fun list(
            params: EmailListParams = EmailListParams.none()
        ): CompletableFuture<HttpResponseFor<EmailListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<EmailListPageAsync>> =
            list(EmailListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /emails/{id}`, but is otherwise the same as
         * [EmailServiceAsync.cancel].
         */
        fun cancel(id: String): CompletableFuture<HttpResponseFor<EmailCancelResponse>> =
            cancel(id, EmailCancelParams.none())

        /** @see cancel */
        fun cancel(
            id: String,
            params: EmailCancelParams = EmailCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EmailCancelResponse>> =
            cancel(params.toBuilder().id(id).build(), requestOptions)

        /** @see cancel */
        fun cancel(
            id: String,
            params: EmailCancelParams = EmailCancelParams.none(),
        ): CompletableFuture<HttpResponseFor<EmailCancelResponse>> =
            cancel(id, params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            params: EmailCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EmailCancelResponse>>

        /** @see cancel */
        fun cancel(
            params: EmailCancelParams
        ): CompletableFuture<HttpResponseFor<EmailCancelResponse>> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EmailCancelResponse>> =
            cancel(id, EmailCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /emails`, but is otherwise the same as
         * [EmailServiceAsync.send].
         */
        fun send(params: EmailSendParams): CompletableFuture<HttpResponseFor<EmailSendResponse>> =
            send(params, RequestOptions.none())

        /** @see send */
        fun send(
            params: EmailSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EmailSendResponse>>
    }
}
