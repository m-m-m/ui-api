/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiComposite;
import io.github.mmm.ui.api.widget.composite.UiRemovableComposite;
import io.github.mmm.ui.api.widget.composite.UiSlot;

/**
 * {@link UiRemovableComposite} representing a panel that lays out its children in predefined positions:
 * <ul>
 * <li>{@link #getCenter() center}</li>
 * <li>{@link #getTop() top}</li>
 * <li>{@link #getBottom() bottom}</li>
 * <li>{@link #getLeft() left}</li>
 * <li>{@link #getRight() right}</li>
 * </ul>
 * Here you can see an example of the layout (HTML structure will differ):<br>
 * <table border="1">
 * <thead>
 * <tr>
 * <th colspan="3">header</th>
 * </tr>
 * </thead> <tbdoy>
 * <tr>
 * <td>left</td>
 * <td>center</td>
 * <td>right</td>
 * </tr>
 * </tbody> <tfoot>
 * <tr>
 * <td colspan="3" style="text-align:center">footer</td>
 * </tr>
 * </tfoot>
 * </table>
 * The {@link #getCenter() center widget} will consume additional space if the owning window grows while the other
 * border widgets only get the required space. Use CSS to customize this behavior. Please note that implementations of
 * this panel may be responsive and will hide {@link #getLeft() left} and {@link #getRight() right} content in a
 * "drawer" if the {@link io.github.mmm.ui.api.UiScreen screen} resolution is not wide enough. Typically you should have
 * only a single instance of {@link UiBorderPanel} for your application.
 *
 * @since 1.0.0
 */
public interface UiBorderPanel extends UiComposite<UiSlot>, UiRegularWidget, UiNativeWidget {

  /** {@link #getChild(int) Child index} of {@link #getCenter() center widget}. */
  int INDEX_CENTER = 0;

  /** {@link #getChild(int) Child index} of {@link #getTop() top widget}. */
  int INDEX_TOP = 1;

  /** {@link #getChild(int) Child index} of {@link #getLeft() left widget}. */
  int INDEX_LEFT = 2;

  /** {@link #getChild(int) Child index} of {@link #getBottom() bottom widget}. */
  int INDEX_BOTTOM = 3;

  /** {@link #getChild(int) Child index} of {@link #getRight() right widget}. */
  int INDEX_RIGHT = 4;

  /**
   * @return the {@link UiSlot} for the header shown at the top.
   */
  UiSlot getTop();

  /**
   * @return the {@link UiSlot} for the footer shown at the bottom.
   */
  UiSlot getBottom();

  /**
   * @return the {@link UiSlot} shown at the left.
   */
  UiSlot getLeft();

  /**
   * @return the {@link UiSlot} shown at the right.
   */
  UiSlot getRight();

  /**
   * @return the {@link UiSlot} for the main content shown in the center of this panel.
   */
  UiSlot getCenter();

  @Override
  default UiSlot getChild(int index) {

    switch (index) {
      case INDEX_CENTER:
        return getCenter();
      case INDEX_TOP:
        return getTop();
      case INDEX_LEFT:
        return getLeft();
      case INDEX_BOTTOM:
        return getBottom();
      case INDEX_RIGHT:
        return getRight();
    }
    return null;
  }

  /**
   * @return the new {@link UiBorderPanel}.
   */
  static UiBorderPanel of() {

    return UiWidgetFactoryNative.get().create(UiBorderPanel.class);
  }

}
