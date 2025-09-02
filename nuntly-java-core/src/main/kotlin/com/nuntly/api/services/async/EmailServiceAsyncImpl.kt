// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.async

import com.nuntly.api.core.ClientOptions
import com.nuntly.api.core.RequestOptions
import com.nuntly.api.core.checkRequired
import com.nuntly.api.core.handlers.errorBodyHandler
import com.nuntly.api.core.handlers.errorHandler
import com.nuntly.api.core.handlers.jsonHandler
import com.nuntly.api.core.http.HttpMethod
import com.nuntly.api.core.http.HttpRequest
import com.nuntly.api.core.http.HttpResponse
import com.nuntly.api.core.http.HttpResponse.Handler
import com.nuntly.api.core.http.HttpResponseFor
import com.nuntly.api.core.http.json
import com.nuntly.api.core.http.parseable
import com.nuntly.api.core.prepareAsync
import com.nuntly.api.models.DataEnvelope
import com.nuntly.api.models.emails.EmailCancelParams
import com.nuntly.api.models.emails.EmailCancelResponse
import com.nuntly.api.models.emails.EmailListPageAsync
import com.nuntly.api.models.emails.EmailListPageResponse
import com.nuntly.api.models.emails.EmailListParams
import com.nuntly.api.models.emails.EmailRetrieveParams
import com.nuntly.api.models.emails.EmailRetrieveResponse
import com.nuntly.api.models.emails.EmailSendParams
import com.nuntly.api.models.emails.EmailSendResponse
import com.nuntly.api.services.async.emails.BulkServiceAsync
import com.nuntly.api.services.async.emails.BulkServiceAsyncImpl
import com.nuntly.api.services.async.emails.EventServiceAsync
import com.nuntly.api.services.async.emails.EventServiceAsyncImpl
import com.nuntly.api.services.async.emails.StatServiceAsync
import com.nuntly.api.services.async.emails.StatServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class EmailServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    EmailServiceAsync {

    private val withRawResponse: EmailServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkServiceAsync by lazy { BulkServiceAsyncImpl(clientOptions) }

    private val events: EventServiceAsync by lazy { EventServiceAsyncImpl(clientOptions) }

    private val stats: StatServiceAsync by lazy { StatServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): EmailServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmailServiceAsync =
        EmailServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun bulk(): BulkServiceAsync = bulk

    override fun events(): EventServiceAsync = events

    override fun stats(): StatServiceAsync = stats

    override fun retrieve(
        params: EmailRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<EmailRetrieveResponse> =
        // get /emails/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: EmailListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<EmailListPageAsync> =
        // get /emails
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun cancel(
        params: EmailCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<EmailCancelResponse> =
        // delete /emails/{id}
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    override fun send(
        params: EmailSendParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<EmailSendResponse> =
        // post /emails
        withRawResponse().send(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EmailServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val bulk: BulkServiceAsync.WithRawResponse by lazy {
            BulkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val events: EventServiceAsync.WithRawResponse by lazy {
            EventServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val stats: StatServiceAsync.WithRawResponse by lazy {
            StatServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EmailServiceAsync.WithRawResponse =
            EmailServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun bulk(): BulkServiceAsync.WithRawResponse = bulk

        override fun events(): EventServiceAsync.WithRawResponse = events

        override fun stats(): StatServiceAsync.WithRawResponse = stats

        private val retrieveHandler: Handler<DataEnvelope<EmailRetrieveResponse>> =
            jsonHandler<DataEnvelope<EmailRetrieveResponse>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: EmailRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EmailRetrieveResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .data()
                    }
                }
        }

        private val listHandler: Handler<EmailListPageResponse> =
            jsonHandler<EmailListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: EmailListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EmailListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                EmailListPageAsync.builder()
                                    .service(EmailServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val cancelHandler: Handler<DataEnvelope<EmailCancelResponse>> =
            jsonHandler<DataEnvelope<EmailCancelResponse>>(clientOptions.jsonMapper)

        override fun cancel(
            params: EmailCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EmailCancelResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { cancelHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .data()
                    }
                }
        }

        private val sendHandler: Handler<DataEnvelope<EmailSendResponse>> =
            jsonHandler<DataEnvelope<EmailSendResponse>>(clientOptions.jsonMapper)

        override fun send(
            params: EmailSendParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EmailSendResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { sendHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .data()
                    }
                }
        }
    }
}
