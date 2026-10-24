package com.nuntly.sdk.models;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.segments().create(CreateSegmentRequest.builder()
 *     .name("example.com")
 *     .build());
 * }</pre>
 *
 * @param name A name for the segment, shown to your team. Stored lowercased and trimmed.
 */
public record CreateSegmentRequest(String name) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;

    /** A name for the segment, shown to your team. Stored lowercased and trimmed. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public CreateSegmentRequest build() {
      return new CreateSegmentRequest(name);
    }
  }
}
