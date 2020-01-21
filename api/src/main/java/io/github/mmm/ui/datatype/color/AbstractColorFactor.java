/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

/**
 * The implementation of {@link ColorSegment} for a factor in the range from {@code 0} to {@code 1} such as
 * {@link Saturation}, {@link Lightness}, or {@link Brightness}. <br>
 * <b>ATTENTION:</b><br>
 * Beside {@link #toPercentString() percent} notation the {@link String} constructor both accepts
 * {@link #getValueAsByte() byte values} as well as {@link #toFactorString() factor} notation.
 *
 * @param <SELF> is the generic type of the class itself (bound by the actual final subclass).
 * @since 1.0.0
 */
public abstract class AbstractColorFactor<SELF extends AbstractColorFactor<SELF>> extends ColorSegment<SELF> {

  /** @see #getMax() */
  public static final double MAX_VALUE = 1;

  /** @see #AbstractColorFactor(int) */
  protected static final double BYTE_MAX = 255;

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public AbstractColorFactor(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param byteValue is the {@link #getValueAsByte() value given as byte}.
   */
  public AbstractColorFactor(int byteValue) {

    super(byteValue / BYTE_MAX);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public AbstractColorFactor(String value) {

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
      return (percent / 100.0);
    } else if (value.contains(".")) {
      return Double.parseDouble(value);
    } else {
      return (Integer.parseInt(value) / BYTE_MAX);
    }
  }

  @Override
  public double getValueAsFactor() {

    return getValue();
  }

  @Override
  public double getMax() {

    return MAX_VALUE;
  }

  /**
   * @return the {@link #getValue()} as {@code int} in the range from {@code 0} to {@code 255}.
   */
  public int getValueAsByte() {

    return (int) (getValueAsFactor() * BYTE_MAX);
  }

  /**
   * @return the {@link #getValueAsByte() byte value} as {@link String}. E.g. "255".
   */
  public String toByteString() {

    return Integer.toString(getValueAsByte());
  }

  @Override
  public String toString() {

    return toFactorString();
  }

}
