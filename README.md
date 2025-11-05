# Nuntly Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.nuntly/nuntly-java)](https://central.sonatype.com/artifact/com.nuntly/nuntly-java/0.2.0)
[![javadoc](https://javadoc.io/badge2/com.nuntly/nuntly-java/0.2.0/javadoc.svg)](https://javadoc.io/doc/com.nuntly/nuntly-java/0.2.0)

<!-- x-release-please-end -->

The Nuntly Java SDK provides convenient access to the [Nuntly REST API](http://developers.nuntly.com) from applications written in Java.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

The REST API documentation can be found on [developers.nuntly.com](http://developers.nuntly.com). Javadocs are available on [javadoc.io](https://javadoc.io/doc/com.nuntly/nuntly-java/0.2.0).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.nuntly:nuntly-java:0.2.0")
```

### Maven

```xml
<dependency>
  <groupId>com.nuntly</groupId>
  <artifactId>nuntly-java</artifactId>
  <version>0.2.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;
import com.nuntly.models.emails.EmailSendParams;
import com.nuntly.models.emails.EmailSendResponse;

// Configures using the `nuntly.apiKey` and `nuntly.baseUrl` system properties
// Or configures using the `NUNTLY_API_KEY` and `NUNTLY_BASE_URL` environment variables
NuntlyClient client = NuntlyOkHttpClient.fromEnv();

EmailSendParams params = EmailSendParams.builder()
    .from("ray@info.tomlinson.ai")
    .subject("Verify Your Email Address")
    .to("brian67@gmail.com")
    .text("Thank you for signing up! Please verify your email address...")
    .build();
EmailSendResponse email = client.emails().send(params);
```

## Client configuration

Configure the client using system properties or environment variables:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;

// Configures using the `nuntly.apiKey` and `nuntly.baseUrl` system properties
// Or configures using the `NUNTLY_API_KEY` and `NUNTLY_BASE_URL` environment variables
NuntlyClient client = NuntlyOkHttpClient.fromEnv();
```

Or manually:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;

NuntlyClient client = NuntlyOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;

NuntlyClient client = NuntlyOkHttpClient.builder()
    // Configures using the `nuntly.apiKey` and `nuntly.baseUrl` system properties
    // Or configures using the `NUNTLY_API_KEY` and `NUNTLY_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter    | System property  | Environment variable | Required | Default value                 |
| --------- | ---------------- | -------------------- | -------- | ----------------------------- |
| `apiKey`  | `nuntly.apiKey`  | `NUNTLY_API_KEY`     | false    | -                             |
| `baseUrl` | `nuntly.baseUrl` | `NUNTLY_BASE_URL`    | true     | `"https://api.eu.nuntly.com"` |

System properties take precedence over environment variables.

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import com.nuntly.client.NuntlyClient;

NuntlyClient clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Nuntly API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.emails().send(...)` should be called with an instance of `EmailSendParams`, and it will return an instance of `EmailSendResponse`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;
import com.nuntly.models.emails.EmailSendParams;
import com.nuntly.models.emails.EmailSendResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `nuntly.apiKey` and `nuntly.baseUrl` system properties
// Or configures using the `NUNTLY_API_KEY` and `NUNTLY_BASE_URL` environment variables
NuntlyClient client = NuntlyOkHttpClient.fromEnv();

EmailSendParams params = EmailSendParams.builder()
    .from("ray@info.tomlinson.ai")
    .subject("Verify Your Email Address")
    .to("brian67@gmail.com")
    .text("Thank you for signing up! Please verify your email address...")
    .build();
CompletableFuture<EmailSendResponse> email = client.async().emails().send(params);
```

Or create an asynchronous client from the beginning:

```java
import com.nuntly.client.NuntlyClientAsync;
import com.nuntly.client.okhttp.NuntlyOkHttpClientAsync;
import com.nuntly.models.emails.EmailSendParams;
import com.nuntly.models.emails.EmailSendResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `nuntly.apiKey` and `nuntly.baseUrl` system properties
// Or configures using the `NUNTLY_API_KEY` and `NUNTLY_BASE_URL` environment variables
NuntlyClientAsync client = NuntlyOkHttpClientAsync.fromEnv();

EmailSendParams params = EmailSendParams.builder()
    .from("ray@info.tomlinson.ai")
    .subject("Verify Your Email Address")
    .to("brian67@gmail.com")
    .text("Thank you for signing up! Please verify your email address...")
    .build();
CompletableFuture<EmailSendResponse> email = client.emails().send(params);
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.nuntly.core.http.Headers;
import com.nuntly.core.http.HttpResponseFor;
import com.nuntly.models.apikeys.ApiKeyCreateParams;
import com.nuntly.models.apikeys.ApiKeyCreateResponse;

HttpResponseFor<ApiKeyCreateResponse> apiKey = client.apiKeys().withRawResponse().create();

int statusCode = apiKey.statusCode();
Headers headers = apiKey.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.nuntly.models.apikeys.ApiKeyCreateResponse;

ApiKeyCreateResponse parsedApiKey = apiKey.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`NuntlyServiceException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/NuntlyServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                              |
  | ------ | ---------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/UnexpectedStatusCodeException.kt) |

- [`NuntlyIoException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/NuntlyIoException.kt): I/O networking errors.

- [`NuntlyRetryableException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/NuntlyRetryableException.kt): Generic error indicating a failure that could be retried by the client.

- [`NuntlyInvalidDataException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/NuntlyInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`NuntlyException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/NuntlyException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Pagination

The SDK defines methods that return a paginated lists of results. It provides convenient ways to access the results either one page at a time or item-by-item across all pages.

### Auto-pagination

To iterate through all results across all pages, use the `autoPager()` method, which automatically fetches more pages as needed.

When using the synchronous client, the method returns an [`Iterable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)

```java
import com.nuntly.models.emails.EmailListPage;
import com.nuntly.models.emails.EmailListResponse;

EmailListPage page = client.emails().list();

// Process as an Iterable
for (EmailListResponse email : page.autoPager()) {
    System.out.println(email);
}

// Process as a Stream
page.autoPager()
    .stream()
    .limit(50)
    .forEach(email -> System.out.println(email));
```

When using the asynchronous client, the method returns an [`AsyncStreamResponse`](nuntly-java-core/src/main/kotlin/com/nuntly/core/http/AsyncStreamResponse.kt):

```java
import com.nuntly.core.http.AsyncStreamResponse;
import com.nuntly.models.emails.EmailListPageAsync;
import com.nuntly.models.emails.EmailListResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

CompletableFuture<EmailListPageAsync> pageFuture = client.async().emails().list();

pageFuture.thenRun(page -> page.autoPager().subscribe(email -> {
    System.out.println(email);
}));

// If you need to handle errors or completion of the stream
pageFuture.thenRun(page -> page.autoPager().subscribe(new AsyncStreamResponse.Handler<>() {
    @Override
    public void onNext(EmailListResponse email) {
        System.out.println(email);
    }

    @Override
    public void onComplete(Optional<Throwable> error) {
        if (error.isPresent()) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error.get());
        } else {
            System.out.println("No more!");
        }
    }
}));

// Or use futures
pageFuture.thenRun(page -> page.autoPager()
    .subscribe(email -> {
        System.out.println(email);
    })
    .onCompleteFuture()
    .whenComplete((unused, error) -> {
        if (error != null) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error);
        } else {
            System.out.println("No more!");
        }
    }));
```

### Manual pagination

To access individual page items and manually request the next page, use the `items()`,
`hasNextPage()`, and `nextPage()` methods:

```java
import com.nuntly.models.emails.EmailListPage;
import com.nuntly.models.emails.EmailListResponse;

EmailListPage page = client.emails().list();
while (true) {
    for (EmailListResponse email : page.items()) {
        System.out.println(email);
    }

    if (!page.hasNextPage()) {
        break;
    }

    page = page.nextPage();
}
```

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `NUNTLY_LOG` environment variable to `info`:

```sh
$ export NUNTLY_LOG=info
```

Or to `debug` for more verbose logging:

```sh
$ export NUNTLY_LOG=debug
```

## ProGuard and R8

Although the SDK uses reflection, it is still usable with [ProGuard](https://github.com/Guardsquare/proguard) and [R8](https://developer.android.com/topic/performance/app-optimization/enable-app-optimization) because `nuntly-java-core` is published with a [configuration file](nuntly-java-core/src/main/resources/META-INF/proguard/nuntly-java-core.pro) containing [keep rules](https://www.guardsquare.com/manual/configuration/usage).

ProGuard and R8 should automatically detect and use the published rules, but you can also manually copy the keep rules if necessary.

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`NuntlyOkHttpClient`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClient.kt) or [`NuntlyOkHttpClientAsync`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff between requests.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a request.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;

NuntlyClient client = NuntlyOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.nuntly.models.apikeys.ApiKeyCreateResponse;

ApiKeyCreateResponse apiKey = client.apiKeys().create(RequestOptions.builder().timeout(Duration.ofSeconds(30)).build());
```

Or configure the default for all method calls at the client level:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;
import java.time.Duration;

NuntlyClient client = NuntlyOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

NuntlyClient client = NuntlyOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;

NuntlyClient client = NuntlyOkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `nuntly-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`NuntlyClient`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClient.kt), [`NuntlyClientAsync`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientAsync.kt), [`NuntlyClientImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientImpl.kt), and [`NuntlyClientAsyncImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientAsyncImpl.kt), all of which can work with any HTTP client
- `nuntly-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`NuntlyOkHttpClient`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClient.kt) and [`NuntlyOkHttpClientAsync`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClientAsync.kt), which provide a way to construct [`NuntlyClientImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientImpl.kt) and [`NuntlyClientAsyncImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientAsyncImpl.kt), respectively, using OkHttp
- `nuntly-java`
  - Depends on and exposes the APIs of both `nuntly-java-core` and `nuntly-java-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`nuntly-java` dependency](#installation) with `nuntly-java-core`
2. Copy `nuntly-java-client-okhttp`'s [`OkHttpClient`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`NuntlyClientImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientImpl.kt) or [`NuntlyClientAsyncImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientAsyncImpl.kt), similarly to [`NuntlyOkHttpClient`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClient.kt) or [`NuntlyOkHttpClientAsync`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`nuntly-java` dependency](#installation) with `nuntly-java-core`
2. Write a class that implements the [`HttpClient`](nuntly-java-core/src/main/kotlin/com/nuntly/core/http/HttpClient.kt) interface
3. Construct [`NuntlyClientImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientImpl.kt) or [`NuntlyClientAsyncImpl`](nuntly-java-core/src/main/kotlin/com/nuntly/client/NuntlyClientAsyncImpl.kt), similarly to [`NuntlyOkHttpClient`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClient.kt) or [`NuntlyOkHttpClientAsync`](nuntly-java-client-okhttp/src/main/kotlin/com/nuntly/client/okhttp/NuntlyOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.nuntly.core.JsonValue;
import com.nuntly.models.emails.EmailSendParams;

EmailSendParams params = EmailSendParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set undocumented parameters on _nested_ headers, query params, or body classes, call the `putAdditionalProperty` method on the nested class:

```java
import com.nuntly.core.JsonValue;
import com.nuntly.models.emails.bulk.BulkSendParams;

BulkSendParams params = BulkSendParams.builder()
    .fallback(BulkSendParams.Fallback.builder()
        .putAdditionalProperty("secretProperty", JsonValue.from("42"))
        .build())
    .build();
```

These properties can be accessed on the nested built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](nuntly-java-core/src/main/kotlin/com/nuntly/core/Values.kt) object to its setter:

