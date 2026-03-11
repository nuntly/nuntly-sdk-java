// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.threads

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Thread
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val agentId: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val domainId: JsonField<String>,
    private val domainName: JsonField<String>,
    private val inboxId: JsonField<String>,
    private val isRead: JsonField<Boolean>,
    private val isSpam: JsonField<Boolean>,
    private val lastMessageAt: JsonField<String>,
    private val messageCount: JsonField<Double>,
    private val subject: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agentId") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("domainId") @ExcludeMissing domainId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("domainName")
        @ExcludeMissing
        domainName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inboxId") @ExcludeMissing inboxId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("isRead") @ExcludeMissing isRead: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isSpam") @ExcludeMissing isSpam: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("lastMessageAt")
        @ExcludeMissing
        lastMessageAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("messageCount")
        @ExcludeMissing
        messageCount: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        agentId,
        createdAt,
        domainId,
        domainName,
        inboxId,
        isRead,
        isSpam,
        lastMessageAt,
        messageCount,
        subject,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The id of the thread
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The AI agent identifier.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun agentId(): Optional<String> = agentId.getOptional("agentId")

    /**
     * Date at which the object was created (ISO 8601 format)
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): String = createdAt.getRequired("createdAt")

    /**
     * The id of the domain.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun domainId(): Optional<String> = domainId.getOptional("domainId")

    /**
     * The domain name.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun domainName(): String = domainName.getRequired("domainName")

    /**
     * The id of the inbox.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inboxId(): String = inboxId.getRequired("inboxId")

    /**
     * Whether the thread has been read.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isRead(): Boolean = isRead.getRequired("isRead")

    /**
     * Whether the thread is marked as spam.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isSpam(): Boolean = isSpam.getRequired("isSpam")

    /**
     * The timestamp of the most recent message.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lastMessageAt(): String = lastMessageAt.getRequired("lastMessageAt")

    /**
     * The number of messages in the thread.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun messageCount(): Double = messageCount.getRequired("messageCount")

    /**
     * The original subject line.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun subject(): String = subject.getRequired("subject")

    /**
     * Date at which the object was updated (ISO 8601 format)
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<String> = updatedAt.getOptional("updatedAt")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agentId") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [domainId].
     *
     * Unlike [domainId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("domainId") @ExcludeMissing fun _domainId(): JsonField<String> = domainId

    /**
     * Returns the raw JSON value of [domainName].
     *
     * Unlike [domainName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("domainName") @ExcludeMissing fun _domainName(): JsonField<String> = domainName

    /**
     * Returns the raw JSON value of [inboxId].
     *
     * Unlike [inboxId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inboxId") @ExcludeMissing fun _inboxId(): JsonField<String> = inboxId

    /**
     * Returns the raw JSON value of [isRead].
     *
     * Unlike [isRead], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isRead") @ExcludeMissing fun _isRead(): JsonField<Boolean> = isRead

    /**
     * Returns the raw JSON value of [isSpam].
     *
     * Unlike [isSpam], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isSpam") @ExcludeMissing fun _isSpam(): JsonField<Boolean> = isSpam

    /**
     * Returns the raw JSON value of [lastMessageAt].
     *
     * Unlike [lastMessageAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lastMessageAt")
    @ExcludeMissing
    fun _lastMessageAt(): JsonField<String> = lastMessageAt

    /**
     * Returns the raw JSON value of [messageCount].
     *
     * Unlike [messageCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("messageCount")
    @ExcludeMissing
    fun _messageCount(): JsonField<Double> = messageCount

    /**
     * Returns the raw JSON value of [subject].
     *
     * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

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
         * Returns a mutable builder for constructing an instance of [Thread].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .agentId()
         * .createdAt()
         * .domainId()
         * .domainName()
         * .inboxId()
         * .isRead()
         * .isSpam()
         * .lastMessageAt()
         * .messageCount()
         * .subject()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Thread]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var agentId: JsonField<String>? = null
        private var createdAt: JsonField<String>? = null
        private var domainId: JsonField<String>? = null
        private var domainName: JsonField<String>? = null
        private var inboxId: JsonField<String>? = null
        private var isRead: JsonField<Boolean>? = null
        private var isSpam: JsonField<Boolean>? = null
        private var lastMessageAt: JsonField<String>? = null
        private var messageCount: JsonField<Double>? = null
        private var subject: JsonField<String>? = null
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(thread: Thread) = apply {
            id = thread.id
            agentId = thread.agentId
            createdAt = thread.createdAt
            domainId = thread.domainId
            domainName = thread.domainName
            inboxId = thread.inboxId
            isRead = thread.isRead
            isSpam = thread.isSpam
            lastMessageAt = thread.lastMessageAt
            messageCount = thread.messageCount
            subject = thread.subject
            updatedAt = thread.updatedAt
            additionalProperties = thread.additionalProperties.toMutableMap()
        }

        /** The id of the thread */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The AI agent identifier. */
        fun agentId(agentId: String?) = agentId(JsonField.ofNullable(agentId))

        /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
        fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

        /** Date at which the object was created (ISO 8601 format) */
        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        /** The id of the domain. */
        fun domainId(domainId: String?) = domainId(JsonField.ofNullable(domainId))

        /** Alias for calling [Builder.domainId] with `domainId.orElse(null)`. */
        fun domainId(domainId: Optional<String>) = domainId(domainId.getOrNull())

        /**
         * Sets [Builder.domainId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.domainId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun domainId(domainId: JsonField<String>) = apply { this.domainId = domainId }

        /** The domain name. */
        fun domainName(domainName: String) = domainName(JsonField.of(domainName))

        /**
         * Sets [Builder.domainName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.domainName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun domainName(domainName: JsonField<String>) = apply { this.domainName = domainName }

        /** The id of the inbox. */
        fun inboxId(inboxId: String) = inboxId(JsonField.of(inboxId))

        /**
         * Sets [Builder.inboxId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inboxId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun inboxId(inboxId: JsonField<String>) = apply { this.inboxId = inboxId }

        /** Whether the thread has been read. */
        fun isRead(isRead: Boolean) = isRead(JsonField.of(isRead))

        /**
         * Sets [Builder.isRead] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isRead] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isRead(isRead: JsonField<Boolean>) = apply { this.isRead = isRead }

        /** Whether the thread is marked as spam. */
        fun isSpam(isSpam: Boolean) = isSpam(JsonField.of(isSpam))

        /**
         * Sets [Builder.isSpam] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isSpam] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isSpam(isSpam: JsonField<Boolean>) = apply { this.isSpam = isSpam }

        /** The timestamp of the most recent message. */
        fun lastMessageAt(lastMessageAt: String) = lastMessageAt(JsonField.of(lastMessageAt))

        /**
         * Sets [Builder.lastMessageAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastMessageAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lastMessageAt(lastMessageAt: JsonField<String>) = apply {
            this.lastMessageAt = lastMessageAt
        }

        /** The number of messages in the thread. */
        fun messageCount(messageCount: Double) = messageCount(JsonField.of(messageCount))

        /**
         * Sets [Builder.messageCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageCount] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageCount(messageCount: JsonField<Double>) = apply {
            this.messageCount = messageCount
        }

        /** The original subject line. */
        fun subject(subject: String) = subject(JsonField.of(subject))

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

        /** Date at which the object was updated (ISO 8601 format) */
        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [Thread].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .agentId()
         * .createdAt()
         * .domainId()
         * .domainName()
         * .inboxId()
         * .isRead()
         * .isSpam()
         * .lastMessageAt()
         * .messageCount()
         * .subject()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Thread =
            Thread(
                checkRequired("id", id),
                checkRequired("agentId", agentId),
                checkRequired("createdAt", createdAt),
                checkRequired("domainId", domainId),
                checkRequired("domainName", domainName),
                checkRequired("inboxId", inboxId),
                checkRequired("isRead", isRead),
                checkRequired("isSpam", isSpam),
                checkRequired("lastMessageAt", lastMessageAt),
                checkRequired("messageCount", messageCount),
                checkRequired("subject", subject),
                updatedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Thread = apply {
        if (validated) {
            return@apply
        }

        id()
        agentId()
        createdAt()
        domainId()
        domainName()
        inboxId()
        isRead()
        isSpam()
        lastMessageAt()
        messageCount()
        subject()
        updatedAt()
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
            (if (agentId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (domainId.asKnown().isPresent) 1 else 0) +
            (if (domainName.asKnown().isPresent) 1 else 0) +
            (if (inboxId.asKnown().isPresent) 1 else 0) +
            (if (isRead.asKnown().isPresent) 1 else 0) +
            (if (isSpam.asKnown().isPresent) 1 else 0) +
            (if (lastMessageAt.asKnown().isPresent) 1 else 0) +
            (if (messageCount.asKnown().isPresent) 1 else 0) +
            (if (subject.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Thread &&
            id == other.id &&
            agentId == other.agentId &&
            createdAt == other.createdAt &&
            domainId == other.domainId &&
            domainName == other.domainName &&
            inboxId == other.inboxId &&
            isRead == other.isRead &&
            isSpam == other.isSpam &&
            lastMessageAt == other.lastMessageAt &&
            messageCount == other.messageCount &&
            subject == other.subject &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            agentId,
            createdAt,
            domainId,
            domainName,
            inboxId,
            isRead,
            isSpam,
            lastMessageAt,
            messageCount,
            subject,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Thread{id=$id, agentId=$agentId, createdAt=$createdAt, domainId=$domainId, domainName=$domainName, inboxId=$inboxId, isRead=$isRead, isSpam=$isSpam, lastMessageAt=$lastMessageAt, messageCount=$messageCount, subject=$subject, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
