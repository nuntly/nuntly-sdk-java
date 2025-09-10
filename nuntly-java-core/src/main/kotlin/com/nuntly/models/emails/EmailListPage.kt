// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.nuntly.core.AutoPager
import com.nuntly.core.Page
import com.nuntly.core.checkRequired
import com.nuntly.services.blocking.EmailService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see EmailService.list */
class EmailListPage
private constructor(
    private val service: EmailService,
    private val params: EmailListParams,
    private val response: EmailListPageResponse,
) : Page<EmailListResponse> {

    /**
     * Delegates to [EmailListPageResponse], but gracefully handles missing data.
     *
     * @see EmailListPageResponse.data
     */
    fun data(): List<EmailListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [EmailListPageResponse], but gracefully handles missing data.
     *
     * @see EmailListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    override fun items(): List<EmailListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): EmailListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): EmailListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<EmailListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): EmailListParams = params

    /** The response that this page was parsed from. */
    fun response(): EmailListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EmailListPage].
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

    /** A builder for [EmailListPage]. */
    class Builder internal constructor() {

        private var service: EmailService? = null
        private var params: EmailListParams? = null
        private var response: EmailListPageResponse? = null

        @JvmSynthetic
        internal fun from(emailListPage: EmailListPage) = apply {
            service = emailListPage.service
            params = emailListPage.params
            response = emailListPage.response
        }

        fun service(service: EmailService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: EmailListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: EmailListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [EmailListPage].
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
        fun build(): EmailListPage =
            EmailListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EmailListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "EmailListPage{service=$service, params=$params, response=$response}"
}
