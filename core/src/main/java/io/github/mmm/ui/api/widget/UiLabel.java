/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget;

import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;

/**
 * {@link UiRegularWidget} that represents a label. A label is a very simple widget that displays some static text.
 *
 * @since 1.0.0
 */
public interface UiLabel extends UiAtomicWidget, AttributeWriteText, UiNativeWidget {

  /**
   * @param text the {@link UiLabel#getText() text}.
   * @return the new {@link UiLabel}.
   */
  static UiLabel of(String text) {

    UiLabel widget = UiWidgetFactoryNative.get().create(UiLabel.class);
    widget.setText(text);
    return widget;
  }

}
