package com.nuntly.sdk.spring;

import static org.assertj.core.api.Assertions.assertThat;

import com.nuntly.sdk.AppInfo;
import com.nuntly.sdk.BackoffStrategy;
import com.nuntly.sdk.Hooks;
import com.nuntly.sdk.Nuntly;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

class NuntlyAutoConfigurationTest {

  private final ApplicationContextRunner contextRunner =
      new ApplicationContextRunner()
          .withConfiguration(AutoConfigurations.of(NuntlyAutoConfiguration.class));

  @Test
  void registersNuntlyBeanWithApiKey() {
    contextRunner
        .withPropertyValues("nuntly.api-key=test-key")
        .run(
            context -> {
              assertThat(context).hasSingleBean(Nuntly.class);
              assertThat(context).hasSingleBean(NuntlyProperties.class);
            });
  }

  @Test
  void bindsPropertiesFromApplicationConfig() {
    contextRunner
        .withPropertyValues(
            "nuntly.api-key=test-key",
            "nuntly.base-url=https://staging.nuntly.com",
            "nuntly.timeout=30s",
            "nuntly.max-retries=5",
            "nuntly.debug=true")
        .run(
            context -> {
              NuntlyProperties props = context.getBean(NuntlyProperties.class);
              assertThat(props.getApiKey()).isEqualTo("test-key");
              assertThat(props.getBaseUrl()).isEqualTo("https://staging.nuntly.com");
              assertThat(props.getTimeout().toSeconds()).isEqualTo(30);
              assertThat(props.getMaxRetries()).isEqualTo(5);
              assertThat(props.isDebug()).isTrue();
            });
  }

  @Test
  void userBeanOverridesAutoConfiguredBean() {
    Nuntly userBean =
        Nuntly.create(com.nuntly.sdk.ClientOptions.builder().apiKey("user-key").build());
    contextRunner
        .withBean(Nuntly.class, () -> userBean)
        .run(context -> assertThat(context.getBean(Nuntly.class)).isSameAs(userBean));
  }

  // The optional Hooks / BackoffStrategy / AppInfo beans wire into the
  // ClientOptions builder via constructor injection. The SDK exposes no
  // public accessor to read them back from a Nuntly instance, so these
  // tests assert (a) the bean resolves without error when each override
  // is present and (b) the bean is still registered alongside the user
  // override (no `@ConditionalOnMissingBean` collision).

  @Test
  void resolvesWhenUserHooksBeanIsPresent() {
    Hooks userHooks = Hooks.NONE;
    contextRunner
        .withPropertyValues("nuntly.api-key=test-key")
        .withBean(Hooks.class, () -> userHooks)
        .run(
            context -> {
              assertThat(context).hasSingleBean(Nuntly.class);
              assertThat(context.getBean(Hooks.class)).isSameAs(userHooks);
            });
  }

  @Test
  void resolvesWhenUserBackoffStrategyBeanIsPresent() {
    BackoffStrategy userBackoff = BackoffStrategy.DEFAULT;
    contextRunner
        .withPropertyValues("nuntly.api-key=test-key")
        .withBean(BackoffStrategy.class, () -> userBackoff)
        .run(
            context -> {
              assertThat(context).hasSingleBean(Nuntly.class);
              assertThat(context.getBean(BackoffStrategy.class)).isSameAs(userBackoff);
            });
  }

  @Test
  void resolvesWhenUserAppInfoBeanIsPresent() {
    AppInfo userAppInfo = AppInfo.of("my-app", "9.9.9");
    contextRunner
        .withPropertyValues("nuntly.api-key=test-key")
        .withBean(AppInfo.class, () -> userAppInfo)
        .run(
            context -> {
              assertThat(context).hasSingleBean(Nuntly.class);
              assertThat(context.getBean(AppInfo.class)).isSameAs(userAppInfo);
            });
  }
}
