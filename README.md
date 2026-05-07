# nuntly-java

[![Maven Central](https://img.shields.io/maven-central/v/com.nuntly/nuntly-java.svg)](https://search.maven.org/artifact/com.nuntly/nuntly-java)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](./LICENSE)

The official Java 21 SDK for [Nuntly](https://nuntly.com), the developer-first email platform. Send transactional emails, manage domains, handle webhooks, and receive inbound mail with records, sealed interfaces, and pattern matching.

[Documentation](https://nuntly.com/docs) | [API Reference](https://nuntly.com/docs/api) | [Website](https://nuntly.com) | [Get your API key](https://app.nuntly.com/signup)

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
    .filter(e -> "delivered".equals(e.status()))
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

```java
var email = nuntly.emails().retrieve("em_123");
var response = nuntly.emails().withResponse(email);
System.out.println(response.data().status());
System.out.println(response.response().headers().firstValue("x-request-id"));
```

## Resources

- `nuntly.emails()` - send, retrieve, list, cancel
  - `.stats()` - retrieve
  - `.events()` - list
  - `.content()` - retrieve
  - `.bulk()` - send, list
- `nuntly.domains()` - create, retrieve, list, update, delete
- `nuntly.webhooks()` - create, retrieve, list, update, delete
  - `.events()` - list, replay, deliveries
- `nuntly.organizations()` - retrieve, list
  - `.usage()` - retrieve
- `nuntly.inboxes()` - create, retrieve, list, update, delete
- `nuntly.agents()` - memory
- `nuntly.threads()` - retrieve, update
  - `.messages()` - list
- `nuntly.messages()` - retrieve, list, reply, forward
  - `.content()` - retrieve
  - `.attachments()` - list, retrieve
- `nuntly.namespaces()` - create, retrieve, list, update, delete
- `nuntly.apiKeys()` - create, retrieve, list, update, delete

## License

MIT. See [LICENSE](./LICENSE).
