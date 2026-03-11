// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking

import com.nuntly.core.ClientOptions
import com.nuntly.core.RequestOptions
import com.nuntly.core.checkRequired
import com.nuntly.core.handlers.errorBodyHandler
import com.nuntly.core.handlers.errorHandler
import com.nuntly.core.handlers.jsonHandler
import com.nuntly.core.http.HttpMethod
import com.nuntly.core.http.HttpRequest
import com.nuntly.core.http.HttpResponse
import com.nuntly.core.http.HttpResponse.Handler
import com.nuntly.core.http.HttpResponseFor
import com.nuntly.core.http.json
import com.nuntly.core.http.parseable
import com.nuntly.core.prepare
import com.nuntly.models.DataEnvelope
import com.nuntly.models.inboxes.Inbox
import com.nuntly.models.inboxes.InboxCreateParams
import com.nuntly.models.inboxes.InboxDeleteParams
import com.nuntly.models.inboxes.InboxDeleteResponse
import com.nuntly.models.inboxes.InboxListPage
import com.nuntly.models.inboxes.InboxListPageResponse
import com.nuntly.models.inboxes.InboxListParams
import com.nuntly.models.inboxes.InboxRetrieveParams
import com.nuntly.models.inboxes.InboxSendParams
import com.nuntly.models.inboxes.InboxSendResponse
import com.nuntly.models.inboxes.InboxUpdateParams
import com.nuntly.models.inboxes.InboxUpdateResponse
import com.nuntly.services.blocking.inboxes.ThreadService
import com.nuntly.services.blocking.inboxes.ThreadServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Create email inboxes at a specific address on a verified receiving domain. Assign inboxes to
 * namespaces or AI agents.
 */
class InboxServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InboxService {

    private val withRawResponse: InboxService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val threads: ThreadService by lazy { ThreadServiceImpl(clientOptions) }

    override fun withRawResponse(): InboxService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxService =
        InboxServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    override fun threads(): ThreadService = threads

    override fun create(params: InboxCreateParams, requestOptions: RequestOptions): Inbox =
        // post /inboxes
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: InboxRetrieveParams, requestOptions: RequestOptions): Inbox =
        // get /inboxes/{inboxId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: InboxUpdateParams,
        requestOptions: RequestOptions,
    ): InboxUpdateResponse =
        // patch /inboxes/{inboxId}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: InboxListParams, requestOptions: RequestOptions): InboxListPage =
        // get /inboxes
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: InboxDeleteParams,
        requestOptions: RequestOptions,
    ): InboxDeleteResponse =
        // delete /inboxes/{inboxId}
        withRawResponse().delete(params, requestOptions).parse()

    override fun send(params: InboxSendParams, requestOptions: RequestOptions): InboxSendResponse =
        // post /inboxes/{inboxId}/messages
        withRawResponse().send(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InboxService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val threads: ThreadService.WithRawResponse by lazy {
            ThreadServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InboxService.WithRawResponse =
            InboxServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        override fun threads(): ThreadService.WithRawResponse = threads

        private val createHandler: Handler<DataEnvelope<Inbox>> =
            jsonHandler<DataEnvelope<Inbox>>(clientOptions.jsonMapper)

        override fun create(
            params: InboxCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Inbox> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("inboxes")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val retrieveHandler: Handler<DataEnvelope<Inbox>> =
            jsonHandler<DataEnvelope<Inbox>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: InboxRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Inbox> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("inboxId", params.inboxId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("inboxes", params._pathParam(0))
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

        private val updateHandler: Handler<DataEnvelope<InboxUpdateResponse>> =
            jsonHandler<DataEnvelope<InboxUpdateResponse>>(clientOptions.jsonMapper)

        override fun update(
            params: InboxUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("inboxId", params.inboxId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("inboxes", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val listHandler: Handler<InboxListPageResponse> =
            jsonHandler<InboxListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: InboxListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("inboxes")
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
                        InboxListPage.builder()
                            .service(InboxServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<DataEnvelope<InboxDeleteResponse>> =
            jsonHandler<DataEnvelope<InboxDeleteResponse>>(clientOptions.jsonMapper)

        override fun delete(
            params: InboxDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("inboxId", params.inboxId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("inboxes", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .data()
            }
        }

        private val sendHandler: Handler<DataEnvelope<InboxSendResponse>> =
            jsonHandler<DataEnvelope<InboxSendResponse>>(clientOptions.jsonMapper)

        override fun send(
            params: InboxSendParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxSendResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("inboxId", params.inboxId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("inboxes", params._pathParam(0), "messages")
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
