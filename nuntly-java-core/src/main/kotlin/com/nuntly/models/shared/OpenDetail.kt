// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkRequired
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects

class OpenDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val openedAt: JsonField<String>,
    private val userAgent: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("opened_at") @ExcludeMissing openedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("user_agent") @ExcludeMissing userAgent: JsonField<String> = JsonMissing.of(),
    ) : this(openedAt, userAgent, mutableMapOf())

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun openedAt(): String = openedAt.getRequired("opened_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun userAgent(): String = userAgent.getRequired("user_agent")

    /**
     * Returns the raw JSON value of [openedAt].
     *
     * Unlike [openedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("opened_at") @ExcludeMissing fun _openedAt(): JsonField<String> = openedAt

    /**
     * Returns the raw JSON value of [userAgent].
     *
     * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user_agent") @ExcludeMissing fun _userAgent(): JsonField<String> = userAgent

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
         * Returns a mutable builder for constructing an instance of [OpenDetail].
         *
         * The following fields are required:
         * ```java
         * .openedAt()
         * .userAgent()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OpenDetail]. */
    class Builder internal constructor() {

        private var openedAt: JsonField<String>? = null
        private var userAgent: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(openDetail: OpenDetail) = apply {
            openedAt = openDetail.openedAt
            userAgent = openDetail.userAgent
            additionalProperties = openDetail.additionalProperties.toMutableMap()
        }

        fun openedAt(openedAt: String) = openedAt(JsonField.of(openedAt))

        /**
         * Sets [Builder.openedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.openedAt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun openedAt(openedAt: JsonField<String>) = apply { this.openedAt = openedAt }

        fun userAgent(userAgent: String) = userAgent(JsonField.of(userAgent))

        /**
         * Sets [Builder.userAgent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userAgent] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

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
         * Returns an immutable instance of [OpenDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .openedAt()
         * .userAgent()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OpenDetail =
            OpenDetail(
                checkRequired("openedAt", openedAt),
                checkRequired("userAgent", userAgent),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OpenDetail = apply {
        if (validated) {
            return@apply
        }

        openedAt()
        userAgent()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (openedAt.asKnown().isPresent) 1 else 0) + (if (userAgent.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OpenDetail &&
            openedAt == other.openedAt &&
            userAgent == other.userAgent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(openedAt, userAgent, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OpenDetail{openedAt=$openedAt, userAgent=$userAgent, additionalProperties=$additionalProperties}"
}
