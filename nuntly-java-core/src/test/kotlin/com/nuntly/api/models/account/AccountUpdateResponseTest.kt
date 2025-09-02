// File generated from our OpenAPI spec by Stainless.

package com.nuntly.api.models.account

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.nuntly.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountUpdateResponseTest {

    @Test
    fun create() {
        val accountUpdateResponse =
            AccountUpdateResponse.builder()
                .id("user_01jh6jk831bzen14edngw38we9")
                .kind(AccountUpdateResponse.Kind.USER)
                .build()

        assertThat(accountUpdateResponse.id()).isEqualTo("user_01jh6jk831bzen14edngw38we9")
        assertThat(accountUpdateResponse.kind()).isEqualTo(AccountUpdateResponse.Kind.USER)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountUpdateResponse =
            AccountUpdateResponse.builder()
                .id("user_01jh6jk831bzen14edngw38we9")
                .kind(AccountUpdateResponse.Kind.USER)
                .build()

        val roundtrippedAccountUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountUpdateResponse),
                jacksonTypeRef<AccountUpdateResponse>(),
            )

        assertThat(roundtrippedAccountUpdateResponse).isEqualTo(accountUpdateResponse)
    }
}
