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
import com.nuntly.core.getOrThrow
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Payload for webhook events representing email events, eg. sent, bounced, opened, clicked,
 * complained, etc.
 */
@JsonDeserialize(using = UnwrapWebhookEvent.Deserializer::class)
@JsonSerialize(using = UnwrapWebhookEvent.Serializer::class)
class UnwrapWebhookEvent
private constructor(
    private val emailQueued: EmailQueuedEvent? = null,
    private val emailScheduled: EmailScheduledEvent? = null,
    private val emailProcessed: EmailProcessedEvent? = null,
    private val emailSending: EmailSendingEvent? = null,
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

    /** Event triggered when an email is queued for sending. */
    fun emailQueued(): Optional<EmailQueuedEvent> = Optional.ofNullable(emailQueued)

    /** Event triggered when an email is scheduled for sending. */
    fun emailScheduled(): Optional<EmailScheduledEvent> = Optional.ofNullable(emailScheduled)

    /** Event triggered when an email is processed. */
    fun emailProcessed(): Optional<EmailProcessedEvent> = Optional.ofNullable(emailProcessed)

    /** Event triggered when an email is being sent. */
    fun emailSending(): Optional<EmailSendingEvent> = Optional.ofNullable(emailSending)

    /** Event triggered when an email is sent successfully. */
    fun emailSent(): Optional<EmailSentEvent> = Optional.ofNullable(emailSent)

    /** Event triggered when an email is delivered successfully. */
    fun emailDelivered(): Optional<EmailDeliveredEvent> = Optional.ofNullable(emailDelivered)

    /** Event triggered when an email is opened by the recipient. */
    fun emailOpened(): Optional<EmailOpenedEvent> = Optional.ofNullable(emailOpened)

    /** Event triggered when a link within an email is clicked by the recipient. */
    fun emailClicked(): Optional<EmailClickedEvent> = Optional.ofNullable(emailClicked)

    /** Event triggered when an email bounces. */
    fun emailBounced(): Optional<EmailBouncedEvent> = Optional.ofNullable(emailBounced)

    /** Event triggered when an email is marked as complained by the recipient. */
    fun emailComplained(): Optional<EmailComplainedEvent> = Optional.ofNullable(emailComplained)

    /** Event triggered when an email is rejected. */
    fun emailRejected(): Optional<EmailRejectedEvent> = Optional.ofNullable(emailRejected)

    /** Event triggered when an email delivery is delayed. */
    fun emailDeliveryDelayed(): Optional<EmailDeliveryDelayedEvent> =
        Optional.ofNullable(emailDeliveryDelayed)

    /** Event triggered when an email fails to be sent. */
    fun emailFailed(): Optional<EmailFailedEvent> = Optional.ofNullable(emailFailed)

    fun isEmailQueued(): Boolean = emailQueued != null

    fun isEmailScheduled(): Boolean = emailScheduled != null

    fun isEmailProcessed(): Boolean = emailProcessed != null

    fun isEmailSending(): Boolean = emailSending != null

    fun isEmailSent(): Boolean = emailSent != null

    fun isEmailDelivered(): Boolean = emailDelivered != null

    fun isEmailOpened(): Boolean = emailOpened != null

    fun isEmailClicked(): Boolean = emailClicked != null

    fun isEmailBounced(): Boolean = emailBounced != null

    fun isEmailComplained(): Boolean = emailComplained != null

    fun isEmailRejected(): Boolean = emailRejected != null

    fun isEmailDeliveryDelayed(): Boolean = emailDeliveryDelayed != null

    fun isEmailFailed(): Boolean = emailFailed != null

    /** Event triggered when an email is queued for sending. */
    fun asEmailQueued(): EmailQueuedEvent = emailQueued.getOrThrow("emailQueued")

    /** Event triggered when an email is scheduled for sending. */
    fun asEmailScheduled(): EmailScheduledEvent = emailScheduled.getOrThrow("emailScheduled")

    /** Event triggered when an email is processed. */
    fun asEmailProcessed(): EmailProcessedEvent = emailProcessed.getOrThrow("emailProcessed")

    /** Event triggered when an email is being sent. */
    fun asEmailSending(): EmailSendingEvent = emailSending.getOrThrow("emailSending")

    /** Event triggered when an email is sent successfully. */
    fun asEmailSent(): EmailSentEvent = emailSent.getOrThrow("emailSent")

    /** Event triggered when an email is delivered successfully. */
    fun asEmailDelivered(): EmailDeliveredEvent = emailDelivered.getOrThrow("emailDelivered")

    /** Event triggered when an email is opened by the recipient. */
    fun asEmailOpened(): EmailOpenedEvent = emailOpened.getOrThrow("emailOpened")

    /** Event triggered when a link within an email is clicked by the recipient. */
    fun asEmailClicked(): EmailClickedEvent = emailClicked.getOrThrow("emailClicked")

    /** Event triggered when an email bounces. */
    fun asEmailBounced(): EmailBouncedEvent = emailBounced.getOrThrow("emailBounced")

    /** Event triggered when an email is marked as complained by the recipient. */
    fun asEmailComplained(): EmailComplainedEvent = emailComplained.getOrThrow("emailComplained")

    /** Event triggered when an email is rejected. */
    fun asEmailRejected(): EmailRejectedEvent = emailRejected.getOrThrow("emailRejected")

    /** Event triggered when an email delivery is delayed. */
    fun asEmailDeliveryDelayed(): EmailDeliveryDelayedEvent =
        emailDeliveryDelayed.getOrThrow("emailDeliveryDelayed")

    /** Event triggered when an email fails to be sent. */
    fun asEmailFailed(): EmailFailedEvent = emailFailed.getOrThrow("emailFailed")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            emailQueued != null -> visitor.visitEmailQueued(emailQueued)
            emailScheduled != null -> visitor.visitEmailScheduled(emailScheduled)
            emailProcessed != null -> visitor.visitEmailProcessed(emailProcessed)
            emailSending != null -> visitor.visitEmailSending(emailSending)
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
                override fun visitEmailQueued(emailQueued: EmailQueuedEvent) {
                    emailQueued.validate()
                }

                override fun visitEmailScheduled(emailScheduled: EmailScheduledEvent) {
                    emailScheduled.validate()
                }

                override fun visitEmailProcessed(emailProcessed: EmailProcessedEvent) {
                    emailProcessed.validate()
                }

                override fun visitEmailSending(emailSending: EmailSendingEvent) {
                    emailSending.validate()
                }

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
                override fun visitEmailQueued(emailQueued: EmailQueuedEvent) =
                    emailQueued.validity()

                override fun visitEmailScheduled(emailScheduled: EmailScheduledEvent) =
                    emailScheduled.validity()

                override fun visitEmailProcessed(emailProcessed: EmailProcessedEvent) =
                    emailProcessed.validity()

                override fun visitEmailSending(emailSending: EmailSendingEvent) =
                    emailSending.validity()

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
            emailQueued == other.emailQueued &&
            emailScheduled == other.emailScheduled &&
            emailProcessed == other.emailProcessed &&
            emailSending == other.emailSending &&
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
            emailQueued,
            emailScheduled,
            emailProcessed,
            emailSending,
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
            emailQueued != null -> "UnwrapWebhookEvent{emailQueued=$emailQueued}"
            emailScheduled != null -> "UnwrapWebhookEvent{emailScheduled=$emailScheduled}"
            emailProcessed != null -> "UnwrapWebhookEvent{emailProcessed=$emailProcessed}"
            emailSending != null -> "UnwrapWebhookEvent{emailSending=$emailSending}"
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

        /** Event triggered when an email is queued for sending. */
        @JvmStatic
        fun ofEmailQueued(emailQueued: EmailQueuedEvent) =
            UnwrapWebhookEvent(emailQueued = emailQueued)

        /** Event triggered when an email is scheduled for sending. */
        @JvmStatic
        fun ofEmailScheduled(emailScheduled: EmailScheduledEvent) =
            UnwrapWebhookEvent(emailScheduled = emailScheduled)

        /** Event triggered when an email is processed. */
        @JvmStatic
        fun ofEmailProcessed(emailProcessed: EmailProcessedEvent) =
            UnwrapWebhookEvent(emailProcessed = emailProcessed)

        /** Event triggered when an email is being sent. */
        @JvmStatic
        fun ofEmailSending(emailSending: EmailSendingEvent) =
            UnwrapWebhookEvent(emailSending = emailSending)

        /** Event triggered when an email is sent successfully. */
        @JvmStatic
        fun ofEmailSent(emailSent: EmailSentEvent) = UnwrapWebhookEvent(emailSent = emailSent)

        /** Event triggered when an email is delivered successfully. */
        @JvmStatic
        fun ofEmailDelivered(emailDelivered: EmailDeliveredEvent) =
            UnwrapWebhookEvent(emailDelivered = emailDelivered)

        /** Event triggered when an email is opened by the recipient. */
        @JvmStatic
        fun ofEmailOpened(emailOpened: EmailOpenedEvent) =
            UnwrapWebhookEvent(emailOpened = emailOpened)

        /** Event triggered when a link within an email is clicked by the recipient. */
        @JvmStatic
        fun ofEmailClicked(emailClicked: EmailClickedEvent) =
            UnwrapWebhookEvent(emailClicked = emailClicked)

        /** Event triggered when an email bounces. */
        @JvmStatic
        fun ofEmailBounced(emailBounced: EmailBouncedEvent) =
            UnwrapWebhookEvent(emailBounced = emailBounced)

        /** Event triggered when an email is marked as complained by the recipient. */
        @JvmStatic
        fun ofEmailComplained(emailComplained: EmailComplainedEvent) =
            UnwrapWebhookEvent(emailComplained = emailComplained)

        /** Event triggered when an email is rejected. */
        @JvmStatic
        fun ofEmailRejected(emailRejected: EmailRejectedEvent) =
            UnwrapWebhookEvent(emailRejected = emailRejected)

        /** Event triggered when an email delivery is delayed. */
        @JvmStatic
        fun ofEmailDeliveryDelayed(emailDeliveryDelayed: EmailDeliveryDelayedEvent) =
            UnwrapWebhookEvent(emailDeliveryDelayed = emailDeliveryDelayed)

        /** Event triggered when an email fails to be sent. */
        @JvmStatic
        fun ofEmailFailed(emailFailed: EmailFailedEvent) =
            UnwrapWebhookEvent(emailFailed = emailFailed)
    }

    /**
     * An interface that defines how to map each variant of [UnwrapWebhookEvent] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** Event triggered when an email is queued for sending. */
        fun visitEmailQueued(emailQueued: EmailQueuedEvent): T

        /** Event triggered when an email is scheduled for sending. */
        fun visitEmailScheduled(emailScheduled: EmailScheduledEvent): T

        /** Event triggered when an email is processed. */
        fun visitEmailProcessed(emailProcessed: EmailProcessedEvent): T

        /** Event triggered when an email is being sent. */
        fun visitEmailSending(emailSending: EmailSendingEvent): T

        /** Event triggered when an email is sent successfully. */
        fun visitEmailSent(emailSent: EmailSentEvent): T

        /** Event triggered when an email is delivered successfully. */
        fun visitEmailDelivered(emailDelivered: EmailDeliveredEvent): T

        /** Event triggered when an email is opened by the recipient. */
        fun visitEmailOpened(emailOpened: EmailOpenedEvent): T

        /** Event triggered when a link within an email is clicked by the recipient. */
        fun visitEmailClicked(emailClicked: EmailClickedEvent): T

        /** Event triggered when an email bounces. */
        fun visitEmailBounced(emailBounced: EmailBouncedEvent): T

        /** Event triggered when an email is marked as complained by the recipient. */
        fun visitEmailComplained(emailComplained: EmailComplainedEvent): T

        /** Event triggered when an email is rejected. */
        fun visitEmailRejected(emailRejected: EmailRejectedEvent): T

        /** Event triggered when an email delivery is delayed. */
        fun visitEmailDeliveryDelayed(emailDeliveryDelayed: EmailDeliveryDelayedEvent): T

        /** Event triggered when an email fails to be sent. */
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
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "email.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailQueuedEvent>())?.let {
                        UnwrapWebhookEvent(emailQueued = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.scheduled" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailScheduledEvent>())?.let {
                        UnwrapWebhookEvent(emailScheduled = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.processed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailProcessedEvent>())?.let {
                        UnwrapWebhookEvent(emailProcessed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.sending" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailSendingEvent>())?.let {
                        UnwrapWebhookEvent(emailSending = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.sent" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailSentEvent>())?.let {
                        UnwrapWebhookEvent(emailSent = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.delivered" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailDeliveredEvent>())?.let {
                        UnwrapWebhookEvent(emailDelivered = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.opened" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailOpenedEvent>())?.let {
                        UnwrapWebhookEvent(emailOpened = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.clicked" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailClickedEvent>())?.let {
                        UnwrapWebhookEvent(emailClicked = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.bounced" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailBouncedEvent>())?.let {
                        UnwrapWebhookEvent(emailBounced = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.complained" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailComplainedEvent>())?.let {
                        UnwrapWebhookEvent(emailComplained = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.rejected" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailRejectedEvent>())?.let {
                        UnwrapWebhookEvent(emailRejected = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.deliveryDelayed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailDeliveryDelayedEvent>())?.let {
                        UnwrapWebhookEvent(emailDeliveryDelayed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
                "email.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailFailedEvent>())?.let {
                        UnwrapWebhookEvent(emailFailed = it, _json = json)
                    } ?: UnwrapWebhookEvent(_json = json)
                }
            }

            return UnwrapWebhookEvent(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<UnwrapWebhookEvent>(UnwrapWebhookEvent::class) {

        override fun serialize(
            value: UnwrapWebhookEvent,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.emailQueued != null -> generator.writeObject(value.emailQueued)
                value.emailScheduled != null -> generator.writeObject(value.emailScheduled)
                value.emailProcessed != null -> generator.writeObject(value.emailProcessed)
                value.emailSending != null -> generator.writeObject(value.emailSending)
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
