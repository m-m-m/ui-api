/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.attribute.AttributeReadSource;
import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} with a {@link #getSource() source}.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetWithSource extends UiWidget, AttributeReadSource {

  /**
   * @param source is the new {@link #getSource() source}.
   */
  void setSource(String source);

}
