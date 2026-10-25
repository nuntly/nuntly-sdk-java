package com.nuntly.sdk.models;

import com.google.gson.annotations.JsonAdapter;
import com.nuntly.sdk.ExplicitNullTypeAdapterFactory;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.emails().send(CreateEmailRequest.builder()
 *     .from("Tomlinson AI <ray@info.tomlinson.ai>")
 *     .to(List.of("brian67@gmail.com"))
 *     .subject("Verify your email address")
 *     .text("Thank you for signing up! Please verify your email address.")
 *     .html("<h1>Welcome 🎉</h1><p>Thank you for signing up! Please verify your email address.</p>")
 *     .tags(List.of(Tag.builder().name("category").value("transactional").build()))
 *     .build());
 * }</pre>
 *
 * @param from The e-mail address of the sender
 * @param to The primary recipient(s) of the email
 * @param cc The carbon copy recipient(s) of the email
 * @param bcc The blind carbon copy recipient(s) of the email
 * @param replyTo The email address where replies should be sent. If a recipient replies, the
 *     response will go to this address instead of the sender's email address
 * @param subject The subject of the e-mail
 * @param text The plaintext version of the email
 * @param html The HTML version of the email
 * @param headers The headers to add to the email
 * @param tags The tags to add to the email
 * @param attachments The attachements to add to the email
 * @param variables The variables for the template
 * @param scheduledAt The date at which the email is scheduled to be sent
 */
public record CreateEmailRequest(
    String from,
    List<String> to,
    List<String> cc,
    List<String> bcc,
    List<String> replyTo,
    String subject,
    Optional<String> text,
    Optional<String> html,
    Map<String, String> headers,
    List<Tag> tags,
    List<Attachment> attachments,
    @JsonAdapter(ExplicitNullTypeAdapterFactory.MapNullValues.class) Map<String, Object> variables,
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
