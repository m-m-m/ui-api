/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.UiLocalizer;

/**
 * Interface to {@link #getText() read} and {@link #setText(String) write} the {@link #getText() text}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteText extends AttributeReadText {

  /**
   * @param text is the new {@link #getText() text} to set.
   */
  void setText(String text);

  /**
   * @param widget the {@link AttributeWriteText} where to set the localized given {@code text}.
   * @param text the optional {@link #getText() text} to {@link #setText(String) set}. May be {@code null} in which
   *        case this method has no effect.
   */
  static void setText(AttributeWriteText widget, String text) {

    setText(widget, text, null);
  }

  /**
   * @param widget the {@link AttributeWriteText} where to set the localized given {@code text}.
   * @param text the optional {@link #getText() text} to {@link #setText(String) set}. May be {@code null} in which
   *        case this method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void setText(AttributeWriteText widget, String text, Object context) {

    if (text != null) {
      String l10n = UiLocalizer.get().localize(text, context);
      widget.setText(l10n);
    }
  }

}
