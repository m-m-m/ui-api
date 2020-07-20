/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.navigation;

/**
 * {@link UiAbstractMenu} that acts as the toplevel container for a menu or navigation bar. Further, it is the factory
 * for its children ({@link UiMenu menus} and {@link UiAbstractMenuItem menu items}).
 *
 * @param <E> type of the {@link #getChild(int) child menu entries}.
 * @since 1.0.0
 */
public interface UiAbstractMenuBar<E extends UiAbstractMenuEntry> extends UiAbstractMenu<E> {

}
