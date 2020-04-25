/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link UiMutableSingleComposite Single composite widget} that represents a {@code slot}. A slot is a placeholder for
 * any {@link UiRegularWidget} (as a "sub-dialog") that may be embedded at this position. The widget itself will have no
 * other visual effect than showing its {@link #getChild() child} (if {@link #setChild(UiRegularWidget) set}).
 *
 * @since 1.0.0
 */
public interface UiSlot extends UiMutableSingleComposite<UiRegularWidget>, UiNativeWidget {

  /**
   * @param id the {@link #getId() ID}.
   * @return the new {@link UiSlot}.
   */
  static UiSlot of(String id) {

    UiSlot slot = UiWidgetFactoryNative.get().create(UiSlot.class);
    slot.setId(id);
    return slot;
  }

}
