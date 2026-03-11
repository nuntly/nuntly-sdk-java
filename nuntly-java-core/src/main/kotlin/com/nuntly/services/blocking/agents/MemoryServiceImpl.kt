// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.agents

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
import com.nuntly.models.agents.AgentMemory
import com.nuntly.models.agents.memory.MemoryRetrieveParams
import com.nuntly.models.agents.memory.MemoryUpsertParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Read and write persistent state for an AI agent, optionally scoped to a specific inbox or thread.
 */
class MemoryServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MemoryService {

    private val withRawResponse: MemoryService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MemoryService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MemoryService =
        MemoryServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: MemoryRetrieveParams,
        requestOptions: RequestOptions,
    ): AgentMemory =
        // get /agents/{agentId}/memory
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun upsert(params: MemoryUpsertParams, requestOptions: RequestOptions): AgentMemory =
        // put /agents/{agentId}/memory
        withRawResponse().upsert(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MemoryService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MemoryService.WithRawResponse =
            MemoryServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<DataEnvelope<AgentMemory>> =
            jsonHandler<DataEnvelope<AgentMemory>>(clientOptions.jsonMapper)

        override fun retrieve(
            params: MemoryRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentMemory> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("agentId", params.agentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", params._pathParam(0), "memory")
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

        private val upsertHandler: Handler<DataEnvelope<AgentMemory>> =
            jsonHandler<DataEnvelope<AgentMemory>>(clientOptions.jsonMapper)

        override fun upsert(
            params: MemoryUpsertParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentMemory> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("agentId", params.agentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", params._pathParam(0), "memory")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { upsertHandler.handle(it) }
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
