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

class ClickDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val clickedAt: JsonField<String>,
    private val link: JsonField<String>,
    private val userAgent: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("clicked_at") @ExcludeMissing clickedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("link") @ExcludeMissing link: JsonField<String> = JsonMissing.of(),
        @JsonProperty("user_agent") @ExcludeMissing userAgent: JsonField<String> = JsonMissing.of(),
    ) : this(clickedAt, link, userAgent, mutableMapOf())

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun clickedAt(): String = clickedAt.getRequired("clicked_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun link(): String = link.getRequired("link")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun userAgent(): String = userAgent.getRequired("user_agent")

    /**
     * Returns the raw JSON value of [clickedAt].
     *
     * Unlike [clickedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("clicked_at") @ExcludeMissing fun _clickedAt(): JsonField<String> = clickedAt

    /**
     * Returns the raw JSON value of [link].
     *
     * Unlike [link], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("link") @ExcludeMissing fun _link(): JsonField<String> = link

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
         * Returns a mutable builder for constructing an instance of [ClickDetail].
         *
         * The following fields are required:
         * ```java
         * .clickedAt()
         * .link()
         * .userAgent()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ClickDetail]. */
    class Builder internal constructor() {

        private var clickedAt: JsonField<String>? = null
        private var link: JsonField<String>? = null
        private var userAgent: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(clickDetail: ClickDetail) = apply {
            clickedAt = clickDetail.clickedAt
            link = clickDetail.link
            userAgent = clickDetail.userAgent
            additionalProperties = clickDetail.additionalProperties.toMutableMap()
        }

        fun clickedAt(clickedAt: String) = clickedAt(JsonField.of(clickedAt))

        /**
         * Sets [Builder.clickedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clickedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clickedAt(clickedAt: JsonField<String>) = apply { this.clickedAt = clickedAt }

        fun link(link: String) = link(JsonField.of(link))

        /**
         * Sets [Builder.link] to an arbitrary JSON value.
         *
         * You should usually call [Builder.link] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun link(link: JsonField<String>) = apply { this.link = link }

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
         * Returns an immutable instance of [ClickDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .clickedAt()
         * .link()
         * .userAgent()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ClickDetail =
            ClickDetail(
                checkRequired("clickedAt", clickedAt),
                checkRequired("link", link),
                checkRequired("userAgent", userAgent),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ClickDetail = apply {
        if (validated) {
            return@apply
        }

        clickedAt()
        link()
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
        (if (clickedAt.asKnown().isPresent) 1 else 0) +
            (if (link.asKnown().isPresent) 1 else 0) +
            (if (userAgent.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ClickDetail &&
            clickedAt == other.clickedAt &&
            link == other.link &&
            userAgent == other.userAgent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(clickedAt, link, userAgent, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ClickDetail{clickedAt=$clickedAt, link=$link, userAgent=$userAgent, additionalProperties=$additionalProperties}"
}
