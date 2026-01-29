// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails

import com.fasterxml.jackson.annotation.JsonCreator
import com.nuntly.core.Enum
import com.nuntly.core.JsonField
import com.nuntly.errors.NuntlyInvalidDataException

/** The status of the email. */
class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val QUEUED = of("queued")

        @JvmField val SCHEDULED = of("scheduled")

        @JvmField val PROCESSED = of("processed")

        @JvmField val FAILED = of("failed")

        @JvmField val SENDING = of("sending")

        @JvmField val SENT = of("sent")

        @JvmField val DELIVERED = of("delivered")

        @JvmField val BOUNCED = of("bounced")

        @JvmField val COMPLAINED = of("complained")

        @JvmField val CANCELED = of("canceled")

        @JvmField val REJECTED = of("rejected")

        @JvmStatic fun of(value: String) = Status(JsonField.of(value))
    }

    /** An enum containing [Status]'s known values. */
    enum class Known {
        QUEUED,
        SCHEDULED,
        PROCESSED,
        FAILED,
        SENDING,
        SENT,
        DELIVERED,
        BOUNCED,
        COMPLAINED,
        CANCELED,
        REJECTED,
    }

    /**
     * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [Status] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        QUEUED,
        SCHEDULED,
        PROCESSED,
        FAILED,
        SENDING,
        SENT,
        DELIVERED,
        BOUNCED,
        COMPLAINED,
        CANCELED,
        REJECTED,
        /** An enum member indicating that [Status] was instantiated with an unknown value. */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            QUEUED -> Value.QUEUED
            SCHEDULED -> Value.SCHEDULED
            PROCESSED -> Value.PROCESSED
            FAILED -> Value.FAILED
            SENDING -> Value.SENDING
            SENT -> Value.SENT
            DELIVERED -> Value.DELIVERED
            BOUNCED -> Value.BOUNCED
            COMPLAINED -> Value.COMPLAINED
            CANCELED -> Value.CANCELED
            REJECTED -> Value.REJECTED
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws NuntlyInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            QUEUED -> Known.QUEUED
            SCHEDULED -> Known.SCHEDULED
            PROCESSED -> Known.PROCESSED
            FAILED -> Known.FAILED
            SENDING -> Known.SENDING
            SENT -> Known.SENT
            DELIVERED -> Known.DELIVERED
            BOUNCED -> Known.BOUNCED
            COMPLAINED -> Known.COMPLAINED
            CANCELED -> Known.CANCELED
            REJECTED -> Known.REJECTED
            else -> throw NuntlyInvalidDataException("Unknown Status: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws NuntlyInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): Status = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Status && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
