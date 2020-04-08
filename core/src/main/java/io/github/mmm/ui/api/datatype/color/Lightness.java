/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.color;

/**
 * This {@link ColorSegment} represents the lightness of a {@link Color}. Just like {@link Brightness} it is a {@link AbstractColorFactor
 * factor} indicating the amount of light emitted by a {@link Color}, but relative to the {@link Brightness} of a
 * similarly illuminated white.
 *
 * @see GenericColor#getLightness()
 *
 * @since 1.0.0
 */
public class Lightness extends AbstractColorFactor<Lightness> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Lightness(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Lightness(String value) {

    super(value);
  }

  @Override
  protected Lightness newInstance(double value) {

    return new Lightness(value);
  }

  @Override
  public String toString() {

    return toPercentString();
  }

}
