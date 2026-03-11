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
import com.nuntly.models.messages.MessageDetail
import com.nuntly.models.messages.MessageForwardParams
import com.nuntly.models.messages.MessageForwardResponse
import com.nuntly.models.messages.MessageListPage
import com.nuntly.models.messages.MessageListPageResponse
import com.nuntly.models.messages.MessageListParams
import com.nuntly.models.messages.MessageReplyParams
import com.nuntly.models.messages.MessageReplyResponse
import com.nuntly.models.messages.MessageRetrieveParams
import com.nuntly.services.blocking.messages.AttachmentService
import com.nuntly.services.blocking.messages.AttachmentServiceImpl
import com.nuntly.services.blocking.messages.ContentService
import com.nuntly.services.blocking.messages.ContentServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Access received messages, download attachments, and send replies or forwards from an inbox. */
class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val content: ContentService by lazy { ContentServiceImpl(clientOptions) }

    private val attachments: AttachmentService by lazy { AttachmentServiceImpl(clientOptions) }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService =
        MessageServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    override fun content(): ContentService = content

    /**
     * Access received messages, download attachments, and send replies or forwards from an inbox.
     */
    override fun attachments(): AttachmentService = attachments

    override fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions,
    ): MessageDetail =
        // get /messages/{messageId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: MessageListParams, requestOptions: RequestOptions): MessageListPage =
        // get /messages
        withRawResponse().list(params, requestOptions).parse()

    override fun forward(
        params: MessageForwardParams,
        requestOptions: RequestOptions,
    ): MessageForwardResponse =
        // post /messages/{messageId}/forward
        withRawResponse().forward(params, requestOptions).parse()

    override fun reply(
        params: MessageReplyParams,
        requestOptions: RequestOptions,
    ): MessageReplyResponse =
        // post /messages/{messageId}/reply
        withRawResponse().reply(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val content: ContentService.WithRawResponse by lazy {
            ContentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val attachments: AttachmentService.WithRawResponse by lazy {
            AttachmentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageService.WithRawResponse =
            MessageServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        override fun content(): ContentService.WithRawResponse = content

        /**
         * Access received messages, download attachments, and send replies or forwards from an
         * inbox.
         */
        override fun attachments(): AttachmentService.WithRawResponse = attachments

        private val retrieveHandler: Handler<DataEnvelope<MessageDetail>> =
            jsonHandler<DataEnvelope<MessageDetail>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageDetail> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("messages", params._pathParam(0))
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

        private val listHandler: Handler<MessageListPageResponse> =
            jsonHandler<MessageListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: MessageListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("messages")
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
                        MessageListPage.builder()
                            .service(MessageServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val forwardHandler: Handler<DataEnvelope<MessageForwardResponse>> =
            jsonHandler<DataEnvelope<MessageForwardResponse>>(clientOptions.jsonMapper)

        override fun forward(
            params: MessageForwardParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageForwardResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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

        private val replyHandler: Handler<DataEnvelope<MessageReplyResponse>> =
            jsonHandler<DataEnvelope<MessageReplyResponse>>(clientOptions.jsonMapper)

        override fun reply(
            params: MessageReplyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageReplyResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
