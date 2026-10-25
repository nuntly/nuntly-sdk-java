package com.nuntly.sdk.models;

import com.nuntly.sdk.JsonNullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var response = nuntly.broadcasts().update("bc_01kabn43yqyxn2bx4ve84mczd3", UpdateBroadcastRequest.builder()
 *     .name("October newsletter")
 *     .build());
 * }</pre>
 *
 * @param templateId Set to null to detach the template.
 * @param from The sender address, on a verified domain.
 * @param name Set to null to remove the name.
 * @param subject Set to null to fall back to the template version’s subject.
 * @param replyTo The email address where replies should be sent. If a recipient replies, the
 *     response will go to this address instead of the sender's email address
 * @param topicId Set to null to remove the topic.
 * @param segmentId Set to null to remove the segment.
 * @param variables Replaces the stored values. Send {} to clear them.
 * @param status Only draft is accepted.
 */
public record UpdateBroadcastRequest(
    JsonNullable<String> templateId,
    Optional<String> from,
    JsonNullable<String> name,
    JsonNullable<String> subject,
    JsonNullable<List<String>> replyTo,
    JsonNullable<String> topicId,
    JsonNullable<String> segmentId,
    Map<String, Object> variables,
    Optional<BroadcastStatus> status) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private JsonNullable<String> templateId = JsonNullable.absent();
    private String from;
    private JsonNullable<String> name = JsonNullable.absent();
    private JsonNullable<String> subject = JsonNullable.absent();
    private JsonNullable<List<String>> replyTo = JsonNullable.absent();
    private JsonNullable<String> topicId = JsonNullable.absent();
    private JsonNullable<String> segmentId = JsonNullable.absent();
    private Map<String, Object> variables;
    private BroadcastStatus status;

    /**
     * Sets {@code templateId}; {@code null} leaves it unset. Use {@link #clearTemplateId()} to send
     * null.
     */
    public Builder templateId(String templateId) {
      this.templateId = JsonNullable.ofNullable(templateId);
      return this;
    }

    /** Sends {@code templateId} as null. Set to null to detach the template. */
    public Builder clearTemplateId() {
      this.templateId = JsonNullable.ofNull();
      return this;
    }

    /** The sender address, on a verified domain. */
    public Builder from(String from) {
      this.from = from;
      return this;
    }

    /** Sets {@code name}; {@code null} leaves it unset. Use {@link #clearName()} to send null. */
    public Builder name(String name) {
      this.name = JsonNullable.ofNullable(name);
      return this;
    }

    /** Sends {@code name} as null. Set to null to remove the name. */
    public Builder clearName() {
      this.name = JsonNullable.ofNull();
      return this;
    }

    /**
     * Sets {@code subject}; {@code null} leaves it unset. Use {@link #clearSubject()} to send null.
     */
    public Builder subject(String subject) {
      this.subject = JsonNullable.ofNullable(subject);
      return this;
    }

    /**
     * Sends {@code subject} as null. Set to null to fall back to the template version’s subject.
     */
    public Builder clearSubject() {
      this.subject = JsonNullable.ofNull();
      return this;
    }

    /**
     * Sets {@code replyTo}; {@code null} leaves it unset. Use {@link #clearReplyTo()} to send null.
     */
    public Builder replyTo(List<String> replyTo) {
      this.replyTo = JsonNullable.ofNullable(replyTo);
      return this;
    }

    /**
     * Sends {@code replyTo} as null. The email address where replies should be sent. If a recipient
     * replies, the response will go to this address instead of the sender's email address
     */
    public Builder clearReplyTo() {
      this.replyTo = JsonNullable.ofNull();
      return this;
    }

    /**
     * Sets {@code topicId}; {@code null} leaves it unset. Use {@link #clearTopicId()} to send null.
     */
    public Builder topicId(String topicId) {
      this.topicId = JsonNullable.ofNullable(topicId);
      return this;
    }

    /** Sends {@code topicId} as null. Set to null to remove the topic. */
    public Builder clearTopicId() {
      this.topicId = JsonNullable.ofNull();
      return this;
    }

    /**
     * Sets {@code segmentId}; {@code null} leaves it unset. Use {@link #clearSegmentId()} to send
     * null.
     */
    public Builder segmentId(String segmentId) {
      this.segmentId = JsonNullable.ofNullable(segmentId);
      return this;
    }

    /** Sends {@code segmentId} as null. Set to null to remove the segment. */
    public Builder clearSegmentId() {
      this.segmentId = JsonNullable.ofNull();
      return this;
    }

    /** Replaces the stored values. Send {} to clear them. */
    public Builder variables(Map<String, Object> variables) {
      this.variables = variables;
      return this;
    }

    /** Only draft is accepted. */
    public Builder status(BroadcastStatus status) {
      this.status = status;
      return this;
    }

    public UpdateBroadcastRequest build() {
      return new UpdateBroadcastRequest(
          templateId,
          Optional.ofNullable(from),
          name,
          subject,
          replyTo,
          topicId,
          segmentId,
          variables,
          Optional.ofNullable(status));
    }
  }
}
