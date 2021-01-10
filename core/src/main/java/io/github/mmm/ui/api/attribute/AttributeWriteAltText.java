/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.UiLocalizer;

/**
 * Interface to {@link #getAltText() read} and {@link #setAltText(String) write} the {@link #getAltText() alternative
 * text}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteAltText {

  /**
   * @return the <em>alternative text</em> of this object. This text is used to provide the essential information of an
   *         object in textual form. E.g. if an image can NOT be displayed because it is missing, the alternative text
   *         is displayed instead. Further, accessibility tools such as screen-readers can use this information to help
   *         the user in order to better understand the meaning of an object. Will be the empty {@link String} if not
   *         set.
   */
  String getAltText();

  /**
   * @param altText is the new {@link #getAltText() alternative text}.
   */
  void setAltText(String altText);

  /**
   * @param widget the {@link AttributeWriteAltText} where to set the localized given {@code altText}.
   * @param altText the optional {@link #getAltText() altText} to {@link #setAltText(String) set}. May be {@code null}
   *        in which case this method has no effect.
   */
  static void setText(AttributeWriteAltText widget, String altText) {

    setText(widget, altText, null);
  }

  /**
   * @param widget the {@link AttributeWriteAltText} where to set the localized given {@code altText}.
   * @param altText the optional {@link #getAltText() altText} to {@link #setAltText(String) set}. May be {@code null}
   *        in which case this method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void setText(AttributeWriteAltText widget, String altText, Object context) {

    if (altText != null) {
      String l10n = UiLocalizer.get().localize(altText, context);
      widget.setAltText(l10n);
    }
  }

}
