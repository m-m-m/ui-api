/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.window;

import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.attribute.AttributeReadPosition;
import io.github.mmm.ui.api.attribute.AttributeReadSize;
import io.github.mmm.ui.api.attribute.AttributeWritePlaceholder;
import io.github.mmm.ui.api.attribute.AttributeWriteResizable;
import io.github.mmm.ui.api.attribute.AttributeWriteTitle;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;

/**
 * {@link UiMutableComposite} that represents a <em>window</em>.
 *
 * @since 1.0.0
 */
public abstract interface UiAbstractWindow
    extends UiMutableComposite<UiRegularWidget>, AttributeWriteTitle, AttributeWriteResizable {

  @Override
  UiAbstractWindow getParent();

  /**
   * @param window is the potential descendant of this window. May be {@code null}.
   * @return the ancestor of the given {@link UiChildWindow} that has this window as parent. Will be {@code null} if no
   *         such window was found (the given {@link UiChildWindow} is {@code null} or not a descendant of this window).
   */
  default UiAbstractWindow findChild(UiChildWindow window) {

    if (window == null) {
      return null;
    }
    UiAbstractWindow current = window;
    while (current != null) {
      UiAbstractWindow currentParent = current.getParent();
      if (currentParent == this) {
        return current;
      }
      current = currentParent;
    }
    return null;
  }

  /**
   * @return access to read and write the position of this window.
   */
  AttributeReadPosition getPosition();

  /**
   * @return access to read and write the size of this window.
   */
  AttributeReadSize getSize();

  /**
   * Opens this window by setting {@link #isVisible() visible} to {@code true}.
   */
  default void open() {

    setVisible(true);
  }

  /**
   * Opens this window by setting {@link #isVisible() visible} to {@code false}.
   */
  default void close() {

    setVisible(false);
  }

  /**
   * @param window the {@link UiAbstractWindow} to initialize with the given {@code title}.
   * @param title the {@link #getTitle() title} to {@link #setTitle(String) set}. May be {@code null} in which case this
   *        method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void initTitle(UiAbstractWindow window, String title) {

    initTitle(window, title, null);
  }

  /**
   * @param window the {@link UiAbstractWindow} to initialize with the given {@code title}.
   * @param title the {@link #getTitle() title} to {@link #setTitle(String) set}. May be {@code null} in which case this
   *        method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void initTitle(UiAbstractWindow window, String title, Object context) {

    if (title != null) {
      String l10n = UiLocalizer.get().localize(title, context);
      window.setTitle(l10n);
      if (window instanceof AttributeWritePlaceholder) {
        ((AttributeWritePlaceholder) window).setPlaceholder(l10n);
      }
    }
  }

}
