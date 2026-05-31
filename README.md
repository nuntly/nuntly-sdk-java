# nuntly-java

[![Maven Central](https://img.shields.io/maven-central/v/com.nuntly/nuntly-java.svg)](https://search.maven.org/artifact/com.nuntly/nuntly-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](./LICENSE)

The official Java 21 SDK for [Nuntly](https://nuntly.com), the developer-first email platform. Send transactional emails, manage domains, handle webhooks, and receive inbound mail with records, sealed interfaces, and pattern matching.

[Documentation](https://nuntly.com/docs) | [API Reference](https://nuntly.com/docs/api) | [Website](https://nuntly.com) | [Get your API key](https://nuntly.com/auth/sign-up)

**Requires Java 21+.** Uses records, sealed interfaces, pattern matching switch, and `java.net.http.HttpClient`.

## Installation

### Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation("com.nuntly:nuntly-java:0.0.1")
}
```

### Gradle (Groovy)

```groovy
dependencies {
    implementation 'com.nuntly:nuntly-java:0.0.1'
}
```

### Maven

```xml
<dependency>
    <groupId>com.nuntly</groupId>
    <artifactId>nuntly-java</artifactId>
    <version>0.0.1</version>
</dependency>
```

## Quick start

```java
import com.nuntly.sdk.*;
import com.nuntly.sdk.models.*;
import java.util.List;

var nuntly = Nuntly.create(ClientOptions.builder()
    .apiKey(System.getenv("NUNTLY_API_KEY"))
    .build());

var email = nuntly.emails().send(CreateEmailRequest.builder()
    .from("hello@yourcompany.com")
    .to(List.of("recipient@example.com"))
    .subject("Welcome to Nuntly")
    .html("<h1>Welcome!</h1><p>Your account is ready.</p>")
    .build());

System.out.println(email.id());
```

## Configuration

```java
var nuntly = Nuntly.create(ClientOptions.builder()
    .apiKey(System.getenv("NUNTLY_API_KEY"))
    .baseUrl("https://api.nuntly.com")       // optional
    .timeout(Duration.ofSeconds(30))          // optional, default: 60s
    .maxRetries(3)                            // optional, default: 2
    .backoff(BackoffStrategy.builder()        // optional
        .initialIntervalMs(200)
        .maxIntervalMs(30000)
        .exponent(1.5)
        .build())
    .debug(true)                              // optional
    .build());
```

## Pagination

```java
// Auto-paginate all items
for (var item : nuntly.emails().list()) {
    System.out.println(item.id() + " - " + item.status());
}

// Stream API
nuntly.emails().list().stream()
    .filter(e -> e.status() == EmailStatus.DELIVERED)
    .forEach(e -> System.out.println(e.id()));

// Manual pagination
var page = nuntly.emails().list();
System.out.println(page.data());
if (page.hasNextPage()) {
    var next = page.nextPage();
}
```

## Error handling

```java
import com.nuntly.sdk.ApiError.*;

try {
    nuntly.emails().retrieve("em_invalid");
} catch (ApiError e) {
    switch (e) {
        case NotFoundError nf -> System.out.println("Not found: " + nf.requestId());
        case RateLimitError rl -> System.out.println("Retry in: " + rl.retryAfter() + "ms");
        case AuthenticationError ae -> System.out.println("Invalid API key");
        default -> System.out.println("HTTP " + e.status() + ": " + e.getMessage());
    }

    // Raw response access
    System.out.println(e.rawResponse().statusCode());
}
```

## Lifecycle hooks

```java
var nuntly = Nuntly.create(ClientOptions.builder()
    .apiKey(System.getenv("NUNTLY_API_KEY"))
    .hooks(Hooks.builder()
        .onRequest(req -> System.err.println("-> " + req.method() + " " + req.uri()))
        .onResponse((res, req) -> System.err.println("<- " + res.statusCode()))
        .onRetry(ctx -> System.err.println("Retry #" + ctx.attempt()))
        .onError((err, req) -> logger.error("Failed: " + req.uri(), err))
        .build())
    .build());
```

## Raw response access

Inspect the underlying HTTP response on errors via `ApiError.rawResponse()`:

```java
try {
    nuntly.emails().retrieve("em_invalid");
} catch (ApiError e) {
    System.out.println(e.rawResponse().statusCode());
    System.out.println(e.rawResponse().headers().firstValue("x-request-id").orElse(""));
}
```

## Spring Boot

A separate auto-configuration starter wires `Nuntly` as a bean and binds settings from `application.yml` / `application.properties`:

```kotlin
dependencies {
    implementation("com.nuntly:nuntly-java-spring:0.0.1")
}
```

```yaml
# application.yml
nuntly:
  api-key: ${NUNTLY_API_KEY}
  base-url: https://api.nuntly.com  # optional
  timeout: 30s                       # optional
  max-retries: 3                     # optional
  debug: false                       # optional
```

```java
@Service
public class MailService {
  private final Nuntly nuntly;

  public MailService(Nuntly nuntly) { this.nuntly = nuntly; }
}
```

Override any extensibility point by declaring a single `@Bean`. The starter wires it into the underlying `ClientOptions`:

```java
@Bean Hooks hooks() {
  return Hooks.builder()
      .onRequest(req -> log.info("-> {} {}", req.method(), req.uri()))
      .build();
}

@Bean BackoffStrategy backoff() {
  return BackoffStrategy.builder().initialIntervalMs(200).build();
}

@Bean AppInfo appInfo() {
  return AppInfo.of("my-app", "1.4.2");
}
```

## Webhook verification

Verify a webhook signature and parse the payload into a typed event:

```java
import com.nuntly.sdk.lib.Webhook;
import com.nuntly.sdk.models.WebhookEvent;
import com.nuntly.sdk.models.WebhookEvent.*;

WebhookEvent event = Webhook.verify(payload, signatureHeader, secret);

switch (event) {
  case EmailBouncedEvent e -> handleBounce(e);
  case EmailDeliveredEvent e -> handleDelivered(e);
  case MessageReceivedEvent e -> handleReceive(e);
  default -> log.warn("Unhandled event type: {}", event.type());
}
```

`WebhookEvent` is a sealed interface; the compiler enforces exhaustive matching once every permitted subtype has a case.

## Error types

`NotFoundError`, `RateLimitError`, `AuthenticationError`, `PermissionDeniedError`, `ConflictError`, `BadRequestError`, `UnprocessableEntityError`, `InternalServerError`. All extend `ApiError`. See [`ApiError.java`](./core/src/main/java/com/nuntly/sdk/ApiError.java).

## License

MIT. See [LICENSE](./LICENSE).
