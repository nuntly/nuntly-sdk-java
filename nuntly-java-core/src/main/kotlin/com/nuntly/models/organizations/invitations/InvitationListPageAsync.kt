// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.invitations

import com.nuntly.core.AutoPagerAsync
import com.nuntly.core.PageAsync
import com.nuntly.core.checkRequired
import com.nuntly.services.async.organizations.InvitationServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see InvitationServiceAsync.list */
class InvitationListPageAsync
private constructor(
    private val service: InvitationServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: InvitationListParams,
    private val response: InvitationListPageResponse,
) : PageAsync<InvitationListResponse> {

    /**
     * Delegates to [InvitationListPageResponse], but gracefully handles missing data.
     *
     * @see InvitationListPageResponse.data
     */
    fun data(): List<InvitationListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [InvitationListPageResponse], but gracefully handles missing data.
     *
     * @see InvitationListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<InvitationListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): InvitationListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<InvitationListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<InvitationListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): InvitationListParams = params

    /** The response that this page was parsed from. */
    fun response(): InvitationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InvitationListPageAsync].
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

    /** A builder for [InvitationListPageAsync]. */
    class Builder internal constructor() {

        private var service: InvitationServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: InvitationListParams? = null
        private var response: InvitationListPageResponse? = null

        @JvmSynthetic
        internal fun from(invitationListPageAsync: InvitationListPageAsync) = apply {
            service = invitationListPageAsync.service
            streamHandlerExecutor = invitationListPageAsync.streamHandlerExecutor
            params = invitationListPageAsync.params
            response = invitationListPageAsync.response
        }

        fun service(service: InvitationServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: InvitationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InvitationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InvitationListPageAsync].
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
        fun build(): InvitationListPageAsync =
            InvitationListPageAsync(
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

        return other is InvitationListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "InvitationListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
