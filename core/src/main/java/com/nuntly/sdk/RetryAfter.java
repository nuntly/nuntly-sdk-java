package com.nuntly.sdk;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Pattern;

final class RetryAfter {
  private static final Pattern DELTA_SECONDS = Pattern.compile("\\d+(\\.\\d+)?");

  private RetryAfter() {}

  // `Retry-After` is decimal seconds or an HTTP-date (RFC 9110); a past date means no wait.
  static Optional<Long> parseMillis(String value) {
    var trimmed = value.trim();
    if (DELTA_SECONDS.matcher(trimmed).matches()) {
      return Optional.of(Math.round(Double.parseDouble(trimmed) * 1000));
    }
    try {
      var date = ZonedDateTime.parse(trimmed, DateTimeFormatter.RFC_1123_DATE_TIME);
      return Optional.of(Math.max(0, Duration.between(Instant.now(), date).toMillis()));
    } catch (DateTimeParseException ignored) {
      return Optional.empty();
    }
  }
}
