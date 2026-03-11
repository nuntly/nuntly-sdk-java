// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.inboxes

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

class Inbox
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val address: JsonField<String>,
    private val agentId: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val domainId: JsonField<String>,
    private val domainName: JsonField<String>,
    private val name: JsonField<String>,
    private val namespaceId: JsonField<String>,
    private val namespaceName: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agentId") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("domainId") @ExcludeMissing domainId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("domainName")
        @ExcludeMissing
        domainName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("namespaceId")
        @ExcludeMissing
        namespaceId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("namespaceName")
        @ExcludeMissing
        namespaceName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        address,
        agentId,
        createdAt,
        domainId,
        domainName,
        name,
        namespaceId,
        namespaceName,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The id of the inbox
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The local-part of the email address.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun address(): String = address.getRequired("address")

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
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun domainId(): String = domainId.getRequired("domainId")

    /**
     * The domain name.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun domainName(): String = domainName.getRequired("domainName")

    /**
     * The display name of the inbox.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The id of the namespace.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun namespaceId(): Optional<String> = namespaceId.getOptional("namespaceId")

    /**
     * The display name of the namespace.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun namespaceName(): Optional<String> = namespaceName.getOptional("namespaceName")

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
     * Returns the raw JSON value of [address].
     *
     * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

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
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [namespaceId].
     *
     * Unlike [namespaceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("namespaceId") @ExcludeMissing fun _namespaceId(): JsonField<String> = namespaceId

    /**
     * Returns the raw JSON value of [namespaceName].
     *
     * Unlike [namespaceName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("namespaceName")
    @ExcludeMissing
    fun _namespaceName(): JsonField<String> = namespaceName

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
         * Returns a mutable builder for constructing an instance of [Inbox].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .address()
         * .agentId()
         * .createdAt()
         * .domainId()
         * .domainName()
         * .name()
         * .namespaceId()
         * .namespaceName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Inbox]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var address: JsonField<String>? = null
        private var agentId: JsonField<String>? = null
        private var createdAt: JsonField<String>? = null
        private var domainId: JsonField<String>? = null
        private var domainName: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var namespaceId: JsonField<String>? = null
        private var namespaceName: JsonField<String>? = null
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inbox: Inbox) = apply {
            id = inbox.id
            address = inbox.address
            agentId = inbox.agentId
            createdAt = inbox.createdAt
            domainId = inbox.domainId
            domainName = inbox.domainName
            name = inbox.name
            namespaceId = inbox.namespaceId
            namespaceName = inbox.namespaceName
            updatedAt = inbox.updatedAt
            additionalProperties = inbox.additionalProperties.toMutableMap()
        }

        /** The id of the inbox */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The local-part of the email address. */
        fun address(address: String) = address(JsonField.of(address))

        /**
         * Sets [Builder.address] to an arbitrary JSON value.
         *
         * You should usually call [Builder.address] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun address(address: JsonField<String>) = apply { this.address = address }

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
        fun domainId(domainId: String) = domainId(JsonField.of(domainId))

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

        /** The display name of the inbox. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The id of the namespace. */
        fun namespaceId(namespaceId: String?) = namespaceId(JsonField.ofNullable(namespaceId))

        /** Alias for calling [Builder.namespaceId] with `namespaceId.orElse(null)`. */
        fun namespaceId(namespaceId: Optional<String>) = namespaceId(namespaceId.getOrNull())

        /**
         * Sets [Builder.namespaceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.namespaceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun namespaceId(namespaceId: JsonField<String>) = apply { this.namespaceId = namespaceId }

        /** The display name of the namespace. */
        fun namespaceName(namespaceName: String?) =
            namespaceName(JsonField.ofNullable(namespaceName))

        /** Alias for calling [Builder.namespaceName] with `namespaceName.orElse(null)`. */
        fun namespaceName(namespaceName: Optional<String>) =
            namespaceName(namespaceName.getOrNull())

        /**
         * Sets [Builder.namespaceName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.namespaceName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun namespaceName(namespaceName: JsonField<String>) = apply {
            this.namespaceName = namespaceName
        }

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
         * Returns an immutable instance of [Inbox].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .address()
         * .agentId()
         * .createdAt()
         * .domainId()
         * .domainName()
         * .name()
         * .namespaceId()
         * .namespaceName()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Inbox =
            Inbox(
                checkRequired("id", id),
                checkRequired("address", address),
                checkRequired("agentId", agentId),
                checkRequired("createdAt", createdAt),
                checkRequired("domainId", domainId),
                checkRequired("domainName", domainName),
                checkRequired("name", name),
                checkRequired("namespaceId", namespaceId),
                checkRequired("namespaceName", namespaceName),
                updatedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Inbox = apply {
        if (validated) {
            return@apply
        }

        id()
        address()
        agentId()
        createdAt()
        domainId()
        domainName()
        name()
        namespaceId()
        namespaceName()
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
            (if (address.asKnown().isPresent) 1 else 0) +
            (if (agentId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (domainId.asKnown().isPresent) 1 else 0) +
            (if (domainName.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (namespaceId.asKnown().isPresent) 1 else 0) +
            (if (namespaceName.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Inbox &&
            id == other.id &&
            address == other.address &&
            agentId == other.agentId &&
            createdAt == other.createdAt &&
            domainId == other.domainId &&
            domainName == other.domainName &&
            name == other.name &&
            namespaceId == other.namespaceId &&
            namespaceName == other.namespaceName &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            address,
            agentId,
            createdAt,
            domainId,
            domainName,
            name,
            namespaceId,
            namespaceName,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Inbox{id=$id, address=$address, agentId=$agentId, createdAt=$createdAt, domainId=$domainId, domainName=$domainName, name=$name, namespaceId=$namespaceId, namespaceName=$namespaceName, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
