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
import com.nuntly.models.messages.MessageDetail
import com.nuntly.models.messages.MessageForwardParams
import com.nuntly.models.messages.MessageForwardResponse
import com.nuntly.models.messages.MessageListPageAsync
import com.nuntly.models.messages.MessageListPageResponse
import com.nuntly.models.messages.MessageListParams
import com.nuntly.models.messages.MessageReplyParams
import com.nuntly.models.messages.MessageReplyResponse
import com.nuntly.models.messages.MessageRetrieveParams
import com.nuntly.services.async.messages.AttachmentServiceAsync
import com.nuntly.services.async.messages.AttachmentServiceAsyncImpl
import com.nuntly.services.async.messages.ContentServiceAsync
import com.nuntly.services.async.messages.ContentServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
class MessageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageServiceAsync {

    private val withRawResponse: MessageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val content: ContentServiceAsync by lazy { ContentServiceAsyncImpl(clientOptions) }

    private val attachments: AttachmentServiceAsync by lazy {
        AttachmentServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): MessageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageServiceAsync =
        MessageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    override fun content(): ContentServiceAsync = content

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    override fun attachments(): AttachmentServiceAsync = attachments

    override fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageDetail> =
        // get /messages/{messageId}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: MessageListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageListPageAsync> =
        // get /messages
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun forward(
        params: MessageForwardParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageForwardResponse> =
        // post /messages/{messageId}/forward
        withRawResponse().forward(params, requestOptions).thenApply { it.parse() }

    override fun reply(
        params: MessageReplyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageReplyResponse> =
        // post /messages/{messageId}/reply
        withRawResponse().reply(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val content: ContentServiceAsync.WithRawResponse by lazy {
            ContentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val attachments: AttachmentServiceAsync.WithRawResponse by lazy {
            AttachmentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageServiceAsync.WithRawResponse =
            MessageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        override fun content(): ContentServiceAsync.WithRawResponse = content

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        override fun attachments(): AttachmentServiceAsync.WithRawResponse = attachments

        private val retrieveHandler: Handler<DataEnvelope<MessageDetail>> =
            jsonHandler<DataEnvelope<MessageDetail>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageDetail>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("messages", params._pathParam(0))
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

        private val listHandler: Handler<MessageListPageResponse> =
            jsonHandler<MessageListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: MessageListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("messages")
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
                                MessageListPageAsync.builder()
                                    .service(MessageServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val forwardHandler: Handler<DataEnvelope<MessageForwardResponse>> =
            jsonHandler<DataEnvelope<MessageForwardResponse>>(clientOptions.jsonMapper)

        override fun forward(
            params: MessageForwardParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageForwardResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("messages", params._pathParam(0), "forward")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { forwardHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .data()
                    }
                }
        }

        private val replyHandler: Handler<DataEnvelope<MessageReplyResponse>> =
            jsonHandler<DataEnvelope<MessageReplyResponse>>(clientOptions.jsonMapper)

        override fun reply(
            params: MessageReplyParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageReplyResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("messages", params._pathParam(0), "reply")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { replyHandler.handle(it) }
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
