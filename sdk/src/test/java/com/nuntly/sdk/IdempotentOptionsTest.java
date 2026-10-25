package com.nuntly.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.RecordComponent;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

// Only the methods whose endpoint deduplicates by Idempotency-Key take a key.
class IdempotentOptionsTest {

  private static final Set<String> IDEMPOTENT_METHODS =
      Set.of(
          "Broadcasts.create",
          "Broadcasts.send",
          "EmailsBulk.send",
          "Emails.send",
          "Inboxes.create",
          "InboxesMessages.send",
          "Messages.forward",
          "Messages.reply");

  // Every operation takes per-request options; only the idempotent ones take a key with them.
  @Test
  void theIdempotentMethodsTakeIdempotentOptionsAndEveryOtherOneRequestOptions() {
    var operations = new TreeSet<String>();
    var withIdempotentOptions = new TreeSet<String>();
    var withPlainOptions = new TreeSet<String>();
    for (var resource : resourceClasses()) {
      for (Method method : resource.getDeclaredMethods()) {
        if (!Modifier.isPublic(method.getModifiers())) continue;
        // A sub-resource accessor, such as emails().bulk(), is no operation.
        if (Resource.class.isAssignableFrom(method.getReturnType())) continue;
        var params = Arrays.asList(method.getParameterTypes());
        var name = resource.getSimpleName() + "." + method.getName();
        operations.add(name);
        if (params.contains(IdempotentRequestOptions.class)) withIdempotentOptions.add(name);
        if (params.contains(RequestOptions.class)) withPlainOptions.add(name);
      }
    }

    assertEquals(new TreeSet<>(IDEMPOTENT_METHODS), withIdempotentOptions);
    var others = new TreeSet<>(operations);
    others.removeAll(IDEMPOTENT_METHODS);
    assertEquals(others, withPlainOptions);
  }

  // A public client call taking them would let any path be replayed as if deduplicated.
  @Test
  void noPublicClientCallTakesIdempotentOptions() {
    var publicCalls =
        Arrays.stream(NuntlyClient.class.getMethods())
            .filter(
                m -> Arrays.asList(m.getParameterTypes()).contains(IdempotentRequestOptions.class))
            .map(Method::getName)
            .toList();
    assertEquals(List.of(), publicCalls);
  }

  @Test
  void requestOptionsCarryNoIdempotencyKey() {
    var components =
        Arrays.stream(RequestOptions.class.getRecordComponents())
            .map(RecordComponent::getName)
            .toList();
    assertFalse(components.contains("idempotencyKey"));
    assertFalse(
        Arrays.stream(RequestOptions.Builder.class.getMethods())
            .anyMatch(m -> m.getName().equals("idempotencyKey")));
  }

  // Every resource reachable from Nuntly through its accessors, sub-resources included.
  private static Set<Class<?>> resourceClasses() {
    var found = new HashSet<Class<?>>();
    var queue = new ArrayDeque<Class<?>>();
    queue.add(Nuntly.class);
    while (!queue.isEmpty()) {
      for (Method accessor : queue.poll().getDeclaredMethods()) {
        var type = accessor.getReturnType();
        if (accessor.getParameterCount() == 0
            && Resource.class.isAssignableFrom(type)
            && found.add(type)) {
          queue.add(type);
        }
      }
    }
    return found;
  }
}
