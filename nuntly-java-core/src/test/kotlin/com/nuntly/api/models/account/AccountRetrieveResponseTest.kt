// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.account

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountRetrieveResponseTest {

    @Test
    fun create() {
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .id("user_01jh6jk831bzen14edngw38we9")
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.249Z"))
                .displayName("Ray Tomlinson")
                .email("ray@info.tomlinson.ai")
                .kind(AccountRetrieveResponse.Kind.USER)
                .region(AccountRetrieveResponse.Region.EU_WEST_1)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.249Z"))
                .picture("picture")
                .build()

        assertThat(accountRetrieveResponse.id()).isEqualTo("user_01jh6jk831bzen14edngw38we9")
        assertThat(accountRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-09T22:22:41.249Z"))
        assertThat(accountRetrieveResponse.displayName()).isEqualTo("Ray Tomlinson")
        assertThat(accountRetrieveResponse.email()).isEqualTo("ray@info.tomlinson.ai")
        assertThat(accountRetrieveResponse.kind()).isEqualTo(AccountRetrieveResponse.Kind.USER)
        assertThat(accountRetrieveResponse.region())
            .isEqualTo(AccountRetrieveResponse.Region.EU_WEST_1)
        assertThat(accountRetrieveResponse.modifiedAt())
            .contains(OffsetDateTime.parse("2025-01-09T22:22:41.249Z"))
        assertThat(accountRetrieveResponse.picture()).contains("picture")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .id("user_01jh6jk831bzen14edngw38we9")
                .createdAt(OffsetDateTime.parse("2025-01-09T22:22:41.249Z"))
                .displayName("Ray Tomlinson")
                .email("ray@info.tomlinson.ai")
                .kind(AccountRetrieveResponse.Kind.USER)
                .region(AccountRetrieveResponse.Region.EU_WEST_1)
                .modifiedAt(OffsetDateTime.parse("2025-01-09T22:22:41.249Z"))
                .picture("picture")
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }
}
