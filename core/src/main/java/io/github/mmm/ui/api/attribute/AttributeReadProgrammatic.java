/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read an {@link #isProgrammatic() programmatic flag}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadProgrammatic {

  /**
   * @return {@code true} if this event was triggered by the program (e.g. via
   *         {@link io.github.mmm.ui.api.widget.attribute.UiWidgetWithClick#click()}), {@code false} if performed by an
   *         end-user interaction (e.g. keyboard, touch, or mouse).
   */
  boolean isProgrammatic();

}
