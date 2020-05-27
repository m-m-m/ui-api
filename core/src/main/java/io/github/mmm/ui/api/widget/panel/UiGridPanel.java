/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiRemovableComposite;

/**
 * {@link UiRemovableComposite} that allows to layout child {@link UiRegularWidget widgets} in a grid. To simplify API
 * usage the grid is organized in {@link UiGridRow}s what allows you to {@link #removeChild(int) remove} entire rows or
 * to {@link #addRow(int, UiRegularWidget...) insert} new rows. For advanced usage {@link UiGridRow} even allows to
 * {@link UiGridRow#addChild(UiRegularWidget, int, int, int) add its children with column and row-span}.
 *
 * @since 1.0.0
 */
public interface UiGridPanel extends UiRemovableComposite<UiGridRow>, UiRegularWidget, UiNativeWidget {

  /**
   * @param children the optional {@link UiGridRow#getChild(int) children} to add horizontally in the new
   *        {@link UiGridRow row}.
   * @return the new {@link UiGridRow} that has been added.
   */
  default UiGridRow addRow(UiRegularWidget... children) {

    return addRow(-1, children);
  }

  /**
   * @param rowIndex the {@link #getChild(int) row index} where to insert the new {@link UiGridRow row}.
   * @param children the optional {@link UiGridRow#getChild(int) children} to add horizontally in the new
   *        {@link UiGridRow row}.
   * @return the new {@link UiGridRow} that has been added.
   */
  UiGridRow addRow(int rowIndex, UiRegularWidget... children);

  /**
   * @return the new {@link UiGridPanel}.
   */
  static UiGridPanel of() {

    return UiWidgetFactoryNative.get().create(UiGridPanel.class);
  }

}
