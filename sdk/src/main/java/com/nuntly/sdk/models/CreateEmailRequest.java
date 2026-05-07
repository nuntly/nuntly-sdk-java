package com.nuntly.sdk.models;

import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.emails().send(CreateEmailRequest.builder()
 *     .from("hello@nuntly.com")
 *     .to(List.of("user@example.com"))
 *     .subject("Welcome to Nuntly")
 *     .build());
 * }</pre>
 */
public record CreateEmailRequest(
    /** The e-mail address of the sender */
    String from,
    /** The primary recipient(s) of the email */
    java.util.List<String> to,
    /** The carbon copy recipient(s) of the email */
    java.util.Optional<java.util.List<String>> cc,
    /** The blind carbon copy recipient(s) of the email */
    java.util.Optional<java.util.List<String>> bcc,
    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     */
    java.util.Optional<java.util.List<String>> replyTo,
    /** The subject of the e-mail */
    String subject,
    /** The plaintext version of the email */
    java.util.Optional<String> text,
    /** The HTML version of the email */
    java.util.Optional<String> html,
    /** The headers to add to the email */
    java.util.Optional<java.util.Map<String, Object>> headers,
    /** The tags to add to the email */
    java.util.Optional<java.util.List<java.util.Map<String, Object>>> tags,
    /** The attachements to add to the email */
    java.util.Optional<java.util.List<java.util.Map<String, Object>>> attachments,
    /** The variables for the template */
    java.util.Optional<java.util.Map<String, Object>> variables,
    /** The date at which the email is scheduled to be sent */
    java.util.Optional<String> scheduledAt) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String from;
    private java.util.List<String> to;
    private java.util.List<String> cc;
    private java.util.List<String> bcc;
    private java.util.List<String> replyTo;
    private String subject;
    private String text;
    private String html;
    private java.util.Map<String, Object> headers;
    private java.util.List<java.util.Map<String, Object>> tags;
    private java.util.List<java.util.Map<String, Object>> attachments;
    private java.util.Map<String, Object> variables;
    private String scheduledAt;

    /** The e-mail address of the sender */
    public Builder from(String from) {
      this.from = from;
      return this;
    }

    /** The primary recipient(s) of the email */
    public Builder to(java.util.List<String> to) {
      this.to = to;
      return this;
    }

    /** The carbon copy recipient(s) of the email */
    public Builder cc(java.util.List<String> cc) {
      this.cc = cc;
      return this;
    }

    /** The blind carbon copy recipient(s) of the email */
    public Builder bcc(java.util.List<String> bcc) {
      this.bcc = bcc;
      return this;
    }

    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     */
    public Builder replyTo(java.util.List<String> replyTo) {
      this.replyTo = replyTo;
      return this;
    }

    /** The subject of the e-mail */
    public Builder subject(String subject) {
      this.subject = subject;
      return this;
    }

    /** The plaintext version of the email */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /** The HTML version of the email */
    public Builder html(String html) {
      this.html = html;
      return this;
    }

    /** The headers to add to the email */
    public Builder headers(java.util.Map<String, Object> headers) {
      this.headers = headers;
      return this;
    }

    /** The tags to add to the email */
    public Builder tags(java.util.List<java.util.Map<String, Object>> tags) {
      this.tags = tags;
      return this;
    }

    /** The attachements to add to the email */
    public Builder attachments(java.util.List<java.util.Map<String, Object>> attachments) {
      this.attachments = attachments;
      return this;
    }

    /** The variables for the template */
    public Builder variables(java.util.Map<String, Object> variables) {
      this.variables = variables;
      return this;
    }

    /** The date at which the email is scheduled to be sent */
    public Builder scheduledAt(String scheduledAt) {
      this.scheduledAt = scheduledAt;
      return this;
    }

    public CreateEmailRequest build() {
      return new CreateEmailRequest(
          from,
          to,
          Optional.ofNullable(cc),
          Optional.ofNullable(bcc),
          Optional.ofNullable(replyTo),
          subject,
          Optional.ofNullable(text),
          Optional.ofNullable(html),
          Optional.ofNullable(headers),
          Optional.ofNullable(tags),
          Optional.ofNullable(attachments),
          Optional.ofNullable(variables),
          Optional.ofNullable(scheduledAt));
    }
  }
}
