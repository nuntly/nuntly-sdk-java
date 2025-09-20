// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.shared

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class DeliveryDetail
private constructor(
    private val deliveredAt: JsonField<String>,
    private val recipients: JsonField<List<String>>,
    private val remoteMtaIp: JsonField<String>,
    private val reportingMta: JsonField<String>,
    private val smtpResponse: JsonField<String>,
    private val processingTime: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delivered_at")
        @ExcludeMissing
        deliveredAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recipients")
        @ExcludeMissing
        recipients: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("remote_mta_ip")
        @ExcludeMissing
        remoteMtaIp: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reporting_mta")
        @ExcludeMissing
        reportingMta: JsonField<String> = JsonMissing.of(),
        @JsonProperty("smtp_response")
        @ExcludeMissing
        smtpResponse: JsonField<String> = JsonMissing.of(),
        @JsonProperty("processing_time")
        @ExcludeMissing
        processingTime: JsonField<Double> = JsonMissing.of(),
    ) : this(
        deliveredAt,
        recipients,
        remoteMtaIp,
        reportingMta,
        smtpResponse,
        processingTime,
        mutableMapOf(),
    )

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deliveredAt(): String = deliveredAt.getRequired("delivered_at")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipients(): List<String> = recipients.getRequired("recipients")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun remoteMtaIp(): String = remoteMtaIp.getRequired("remote_mta_ip")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reportingMta(): String = reportingMta.getRequired("reporting_mta")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun smtpResponse(): String = smtpResponse.getRequired("smtp_response")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun processingTime(): Optional<Double> = processingTime.getOptional("processing_time")

    /**
     * Returns the raw JSON value of [deliveredAt].
     *
     * Unlike [deliveredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delivered_at")
    @ExcludeMissing
    fun _deliveredAt(): JsonField<String> = deliveredAt

    /**
     * Returns the raw JSON value of [recipients].
     *
     * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("recipients")
    @ExcludeMissing
    fun _recipients(): JsonField<List<String>> = recipients

    /**
     * Returns the raw JSON value of [remoteMtaIp].
     *
     * Unlike [remoteMtaIp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("remote_mta_ip")
    @ExcludeMissing
    fun _remoteMtaIp(): JsonField<String> = remoteMtaIp

    /**
     * Returns the raw JSON value of [reportingMta].
     *
     * Unlike [reportingMta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reporting_mta")
    @ExcludeMissing
    fun _reportingMta(): JsonField<String> = reportingMta

    /**
     * Returns the raw JSON value of [smtpResponse].
     *
     * Unlike [smtpResponse], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("smtp_response")
    @ExcludeMissing
    fun _smtpResponse(): JsonField<String> = smtpResponse

    /**
     * Returns the raw JSON value of [processingTime].
     *
     * Unlike [processingTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("processing_time")
    @ExcludeMissing
    fun _processingTime(): JsonField<Double> = processingTime

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
         * Returns a mutable builder for constructing an instance of [DeliveryDetail].
         *
         * The following fields are required:
         * ```java
         * .deliveredAt()
         * .recipients()
         * .remoteMtaIp()
         * .reportingMta()
         * .smtpResponse()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DeliveryDetail]. */
    class Builder internal constructor() {

        private var deliveredAt: JsonField<String>? = null
        private var recipients: JsonField<MutableList<String>>? = null
        private var remoteMtaIp: JsonField<String>? = null
        private var reportingMta: JsonField<String>? = null
        private var smtpResponse: JsonField<String>? = null
        private var processingTime: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(deliveryDetail: DeliveryDetail) = apply {
            deliveredAt = deliveryDetail.deliveredAt
            recipients = deliveryDetail.recipients.map { it.toMutableList() }
            remoteMtaIp = deliveryDetail.remoteMtaIp
            reportingMta = deliveryDetail.reportingMta
            smtpResponse = deliveryDetail.smtpResponse
            processingTime = deliveryDetail.processingTime
            additionalProperties = deliveryDetail.additionalProperties.toMutableMap()
        }

        fun deliveredAt(deliveredAt: String) = deliveredAt(JsonField.of(deliveredAt))

        /**
         * Sets [Builder.deliveredAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveredAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun deliveredAt(deliveredAt: JsonField<String>) = apply { this.deliveredAt = deliveredAt }

        fun recipients(recipients: List<String>) = recipients(JsonField.of(recipients))

        /**
         * Sets [Builder.recipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipients] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipients(recipients: JsonField<List<String>>) = apply {
            this.recipients = recipients.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [recipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipient(recipient: String) = apply {
            recipients =
                (recipients ?: JsonField.of(mutableListOf())).also {
                    checkKnown("recipients", it).add(recipient)
                }
        }

        fun remoteMtaIp(remoteMtaIp: String) = remoteMtaIp(JsonField.of(remoteMtaIp))

        /**
         * Sets [Builder.remoteMtaIp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.remoteMtaIp] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun remoteMtaIp(remoteMtaIp: JsonField<String>) = apply { this.remoteMtaIp = remoteMtaIp }

        fun reportingMta(reportingMta: String) = reportingMta(JsonField.of(reportingMta))

        /**
         * Sets [Builder.reportingMta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reportingMta] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reportingMta(reportingMta: JsonField<String>) = apply {
            this.reportingMta = reportingMta
        }

        fun smtpResponse(smtpResponse: String) = smtpResponse(JsonField.of(smtpResponse))

        /**
         * Sets [Builder.smtpResponse] to an arbitrary JSON value.
         *
         * You should usually call [Builder.smtpResponse] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun smtpResponse(smtpResponse: JsonField<String>) = apply {
            this.smtpResponse = smtpResponse
        }

        fun processingTime(processingTime: Double) = processingTime(JsonField.of(processingTime))

        /**
         * Sets [Builder.processingTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.processingTime] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun processingTime(processingTime: JsonField<Double>) = apply {
            this.processingTime = processingTime
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
         * Returns an immutable instance of [DeliveryDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .deliveredAt()
         * .recipients()
         * .remoteMtaIp()
         * .reportingMta()
         * .smtpResponse()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DeliveryDetail =
            DeliveryDetail(
                checkRequired("deliveredAt", deliveredAt),
                checkRequired("recipients", recipients).map { it.toImmutable() },
                checkRequired("remoteMtaIp", remoteMtaIp),
                checkRequired("reportingMta", reportingMta),
                checkRequired("smtpResponse", smtpResponse),
                processingTime,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DeliveryDetail = apply {
        if (validated) {
            return@apply
        }

        deliveredAt()
        recipients()
        remoteMtaIp()
        reportingMta()
        smtpResponse()
        processingTime()
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
        (if (deliveredAt.asKnown().isPresent) 1 else 0) +
            (recipients.asKnown().getOrNull()?.size ?: 0) +
            (if (remoteMtaIp.asKnown().isPresent) 1 else 0) +
            (if (reportingMta.asKnown().isPresent) 1 else 0) +
            (if (smtpResponse.asKnown().isPresent) 1 else 0) +
            (if (processingTime.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DeliveryDetail &&
            deliveredAt == other.deliveredAt &&
            recipients == other.recipients &&
            remoteMtaIp == other.remoteMtaIp &&
            reportingMta == other.reportingMta &&
            smtpResponse == other.smtpResponse &&
            processingTime == other.processingTime &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            deliveredAt,
            recipients,
            remoteMtaIp,
            reportingMta,
            smtpResponse,
            processingTime,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DeliveryDetail{deliveredAt=$deliveredAt, recipients=$recipients, remoteMtaIp=$remoteMtaIp, reportingMta=$reportingMta, smtpResponse=$smtpResponse, processingTime=$processingTime, additionalProperties=$additionalProperties}"
}
