package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.broadcasts().send("bc_01kabn43yqyxn2bx4ve84mczd3", SendBroadcastRequest.builder()
 *     .scheduledAt("2026-03-30T09:00:00.000Z")
 *     .build());
 * }</pre>
 *
 * @param scheduledAt When to send. Omit to send immediately.
 */
public record SendBroadcastRequest(Optional<String> scheduledAt) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String scheduledAt;

    /** When to send. Omit to send immediately. */
    public Builder scheduledAt(String scheduledAt) {
      this.scheduledAt = scheduledAt;
      return this;
    }

    public SendBroadcastRequest build() {
      return new SendBroadcastRequest(Optional.ofNullable(scheduledAt));
    }
  }
}
