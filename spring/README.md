# nuntly-java-spring

Spring Boot 3 auto-configuration for the [Nuntly Java SDK](https://github.com/nuntly/nuntly-sdk-java).

Adds a single `Nuntly` bean to the application context, configurable via `application.yaml` or environment variables.

## Installation

```kotlin
dependencies {
    implementation("com.nuntly:nuntly-java-spring:0.0.1")
}
```

Requires Java 21 and Spring Boot 3.4+.

## Configuration

```yaml
nuntly:
  api-key: ${NUNTLY_API_KEY}
  base-url: https://api.nuntly.com   # optional
  timeout: 60s                       # optional
  max-retries: 2                     # optional
  retry-disabled: false              # optional
  debug: false                       # optional
```

If `nuntly.api-key` is not set, the SDK falls back to the `NUNTLY_API_KEY` environment variable.

## Usage

```java
import com.nuntly.sdk.Nuntly;
import com.nuntly.sdk.models.CreateEmailRequest;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WelcomeEmailService {
    private final Nuntly nuntly;

    public WelcomeEmailService(Nuntly nuntly) {
        this.nuntly = nuntly;
    }

    public void send(String to) {
        nuntly.emails().send(CreateEmailRequest.builder()
            .from("hello@example.com")
            .to(List.of(to))
            .subject("Welcome to Nuntly")
            .html("<p>Hello!</p>")
            .build());
    }
}
```

## Custom bean

Define your own `Nuntly` bean to override the auto-configured one:

```java
@Bean
Nuntly nuntly() {
    return Nuntly.create(ClientOptions.builder()
        .apiKey(System.getenv("NUNTLY_API_KEY"))
        .hooks(/* ... */)
        .build());
}
```
