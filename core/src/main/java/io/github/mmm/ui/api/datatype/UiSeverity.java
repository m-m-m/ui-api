/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype;

/**
 * This is the interface that represents the <em>severity</em> of a message. The severity defines the default title and
 * icon to use for e.g. a message popup window. We do NOT use an enum here to allow custom extension. However, we do NOT
 * just use a {@link String} instead to make signatures more explicit and for better documentation. <br>
 * The following severities are predefined:
 * <ul>
 * <li>{@link #INFORMATION}</li>
 * <li>{@link #WARNING}</li>
 * <li>{@link #ERROR}</li>
 * <li>{@link #QUESTION}</li>
 * </ul>
 * Implementations should ignore unsupported icons or use a fallback.
 *
 * @since 1.0.0
 */
public class UiSeverity {

  /** {@link UiSeverity} indicating an general purpose information. */
  public static final UiSeverity INFORMATION = new UiSeverity("information");

  /** {@link UiSeverity} indicating a warning. */
  public static final UiSeverity WARNING = new UiSeverity("warning");

  /** {@link UiSeverity} indicating an error. */
  public static final UiSeverity ERROR = new UiSeverity("error");

  /** {@link UiSeverity} indicating a question. */
  public static final UiSeverity QUESTION = new UiSeverity("question");

  private final String name;

  /**
   * The constructor.
   *
   * @param name the {@link #getName() name}.
   */
  public UiSeverity(String name) {

    super();
    this.name = name;
  }

  /**
   * @return the name identifying this icon. Depending on the implementation it may be mapped to an actual image URL or
   *         just concatenated with prefix and suffix.
   */
  public String getName() {

    return this.name;
  }

}
