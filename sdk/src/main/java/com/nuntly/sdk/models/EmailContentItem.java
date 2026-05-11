package com.nuntly.sdk.models;

public record EmailContentItem(
    /** Presigned download URL. */
    String downloadUrl,
    /** Uncompressed size in bytes. */
    long size,
    /** When the URL expires. */
    String expiresAt) {}
