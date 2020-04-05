/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.menu;

import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiAbstractMenuItem} for a normal menu item that acts like a button. It can be {@link #click() clicked} and
 * invokes an {@link #addListener(io.github.mmm.ui.event.UiEventListener) action}.
 *
 * @since 1.0.0
 */
public interface UiMenuItem extends UiAbstractActiveMenuItem, UiNativeWidget {

  // nothing to add

}
