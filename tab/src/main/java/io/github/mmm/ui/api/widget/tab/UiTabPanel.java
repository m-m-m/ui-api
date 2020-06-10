/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.tab;

import java.util.function.Supplier;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiSwitchComposite;

/**
 * {@link UiSwitchComposite} representing a <em>tab panel</em>. It contains a number of {@link #getChild(int) children}
 * but only shows one of them at a time. It shows a tab bar (typically at the top as a header) with the
 * {@link UiTab#getText() labels} of its {@link #getChild(int) children}. The user can click on one of these tabs in
 * order to see the actual {@link UiTab#getChild() content} of the according tab. <br>
 * This design might look a little complicated but gives a lot more flexibility for setting and changing attributes of
 * the {@link UiTab tab}. For convenience usage there is also {@link #addTab(String, UiRegularWidget)}.<br>
 * <b>IMPORTANT:</b> In case you {@link UiTab#setClosable(boolean) make} the {@link UiTab} {@link UiTab#isClosable()
 * closable}, it will remove itself as {@link #getChild(int) child} from this {@link UiTabPanel} when the end-user
 * closes it.
 *
 * @since 1.0.0
 */
public interface UiTabPanel extends UiSwitchComposite<UiTab>, UiRegularWidget, UiNativeWidget {

  /**
   * Adds the given {@link UiRegularWidget} as new tab (and the end of all existing tabs).<br>
   * <b>IMPORTANT:</b> In case you {@link UiTab#setClosable(boolean) make} the {@link UiTab} {@link UiTab#isClosable()
   * closable}, it will remove itself as {@link #getChild(int) child} from this {@link UiTabPanel} when the end-user
   * closes it.
   *
   * @param text the label that will be displayed to identify the tab.
   * @param child the {@link UiTab#getChild() tab content}.
   * @return the {@link UiTab} for this tab.
   */
  default UiTab addTab(String text, UiRegularWidget child) {

    return addTab(text, child, -1);
  }

  /**
   * Adds a new tab (and the end of all existing tabs) with the content provided lazily from the given {@link Supplier}
   * (when the tab is selected for the first time).<br>
   *
   * @param text the label that will be displayed to identify the tab.
   * @param childSupplier the {@link Supplier} {@link Supplier#get() providing} the {@link UiTab#getChild() tab
   *        content}. Allows lazy creation of the child when the tab is selected for the first time.
   * @return the {@link UiTab} for this tab.
   */
  default UiTab addTab(String text, Supplier<UiRegularWidget> childSupplier) {

    return addTab(text, childSupplier, -1);
  }

  /**
   * Adds the given {@link UiRegularWidget} as new tab at the given {@code index}.
   *
   * @param text the label that will be displayed to identify the tab.
   * @param child the {@link UiTab#getChild() tab content}.
   * @param index is the {@link #getChild(int) index} where to insert the new {@link UiTab}.
   * @return the {@link UiTab} for this tab.
   */
  UiTab addTab(String text, UiRegularWidget child, int index);

  /**
   * Adds a new tab at the given {@code index} with the content provided lazily from the given {@link Supplier} (when
   * the tab is selected for the first time).
   *
   * @param text the label that will be displayed to identify the tab.
   * @param childSupplier the {@link Supplier} {@link Supplier#get() providing} the {@link UiTab#getChild() tab
   *        content}. Allows lazy creation of the child when the tab is selected for the first time.
   * @param index is the {@link #getChild(int) index} where to insert the new {@link UiTab}.
   * @return the {@link UiTab} for this tab. It allows to change the title, set tooltip or image (icon), etc.
   */
  UiTab addTab(String text, Supplier<UiRegularWidget> childSupplier, int index);

  /**
   * @return the new {@link UiTabPanel}.
   */
  static UiTabPanel of() {

    return UiWidgetFactoryNative.get().create(UiTabPanel.class);
  }

  /**
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiTabPanel}.
   */
  static UiTabPanel of(UiTab... children) {

    UiTabPanel widget = of();
    for (UiTab child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
