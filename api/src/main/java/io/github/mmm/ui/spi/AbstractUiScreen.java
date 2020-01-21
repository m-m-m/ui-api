/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import io.github.mmm.ui.UiScreen;
import io.github.mmm.ui.datatype.UiDisplayType;

/**
 * Abstract base implementation of {@link UiScreen}.
 * 
 * @since 1.0.0
 */
public abstract class AbstractUiScreen implements UiScreen {

  /** @see #getWidthInPixel() */
  protected double width;

  /** @see #getHeightInPixel() */
  protected double height;

  /** @see #getDpi() */
  protected double dpi;

  /** @see #getSize() */
  protected double size;

  /** @see #getType() */
  protected UiDisplayType type;

  /**
   * The constructor.
   */
  public AbstractUiScreen() {

    super();
  }

  @Override
  public double getWidthInPixel() {

    if (this.width == 0) {
      update();
    }
    return this.width;
  }

  @Override
  public double getHeightInPixel() {

    if (this.height == 0) {
      update();
    }
    return this.height;
  }

  @Override
  public double getDpi() {

    if (this.dpi == 0) {
      update();
    }
    return this.dpi;
  }

  @Override
  public double getSize() {

    if (this.size == 0) {
      update();
    }
    return this.size;
  }

  @Override
  public UiDisplayType getType() {

    if (this.type == null) {
      update();
    }
    return this.type;
  }

  @Override
  public void update() {

    doUpdate();
    double w = this.width / this.dpi;
    double h = this.height / this.dpi;
    this.size = Math.sqrt((w * w) + (h * h));
    if (this.size < 8) {
      this.type = UiDisplayType.SMALL;
    } else if (this.size > 12) {
      this.type = UiDisplayType.LARGE;
    } else {
      this.type = UiDisplayType.MEDIUM;
    }
  }

  /**
   * Called from {@link #update()} to update the native values while {@link #update()} will by default also update
   * calculated values.
   */
  protected abstract void doUpdate();

  @Override
  public String toString() {

    return this.width + "x" + this.height;
  }
}
