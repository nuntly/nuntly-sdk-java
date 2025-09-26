// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.invitations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.Enum
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkRequired
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class InvitationDeleteResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val invitationId: JsonField<String>,
    private val kind: JsonField<Kind>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("invitation_id")
        @ExcludeMissing
        invitationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kind") @ExcludeMissing kind: JsonField<Kind> = JsonMissing.of(),
    ) : this(id, invitationId, kind, mutableMapOf())

    /**
     * The id of the organization
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The id of the invitation
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun invitationId(): String = invitationId.getRequired("invitation_id")

    /**
     * The kind of object returned
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun kind(): Kind = kind.getRequired("kind")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [invitationId].
     *
     * Unlike [invitationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invitation_id")
    @ExcludeMissing
    fun _invitationId(): JsonField<String> = invitationId

    /**
     * Returns the raw JSON value of [kind].
     *
     * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<Kind> = kind

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
         * Returns a mutable builder for constructing an instance of [InvitationDeleteResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .invitationId()
         * .kind()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InvitationDeleteResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var invitationId: JsonField<String>? = null
        private var kind: JsonField<Kind>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(invitationDeleteResponse: InvitationDeleteResponse) = apply {
            id = invitationDeleteResponse.id
            invitationId = invitationDeleteResponse.invitationId
            kind = invitationDeleteResponse.kind
            additionalProperties = invitationDeleteResponse.additionalProperties.toMutableMap()
        }

        /** The id of the organization */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The id of the invitation */
        fun invitationId(invitationId: String) = invitationId(JsonField.of(invitationId))

        /**
         * Sets [Builder.invitationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.invitationId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun invitationId(invitationId: JsonField<String>) = apply {
            this.invitationId = invitationId
        }

        /** The kind of object returned */
        fun kind(kind: Kind) = kind(JsonField.of(kind))

        /**
         * Sets [Builder.kind] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kind] with a well-typed [Kind] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun kind(kind: JsonField<Kind>) = apply { this.kind = kind }

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
         * Returns an immutable instance of [InvitationDeleteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .invitationId()
         * .kind()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InvitationDeleteResponse =
            InvitationDeleteResponse(
                checkRequired("id", id),
                checkRequired("invitationId", invitationId),
                checkRequired("kind", kind),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InvitationDeleteResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        invitationId()
        kind().validate()
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
            (if (invitationId.asKnown().isPresent) 1 else 0) +
            (kind.asKnown().getOrNull()?.validity() ?: 0)

    /** The kind of object returned */
    class Kind @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INVITATION = of("invitation")

            @JvmStatic fun of(value: String) = Kind(JsonField.of(value))
        }

        /** An enum containing [Kind]'s known values. */
        enum class Known {
            INVITATION
        }

        /**
         * An enum containing [Kind]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Kind] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INVITATION,
            /** An enum member indicating that [Kind] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INVITATION -> Value.INVITATION
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws NuntlyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                INVITATION -> Known.INVITATION
                else -> throw NuntlyInvalidDataException("Unknown Kind: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws NuntlyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Kind = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Kind && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvitationDeleteResponse &&
            id == other.id &&
            invitationId == other.invitationId &&
            kind == other.kind &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, invitationId, kind, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InvitationDeleteResponse{id=$id, invitationId=$invitationId, kind=$kind, additionalProperties=$additionalProperties}"
}
