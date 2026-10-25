package com.nuntly.sdk.models;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.topics().create(CreateTopicRequest.builder()
 *     .name("product updates")
 *     .build());
 * }</pre>
 *
 * @param name A name for the topic, shown to your team. Stored lowercased and trimmed.
 */
public record CreateTopicRequest(String name) {

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

    public CreateTopicRequest build() {
      return new CreateTopicRequest(name);
    }
  }
}
