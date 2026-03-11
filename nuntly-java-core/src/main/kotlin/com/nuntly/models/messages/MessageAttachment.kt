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

class MessageAttachment
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val contentDisposition: JsonField<String>,
    private val contentId: JsonField<String>,
    private val contentType: JsonField<String>,
    private val filename: JsonField<String>,
    private val size: JsonField<Double>,
    private val downloadUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contentDisposition")
        @ExcludeMissing
        contentDisposition: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contentId") @ExcludeMissing contentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contentType")
        @ExcludeMissing
        contentType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("filename") @ExcludeMissing filename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("size") @ExcludeMissing size: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("downloadUrl")
        @ExcludeMissing
        downloadUrl: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        contentDisposition,
        contentId,
        contentType,
        filename,
        size,
        downloadUrl,
        mutableMapOf(),
    )

    /**
     * The id of the attachment
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The content disposition (inline or attachment).
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contentDisposition(): Optional<String> =
        contentDisposition.getOptional("contentDisposition")

    /**
     * The CID for inline images.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contentId(): Optional<String> = contentId.getOptional("contentId")

    /**
     * The MIME content type.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contentType(): String = contentType.getRequired("contentType")

    /**
     * The original filename.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filename(): Optional<String> = filename.getOptional("filename")

    /**
     * The size in bytes.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun size(): Double = size.getRequired("size")

    /**
     * Presigned download URL (included when retrieving a single attachment).
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun downloadUrl(): Optional<String> = downloadUrl.getOptional("downloadUrl")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [contentDisposition].
     *
     * Unlike [contentDisposition], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("contentDisposition")
    @ExcludeMissing
    fun _contentDisposition(): JsonField<String> = contentDisposition

    /**
     * Returns the raw JSON value of [contentId].
     *
     * Unlike [contentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contentId") @ExcludeMissing fun _contentId(): JsonField<String> = contentId

    /**
     * Returns the raw JSON value of [contentType].
     *
     * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contentType") @ExcludeMissing fun _contentType(): JsonField<String> = contentType

    /**
     * Returns the raw JSON value of [filename].
     *
     * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

    /**
     * Returns the raw JSON value of [size].
     *
     * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Double> = size

    /**
     * Returns the raw JSON value of [downloadUrl].
     *
     * Unlike [downloadUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("downloadUrl") @ExcludeMissing fun _downloadUrl(): JsonField<String> = downloadUrl

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
         * Returns a mutable builder for constructing an instance of [MessageAttachment].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .contentDisposition()
         * .contentId()
         * .contentType()
         * .filename()
         * .size()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageAttachment]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var contentDisposition: JsonField<String>? = null
        private var contentId: JsonField<String>? = null
        private var contentType: JsonField<String>? = null
        private var filename: JsonField<String>? = null
        private var size: JsonField<Double>? = null
        private var downloadUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageAttachment: MessageAttachment) = apply {
            id = messageAttachment.id
            contentDisposition = messageAttachment.contentDisposition
            contentId = messageAttachment.contentId
            contentType = messageAttachment.contentType
            filename = messageAttachment.filename
            size = messageAttachment.size
            downloadUrl = messageAttachment.downloadUrl
            additionalProperties = messageAttachment.additionalProperties.toMutableMap()
        }

        /** The id of the attachment */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The content disposition (inline or attachment). */
        fun contentDisposition(contentDisposition: String?) =
            contentDisposition(JsonField.ofNullable(contentDisposition))

        /**
         * Alias for calling [Builder.contentDisposition] with `contentDisposition.orElse(null)`.
         */
        fun contentDisposition(contentDisposition: Optional<String>) =
            contentDisposition(contentDisposition.getOrNull())

        /**
         * Sets [Builder.contentDisposition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentDisposition] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contentDisposition(contentDisposition: JsonField<String>) = apply {
            this.contentDisposition = contentDisposition
        }

        /** The CID for inline images. */
        fun contentId(contentId: String?) = contentId(JsonField.ofNullable(contentId))

        /** Alias for calling [Builder.contentId] with `contentId.orElse(null)`. */
        fun contentId(contentId: Optional<String>) = contentId(contentId.getOrNull())

        /**
         * Sets [Builder.contentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentId(contentId: JsonField<String>) = apply { this.contentId = contentId }

        /** The MIME content type. */
        fun contentType(contentType: String) = contentType(JsonField.of(contentType))

        /**
         * Sets [Builder.contentType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentType(contentType: JsonField<String>) = apply { this.contentType = contentType }

        /** The original filename. */
        fun filename(filename: String?) = filename(JsonField.ofNullable(filename))

        /** Alias for calling [Builder.filename] with `filename.orElse(null)`. */
        fun filename(filename: Optional<String>) = filename(filename.getOrNull())

        /**
         * Sets [Builder.filename] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filename] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /** The size in bytes. */
        fun size(size: Double) = size(JsonField.of(size))

        /**
         * Sets [Builder.size] to an arbitrary JSON value.
         *
         * You should usually call [Builder.size] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun size(size: JsonField<Double>) = apply { this.size = size }

        /** Presigned download URL (included when retrieving a single attachment). */
        fun downloadUrl(downloadUrl: String) = downloadUrl(JsonField.of(downloadUrl))

        /**
         * Sets [Builder.downloadUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.downloadUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun downloadUrl(downloadUrl: JsonField<String>) = apply { this.downloadUrl = downloadUrl }

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
         * Returns an immutable instance of [MessageAttachment].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .contentDisposition()
         * .contentId()
         * .contentType()
         * .filename()
         * .size()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageAttachment =
            MessageAttachment(
                checkRequired("id", id),
                checkRequired("contentDisposition", contentDisposition),
                checkRequired("contentId", contentId),
                checkRequired("contentType", contentType),
                checkRequired("filename", filename),
                checkRequired("size", size),
                downloadUrl,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageAttachment = apply {
        if (validated) {
            return@apply
        }

        id()
        contentDisposition()
        contentId()
        contentType()
        filename()
        size()
        downloadUrl()
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
            (if (contentDisposition.asKnown().isPresent) 1 else 0) +
            (if (contentId.asKnown().isPresent) 1 else 0) +
            (if (contentType.asKnown().isPresent) 1 else 0) +
            (if (filename.asKnown().isPresent) 1 else 0) +
            (if (size.asKnown().isPresent) 1 else 0) +
            (if (downloadUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageAttachment &&
            id == other.id &&
            contentDisposition == other.contentDisposition &&
            contentId == other.contentId &&
            contentType == other.contentType &&
            filename == other.filename &&
            size == other.size &&
            downloadUrl == other.downloadUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            contentDisposition,
            contentId,
            contentType,
            filename,
            size,
            downloadUrl,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageAttachment{id=$id, contentDisposition=$contentDisposition, contentId=$contentId, contentType=$contentType, filename=$filename, size=$size, downloadUrl=$downloadUrl, additionalProperties=$additionalProperties}"
}
