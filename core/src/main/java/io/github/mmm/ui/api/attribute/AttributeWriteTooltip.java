/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.UiLocalizer;

/**
 * Interface to {@link #getTooltip() read} and {@link #setTooltip(String) write} the {@link #getTooltip() tooltip}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteTooltip {

  /**
   * @return the text of this object. It is a brief description that explains this object to the end-user. Will be the
   *         empty {@link String} if no tooltip is specified.
   */
  String getTooltip();

  /**
   * @param tooltip is the new value of {@link #getTooltip()}.
   */
  void setTooltip(String tooltip);

  /**
   * @param widget the {@link AttributeWriteTooltip} where to set the localized given {@code tooltip}.
   * @param tooltip the optional {@link #getTooltip() tooltip} to {@link #setTooltip(String) set}. May be {@code null}
   *        in which case this method has no effect.
   */
  static void setTooltip(AttributeWriteTooltip widget, String tooltip) {

    setText(widget, tooltip, null);
  }

  /**
   * @param widget the {@link AttributeWriteTooltip} where to set the localized given {@code tooltip}.
   * @param tooltip the optional {@link #getTooltip() tooltip} to {@link #setTooltip(String) set}. May be {@code null}
   *        in which case this method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void setText(AttributeWriteTooltip widget, String tooltip, Object context) {

    if (tooltip != null) {
      String l10n = UiLocalizer.get().localize(tooltip, context);
      widget.setTooltip(l10n);
    }
  }

}
