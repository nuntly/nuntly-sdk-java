// File generated from our OpenAPI spec by Stainless.

package com.nuntly.models.organizations.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageRetrieveResponseTest {

    @Test
    fun create() {
        val usageRetrieveResponse =
            UsageRetrieveResponse.builder()
                .daily(
                    UsageRetrieveResponse.Daily.builder()
                        .consumed(
                            UsageRetrieveResponse.Daily.Consumed.builder()
                                .transacEmails(0.0)
                                .build()
                        )
                        .period("period")
                        .quota(
                            UsageRetrieveResponse.Daily.Quota.builder().transacEmails(0.0).build()
                        )
                        .build()
                )
                .monthly(
                    UsageRetrieveResponse.Monthly.builder()
                        .consumed(
                            UsageRetrieveResponse.Monthly.Consumed.builder()
                                .transacEmails(0.0)
                                .build()
                        )
                        .period("period")
                        .quota(
                            UsageRetrieveResponse.Monthly.Quota.builder().transacEmails(0.0).build()
                        )
                        .build()
                )
                .build()

        assertThat(usageRetrieveResponse.daily())
            .isEqualTo(
                UsageRetrieveResponse.Daily.builder()
                    .consumed(
                        UsageRetrieveResponse.Daily.Consumed.builder().transacEmails(0.0).build()
                    )
                    .period("period")
                    .quota(UsageRetrieveResponse.Daily.Quota.builder().transacEmails(0.0).build())
                    .build()
            )
        assertThat(usageRetrieveResponse.monthly())
            .isEqualTo(
                UsageRetrieveResponse.Monthly.builder()
                    .consumed(
                        UsageRetrieveResponse.Monthly.Consumed.builder().transacEmails(0.0).build()
                    )
                    .period("period")
                    .quota(UsageRetrieveResponse.Monthly.Quota.builder().transacEmails(0.0).build())
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageRetrieveResponse =
            UsageRetrieveResponse.builder()
                .daily(
                    UsageRetrieveResponse.Daily.builder()
                        .consumed(
                            UsageRetrieveResponse.Daily.Consumed.builder()
                                .transacEmails(0.0)
                                .build()
                        )
                        .period("period")
                        .quota(
                            UsageRetrieveResponse.Daily.Quota.builder().transacEmails(0.0).build()
                        )
                        .build()
                )
                .monthly(
                    UsageRetrieveResponse.Monthly.builder()
                        .consumed(
                            UsageRetrieveResponse.Monthly.Consumed.builder()
                                .transacEmails(0.0)
                                .build()
                        )
                        .period("period")
                        .quota(
                            UsageRetrieveResponse.Monthly.Quota.builder().transacEmails(0.0).build()
                        )
                        .build()
                )
                .build()

        val roundtrippedUsageRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageRetrieveResponse),
                jacksonTypeRef<UsageRetrieveResponse>(),
            )

        assertThat(roundtrippedUsageRetrieveResponse).isEqualTo(usageRetrieveResponse)
    }
}
