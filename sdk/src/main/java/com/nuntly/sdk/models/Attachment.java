package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param content The base64-encoded content of the attachment
 * @param filename The name of the attached file to be displayed to the recipient
 * @param contentType Content type of the attachment (the MIME type)
 */
public record Attachment(String content, Optional<String> filename, Optional<String> contentType) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String content;
    private String filename;
    private String contentType;

    /** The base64-encoded content of the attachment */
    public Builder content(String content) {
      this.content = content;
      return this;
    }

    /** The name of the attached file to be displayed to the recipient */
    public Builder filename(String filename) {
      this.filename = filename;
      return this;
    }

    /** Content type of the attachment (the MIME type) */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    public Attachment build() {
      return new Attachment(
          content, Optional.ofNullable(filename), Optional.ofNullable(contentType));
    }
  }
}
