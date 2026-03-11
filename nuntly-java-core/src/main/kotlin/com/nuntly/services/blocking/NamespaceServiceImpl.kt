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
import com.nuntly.models.namespaces.Namespace
import com.nuntly.models.namespaces.NamespaceCreateParams
import com.nuntly.models.namespaces.NamespaceDeleteParams
import com.nuntly.models.namespaces.NamespaceDeleteResponse
import com.nuntly.models.namespaces.NamespaceDetail
import com.nuntly.models.namespaces.NamespaceListPage
import com.nuntly.models.namespaces.NamespaceListPageResponse
import com.nuntly.models.namespaces.NamespaceListParams
import com.nuntly.models.namespaces.NamespaceRetrieveParams
import com.nuntly.models.namespaces.NamespaceUpdateParams
import com.nuntly.models.namespaces.NamespaceUpdateResponse
import com.nuntly.services.blocking.namespaces.InboxService
import com.nuntly.services.blocking.namespaces.InboxServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
 * namespaces to your own data model.
 */
class NamespaceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    NamespaceService {

    private val withRawResponse: NamespaceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val inboxes: InboxService by lazy { InboxServiceImpl(clientOptions) }

    override fun withRawResponse(): NamespaceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceService =
        NamespaceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    override fun inboxes(): InboxService = inboxes

    override fun create(params: NamespaceCreateParams, requestOptions: RequestOptions): Namespace =
        // post /namespaces
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: NamespaceRetrieveParams,
        requestOptions: RequestOptions,
    ): NamespaceDetail =
        // get /namespaces/{namespaceId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: NamespaceUpdateParams,
        requestOptions: RequestOptions,
    ): NamespaceUpdateResponse =
        // patch /namespaces/{namespaceId}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions,
    ): NamespaceListPage =
        // get /namespaces
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: NamespaceDeleteParams,
        requestOptions: RequestOptions,
    ): NamespaceDeleteResponse =
        // delete /namespaces/{namespaceId}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NamespaceService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val inboxes: InboxService.WithRawResponse by lazy {
            InboxServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NamespaceService.WithRawResponse =
            NamespaceServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        override fun inboxes(): InboxService.WithRawResponse = inboxes

        private val createHandler: Handler<DataEnvelope<Namespace>> =
            jsonHandler<DataEnvelope<Namespace>>(clientOptions.jsonMapper)

        override fun create(
            params: NamespaceCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Namespace> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces")
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

        private val retrieveHandler: Handler<DataEnvelope<NamespaceDetail>> =
            jsonHandler<DataEnvelope<NamespaceDetail>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: NamespaceRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceDetail> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("namespaceId", params.namespaceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces", params._pathParam(0))
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

        private val updateHandler: Handler<DataEnvelope<NamespaceUpdateResponse>> =
            jsonHandler<DataEnvelope<NamespaceUpdateResponse>>(clientOptions.jsonMapper)

        override fun update(
            params: NamespaceUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("namespaceId", params.namespaceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces", params._pathParam(0))
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

        private val listHandler: Handler<NamespaceListPageResponse> =
            jsonHandler<NamespaceListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: NamespaceListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces")
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
                        NamespaceListPage.builder()
                            .service(NamespaceServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<DataEnvelope<NamespaceDeleteResponse>> =
            jsonHandler<DataEnvelope<NamespaceDeleteResponse>>(clientOptions.jsonMapper)

        override fun delete(
            params: NamespaceDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NamespaceDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("namespaceId", params.namespaceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces", params._pathParam(0))
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
    }
}
