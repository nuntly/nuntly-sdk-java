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
import com.nuntly.models.threads.Thread
import com.nuntly.models.threads.ThreadRetrieveParams
import com.nuntly.models.threads.ThreadUpdateParams
import com.nuntly.models.threads.ThreadUpdateResponse
import com.nuntly.services.async.threads.MessageServiceAsync
import com.nuntly.services.async.threads.MessageServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them to
 * an agent.
 */
class ThreadServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ThreadServiceAsync {

    private val withRawResponse: ThreadServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val messages: MessageServiceAsync by lazy { MessageServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ThreadServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadServiceAsync =
        ThreadServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them
     * to an agent.
     */
    override fun messages(): MessageServiceAsync = messages

    override fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Thread> =
        // get /threads/{threadId}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ThreadUpdateResponse> =
        // patch /threads/{threadId}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ThreadServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadServiceAsync.WithRawResponse =
            ThreadServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Browse email conversations grouped by subject. Mark threads as read or spam, and assign
         * them to an agent.
         */
        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        private val retrieveHandler: Handler<DataEnvelope<Thread>> =
            jsonHandler<DataEnvelope<Thread>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Thread>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", params._pathParam(0))
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

        private val updateHandler: Handler<DataEnvelope<ThreadUpdateResponse>> =
            jsonHandler<DataEnvelope<ThreadUpdateResponse>>(clientOptions.jsonMapper)

        override fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ThreadUpdateResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", params._pathParam(0))
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
    }
}
