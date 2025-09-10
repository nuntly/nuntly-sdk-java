// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.memberships

import com.nuntly.core.AutoPagerAsync
import com.nuntly.core.PageAsync
import com.nuntly.core.checkRequired
import com.nuntly.services.async.organizations.MembershipServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see MembershipServiceAsync.list */
class MembershipListPageAsync
private constructor(
    private val service: MembershipServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: MembershipListParams,
    private val response: MembershipListPageResponse,
) : PageAsync<MembershipListResponse> {

    /**
     * Delegates to [MembershipListPageResponse], but gracefully handles missing data.
     *
     * @see MembershipListPageResponse.data
     */
    fun data(): List<MembershipListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [MembershipListPageResponse], but gracefully handles missing data.
     *
     * @see MembershipListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<MembershipListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): MembershipListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<MembershipListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<MembershipListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): MembershipListParams = params

    /** The response that this page was parsed from. */
    fun response(): MembershipListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MembershipListPageAsync].
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

    /** A builder for [MembershipListPageAsync]. */
    class Builder internal constructor() {

        private var service: MembershipServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: MembershipListParams? = null
        private var response: MembershipListPageResponse? = null

        @JvmSynthetic
        internal fun from(membershipListPageAsync: MembershipListPageAsync) = apply {
            service = membershipListPageAsync.service
            streamHandlerExecutor = membershipListPageAsync.streamHandlerExecutor
            params = membershipListPageAsync.params
            response = membershipListPageAsync.response
        }

        fun service(service: MembershipServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: MembershipListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MembershipListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MembershipListPageAsync].
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
        fun build(): MembershipListPageAsync =
            MembershipListPageAsync(
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

        return other is MembershipListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "MembershipListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
