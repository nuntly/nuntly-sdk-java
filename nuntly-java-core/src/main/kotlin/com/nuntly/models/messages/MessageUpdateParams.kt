// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.Params
import com.nuntly.core.checkKnown
import com.nuntly.core.http.Headers
import com.nuntly.core.http.QueryParams
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Update message labels. Only available for messages in user-created inboxes. */
class MessageUpdateParams
private constructor(
    private val messageId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun messageId(): Optional<String> = Optional.ofNullable(messageId)

    /**
     * Labels to add to the message.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addLabels(): Optional<List<String>> = body.addLabels()

    /**
     * Labels to remove from the message.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun removeLabels(): Optional<List<String>> = body.removeLabels()

    /**
     * Returns the raw JSON value of [addLabels].
     *
     * Unlike [addLabels], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _addLabels(): JsonField<List<String>> = body._addLabels()

    /**
     * Returns the raw JSON value of [removeLabels].
     *
     * Unlike [removeLabels], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _removeLabels(): JsonField<List<String>> = body._removeLabels()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): MessageUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [MessageUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageUpdateParams]. */
    class Builder internal constructor() {

        private var messageId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(messageUpdateParams: MessageUpdateParams) = apply {
            messageId = messageUpdateParams.messageId
            body = messageUpdateParams.body.toBuilder()
            additionalHeaders = messageUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = messageUpdateParams.additionalQueryParams.toBuilder()
        }

        fun messageId(messageId: String?) = apply { this.messageId = messageId }

        /** Alias for calling [Builder.messageId] with `messageId.orElse(null)`. */
        fun messageId(messageId: Optional<String>) = messageId(messageId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [addLabels]
         * - [removeLabels]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Labels to add to the message. */
        fun addLabels(addLabels: List<String>) = apply { body.addLabels(addLabels) }

        /**
         * Sets [Builder.addLabels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addLabels] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun addLabels(addLabels: JsonField<List<String>>) = apply { body.addLabels(addLabels) }

        /**
         * Adds a single [String] to [addLabels].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAddLabel(addLabel: String) = apply { body.addAddLabel(addLabel) }

        /** Labels to remove from the message. */
        fun removeLabels(removeLabels: List<String>) = apply { body.removeLabels(removeLabels) }

        /**
         * Sets [Builder.removeLabels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.removeLabels] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun removeLabels(removeLabels: JsonField<List<String>>) = apply {
            body.removeLabels(removeLabels)
        }

        /**
         * Adds a single [String] to [removeLabels].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRemoveLabel(removeLabel: String) = apply { body.addRemoveLabel(removeLabel) }

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
         * Returns an immutable instance of [MessageUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageUpdateParams =
            MessageUpdateParams(
                messageId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> messageId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val addLabels: JsonField<List<String>>,
        private val removeLabels: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("addLabels")
            @ExcludeMissing
            addLabels: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("removeLabels")
            @ExcludeMissing
            removeLabels: JsonField<List<String>> = JsonMissing.of(),
        ) : this(addLabels, removeLabels, mutableMapOf())

        /**
         * Labels to add to the message.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun addLabels(): Optional<List<String>> = addLabels.getOptional("addLabels")

        /**
         * Labels to remove from the message.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun removeLabels(): Optional<List<String>> = removeLabels.getOptional("removeLabels")

        /**
         * Returns the raw JSON value of [addLabels].
         *
         * Unlike [addLabels], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("addLabels")
        @ExcludeMissing
        fun _addLabels(): JsonField<List<String>> = addLabels

        /**
         * Returns the raw JSON value of [removeLabels].
         *
         * Unlike [removeLabels], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("removeLabels")
        @ExcludeMissing
        fun _removeLabels(): JsonField<List<String>> = removeLabels

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

            private var addLabels: JsonField<MutableList<String>>? = null
            private var removeLabels: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                addLabels = body.addLabels.map { it.toMutableList() }
                removeLabels = body.removeLabels.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Labels to add to the message. */
            fun addLabels(addLabels: List<String>) = addLabels(JsonField.of(addLabels))

            /**
             * Sets [Builder.addLabels] to an arbitrary JSON value.
             *
             * You should usually call [Builder.addLabels] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun addLabels(addLabels: JsonField<List<String>>) = apply {
                this.addLabels = addLabels.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [addLabels].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAddLabel(addLabel: String) = apply {
                addLabels =
                    (addLabels ?: JsonField.of(mutableListOf())).also {
                        checkKnown("addLabels", it).add(addLabel)
                    }
            }

            /** Labels to remove from the message. */
            fun removeLabels(removeLabels: List<String>) = removeLabels(JsonField.of(removeLabels))

            /**
             * Sets [Builder.removeLabels] to an arbitrary JSON value.
             *
             * You should usually call [Builder.removeLabels] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun removeLabels(removeLabels: JsonField<List<String>>) = apply {
                this.removeLabels = removeLabels.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [removeLabels].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRemoveLabel(removeLabel: String) = apply {
                removeLabels =
                    (removeLabels ?: JsonField.of(mutableListOf())).also {
                        checkKnown("removeLabels", it).add(removeLabel)
                    }
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
                Body(
                    (addLabels ?: JsonMissing.of()).map { it.toImmutable() },
                    (removeLabels ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            addLabels()
            removeLabels()
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
            (addLabels.asKnown().getOrNull()?.size ?: 0) +
                (removeLabels.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                addLabels == other.addLabels &&
                removeLabels == other.removeLabels &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(addLabels, removeLabels, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{addLabels=$addLabels, removeLabels=$removeLabels, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageUpdateParams &&
            messageId == other.messageId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(messageId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MessageUpdateParams{messageId=$messageId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