```java
import com.nuntly.core.JsonValue;
import com.nuntly.models.emails.EmailSendParams;

EmailSendParams params = EmailSendParams.builder()
    .from(JsonValue.from(42))
    .subject("Verify Your Email Address")
    .to("brian67@gmail.com")
    .text("Thank you for signing up! Please verify your email address...")
    .build();
```

The most straightforward way to create a [`JsonValue`](nuntly-java-core/src/main/kotlin/com/nuntly/core/Values.kt) is using its `from(...)` method:

```java
import com.nuntly.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](nuntly-java-core/src/main/kotlin/com/nuntly/core/Values.kt):

```java
import com.nuntly.core.JsonMissing;
import com.nuntly.models.emails.EmailSendParams;

EmailSendParams params = EmailSendParams.builder()
    .subject("Welcome to Tomlinson AI!")
    .to("carlo43@gmail.com")
    .from(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.nuntly.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.emails().send(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.nuntly.core.JsonField;
import java.util.Optional;

JsonField<String> from = client.emails().send(params)._from();

if (from.isMissing()) {
  // The property is absent from the JSON response
} else if (from.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = from.asString();

  // Try to deserialize into a custom type
  MyClass myObject = from.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`NuntlyInvalidDataException`](nuntly-java-core/src/main/kotlin/com/nuntly/errors/NuntlyInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.nuntly.models.emails.EmailSendResponse;

EmailSendResponse email = client.emails().send(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.nuntly.models.emails.EmailSendResponse;

EmailSendResponse email = client.emails().send(
  params, RequestOptions.builder().responseValidation(true).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.nuntly.client.NuntlyClient;
import com.nuntly.client.okhttp.NuntlyOkHttpClient;

NuntlyClient client = NuntlyOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/nuntly/nuntly-sdk-java/issues) with questions, bugs, or suggestions.
