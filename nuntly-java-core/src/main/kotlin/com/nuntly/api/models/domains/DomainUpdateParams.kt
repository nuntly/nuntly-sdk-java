// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.domains

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.api.core.ExcludeMissing
import com.nuntly.api.core.JsonField
import com.nuntly.api.core.JsonMissing
import com.nuntly.api.core.JsonValue
import com.nuntly.api.core.Params
import com.nuntly.api.core.http.Headers
import com.nuntly.api.core.http.QueryParams
import com.nuntly.api.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Updates domain tracking settings */
class DomainUpdateParams
private constructor(
    private val id: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /**
     * Emit an event for each time the recipient clicks a link in the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clickTracking(): Optional<Boolean> = body.clickTracking()

    /**
     * Emit an event for each recipient opens an email their email client
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun openTracking(): Optional<Boolean> = body.openTracking()

    /**
     * Returns the raw JSON value of [clickTracking].
     *
     * Unlike [clickTracking], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _clickTracking(): JsonField<Boolean> = body._clickTracking()

    /**
     * Returns the raw JSON value of [openTracking].
     *
     * Unlike [openTracking], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _openTracking(): JsonField<Boolean> = body._openTracking()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): DomainUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [DomainUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DomainUpdateParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(domainUpdateParams: DomainUpdateParams) = apply {
            id = domainUpdateParams.id
            body = domainUpdateParams.body.toBuilder()
            additionalHeaders = domainUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = domainUpdateParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [clickTracking]
         * - [openTracking]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Emit an event for each time the recipient clicks a link in the email */
        fun clickTracking(clickTracking: Boolean) = apply { body.clickTracking(clickTracking) }

        /**
         * Sets [Builder.clickTracking] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clickTracking] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun clickTracking(clickTracking: JsonField<Boolean>) = apply {
            body.clickTracking(clickTracking)
        }

        /** Emit an event for each recipient opens an email their email client */
        fun openTracking(openTracking: Boolean) = apply { body.openTracking(openTracking) }

        /**
         * Sets [Builder.openTracking] to an arbitrary JSON value.
         *
         * You should usually call [Builder.openTracking] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun openTracking(openTracking: JsonField<Boolean>) = apply {
            body.openTracking(openTracking)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [DomainUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DomainUpdateParams =
            DomainUpdateParams(
                id,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val clickTracking: JsonField<Boolean>,
        private val openTracking: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("click_tracking")
            @ExcludeMissing
            clickTracking: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("open_tracking")
            @ExcludeMissing
            openTracking: JsonField<Boolean> = JsonMissing.of(),
        ) : this(clickTracking, openTracking, mutableMapOf())

        /**
         * Emit an event for each time the recipient clicks a link in the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun clickTracking(): Optional<Boolean> = clickTracking.getOptional("click_tracking")

        /**
         * Emit an event for each recipient opens an email their email client
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun openTracking(): Optional<Boolean> = openTracking.getOptional("open_tracking")

        /**
         * Returns the raw JSON value of [clickTracking].
         *
         * Unlike [clickTracking], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("click_tracking")
        @ExcludeMissing
        fun _clickTracking(): JsonField<Boolean> = clickTracking

        /**
         * Returns the raw JSON value of [openTracking].
         *
         * Unlike [openTracking], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("open_tracking")
        @ExcludeMissing
        fun _openTracking(): JsonField<Boolean> = openTracking

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var clickTracking: JsonField<Boolean> = JsonMissing.of()
            private var openTracking: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                clickTracking = body.clickTracking
                openTracking = body.openTracking
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Emit an event for each time the recipient clicks a link in the email */
            fun clickTracking(clickTracking: Boolean) = clickTracking(JsonField.of(clickTracking))

            /**
             * Sets [Builder.clickTracking] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clickTracking] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clickTracking(clickTracking: JsonField<Boolean>) = apply {
                this.clickTracking = clickTracking
            }

            /** Emit an event for each recipient opens an email their email client */
            fun openTracking(openTracking: Boolean) = openTracking(JsonField.of(openTracking))

            /**
             * Sets [Builder.openTracking] to an arbitrary JSON value.
             *
             * You should usually call [Builder.openTracking] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun openTracking(openTracking: JsonField<Boolean>) = apply {
                this.openTracking = openTracking
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(clickTracking, openTracking, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            clickTracking()
            openTracking()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: NuntlyInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (clickTracking.asKnown().isPresent) 1 else 0) +
                (if (openTracking.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                clickTracking == other.clickTracking &&
                openTracking == other.openTracking &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(clickTracking, openTracking, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{clickTracking=$clickTracking, openTracking=$openTracking, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DomainUpdateParams &&
            id == other.id &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(id, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "DomainUpdateParams{id=$id, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
