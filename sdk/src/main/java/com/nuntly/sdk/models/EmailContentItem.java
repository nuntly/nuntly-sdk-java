package com.nuntly.sdk.models;

import java.util.Optional;

/**
 * @param downloadUrl Presigned download URL.
 * @param size Uncompressed size in bytes.
 * @param expiresAt When the URL expires.
 */
public record EmailContentItem(String downloadUrl, Optional<Long> size, String expiresAt) {}
