package com.nuntly.sdk.models;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.segments().update("seg_01kabn43yqyxn2bx4ve84mczd3", UpdateSegmentRequest.builder()
 *     .name("vip customers")
 *     .build());
 * }</pre>
 *
 * @param name A name for the segment, shown to your team. Stored lowercased and trimmed.
 */
public record UpdateSegmentRequest(String name) {

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

    public UpdateSegmentRequest build() {
      return new UpdateSegmentRequest(name);
    }
  }
}
