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
    implementation("com.nuntly:nuntly-java:2.0.0")
}
```

### Gradle (Groovy)

```groovy
dependencies {
    implementation 'com.nuntly:nuntly-java:2.0.0'
}
```

### Maven

```xml
<dependency>
    <groupId>com.nuntly</groupId>
    <artifactId>nuntly-java</artifactId>
    <version>2.0.0</version>
</dependency>
```

The SDK brings in Gson 2.x as an API dependency, and a few of its public methods use Gson types: `ApiError.details()` returns an `Optional<JsonElement>`, `NuntlyClient.gson()` returns the configured `Gson`, and `ExplicitNullTypeAdapterFactory` is a Gson `TypeAdapterFactory`. These stay on Gson 2.x for the whole 2.x line. Moving them off Gson is planned for 3.0.

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
    .timeout(Duration.ofSeconds(30))          // optional, default: 60s, Duration.ZERO for none
    .maxRetries(3)                            // optional, default: 2
    .backoff(BackoffStrategy.builder()        // optional
        .initialIntervalMs(200)
        .maxIntervalMs(30000)
        .exponent(1.5)
        .build())
    .debug(true)                              // optional
    .build());
```

### Retries

A failed request is retried up to `maxRetries` times (2 by default) on a 408, a 429, a 500, a 502, a 503, a 504 or an `IOException` (connection reset, timeout). The first retry waits 375 to 500 ms and each later one twice as long, up to 8 s (`BackoffStrategy.DEFAULT`: 500 ms initial interval, exponent 2, jitter that shortens each delay to 75% to 100% of it).

- A 409 is retried only when the API sends `x-should-retry: true`, as on `idempotency_key_in_progress`: the first attempt of a keyed send still holds the key, and the retry gets its stored response. Any other conflict, such as `contact_already_exists`, does not resolve on its own.
- A `POST` or a `PATCH` is retried only on a 429, so a retry cannot create a duplicate. The exception is the methods the API deduplicates by `Idempotency-Key`: `emails().send()`, `emails().bulk().send()`, `messages().reply()`, `messages().forward()`, `inboxes().messages().send()`, `inboxes().create()`, `broadcasts().create()` and `broadcasts().send()` send your key or generate one, and are also retried on a 408, a 5xx or an `IOException`. An `Idempotency-Key` header on another request does not change its retries.
- A server-sent `x-should-retry: true|false` overrides these rules. A `Retry-After` (seconds, decimals allowed, or an HTTP-date) on any response replaces the backoff delay; above 60 s the SDK does not wait and throws the error for that response at once, with `RateLimitError.retryAfter()` set on a 429.
- An exception thrown by a hook is never retried.

Call `disableRetry()` on the builder to turn retries off.

### Per-request options

Every resource method has an overload that takes a `RequestOptions` as its last argument, to change the timeout, the maximum retries or the headers of one call:

```java
var email = nuntly.emails().retrieve("em_01k8a1b2c3", RequestOptions.builder()
    .timeout(Duration.ofSeconds(10))
    .maxRetries(0)
    .headers(Map.of("X-Trace-Id", "checkout-1042"))
    .build());
```

### Idempotency keys

The methods whose endpoint deduplicates by key take an `IdempotentRequestOptions` instead, with the same settings and the key. Pass your own key to deduplicate across processes:

```java
var email = nuntly.emails().send(request, IdempotentRequestOptions.builder()
    .idempotencyKey("order-1042-confirmation")
    .build());
```

No other method takes an idempotency key: the API would ignore it.

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

// Page size, cursor and filters go in a params record
var inboxes = nuntly.inboxes().list(InboxesListParams.builder()
    .limit(20)
    .namespaceId("ns_01ka8k8s80gvx9604cn9am5st4")
    .build());

// Manual pagination
var page = nuntly.emails().list();
System.out.println(page.data());
if (page.hasNextPage()) {
    var next = page.nextPage();
}
```

## Clearing a field

A field the API accepts as `null` (for example a broadcast `templateId`, `topicId` or `segmentId`) has a `clearX()` builder method that sends `null`. Fields you do not set, or set to `null`, stay out of the request and keep their value.

```java
nuntly.broadcasts().update(broadcastId, UpdateBroadcastRequest.builder()
    .clearSegmentId()            // sends "segmentId": null
    .subject("Spring sale")      // templateId, topicId... are left unchanged
    .build());

// A null map value removes a contact property. Map.of() rejects null: use a HashMap.
var properties = new HashMap<String, Object>();
properties.put("plan", null);
nuntly.contacts().update(contactId, UpdateContactRequest.builder().properties(properties).build());
```

Contact `properties`, agent `memory` and email `variables` send a `null` map value (a `null` template variable renders as empty text). Email `headers` and broadcast `variables` drop a `null` value from the request, because the API rejects `null` there.

## Error handling

```java
import com.nuntly.sdk.ApiError;
import com.nuntly.sdk.ApiError.*;

try {
    nuntly.emails().retrieve("em_invalid");
} catch (ApiError e) {
    switch (e) {
        case NotFoundError nf -> System.out.println("Not found: " + nf.requestId().orElse("?"));
        case RateLimitError rl -> System.out.println("Retry in: " + rl.retryAfter().orElse(0L) + "ms");
        case AuthenticationError ae -> System.out.println("Invalid API key");
        default -> System.out.println("HTTP " + e.status() + " " + e.code() + ": " + e.title());
    }

    // Raw response access
    System.out.println(e.rawResponse().statusCode());
}
```

Every `ApiError` exposes `status()`, `code()` (for example `invalid_body`), `title()`, `details()`, `headers()`, `requestId()` and `rawResponse()`. When the body is not the API error JSON, such as a proxy's HTML page, `code()` is `unknown` and `title()` holds its first 200 characters.

A 2xx response whose body is empty or not a JSON object, such as a captive portal page, throws a plain `NuntlyError`: the API may have applied the request, so check before sending it again.

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

For one request, the hooks run in this order: `onRequest` before every attempt, `onRetry` before each retry, `onResponse` once on the final response, then `onSuccess` on a 2xx or `onError`. The request a hook receives, also through `response.request()` and `ApiError.rawResponse().request()`, carries `Authorization: Bearer [redacted]`, and `ClientOptions.toString()` hides the key: no hook argument, log line or error carries the API key.

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
    implementation("com.nuntly:nuntly-java-spring:2.0.0")
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
import com.nuntly.sdk.models.*;

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

A request that gets no response throws `ConnectionError`, and `ConnectionError.TimeoutError` when it exceeds the timeout.

## Upgrading

Upgrading from 1.x? See [MIGRATION.md](MIGRATION.md).

## License

MIT. See [LICENSE](./LICENSE).
