/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.UiLocalizer;

/**
 * Interface to {@link #getTitle() read} and {@link #setTitle(String) write} the {@link #getTitle() title}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteTitle extends AttributeReadTitle {

  /**
   * @param title the new value of {@link #getTitle() title}.
   */
  void setTitle(String title);

  /**
   * @param widget the {@link AttributeWriteTitle} where to set the localized given {@code title}.
   * @param title the optional {@link #getTitle() title} to {@link #setTitle(String) set}. May be {@code null} in which
   *        case this method has no effect.
   */
  static void setTitle(AttributeWriteTitle widget, String title) {

    setTitle(widget, title, null);
  }

  /**
   * @param widget the {@link AttributeWriteTitle} where to set the localized given {@code title}.
   * @param title the optional {@link #getTitle() title} to {@link #setTitle(String) set}. May be {@code null} in which
   *        case this method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void setTitle(AttributeWriteTitle widget, String title, Object context) {

    if (title != null) {
      String l10n = UiLocalizer.get().localize(title, context);
      widget.setTitle(l10n);
    }
  }

}
