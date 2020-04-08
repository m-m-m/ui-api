/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.color;

/**
 * This {@link ColorSegment} represents the main characteristic of a a color by the degree of the angle around that axis
 * in the color cube starting with red at 0°.
 *
 * @see GenericColor#getHue()
 *
 * @since 1.0.0
 */
public class Hue extends ColorSegment<Hue> {

  /** The factor for percent values (360 / 100). */
  private static final double PERCENT_FACTOR = 3.6;

  /**
   * If {@link Chroma} is {@code 0} then {@link Hue} is actually undefined. This value represent this undefined value.
   * For convenience a {@link #getValue() value} of 0° is used as representation.
   */
  public static final Hue UNDEFINED = new Hue(0);

  /** The maximum value allowed. */
  public static final double MAX_VALUE = 360;

  /**
   * The constructor.
   *
   * @param value is the #getValue()
   */
  public Hue(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link String} in {@link #toString() default} or
   *        {@link #toPercentString() percent} representation.
   */
  public Hue(String value) {

    super(parseValue(value));
  }

  /**
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   * @return the parsed value.
   */
  private static double parseValue(String value) {

    int length = value.length();
    if (value.charAt(length - 1) == '%') {
      double percent = Double.parseDouble(value.substring(0, length - 1));
      return (percent * PERCENT_FACTOR);
    } else {
      return Double.parseDouble(value);
    }
  }

  @Override
  public double getMax() {

    return MAX_VALUE;
  }

  @Override
  protected Hue newInstance(double value) {

    return new Hue(value);
  }

}
