// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.async

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
import com.nuntly.core.prepareAsync
import com.nuntly.models.DataEnvelope
import com.nuntly.models.namespaces.Namespace
import com.nuntly.models.namespaces.NamespaceCreateParams
import com.nuntly.models.namespaces.NamespaceDeleteParams
import com.nuntly.models.namespaces.NamespaceDeleteResponse
import com.nuntly.models.namespaces.NamespaceDetail
import com.nuntly.models.namespaces.NamespaceListPageAsync
import com.nuntly.models.namespaces.NamespaceListPageResponse
import com.nuntly.models.namespaces.NamespaceListParams
import com.nuntly.models.namespaces.NamespaceRetrieveParams
import com.nuntly.models.namespaces.NamespaceUpdateParams
import com.nuntly.models.namespaces.NamespaceUpdateResponse
import com.nuntly.services.async.namespaces.InboxServiceAsync
import com.nuntly.services.async.namespaces.InboxServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
 * namespaces to your own data model.
 */
class NamespaceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    NamespaceServiceAsync {

    private val withRawResponse: NamespaceServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val inboxes: InboxServiceAsync by lazy { InboxServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): NamespaceServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NamespaceServiceAsync =
        NamespaceServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
     * namespaces to your own data model.
     */
    override fun inboxes(): InboxServiceAsync = inboxes

    override fun create(
        params: NamespaceCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Namespace> =
        // post /namespaces
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: NamespaceRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceDetail> =
        // get /namespaces/{namespaceId}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: NamespaceUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceUpdateResponse> =
        // patch /namespaces/{namespaceId}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: NamespaceListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceListPageAsync> =
        // get /namespaces
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: NamespaceDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NamespaceDeleteResponse> =
        // delete /namespaces/{namespaceId}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NamespaceServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val inboxes: InboxServiceAsync.WithRawResponse by lazy {
            InboxServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NamespaceServiceAsync.WithRawResponse =
            NamespaceServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Isolate inboxes by tenant, client, or agent using namespaces. Use an external ID to map
         * namespaces to your own data model.
         */
        override fun inboxes(): InboxServiceAsync.WithRawResponse = inboxes

        private val createHandler: Handler<DataEnvelope<Namespace>> =
            jsonHandler<DataEnvelope<Namespace>>(clientOptions.jsonMapper)

        override fun create(
            params: NamespaceCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Namespace>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
        }

        private val retrieveHandler: Handler<DataEnvelope<NamespaceDetail>> =
            jsonHandler<DataEnvelope<NamespaceDetail>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: NamespaceRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceDetail>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("namespaceId", params.namespaceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces", params._pathParam(0))
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

        private val updateHandler: Handler<DataEnvelope<NamespaceUpdateResponse>> =
            jsonHandler<DataEnvelope<NamespaceUpdateResponse>>(clientOptions.jsonMapper)

        override fun update(
            params: NamespaceUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceUpdateResponse>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
        }

        private val listHandler: Handler<NamespaceListPageResponse> =
            jsonHandler<NamespaceListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: NamespaceListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("namespaces")
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
                                NamespaceListPageAsync.builder()
                                    .service(NamespaceServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<DataEnvelope<NamespaceDeleteResponse>> =
            jsonHandler<DataEnvelope<NamespaceDeleteResponse>>(clientOptions.jsonMapper)

        override fun delete(
            params: NamespaceDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NamespaceDeleteResponse>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
