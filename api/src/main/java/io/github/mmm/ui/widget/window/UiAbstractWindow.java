/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.window;

import io.github.mmm.ui.datatype.UiLength;
import io.github.mmm.ui.datatype.UiLengthUnit;
import io.github.mmm.ui.widget.UiClosableWidget;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;

/**
 * {@link UiDynamicComposite} that represents a <em>window</em>. To open the window use {@link #setVisible(boolean)
 * setVisible(true)} and to close it use {@link #setVisible(boolean) setVisible(false)}. Some underlying UI toolkits do
 * not support to dynamically change the features of the window so configure them via {@link #setClosable(boolean)},
 * {@link #setResizable(boolean)}, etc. before opening the window.
 *
 * @since 1.0.0
 */
public abstract interface UiAbstractWindow extends UiDynamicComposite<UiRegularWidget>, UiClosableWidget {

  /**
   * This method gets the title of this object. The detailed meaning of the title depends on the type of object. E.g. a
   * window will have the title in the top-level bar.
   *
   * @return the title.
   */
  String getTitle();

  /**
   * This method sets the title of this object.
   *
   * @see #getTitle()
   *
   * @param title is the new title.
   */
  void setTitle(String title);

  /**
   * This method gets the pixel position of the left border object on the x-axis (horizontal).
   *
   * @see #getPositionY()
   *
   * @return the x position.
   */
  double getPositionX();

  /**
   * This method gets the pixel position of the top border of this object on the y-axis (vertical).
   *
   * @see #getPositionX()
   *
   * @return the y position.
   */
  double getPositionY();

  /**
   * This method sets the position of the object.
   *
   * @param x is the {@link #getPositionX() position on the x-axsis} (horizontal).
   * @param y is the {@link #getPositionY() position on the y-axsis} (vertical).
   */
  void setPosition(double x, double y);

  /**
   * This method gets the width of this object.
   *
   * @return the width. Will be {@link UiLength#ZERO} if undefined (NOT set).
   */
  UiLength getWidth();

  /**
   * @param width the new {@link #getWidth() width}.
   */
  void setWidth(UiLength width);

  /**
   * This method gets the height of this object.
   *
   * @return the height. Will be {@link UiLength#ZERO} if undefined (NOT set).
   */
  UiLength getHeight();

  /**
   * @param height the new {@link #getHeight() height}.
   */
  void setHeight(UiLength height);

  /**
   * @param width is the new {@link #getWidth() width} of the object.
   * @param height is the new {@link #getHeight() height} of the object.
   */
  default void setSize(UiLength width, UiLength height) {

    setWidth(width);
    setHeight(height);
  }

  /**
   * @param width is the new {@link #getWidth() width} of the object.
   * @param height is the new {@link #getHeight() height} of the object.
   * @param unit is the {@link UiLengthUnit unit} of {@code width} and {@code height}.
   */
  default void setSize(double width, double height, UiLengthUnit unit) {

    setSize(unit.newLength(width), unit.newLength(height));
  }

  /**
   * @return {@code true} if this window can be {@link #setSize(UiLength, UiLength) resized} by the end-user,
   *         {@code false} otherwise.
   */
  boolean isResizable();

  /**
   * @param resizable is the new value of {@link #isResizable()}.
   */
  void setResizable(boolean resizable);

  /**
   * @return {@code true} if this window can be moved by the end-user (by dragging around), {@code false} otherwise.
   */
  boolean isMovable();

  /**
   * @param movable is the new value of {@link #isMovable()}.
   */
  void setMovable(boolean movable);

  /**
   * @return {@code true} if this window is closable (the end-user can close this window via an icon-button or by
   *         hitting escape), {@code false} otherwise.
   */
  @Override
  boolean isClosable();

  /**
   * @param closable is the new value of {@link #isClosable()}.
   */
  @Override
  void setClosable(boolean closable);

  /**
   * @return {@code true} if this window is currently maximized (fully expanded to cover the entire screen),
   *         {@code false} otherwise.
   */
  boolean isMaximized();

  /**
   * @param maximized {@code true} to maximize, {@code false} to un-maximize (size and position will be restored to the
   *        values before it was maximized).
   * @see #isMaximized()
   */
  void setMaximized(boolean maximized);

}
