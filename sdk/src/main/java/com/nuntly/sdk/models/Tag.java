package com.nuntly.sdk.models;

public record Tag(
    /** The name of the tag */
    String name,
    /** The tag to add to the email */
    String value) {}
