// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads.messages

import com.nuntly.core.AutoPager
import com.nuntly.core.Page
import com.nuntly.core.checkRequired
import com.nuntly.services.blocking.threads.MessageService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see MessageService.list */
class MessageListPage
private constructor(
    private val service: MessageService,
    private val params: MessageListParams,
    private val response: MessageListPageResponse,
) : Page<MessageListResponse> {

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see MessageListPageResponse.data
     */
    fun data(): List<MessageListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see MessageListPageResponse.nextCursor
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("nextCursor")

    override fun items(): List<MessageListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): MessageListParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): MessageListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<MessageListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListPage].
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

    /** A builder for [MessageListPage]. */
    class Builder internal constructor() {

        private var service: MessageService? = null
        private var params: MessageListParams? = null
        private var response: MessageListPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListPage: MessageListPage) = apply {
            service = messageListPage.service
            params = messageListPage.params
            response = messageListPage.response
        }

        fun service(service: MessageService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MessageListPage].
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
        fun build(): MessageListPage =
            MessageListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "MessageListPage{service=$service, params=$params, response=$response}"
}
