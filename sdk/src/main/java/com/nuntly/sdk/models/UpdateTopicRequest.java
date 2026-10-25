package com.nuntly.sdk.models;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.topics().update("tpc_01kabn43yqyxn2bx4ve84mczd3", UpdateTopicRequest.builder()
 *     .name("product updates")
 *     .build());
 * }</pre>
 *
 * @param name A name for the topic, shown to your team. Stored lowercased and trimmed.
 */
public record UpdateTopicRequest(String name) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;

    /** A name for the topic, shown to your team. Stored lowercased and trimmed. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public UpdateTopicRequest build() {
      return new UpdateTopicRequest(name);
    }
  }
}
