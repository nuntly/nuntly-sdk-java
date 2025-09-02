// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.models.emails.EmailCancelParams
import com.nuntly.api.models.emails.EmailCancelResponse
import com.nuntly.api.models.emails.EmailListPage
import com.nuntly.api.models.emails.EmailListParams
import com.nuntly.api.models.emails.EmailRetrieveParams
import com.nuntly.api.models.emails.EmailRetrieveResponse
import com.nuntly.api.models.emails.EmailSendParams
import com.nuntly.api.models.emails.EmailSendResponse
import com.nuntly.api.services.blocking.emails.BulkService
import com.nuntly.api.services.blocking.emails.EventService
import com.nuntly.api.services.blocking.emails.StatService
import java.util.function.Consumer

interface EmailService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmailService

    fun bulk(): BulkService

    fun events(): EventService

    fun stats(): StatService

    /** Return the email with the given id */
    fun retrieve(id: String): EmailRetrieveResponse = retrieve(id, EmailRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EmailRetrieveParams = EmailRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: EmailRetrieveParams = EmailRetrieveParams.none(),
    ): EmailRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: EmailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: EmailRetrieveParams): EmailRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): EmailRetrieveResponse =
        retrieve(id, EmailRetrieveParams.none(), requestOptions)

    /** Return a list of your last emails */
    fun list(): EmailListPage = list(EmailListParams.none())

    /** @see list */
    fun list(
        params: EmailListParams = EmailListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailListPage

    /** @see list */
    fun list(params: EmailListParams = EmailListParams.none()): EmailListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): EmailListPage =
        list(EmailListParams.none(), requestOptions)

    /** Cancel a scheduled email */
    fun cancel(id: String): EmailCancelResponse = cancel(id, EmailCancelParams.none())

    /** @see cancel */
    fun cancel(
        id: String,
        params: EmailCancelParams = EmailCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailCancelResponse = cancel(params.toBuilder().id(id).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        id: String,
        params: EmailCancelParams = EmailCancelParams.none(),
    ): EmailCancelResponse = cancel(id, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: EmailCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailCancelResponse

    /** @see cancel */
    fun cancel(params: EmailCancelParams): EmailCancelResponse =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(id: String, requestOptions: RequestOptions): EmailCancelResponse =
        cancel(id, EmailCancelParams.none(), requestOptions)

    /**
     * Send transactional emails through the Nuntly platform. It supports HTML and plain-text
     * emails, attachments, labels, custom headers and scheduling.
     */
    fun send(params: EmailSendParams): EmailSendResponse = send(params, RequestOptions.none())

    /** @see send */
    fun send(
        params: EmailSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailSendResponse

    /** A view of [EmailService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmailService.WithRawResponse

        fun bulk(): BulkService.WithRawResponse

        fun events(): EventService.WithRawResponse

        fun stats(): StatService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /emails/{id}`, but is otherwise the same as
         * [EmailService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<EmailRetrieveResponse> =
            retrieve(id, EmailRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: EmailRetrieveParams = EmailRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: EmailRetrieveParams = EmailRetrieveParams.none(),
        ): HttpResponseFor<EmailRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: EmailRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: EmailRetrieveParams): HttpResponseFor<EmailRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailRetrieveResponse> =
            retrieve(id, EmailRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /emails`, but is otherwise the same as
         * [EmailService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<EmailListPage> = list(EmailListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: EmailListParams = EmailListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: EmailListParams = EmailListParams.none()): HttpResponseFor<EmailListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EmailListPage> =
            list(EmailListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /emails/{id}`, but is otherwise the same as
         * [EmailService.cancel].
         */
        @MustBeClosed
        fun cancel(id: String): HttpResponseFor<EmailCancelResponse> =
            cancel(id, EmailCancelParams.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            params: EmailCancelParams = EmailCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailCancelResponse> =
            cancel(params.toBuilder().id(id).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            params: EmailCancelParams = EmailCancelParams.none(),
        ): HttpResponseFor<EmailCancelResponse> = cancel(id, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: EmailCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailCancelResponse>

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: EmailCancelParams): HttpResponseFor<EmailCancelResponse> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailCancelResponse> =
            cancel(id, EmailCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /emails`, but is otherwise the same as
         * [EmailService.send].
         */
        @MustBeClosed
        fun send(params: EmailSendParams): HttpResponseFor<EmailSendResponse> =
            send(params, RequestOptions.none())

        /** @see send */
        @MustBeClosed
        fun send(
            params: EmailSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailSendResponse>
    }
}
