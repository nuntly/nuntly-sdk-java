// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.BaseDeserializer
import com.nuntly.core.BaseSerializer
import com.nuntly.core.Enum
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkRequired
import com.nuntly.core.getOrThrow
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Payload for webhook events representing email and inbound events, eg. sent, bounced, opened,
 * clicked, complained, received, etc.
 */
@JsonDeserialize(using = Event.Deserializer::class)
@JsonSerialize(using = Event.Serializer::class)
class Event
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
    private val messageReceived: MessageReceivedEvent? = null,
    private val messageSecurityFlagged: MessageSecurityFlaggedEvent? = null,
    private val messageAgentTriggered: MessageAgentTriggeredEvent? = null,
    private val messageSent: MessageSentEvent? = null,
    private val messageRejected: MessageRejected? = null,
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

    /** Event triggered when an email is received on a receiving-enabled domain. */
    fun messageReceived(): Optional<MessageReceivedEvent> = Optional.ofNullable(messageReceived)

    /** Event triggered when a received email has a security issue (SPF, DKIM, spam, or virus). */
    fun messageSecurityFlagged(): Optional<MessageSecurityFlaggedEvent> =
        Optional.ofNullable(messageSecurityFlagged)

    /** Event triggered when a message is received on an inbox with an AI agent. */
    fun messageAgentTriggered(): Optional<MessageAgentTriggeredEvent> =
        Optional.ofNullable(messageAgentTriggered)

    /** Event triggered when a message is sent from an inbox. */
    fun messageSent(): Optional<MessageSentEvent> = Optional.ofNullable(messageSent)

    /**
     * Event triggered when a received email is rejected before being stored (e.g., inbox storage
     * limit exceeded).
     */
    fun messageRejected(): Optional<MessageRejected> = Optional.ofNullable(messageRejected)

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

    fun isMessageReceived(): Boolean = messageReceived != null

    fun isMessageSecurityFlagged(): Boolean = messageSecurityFlagged != null

    fun isMessageAgentTriggered(): Boolean = messageAgentTriggered != null

    fun isMessageSent(): Boolean = messageSent != null

    fun isMessageRejected(): Boolean = messageRejected != null

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

    /** Event triggered when an email is received on a receiving-enabled domain. */
    fun asMessageReceived(): MessageReceivedEvent = messageReceived.getOrThrow("messageReceived")

    /** Event triggered when a received email has a security issue (SPF, DKIM, spam, or virus). */
    fun asMessageSecurityFlagged(): MessageSecurityFlaggedEvent =
        messageSecurityFlagged.getOrThrow("messageSecurityFlagged")

    /** Event triggered when a message is received on an inbox with an AI agent. */
    fun asMessageAgentTriggered(): MessageAgentTriggeredEvent =
        messageAgentTriggered.getOrThrow("messageAgentTriggered")

    /** Event triggered when a message is sent from an inbox. */
    fun asMessageSent(): MessageSentEvent = messageSent.getOrThrow("messageSent")

    /**
     * Event triggered when a received email is rejected before being stored (e.g., inbox storage
     * limit exceeded).
     */
    fun asMessageRejected(): MessageRejected = messageRejected.getOrThrow("messageRejected")

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
            messageReceived != null -> visitor.visitMessageReceived(messageReceived)
            messageSecurityFlagged != null ->
                visitor.visitMessageSecurityFlagged(messageSecurityFlagged)
            messageAgentTriggered != null ->
                visitor.visitMessageAgentTriggered(messageAgentTriggered)
            messageSent != null -> visitor.visitMessageSent(messageSent)
            messageRejected != null -> visitor.visitMessageRejected(messageRejected)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): Event = apply {
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

                override fun visitMessageReceived(messageReceived: MessageReceivedEvent) {
                    messageReceived.validate()
                }

                override fun visitMessageSecurityFlagged(
                    messageSecurityFlagged: MessageSecurityFlaggedEvent
                ) {
                    messageSecurityFlagged.validate()
                }

                override fun visitMessageAgentTriggered(
                    messageAgentTriggered: MessageAgentTriggeredEvent
                ) {
                    messageAgentTriggered.validate()
                }

                override fun visitMessageSent(messageSent: MessageSentEvent) {
                    messageSent.validate()
                }

                override fun visitMessageRejected(messageRejected: MessageRejected) {
                    messageRejected.validate()
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

                override fun visitMessageReceived(messageReceived: MessageReceivedEvent) =
                    messageReceived.validity()

                override fun visitMessageSecurityFlagged(
                    messageSecurityFlagged: MessageSecurityFlaggedEvent
                ) = messageSecurityFlagged.validity()

                override fun visitMessageAgentTriggered(
                    messageAgentTriggered: MessageAgentTriggeredEvent
                ) = messageAgentTriggered.validity()

                override fun visitMessageSent(messageSent: MessageSentEvent) =
                    messageSent.validity()

                override fun visitMessageRejected(messageRejected: MessageRejected) =
                    messageRejected.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Event &&
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
            emailFailed == other.emailFailed &&
            messageReceived == other.messageReceived &&
            messageSecurityFlagged == other.messageSecurityFlagged &&
            messageAgentTriggered == other.messageAgentTriggered &&
            messageSent == other.messageSent &&
            messageRejected == other.messageRejected
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
            messageReceived,
            messageSecurityFlagged,
            messageAgentTriggered,
            messageSent,
            messageRejected,
        )

    override fun toString(): String =
        when {
            emailQueued != null -> "Event{emailQueued=$emailQueued}"
            emailScheduled != null -> "Event{emailScheduled=$emailScheduled}"
            emailProcessed != null -> "Event{emailProcessed=$emailProcessed}"
            emailSending != null -> "Event{emailSending=$emailSending}"
            emailSent != null -> "Event{emailSent=$emailSent}"
            emailDelivered != null -> "Event{emailDelivered=$emailDelivered}"
            emailOpened != null -> "Event{emailOpened=$emailOpened}"
            emailClicked != null -> "Event{emailClicked=$emailClicked}"
            emailBounced != null -> "Event{emailBounced=$emailBounced}"
            emailComplained != null -> "Event{emailComplained=$emailComplained}"
            emailRejected != null -> "Event{emailRejected=$emailRejected}"
            emailDeliveryDelayed != null -> "Event{emailDeliveryDelayed=$emailDeliveryDelayed}"
            emailFailed != null -> "Event{emailFailed=$emailFailed}"
            messageReceived != null -> "Event{messageReceived=$messageReceived}"
            messageSecurityFlagged != null ->
                "Event{messageSecurityFlagged=$messageSecurityFlagged}"
            messageAgentTriggered != null -> "Event{messageAgentTriggered=$messageAgentTriggered}"
            messageSent != null -> "Event{messageSent=$messageSent}"
            messageRejected != null -> "Event{messageRejected=$messageRejected}"
            _json != null -> "Event{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Event")
        }

    companion object {

        /** Event triggered when an email is queued for sending. */
        @JvmStatic
        fun ofEmailQueued(emailQueued: EmailQueuedEvent) = Event(emailQueued = emailQueued)

        /** Event triggered when an email is scheduled for sending. */
        @JvmStatic
        fun ofEmailScheduled(emailScheduled: EmailScheduledEvent) =
            Event(emailScheduled = emailScheduled)

        /** Event triggered when an email is processed. */
        @JvmStatic
        fun ofEmailProcessed(emailProcessed: EmailProcessedEvent) =
            Event(emailProcessed = emailProcessed)

        /** Event triggered when an email is being sent. */
        @JvmStatic
        fun ofEmailSending(emailSending: EmailSendingEvent) = Event(emailSending = emailSending)

        /** Event triggered when an email is sent successfully. */
        @JvmStatic fun ofEmailSent(emailSent: EmailSentEvent) = Event(emailSent = emailSent)

        /** Event triggered when an email is delivered successfully. */
        @JvmStatic
        fun ofEmailDelivered(emailDelivered: EmailDeliveredEvent) =
            Event(emailDelivered = emailDelivered)

        /** Event triggered when an email is opened by the recipient. */
        @JvmStatic
        fun ofEmailOpened(emailOpened: EmailOpenedEvent) = Event(emailOpened = emailOpened)

        /** Event triggered when a link within an email is clicked by the recipient. */
        @JvmStatic
        fun ofEmailClicked(emailClicked: EmailClickedEvent) = Event(emailClicked = emailClicked)

        /** Event triggered when an email bounces. */
        @JvmStatic
        fun ofEmailBounced(emailBounced: EmailBouncedEvent) = Event(emailBounced = emailBounced)

        /** Event triggered when an email is marked as complained by the recipient. */
        @JvmStatic
        fun ofEmailComplained(emailComplained: EmailComplainedEvent) =
            Event(emailComplained = emailComplained)

        /** Event triggered when an email is rejected. */
        @JvmStatic
        fun ofEmailRejected(emailRejected: EmailRejectedEvent) =
            Event(emailRejected = emailRejected)

        /** Event triggered when an email delivery is delayed. */
        @JvmStatic
        fun ofEmailDeliveryDelayed(emailDeliveryDelayed: EmailDeliveryDelayedEvent) =
            Event(emailDeliveryDelayed = emailDeliveryDelayed)

        /** Event triggered when an email fails to be sent. */
        @JvmStatic
        fun ofEmailFailed(emailFailed: EmailFailedEvent) = Event(emailFailed = emailFailed)

        /** Event triggered when an email is received on a receiving-enabled domain. */
        @JvmStatic
        fun ofMessageReceived(messageReceived: MessageReceivedEvent) =
            Event(messageReceived = messageReceived)

        /**
         * Event triggered when a received email has a security issue (SPF, DKIM, spam, or virus).
         */
        @JvmStatic
        fun ofMessageSecurityFlagged(messageSecurityFlagged: MessageSecurityFlaggedEvent) =
            Event(messageSecurityFlagged = messageSecurityFlagged)

        /** Event triggered when a message is received on an inbox with an AI agent. */
        @JvmStatic
        fun ofMessageAgentTriggered(messageAgentTriggered: MessageAgentTriggeredEvent) =
            Event(messageAgentTriggered = messageAgentTriggered)

        /** Event triggered when a message is sent from an inbox. */
        @JvmStatic
        fun ofMessageSent(messageSent: MessageSentEvent) = Event(messageSent = messageSent)

        /**
         * Event triggered when a received email is rejected before being stored (e.g., inbox
         * storage limit exceeded).
         */
        @JvmStatic
        fun ofMessageRejected(messageRejected: MessageRejected) =
            Event(messageRejected = messageRejected)
    }

    /** An interface that defines how to map each variant of [Event] to a value of type [T]. */
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

        /** Event triggered when an email is received on a receiving-enabled domain. */
        fun visitMessageReceived(messageReceived: MessageReceivedEvent): T

        /**
         * Event triggered when a received email has a security issue (SPF, DKIM, spam, or virus).
         */
        fun visitMessageSecurityFlagged(messageSecurityFlagged: MessageSecurityFlaggedEvent): T

        /** Event triggered when a message is received on an inbox with an AI agent. */
        fun visitMessageAgentTriggered(messageAgentTriggered: MessageAgentTriggeredEvent): T

        /** Event triggered when a message is sent from an inbox. */
        fun visitMessageSent(messageSent: MessageSentEvent): T

        /**
         * Event triggered when a received email is rejected before being stored (e.g., inbox
         * storage limit exceeded).
         */
        fun visitMessageRejected(messageRejected: MessageRejected): T

        /**
         * Maps an unknown variant of [Event] to a value of type [T].
         *
         * An instance of [Event] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws NuntlyInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw NuntlyInvalidDataException("Unknown Event: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Event>(Event::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Event {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "email.queued" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailQueuedEvent>())?.let {
                        Event(emailQueued = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.scheduled" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailScheduledEvent>())?.let {
                        Event(emailScheduled = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.processed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailProcessedEvent>())?.let {
                        Event(emailProcessed = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.sending" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailSendingEvent>())?.let {
                        Event(emailSending = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.sent" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailSentEvent>())?.let {
                        Event(emailSent = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.delivered" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailDeliveredEvent>())?.let {
                        Event(emailDelivered = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.opened" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailOpenedEvent>())?.let {
                        Event(emailOpened = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.clicked" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailClickedEvent>())?.let {
                        Event(emailClicked = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.bounced" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailBouncedEvent>())?.let {
                        Event(emailBounced = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.complained" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailComplainedEvent>())?.let {
                        Event(emailComplained = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.rejected" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailRejectedEvent>())?.let {
                        Event(emailRejected = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.deliveryDelayed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailDeliveryDelayedEvent>())?.let {
                        Event(emailDeliveryDelayed = it, _json = json)
                    } ?: Event(_json = json)
                }
                "email.failed" -> {
                    return tryDeserialize(node, jacksonTypeRef<EmailFailedEvent>())?.let {
                        Event(emailFailed = it, _json = json)
                    } ?: Event(_json = json)
                }
                "message.received" -> {
                    return tryDeserialize(node, jacksonTypeRef<MessageReceivedEvent>())?.let {
                        Event(messageReceived = it, _json = json)
                    } ?: Event(_json = json)
                }
                "message.security.flagged" -> {
                    return tryDeserialize(node, jacksonTypeRef<MessageSecurityFlaggedEvent>())
                        ?.let { Event(messageSecurityFlagged = it, _json = json) }
                        ?: Event(_json = json)
                }
                "message.agent.triggered" -> {
                    return tryDeserialize(node, jacksonTypeRef<MessageAgentTriggeredEvent>())?.let {
                        Event(messageAgentTriggered = it, _json = json)
                    } ?: Event(_json = json)
                }
                "message.sent" -> {
                    return tryDeserialize(node, jacksonTypeRef<MessageSentEvent>())?.let {
                        Event(messageSent = it, _json = json)
                    } ?: Event(_json = json)
                }
                "message.rejected" -> {
                    return tryDeserialize(node, jacksonTypeRef<MessageRejected>())?.let {
                        Event(messageRejected = it, _json = json)
                    } ?: Event(_json = json)
                }
            }

            return Event(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<Event>(Event::class) {

        override fun serialize(
            value: Event,
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
                value.messageReceived != null -> generator.writeObject(value.messageReceived)
                value.messageSecurityFlagged != null ->
                    generator.writeObject(value.messageSecurityFlagged)
                value.messageAgentTriggered != null ->
                    generator.writeObject(value.messageAgentTriggered)
                value.messageSent != null -> generator.writeObject(value.messageSent)
                value.messageRejected != null -> generator.writeObject(value.messageRejected)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Event")
            }
        }
    }

    /**
     * Event triggered when a received email is rejected before being stored (e.g., inbox storage
     * limit exceeded).
     */
    class MessageRejected
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val data: JsonField<Data>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(id, createdAt, data, type, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): String = createdAt.getRequired("createdAt")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun data(): Data = data.getRequired("data")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("message.rejected")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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
             * Returns a mutable builder for constructing an instance of [MessageRejected].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .createdAt()
             * .data()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MessageRejected]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var createdAt: JsonField<String>? = null
            private var data: JsonField<Data>? = null
            private var type: JsonValue = JsonValue.from("message.rejected")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(messageRejected: MessageRejected) = apply {
                id = messageRejected.id
                createdAt = messageRejected.createdAt
                data = messageRejected.data
                type = messageRejected.type
                additionalProperties = messageRejected.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun data(data: Data) = data(JsonField.of(data))

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("message.rejected")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [MessageRejected].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .createdAt()
             * .data()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): MessageRejected =
                MessageRejected(
                    checkRequired("id", id),
                    checkRequired("createdAt", createdAt),
                    checkRequired("data", data),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): MessageRejected = apply {
            if (validated) {
                return@apply
            }

            id()
            createdAt()
            data().validate()
            _type().let {
                if (it != JsonValue.from("message.rejected")) {
                    throw NuntlyInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("message.rejected")) 1 else 0 }

        class Data
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val domainId: JsonField<String>,
            private val domainName: JsonField<String>,
            private val from: JsonField<String>,
            private val inboxId: JsonField<String>,
            private val orgId: JsonField<String>,
            private val reason: JsonField<Reason>,
            private val subject: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("domainId")
                @ExcludeMissing
                domainId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("domainName")
                @ExcludeMissing
                domainName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
                @JsonProperty("inboxId")
                @ExcludeMissing
                inboxId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("orgId") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<Reason> = JsonMissing.of(),
                @JsonProperty("subject")
                @ExcludeMissing
                subject: JsonField<String> = JsonMissing.of(),
            ) : this(domainId, domainName, from, inboxId, orgId, reason, subject, mutableMapOf())

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun domainId(): String = domainId.getRequired("domainId")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun domainName(): String = domainName.getRequired("domainName")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun from(): String = from.getRequired("from")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun inboxId(): String = inboxId.getRequired("inboxId")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun orgId(): String = orgId.getRequired("orgId")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun reason(): Reason = reason.getRequired("reason")

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun subject(): String = subject.getRequired("subject")

            /**
             * Returns the raw JSON value of [domainId].
             *
             * Unlike [domainId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("domainId") @ExcludeMissing fun _domainId(): JsonField<String> = domainId

            /**
             * Returns the raw JSON value of [domainName].
             *
             * Unlike [domainName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("domainName")
            @ExcludeMissing
            fun _domainName(): JsonField<String> = domainName

            /**
             * Returns the raw JSON value of [from].
             *
             * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

            /**
             * Returns the raw JSON value of [inboxId].
             *
             * Unlike [inboxId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("inboxId") @ExcludeMissing fun _inboxId(): JsonField<String> = inboxId

            /**
             * Returns the raw JSON value of [orgId].
             *
             * Unlike [orgId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("orgId") @ExcludeMissing fun _orgId(): JsonField<String> = orgId

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<Reason> = reason

            /**
             * Returns the raw JSON value of [subject].
             *
             * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

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
                 * Returns a mutable builder for constructing an instance of [Data].
                 *
                 * The following fields are required:
                 * ```java
                 * .domainId()
                 * .domainName()
                 * .from()
                 * .inboxId()
                 * .orgId()
                 * .reason()
                 * .subject()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Data]. */
            class Builder internal constructor() {

                private var domainId: JsonField<String>? = null
                private var domainName: JsonField<String>? = null
                private var from: JsonField<String>? = null
                private var inboxId: JsonField<String>? = null
                private var orgId: JsonField<String>? = null
                private var reason: JsonField<Reason>? = null
                private var subject: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(data: Data) = apply {
                    domainId = data.domainId
                    domainName = data.domainName
                    from = data.from
                    inboxId = data.inboxId
                    orgId = data.orgId
                    reason = data.reason
                    subject = data.subject
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

                fun domainId(domainId: String) = domainId(JsonField.of(domainId))

                /**
                 * Sets [Builder.domainId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.domainId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun domainId(domainId: JsonField<String>) = apply { this.domainId = domainId }

                fun domainName(domainName: String) = domainName(JsonField.of(domainName))

                /**
                 * Sets [Builder.domainName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.domainName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun domainName(domainName: JsonField<String>) = apply {
                    this.domainName = domainName
                }

                fun from(from: String) = from(JsonField.of(from))

                /**
                 * Sets [Builder.from] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.from] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun from(from: JsonField<String>) = apply { this.from = from }

                fun inboxId(inboxId: String) = inboxId(JsonField.of(inboxId))

                /**
                 * Sets [Builder.inboxId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.inboxId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun inboxId(inboxId: JsonField<String>) = apply { this.inboxId = inboxId }

                fun orgId(orgId: String) = orgId(JsonField.of(orgId))

                /**
                 * Sets [Builder.orgId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.orgId] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

                fun reason(reason: Reason) = reason(JsonField.of(reason))

                /**
                 * Sets [Builder.reason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reason] with a well-typed [Reason] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reason(reason: JsonField<Reason>) = apply { this.reason = reason }

                fun subject(subject: String) = subject(JsonField.of(subject))

                /**
                 * Sets [Builder.subject] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.subject] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun subject(subject: JsonField<String>) = apply { this.subject = subject }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Data].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .domainId()
                 * .domainName()
                 * .from()
                 * .inboxId()
                 * .orgId()
                 * .reason()
                 * .subject()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Data =
                    Data(
                        checkRequired("domainId", domainId),
                        checkRequired("domainName", domainName),
                        checkRequired("from", from),
                        checkRequired("inboxId", inboxId),
                        checkRequired("orgId", orgId),
                        checkRequired("reason", reason),
                        checkRequired("subject", subject),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Data = apply {
                if (validated) {
                    return@apply
                }

                domainId()
                domainName()
                from()
                inboxId()
                orgId()
                reason().validate()
                subject()
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
                (if (domainId.asKnown().isPresent) 1 else 0) +
                    (if (domainName.asKnown().isPresent) 1 else 0) +
                    (if (from.asKnown().isPresent) 1 else 0) +
                    (if (inboxId.asKnown().isPresent) 1 else 0) +
                    (if (orgId.asKnown().isPresent) 1 else 0) +
                    (reason.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (subject.asKnown().isPresent) 1 else 0)

            class Reason @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val INBOX_STORAGE_LIMIT_EXCEEDED = of("inbox_storage_limit_exceeded")

                    @JvmField val MESSAGE_TOO_LARGE = of("message_too_large")

                    @JvmStatic fun of(value: String) = Reason(JsonField.of(value))
                }

                /** An enum containing [Reason]'s known values. */
                enum class Known {
                    INBOX_STORAGE_LIMIT_EXCEEDED,
                    MESSAGE_TOO_LARGE,
                }

                /**
                 * An enum containing [Reason]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Reason] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    INBOX_STORAGE_LIMIT_EXCEEDED,
                    MESSAGE_TOO_LARGE,
                    /**
                     * An enum member indicating that [Reason] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        INBOX_STORAGE_LIMIT_EXCEEDED -> Value.INBOX_STORAGE_LIMIT_EXCEEDED
                        MESSAGE_TOO_LARGE -> Value.MESSAGE_TOO_LARGE
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws NuntlyInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        INBOX_STORAGE_LIMIT_EXCEEDED -> Known.INBOX_STORAGE_LIMIT_EXCEEDED
                        MESSAGE_TOO_LARGE -> Known.MESSAGE_TOO_LARGE
                        else -> throw NuntlyInvalidDataException("Unknown Reason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws NuntlyInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        NuntlyInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): Reason = apply {
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

                    return other is Reason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Data &&
                    domainId == other.domainId &&
                    domainName == other.domainName &&
                    from == other.from &&
                    inboxId == other.inboxId &&
                    orgId == other.orgId &&
                    reason == other.reason &&
                    subject == other.subject &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    domainId,
                    domainName,
                    from,
                    inboxId,
                    orgId,
                    reason,
                    subject,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Data{domainId=$domainId, domainName=$domainName, from=$from, inboxId=$inboxId, orgId=$orgId, reason=$reason, subject=$subject, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MessageRejected &&
                id == other.id &&
                createdAt == other.createdAt &&
                data == other.data &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, createdAt, data, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MessageRejected{id=$id, createdAt=$createdAt, data=$data, type=$type, additionalProperties=$additionalProperties}"
    }
}
