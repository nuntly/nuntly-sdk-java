// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.emails

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
import com.nuntly.core.http.parseable
import com.nuntly.core.prepare
import com.nuntly.models.DataEnvelope
import com.nuntly.models.emails.content.ContentRetrieveParams
import com.nuntly.models.emails.content.ContentRetrieveResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ContentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ContentService {

    private val withRawResponse: ContentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentService =
        ContentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions,
    ): ContentRetrieveResponse =
        // get /emails/{id}/content
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContentService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContentService.WithRawResponse =
            ContentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<DataEnvelope<ContentRetrieveResponse>> =
            jsonHandler<DataEnvelope<ContentRetrieveResponse>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContentRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("emails", params._pathParam(0), "content")
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
    }
}
