/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

/**
 * This {@link ColorSegment} represents the brightness of a {@link Color}. The brightness is a {@link AbstractColorFactor factor}
 * indicating the amount of light emitted by a {@link Color}.
 *
 * @see GenericColor#getBrightness()
 *
 * @since 1.0.0
 */
public class Brightness extends AbstractColorFactor<Brightness> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Brightness(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Brightness(String value) {

    super(value);
  }

  @Override
  protected Brightness newInstance(double value) {

    return new Brightness(value);
  }

  @Override
  public String toString() {

    return toPercentString();
  }

}
