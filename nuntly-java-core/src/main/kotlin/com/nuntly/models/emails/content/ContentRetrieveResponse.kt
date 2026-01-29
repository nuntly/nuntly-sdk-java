// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.emails.content

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.ExcludeMissing
import com.nuntly.core.JsonField
import com.nuntly.core.JsonMissing
import com.nuntly.core.JsonValue
import com.nuntly.errors.NuntlyInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class ContentRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val htmlTemplateUrl: JsonField<String>,
    private val htmlUrl: JsonField<String>,
    private val mineUrl: JsonField<String>,
    private val subjectTemplateUrl: JsonField<String>,
    private val textTemplateUrl: JsonField<String>,
    private val textUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("htmlTemplateUrl")
        @ExcludeMissing
        htmlTemplateUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("htmlUrl") @ExcludeMissing htmlUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mineUrl") @ExcludeMissing mineUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("subjectTemplateUrl")
        @ExcludeMissing
        subjectTemplateUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("textTemplateUrl")
        @ExcludeMissing
        textTemplateUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("textUrl") @ExcludeMissing textUrl: JsonField<String> = JsonMissing.of(),
    ) : this(
        htmlTemplateUrl,
        htmlUrl,
        mineUrl,
        subjectTemplateUrl,
        textTemplateUrl,
        textUrl,
        mutableMapOf(),
    )

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun htmlTemplateUrl(): Optional<String> = htmlTemplateUrl.getOptional("htmlTemplateUrl")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun htmlUrl(): Optional<String> = htmlUrl.getOptional("htmlUrl")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mineUrl(): Optional<String> = mineUrl.getOptional("mineUrl")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun subjectTemplateUrl(): Optional<String> =
        subjectTemplateUrl.getOptional("subjectTemplateUrl")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun textTemplateUrl(): Optional<String> = textTemplateUrl.getOptional("textTemplateUrl")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun textUrl(): Optional<String> = textUrl.getOptional("textUrl")

    /**
     * Returns the raw JSON value of [htmlTemplateUrl].
     *
     * Unlike [htmlTemplateUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("htmlTemplateUrl")
    @ExcludeMissing
    fun _htmlTemplateUrl(): JsonField<String> = htmlTemplateUrl

    /**
     * Returns the raw JSON value of [htmlUrl].
     *
     * Unlike [htmlUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("htmlUrl") @ExcludeMissing fun _htmlUrl(): JsonField<String> = htmlUrl

    /**
     * Returns the raw JSON value of [mineUrl].
     *
     * Unlike [mineUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mineUrl") @ExcludeMissing fun _mineUrl(): JsonField<String> = mineUrl

    /**
     * Returns the raw JSON value of [subjectTemplateUrl].
     *
     * Unlike [subjectTemplateUrl], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("subjectTemplateUrl")
    @ExcludeMissing
    fun _subjectTemplateUrl(): JsonField<String> = subjectTemplateUrl

    /**
     * Returns the raw JSON value of [textTemplateUrl].
     *
     * Unlike [textTemplateUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("textTemplateUrl")
    @ExcludeMissing
    fun _textTemplateUrl(): JsonField<String> = textTemplateUrl

    /**
     * Returns the raw JSON value of [textUrl].
     *
     * Unlike [textUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("textUrl") @ExcludeMissing fun _textUrl(): JsonField<String> = textUrl

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

        /** Returns a mutable builder for constructing an instance of [ContentRetrieveResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContentRetrieveResponse]. */
    class Builder internal constructor() {

        private var htmlTemplateUrl: JsonField<String> = JsonMissing.of()
        private var htmlUrl: JsonField<String> = JsonMissing.of()
        private var mineUrl: JsonField<String> = JsonMissing.of()
        private var subjectTemplateUrl: JsonField<String> = JsonMissing.of()
        private var textTemplateUrl: JsonField<String> = JsonMissing.of()
        private var textUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contentRetrieveResponse: ContentRetrieveResponse) = apply {
            htmlTemplateUrl = contentRetrieveResponse.htmlTemplateUrl
            htmlUrl = contentRetrieveResponse.htmlUrl
            mineUrl = contentRetrieveResponse.mineUrl
            subjectTemplateUrl = contentRetrieveResponse.subjectTemplateUrl
            textTemplateUrl = contentRetrieveResponse.textTemplateUrl
            textUrl = contentRetrieveResponse.textUrl
            additionalProperties = contentRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun htmlTemplateUrl(htmlTemplateUrl: String) =
            htmlTemplateUrl(JsonField.of(htmlTemplateUrl))

        /**
         * Sets [Builder.htmlTemplateUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.htmlTemplateUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun htmlTemplateUrl(htmlTemplateUrl: JsonField<String>) = apply {
            this.htmlTemplateUrl = htmlTemplateUrl
        }

        fun htmlUrl(htmlUrl: String) = htmlUrl(JsonField.of(htmlUrl))

        /**
         * Sets [Builder.htmlUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.htmlUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun htmlUrl(htmlUrl: JsonField<String>) = apply { this.htmlUrl = htmlUrl }

        fun mineUrl(mineUrl: String) = mineUrl(JsonField.of(mineUrl))

        /**
         * Sets [Builder.mineUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mineUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mineUrl(mineUrl: JsonField<String>) = apply { this.mineUrl = mineUrl }

        fun subjectTemplateUrl(subjectTemplateUrl: String) =
            subjectTemplateUrl(JsonField.of(subjectTemplateUrl))

        /**
         * Sets [Builder.subjectTemplateUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subjectTemplateUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subjectTemplateUrl(subjectTemplateUrl: JsonField<String>) = apply {
            this.subjectTemplateUrl = subjectTemplateUrl
        }

        fun textTemplateUrl(textTemplateUrl: String) =
            textTemplateUrl(JsonField.of(textTemplateUrl))

        /**
         * Sets [Builder.textTemplateUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.textTemplateUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun textTemplateUrl(textTemplateUrl: JsonField<String>) = apply {
            this.textTemplateUrl = textTemplateUrl
        }

        fun textUrl(textUrl: String) = textUrl(JsonField.of(textUrl))

        /**
         * Sets [Builder.textUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.textUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun textUrl(textUrl: JsonField<String>) = apply { this.textUrl = textUrl }

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
         * Returns an immutable instance of [ContentRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContentRetrieveResponse =
            ContentRetrieveResponse(
                htmlTemplateUrl,
                htmlUrl,
                mineUrl,
                subjectTemplateUrl,
                textTemplateUrl,
                textUrl,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContentRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        htmlTemplateUrl()
        htmlUrl()
        mineUrl()
        subjectTemplateUrl()
        textTemplateUrl()
        textUrl()
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
        (if (htmlTemplateUrl.asKnown().isPresent) 1 else 0) +
            (if (htmlUrl.asKnown().isPresent) 1 else 0) +
            (if (mineUrl.asKnown().isPresent) 1 else 0) +
            (if (subjectTemplateUrl.asKnown().isPresent) 1 else 0) +
            (if (textTemplateUrl.asKnown().isPresent) 1 else 0) +
            (if (textUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContentRetrieveResponse &&
            htmlTemplateUrl == other.htmlTemplateUrl &&
            htmlUrl == other.htmlUrl &&
            mineUrl == other.mineUrl &&
            subjectTemplateUrl == other.subjectTemplateUrl &&
            textTemplateUrl == other.textTemplateUrl &&
            textUrl == other.textUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            htmlTemplateUrl,
            htmlUrl,
            mineUrl,
            subjectTemplateUrl,
            textTemplateUrl,
            textUrl,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContentRetrieveResponse{htmlTemplateUrl=$htmlTemplateUrl, htmlUrl=$htmlUrl, mineUrl=$mineUrl, subjectTemplateUrl=$subjectTemplateUrl, textTemplateUrl=$textTemplateUrl, textUrl=$textUrl, additionalProperties=$additionalProperties}"
}
