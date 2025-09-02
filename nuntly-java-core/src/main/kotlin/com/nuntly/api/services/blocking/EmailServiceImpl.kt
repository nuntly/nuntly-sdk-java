// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.services.blocking

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
import com.nuntly.api.core.prepare
import com.nuntly.api.models.DataEnvelope
import com.nuntly.api.models.emails.EmailCancelParams
import com.nuntly.api.models.emails.EmailCancelResponse
import com.nuntly.api.models.emails.EmailListPage
import com.nuntly.api.models.emails.EmailListPageResponse
import com.nuntly.api.models.emails.EmailListParams
import com.nuntly.api.models.emails.EmailRetrieveParams
import com.nuntly.api.models.emails.EmailRetrieveResponse
import com.nuntly.api.models.emails.EmailSendParams
import com.nuntly.api.models.emails.EmailSendResponse
import com.nuntly.api.services.blocking.emails.BulkService
import com.nuntly.api.services.blocking.emails.BulkServiceImpl
import com.nuntly.api.services.blocking.emails.EventService
import com.nuntly.api.services.blocking.emails.EventServiceImpl
import com.nuntly.api.services.blocking.emails.StatService
import com.nuntly.api.services.blocking.emails.StatServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class EmailServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    EmailService {

    private val withRawResponse: EmailService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val bulk: BulkService by lazy { BulkServiceImpl(clientOptions) }

    private val events: EventService by lazy { EventServiceImpl(clientOptions) }

    private val stats: StatService by lazy { StatServiceImpl(clientOptions) }

    override fun withRawResponse(): EmailService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmailService =
        EmailServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun bulk(): BulkService = bulk

    override fun events(): EventService = events

    override fun stats(): StatService = stats

    override fun retrieve(
        params: EmailRetrieveParams,
        requestOptions: RequestOptions,
    ): EmailRetrieveResponse =
        // get /emails/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: EmailListParams, requestOptions: RequestOptions): EmailListPage =
        // get /emails
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(
        params: EmailCancelParams,
        requestOptions: RequestOptions,
    ): EmailCancelResponse =
        // delete /emails/{id}
        withRawResponse().cancel(params, requestOptions).parse()

    override fun send(params: EmailSendParams, requestOptions: RequestOptions): EmailSendResponse =
        // post /emails
        withRawResponse().send(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EmailService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val bulk: BulkService.WithRawResponse by lazy {
            BulkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val events: EventService.WithRawResponse by lazy {
            EventServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val stats: StatService.WithRawResponse by lazy {
            StatServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EmailService.WithRawResponse =
            EmailServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun bulk(): BulkService.WithRawResponse = bulk

        override fun events(): EventService.WithRawResponse = events

        override fun stats(): StatService.WithRawResponse = stats

        private val retrieveHandler: Handler<DataEnvelope<EmailRetrieveResponse>> =
            jsonHandler<DataEnvelope<EmailRetrieveResponse>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: EmailRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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

        private val listHandler: Handler<EmailListPageResponse> =
            jsonHandler<EmailListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: EmailListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        EmailListPage.builder()
                            .service(EmailServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val cancelHandler: Handler<DataEnvelope<EmailCancelResponse>> =
            jsonHandler<DataEnvelope<EmailCancelResponse>>(clientOptions.jsonMapper)

        override fun cancel(
            params: EmailCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailCancelResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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

        private val sendHandler: Handler<DataEnvelope<EmailSendResponse>> =
            jsonHandler<DataEnvelope<EmailSendResponse>>(clientOptions.jsonMapper)

        override fun send(
            params: EmailSendParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailSendResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
