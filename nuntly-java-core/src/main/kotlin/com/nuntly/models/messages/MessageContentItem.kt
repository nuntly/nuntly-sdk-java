// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.messages

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

class MessageContentItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val downloadUrl: JsonField<String>,
    private val expiresAt: JsonField<String>,
    private val size: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("downloadUrl")
        @ExcludeMissing
        downloadUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expiresAt") @ExcludeMissing expiresAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing size: JsonField<Double> = JsonMissing.of(),
    ) : this(downloadUrl, expiresAt, size, mutableMapOf())

    /**
     * Presigned download URL.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun downloadUrl(): String = downloadUrl.getRequired("downloadUrl")

    /**
     * When the URL expires.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expiresAt(): String = expiresAt.getRequired("expiresAt")

    /**
     * Uncompressed size in bytes.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun size(): Optional<Double> = size.getOptional("size")

    /**
     * Returns the raw JSON value of [downloadUrl].
     *
     * Unlike [downloadUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("downloadUrl") @ExcludeMissing fun _downloadUrl(): JsonField<String> = downloadUrl

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expiresAt") @ExcludeMissing fun _expiresAt(): JsonField<String> = expiresAt

    /**
     * Returns the raw JSON value of [size].
     *
     * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Double> = size

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
         * Returns a mutable builder for constructing an instance of [MessageContentItem].
         *
         * The following fields are required:
         * ```java
         * .downloadUrl()
         * .expiresAt()
         * .size()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageContentItem]. */
    class Builder internal constructor() {

        private var downloadUrl: JsonField<String>? = null
        private var expiresAt: JsonField<String>? = null
        private var size: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageContentItem: MessageContentItem) = apply {
            downloadUrl = messageContentItem.downloadUrl
            expiresAt = messageContentItem.expiresAt
            size = messageContentItem.size
            additionalProperties = messageContentItem.additionalProperties.toMutableMap()
        }

        /** Presigned download URL. */
        fun downloadUrl(downloadUrl: String) = downloadUrl(JsonField.of(downloadUrl))

        /**
         * Sets [Builder.downloadUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.downloadUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun downloadUrl(downloadUrl: JsonField<String>) = apply { this.downloadUrl = downloadUrl }

        /** When the URL expires. */
        fun expiresAt(expiresAt: String) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun expiresAt(expiresAt: JsonField<String>) = apply { this.expiresAt = expiresAt }

        /** Uncompressed size in bytes. */
        fun size(size: Double?) = size(JsonField.ofNullable(size))

        /**
         * Alias for [Builder.size].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun size(size: Double) = size(size as Double?)

        /** Alias for calling [Builder.size] with `size.orElse(null)`. */
        fun size(size: Optional<Double>) = size(size.getOrNull())

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<Double>) = apply { this.size = size }

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
         * Returns an immutable instance of [MessageContentItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .downloadUrl()
         * .expiresAt()
         * .size()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageContentItem =
            MessageContentItem(
                checkRequired("downloadUrl", downloadUrl),
                checkRequired("expiresAt", expiresAt),
                checkRequired("size", size),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageContentItem = apply {
        if (validated) {
            return@apply
        }

        downloadUrl()
        expiresAt()
        size()
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
        (if (downloadUrl.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (if (size.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageContentItem &&
            downloadUrl == other.downloadUrl &&
            expiresAt == other.expiresAt &&
            size == other.size &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(downloadUrl, expiresAt, size, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageContentItem{downloadUrl=$downloadUrl, expiresAt=$expiresAt, size=$size, additionalProperties=$additionalProperties}"
}
