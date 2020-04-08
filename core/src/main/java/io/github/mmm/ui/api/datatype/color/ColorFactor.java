/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.color;

/**
 * This class is a generic implementation of {@link AbstractColorFactor} used for color transformations such as
 * {@link GenericColor#lighten(ColorFactor)} or {@link GenericColor#darken(ColorFactor)}.
 *
 * @since 1.0.0
 */
public class ColorFactor extends AbstractColorFactor<ColorFactor> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public ColorFactor(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public ColorFactor(String value) {

    super(value);
  }

  @Override
  protected ColorFactor newInstance(double value) {

    return new ColorFactor(value);
  }

}
