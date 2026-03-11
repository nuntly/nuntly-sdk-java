// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces.inboxes

import com.nuntly.core.AutoPagerAsync
import com.nuntly.core.PageAsync
import com.nuntly.core.checkRequired
import com.nuntly.models.inboxes.Inbox
import com.nuntly.services.async.namespaces.InboxServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see InboxServiceAsync.list */
class InboxListPageAsync
private constructor(
    private val service: InboxServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: InboxListParams,
    private val response: InboxListPageResponse,
) : PageAsync<Inbox> {

    /**
     * Delegates to [InboxListPageResponse], but gracefully handles missing data.
     *
     * @see InboxListPageResponse.data
     */
    fun data(): List<Inbox> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [InboxListPageResponse], but gracefully handles missing data.
     *
     * @see InboxListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("nextCursor")

    override fun items(): List<Inbox> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): InboxListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<InboxListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Inbox> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): InboxListParams = params

    /** The response that this page was parsed from. */
    fun response(): InboxListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InboxListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboxListPageAsync]. */
    class Builder internal constructor() {

        private var service: InboxServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: InboxListParams? = null
        private var response: InboxListPageResponse? = null

        @JvmSynthetic
        internal fun from(inboxListPageAsync: InboxListPageAsync) = apply {
            service = inboxListPageAsync.service
            streamHandlerExecutor = inboxListPageAsync.streamHandlerExecutor
            params = inboxListPageAsync.params
            response = inboxListPageAsync.response
        }

        fun service(service: InboxServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: InboxListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InboxListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InboxListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InboxListPageAsync =
            InboxListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "InboxListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
