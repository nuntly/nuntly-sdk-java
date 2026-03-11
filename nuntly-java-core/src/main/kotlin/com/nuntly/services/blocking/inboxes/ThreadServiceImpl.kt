// File generated from our OpenAPI spec by Stainless.

package com.nuntly.services.blocking.inboxes

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
import com.nuntly.models.inboxes.threads.ThreadListPage
import com.nuntly.models.inboxes.threads.ThreadListPageResponse
import com.nuntly.models.inboxes.threads.ThreadListParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Browse email conversations grouped by subject. Mark threads as read or spam, and assign them to
 * an agent.
 */
class ThreadServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ThreadService {

    private val withRawResponse: ThreadService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ThreadService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService =
        ThreadServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(params: ThreadListParams, requestOptions: RequestOptions): ThreadListPage =
        // get /inboxes/{inboxId}/threads
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ThreadService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadService.WithRawResponse =
            ThreadServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<ThreadListPageResponse> =
            jsonHandler<ThreadListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ThreadListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("inboxId", params.inboxId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("inboxes", params._pathParam(0), "threads")
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
                        ThreadListPage.builder()
                            .service(ThreadServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
