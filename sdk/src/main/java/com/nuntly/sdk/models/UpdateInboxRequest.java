package com.nuntly.sdk.models;

import com.nuntly.sdk.JsonNullable;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.inboxes().update(UpdateInboxRequest.builder()
 *     .build());
 * }</pre>
 *
 * @param name The display name of the inbox.
 */
public record UpdateInboxRequest(JsonNullable<String> name) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private JsonNullable<String> name = JsonNullable.absent();

    /** Sets {@code name}; {@code null} leaves it unset. Use {@link #clearName()} to send null. */
    public Builder name(String name) {
      this.name = JsonNullable.ofNullable(name);
      return this;
    }

    /** Sends {@code name} as null. The display name of the inbox. */
    public Builder clearName() {
      this.name = JsonNullable.ofNull();
      return this;
    }

    public UpdateInboxRequest build() {
      return new UpdateInboxRequest(name);
    }
  }
}
