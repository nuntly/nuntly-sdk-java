// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.domains

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

class DomainUpdateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val clickTracking: JsonField<Boolean>,
    private val openTracking: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("clickTracking")
        @ExcludeMissing
        clickTracking: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("openTracking")
        @ExcludeMissing
        openTracking: JsonField<Boolean> = JsonMissing.of(),
    ) : this(id, clickTracking, openTracking, mutableMapOf())

    /**
     * The id of the domain
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Emit an event for each time the recipient clicks a link in the email
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun clickTracking(): Boolean = clickTracking.getRequired("clickTracking")

    /**
     * Emit an event for each recipient opens an email their email client
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun openTracking(): Boolean = openTracking.getRequired("openTracking")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [clickTracking].
     *
     * Unlike [clickTracking], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("clickTracking")
    @ExcludeMissing
    fun _clickTracking(): JsonField<Boolean> = clickTracking

    /**
     * Returns the raw JSON value of [openTracking].
     *
     * Unlike [openTracking], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("openTracking")
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

        /**
         * Returns a mutable builder for constructing an instance of [DomainUpdateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .clickTracking()
         * .openTracking()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DomainUpdateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var clickTracking: JsonField<Boolean>? = null
        private var openTracking: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(domainUpdateResponse: DomainUpdateResponse) = apply {
            id = domainUpdateResponse.id
            clickTracking = domainUpdateResponse.clickTracking
            openTracking = domainUpdateResponse.openTracking
            additionalProperties = domainUpdateResponse.additionalProperties.toMutableMap()
        }

        /** The id of the domain */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

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
         * You should usually call [Builder.openTracking] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [DomainUpdateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .clickTracking()
         * .openTracking()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DomainUpdateResponse =
            DomainUpdateResponse(
                checkRequired("id", id),
                checkRequired("clickTracking", clickTracking),
                checkRequired("openTracking", openTracking),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DomainUpdateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (clickTracking.asKnown().isPresent) 1 else 0) +
            (if (openTracking.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DomainUpdateResponse &&
            id == other.id &&
            clickTracking == other.clickTracking &&
            openTracking == other.openTracking &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, clickTracking, openTracking, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DomainUpdateResponse{id=$id, clickTracking=$clickTracking, openTracking=$openTracking, additionalProperties=$additionalProperties}"
}
