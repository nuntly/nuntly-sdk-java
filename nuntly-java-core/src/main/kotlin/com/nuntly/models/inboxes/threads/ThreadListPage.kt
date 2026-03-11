// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes.threads

import com.nuntly.core.AutoPager
import com.nuntly.core.Page
import com.nuntly.core.checkRequired
import com.nuntly.models.threads.Thread
import com.nuntly.services.blocking.inboxes.ThreadService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ThreadService.list */
class ThreadListPage
private constructor(
    private val service: ThreadService,
    private val params: ThreadListParams,
    private val response: ThreadListPageResponse,
) : Page<Thread> {

    /**
     * Delegates to [ThreadListPageResponse], but gracefully handles missing data.
     *
     * @see ThreadListPageResponse.data
     */
    fun data(): List<Thread> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ThreadListPageResponse], but gracefully handles missing data.
     *
     * @see ThreadListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("nextCursor")

    override fun items(): List<Thread> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): ThreadListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): ThreadListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Thread> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ThreadListParams = params

    /** The response that this page was parsed from. */
    fun response(): ThreadListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ThreadListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ThreadListPage]. */
    class Builder internal constructor() {

        private var service: ThreadService? = null
        private var params: ThreadListParams? = null
        private var response: ThreadListPageResponse? = null

        @JvmSynthetic
        internal fun from(threadListPage: ThreadListPage) = apply {
            service = threadListPage.service
            params = threadListPage.params
            response = threadListPage.response
        }

        fun service(service: ThreadService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ThreadListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ThreadListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ThreadListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ThreadListPage =
            ThreadListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ThreadListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "ThreadListPage{service=$service, params=$params, response=$response}"
}
