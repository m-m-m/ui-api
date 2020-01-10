/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiComposite;

/**
 * {@link Enum} with the available modes defining which hierarchical properties a
 * {@link io.github.mmm.ui.widget.composite.UiComposite} will propagate to its children.
 *
 * @see UiComposite#getPropagation()
 * @since 1.0.0
 */
public enum UiPropagation {

  /** No property is propagated. */
  NONE,

  /** Only {@link io.github.mmm.ui.widget.UiWidget#isVisible() visible} property is propagated. */
  VISIBLE,

  /** Only {@link io.github.mmm.ui.widget.UiWidget#isEnabled() enabled} property is propagated. */
  ENABLED,

  /**
   * Both {@link io.github.mmm.ui.widget.UiWidget#isVisible() visible} and
   * {@link io.github.mmm.ui.widget.UiWidget#isEnabled() enabled} are propagated.
   */
  VISIBLE_AND_ENABLED;

  /**
   * @return {@code true} if visible state is propagated, {@code false} otherwise.
   */
  public boolean isVisible() {

    return (this == VISIBLE) || (this == VISIBLE_AND_ENABLED);
  }

  /**
   * @return {@code true} if enabled state is propagated, {@code false} otherwise.
   */
  public boolean isEnabled() {

    return (this == ENABLED) || (this == VISIBLE_AND_ENABLED);
  }

  /**
   * @param widget the {@link UiWidget} that has updated its parent.
   */
  @SuppressWarnings("null")
  public void updateParent(UiWidget widget) {

    UiComposite<?> parent = widget.getParent();
    UiPropagation newPropagation = UiPropagation.NONE;
    if (parent != null) {
      newPropagation = parent.getPropagation();
    }
    boolean enabled = true;
    if (newPropagation.isEnabled()) {
      enabled = parent.isEnabled(UiFlagMode.ANY);
    }
    if (isEnabled() || !enabled) {
      widget.setEnabled(enabled, UiFlagMode.PARENT);
    }
    boolean visible = true;
    if (newPropagation.isVisible()) {
      visible = parent.isVisible(UiFlagMode.ANY);
    }
    if (isVisible() || !visible) {
      widget.setVisible(visible, UiFlagMode.PARENT);
    }
  }

}
