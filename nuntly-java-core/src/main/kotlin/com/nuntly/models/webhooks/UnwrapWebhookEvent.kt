// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.BaseDeserializer
import com.nuntly.core.BaseSerializer
import com.nuntly.core.JsonValue
import com.nuntly.core.allMaxBy
import com.nuntly.core.getOrThrow
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Objects
import java.util.Optional

/** The event payload */
@JsonDeserialize(using = UnwrapWebhookEvent.Deserializer::class)
@JsonSerialize(using = UnwrapWebhookEvent.Serializer::class)
class UnwrapWebhookEvent
private constructor(
    private val emailSent: EmailSentEvent? = null,
    private val emailDelivered: EmailDeliveredEvent? = null,
    private val emailOpened: EmailOpenedEvent? = null,
    private val emailClicked: EmailClickedEvent? = null,
    private val emailBounced: EmailBouncedEvent? = null,
    private val emailComplained: EmailComplainedEvent? = null,
    private val emailRejected: EmailRejectedEvent? = null,
    private val emailDeliveryDelayed: EmailDeliveryDelayedEvent? = null,
    private val emailFailed: EmailFailedEvent? = null,
    private val _json: JsonValue? = null,
) {

    fun emailSent(): Optional<EmailSentEvent> = Optional.ofNullable(emailSent)

    fun emailDelivered(): Optional<EmailDeliveredEvent> = Optional.ofNullable(emailDelivered)

    fun emailOpened(): Optional<EmailOpenedEvent> = Optional.ofNullable(emailOpened)

    fun emailClicked(): Optional<EmailClickedEvent> = Optional.ofNullable(emailClicked)

    fun emailBounced(): Optional<EmailBouncedEvent> = Optional.ofNullable(emailBounced)

    fun emailComplained(): Optional<EmailComplainedEvent> = Optional.ofNullable(emailComplained)

    fun emailRejected(): Optional<EmailRejectedEvent> = Optional.ofNullable(emailRejected)

    fun emailDeliveryDelayed(): Optional<EmailDeliveryDelayedEvent> =
        Optional.ofNullable(emailDeliveryDelayed)

    fun emailFailed(): Optional<EmailFailedEvent> = Optional.ofNullable(emailFailed)

    fun isEmailSent(): Boolean = emailSent != null

    fun isEmailDelivered(): Boolean = emailDelivered != null

    fun isEmailOpened(): Boolean = emailOpened != null

    fun isEmailClicked(): Boolean = emailClicked != null

    fun isEmailBounced(): Boolean = emailBounced != null

    fun isEmailComplained(): Boolean = emailComplained != null

    fun isEmailRejected(): Boolean = emailRejected != null

    fun isEmailDeliveryDelayed(): Boolean = emailDeliveryDelayed != null

    fun isEmailFailed(): Boolean = emailFailed != null

    fun asEmailSent(): EmailSentEvent = emailSent.getOrThrow("emailSent")

    fun asEmailDelivered(): EmailDeliveredEvent = emailDelivered.getOrThrow("emailDelivered")

    fun asEmailOpened(): EmailOpenedEvent = emailOpened.getOrThrow("emailOpened")

    fun asEmailClicked(): EmailClickedEvent = emailClicked.getOrThrow("emailClicked")

    fun asEmailBounced(): EmailBouncedEvent = emailBounced.getOrThrow("emailBounced")

    fun asEmailComplained(): EmailComplainedEvent = emailComplained.getOrThrow("emailComplained")

    fun asEmailRejected(): EmailRejectedEvent = emailRejected.getOrThrow("emailRejected")

    fun asEmailDeliveryDelayed(): EmailDeliveryDelayedEvent =
        emailDeliveryDelayed.getOrThrow("emailDeliveryDelayed")

    fun asEmailFailed(): EmailFailedEvent = emailFailed.getOrThrow("emailFailed")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            emailSent != null -> visitor.visitEmailSent(emailSent)
            emailDelivered != null -> visitor.visitEmailDelivered(emailDelivered)
            emailOpened != null -> visitor.visitEmailOpened(emailOpened)
            emailClicked != null -> visitor.visitEmailClicked(emailClicked)
            emailBounced != null -> visitor.visitEmailBounced(emailBounced)
            emailComplained != null -> visitor.visitEmailComplained(emailComplained)
            emailRejected != null -> visitor.visitEmailRejected(emailRejected)
            emailDeliveryDelayed != null -> visitor.visitEmailDeliveryDelayed(emailDeliveryDelayed)
            emailFailed != null -> visitor.visitEmailFailed(emailFailed)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): UnwrapWebhookEvent = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitEmailSent(emailSent: EmailSentEvent) {
                    emailSent.validate()
                }

                override fun visitEmailDelivered(emailDelivered: EmailDeliveredEvent) {
                    emailDelivered.validate()
                }

                override fun visitEmailOpened(emailOpened: EmailOpenedEvent) {
                    emailOpened.validate()
                }

                override fun visitEmailClicked(emailClicked: EmailClickedEvent) {
                    emailClicked.validate()
                }

                override fun visitEmailBounced(emailBounced: EmailBouncedEvent) {
                    emailBounced.validate()
                }

                override fun visitEmailComplained(emailComplained: EmailComplainedEvent) {
                    emailComplained.validate()
                }

                override fun visitEmailRejected(emailRejected: EmailRejectedEvent) {
                    emailRejected.validate()
                }

                override fun visitEmailDeliveryDelayed(
                    emailDeliveryDelayed: EmailDeliveryDelayedEvent
                ) {
                    emailDeliveryDelayed.validate()
                }

                override fun visitEmailFailed(emailFailed: EmailFailedEvent) {
                    emailFailed.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitEmailSent(emailSent: EmailSentEvent) = emailSent.validity()

                override fun visitEmailDelivered(emailDelivered: EmailDeliveredEvent) =
                    emailDelivered.validity()

                override fun visitEmailOpened(emailOpened: EmailOpenedEvent) =
                    emailOpened.validity()

                override fun visitEmailClicked(emailClicked: EmailClickedEvent) =
                    emailClicked.validity()

                override fun visitEmailBounced(emailBounced: EmailBouncedEvent) =
                    emailBounced.validity()

                override fun visitEmailComplained(emailComplained: EmailComplainedEvent) =
                    emailComplained.validity()

                override fun visitEmailRejected(emailRejected: EmailRejectedEvent) =
                    emailRejected.validity()

                override fun visitEmailDeliveryDelayed(
                    emailDeliveryDelayed: EmailDeliveryDelayedEvent
                ) = emailDeliveryDelayed.validity()

                override fun visitEmailFailed(emailFailed: EmailFailedEvent) =
                    emailFailed.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UnwrapWebhookEvent &&
            emailSent == other.emailSent &&
            emailDelivered == other.emailDelivered &&
            emailOpened == other.emailOpened &&
            emailClicked == other.emailClicked &&
            emailBounced == other.emailBounced &&
            emailComplained == other.emailComplained &&
            emailRejected == other.emailRejected &&
            emailDeliveryDelayed == other.emailDeliveryDelayed &&
            emailFailed == other.emailFailed
    }

    override fun hashCode(): Int =
        Objects.hash(
            emailSent,
            emailDelivered,
            emailOpened,
            emailClicked,
            emailBounced,
            emailComplained,
            emailRejected,
            emailDeliveryDelayed,
            emailFailed,
        )

    override fun toString(): String =
        when {
            emailSent != null -> "UnwrapWebhookEvent{emailSent=$emailSent}"
            emailDelivered != null -> "UnwrapWebhookEvent{emailDelivered=$emailDelivered}"
            emailOpened != null -> "UnwrapWebhookEvent{emailOpened=$emailOpened}"
            emailClicked != null -> "UnwrapWebhookEvent{emailClicked=$emailClicked}"
            emailBounced != null -> "UnwrapWebhookEvent{emailBounced=$emailBounced}"
            emailComplained != null -> "UnwrapWebhookEvent{emailComplained=$emailComplained}"
            emailRejected != null -> "UnwrapWebhookEvent{emailRejected=$emailRejected}"
            emailDeliveryDelayed != null ->
                "UnwrapWebhookEvent{emailDeliveryDelayed=$emailDeliveryDelayed}"
            emailFailed != null -> "UnwrapWebhookEvent{emailFailed=$emailFailed}"
            _json != null -> "UnwrapWebhookEvent{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
        }

    companion object {

        @JvmStatic
        fun ofEmailSent(emailSent: EmailSentEvent) = UnwrapWebhookEvent(emailSent = emailSent)

        @JvmStatic
        fun ofEmailDelivered(emailDelivered: EmailDeliveredEvent) =
            UnwrapWebhookEvent(emailDelivered = emailDelivered)

        @JvmStatic
        fun ofEmailOpened(emailOpened: EmailOpenedEvent) =
            UnwrapWebhookEvent(emailOpened = emailOpened)

        @JvmStatic
        fun ofEmailClicked(emailClicked: EmailClickedEvent) =
            UnwrapWebhookEvent(emailClicked = emailClicked)

        @JvmStatic
        fun ofEmailBounced(emailBounced: EmailBouncedEvent) =
            UnwrapWebhookEvent(emailBounced = emailBounced)

        @JvmStatic
        fun ofEmailComplained(emailComplained: EmailComplainedEvent) =
            UnwrapWebhookEvent(emailComplained = emailComplained)

        @JvmStatic
        fun ofEmailRejected(emailRejected: EmailRejectedEvent) =
            UnwrapWebhookEvent(emailRejected = emailRejected)

        @JvmStatic
        fun ofEmailDeliveryDelayed(emailDeliveryDelayed: EmailDeliveryDelayedEvent) =
            UnwrapWebhookEvent(emailDeliveryDelayed = emailDeliveryDelayed)

        @JvmStatic
        fun ofEmailFailed(emailFailed: EmailFailedEvent) =
            UnwrapWebhookEvent(emailFailed = emailFailed)
    }

    /**
     * An interface that defines how to map each variant of [UnwrapWebhookEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitEmailSent(emailSent: EmailSentEvent): T

        fun visitEmailDelivered(emailDelivered: EmailDeliveredEvent): T

        fun visitEmailOpened(emailOpened: EmailOpenedEvent): T

        fun visitEmailClicked(emailClicked: EmailClickedEvent): T

        fun visitEmailBounced(emailBounced: EmailBouncedEvent): T

        fun visitEmailComplained(emailComplained: EmailComplainedEvent): T

        fun visitEmailRejected(emailRejected: EmailRejectedEvent): T

        fun visitEmailDeliveryDelayed(emailDeliveryDelayed: EmailDeliveryDelayedEvent): T

        fun visitEmailFailed(emailFailed: EmailFailedEvent): T

        /**
         * Maps an unknown variant of [UnwrapWebhookEvent] to a value of type [T].
         *
         * An instance of [UnwrapWebhookEvent] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws NuntlyInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw NuntlyInvalidDataException("Unknown UnwrapWebhookEvent: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UnwrapWebhookEvent {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<EmailSentEvent>())?.let {
                            UnwrapWebhookEvent(emailSent = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailDeliveredEvent>())?.let {
                            UnwrapWebhookEvent(emailDelivered = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailOpenedEvent>())?.let {
                            UnwrapWebhookEvent(emailOpened = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailClickedEvent>())?.let {
                            UnwrapWebhookEvent(emailClicked = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailBouncedEvent>())?.let {
                            UnwrapWebhookEvent(emailBounced = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailComplainedEvent>())?.let {
                            UnwrapWebhookEvent(emailComplained = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailRejectedEvent>())?.let {
                            UnwrapWebhookEvent(emailRejected = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailDeliveryDelayedEvent>())?.let {
                            UnwrapWebhookEvent(emailDeliveryDelayed = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<EmailFailedEvent>())?.let {
                            UnwrapWebhookEvent(emailFailed = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> UnwrapWebhookEvent(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun serialize(
            value: UnwrapWebhookEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.emailSent != null -> generator.writeObject(value.emailSent)
                value.emailDelivered != null -> generator.writeObject(value.emailDelivered)
                value.emailOpened != null -> generator.writeObject(value.emailOpened)
                value.emailClicked != null -> generator.writeObject(value.emailClicked)
                value.emailBounced != null -> generator.writeObject(value.emailBounced)
                value.emailComplained != null -> generator.writeObject(value.emailComplained)
                value.emailRejected != null -> generator.writeObject(value.emailRejected)
                value.emailDeliveryDelayed != null ->
                    generator.writeObject(value.emailDeliveryDelayed)
                value.emailFailed != null -> generator.writeObject(value.emailFailed)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UnwrapWebhookEvent")
            }
        }
    }
}
