package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.inboxes().update(UpdateInboxRequest.builder()
 *     .build());
 * }</pre>
 */
public record UpdateInboxRequest(
    /** The display name of the inbox. */
    java.util.Optional<String> name) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;

    /** The display name of the inbox. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public UpdateInboxRequest build() {
      return new UpdateInboxRequest(Optional.ofNullable(name));
    }
  }
}
