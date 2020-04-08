/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget;

/**
 * This is the marker interface for native {@link UiWidget}s that can be
 * {@link io.github.mmm.ui.api.UiContext#create(Class) created from their interface} via
 * {@link io.github.mmm.ui.api.UiContext}. <br>
 * {@link UiWidget}s are defined as interfaces to abstract from the underlying implementation and native UI toolkit. In
 * the source code those that can not be created directly are declared as [@code abstract}. As the {@code abstract}
 * modifier has no further implication in Java this {@link UiNativeWidget} marker interface helps to specify which
 * widget interfaces can be created directly (to avoid confusion). All these interfaces except for
 * {@link UiNativeWidget} itself can be created and should be supported as legal arguments to
 * {@link io.github.mmm.ui.api.UiContext#create(Class)}.
 *
 * @see io.github.mmm.ui.api.UiContext
 * @see io.github.mmm.ui.api.UiContext#create(Class)
 *
 * @since 1.0.0
 */
public abstract interface UiNativeWidget extends UiWidget {

  // nothing to add

}
