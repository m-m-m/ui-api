/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isAttached() read} the {@link #isAttached() attached state}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadAttached {

  /**
   * @return {@code true} if attached, {@code false} if detached. A {@link io.github.mmm.ui.api.widget.UiWidget} is
   *         attached if it is actively linked to the UI. In other words it is attached if all its ancestors
   *         ({@link io.github.mmm.ui.api.widget.UiWidget#getParent() parents}) are attached and its root is a window
   *         that is attached to the screen. Technically, in case of a web-app attached means connected to the document
   *         body or for JavaFx connected to the scene-graph. Please note that an attached
   *         {@link io.github.mmm.ui.api.widget.UiWidget} can still be {@link AttributeReadVisible#isVisible() visible
   *         or hidden}. Also be aware that there is no {@code setAttached} method as the attached state will change
   *         implicitly if the {@link io.github.mmm.ui.api.widget.UiWidget#getParent() parent} changes e.g. via
   *         {@link io.github.mmm.ui.api.widget.composite.UiMutableComposite#addChild(io.github.mmm.ui.api.widget.UiWidget)}.
   */
  boolean isAttached();

}
