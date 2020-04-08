/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.color;

/**
 * A {@link ColorSegment} is a part of a {@link Color}.
 *
 * @param <SELF> type of the class itself.
 * @since 1.0.0
 */
public abstract class ColorSegment<SELF extends ColorSegment<SELF>> {

  private final double value;

  /**
   * The constructor.
   *
   * @param value is the actual {@link #getValue() value}.
   */
  public ColorSegment(double value) {

    super();
    if ((value < getMin()) || (value > getMax())) {
      throw new IllegalArgumentException(value + "([" + getMin() + "-" + getMax() + "])");
    }
    this.value = value;
  }

  /**
   * @return the actual value of this {@link ColorSegment}.
   */
  public double getValue() {

    return this.value;
  }

  /**
   * Creates a new instance with the given value.
   *
   * @param newValue is the {@link #getValue() value}.
   * @return the new instance.
   */
  protected abstract SELF newInstance(double newValue);

  /**
   * @return a new segment of the same type with the <em>inverted</em> value. Inverted means the complement or
   *         technically <code>{@link #getMax()} - {@link #getValue()}</code>.
   */
  public SELF invert() {

    return newInstance(getMax() - this.value);
  }

  /**
   * @param factor is the {@link ColorFactor} to increase by. E.g. {@code 0.0} will cause no change, {@code 1.0} will
   *        lead to {@link #getMax() maximum value}.
   * @return a new segment with the value increased by the given factor through linear interpolation.
   */
  public SELF increase(ColorFactor factor) {

    return newInstance(this.value + (getMax() - this.value) * factor.getValueAsFactor());
  }

  /**
   * @param factor is the {@link ColorFactor} to decrease by. E.g. {@code 0.0} will cause no change, {@code 1.0} will
   *        lead to {@code 0}.
   * @return a new segment with the value decreased by the given factor through linear interpolation.
   */
  public SELF decrease(ColorFactor factor) {

    return newInstance(this.value - (this.value * factor.getValueAsFactor()));
  }

  @Override
  public boolean equals(Object obj) {

    if ((obj == null) || (obj.getClass() != getClass())) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    ColorSegment<?> other = (ColorSegment<?>) obj;
    return this.value == other.value;
  }

  @Override
  public int hashCode() {

    return (int) this.value;
  }

  /**
   * @return the minimum allowed for {@link #getValue() value}.
   */
  public double getMin() {

    return 0;
  }

  /**
   * @return the maximum allowed for {@link #getValue() value}.
   */
  public abstract double getMax();

  /**
   * @return the value in the range from {@code 0} to {@code 1} ({@code [0, 1]}).
   */
  public double getValueAsFactor() {

    return getValue() / getMax();
  }

  /**
   * @return the {@link #getValueAsFactor() value} as {@link String} (e.g. "0.512").
   */
  public String toFactorString() {

    return formatDouble(getValueAsFactor());
  }

  /**
   * @return the {@link #getValueAsFactor() value} as {@link String} formatted in percent (e.g. "51.2%").
   * @see #getValueAsPercent()
   */
  public String toPercentString() {

    return formatDouble(getValueAsFactor() * 100) + "%";
  }

  /**
   * @return the value in percent in the range from {@code 0} to {@code 100}. Will be rounded to an {@code int}. If you
   *         want to keep (potential) precision, use {@link #getValueAsFactor()} and multiply with {@code 100}.
   */
  public int getValueAsPercent() {

    return (int) Math.round(getValueAsFactor() * 100);
  }

  /**
   * @param d is the {@link Double} value.
   * @return the string representation formatted in a human friendly way (no scientific notation, limited number of
   *         decimal digits, etc.) with potential precision loss.
   */
  private static String formatDouble(double d) {

    return toString(d);
  }

  /**
   * {@inheritDoc}
   *
   * @return the default {@link String} representation. Depending on the type this might be the same as
   *         {@link #toFactorString()} but it might also be an absolute integer (e.g. in the range {@code [0, 255]}
   *         for RGBA segments).
   */
  @Override
  public String toString() {

    return toString(this.value);
  }

  private static String toString(double d) {

    // TODO prevent scientific notation, limit digits, etc. without using DecimalFormat or the like...
    return Double.toString(d);
  }

}
