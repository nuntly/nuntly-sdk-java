package com.nuntly.sdk.spring;

import com.nuntly.sdk.AppInfo;
import com.nuntly.sdk.BackoffStrategy;
import com.nuntly.sdk.ClientOptions;
import com.nuntly.sdk.Hooks;
import com.nuntly.sdk.Nuntly;
import com.nuntly.sdk.Version;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;

@AutoConfiguration
@ConditionalOnClass(Nuntly.class)
@EnableConfigurationProperties(NuntlyProperties.class)
public class NuntlyAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public Nuntly nuntly(
      NuntlyProperties properties,
      @Nullable Hooks hooks,
      @Nullable BackoffStrategy backoff,
      @Nullable AppInfo appInfo) {
    ClientOptions.Builder builder = ClientOptions.builder();

    if (properties.getApiKey() != null) builder.apiKey(properties.getApiKey());
    if (properties.getBaseUrl() != null) builder.baseUrl(properties.getBaseUrl());
    if (properties.getTimeout() != null) builder.timeout(properties.getTimeout());
    if (properties.getMaxRetries() != null) builder.maxRetries(properties.getMaxRetries());
    if (properties.isRetryDisabled()) builder.disableRetry();
    if (properties.isDebug()) builder.debug(true);

    if (hooks != null) builder.hooks(hooks);
    if (backoff != null) builder.backoff(backoff);
    // The user-provided AppInfo wins; otherwise we stamp the starter so the
    // outbound User-Agent advertises the Spring Boot integration.
    builder.appInfo(
        appInfo != null ? appInfo : AppInfo.of("@nuntly/sdk-java-spring", Version.SDK_VERSION));

    return Nuntly.create(builder.build());
  }
}
