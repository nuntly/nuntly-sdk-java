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
                .transactional(
                    UsageRetrieveResponse.Transactional.builder()
                        .limits(
                            UsageRetrieveResponse.Transactional.Limits.builder()
                                .daily(0.0)
                                .monthly(0.0)
                                .build()
                        )
                        .usage(
                            UsageRetrieveResponse.Transactional.Usage.builder()
                                .daily(0.0)
                                .monthly(0.0)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(usageRetrieveResponse.transactional())
            .isEqualTo(
                UsageRetrieveResponse.Transactional.builder()
                    .limits(
                        UsageRetrieveResponse.Transactional.Limits.builder()
                            .daily(0.0)
                            .monthly(0.0)
                            .build()
                    )
                    .usage(
                        UsageRetrieveResponse.Transactional.Usage.builder()
                            .daily(0.0)
                            .monthly(0.0)
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageRetrieveResponse =
            UsageRetrieveResponse.builder()
                .transactional(
                    UsageRetrieveResponse.Transactional.builder()
                        .limits(
                            UsageRetrieveResponse.Transactional.Limits.builder()
                                .daily(0.0)
                                .monthly(0.0)
                                .build()
                        )
                        .usage(
                            UsageRetrieveResponse.Transactional.Usage.builder()
                                .daily(0.0)
                                .monthly(0.0)
                                .build()
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
