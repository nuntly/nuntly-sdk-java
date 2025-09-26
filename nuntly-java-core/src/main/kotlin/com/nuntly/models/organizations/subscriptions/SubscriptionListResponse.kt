// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.subscriptions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.nuntly.core.Enum
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

class SubscriptionListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val cancelAt: JsonField<String>,
    private val cancelAtPeriodEnd: JsonField<Boolean>,
    private val currentPeriodEnd: JsonField<String>,
    private val currentPeriodStart: JsonField<String>,
    private val orgId: JsonField<String>,
    private val price: JsonField<Price>,
    private val status: JsonField<Status>,
    private val type: JsonField<Type>,
    private val addon: JsonField<Addon>,
    private val plan: JsonField<Plan>,
    private val quota: JsonField<Quota>,
    private val schedule: JsonField<Schedule>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cancel_at") @ExcludeMissing cancelAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("cancel_at_period_end")
        @ExcludeMissing
        cancelAtPeriodEnd: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("current_period_end")
        @ExcludeMissing
        currentPeriodEnd: JsonField<String> = JsonMissing.of(),
        @JsonProperty("current_period_start")
        @ExcludeMissing
        currentPeriodStart: JsonField<String> = JsonMissing.of(),
        @JsonProperty("org_id") @ExcludeMissing orgId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<Price> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("addon") @ExcludeMissing addon: JsonField<Addon> = JsonMissing.of(),
        @JsonProperty("plan") @ExcludeMissing plan: JsonField<Plan> = JsonMissing.of(),
        @JsonProperty("quota") @ExcludeMissing quota: JsonField<Quota> = JsonMissing.of(),
        @JsonProperty("schedule") @ExcludeMissing schedule: JsonField<Schedule> = JsonMissing.of(),
    ) : this(
        cancelAt,
        cancelAtPeriodEnd,
        currentPeriodEnd,
        currentPeriodStart,
        orgId,
        price,
        status,
        type,
        addon,
        plan,
        quota,
        schedule,
        mutableMapOf(),
    )

    /**
     * If the subscription has been canceled, the date of that cancellation
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancelAt(): Optional<String> = cancelAt.getOptional("cancel_at")

    /**
     * Whether this subscription will or did cancel at the end of the current billing period
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cancelAtPeriodEnd(): Boolean = cancelAtPeriodEnd.getRequired("cancel_at_period_end")

    /**
     * End of the current period that the subscription has been invoiced for
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun currentPeriodEnd(): String = currentPeriodEnd.getRequired("current_period_end")

    /**
     * Start of the current period that the subscription has been invoiced for
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun currentPeriodStart(): String = currentPeriodStart.getRequired("current_period_start")

    /**
     * The id of the organization
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun orgId(): String = orgId.getRequired("org_id")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun price(): Price = price.getRequired("price")

    /**
     * The status of the subscription (plan or addon
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The type of the subscription
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * The name of the addon
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addon(): Optional<Addon> = addon.getOptional("addon")

    /**
     * The name of the plan
     *
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun plan(): Optional<Plan> = plan.getOptional("plan")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun quota(): Optional<Quota> = quota.getOptional("quota")

    /**
     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun schedule(): Optional<Schedule> = schedule.getOptional("schedule")

    /**
     * Returns the raw JSON value of [cancelAt].
     *
     * Unlike [cancelAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cancel_at") @ExcludeMissing fun _cancelAt(): JsonField<String> = cancelAt

    /**
     * Returns the raw JSON value of [cancelAtPeriodEnd].
     *
     * Unlike [cancelAtPeriodEnd], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("cancel_at_period_end")
    @ExcludeMissing
    fun _cancelAtPeriodEnd(): JsonField<Boolean> = cancelAtPeriodEnd

    /**
     * Returns the raw JSON value of [currentPeriodEnd].
     *
     * Unlike [currentPeriodEnd], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("current_period_end")
    @ExcludeMissing
    fun _currentPeriodEnd(): JsonField<String> = currentPeriodEnd

    /**
     * Returns the raw JSON value of [currentPeriodStart].
     *
     * Unlike [currentPeriodStart], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("current_period_start")
    @ExcludeMissing
    fun _currentPeriodStart(): JsonField<String> = currentPeriodStart

    /**
     * Returns the raw JSON value of [orgId].
     *
     * Unlike [orgId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("org_id") @ExcludeMissing fun _orgId(): JsonField<String> = orgId

    /**
     * Returns the raw JSON value of [price].
     *
     * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Price> = price

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [addon].
     *
     * Unlike [addon], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("addon") @ExcludeMissing fun _addon(): JsonField<Addon> = addon

    /**
     * Returns the raw JSON value of [plan].
     *
     * Unlike [plan], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("plan") @ExcludeMissing fun _plan(): JsonField<Plan> = plan

    /**
     * Returns the raw JSON value of [quota].
     *
     * Unlike [quota], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quota") @ExcludeMissing fun _quota(): JsonField<Quota> = quota

    /**
     * Returns the raw JSON value of [schedule].
     *
     * Unlike [schedule], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("schedule") @ExcludeMissing fun _schedule(): JsonField<Schedule> = schedule

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
         * Returns a mutable builder for constructing an instance of [SubscriptionListResponse].
         *
         * The following fields are required:
         * ```java
         * .cancelAt()
         * .cancelAtPeriodEnd()
         * .currentPeriodEnd()
         * .currentPeriodStart()
         * .orgId()
         * .price()
         * .status()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SubscriptionListResponse]. */
    class Builder internal constructor() {

        private var cancelAt: JsonField<String>? = null
        private var cancelAtPeriodEnd: JsonField<Boolean>? = null
        private var currentPeriodEnd: JsonField<String>? = null
        private var currentPeriodStart: JsonField<String>? = null
        private var orgId: JsonField<String>? = null
        private var price: JsonField<Price>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonField<Type>? = null
        private var addon: JsonField<Addon> = JsonMissing.of()
        private var plan: JsonField<Plan> = JsonMissing.of()
        private var quota: JsonField<Quota> = JsonMissing.of()
        private var schedule: JsonField<Schedule> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(subscriptionListResponse: SubscriptionListResponse) = apply {
            cancelAt = subscriptionListResponse.cancelAt
            cancelAtPeriodEnd = subscriptionListResponse.cancelAtPeriodEnd
            currentPeriodEnd = subscriptionListResponse.currentPeriodEnd
            currentPeriodStart = subscriptionListResponse.currentPeriodStart
            orgId = subscriptionListResponse.orgId
            price = subscriptionListResponse.price
            status = subscriptionListResponse.status
            type = subscriptionListResponse.type
            addon = subscriptionListResponse.addon
            plan = subscriptionListResponse.plan
            quota = subscriptionListResponse.quota
            schedule = subscriptionListResponse.schedule
            additionalProperties = subscriptionListResponse.additionalProperties.toMutableMap()
        }

        /** If the subscription has been canceled, the date of that cancellation */
        fun cancelAt(cancelAt: String?) = cancelAt(JsonField.ofNullable(cancelAt))

        /** Alias for calling [Builder.cancelAt] with `cancelAt.orElse(null)`. */
        fun cancelAt(cancelAt: Optional<String>) = cancelAt(cancelAt.getOrNull())

        /**
         * Sets [Builder.cancelAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancelAt] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cancelAt(cancelAt: JsonField<String>) = apply { this.cancelAt = cancelAt }

        /** Whether this subscription will or did cancel at the end of the current billing period */
        fun cancelAtPeriodEnd(cancelAtPeriodEnd: Boolean) =
            cancelAtPeriodEnd(JsonField.of(cancelAtPeriodEnd))

        /**
         * Sets [Builder.cancelAtPeriodEnd] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancelAtPeriodEnd] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cancelAtPeriodEnd(cancelAtPeriodEnd: JsonField<Boolean>) = apply {
            this.cancelAtPeriodEnd = cancelAtPeriodEnd
        }

        /** End of the current period that the subscription has been invoiced for */
        fun currentPeriodEnd(currentPeriodEnd: String) =
            currentPeriodEnd(JsonField.of(currentPeriodEnd))

        /**
         * Sets [Builder.currentPeriodEnd] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentPeriodEnd] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun currentPeriodEnd(currentPeriodEnd: JsonField<String>) = apply {
            this.currentPeriodEnd = currentPeriodEnd
        }

        /** Start of the current period that the subscription has been invoiced for */
        fun currentPeriodStart(currentPeriodStart: String) =
            currentPeriodStart(JsonField.of(currentPeriodStart))

        /**
         * Sets [Builder.currentPeriodStart] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentPeriodStart] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun currentPeriodStart(currentPeriodStart: JsonField<String>) = apply {
            this.currentPeriodStart = currentPeriodStart
        }

        /** The id of the organization */
        fun orgId(orgId: String) = orgId(JsonField.of(orgId))

        /**
         * Sets [Builder.orgId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.orgId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun orgId(orgId: JsonField<String>) = apply { this.orgId = orgId }

        fun price(price: Price) = price(JsonField.of(price))

        /**
         * Sets [Builder.price] to an arbitrary JSON value.
         *
         * You should usually call [Builder.price] with a well-typed [Price] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun price(price: JsonField<Price>) = apply { this.price = price }

        /** The status of the subscription (plan or addon */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The type of the subscription */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The name of the addon */
        fun addon(addon: Addon) = addon(JsonField.of(addon))

        /**
         * Sets [Builder.addon] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addon] with a well-typed [Addon] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun addon(addon: JsonField<Addon>) = apply { this.addon = addon }

        /** The name of the plan */
        fun plan(plan: Plan) = plan(JsonField.of(plan))

        /**
         * Sets [Builder.plan] to an arbitrary JSON value.
         *
         * You should usually call [Builder.plan] with a well-typed [Plan] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun plan(plan: JsonField<Plan>) = apply { this.plan = plan }

        fun quota(quota: Quota) = quota(JsonField.of(quota))

        /**
         * Sets [Builder.quota] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quota] with a well-typed [Quota] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quota(quota: JsonField<Quota>) = apply { this.quota = quota }

        fun schedule(schedule: Schedule) = schedule(JsonField.of(schedule))

        /**
         * Sets [Builder.schedule] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schedule] with a well-typed [Schedule] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun schedule(schedule: JsonField<Schedule>) = apply { this.schedule = schedule }

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
         * Returns an immutable instance of [SubscriptionListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .cancelAt()
         * .cancelAtPeriodEnd()
         * .currentPeriodEnd()
         * .currentPeriodStart()
         * .orgId()
         * .price()
         * .status()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SubscriptionListResponse =
            SubscriptionListResponse(
                checkRequired("cancelAt", cancelAt),
                checkRequired("cancelAtPeriodEnd", cancelAtPeriodEnd),
                checkRequired("currentPeriodEnd", currentPeriodEnd),
                checkRequired("currentPeriodStart", currentPeriodStart),
                checkRequired("orgId", orgId),
                checkRequired("price", price),
                checkRequired("status", status),
                checkRequired("type", type),
                addon,
                plan,
                quota,
                schedule,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SubscriptionListResponse = apply {
        if (validated) {
            return@apply
        }

        cancelAt()
        cancelAtPeriodEnd()
        currentPeriodEnd()
        currentPeriodStart()
        orgId()
        price().validate()
        status().validate()
        type().validate()
        addon().ifPresent { it.validate() }
        plan().ifPresent { it.validate() }
        quota().ifPresent { it.validate() }
        schedule().ifPresent { it.validate() }
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
        (if (cancelAt.asKnown().isPresent) 1 else 0) +
            (if (cancelAtPeriodEnd.asKnown().isPresent) 1 else 0) +
            (if (currentPeriodEnd.asKnown().isPresent) 1 else 0) +
            (if (currentPeriodStart.asKnown().isPresent) 1 else 0) +
            (if (orgId.asKnown().isPresent) 1 else 0) +
            (price.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (addon.asKnown().getOrNull()?.validity() ?: 0) +
            (plan.asKnown().getOrNull()?.validity() ?: 0) +
            (quota.asKnown().getOrNull()?.validity() ?: 0) +
            (schedule.asKnown().getOrNull()?.validity() ?: 0)

    class Price
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val currency: JsonField<String>,
        private val recurring: JsonField<Recurring>,
        private val unitAmount: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("currency")
            @ExcludeMissing
            currency: JsonField<String> = JsonMissing.of(),
            @JsonProperty("recurring")
            @ExcludeMissing
            recurring: JsonField<Recurring> = JsonMissing.of(),
            @JsonProperty("unit_amount")
            @ExcludeMissing
            unitAmount: JsonField<Double> = JsonMissing.of(),
        ) : this(currency, recurring, unitAmount, mutableMapOf())

        /**
         * ISO currency code
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun currency(): String = currency.getRequired("currency")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recurring(): Recurring = recurring.getRequired("recurring")

        /**
         * The unit amount in cents (or local equivalent) to be charged
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun unitAmount(): Optional<Double> = unitAmount.getOptional("unit_amount")

        /**
         * Returns the raw JSON value of [currency].
         *
         * Unlike [currency], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<String> = currency

        /**
         * Returns the raw JSON value of [recurring].
         *
         * Unlike [recurring], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recurring")
        @ExcludeMissing
        fun _recurring(): JsonField<Recurring> = recurring

        /**
         * Returns the raw JSON value of [unitAmount].
         *
         * Unlike [unitAmount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("unit_amount")
        @ExcludeMissing
        fun _unitAmount(): JsonField<Double> = unitAmount

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
             * Returns a mutable builder for constructing an instance of [Price].
             *
             * The following fields are required:
             * ```java
             * .currency()
             * .recurring()
             * .unitAmount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Price]. */
        class Builder internal constructor() {

            private var currency: JsonField<String>? = null
            private var recurring: JsonField<Recurring>? = null
            private var unitAmount: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(price: Price) = apply {
                currency = price.currency
                recurring = price.recurring
                unitAmount = price.unitAmount
                additionalProperties = price.additionalProperties.toMutableMap()
            }

            /** ISO currency code */
            fun currency(currency: String) = currency(JsonField.of(currency))

            /**
             * Sets [Builder.currency] to an arbitrary JSON value.
             *
             * You should usually call [Builder.currency] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun currency(currency: JsonField<String>) = apply { this.currency = currency }

            fun recurring(recurring: Recurring) = recurring(JsonField.of(recurring))

            /**
             * Sets [Builder.recurring] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recurring] with a well-typed [Recurring] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recurring(recurring: JsonField<Recurring>) = apply { this.recurring = recurring }

            /** The unit amount in cents (or local equivalent) to be charged */
            fun unitAmount(unitAmount: Double?) = unitAmount(JsonField.ofNullable(unitAmount))

            /**
             * Alias for [Builder.unitAmount].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun unitAmount(unitAmount: Double) = unitAmount(unitAmount as Double?)

            /** Alias for calling [Builder.unitAmount] with `unitAmount.orElse(null)`. */
            fun unitAmount(unitAmount: Optional<Double>) = unitAmount(unitAmount.getOrNull())

            /**
             * Sets [Builder.unitAmount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.unitAmount] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun unitAmount(unitAmount: JsonField<Double>) = apply { this.unitAmount = unitAmount }

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
             * Returns an immutable instance of [Price].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .currency()
             * .recurring()
             * .unitAmount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Price =
                Price(
                    checkRequired("currency", currency),
                    checkRequired("recurring", recurring),
                    checkRequired("unitAmount", unitAmount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Price = apply {
            if (validated) {
                return@apply
            }

            currency()
            recurring().validate()
            unitAmount()
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
            (if (currency.asKnown().isPresent) 1 else 0) +
                (recurring.asKnown().getOrNull()?.validity() ?: 0) +
                (if (unitAmount.asKnown().isPresent) 1 else 0)

        class Recurring
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val interval: JsonField<Interval>,
            private val intervalCount: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("interval")
                @ExcludeMissing
                interval: JsonField<Interval> = JsonMissing.of(),
                @JsonProperty("interval_count")
                @ExcludeMissing
                intervalCount: JsonField<Double> = JsonMissing.of(),
            ) : this(interval, intervalCount, mutableMapOf())

            /**
             * The frequency at which a subscription is billed.
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun interval(): Optional<Interval> = interval.getOptional("interval")

            /**
             * The number of intervals between subscription billings
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun intervalCount(): Optional<Double> = intervalCount.getOptional("interval_count")

            /**
             * Returns the raw JSON value of [interval].
             *
             * Unlike [interval], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("interval")
            @ExcludeMissing
            fun _interval(): JsonField<Interval> = interval

            /**
             * Returns the raw JSON value of [intervalCount].
             *
             * Unlike [intervalCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("interval_count")
            @ExcludeMissing
            fun _intervalCount(): JsonField<Double> = intervalCount

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

                /** Returns a mutable builder for constructing an instance of [Recurring]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Recurring]. */
            class Builder internal constructor() {

                private var interval: JsonField<Interval> = JsonMissing.of()
                private var intervalCount: JsonField<Double> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(recurring: Recurring) = apply {
                    interval = recurring.interval
                    intervalCount = recurring.intervalCount
                    additionalProperties = recurring.additionalProperties.toMutableMap()
                }

                /** The frequency at which a subscription is billed. */
                fun interval(interval: Interval) = interval(JsonField.of(interval))

                /**
                 * Sets [Builder.interval] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.interval] with a well-typed [Interval] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun interval(interval: JsonField<Interval>) = apply { this.interval = interval }

                /** The number of intervals between subscription billings */
                fun intervalCount(intervalCount: Double) =
                    intervalCount(JsonField.of(intervalCount))

                /**
                 * Sets [Builder.intervalCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.intervalCount] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun intervalCount(intervalCount: JsonField<Double>) = apply {
                    this.intervalCount = intervalCount
                }

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
                 * Returns an immutable instance of [Recurring].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Recurring =
                    Recurring(interval, intervalCount, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Recurring = apply {
                if (validated) {
                    return@apply
                }

                interval().ifPresent { it.validate() }
                intervalCount()
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
                (interval.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (intervalCount.asKnown().isPresent) 1 else 0)

            /** The frequency at which a subscription is billed. */
            class Interval @JsonCreator private constructor(private val value: JsonField<String>) :
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

                    @JvmField val DAY = of("day")

                    @JvmField val MONTH = of("month")

                    @JvmField val WEEK = of("week")

                    @JvmField val YEAR = of("year")

                    @JvmStatic fun of(value: String) = Interval(JsonField.of(value))
                }

                /** An enum containing [Interval]'s known values. */
                enum class Known {
                    DAY,
                    MONTH,
                    WEEK,
                    YEAR,
                }

                /**
                 * An enum containing [Interval]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Interval] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    DAY,
                    MONTH,
                    WEEK,
                    YEAR,
                    /**
                     * An enum member indicating that [Interval] was instantiated with an unknown
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
                        DAY -> Value.DAY
                        MONTH -> Value.MONTH
                        WEEK -> Value.WEEK
                        YEAR -> Value.YEAR
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
                        DAY -> Known.DAY
                        MONTH -> Known.MONTH
                        WEEK -> Known.WEEK
                        YEAR -> Known.YEAR
                        else -> throw NuntlyInvalidDataException("Unknown Interval: $value")
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

                fun validate(): Interval = apply {
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

                    return other is Interval && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Recurring &&
                    interval == other.interval &&
                    intervalCount == other.intervalCount &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(interval, intervalCount, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Recurring{interval=$interval, intervalCount=$intervalCount, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Price &&
                currency == other.currency &&
                recurring == other.recurring &&
                unitAmount == other.unitAmount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(currency, recurring, unitAmount, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Price{currency=$currency, recurring=$recurring, unitAmount=$unitAmount, additionalProperties=$additionalProperties}"
    }

    /** The status of the subscription (plan or addon */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ACTIVE = of("active")

            @JvmField val CANCELED = of("canceled")

            @JvmField val INCOMPLETE = of("incomplete")

            @JvmField val INCOMPLETE_EXPIRED = of("incomplete_expired")

            @JvmField val PAST_DUE = of("past_due")

            @JvmField val PAUSED = of("paused")

            @JvmField val TRIALING = of("trialing")

            @JvmField val UNPAID = of("unpaid")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            ACTIVE,
            CANCELED,
            INCOMPLETE,
            INCOMPLETE_EXPIRED,
            PAST_DUE,
            PAUSED,
            TRIALING,
            UNPAID,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ACTIVE,
            CANCELED,
            INCOMPLETE,
            INCOMPLETE_EXPIRED,
            PAST_DUE,
            PAUSED,
            TRIALING,
            UNPAID,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                CANCELED -> Value.CANCELED
                INCOMPLETE -> Value.INCOMPLETE
                INCOMPLETE_EXPIRED -> Value.INCOMPLETE_EXPIRED
                PAST_DUE -> Value.PAST_DUE
                PAUSED -> Value.PAUSED
                TRIALING -> Value.TRIALING
                UNPAID -> Value.UNPAID
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws NuntlyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                ACTIVE -> Known.ACTIVE
                CANCELED -> Known.CANCELED
                INCOMPLETE -> Known.INCOMPLETE
                INCOMPLETE_EXPIRED -> Known.INCOMPLETE_EXPIRED
                PAST_DUE -> Known.PAST_DUE
                PAUSED -> Known.PAUSED
                TRIALING -> Known.TRIALING
                UNPAID -> Known.UNPAID
                else -> throw NuntlyInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws NuntlyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The type of the subscription */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PLAN = of("plan")

            @JvmField val ADDON = of("addon")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            PLAN,
            ADDON,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PLAN,
            ADDON,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PLAN -> Value.PLAN
                ADDON -> Value.ADDON
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws NuntlyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                PLAN -> Known.PLAN
                ADDON -> Known.ADDON
                else -> throw NuntlyInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws NuntlyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The name of the addon */
    class Addon @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val DEDICATED_IPS = of("dedicated-ips")

            @JvmStatic fun of(value: String) = Addon(JsonField.of(value))
        }

        /** An enum containing [Addon]'s known values. */
        enum class Known {
            DEDICATED_IPS
        }

        /**
         * An enum containing [Addon]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Addon] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DEDICATED_IPS,
            /** An enum member indicating that [Addon] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                DEDICATED_IPS -> Value.DEDICATED_IPS
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws NuntlyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                DEDICATED_IPS -> Known.DEDICATED_IPS
                else -> throw NuntlyInvalidDataException("Unknown Addon: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws NuntlyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Addon = apply {
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

            return other is Addon && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The name of the plan */
    class Plan @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FREE = of("free")

            @JvmField val STARTER = of("starter")

            @JvmField val SCALE = of("scale")

            @JvmField val ENTERPRISE = of("enterprise")

            @JvmStatic fun of(value: String) = Plan(JsonField.of(value))
        }

        /** An enum containing [Plan]'s known values. */
        enum class Known {
            FREE,
            STARTER,
            SCALE,
            ENTERPRISE,
        }

        /**
         * An enum containing [Plan]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Plan] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FREE,
            STARTER,
            SCALE,
            ENTERPRISE,
            /** An enum member indicating that [Plan] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                FREE -> Value.FREE
                STARTER -> Value.STARTER
                SCALE -> Value.SCALE
                ENTERPRISE -> Value.ENTERPRISE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws NuntlyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                FREE -> Known.FREE
                STARTER -> Known.STARTER
                SCALE -> Known.SCALE
                ENTERPRISE -> Known.ENTERPRISE
                else -> throw NuntlyInvalidDataException("Unknown Plan: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws NuntlyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { NuntlyInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Plan = apply {
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

            return other is Plan && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Quota
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val daily: JsonField<Daily>,
        private val monthly: JsonField<Monthly>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("daily") @ExcludeMissing daily: JsonField<Daily> = JsonMissing.of(),
            @JsonProperty("monthly") @ExcludeMissing monthly: JsonField<Monthly> = JsonMissing.of(),
        ) : this(daily, monthly, mutableMapOf())

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun daily(): Daily = daily.getRequired("daily")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun monthly(): Monthly = monthly.getRequired("monthly")

        /**
         * Returns the raw JSON value of [daily].
         *
         * Unlike [daily], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("daily") @ExcludeMissing fun _daily(): JsonField<Daily> = daily

        /**
         * Returns the raw JSON value of [monthly].
         *
         * Unlike [monthly], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("monthly") @ExcludeMissing fun _monthly(): JsonField<Monthly> = monthly

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
             * Returns a mutable builder for constructing an instance of [Quota].
             *
             * The following fields are required:
             * ```java
             * .daily()
             * .monthly()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Quota]. */
        class Builder internal constructor() {

            private var daily: JsonField<Daily>? = null
            private var monthly: JsonField<Monthly>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(quota: Quota) = apply {
                daily = quota.daily
                monthly = quota.monthly
                additionalProperties = quota.additionalProperties.toMutableMap()
            }

            fun daily(daily: Daily) = daily(JsonField.of(daily))

            /**
             * Sets [Builder.daily] to an arbitrary JSON value.
             *
             * You should usually call [Builder.daily] with a well-typed [Daily] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun daily(daily: JsonField<Daily>) = apply { this.daily = daily }

            fun monthly(monthly: Monthly) = monthly(JsonField.of(monthly))

            /**
             * Sets [Builder.monthly] to an arbitrary JSON value.
             *
             * You should usually call [Builder.monthly] with a well-typed [Monthly] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun monthly(monthly: JsonField<Monthly>) = apply { this.monthly = monthly }

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
             * Returns an immutable instance of [Quota].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .daily()
             * .monthly()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Quota =
                Quota(
                    checkRequired("daily", daily),
                    checkRequired("monthly", monthly),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Quota = apply {
            if (validated) {
                return@apply
            }

            daily().validate()
            monthly().validate()
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
            (daily.asKnown().getOrNull()?.validity() ?: 0) +
                (monthly.asKnown().getOrNull()?.validity() ?: 0)

        class Daily
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val transacEmails: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("transac_emails")
                @ExcludeMissing
                transacEmails: JsonField<Double> = JsonMissing.of()
            ) : this(transacEmails, mutableMapOf())

            /**
             * The quota of the emails subscribed (if applicable)
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

            /**
             * Returns the raw JSON value of [transacEmails].
             *
             * Unlike [transacEmails], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transac_emails")
            @ExcludeMissing
            fun _transacEmails(): JsonField<Double> = transacEmails

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
                 * Returns a mutable builder for constructing an instance of [Daily].
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Daily]. */
            class Builder internal constructor() {

                private var transacEmails: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(daily: Daily) = apply {
                    transacEmails = daily.transacEmails
                    additionalProperties = daily.additionalProperties.toMutableMap()
                }

                /** The quota of the emails subscribed (if applicable) */
                fun transacEmails(transacEmails: Double) =
                    transacEmails(JsonField.of(transacEmails))

                /**
                 * Sets [Builder.transacEmails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transacEmails] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun transacEmails(transacEmails: JsonField<Double>) = apply {
                    this.transacEmails = transacEmails
                }

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
                 * Returns an immutable instance of [Daily].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Daily =
                    Daily(
                        checkRequired("transacEmails", transacEmails),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Daily = apply {
                if (validated) {
                    return@apply
                }

                transacEmails()
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
            internal fun validity(): Int = (if (transacEmails.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Daily &&
                    transacEmails == other.transacEmails &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(transacEmails, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Daily{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
        }

        class Monthly
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val transacEmails: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("transac_emails")
                @ExcludeMissing
                transacEmails: JsonField<Double> = JsonMissing.of()
            ) : this(transacEmails, mutableMapOf())

            /**
             * The quota of the emails subscribed (if applicable)
             *
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

            /**
             * Returns the raw JSON value of [transacEmails].
             *
             * Unlike [transacEmails], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transac_emails")
            @ExcludeMissing
            fun _transacEmails(): JsonField<Double> = transacEmails

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
                 * Returns a mutable builder for constructing an instance of [Monthly].
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Monthly]. */
            class Builder internal constructor() {

                private var transacEmails: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(monthly: Monthly) = apply {
                    transacEmails = monthly.transacEmails
                    additionalProperties = monthly.additionalProperties.toMutableMap()
                }

                /** The quota of the emails subscribed (if applicable) */
                fun transacEmails(transacEmails: Double) =
                    transacEmails(JsonField.of(transacEmails))

                /**
                 * Sets [Builder.transacEmails] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transacEmails] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun transacEmails(transacEmails: JsonField<Double>) = apply {
                    this.transacEmails = transacEmails
                }

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
                 * Returns an immutable instance of [Monthly].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .transacEmails()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Monthly =
                    Monthly(
                        checkRequired("transacEmails", transacEmails),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Monthly = apply {
                if (validated) {
                    return@apply
                }

                transacEmails()
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
            internal fun validity(): Int = (if (transacEmails.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Monthly &&
                    transacEmails == other.transacEmails &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(transacEmails, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Monthly{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Quota &&
                daily == other.daily &&
                monthly == other.monthly &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(daily, monthly, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Quota{daily=$daily, monthly=$monthly, additionalProperties=$additionalProperties}"
    }

    class Schedule
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val created: JsonField<String>,
        private val phases: JsonField<List<Phase>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("created") @ExcludeMissing created: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phases")
            @ExcludeMissing
            phases: JsonField<List<Phase>> = JsonMissing.of(),
        ) : this(created, phases, mutableMapOf())

        /**
         * The date of the creation of the schedule
         *
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun created(): String = created.getRequired("created")

        /**
         * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun phases(): List<Phase> = phases.getRequired("phases")

        /**
         * Returns the raw JSON value of [created].
         *
         * Unlike [created], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<String> = created

        /**
         * Returns the raw JSON value of [phases].
         *
         * Unlike [phases], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("phases") @ExcludeMissing fun _phases(): JsonField<List<Phase>> = phases

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
             * Returns a mutable builder for constructing an instance of [Schedule].
             *
             * The following fields are required:
             * ```java
             * .created()
             * .phases()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Schedule]. */
        class Builder internal constructor() {

            private var created: JsonField<String>? = null
            private var phases: JsonField<MutableList<Phase>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(schedule: Schedule) = apply {
                created = schedule.created
                phases = schedule.phases.map { it.toMutableList() }
                additionalProperties = schedule.additionalProperties.toMutableMap()
            }

            /** The date of the creation of the schedule */
            fun created(created: String) = created(JsonField.of(created))

            /**
             * Sets [Builder.created] to an arbitrary JSON value.
             *
             * You should usually call [Builder.created] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun created(created: JsonField<String>) = apply { this.created = created }

            fun phases(phases: List<Phase>) = phases(JsonField.of(phases))

            /**
             * Sets [Builder.phases] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phases] with a well-typed `List<Phase>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phases(phases: JsonField<List<Phase>>) = apply {
                this.phases = phases.map { it.toMutableList() }
            }

            /**
             * Adds a single [Phase] to [phases].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPhase(phase: Phase) = apply {
                phases =
                    (phases ?: JsonField.of(mutableListOf())).also {
                        checkKnown("phases", it).add(phase)
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
             * Returns an immutable instance of [Schedule].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .created()
             * .phases()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Schedule =
                Schedule(
                    checkRequired("created", created),
                    checkRequired("phases", phases).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Schedule = apply {
            if (validated) {
                return@apply
            }

            created()
            phases().forEach { it.validate() }
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
            (if (created.asKnown().isPresent) 1 else 0) +
                (phases.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class Phase
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val price: JsonField<Price>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("price") @ExcludeMissing price: JsonField<Price> = JsonMissing.of()
            ) : this(price, mutableMapOf())

            /**
             * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun price(): Price = price.getRequired("price")

            /**
             * Returns the raw JSON value of [price].
             *
             * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Price> = price

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
                 * Returns a mutable builder for constructing an instance of [Phase].
                 *
                 * The following fields are required:
                 * ```java
                 * .price()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Phase]. */
            class Builder internal constructor() {

                private var price: JsonField<Price>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(phase: Phase) = apply {
                    price = phase.price
                    additionalProperties = phase.additionalProperties.toMutableMap()
                }

                fun price(price: Price) = price(JsonField.of(price))

                /**
                 * Sets [Builder.price] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.price] with a well-typed [Price] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun price(price: JsonField<Price>) = apply { this.price = price }

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
                 * Returns an immutable instance of [Phase].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .price()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Phase =
                    Phase(checkRequired("price", price), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Phase = apply {
                if (validated) {
                    return@apply
                }

                price().validate()
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
            internal fun validity(): Int = (price.asKnown().getOrNull()?.validity() ?: 0)

            class Price
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val currency: JsonField<String>,
                private val recurring: JsonField<Recurring>,
                private val type: JsonField<Type>,
                private val unitAmount: JsonField<Double>,
                private val plan: JsonField<Plan>,
                private val quota: JsonField<Quota>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("currency")
                    @ExcludeMissing
                    currency: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("recurring")
                    @ExcludeMissing
                    recurring: JsonField<Recurring> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                    @JsonProperty("unit_amount")
                    @ExcludeMissing
                    unitAmount: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("plan") @ExcludeMissing plan: JsonField<Plan> = JsonMissing.of(),
                    @JsonProperty("quota")
                    @ExcludeMissing
                    quota: JsonField<Quota> = JsonMissing.of(),
                ) : this(currency, recurring, type, unitAmount, plan, quota, mutableMapOf())

                /**
                 * ISO currency code
                 *
                 * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun currency(): String = currency.getRequired("currency")

                /**
                 * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun recurring(): Recurring = recurring.getRequired("recurring")

                /**
                 * The type of the subscription
                 *
                 * @throws NuntlyInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun type(): Type = type.getRequired("type")

                /**
                 * The unit amount in cents (or local equivalent) to be charged
                 *
                 * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun unitAmount(): Optional<Double> = unitAmount.getOptional("unit_amount")

                /**
                 * The name of the plan
                 *
                 * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun plan(): Optional<Plan> = plan.getOptional("plan")

                /**
                 * @throws NuntlyInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun quota(): Optional<Quota> = quota.getOptional("quota")

                /**
                 * Returns the raw JSON value of [currency].
                 *
                 * Unlike [currency], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("currency")
                @ExcludeMissing
                fun _currency(): JsonField<String> = currency

                /**
                 * Returns the raw JSON value of [recurring].
                 *
                 * Unlike [recurring], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("recurring")
                @ExcludeMissing
                fun _recurring(): JsonField<Recurring> = recurring

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                /**
                 * Returns the raw JSON value of [unitAmount].
                 *
                 * Unlike [unitAmount], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("unit_amount")
                @ExcludeMissing
                fun _unitAmount(): JsonField<Double> = unitAmount

                /**
                 * Returns the raw JSON value of [plan].
                 *
                 * Unlike [plan], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("plan") @ExcludeMissing fun _plan(): JsonField<Plan> = plan

                /**
                 * Returns the raw JSON value of [quota].
                 *
                 * Unlike [quota], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("quota") @ExcludeMissing fun _quota(): JsonField<Quota> = quota

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
                     * Returns a mutable builder for constructing an instance of [Price].
                     *
                     * The following fields are required:
                     * ```java
                     * .currency()
                     * .recurring()
                     * .type()
                     * .unitAmount()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Price]. */
                class Builder internal constructor() {

                    private var currency: JsonField<String>? = null
                    private var recurring: JsonField<Recurring>? = null
                    private var type: JsonField<Type>? = null
                    private var unitAmount: JsonField<Double>? = null
                    private var plan: JsonField<Plan> = JsonMissing.of()
                    private var quota: JsonField<Quota> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(price: Price) = apply {
                        currency = price.currency
                        recurring = price.recurring
                        type = price.type
                        unitAmount = price.unitAmount
                        plan = price.plan
                        quota = price.quota
                        additionalProperties = price.additionalProperties.toMutableMap()
                    }

                    /** ISO currency code */
                    fun currency(currency: String) = currency(JsonField.of(currency))

                    /**
                     * Sets [Builder.currency] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.currency] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun currency(currency: JsonField<String>) = apply { this.currency = currency }

                    fun recurring(recurring: Recurring) = recurring(JsonField.of(recurring))

                    /**
                     * Sets [Builder.recurring] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.recurring] with a well-typed [Recurring]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun recurring(recurring: JsonField<Recurring>) = apply {
                        this.recurring = recurring
                    }

                    /** The type of the subscription */
                    fun type(type: Type) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

                    /** The unit amount in cents (or local equivalent) to be charged */
                    fun unitAmount(unitAmount: Double?) =
                        unitAmount(JsonField.ofNullable(unitAmount))

                    /**
                     * Alias for [Builder.unitAmount].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun unitAmount(unitAmount: Double) = unitAmount(unitAmount as Double?)

                    /** Alias for calling [Builder.unitAmount] with `unitAmount.orElse(null)`. */
                    fun unitAmount(unitAmount: Optional<Double>) =
                        unitAmount(unitAmount.getOrNull())

                    /**
                     * Sets [Builder.unitAmount] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.unitAmount] with a well-typed [Double] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun unitAmount(unitAmount: JsonField<Double>) = apply {
                        this.unitAmount = unitAmount
                    }

                    /** The name of the plan */
                    fun plan(plan: Plan) = plan(JsonField.of(plan))

                    /**
                     * Sets [Builder.plan] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.plan] with a well-typed [Plan] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun plan(plan: JsonField<Plan>) = apply { this.plan = plan }

                    fun quota(quota: Quota) = quota(JsonField.of(quota))

                    /**
                     * Sets [Builder.quota] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.quota] with a well-typed [Quota] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun quota(quota: JsonField<Quota>) = apply { this.quota = quota }

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
                     * Returns an immutable instance of [Price].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .currency()
                     * .recurring()
                     * .type()
                     * .unitAmount()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Price =
                        Price(
                            checkRequired("currency", currency),
                            checkRequired("recurring", recurring),
                            checkRequired("type", type),
                            checkRequired("unitAmount", unitAmount),
                            plan,
                            quota,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Price = apply {
                    if (validated) {
                        return@apply
                    }

                    currency()
                    recurring().validate()
                    type().validate()
                    unitAmount()
                    plan().ifPresent { it.validate() }
                    quota().ifPresent { it.validate() }
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
                    (if (currency.asKnown().isPresent) 1 else 0) +
                        (recurring.asKnown().getOrNull()?.validity() ?: 0) +
                        (type.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (unitAmount.asKnown().isPresent) 1 else 0) +
                        (plan.asKnown().getOrNull()?.validity() ?: 0) +
                        (quota.asKnown().getOrNull()?.validity() ?: 0)

                class Recurring
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val interval: JsonField<Interval>,
                    private val intervalCount: JsonField<Double>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("interval")
                        @ExcludeMissing
                        interval: JsonField<Interval> = JsonMissing.of(),
                        @JsonProperty("interval_count")
                        @ExcludeMissing
                        intervalCount: JsonField<Double> = JsonMissing.of(),
                    ) : this(interval, intervalCount, mutableMapOf())

                    /**
                     * The frequency at which a subscription is billed.
                     *
                     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun interval(): Optional<Interval> = interval.getOptional("interval")

                    /**
                     * The number of intervals between subscription billings
                     *
                     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun intervalCount(): Optional<Double> =
                        intervalCount.getOptional("interval_count")

                    /**
                     * Returns the raw JSON value of [interval].
                     *
                     * Unlike [interval], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("interval")
                    @ExcludeMissing
                    fun _interval(): JsonField<Interval> = interval

                    /**
                     * Returns the raw JSON value of [intervalCount].
                     *
                     * Unlike [intervalCount], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("interval_count")
                    @ExcludeMissing
                    fun _intervalCount(): JsonField<Double> = intervalCount

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
                         * Returns a mutable builder for constructing an instance of [Recurring].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Recurring]. */
                    class Builder internal constructor() {

                        private var interval: JsonField<Interval> = JsonMissing.of()
                        private var intervalCount: JsonField<Double> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(recurring: Recurring) = apply {
                            interval = recurring.interval
                            intervalCount = recurring.intervalCount
                            additionalProperties = recurring.additionalProperties.toMutableMap()
                        }

                        /** The frequency at which a subscription is billed. */
                        fun interval(interval: Interval) = interval(JsonField.of(interval))

                        /**
                         * Sets [Builder.interval] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.interval] with a well-typed [Interval]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun interval(interval: JsonField<Interval>) = apply {
                            this.interval = interval
                        }

                        /** The number of intervals between subscription billings */
                        fun intervalCount(intervalCount: Double) =
                            intervalCount(JsonField.of(intervalCount))

                        /**
                         * Sets [Builder.intervalCount] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.intervalCount] with a well-typed
                         * [Double] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun intervalCount(intervalCount: JsonField<Double>) = apply {
                            this.intervalCount = intervalCount
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Recurring].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Recurring =
                            Recurring(interval, intervalCount, additionalProperties.toMutableMap())
                    }

                    private var validated: Boolean = false

                    fun validate(): Recurring = apply {
                        if (validated) {
                            return@apply
                        }

                        interval().ifPresent { it.validate() }
                        intervalCount()
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
                        (interval.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (intervalCount.asKnown().isPresent) 1 else 0)

                    /** The frequency at which a subscription is billed. */
                    class Interval
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val DAY = of("day")

                            @JvmField val MONTH = of("month")

                            @JvmField val WEEK = of("week")

                            @JvmField val YEAR = of("year")

                            @JvmStatic fun of(value: String) = Interval(JsonField.of(value))
                        }

                        /** An enum containing [Interval]'s known values. */
                        enum class Known {
                            DAY,
                            MONTH,
                            WEEK,
                            YEAR,
                        }

                        /**
                         * An enum containing [Interval]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Interval] can contain an unknown value in a couple of
                         * cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            DAY,
                            MONTH,
                            WEEK,
                            YEAR,
                            /**
                             * An enum member indicating that [Interval] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                DAY -> Value.DAY
                                MONTH -> Value.MONTH
                                WEEK -> Value.WEEK
                                YEAR -> Value.YEAR
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws NuntlyInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                DAY -> Known.DAY
                                MONTH -> Known.MONTH
                                WEEK -> Known.WEEK
                                YEAR -> Known.YEAR
                                else -> throw NuntlyInvalidDataException("Unknown Interval: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws NuntlyInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                NuntlyInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Interval = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Interval && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Recurring &&
                            interval == other.interval &&
                            intervalCount == other.intervalCount &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(interval, intervalCount, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Recurring{interval=$interval, intervalCount=$intervalCount, additionalProperties=$additionalProperties}"
                }

                /** The type of the subscription */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val PLAN = of("plan")

                        @JvmField val ADDON = of("addon")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        PLAN,
                        ADDON,
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        PLAN,
                        ADDON,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            PLAN -> Value.PLAN
                            ADDON -> Value.ADDON
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws NuntlyInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            PLAN -> Known.PLAN
                            ADDON -> Known.ADDON
                            else -> throw NuntlyInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws NuntlyInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            NuntlyInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Type = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /** The name of the plan */
                class Plan @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val FREE = of("free")

                        @JvmField val STARTER = of("starter")

                        @JvmField val SCALE = of("scale")

                        @JvmField val ENTERPRISE = of("enterprise")

                        @JvmStatic fun of(value: String) = Plan(JsonField.of(value))
                    }

                    /** An enum containing [Plan]'s known values. */
                    enum class Known {
                        FREE,
                        STARTER,
                        SCALE,
                        ENTERPRISE,
                    }

                    /**
                     * An enum containing [Plan]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Plan] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        FREE,
                        STARTER,
                        SCALE,
                        ENTERPRISE,
                        /**
                         * An enum member indicating that [Plan] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            FREE -> Value.FREE
                            STARTER -> Value.STARTER
                            SCALE -> Value.SCALE
                            ENTERPRISE -> Value.ENTERPRISE
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws NuntlyInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            FREE -> Known.FREE
                            STARTER -> Known.STARTER
                            SCALE -> Known.SCALE
                            ENTERPRISE -> Known.ENTERPRISE
                            else -> throw NuntlyInvalidDataException("Unknown Plan: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws NuntlyInvalidDataException if this class instance's value does not
                     *   have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            NuntlyInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    fun validate(): Plan = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Plan && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                class Quota
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val daily: JsonField<Daily>,
                    private val monthly: JsonField<Monthly>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("daily")
                        @ExcludeMissing
                        daily: JsonField<Daily> = JsonMissing.of(),
                        @JsonProperty("monthly")
                        @ExcludeMissing
                        monthly: JsonField<Monthly> = JsonMissing.of(),
                    ) : this(daily, monthly, mutableMapOf())

                    /**
                     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun daily(): Daily = daily.getRequired("daily")

                    /**
                     * @throws NuntlyInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun monthly(): Monthly = monthly.getRequired("monthly")

                    /**
                     * Returns the raw JSON value of [daily].
                     *
                     * Unlike [daily], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("daily") @ExcludeMissing fun _daily(): JsonField<Daily> = daily

                    /**
                     * Returns the raw JSON value of [monthly].
                     *
                     * Unlike [monthly], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("monthly")
                    @ExcludeMissing
                    fun _monthly(): JsonField<Monthly> = monthly

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
                         * Returns a mutable builder for constructing an instance of [Quota].
                         *
                         * The following fields are required:
                         * ```java
                         * .daily()
                         * .monthly()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Quota]. */
                    class Builder internal constructor() {

                        private var daily: JsonField<Daily>? = null
                        private var monthly: JsonField<Monthly>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(quota: Quota) = apply {
                            daily = quota.daily
                            monthly = quota.monthly
                            additionalProperties = quota.additionalProperties.toMutableMap()
                        }

                        fun daily(daily: Daily) = daily(JsonField.of(daily))

                        /**
                         * Sets [Builder.daily] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.daily] with a well-typed [Daily] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun daily(daily: JsonField<Daily>) = apply { this.daily = daily }

                        fun monthly(monthly: Monthly) = monthly(JsonField.of(monthly))

                        /**
                         * Sets [Builder.monthly] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.monthly] with a well-typed [Monthly]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun monthly(monthly: JsonField<Monthly>) = apply { this.monthly = monthly }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Quota].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .daily()
                         * .monthly()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Quota =
                            Quota(
                                checkRequired("daily", daily),
                                checkRequired("monthly", monthly),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Quota = apply {
                        if (validated) {
                            return@apply
                        }

                        daily().validate()
                        monthly().validate()
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
                        (daily.asKnown().getOrNull()?.validity() ?: 0) +
                            (monthly.asKnown().getOrNull()?.validity() ?: 0)

                    class Daily
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val transacEmails: JsonField<Double>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("transac_emails")
                            @ExcludeMissing
                            transacEmails: JsonField<Double> = JsonMissing.of()
                        ) : this(transacEmails, mutableMapOf())

                        /**
                         * The quota of the emails subscribed (if applicable)
                         *
                         * @throws NuntlyInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

                        /**
                         * Returns the raw JSON value of [transacEmails].
                         *
                         * Unlike [transacEmails], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("transac_emails")
                        @ExcludeMissing
                        fun _transacEmails(): JsonField<Double> = transacEmails

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
                             * Returns a mutable builder for constructing an instance of [Daily].
                             *
                             * The following fields are required:
                             * ```java
                             * .transacEmails()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Daily]. */
                        class Builder internal constructor() {

                            private var transacEmails: JsonField<Double>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(daily: Daily) = apply {
                                transacEmails = daily.transacEmails
                                additionalProperties = daily.additionalProperties.toMutableMap()
                            }

                            /** The quota of the emails subscribed (if applicable) */
                            fun transacEmails(transacEmails: Double) =
                                transacEmails(JsonField.of(transacEmails))

                            /**
                             * Sets [Builder.transacEmails] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.transacEmails] with a well-typed
                             * [Double] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun transacEmails(transacEmails: JsonField<Double>) = apply {
                                this.transacEmails = transacEmails
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Daily].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .transacEmails()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Daily =
                                Daily(
                                    checkRequired("transacEmails", transacEmails),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Daily = apply {
                            if (validated) {
                                return@apply
                            }

                            transacEmails()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (transacEmails.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Daily &&
                                transacEmails == other.transacEmails &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(transacEmails, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Daily{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
                    }

                    class Monthly
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val transacEmails: JsonField<Double>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("transac_emails")
                            @ExcludeMissing
                            transacEmails: JsonField<Double> = JsonMissing.of()
                        ) : this(transacEmails, mutableMapOf())

                        /**
                         * The quota of the emails subscribed (if applicable)
                         *
                         * @throws NuntlyInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun transacEmails(): Double = transacEmails.getRequired("transac_emails")

                        /**
                         * Returns the raw JSON value of [transacEmails].
                         *
                         * Unlike [transacEmails], this method doesn't throw if the JSON field has
                         * an unexpected type.
                         */
                        @JsonProperty("transac_emails")
                        @ExcludeMissing
                        fun _transacEmails(): JsonField<Double> = transacEmails

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
                             * Returns a mutable builder for constructing an instance of [Monthly].
                             *
                             * The following fields are required:
                             * ```java
                             * .transacEmails()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Monthly]. */
                        class Builder internal constructor() {

                            private var transacEmails: JsonField<Double>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(monthly: Monthly) = apply {
                                transacEmails = monthly.transacEmails
                                additionalProperties = monthly.additionalProperties.toMutableMap()
                            }

                            /** The quota of the emails subscribed (if applicable) */
                            fun transacEmails(transacEmails: Double) =
                                transacEmails(JsonField.of(transacEmails))

                            /**
                             * Sets [Builder.transacEmails] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.transacEmails] with a well-typed
                             * [Double] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun transacEmails(transacEmails: JsonField<Double>) = apply {
                                this.transacEmails = transacEmails
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Monthly].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .transacEmails()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Monthly =
                                Monthly(
                                    checkRequired("transacEmails", transacEmails),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Monthly = apply {
                            if (validated) {
                                return@apply
                            }

                            transacEmails()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (transacEmails.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Monthly &&
                                transacEmails == other.transacEmails &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(transacEmails, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Monthly{transacEmails=$transacEmails, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Quota &&
                            daily == other.daily &&
                            monthly == other.monthly &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(daily, monthly, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Quota{daily=$daily, monthly=$monthly, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Price &&
                        currency == other.currency &&
                        recurring == other.recurring &&
                        type == other.type &&
                        unitAmount == other.unitAmount &&
                        plan == other.plan &&
                        quota == other.quota &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        currency,
                        recurring,
                        type,
                        unitAmount,
                        plan,
                        quota,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Price{currency=$currency, recurring=$recurring, type=$type, unitAmount=$unitAmount, plan=$plan, quota=$quota, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Phase &&
                    price == other.price &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(price, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Phase{price=$price, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Schedule &&
                created == other.created &&
                phases == other.phases &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(created, phases, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Schedule{created=$created, phases=$phases, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SubscriptionListResponse &&
            cancelAt == other.cancelAt &&
            cancelAtPeriodEnd == other.cancelAtPeriodEnd &&
            currentPeriodEnd == other.currentPeriodEnd &&
            currentPeriodStart == other.currentPeriodStart &&
            orgId == other.orgId &&
            price == other.price &&
            status == other.status &&
            type == other.type &&
            addon == other.addon &&
            plan == other.plan &&
            quota == other.quota &&
            schedule == other.schedule &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            cancelAt,
            cancelAtPeriodEnd,
            currentPeriodEnd,
            currentPeriodStart,
            orgId,
            price,
            status,
            type,
            addon,
            plan,
            quota,
            schedule,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SubscriptionListResponse{cancelAt=$cancelAt, cancelAtPeriodEnd=$cancelAtPeriodEnd, currentPeriodEnd=$currentPeriodEnd, currentPeriodStart=$currentPeriodStart, orgId=$orgId, price=$price, status=$status, type=$type, addon=$addon, plan=$plan, quota=$quota, schedule=$schedule, additionalProperties=$additionalProperties}"
}
