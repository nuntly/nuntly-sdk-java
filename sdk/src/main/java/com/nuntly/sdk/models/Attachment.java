package com.nuntly.sdk.models;

public record Attachment(
    /** The base64-encoded content of the attachment */
    String content,
    /** The name of the attached file to be displayed to the recipient */
    java.util.Optional<String> filename,
    /** Content type of the attachment (the MIME type) */
    java.util.Optional<String> contentType) {}
