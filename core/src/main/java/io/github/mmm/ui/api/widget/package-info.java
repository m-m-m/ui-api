/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
/**
 * Contains the API for widgets what are the first-class citizens of a UI. As we are providing an API widgets are
 * provided as interfaces derived from {@link io.github.mmm.ui.api.widget.UiWidget}. To offer type-safety for fabrication of
 * widgets all widgets that should be provided by an implementation of this entire API are derived from
 * {@link io.github.mmm.ui.api.widget.UiNativeWidget} and are called native widgets. This prevents "instantiation" of
 * abstract widget interfaces via {@link io.github.mmm.ui.api.UiContext#create(Class) fabrication}. Further there is the
 * interface {@link io.github.mmm.ui.api.widget.UiRegularWidget} that all regular widgets are derived from. Unlike special
 * widgets such as e.g. {@link io.github.mmm.ui.api.widget.window.UiWindow windows} or
 * {@link io.github.mmm.ui.api.widget.menu.UiMenuItem menu items} a regular widget can be placed anywhere on the UI and
 * therefore be added to {@link io.github.mmm.ui.api.widget.panel.UiMutablePanel panels} and other generic containers. Also
 * widgets are either {@link io.github.mmm.ui.api.widget.UiAtomicWidget atomic} or
 * {@link io.github.mmm.ui.api.widget.composite.UiComposite composite}.
 *
 * Finally we provide custom widgets via {@link io.github.mmm.ui.api.widget.custom.UiCustomWidget} that support you to make
 * your UI modular and maintainable by building reusable UI components.
 */
package io.github.mmm.ui.api.widget;
