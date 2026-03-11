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
import com.nuntly.core.checkRequired
import com.nuntly.errors.NuntlyInvalidDataException
import com.nuntly.models.emails.EmailContentItem
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ContentRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val html: JsonField<EmailContentItem>,
    private val htmlTemplate: JsonField<EmailContentItem>,
    private val mime: JsonField<EmailContentItem>,
    private val subjectTemplate: JsonField<EmailContentItem>,
    private val text: JsonField<EmailContentItem>,
    private val textTemplate: JsonField<EmailContentItem>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("html") @ExcludeMissing html: JsonField<EmailContentItem> = JsonMissing.of(),
        @JsonProperty("htmlTemplate")
        @ExcludeMissing
        htmlTemplate: JsonField<EmailContentItem> = JsonMissing.of(),
        @JsonProperty("mime") @ExcludeMissing mime: JsonField<EmailContentItem> = JsonMissing.of(),
        @JsonProperty("subjectTemplate")
        @ExcludeMissing
        subjectTemplate: JsonField<EmailContentItem> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<EmailContentItem> = JsonMissing.of(),
        @JsonProperty("textTemplate")
        @ExcludeMissing
        textTemplate: JsonField<EmailContentItem> = JsonMissing.of(),
    ) : this(html, htmlTemplate, mime, subjectTemplate, text, textTemplate, mutableMapOf())

    /**
     * HTML content, or `null` if unavailable.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun html(): Optional<EmailContentItem> = html.getOptional("html")

    /**
     * HTML template content, or `null` if unavailable. Returned for failed emails only.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun htmlTemplate(): Optional<EmailContentItem> = htmlTemplate.getOptional("htmlTemplate")

    /**
     * Raw MIME (.eml) content, or `null` if unavailable.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mime(): Optional<EmailContentItem> = mime.getOptional("mime")

    /**
     * Subject template content, or `null` if unavailable. Returned for failed emails only.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun subjectTemplate(): Optional<EmailContentItem> =
        subjectTemplate.getOptional("subjectTemplate")

    /**
     * Plain text content, or `null` if unavailable.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<EmailContentItem> = text.getOptional("text")

    /**
     * Text template content, or `null` if unavailable. Returned for failed emails only.
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun textTemplate(): Optional<EmailContentItem> = textTemplate.getOptional("textTemplate")

    /**
     * Returns the raw JSON value of [html].
     *
     * Unlike [html], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("html") @ExcludeMissing fun _html(): JsonField<EmailContentItem> = html

    /**
     * Returns the raw JSON value of [htmlTemplate].
     *
     * Unlike [htmlTemplate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("htmlTemplate")
    @ExcludeMissing
    fun _htmlTemplate(): JsonField<EmailContentItem> = htmlTemplate

    /**
     * Returns the raw JSON value of [mime].
     *
     * Unlike [mime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mime") @ExcludeMissing fun _mime(): JsonField<EmailContentItem> = mime

    /**
     * Returns the raw JSON value of [subjectTemplate].
     *
     * Unlike [subjectTemplate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subjectTemplate")
    @ExcludeMissing
    fun _subjectTemplate(): JsonField<EmailContentItem> = subjectTemplate

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<EmailContentItem> = text

    /**
     * Returns the raw JSON value of [textTemplate].
     *
     * Unlike [textTemplate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("textTemplate")
    @ExcludeMissing
    fun _textTemplate(): JsonField<EmailContentItem> = textTemplate

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
         * Returns a mutable builder for constructing an instance of [ContentRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .html()
         * .htmlTemplate()
         * .mime()
         * .subjectTemplate()
         * .text()
         * .textTemplate()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContentRetrieveResponse]. */
    class Builder internal constructor() {

        private var html: JsonField<EmailContentItem>? = null
        private var htmlTemplate: JsonField<EmailContentItem>? = null
        private var mime: JsonField<EmailContentItem>? = null
        private var subjectTemplate: JsonField<EmailContentItem>? = null
        private var text: JsonField<EmailContentItem>? = null
        private var textTemplate: JsonField<EmailContentItem>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contentRetrieveResponse: ContentRetrieveResponse) = apply {
            html = contentRetrieveResponse.html
            htmlTemplate = contentRetrieveResponse.htmlTemplate
            mime = contentRetrieveResponse.mime
            subjectTemplate = contentRetrieveResponse.subjectTemplate
            text = contentRetrieveResponse.text
            textTemplate = contentRetrieveResponse.textTemplate
            additionalProperties = contentRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** HTML content, or `null` if unavailable. */
        fun html(html: EmailContentItem?) = html(JsonField.ofNullable(html))

        /** Alias for calling [Builder.html] with `html.orElse(null)`. */
        fun html(html: Optional<EmailContentItem>) = html(html.getOrNull())

        /**
         * Sets [Builder.html] to an arbitrary JSON value.
         *
         * You should usually call [Builder.html] with a well-typed [EmailContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun html(html: JsonField<EmailContentItem>) = apply { this.html = html }

        /** HTML template content, or `null` if unavailable. Returned for failed emails only. */
        fun htmlTemplate(htmlTemplate: EmailContentItem?) =
            htmlTemplate(JsonField.ofNullable(htmlTemplate))

        /** Alias for calling [Builder.htmlTemplate] with `htmlTemplate.orElse(null)`. */
        fun htmlTemplate(htmlTemplate: Optional<EmailContentItem>) =
            htmlTemplate(htmlTemplate.getOrNull())

        /**
         * Sets [Builder.htmlTemplate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.htmlTemplate] with a well-typed [EmailContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun htmlTemplate(htmlTemplate: JsonField<EmailContentItem>) = apply {
            this.htmlTemplate = htmlTemplate
        }

        /** Raw MIME (.eml) content, or `null` if unavailable. */
        fun mime(mime: EmailContentItem?) = mime(JsonField.ofNullable(mime))

        /** Alias for calling [Builder.mime] with `mime.orElse(null)`. */
        fun mime(mime: Optional<EmailContentItem>) = mime(mime.getOrNull())

        /**
         * Sets [Builder.mime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mime] with a well-typed [EmailContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mime(mime: JsonField<EmailContentItem>) = apply { this.mime = mime }

        /** Subject template content, or `null` if unavailable. Returned for failed emails only. */
        fun subjectTemplate(subjectTemplate: EmailContentItem?) =
            subjectTemplate(JsonField.ofNullable(subjectTemplate))

        /** Alias for calling [Builder.subjectTemplate] with `subjectTemplate.orElse(null)`. */
        fun subjectTemplate(subjectTemplate: Optional<EmailContentItem>) =
            subjectTemplate(subjectTemplate.getOrNull())

        /**
         * Sets [Builder.subjectTemplate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subjectTemplate] with a well-typed [EmailContentItem]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun subjectTemplate(subjectTemplate: JsonField<EmailContentItem>) = apply {
            this.subjectTemplate = subjectTemplate
        }

        /** Plain text content, or `null` if unavailable. */
        fun text(text: EmailContentItem?) = text(JsonField.ofNullable(text))

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<EmailContentItem>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [EmailContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun text(text: JsonField<EmailContentItem>) = apply { this.text = text }

        /** Text template content, or `null` if unavailable. Returned for failed emails only. */
        fun textTemplate(textTemplate: EmailContentItem?) =
            textTemplate(JsonField.ofNullable(textTemplate))

        /** Alias for calling [Builder.textTemplate] with `textTemplate.orElse(null)`. */
        fun textTemplate(textTemplate: Optional<EmailContentItem>) =
            textTemplate(textTemplate.getOrNull())

        /**
         * Sets [Builder.textTemplate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.textTemplate] with a well-typed [EmailContentItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun textTemplate(textTemplate: JsonField<EmailContentItem>) = apply {
            this.textTemplate = textTemplate
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
         * Returns an immutable instance of [ContentRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .html()
         * .htmlTemplate()
         * .mime()
         * .subjectTemplate()
         * .text()
         * .textTemplate()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContentRetrieveResponse =
            ContentRetrieveResponse(
                checkRequired("html", html),
                checkRequired("htmlTemplate", htmlTemplate),
                checkRequired("mime", mime),
                checkRequired("subjectTemplate", subjectTemplate),
                checkRequired("text", text),
                checkRequired("textTemplate", textTemplate),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContentRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        html().ifPresent { it.validate() }
        htmlTemplate().ifPresent { it.validate() }
        mime().ifPresent { it.validate() }
        subjectTemplate().ifPresent { it.validate() }
        text().ifPresent { it.validate() }
        textTemplate().ifPresent { it.validate() }
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
        (html.asKnown().getOrNull()?.validity() ?: 0) +
            (htmlTemplate.asKnown().getOrNull()?.validity() ?: 0) +
            (mime.asKnown().getOrNull()?.validity() ?: 0) +
            (subjectTemplate.asKnown().getOrNull()?.validity() ?: 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0) +
            (textTemplate.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContentRetrieveResponse &&
            html == other.html &&
            htmlTemplate == other.htmlTemplate &&
            mime == other.mime &&
            subjectTemplate == other.subjectTemplate &&
            text == other.text &&
            textTemplate == other.textTemplate &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            html,
            htmlTemplate,
            mime,
            subjectTemplate,
            text,
            textTemplate,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContentRetrieveResponse{html=$html, htmlTemplate=$htmlTemplate, mime=$mime, subjectTemplate=$subjectTemplate, text=$text, textTemplate=$textTemplate, additionalProperties=$additionalProperties}"
}
