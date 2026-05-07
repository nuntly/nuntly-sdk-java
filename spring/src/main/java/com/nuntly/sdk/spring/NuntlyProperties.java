package com.nuntly.sdk.spring;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nuntly")
public class NuntlyProperties {

  /** Nuntly API key. Falls back to the NUNTLY_API_KEY environment variable. */
  private String apiKey;

  /** Base URL for the Nuntly API. Defaults to https://api.nuntly.com. */
  private String baseUrl;

  /** HTTP request timeout. Defaults to 60 seconds. */
  private Duration timeout;

  /** Maximum number of retries for failed requests. Defaults to 2. */
  private Integer maxRetries;

  /** Disables retry logic when true. */
  private boolean retryDisabled;

  /** Logs requests and responses when true. */
  private boolean debug;

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public Duration getTimeout() {
    return timeout;
  }

  public void setTimeout(Duration timeout) {
    this.timeout = timeout;
  }

  public Integer getMaxRetries() {
    return maxRetries;
  }

  public void setMaxRetries(Integer maxRetries) {
    this.maxRetries = maxRetries;
  }

  public boolean isRetryDisabled() {
    return retryDisabled;
  }

  public void setRetryDisabled(boolean retryDisabled) {
    this.retryDisabled = retryDisabled;
  }

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    this.debug = debug;
  }
}
