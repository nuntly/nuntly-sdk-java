// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

import com.fasterxml.jackson.annotation.JsonCreator
import com.nuntly.core.Enum
import com.nuntly.core.JsonField
import com.nuntly.errors.NuntlyInvalidDataException

/** The webhook events */
class WebhookEventType @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val EMAIL_SENT = of("email.sent")

        @JvmField val EMAIL_DELIVERED = of("email.delivered")

        @JvmField val EMAIL_OPENED = of("email.opened")

        @JvmField val EMAIL_CLICKED = of("email.clicked")

        @JvmField val EMAIL_BOUNCED = of("email.bounced")

        @JvmField val EMAIL_COMPLAINED = of("email.complained")

        @JvmField val EMAIL_REJECTED = of("email.rejected")

        @JvmField val EMAIL_DELIVERY_DELAYED = of("email.delivery_delayed")

        @JvmField val EMAIL_FAILED = of("email.failed")

        @JvmStatic fun of(value: String) = WebhookEventType(JsonField.of(value))
    }

    /** An enum containing [WebhookEventType]'s known values. */
    enum class Known {
        EMAIL_SENT,
        EMAIL_DELIVERED,
        EMAIL_OPENED,
        EMAIL_CLICKED,
        EMAIL_BOUNCED,
        EMAIL_COMPLAINED,
        EMAIL_REJECTED,
        EMAIL_DELIVERY_DELAYED,
        EMAIL_FAILED,
    }

    /**
     * An enum containing [WebhookEventType]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [WebhookEventType] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        EMAIL_SENT,
        EMAIL_DELIVERED,
        EMAIL_OPENED,
        EMAIL_CLICKED,
        EMAIL_BOUNCED,
        EMAIL_COMPLAINED,
        EMAIL_REJECTED,
        EMAIL_DELIVERY_DELAYED,
        EMAIL_FAILED,
        /**
         * An enum member indicating that [WebhookEventType] was instantiated with an unknown value.
         */
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
            EMAIL_SENT -> Value.EMAIL_SENT
            EMAIL_DELIVERED -> Value.EMAIL_DELIVERED
            EMAIL_OPENED -> Value.EMAIL_OPENED
            EMAIL_CLICKED -> Value.EMAIL_CLICKED
            EMAIL_BOUNCED -> Value.EMAIL_BOUNCED
            EMAIL_COMPLAINED -> Value.EMAIL_COMPLAINED
            EMAIL_REJECTED -> Value.EMAIL_REJECTED
            EMAIL_DELIVERY_DELAYED -> Value.EMAIL_DELIVERY_DELAYED
            EMAIL_FAILED -> Value.EMAIL_FAILED
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
            EMAIL_SENT -> Known.EMAIL_SENT
            EMAIL_DELIVERED -> Known.EMAIL_DELIVERED
            EMAIL_OPENED -> Known.EMAIL_OPENED
            EMAIL_CLICKED -> Known.EMAIL_CLICKED
            EMAIL_BOUNCED -> Known.EMAIL_BOUNCED
            EMAIL_COMPLAINED -> Known.EMAIL_COMPLAINED
            EMAIL_REJECTED -> Known.EMAIL_REJECTED
            EMAIL_DELIVERY_DELAYED -> Known.EMAIL_DELIVERY_DELAYED
            EMAIL_FAILED -> Known.EMAIL_FAILED
            else -> throw NuntlyInvalidDataException("Unknown WebhookEventType: $value")
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

    fun validate(): WebhookEventType = apply {
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

        return other is WebhookEventType && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
