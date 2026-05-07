package com.nuntly.sdk;

import java.util.Optional;

/**
 * Optional application info appended to the User-Agent for telemetry.
 *
 * <p>The wire format is {@code @nuntly/sdk-java/<version> (<name>/<version>) <runtime>}.
 *
 * <p>The {@code @nuntly/sdk-java} identifier is always preserved; AppInfo cannot remove or replace
 * it, only append to it.
 */
public record AppInfo(String name, Optional<String> version) {
  public AppInfo {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("AppInfo name is required");
    }
  }

  public static AppInfo of(String name) {
    return new AppInfo(name, Optional.empty());
  }

  public static AppInfo of(String name, String version) {
    return new AppInfo(name, Optional.ofNullable(version));
  }
}
