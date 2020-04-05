/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

/**
 * This {@link ColorSegment} represents the alpha value of a color what is its opacity. A value of {@code 0} stands for
 * fully transparent (color not visible), while {@code 1.0} stands for a regular color (color fully visible). An alpha
 * value of {@code 0.5} will be 50% transparent so you can see the color but the background shines through.
 *
 * @see Color#getAlpha()
 * @see GenericColor#getAlpha()
 *
 * @since 1.0.0
 */
public class Alpha extends AbstractColorFactor<Alpha> {

  /** The maximum {@link Alpha} value for full opaque (no transparency). */
  public static final Alpha OPAQUE = new Alpha(1.0);

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Alpha(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Alpha(String value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param byteValue is the {@link #getValueAsByte() value given as byte}.
   */
  public Alpha(int byteValue) {

    super(byteValue);
  }

  @Override
  protected Alpha newInstance(double value) {

    return new Alpha(value);
  }

}
