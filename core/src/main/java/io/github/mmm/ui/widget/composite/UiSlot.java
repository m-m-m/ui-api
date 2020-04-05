/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;

/**
 * {@link UiMutableSingleComposite Single composite widget} that represents a {@code slot}. A slot is a placeholder for
 * any {@link UiRegularWidget} (as a "sub-dialog") that may be embedded at this position. The widget itself will have no
 * other visual effect than showing its {@link #getChild() child} (if {@link #setChild(UiRegularWidget) set}).
 *
 * @since 1.0.0
 */
public interface UiSlot extends UiMutableSingleComposite<UiRegularWidget>, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param id the {@link #getId() ID}.
   * @return the new {@link UiSlot}.
   */
  static UiSlot of(UiContext context, String id) {

    UiSlot slot = context.create(UiSlot.class);
    slot.setId(id);
    return slot;
  }

}
