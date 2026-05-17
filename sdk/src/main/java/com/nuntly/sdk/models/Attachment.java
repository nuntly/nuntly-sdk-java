package com.nuntly.sdk.models;

import java.util.Optional;

public record Attachment(
    /** The base64-encoded content of the attachment */
    String content,
    /** The name of the attached file to be displayed to the recipient */
    Optional<String> filename,
    /** Content type of the attachment (the MIME type) */
    Optional<String> contentType) {}
