package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param id The id of the attachment
 * @param filename The original filename.
 * @param contentType The MIME content type.
 * @param size The size in bytes.
 * @param contentDisposition The content disposition (inline or attachment).
 * @param contentId The CID for inline images.
 * @param downloadUrl Presigned download URL (included when retrieving a single attachment).
 */
public record AttachmentResponse(
    String id,
    Optional<String> filename,
    String contentType,
    long size,
    Optional<String> contentDisposition,
    Optional<String> contentId,
    Optional<String> downloadUrl) {}
