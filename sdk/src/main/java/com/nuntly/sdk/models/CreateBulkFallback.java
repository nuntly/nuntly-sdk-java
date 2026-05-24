package com.nuntly.sdk.models;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record CreateBulkFallback(
    /** The e-mail address of the sender */
    Optional<String> from,
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
    Optional<String> subject,
    /** The plaintext version of the email */
    Optional<String> text,
    /** The HTML version of the email */
    Optional<String> html,
    /** The headers to add to the email */
    Map<String, String> headers,
    /** The tags to add to the email */
    List<Tag> tags,
    /** The variables for the template */
    Map<String, Object> variables) {}
