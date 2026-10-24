package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.broadcasts().create(CreateBroadcastRequest.builder()
 *     .from("hello@nuntly.com")
 *     .build());
 * }</pre>
 *
 * @param templateId The template to send.
 * @param from The sender address, on a verified domain.
 * @param name An internal label, shown only to your team.
 * @param subject The subject. Defaults to the template version’s subject.
 * @param replyTo The email address where replies should be sent. If a recipient replies, the
 *     response will go to this address instead of the sender's email address
 * @param topicId The topic to send to.
 * @param segmentId The segment to send to.
 * @param variables Variable values keyed by declared name.
 */
public record CreateBroadcastRequest(
    Optional<String> templateId,
    String from,
    Optional<String> name,
    Optional<String> subject,
    List<String> replyTo,
    Optional<String> topicId,
    Optional<String> segmentId,
    Map<String, Object> variables) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String templateId;
    private String from;
    private String name;
    private String subject;
    private List<String> replyTo;
    private String topicId;
    private String segmentId;
    private Map<String, Object> variables;

    /** The template to send. */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /** The sender address, on a verified domain. */
    public Builder from(String from) {
      this.from = from;
      return this;
    }

    /** An internal label, shown only to your team. */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /** The subject. Defaults to the template version’s subject. */
    public Builder subject(String subject) {
      this.subject = subject;
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

    /** The topic to send to. */
    public Builder topicId(String topicId) {
      this.topicId = topicId;
      return this;
    }

    /** The segment to send to. */
    public Builder segmentId(String segmentId) {
      this.segmentId = segmentId;
      return this;
    }

    /** Variable values keyed by declared name. */
    public Builder variables(Map<String, Object> variables) {
      this.variables = variables;
      return this;
    }

    public CreateBroadcastRequest build() {
      return new CreateBroadcastRequest(
          Optional.ofNullable(templateId),
          from,
          Optional.ofNullable(name),
          Optional.ofNullable(subject),
          replyTo,
          Optional.ofNullable(topicId),
          Optional.ofNullable(segmentId),
          variables);
    }
  }
}
