package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class ClientOptionsTest {

  @Test
  void theCanonicalConstructorDropsATrailingSlashOfTheBaseUrl() {
    var options =
        new ClientOptions(
            "test_key",
            "https://api.nuntly.com/",
            ClientOptions.DEFAULT_TIMEOUT,
            ClientOptions.DEFAULT_MAX_RETRIES,
            BackoffStrategy.DEFAULT,
            true,
            false,
            Hooks.NONE,
            Optional.empty());

    assertEquals("https://api.nuntly.com", options.baseUrl());
  }
}
