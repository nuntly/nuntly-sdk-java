package com.nuntly.sdk.models;

import java.util.Optional;

public record AttachmentResponse(
    /** The id of the attachment */
    String id,
    /** The original filename. */
    String filename,
    /** The MIME content type. */
    String contentType,
    /** The size in bytes. */
    long size,
    /** The content disposition (inline or attachment). */
    String contentDisposition,
    /** The CID for inline images. */
    String contentId,
    /** Presigned download URL (included when retrieving a single attachment). */
    Optional<String> downloadUrl) {}
