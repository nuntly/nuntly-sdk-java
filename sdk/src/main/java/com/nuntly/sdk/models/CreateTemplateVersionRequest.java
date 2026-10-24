package com.nuntly.sdk.models;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 * <pre>{@code
 * var result = nuntly.templates().versions().create(CreateTemplateVersionRequest.builder()
 *     .subject("Welcome to Nuntly")
 *     .html("<h1>Welcome!</h1>")
 *     .build());
 * }</pre>
 *
 * @param text The plain-text body.
 * @param variables Variables the content may reference, at most 20. Immutable once created.
 */
public record CreateTemplateVersionRequest(
    String subject, String html, Optional<String> text, List<VariableDeclaration> variables) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String subject;
    private String html;
    private String text;
    private List<VariableDeclaration> variables;

    public Builder subject(String subject) {
      this.subject = subject;
      return this;
    }

    public Builder html(String html) {
      this.html = html;
      return this;
    }

    /** The plain-text body. */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /** Variables the content may reference, at most 20. Immutable once created. */
    public Builder variables(List<VariableDeclaration> variables) {
      this.variables = variables;
      return this;
    }

    public CreateTemplateVersionRequest build() {
      return new CreateTemplateVersionRequest(subject, html, Optional.ofNullable(text), variables);
    }
  }
}
