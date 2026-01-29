// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.bulk

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.core.checkKnown
import com.nuntly.core.checkRequired
import com.nuntly.core.toImmutable
import com.nuntly.errors.NuntlyInvalidDataException
import com.nuntly.models.emails.Status
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BulkRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val emails: JsonField<List<Email>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("emails") @ExcludeMissing emails: JsonField<List<Email>> = JsonMissing.of(),
    ) : this(id, emails, mutableMapOf())

    /**
     * The bulk id
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun emails(): List<Email> = emails.getRequired("emails")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [emails].
     *
     * Unlike [emails], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("emails") @ExcludeMissing fun _emails(): JsonField<List<Email>> = emails

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
         * Returns a mutable builder for constructing an instance of [BulkRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .emails()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var emails: JsonField<MutableList<Email>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(bulkRetrieveResponse: BulkRetrieveResponse) = apply {
            id = bulkRetrieveResponse.id
            emails = bulkRetrieveResponse.emails.map { it.toMutableList() }
            additionalProperties = bulkRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** The bulk id */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun emails(emails: List<Email>) = emails(JsonField.of(emails))

        /**
         * Sets [Builder.emails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.emails] with a well-typed `List<Email>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun emails(emails: JsonField<List<Email>>) = apply {
            this.emails = emails.map { it.toMutableList() }
        }

        /**
         * Adds a single [Email] to [emails].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEmail(email: Email) = apply {
            emails =
                (emails ?: JsonField.of(mutableListOf())).also {
                    checkKnown("emails", it).add(email)
                }
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
         * Returns an immutable instance of [BulkRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .emails()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BulkRetrieveResponse =
            BulkRetrieveResponse(
                checkRequired("id", id),
                checkRequired("emails", emails).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BulkRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        emails().forEach { it.validate() }
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
            (emails.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Email
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val status: JsonField<Status>,
        private val detail: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("detail") @ExcludeMissing detail: JsonField<String> = JsonMissing.of(),
        ) : this(id, status, detail, mutableMapOf())

        /**
         * The id of the email
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The status of the email.
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun detail(): Optional<String> = detail.getOptional("detail")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [detail].
         *
         * Unlike [detail], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<String> = detail

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
             * Returns a mutable builder for constructing an instance of [Email].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Email]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var detail: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(email: Email) = apply {
                id = email.id
                status = email.status
                detail = email.detail
                additionalProperties = email.additionalProperties.toMutableMap()
            }

            /** The id of the email */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The status of the email. */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun detail(detail: String) = detail(JsonField.of(detail))

            /**
             * Sets [Builder.detail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.detail] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun detail(detail: JsonField<String>) = apply { this.detail = detail }

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
             * Returns an immutable instance of [Email].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Email =
                Email(
                    checkRequired("id", id),
                    checkRequired("status", status),
                    detail,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Email = apply {
            if (validated) {
                return@apply
            }

            id()
            status().validate()
            detail()
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
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (detail.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Email &&
                id == other.id &&
                status == other.status &&
                detail == other.detail &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, status, detail, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Email{id=$id, status=$status, detail=$detail, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BulkRetrieveResponse &&
            id == other.id &&
            emails == other.emails &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, emails, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BulkRetrieveResponse{id=$id, emails=$emails, additionalProperties=$additionalProperties}"
}
