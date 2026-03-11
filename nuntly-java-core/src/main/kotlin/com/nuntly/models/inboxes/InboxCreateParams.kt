// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.Params
import com.nuntly.core.checkRequired
import com.nuntly.core.http.Headers
import com.nuntly.core.http.QueryParams
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Create a new inbox on a verified domain. */
class InboxCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The local-part of the email address (before the @).
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun address(): String = body.address()

    /**
     * The external AI agent identifier.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agentId(): Optional<String> = body.agentId()

    /**
     * The id of the domain for this inbox. Defaults to your provided domain when omitted.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun domainId(): Optional<String> = body.domainId()

    /**
     * The display name of the inbox.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * The id of the namespace to assign the inbox to.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun namespaceId(): Optional<String> = body.namespaceId()

    /**
     * Returns the raw JSON value of [address].
     *
     * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _address(): JsonField<String> = body._address()

    /**
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _agentId(): JsonField<String> = body._agentId()

    /**
     * Returns the raw JSON value of [domainId].
     *
     * Unlike [domainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _domainId(): JsonField<String> = body._domainId()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [namespaceId].
     *
     * Unlike [namespaceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _namespaceId(): JsonField<String> = body._namespaceId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InboxCreateParams].
         *
         * The following fields are required:
         * ```java
         * .address()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboxCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(inboxCreateParams: InboxCreateParams) = apply {
            body = inboxCreateParams.body.toBuilder()
            additionalHeaders = inboxCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = inboxCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [address]
         * - [agentId]
         * - [domainId]
         * - [name]
         * - [namespaceId]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The local-part of the email address (before the @). */
        fun address(address: String) = apply { body.address(address) }

        /**
         * Sets [Builder.address] to an arbitrary JSON value.
         *
         * You should usually call [Builder.address] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun address(address: JsonField<String>) = apply { body.address(address) }

        /** The external AI agent identifier. */
        fun agentId(agentId: String) = apply { body.agentId(agentId) }

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { body.agentId(agentId) }

        /** The id of the domain for this inbox. Defaults to your provided domain when omitted. */
        fun domainId(domainId: String) = apply { body.domainId(domainId) }

        /**
         * Sets [Builder.domainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.domainId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun domainId(domainId: JsonField<String>) = apply { body.domainId(domainId) }

        /** The display name of the inbox. */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /** The id of the namespace to assign the inbox to. */
        fun namespaceId(namespaceId: String) = apply { body.namespaceId(namespaceId) }

        /**
         * Sets [Builder.namespaceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.namespaceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun namespaceId(namespaceId: JsonField<String>) = apply { body.namespaceId(namespaceId) }

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
         * Returns an immutable instance of [InboxCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .address()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InboxCreateParams =
            InboxCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val address: JsonField<String>,
        private val agentId: JsonField<String>,
        private val domainId: JsonField<String>,
        private val name: JsonField<String>,
        private val namespaceId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
            @JsonProperty("agentId") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("domainId")
            @ExcludeMissing
            domainId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("namespaceId")
            @ExcludeMissing
            namespaceId: JsonField<String> = JsonMissing.of(),
        ) : this(address, agentId, domainId, name, namespaceId, mutableMapOf())

        /**
         * The local-part of the email address (before the @).
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun address(): String = address.getRequired("address")

        /**
         * The external AI agent identifier.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agentId(): Optional<String> = agentId.getOptional("agentId")

        /**
         * The id of the domain for this inbox. Defaults to your provided domain when omitted.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun domainId(): Optional<String> = domainId.getOptional("domainId")

        /**
         * The display name of the inbox.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * The id of the namespace to assign the inbox to.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun namespaceId(): Optional<String> = namespaceId.getOptional("namespaceId")

        /**
         * Returns the raw JSON value of [address].
         *
         * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

        /**
         * Returns the raw JSON value of [agentId].
         *
         * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agentId") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

        /**
         * Returns the raw JSON value of [domainId].
         *
         * Unlike [domainId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("domainId") @ExcludeMissing fun _domainId(): JsonField<String> = domainId

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [namespaceId].
         *
         * Unlike [namespaceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("namespaceId")
        @ExcludeMissing
        fun _namespaceId(): JsonField<String> = namespaceId

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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .address()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var address: JsonField<String>? = null
            private var agentId: JsonField<String> = JsonMissing.of()
            private var domainId: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var namespaceId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                address = body.address
                agentId = body.agentId
                domainId = body.domainId
                name = body.name
                namespaceId = body.namespaceId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The local-part of the email address (before the @). */
            fun address(address: String) = address(JsonField.of(address))

            /**
             * Sets [Builder.address] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address(address: JsonField<String>) = apply { this.address = address }

            /** The external AI agent identifier. */
            fun agentId(agentId: String) = agentId(JsonField.of(agentId))

            /**
             * Sets [Builder.agentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

            /**
             * The id of the domain for this inbox. Defaults to your provided domain when omitted.
             */
            fun domainId(domainId: String) = domainId(JsonField.of(domainId))

            /**
             * Sets [Builder.domainId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.domainId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun domainId(domainId: JsonField<String>) = apply { this.domainId = domainId }

            /** The display name of the inbox. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** The id of the namespace to assign the inbox to. */
            fun namespaceId(namespaceId: String) = namespaceId(JsonField.of(namespaceId))

            /**
             * Sets [Builder.namespaceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.namespaceId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun namespaceId(namespaceId: JsonField<String>) = apply {
                this.namespaceId = namespaceId
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
             *
             * The following fields are required:
             * ```java
             * .address()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("address", address),
                    agentId,
                    domainId,
                    name,
                    namespaceId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            address()
            agentId()
            domainId()
            name()
            namespaceId()
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
            (if (address.asKnown().isPresent) 1 else 0) +
                (if (agentId.asKnown().isPresent) 1 else 0) +
                (if (domainId.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (namespaceId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                address == other.address &&
                agentId == other.agentId &&
                domainId == other.domainId &&
                name == other.name &&
                namespaceId == other.namespaceId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(address, agentId, domainId, name, namespaceId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{address=$address, agentId=$agentId, domainId=$domainId, name=$name, namespaceId=$namespaceId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "InboxCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
