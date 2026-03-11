// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.namespaces.inboxes

import com.nuntly.core.AutoPager
import com.nuntly.core.Page
import com.nuntly.core.checkRequired
import com.nuntly.models.inboxes.Inbox
import com.nuntly.services.blocking.namespaces.InboxService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see InboxService.list */
class InboxListPage
private constructor(
    private val service: InboxService,
    private val params: InboxListParams,
    private val response: InboxListPageResponse,
) : Page<Inbox> {

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

    override fun nextPage(): InboxListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Inbox> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): InboxListParams = params

    /** The response that this page was parsed from. */
    fun response(): InboxListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InboxListPage].
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

    /** A builder for [InboxListPage]. */
    class Builder internal constructor() {

        private var service: InboxService? = null
        private var params: InboxListParams? = null
        private var response: InboxListPageResponse? = null

        @JvmSynthetic
        internal fun from(inboxListPage: InboxListPage) = apply {
            service = inboxListPage.service
            params = inboxListPage.params
            response = inboxListPage.response
        }

        fun service(service: InboxService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InboxListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InboxListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InboxListPage].
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
        fun build(): InboxListPage =
            InboxListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "InboxListPage{service=$service, params=$params, response=$response}"
}
