/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget;

import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.datatype.UiTextAlignment;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;

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
   * @param text the {@link UiText#getText() text}.
   * @return the new {@link UiText}.
   */
  static UiText of(String text) {

    UiText widget = UiWidgetFactoryNative.get().create(UiText.class);
    if (text != null) {
      widget.setText(text);
    }
    return widget;
  }

}
