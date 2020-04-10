/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.widget;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiComposite;

/**
 * Abstract base implementation of {@link UiWidget}.
 *
 * @since 1.0.0
 */
public abstract class AbstractUiWidget implements UiWidget {

  /**
   * The constructor.
   */
  public AbstractUiWidget() {

    super();
  }

  /**
   * @param parent the new {@link #getParent() parent}.
   */
  protected abstract void setParent(UiComposite<?> parent);

  /**
   * @param widget the {@link UiWidget}.
   * @param parent the new {@link #getParent() parent}.
   * @see #setParent(UiComposite)
   */
  protected static void setParent(UiWidget widget, UiComposite<?> parent) {

    ((AbstractUiWidget) widget).setParent(parent);
  }

  /**
   * @return the unwrapped widget.
   * @see io.github.mmm.ui.api.widget.UiCustomWidget#getDelegate()
   */
  protected abstract UiNativeWidget unwrap();

  /**
   * @param <T> type of the expected widget.
   * @param widget the {@link UiWidget} to {@link #unwrap() unwrap}.
   * @return the unwrapped native widget.
   * @see #unwrap()
   */
  @SuppressWarnings("unchecked")
  protected <T extends UiNativeWidget> T unwrap(UiWidget widget) {

    if (widget == null) {
      return null;
    }
    return (T) ((AbstractUiWidget) widget).unwrap();
  }

  /**
   * Null-safe variant of {@link String#isEmpty()} for convenience.
   *
   * @param value the {@link String} to check.
   * @return {@code true} if the given {@link String} is {@code null} or {@link String#isEmpty() empty}, {@code false}
   *         otherwise.
   */
  public static boolean isEmpty(String value) {

    return (value == null) || value.isEmpty();
  }

}
