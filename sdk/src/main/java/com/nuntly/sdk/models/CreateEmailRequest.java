package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
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
    List<String> to,
    /** The carbon copy recipient(s) of the email */
    List<String> cc,
    /** The blind carbon copy recipient(s) of the email */
    List<String> bcc,
    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     */
    List<String> replyTo,
    /** The subject of the e-mail */
    String subject,
    /** The plaintext version of the email */
    Optional<String> text,
    /** The HTML version of the email */
    Optional<String> html,
    /** The headers to add to the email */
    Map<String, String> headers,
    /** The tags to add to the email */
    List<Tag> tags,
    /** The attachements to add to the email */
    List<Attachment> attachments,
    /** The variables for the template */
    Map<String, Object> variables,
    /** The date at which the email is scheduled to be sent */
    Optional<String> scheduledAt) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private List<String> replyTo;
    private String subject;
    private String text;
    private String html;
    private Map<String, String> headers;
    private List<Tag> tags;
    private List<Attachment> attachments;
    private Map<String, Object> variables;
    private String scheduledAt;

    /** The e-mail address of the sender */
    public Builder from(String from) {
      this.from = from;
      return this;
    }

    /** The primary recipient(s) of the email */
    public Builder to(List<String> to) {
      this.to = to;
      return this;
    }

    /** The carbon copy recipient(s) of the email */
    public Builder cc(List<String> cc) {
      this.cc = cc;
      return this;
    }

    /** The blind carbon copy recipient(s) of the email */
    public Builder bcc(List<String> bcc) {
      this.bcc = bcc;
      return this;
    }

    /**
     * The email address where replies should be sent. If a recipient replies, the response will go
     * to this address instead of the sender's email address
     */
    public Builder replyTo(List<String> replyTo) {
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
    public Builder headers(Map<String, String> headers) {
      this.headers = headers;
      return this;
    }

    /** The tags to add to the email */
    public Builder tags(List<Tag> tags) {
      this.tags = tags;
      return this;
    }

    /** The attachements to add to the email */
    public Builder attachments(List<Attachment> attachments) {
      this.attachments = attachments;
      return this;
    }

    /** The variables for the template */
    public Builder variables(Map<String, Object> variables) {
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
          cc,
          bcc,
          replyTo,
          subject,
          Optional.ofNullable(text),
          Optional.ofNullable(html),
          headers,
          tags,
          attachments,
          variables,
          Optional.ofNullable(scheduledAt));
    }
  }
}
