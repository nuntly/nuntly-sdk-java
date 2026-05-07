package com.nuntly.sdk;

import java.time.Duration;
import java.util.Optional;

public record ClientOptions(
    String apiKey,
    String baseUrl,
    Duration timeout,
    int maxRetries,
    BackoffStrategy backoff,
    boolean retryEnabled,
    boolean debug,
    Hooks hooks,
    Optional<AppInfo> appInfo) {
  public static final String DEFAULT_BASE_URL = "https://api.nuntly.com";
  public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(60);
  public static final int DEFAULT_MAX_RETRIES = 2;

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String apiKey;
    private String baseUrl;
    private Duration timeout;
    private Integer maxRetries;
    private BackoffStrategy backoff;
    private boolean retryEnabled = true;
    private boolean debug;
    private Hooks hooks;
    private AppInfo appInfo;

    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    public Builder timeout(Duration timeout) {
      this.timeout = timeout;
      return this;
    }

    public Builder maxRetries(int maxRetries) {
      this.maxRetries = maxRetries;
      return this;
    }

    public Builder backoff(BackoffStrategy backoff) {
      this.backoff = backoff;
      return this;
    }

    public Builder disableRetry() {
      this.retryEnabled = false;
      return this;
    }

    public Builder debug(boolean debug) {
      this.debug = debug;
      return this;
    }

    public Builder hooks(Hooks hooks) {
      this.hooks = hooks;
      return this;
    }

    public Builder appInfo(AppInfo appInfo) {
      this.appInfo = appInfo;
      return this;
    }

    public ClientOptions build() {
      var key = apiKey != null ? apiKey : System.getenv("NUNTLY_API_KEY");
      if (key == null || key.isBlank()) {
        throw new IllegalArgumentException(
            "API key is required. Pass it via builder().apiKey() or set the NUNTLY_API_KEY"
                + " environment variable.");
      }
      return new ClientOptions(
          key,
          Optional.ofNullable(baseUrl)
              .orElse(
                  Optional.ofNullable(System.getenv("NUNTLY_BASE_URL")).orElse(DEFAULT_BASE_URL)),
          Optional.ofNullable(timeout).orElse(DEFAULT_TIMEOUT),
          Optional.ofNullable(maxRetries).orElse(DEFAULT_MAX_RETRIES),
          Optional.ofNullable(backoff).orElse(BackoffStrategy.DEFAULT),
          retryEnabled,
          debug,
          Optional.ofNullable(hooks).orElse(Hooks.NONE),
          Optional.ofNullable(appInfo));
    }
  }
}
