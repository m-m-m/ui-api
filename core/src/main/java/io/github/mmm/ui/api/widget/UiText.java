/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.datatype.UiTextAlignment;

/**
 * {@link UiRegularWidget} that represents regular text.
 *
 * @since 1.0.0
 */
public interface UiText extends UiAtomicWidget, AttributeWriteText, UiNativeWidget {

  /**
   * @return the {@link UiTextAlignment}.
   */
  UiTextAlignment getAlignment();

  /**
   * @param alignment the new value of {@link #getAlignment()}.
   */
  void setAlignment(UiTextAlignment alignment);

  /**
   * @param context the {@link UiContext}.
   * @param text the {@link UiText#getText() text}.
   * @return the new {@link UiText}.
   */
  static UiText of(UiContext context, String text) {

    UiText widget = context.create(UiText.class);
    widget.setText(text);
    return widget;
  }

}